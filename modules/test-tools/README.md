# Test tools

Your Iroha test have to inherit from `IrohaTest` class.
You must provide one of Iroha client classes:
- `Iroha2Client`
- `AdminIroha2Client`
- `Iroha2AsyncClient`
- `AdminIroha2AsyncClient`
- `*AsyncClient` (for usage from Java)

You can override `txTimeout` parameter as well.

The `test-tools` module also provides useful annotation `@WithIroha` to isolate tests.
It uses JUnit 5 API to run Iroha2 peer in a Docker container with a predefined state before test execution, and it utilises resources after.

## Usage

```kotlin
class Test : IrohaTest<AdminIroha2Client>() {

    lateinit var client: AdminIroha2Client

    @Test // this annotation is needed for proper test suite detection by IDE
    @WithIroha([DefaultGenesis::class])
    fun `awesome test`(): Unit = runBlocking {
        val health = client.health()
        assert(health == 200)
    }

    @Test
    @WithIroha([SomeGenesis::class, OtherGenesis::class])
    fun `miltiple genesis sources test`(): Unit = runBlocking {
        // In this case genesis will be composed of the
        // unique instructions of SomeGenesis and OtherGenesis
    }

    @Test
    @WithIroha(source = "src/test/resources/genesis.json")
    fun `genesis path test`(): Unit = runBlocking {
    }

    @Test
    @WithIroha
    fun `empty genesis test`(): Unit = runBlocking {
    }

    @Test
    @WithIroha(amount = 4)
    fun `empty genesis with 4 peers test`(): Unit = runBlocking {
    }

    @Test
    @WithIrohaManual(
        apiUrls = ["http://localhost:8080", "http://localhost:8081", "http://localhost:8082", "http://localhost:8083"],
        peerUrls = ["http://localhost:1337", "http://localhost:1338", "http://localhost:1339", "http://localhost:1340"],
        account = "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland",
        publicKey = "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0",
        privateKey = "9ac47abf59b356e0bd7dcbbbb4dec080e302156a48ca907e47cb6aea1d32719e",
    )
    fun `test on existed Iroha environment`(): Unit = runBlocking {
    }

    @Test
    @WithIrohaManual(
        account = "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland",
        publicKey = "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0",
        privateKey = "9ac47abf59b356e0bd7dcbbbb4dec080e302156a48ca907e47cb6aea1d32719e",
        dockerComposeFile = "../../docker-compose/docker-compose.yaml",
    )
    fun `test on existed Iroha environment with dockerComposeFile`(): Unit = runBlocking {
    }
}
```

# Test Containers for Iroha2

The `test-tools` module contains the Docker image for a single Iroha2 peer and Iroha2 network.

## Usage

In a single peer test, [IrohaRunnerExtension](./src/main/kotlin/jp/co/soramitsu/iroha2/testengine/IrohaRunnerExtension.kt) calls [IrohaContainer](./src/main/kotlin/jp/co/soramitsu/iroha2/testengine/IrohaContainer.kt) that starts Iroha2 Docker containers:

```java
@org.junit.jupiter.api.extension.ExtendWith(IrohaRunnerExtension::class)
class SinglePeerTest {

    @Test
    @WithIroha
    public someTest() {
        // ...
    }
}
```

You can modify Iroha2 configurations with [IrohaConfig](./src/main/kotlin/jp/co/soramitsu/iroha2/testengine/IrohaConfig.kt).

## Examples

- [genesis.json](./src/main/resources/genesis.json)
- [config.json](./src/main/resources/config.json)

## More Tests

You can find more tests [in the `client` module](../client/src/test/kotlin/jp/co/soramitsu/iroha2).
