package jp.co.soramitsu.iroha2

import com.google.gson.GsonBuilder
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.BlockParameters
import jp.co.soramitsu.iroha2.generated.CanUnregisterAccount
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Parameters
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.SmartContractParameters
import jp.co.soramitsu.iroha2.generated.SumeragiParameters
import jp.co.soramitsu.iroha2.generated.TransactionParameters
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.transaction.EventFilters
import jp.co.soramitsu.iroha2.transaction.Grant
import jp.co.soramitsu.iroha2.transaction.Mint
import jp.co.soramitsu.iroha2.transaction.Register
import jp.co.soramitsu.iroha2.transaction.SetKeyValue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.assertEquals

class SerializerTest {
    @Test
    fun `should serialize grant permission token genesis block`() {
        val account = "ed012004FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016${ACCOUNT_ID_DELIMITER}wonderland"
        val destination = "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03${ACCOUNT_ID_DELIMITER}wonderland"

        val genesis = Genesis(
            RawGenesisTransaction(
                ChainId("00000000-0000-0000-0000-000000000000"),
                Genesis.EXECUTOR_FILE_NAME,
                Parameters(
                    SumeragiParameters(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)),
                    BlockParameters(NonZeroOfu64(BigInteger.valueOf(4))),
                    TransactionParameters(NonZeroOfu64(BigInteger.valueOf(5)), NonZeroOfu64(BigInteger.valueOf(6))),
                    SmartContractParameters(NonZeroOfu64(BigInteger.valueOf(7)), NonZeroOfu64(BigInteger.valueOf(8))),
                    SmartContractParameters(NonZeroOfu64(BigInteger.valueOf(9)), NonZeroOfu64(BigInteger.valueOf(10))),
                    emptyMap(),
                ),
                listOf(
                    Grant.accountPermission(
                        CanUnregisterAccount(account.asAccountId()),
                        destination.asAccountId(),
                    ).asInstructionBox(),
                ),
                "",
                emptyList(),
                emptyList(),
            ),
        )
        val expectedJson = """
            {
              "chain": "00000000-0000-0000-0000-000000000000",
              "executor": "./executor.wasm",
              "parameters": {
                "sumeragi": {
                  "block_time_ms": 1,
                  "commit_time_ms": 2,
                  "max_clock_drift_ms": 3
                },
                "block": {
                  "max_transactions": 4
                },
                "transaction": {
                  "max_instructions": 5,
                  "smart_contract_size": 6
                },
                "executor": {
                  "fuel": 7,
                  "memory": 8
                },
                "smart_contract": {
                  "fuel": 9,
                  "memory": 10
                },
                "custom": {}
              },
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
              "wasm_dir": "",
              "wasm_triggers": [],
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
                Parameters(
                    SumeragiParameters(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)),
                    BlockParameters(NonZeroOfu64(BigInteger.valueOf(4))),
                    TransactionParameters(NonZeroOfu64(BigInteger.valueOf(5)), NonZeroOfu64(BigInteger.valueOf(6))),
                    SmartContractParameters(NonZeroOfu64(BigInteger.valueOf(7)), NonZeroOfu64(BigInteger.valueOf(8))),
                    SmartContractParameters(NonZeroOfu64(BigInteger.valueOf(9)), NonZeroOfu64(BigInteger.valueOf(10))),
                    emptyMap(),
                ),
                listOf(
                    Mint.asset(assetId, BigDecimal(100)).asInstructionBox(),
                    SetKeyValue.asset(assetId, "key".asName(), "value").asInstructionBox(),
                    Register.trigger(
                        triggerId,
                        listOf(Mint.asset(assetId, BigDecimal(1))),
                        Repeats.Indefinitely(),
                        aliceAccountId,
                        EventFilterBox.Time(
                            EventFilters.timeEventFilter(
                                BigInteger.valueOf(1715676978L),
                                BigInteger.valueOf(1L),
                            ),
                        ),
                        Metadata(mapOf(Pair("key".asName(), Json.writeValue("value")))),
                    ).asInstructionBox(),
                ),
                "",
                emptyList(),
                emptyList(),
            ),
        )
        val expectedJson = """
            {
              "chain": "00000000-0000-0000-0000-000000000000",
              "executor": "./executor.wasm",
              "parameters": {
                "sumeragi": {
                  "block_time_ms": 1,
                  "commit_time_ms": 2,
                  "max_clock_drift_ms": 3
                },
                "block": {
                  "max_transactions": 4
                },
                "transaction": {
                  "max_instructions": 5,
                  "smart_contract_size": 6
                },
                "executor": {
                  "fuel": 7,
                  "memory": 8
                },
                "smart_contract": {
                  "fuel": 9,
                  "memory": 10
                },
                "custom": {}
              },
              "instructions": [
                {
                  "Mint": {
                    "Asset": {
                      "object": "100",
                      "destination": "xor#wonderland#ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland"
                    }
                  }
                },
                {
                  "SetKeyValue": {
                    "Asset": {
                      "object": "xor#wonderland#ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland",
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
                          "Instructions": [
                            {
                              "Mint": {
                                "Asset": {
                                  "object": "1",
                                  "destination": "xor#wonderland#ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland"
                                }
                              }
                            }
                          ]
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
                        "metadata": {
                          "key": "value"
                        }
                      }
                    }
                  }
                }
              ],
              "wasm_dir": "",
              "wasm_triggers": [],
              "topology": []
            }
        """.trimIndent()
        val json = JSON_SERDE.writeValueAsString(genesis.transaction)
        assertEquals(expectedJson, json.asPrettyJson())
    }
}

fun String.asPrettyJson(): String {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonElement = com.google.gson.JsonParser.parseString(this)
    return gson.toJson(jsonElement)
}
