package jp.co.soramitsu.iroha.testcontainers;

import static jp.co.soramitsu.iroha.java.Utils.nonNull;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.time.Duration;
import jp.co.soramitsu.iroha.java.IrohaAPI;
import jp.co.soramitsu.iroha.testcontainers.detail.LoggerConfig;
import jp.co.soramitsu.iroha.testcontainers.detail.PostgresConfig;
import jp.co.soramitsu.iroha.testcontainers.detail.ToriiTlsConfig;
import jp.co.soramitsu.iroha.testcontainers.detail.Verbosity;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.*;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.lifecycle.Startable;
import org.testcontainers.utility.MountableFile;

/**
 * If you get {@link com.github.dockerjava.api.exception.DockerException}: Mounts denied, please
 * refer to https://github.com/testcontainers/testcontainers-java/issues/730
 */
@NoArgsConstructor
public class IrohaContainer extends FailureDetectingExternalResource implements AutoCloseable,
    Startable, Closeable {

  public static final String defaultPostgresAlias = "iroha.postgres";
  public static final String defaultIrohaAlias = "iroha";
  public static final String irohaWorkdir = "/opt/iroha_data";
  // default last release
  public static final String defaultIrohaDockerImage = "hyperledger/iroha:1.3.0";
  // release with URSA integration for ed25519 SHA-2 algorithm
  public static final String defaultIrohaDockerImageWithURSA = "hyperledger/iroha-ursa:1.3.0";
  // release with Burrow integration for Solidity smart-contracts
  public static final String defaultIrohaDockerImageWithBurrow = "hyperledger/iroha-burrow:1.3.0";
  public static final String defaultPostgresDockerImage = "postgres:11-alpine";

  // env vars
  private static final String POSTGRES_USER = "POSTGRES_USER";
  private static final String POSTGRES_HOST = "POSTGRES_HOST";
  private static final String KEY = "KEY";
  private static final String VERBOSITY = "VERBOSITY";

  private String verbosity = Verbosity.CONFIG_FILE;
  private String irohaAlias = defaultIrohaAlias;
  private String irohaDockerImage = defaultIrohaDockerImage;
  private String postgresAlias = defaultPostgresAlias;
  private String postgresDockerImage = defaultPostgresDockerImage;

  private Logger logger = LoggerFactory.getLogger(IrohaContainer.class);

  private Integer fixedIrohaPort;
  private Integer fixedIrohaTlsPort;

  // use default config
  @Getter
  private PeerConfig conf = new PeerConfig();

  @Getter
  private PostgreSQLContainer postgresDockerContainer;
  @Getter
  private FixedHostPortGenericContainer irohaDockerContainer;
  @Getter
  private Network network;

  /**
   * Finalizes current configuration.
   * <p>
   * Useful for debugging.
   */
  public IrohaContainer configure() {
    // refresh postgres alias in config
    PostgresConfig pg = conf.getIrohaConfig().getPg_opt();
    pg.setHost(postgresAlias);

    // save config to temp dir
    conf.save();

    // init docker network
    network = nonNull(network) ? network : Network.builder().build();

    // init postgresDockerContainer
    postgresDockerContainer = (PostgreSQLContainer) new PostgreSQLContainer(postgresDockerImage)
        .withUsername(pg.getUser())
        .withPassword(pg.getPassword())
        .withDatabaseName(pg.getUser())
        .withExposedPorts(pg.getPort())
        .withNetwork(network)
        .withNetworkAliases(postgresAlias);

    // init irohaDockerContainer container
    irohaDockerContainer = new FixedHostPortGenericContainer<>(irohaDockerImage)
        .withEnv(KEY, PeerConfig.peerKeypairName)
        .withEnv(POSTGRES_HOST, postgresAlias)
        .withEnv(POSTGRES_USER, postgresDockerContainer.getUsername())
        .withEnv("WAIT_TIMEOUT", "0") // don't wait for postgres
        .withEnv(VERBOSITY, verbosity)
        .withNetwork(network)
        .withExposedPorts(conf.getIrohaConfig().getTorii_port())
        .withCopyFileToContainer(MountableFile.forHostPath(conf.getDir().getAbsolutePath()),
            irohaWorkdir)
        .waitingFor(
            Wait.forLogMessage(".*iroha initialized.*\\s", 1)
                .withStartupTimeout(Duration.ofSeconds(60))
        )
        .withNetworkAliases(irohaAlias);

    ToriiTlsConfig toriiTlsConfig = conf.getIrohaConfig().getTorii_tls_params();

    if (nonNull(toriiTlsConfig)) {
      irohaDockerContainer.withExposedPorts(toriiTlsConfig.getPort());
      if (nonNull(fixedIrohaTlsPort)) {
        irohaDockerContainer
            .withFixedExposedPort(fixedIrohaTlsPort, toriiTlsConfig.getPort());
      }
    }

    // init fixed Iroha port
    if (nonNull(fixedIrohaPort)) {
      irohaDockerContainer
          .withFixedExposedPort(fixedIrohaPort, conf.getIrohaConfig().getTorii_port());
    }

    // init logger
    if (nonNull(logger)) {
      irohaDockerContainer.withLogConsumer(new Slf4jLogConsumer(logger));
    }

    return this;
  }


  /**
   * Setter for peer configuration.
   */
  public IrohaContainer withPeerConfig(@NonNull PeerConfig conf) {
    this.conf = conf;
    return this;
  }

  /**
   * Setter for irohad verbosity.
   */
  public IrohaContainer withVerbosity(Verbosity verbosity) {
    this.verbosity = verbosity.getLevel();
    return this;
  }

  public IrohaContainer withLoggerConfig(LoggerConfig loggerConfig) {
    this.verbosity = Verbosity.CONFIG_FILE;
    this.conf.getIrohaConfig().setLog(loggerConfig);
    return this;
  }

  /**
   * Technical method to set shared docker network for a network of peers.
   */
  public IrohaContainer withNetwork(@NonNull Network network) {
    this.network = network;
    return this;
  }

  /**
   * Use this method to setup different loggers for different peers. As example, in a network, every
   * peer may write to its own logfile.
   *
   * @param logger can be {@code null} to disable logging
   */
  public IrohaContainer withLogger(Logger logger) {
    this.logger = logger;
    return this;
  }

  /**
   * Technical method to set iroha container alias for docker network.
   */
  public IrohaContainer withIrohaAlias(@NonNull String name) {
    this.irohaAlias = name;
    return this;
  }

  /**
   * Technical method to set postgres container alias for docker network.
   */
  public IrohaContainer withPostgresAlias(@NonNull String alias) {
    this.postgresAlias = alias;
    return this;
  }

  public IrohaContainer withPostgresDockerImage(@NonNull String pgDockerImage) {
    this.postgresDockerImage = pgDockerImage;
    return this;
  }

  public IrohaContainer withIrohaDockerImage(@NonNull String irohaDockerImage) {
    this.irohaDockerImage = irohaDockerImage;
    return this;
  }

  public IrohaContainer withFixedPort(int fixedIrohaPort) {
    if (fixedIrohaPort < 0 || fixedIrohaPort > 65535) {
      throw new IllegalArgumentException("Invalid port " + fixedIrohaPort);
    }
    this.fixedIrohaPort = fixedIrohaPort;
    return this;
  }

  public IrohaContainer withFixedTlsPort(int fixedIrohaTlsPort) {
    if (fixedIrohaTlsPort < 0 || fixedIrohaTlsPort > 65535) {
      throw new IllegalArgumentException("Invalid port " + fixedIrohaTlsPort);
    }
    this.fixedIrohaTlsPort = fixedIrohaTlsPort;
    return this;
  }

  /**
   * Start peer. Method is synchronous -- it is safe to start peer and then access API.
   */
  @Override
  public void start() {
    configure();
    postgresDockerContainer.start();
    irohaDockerContainer.start();
  }

  /**
   * Stop peer.
   */
  @Override
  public void stop() {
    irohaDockerContainer.stop();
    postgresDockerContainer.stop();
    conf.deleteTempDir();
  }

  @Override
  public void close() {
    stop();
  }

  /**
   * Returns a URI for API of current peer.
   */
  @SneakyThrows
  public URI getToriiAddress() {
    String host = irohaDockerContainer.getContainerIpAddress();
    int port = irohaDockerContainer.getMappedPort(
        conf.getIrohaConfig().getTorii_port()
    );

    return new URI("grpc", null, host, port, null, null, null);
  }

  /**
   * Returns a URI for API of current peer over TLS.
   *
   * @return
   */
  @SneakyThrows
  public URI getToriiTlsAddress() {
    String host = irohaDockerContainer.getContainerIpAddress();
    ToriiTlsConfig toriiParams = conf.getIrohaConfig().getTorii_tls_params();
    if (toriiParams != null) {
      int port = irohaDockerContainer.getMappedPort(toriiParams.getPort());
      return new URI("grpc", null, host, port, null, null, null);
    }

    return null;
  }

  /**
   * Returns directory on host filesystem, where peer configuration is stored.
   */
  public File getHostConfigDir() {
    return conf.getDir();
  }

  /**
   * Returns async wrapper over iroha api.
   */
  public IrohaAPI getApi() {
    return new IrohaAPI(getToriiAddress());
  }

  /**
   * Returns secure (using TLS) async wrapper over iroha api.
   */
  public IrohaAPI getSecureApi() {
    return new IrohaAPI(getToriiTlsAddress(), conf.getDir() + "/server.crt");
  }

}
