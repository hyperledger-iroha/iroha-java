package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.transaction.EventFilters
import jp.co.soramitsu.iroha2.transaction.Instructions
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class SerializerTest {
    @Test
    fun `should serialize grant permission token genesis block`() {
        val genesis = Genesis(
            RawGenesisTransaction(
                ChainId("00000000-0000-0000-0000-000000000000"),
                Genesis.EXECUTOR_FILE_NAME,
                emptyList(),
                Instructions.grantPermissionToken(
                    Permissions.CanUnregisterAccount,
                    "ed012004FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016${ACCOUNT_ID_DELIMITER}wonderland".asAccountId()
                        .asJsonString(withPrefix = true),
                    "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03${ACCOUNT_ID_DELIMITER}wonderland".asAccountId(),
                ).let { listOf(it) },
                emptyList(),
            ),
        )
        val expectedJson = """
            {
              "chain": "00000000-0000-0000-0000-000000000000",
              "executor": "executor.wasm",
              "parameters": [],
              "instructions": [
                {
                  "Grant": {
                    "Permission": {
                      "object": {
                        "name": "CanUnregisterAccount",
                        "payload": {
                          "account": "ed012004FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016@wonderland"
                        }
                      },
                      "destination": "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland"
                    }
                  }
                }
              ],
              "topology": []
            }
        """.trimIndent()

        val json = JSON_SERDE.writeValueAsString(genesis.transaction).trimIndent()
        assertEquals(expectedJson.lowercase(), json.asPrettyJson().lowercase())
    }

    @Test
    fun `should serialize mint asset genesis block`() {
        val triggerId = TriggerId(name = Name("time_trigger"))
        val aliceAccountId =
            "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03${ACCOUNT_ID_DELIMITER}wonderland".asAccountId()
        val assetId = AssetId(
            aliceAccountId,
            AssetDefinitionId("wonderland".asDomainId(), "xor".asName()),
        )
        val genesis = Genesis(
            RawGenesisTransaction(
                ChainId("00000000-0000-0000-0000-000000000000"),
                Genesis.EXECUTOR_FILE_NAME,
                emptyList(),
                listOf(
                    Instructions.mintAsset(assetId, 100),
                    Instructions.setKeyValue(assetId, "key".asName(), "value"),
                    Instructions.registerTrigger(
                        triggerId,
                        listOf(Instructions.mintAsset(assetId, 1)),
                        Repeats.Indefinitely(),
                        aliceAccountId,
                        Metadata(mapOf()),
                        EventFilters.timeEventFilter(
                            BigInteger.valueOf(1715676978L),
                            BigInteger.valueOf(1L),
                        ),
                    ),
                ),
                emptyList(),
            ),
        )
        val expectedJson = """
            {
              "chain": "00000000-0000-0000-0000-000000000000",
              "executor": "executor.wasm",
              "parameters": [],
              "instructions": [
                {
                  "Mint": {
                    "Asset": {
                      "object": "100",
                      "destination": "xor#wonderland#ed0120ce7fa46c9dce7ea4b125e2e36bdb63ea33073e7590ac92816ae1e861b7048b03@wonderland"
                    }
                  }
                },
                {
                  "SetKeyValue": {
                    "Asset": {
                      "object": "xor#wonderland#ed0120ce7fa46c9dce7ea4b125e2e36bdb63ea33073e7590ac92816ae1e861b7048b03@wonderland",
                      "key": "key",
                      "value": "value"
                    }
                  }
                },
                {
                  "Register": {
                    "Trigger": {
                      "id": "time_trigger",
                      "action": {
                        "executable": {
                          "Instructions": [{
                            "Mint": {
                              "Asset": {
                                "object": "1",
                                "destination": "xor#wonderland#ed0120ce7fa46c9dce7ea4b125e2e36bdb63ea33073e7590ac92816ae1e861b7048b03@wonderland"
                              }
                            }
                          }]
                        },
                        "repeats": "Indefinitely",
                        "authority": "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland",
                        "filter": {
                          "Time": {
                            "Schedule": {
                              "start_ms": 1715676978,
                              "period_ms": 1
                            }
                          }
                        },
                        "metadata": {}
                      }
                    }
                  }
                }
              ],
              "topology": []
            }
        """.trimIndent()
        val json = JSON_SERDE.writeValueAsString(genesis.transaction).trimIndent()
        assertEquals(expectedJson.asPrettyJson().lowercase(), json.asPrettyJson().lowercase())
    }
}
