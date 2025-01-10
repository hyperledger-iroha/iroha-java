package jp.co.soramitsu.iroha2;

import java.security.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static jp.co.soramitsu.iroha2.CryptoUtils.generateKeyPair;
import static jp.co.soramitsu.iroha2.ExtensionsKt.toIrohaPublicKey;
import jp.co.soramitsu.iroha2.client.Iroha2AsyncClient;
import jp.co.soramitsu.iroha2.client.blockstream.*;
import jp.co.soramitsu.iroha2.generated.*;
import jp.co.soramitsu.iroha2.generated.Metadata;
import jp.co.soramitsu.iroha2.query.QueryAndExtractor;
import jp.co.soramitsu.iroha2.query.QueryBuilder;
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis;
import jp.co.soramitsu.iroha2.testengine.IrohaTest;
import jp.co.soramitsu.iroha2.testengine.WithIroha;
import jp.co.soramitsu.iroha2.transaction.TransactionBuilder;
import kotlin.*;
import kotlin.Pair;
import kotlin.coroutines.*;
import kotlinx.coroutines.flow.*;
import org.jetbrains.annotations.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static jp.co.soramitsu.iroha2.testengine.TestConstsKt.ALICE_ACCOUNT_ID;
import static jp.co.soramitsu.iroha2.testengine.TestConstsKt.ALICE_KEYPAIR;
import static jp.co.soramitsu.iroha2.testengine.TestConstsKt.DEFAULT_ASSET_DEFINITION_ID;
import static jp.co.soramitsu.iroha2.testengine.TestConstsKt.DEFAULT_ASSET_ID;
import static jp.co.soramitsu.iroha2.testengine.TestConstsKt.DEFAULT_DOMAIN_ID;
import org.junit.jupiter.api.parallel.*;
import static org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class JavaTest extends IrohaTest<Iroha2AsyncClient> {

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    public void registerDomain() throws ExecutionException, InterruptedException, TimeoutException {
        final DomainId domainId = new DomainId(new Name("new_domain_name"));
        final SignedTransaction transaction = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .registerDomain(domainId)
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(transaction).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final QueryAndExtractor<Domain> query = QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        final CompletableFuture<Domain> future = client.sendQueryAsync(query);
        final Domain domain = future.get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);
        Assertions.assertEquals(domain.getId(), domainId);
    }

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    public void registerAccount() throws Exception {
        final KeyPair keyPair = generateKeyPair();
        final AccountId accountId = new AccountId(DEFAULT_DOMAIN_ID, toIrohaPublicKey(keyPair.getPublic()));
        final SignedTransaction transaction = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .registerAccount(accountId, new Metadata(Collections.emptyMap()))
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(transaction).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final QueryAndExtractor<Account> query = QueryBuilder.findAccountById(accountId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        final CompletableFuture<Account> future = client.sendQueryAsync(query);
        final Account account = future.get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);
        Assertions.assertEquals(account.getId(), accountId);
    }

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    public void mintAsset() throws Exception {
        final SignedTransaction registerAssetTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, new AssetType.Numeric(new NumericSpec()))
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(registerAssetTx).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final SignedTransaction mintAssetTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .mintAsset(DEFAULT_ASSET_ID, 5)
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(mintAssetTx).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final QueryAndExtractor<List<Asset>> query = QueryBuilder.findAssetsByAccountId(ALICE_ACCOUNT_ID)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        final CompletableFuture<List<Asset>> future = client.sendQueryAsync(query);
        final List<Asset> assets = future.get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);
        Assertions.assertEquals(5, ((AssetValue.Numeric) assets.stream().findFirst().get().getValue()).getNumeric().getMantissa().intValue());
    }

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    public void updateKeyValue() throws Exception {
        final Name assetMetadataKey = new Name("asset_metadata_key");
        final String assetMetadataValue = "some string value";
        final String assetMetadataValue2 = "some string value 2";
        final Metadata metadata = new Metadata(new HashMap<Name, String>() {{
            put(assetMetadataKey, assetMetadataValue);
        }});

        final SignedTransaction registerAssetTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, new AssetType.Store(), metadata, new Mintable.Infinitely())
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(registerAssetTx).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final AssetId assetId = new AssetId(ALICE_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID);
        final SignedTransaction keyValueTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .setKeyValue(assetId, assetMetadataKey, assetMetadataValue2)
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(keyValueTx).get(30, TimeUnit.SECONDS);

        final QueryAndExtractor<String> assetDefinitionValueQuery = QueryBuilder
            .findAssetKeyValueByIdAndKey(assetId, assetMetadataKey)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        final CompletableFuture<String> future = client.sendQueryAsync(assetDefinitionValueQuery);

        final String value = future.get(30, TimeUnit.SECONDS);
        Assertions.assertEquals(value, assetMetadataValue2);
    }

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    public void setKeyValue() throws Exception {
        final String assetValue = "some string value";
        final Name assetKey = new Name("asset_metadata_key");

        final SignedTransaction registerAssetTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .registerAssetDefinition(DEFAULT_ASSET_DEFINITION_ID, new AssetType.Store())
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(registerAssetTx).get(getTxTimeout().getSeconds(), TimeUnit.SECONDS);

        final SignedTransaction keyValueTx = TransactionBuilder.Companion.builder()
            .account(ALICE_ACCOUNT_ID)
            .setKeyValue(DEFAULT_ASSET_DEFINITION_ID, assetKey, assetValue)
            .buildSigned(ALICE_KEYPAIR);
        client.sendTransactionAsync(keyValueTx).get(10, TimeUnit.SECONDS);

        final QueryAndExtractor<String> assetDefinitionValueQuery = QueryBuilder
            .findAssetDefinitionKeyValueByIdAndKey(DEFAULT_ASSET_DEFINITION_ID, assetKey)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        final CompletableFuture<String> future = client.sendQueryAsync(assetDefinitionValueQuery);

        final String value = future.get(10, TimeUnit.SECONDS);
        Assertions.assertEquals(value, assetValue);
    }

    @Test
    @WithIroha(sources = DefaultGenesis.class)
    @ResourceLock("blockStream")
    public void blockStreaming() throws ExecutionException, InterruptedException {
        int count = 5;
        Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> idToSubscription =
            client.subscribeToBlockStream(1, count);
        UUID actionId = idToSubscription.component1().iterator().next().getId();
        BlockStreamSubscription subscription = idToSubscription.component2();

        List<BlockMessage> blocks = new ArrayList<>();
        subscription.receive(actionId, new BlockMessageCollector(blocks));

        for (int i = 0; i <= count + 1; i++) {
            final SignedTransaction transaction = TransactionBuilder.Companion.builder()
                .account(ALICE_ACCOUNT_ID)
                .setKeyValue(ALICE_ACCOUNT_ID, new Name(randomAlphabetic(10)), new String(randomAlphabetic(10)))
                .buildSigned(ALICE_KEYPAIR);
            client.sendTransactionAsync(transaction);
        }

        QueryAndExtractor<List<SignedBlock>> query = QueryBuilder.findAllBlocks()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR);
        Integer blocksSize = client.sendQueryAsync(query).get().size();

        Assertions.assertEquals(blocksSize, blocks.size());

        subscription.close();
    }

    static class BlockMessageCollector implements FlowCollector<BlockMessage> {

        List<BlockMessage> blocks;

        public BlockMessageCollector(List<BlockMessage> blocks) {
            this.blocks = blocks;
        }

        @Nullable
        @Override
        public Object emit(
            BlockMessage blockMessage,
            @NotNull Continuation<? super Unit> continuation
        ) {
            blocks.add(blockMessage);
            return null;
        }
    }
}
