package jp.co.soramitsu.iroha.java;

import static jp.co.soramitsu.iroha.java.Utils.createTxList;
import static jp.co.soramitsu.iroha.java.Utils.createTxStatusRequest;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.reactivex.Observable;
import io.reactivex.exceptions.Exceptions;
import iroha.protocol.CommandService_v1Grpc;
import iroha.protocol.CommandService_v1Grpc.CommandService_v1BlockingStub;
import iroha.protocol.CommandService_v1Grpc.CommandService_v1Stub;
import iroha.protocol.Endpoint.ToriiResponse;
import iroha.protocol.QryResponses.BlockQueryResponse;
import iroha.protocol.QryResponses.QueryResponse;
import iroha.protocol.Queries;
import iroha.protocol.QueryService_v1Grpc;
import iroha.protocol.QueryService_v1Grpc.QueryService_v1BlockingStub;
import iroha.protocol.QueryService_v1Grpc.QueryService_v1Stub;
import iroha.protocol.TransactionOuterClass;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import jp.co.soramitsu.iroha.java.detail.StreamObserverToEmitter;
import jp.co.soramitsu.iroha.java.subscription.SubscriptionStrategy;
import jp.co.soramitsu.iroha.java.subscription.WaitForTerminalStatus;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;

/**
 * Class which provides convenient RX abstraction over Iroha API.
 */
public class IrohaAPI implements Closeable {

  private static final SubscriptionStrategy defaultStrategy = new WaitForTerminalStatus();

  @Getter
  private URI uri;
  @Getter
  private ManagedChannel channel;
  @Getter
  private CommandService_v1BlockingStub cmdStub;
  @Getter
  private CommandService_v1Stub cmdStreamingStub;
  @Getter
  private QueryService_v1BlockingStub queryStub;
  @Getter
  private QueryService_v1Stub queryStreamingStub;

  public IrohaAPI(URI uri) {
    this(uri, null);
  }

  /**
   * Constructor with secure connection over TLS
   *
   * @param uri      - address to connect to Iroha
   * @param certFile - certification filename for SSL/TLS connection
   */
  public IrohaAPI(URI uri, String certFile) {
    this(uri.getHost(), uri.getPort(), certFile);
  }

  public IrohaAPI(String host, int port) {
    this(host, port, null);
  }

  /**
   * Constructor with secure connection over TLS
   *
   * @param host     - address to connect to Iroha
   * @param port     - port to connect to Iroha
   * @param certFile - certificate filename for SSL/TLS connection
   */
  @SneakyThrows
  public IrohaAPI(String host, int port, String certFile) {
    ManagedChannel channel = certFile == null ?
        ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .build()
        :
            NettyChannelBuilder
                .forAddress(host, port)
                .sslContext(
                    GrpcSslContexts.forClient().trustManager(new File(certFile)).build())
                .build();

    setChannel(channel);

    this.uri = new URI("grpc", null, host, port, null, null, null);
  }

  private void setChannel(ManagedChannel channel) {
    this.channel = channel;
    this.setChannelForBlockingCmdStub(channel);
    this.setChannelForBlockingQueryStub(channel);
    this.setChannelForStreamingCmdStub(channel);
    this.setChannelForStreamingQueryStub(channel);
  }

  public IrohaAPI setChannelForBlockingCmdStub(Channel channel) {
    cmdStub = CommandService_v1Grpc.newBlockingStub(channel)
        .withMaxInboundMessageSize(Integer.MAX_VALUE)
        .withMaxOutboundMessageSize(Integer.MAX_VALUE);
    return this;
  }

  public IrohaAPI setChannelForStreamingCmdStub(Channel channel) {
    cmdStreamingStub = CommandService_v1Grpc.newStub(channel)
        .withMaxInboundMessageSize(Integer.MAX_VALUE)
        .withMaxOutboundMessageSize(Integer.MAX_VALUE);
    return this;
  }

  public IrohaAPI setChannelForBlockingQueryStub(Channel channel) {
    queryStub = QueryService_v1Grpc.newBlockingStub(channel)
        .withMaxInboundMessageSize(Integer.MAX_VALUE)
        .withMaxOutboundMessageSize(Integer.MAX_VALUE);
    return this;
  }

  public IrohaAPI setChannelForStreamingQueryStub(Channel channel) {
    queryStreamingStub = QueryService_v1Grpc.newStub(channel)
        .withMaxInboundMessageSize(Integer.MAX_VALUE)
        .withMaxOutboundMessageSize(Integer.MAX_VALUE);
    return this;
  }


  /**
   * Send transaction synchronously, then subscribe for transaction status stream.
   * <p>
   * It uses {@link WaitForTerminalStatus} subscription strategy by default.
   *
   * @param tx protobuf transaction.
   * @return observable. Use {@code Observable.blockingSubscribe(...)} or {@code
   * Observable.subscribe} for synchronous or asynchronous subscription.
   */
  public Observable<ToriiResponse> transaction(TransactionOuterClass.Transaction tx) {
    return transaction(tx, defaultStrategy);
  }

  public Observable<ToriiResponse> transaction(TransactionOuterClass.Transaction tx,
      SubscriptionStrategy strategy) {
    transactionSync(tx);
    byte[] hash = Utils.hash(tx);
    return strategy.subscribe(this, hash);
  }

  /**
   * Send transaction synchronously.
   * <p>
   * Blocking call.
   *
   * @param tx protobuf transaction.
   */
  public void transactionSync(TransactionOuterClass.Transaction tx) {
    cmdStub.torii(tx);
  }

  /**
   * Send query synchronously.
   *
   * @param query protobuf query.
   */
  public QueryResponse query(Queries.Query query) {
    return queryStub.find(query);
  }

  /**
   * Subscribe for blocks in iroha. You need to have special permission to do that.
   *
   * @param query protobuf query.
   */
  public Observable<BlockQueryResponse> blocksQuery(Queries.BlocksQuery query) {
    return Observable.create(
        o -> queryStreamingStub.fetchCommits(query, new StreamObserverToEmitter<>(o))
    );
  }

  /**
   * Synchronously send list of transactions.
   * <p>
   * Blocking call.
   */
  public void transactionListSync(Iterable<TransactionOuterClass.Transaction> txList) {
    cmdStub.listTorii(createTxList(txList));
  }

  /**
   * Asynchronously ask for transaction status.
   *
   * @param txHash hash of transaction for status query.
   * @return {@link Observable}
   */
  public Observable<ToriiResponse> txStatus(byte[] txHash) {
    val req = createTxStatusRequest(txHash);
    return Observable.create(
        o -> cmdStreamingStub.statusStream(req, new StreamObserverToEmitter<>(o))
    );
  }

  /**
   * Synchronously ask to transaction status.
   *
   * @param txHash hash of transaction for status query
   * @return {@link ToriiResponse} status code, error message (if any).
   */
  public ToriiResponse txStatusSync(byte[] txHash) {
    return cmdStub.status(createTxStatusRequest(txHash));
  }

  /**
   * Close GRPC connection.
   */
  public void terminate() {
    if (!channel.isTerminated()) {
      channel.shutdownNow();
      boolean terminated = false;
      do {
        try {
          terminated = channel.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
          Exceptions.propagate(e);
        }
      } while (!terminated);
    }
  }

  @Override
  public void finalize() {
    terminate();
  }

  @Override
  public void close() {
    terminate();
  }
}
