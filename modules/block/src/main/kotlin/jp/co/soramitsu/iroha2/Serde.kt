package jp.co.soramitsu.iroha2

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.KeyDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.LongNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.ipfs.multihash.Multihash
import jp.co.soramitsu.iroha2.DigestFunction.Ed25519
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.Action
import jp.co.soramitsu.iroha2.generated.Algorithm
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetTransferBox
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.BlockHeader
import jp.co.soramitsu.iroha2.generated.BlockParameter
import jp.co.soramitsu.iroha2.generated.BurnBox
import jp.co.soramitsu.iroha2.generated.BurnOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.BurnOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.CustomInstruction
import jp.co.soramitsu.iroha2.generated.CustomParameter
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.Executable
import jp.co.soramitsu.iroha2.generated.ExecuteTrigger
import jp.co.soramitsu.iroha2.generated.ExecuteTriggerEventFilter
import jp.co.soramitsu.iroha2.generated.ExecutionTime
import jp.co.soramitsu.iroha2.generated.Executor
import jp.co.soramitsu.iroha2.generated.GrantBox
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndAccount
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndRole
import jp.co.soramitsu.iroha2.generated.GrantOfRoleIdAndAccount
import jp.co.soramitsu.iroha2.generated.Hash
import jp.co.soramitsu.iroha2.generated.IdBox
import jp.co.soramitsu.iroha2.generated.IdentifiableBox
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.IpfsPath
import jp.co.soramitsu.iroha2.generated.Ipv4Addr
import jp.co.soramitsu.iroha2.generated.Ipv6Addr
import jp.co.soramitsu.iroha2.generated.Log
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.MintBox
import jp.co.soramitsu.iroha2.generated.MintOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.MintOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.Mintable
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NewAccount
import jp.co.soramitsu.iroha2.generated.NewAssetDefinition
import jp.co.soramitsu.iroha2.generated.NewDomain
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Numeric
import jp.co.soramitsu.iroha2.generated.NumericSpec
import jp.co.soramitsu.iroha2.generated.Parameter
import jp.co.soramitsu.iroha2.generated.Peer
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.PublicKey
import jp.co.soramitsu.iroha2.generated.RawGenesisTransaction
import jp.co.soramitsu.iroha2.generated.RegisterBox
import jp.co.soramitsu.iroha2.generated.RegisterOfAccount
import jp.co.soramitsu.iroha2.generated.RegisterOfAsset
import jp.co.soramitsu.iroha2.generated.RegisterOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.RegisterOfDomain
import jp.co.soramitsu.iroha2.generated.RegisterOfPeer
import jp.co.soramitsu.iroha2.generated.RegisterOfRole
import jp.co.soramitsu.iroha2.generated.RegisterOfTrigger
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.RevokeBox
import jp.co.soramitsu.iroha2.generated.Role
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.Schedule
import jp.co.soramitsu.iroha2.generated.SetKeyValueBox
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAccount
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAsset
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfDomain
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfTrigger
import jp.co.soramitsu.iroha2.generated.SetParameter
import jp.co.soramitsu.iroha2.generated.SignedBlock
import jp.co.soramitsu.iroha2.generated.SmartContractParameter
import jp.co.soramitsu.iroha2.generated.SocketAddr
import jp.co.soramitsu.iroha2.generated.SumeragiParameter
import jp.co.soramitsu.iroha2.generated.TimeEventFilter
import jp.co.soramitsu.iroha2.generated.TransactionParameter
import jp.co.soramitsu.iroha2.generated.TransactionQueryOutput
import jp.co.soramitsu.iroha2.generated.TransferBox
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndAssetDefinitionIdAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndDomainIdAndAccount
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.generated.UnregisterBox
import jp.co.soramitsu.iroha2.generated.Upgrade
import jp.co.soramitsu.iroha2.generated.WasmSmartContract
import java.io.ByteArrayOutputStream
import java.math.BigInteger
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * This JSON mapper is configured to serialize and deserialize `Genesis block` in a format compatible with Iroha 2 peer
 */
public val JSON_SERDE by lazy {
    ObjectMapper().also { mapper ->
        val module = SimpleModule()

        // deserializers
        module.addDeserializer(AssetValue::class.java, AssetValueDeserializer)
        module.addDeserializer(PublicKey::class.java, PublicKeyDeserializer)
        module.addDeserializer(IdBox::class.java, IdBoxDeserializer)
        module.addDeserializer(Name::class.java, NameDeserializer)
        module.addDeserializer(Mintable::class.java, MintableDeserializer)
        module.addDeserializer(DomainId::class.java, DomainIdDeserializer)
        module.addDeserializer(AccountId::class.java, AccountIdDeserializer)
        module.addDeserializer(RoleId::class.java, RoleIdDeserializer)
        module.addDeserializer(AssetDefinitionId::class.java, AssetDefinitionIdDeserializer)
        module.addDeserializer(AssetId::class.java, AssetIdDeserializer)
        module.addDeserializer(RegisterBox::class.java, RegisterBoxDeserializer)
        module.addDeserializer(MintBox::class.java, MintBoxDeserializer)
        module.addDeserializer(Metadata::class.java, MetadataDeserializer)
        module.addDeserializer(TriggerId::class.java, TriggerIdDeserializer)
        module.addDeserializer(InstructionBox::class.java, InstructionDeserializer)
        module.addDeserializer(GrantBox::class.java, GrantBoxDeserializer)
        module.addDeserializer(EventFilterBox::class.java, EventFilterBoxDeserializer)
        module.addDeserializer(SetKeyValueBox::class.java, SetKeyValueBoxDeserializer)
        module.addDeserializer(TransferBox::class.java, TransferBoxDeserializer)
        module.addDeserializer(AssetType::class.java, AssetTypeDeserializer)
        module.addDeserializer(ChainId::class.java, ChainIdDeserializer)
        module.addDeserializer(NewDomain::class.java, NewDomainDeserializer)
        module.addDeserializer(NewAssetDefinition::class.java, NewAssetDefinitionDeserializer)
        module.addDeserializer(Trigger::class.java, TriggerDeserializer)
        module.addDeserializer(ExecuteTriggerEventFilter::class.java, ExecuteTriggerEventFilterDeserializer)
        module.addDeserializer(Action::class.java, ActionDeserializer)
        module.addDeserializer(Executable::class.java, ExecutableDeserializer)
        module.addDeserializer(IpfsPath::class.java, IpfsPathDeserializer)
        module.addDeserializer(Repeats::class.java, RepeatsDeserializer)
        module.addDeserializer(Parameter::class.java, ParameterDeserializer)
        module.addDeserializer(SumeragiParameter::class.java, SumeragiParameterDeserializer)
        module.addDeserializer(BlockParameter::class.java, BlockParameterDeserializer)
        module.addDeserializer(TransactionParameter::class.java, TransactionParameterDeserializer)
        module.addDeserializer(SmartContractParameter::class.java, SmartContractParameterDeserializer)
        module.addDeserializer(Schedule::class.java, ScheduleDeserializer)
        module.addDeserializer(ExecutionTime::class.java, ExecutionTimeDeserializer)
        module.addDeserializer(TimeEventFilter::class.java, TimeEventFilterDeserializer)
        module.addDeserializer(NumericSpec::class.java, NumericSpecDeserializer)
        module.addDeserializer(Numeric::class.java, NumericDeserializer)
        module.addDeserializer(Permission::class.java, PermissionDeserializer)
        module.addDeserializer(BurnBox::class.java, BurnBoxDeserializer)

        module.addKeyDeserializer(AssetDefinitionId::class.java, AssetDefinitionIdKeyDeserializer)
        module.addKeyDeserializer(AccountId::class.java, AccountIdKeyDeserializer)
        module.addKeyDeserializer(AssetId::class.java, AssetIdKeyDeserializer)
        module.addKeyDeserializer(DomainId::class.java, DomainIdKeyDeserializer)

        // serializers
        module.addKeySerializer(Name::class.java, NameAsKeySerializer)
        module.addSerializer(RawGenesisTransaction::class.java, RawGenesisTransactionSerializer)
        module.addSerializer(DomainId::class.java, DomainIdSerializer)
        module.addSerializer(AssetDefinitionId::class.java, AssetDefinitionIdSerializer)
        module.addSerializer(AccountId::class.java, AccountIdSerializer)
        module.addSerializer(AssetId::class.java, AssetIdSerializer)
        module.addSerializer(RoleId::class.java, RoleIdSerializer)
        module.addSerializer(SocketAddr::class.java, SocketAddrSerializer)
        module.addSerializer(TriggerId::class.java, TriggerIdSerializer)
        module.addSerializer(Name::class.java, NameSerializer)
        module.addSerializer(UInt::class.java, UIntSerializer)
        module.addSerializer(PublicKey::class.java, PublicKeySerializer)
        module.addSerializer(ModelEnum::class.java, EnumerationSerializer)
        module.addSerializer(Metadata::class.java, MetadataSerializer)
        module.addSerializer(IdentifiableBox.NewRole::class.java, IdentifiableBoxNewRoleSerializer)
        module.addSerializer(Parameter::class.java, ParameterSerializer)
        module.addSerializer(TimeEventFilter::class.java, TimeEventFilterSerializer)
        module.addSerializer(Schedule::class.java, ScheduleSerializer)
        module.addSerializer(Executor::class.java, ExecutorSerializer)
        module.addSerializer(InstructionBox::class.java, InstructionBoxSerializer)
        module.addSerializer(RegisterOfDomain::class.java, RegisterOfDomainSerializer)
        module.addSerializer(RegisterOfTrigger::class.java, RegisterOfTriggerSerializer)
        module.addSerializer(RegisterOfRole::class.java, RegisterOfRoleSerializer)
        module.addSerializer(RegisterOfAsset::class.java, RegisterOfAssetSerializer)
        module.addSerializer(RegisterOfAssetDefinition::class.java, RegisterOfAssetDefinitionSerializer)
        module.addSerializer(RegisterOfPeer::class.java, RegisterOfPeerSerializer)
        module.addSerializer(RegisterOfAccount::class.java, RegisterOfAccountSerializer)
        module.addSerializer(AssetTransferBox::class.java, AssetTransferBoxSerializer)
        module.addSerializer(NonZeroOfu64::class.java, NonZeroOfu64Serializer)
        module.addSerializer(Executable.Instructions::class.java, ExecutableInstructionsSerializer)
        module.addSerializer(ExecuteTriggerEventFilter::class.java, ExecuteTriggerEventFilterSerializer)
        module.addSerializer(AssetType::class.java, AssetTypeSerializer)
        module.addSerializer(Numeric::class.java, NumericSerializer)
        module.addSerializer(Permission::class.java, PermissionSerializer)

        mapper.registerModule(module)
        mapper.registerModule(
            KotlinModule.Builder()
                .configure(KotlinFeature.NullToEmptyCollection, true)
                .configure(KotlinFeature.NullToEmptyMap, true)
                .build(),
        )
        mapper.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
    }
}

/**
 * Deserializer for [Iroha Special Instructions][InstructionBox]
 */
object InstructionDeserializer : JsonDeserializer<InstructionBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): InstructionBox {
        return deserializeInstruction(p.readValueAsTree(), JSON_SERDE)
    }

    private fun deserializeInstruction(jsonNode: JsonNode, mapper: ObjectMapper): InstructionBox {
        val node = jsonNode.fields().next()
        val param = node.key

        val subtype = InstructionBox::class.nestedClasses.find { clazz ->
            !clazz.isCompanion && clazz.simpleName == param
        } ?: throw DeserializationException("Class with constructor($param) not found")

        val argTypeName = subtype.primaryConstructor?.parameters
            ?.firstOrNull()?.type?.toString()
            ?: throw DeserializationException("Subtype parameter not found by $param")

        val toConvert: JsonNode = node.value

        val arg = mapper.convertValue(toConvert, argTypeName.asClass())
        return subtype.primaryConstructor?.call(arg) as InstructionBox
    }
}

object GrantBoxDeserializer : JsonDeserializer<GrantBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): GrantBox {
        val node = p.readValueAsTree<JsonNode>()
        val paramClass = node.fields().next().key.toArg()

        return get(JSON_SERDE.convertValue(node.fields().next().value, paramClass))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Permission" -> GrantOfPermissionAndAccount::class.java
            "Role" -> GrantOfRoleIdAndAccount::class.java
            "RolePermission" -> GrantOfPermissionAndRole::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any): GrantBox {
        return when (arg) {
            is GrantOfPermissionAndAccount -> GrantBox.Permission(arg)
            is GrantOfRoleIdAndAccount -> GrantBox.Role(arg)
            is GrantOfPermissionAndRole -> GrantBox.RolePermission(arg)
            else -> throw DeserializationException("Grant box `$arg` not found")
        }
    }
}

object AssetValueDeserializer : JsonDeserializer<AssetValue>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AssetValue {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        return when (node.key) {
            "Store" -> AssetValue.Store(Metadata(mapOf()))
            else -> throw DeserializationException("AssetValue ${node.key} not found")
        }
    }
}

/**
 * Deserializer for [IdBox]
 */
object IdBoxDeserializer : JsonDeserializer<IdBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): IdBox {
        return sealedDeserializeIdBox(p, JSON_SERDE)
    }
}

object RegisterBoxDeserializer : JsonDeserializer<RegisterBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): RegisterBox {
        val node = p.readValueAsTree<JsonNode>().fields().next()

        val paramClass = node.key.toArg()
        val value = JSON_SERDE.convertValue(node.value, paramClass)

        return getRegisterBox(value)
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Domain" -> NewDomain::class.java
            "Peer" -> Peer::class.java
            "Account" -> NewAccount::class.java
            "AssetDefinition" -> NewAssetDefinition::class.java
            "Asset" -> Asset::class.java
            "Trigger" -> Trigger::class.java
            "Role" -> Role::class.java
            else -> throw DeserializationException("Unknown string type: $this")
        }
    }

    private fun getRegisterBox(arg: Any): RegisterBox {
        return when (arg) {
            is NewDomain -> RegisterBox.Domain(RegisterOfDomain(arg))
            is NewAccount -> RegisterBox.Account(RegisterOfAccount(arg))
            is Peer -> RegisterBox.Peer(RegisterOfPeer(arg))
            is NewAssetDefinition -> RegisterBox.AssetDefinition(RegisterOfAssetDefinition(arg))
            is Asset -> RegisterBox.Asset(RegisterOfAsset(arg))
            is Trigger -> RegisterBox.Trigger(RegisterOfTrigger(arg))
            is Role -> RegisterBox.Role(RegisterOfRole(arg))
            else -> throw DeserializationException("Register box `$arg` not found")
        }
    }
}

/**
 * Deserializer for [BurnBox]
 */
object BurnBoxDeserializer : JsonDeserializer<BurnBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): BurnBox {
        val node = p.readValueAsTree<JsonNode>()
        val paramClass = node.fields().next().key.toArg()

        return get(JSON_SERDE.convertValue(node.fields().next().value, paramClass))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Asset" -> BurnOfNumericAndAsset::class.java
            "TriggerRepetitions" -> BurnOfu32AndTrigger::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any): BurnBox {
        return when (arg) {
            is BurnOfNumericAndAsset -> BurnBox.Asset(arg)
            is BurnOfu32AndTrigger -> BurnBox.TriggerRepetitions(arg)
            else -> throw DeserializationException("Burn box `$arg` not found")
        }
    }
}

object MintBoxDeserializer : JsonDeserializer<MintBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): MintBox {
        val node = p.readValueAsTree<JsonNode>()
        val paramClass = node.fields().next().key.toArg()

        return get(JSON_SERDE.convertValue(node.fields().next().value, paramClass))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Asset" -> MintOfNumericAndAsset::class.java
            "TriggerRepetitions" -> MintOfu32AndTrigger::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any): MintBox {
        return when (arg) {
            is MintOfNumericAndAsset -> MintBox.Asset(arg)
            is MintOfu32AndTrigger -> MintBox.TriggerRepetitions(arg)
            else -> throw DeserializationException("Mint box `$arg` not found")
        }
    }
}

object EventFilterBoxDeserializer : JsonDeserializer<EventFilterBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): EventFilterBox {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        return getBox(JSON_SERDE.convertValue(node.value, node.key.toArg()))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "ExecuteTrigger" -> ExecuteTriggerEventFilter::class.java
            "Time" -> TimeEventFilter::class.java
            else -> throw DeserializationException("Unknown type `$this`")
        }
    }

    private fun getBox(arg: Any): EventFilterBox {
        return when (arg) {
            is ExecuteTriggerEventFilter -> EventFilterBox.ExecuteTrigger(arg)
            is TimeEventFilter -> EventFilterBox.Time(arg)
            else -> throw DeserializationException("Unknown type `$this`")
        }
    }
}

object TriggerIdDeserializer : JsonDeserializer<TriggerId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TriggerId {
        val triggerName = p.readValueAsTree<JsonNode>().asText()
        return getTriggerId(triggerName)
    }
}

object TransferBoxDeserializer : JsonDeserializer<TransferBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TransferBox {
        val node = p.readValueAsTree<JsonNode>()
        val paramClass = node.fields().next().key.toArg()

        return get(JSON_SERDE.convertValue(node.fields().next().value, paramClass))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Domain" -> TransferOfAccountAndDomainIdAndAccount::class.java
            "Asset" -> AssetTransferBox::class.java
            "AssetDefinition" -> TransferOfAccountAndAssetDefinitionIdAndAccount::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any): TransferBox {
        return when (arg) {
            is TransferOfAccountAndDomainIdAndAccount -> TransferBox.Domain(arg)
            is AssetTransferBox -> TransferBox.Asset(arg)
            is TransferOfAccountAndAssetDefinitionIdAndAccount -> TransferBox.AssetDefinition(arg)
            else -> throw DeserializationException("SetKeyValue box `$arg` not found")
        }
    }
}

object SetKeyValueBoxDeserializer : JsonDeserializer<SetKeyValueBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): SetKeyValueBox {
        val node = p.readValueAsTree<JsonNode>()
        val paramClass = node.fields().next().key.toArg()

        return get(JSON_SERDE.convertValue(node.fields().next().value, paramClass))
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Domain" -> SetKeyValueOfDomain::class.java
            "Account" -> SetKeyValueOfAccount::class.java
            "Asset" -> SetKeyValueOfAsset::class.java
            "AssetDefinition" -> SetKeyValueOfAssetDefinition::class.java
            "Trigger" -> SetKeyValueOfTrigger::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any): SetKeyValueBox {
        return when (arg) {
            is SetKeyValueOfDomain -> SetKeyValueBox.Domain(arg)
            is SetKeyValueOfAccount -> SetKeyValueBox.Account(arg)
            is SetKeyValueOfAsset -> SetKeyValueBox.Asset(arg)
            is SetKeyValueOfAssetDefinition -> SetKeyValueBox.AssetDefinition(arg)
            is SetKeyValueOfTrigger -> SetKeyValueBox.Trigger(arg)
            else -> throw DeserializationException("SetKeyValue box `$arg` not found")
        }
    }
}

/**
 * Deserializer for [Metadata]
 */
object MetadataDeserializer : JsonDeserializer<Metadata>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Metadata {
        return deserializeMetadata(p, JSON_SERDE)
    }

    private fun deserializeMetadata(p: JsonParser, mapper: ObjectMapper): Metadata {
        val nodeMetadata = p.readValueAsTree<JsonNode>().fields()
        if (!nodeMetadata.hasNext()) {
            return Metadata(mapOf())
        }
        val node = nodeMetadata.next()
        val key = node.key.asName()
        val value = node.value.asStringOrNull() ?: ""
        return Metadata(mapOf(Pair(key, value)))
    }
}

/**
 * Deserializer for [AssetType]
 */
object AssetTypeDeserializer : JsonDeserializer<AssetType>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AssetType {
        return when (p.readValueAsTree<TextNode>().textValue()) {
            AssetType.Numeric::class.simpleName -> AssetType.Numeric(NumericSpec())
            AssetType.Store::class.simpleName -> AssetType.Store()
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [NumericSpec]
 */
object NumericSpecDeserializer : JsonDeserializer<NumericSpec>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): NumericSpec {
        return NumericSpec(p.readValueAsTree<LongNode>().longValue())
    }
}

/**
 * Deserializer for [Numeric]
 */
object NumericDeserializer : JsonDeserializer<Numeric>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Numeric {
        return p.readValueAs(String::class.java).asNumeric()
    }
}

/**
 * Deserializer for [Permission]
 */
object PermissionDeserializer : JsonDeserializer<Permission>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Permission {
        val node = p.readValueAsTree<ObjectNode>()
        var payloadValue = node.get("payload").asStringOrNull()
        when (payloadValue.isNullOrEmpty()) {
            true -> payloadValue = "null"
            else -> {}
        }
        return Permission(node.get("name").asText(), payloadValue)
    }
}

/**
 * Deserializer for [ChainId]
 */
object ChainIdDeserializer : JsonDeserializer<ChainId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ChainId {
        return ChainId(p.readValueAs(String::class.java))
    }
}

/**
 * Deserializer for [NewAssetDefinition]
 */
object NewAssetDefinitionDeserializer : JsonDeserializer<NewAssetDefinition>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): NewAssetDefinition {
        val node = p.readValueAsTree<JsonNode>()
        val domainId = node["id"].asText().asAssetDefinitionId()
        val mintable = JSON_SERDE.convertValue(node["mintable"], Mintable::class.java)
        val type = JSON_SERDE.convertValue(node["type"], AssetType::class.java)
        val logo = JSON_SERDE.convertValue(node["logo"], IpfsPath::class.java)
        val metadata = JSON_SERDE.convertValue(node["metadata"], Metadata::class.java)

        return NewAssetDefinition(domainId, type, mintable, logo, metadata)
    }
}

/**
 * Deserializer for [NewDomain]
 */
object NewDomainDeserializer : JsonDeserializer<NewDomain>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): NewDomain {
        val node = p.readValueAsTree<JsonNode>()
        val domainId = node["id"].asText().asDomainId()
        val logo = JSON_SERDE.convertValue(node["logo"], IpfsPath::class.java)
        val metadata = JSON_SERDE.convertValue(node["metadata"], Metadata::class.java)

        return NewDomain(domainId, logo, metadata)
    }
}

/**
 * Deserializer for [Trigger]
 */
object TriggerDeserializer : JsonDeserializer<Trigger>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Trigger {
        val node = p.readValueAsTree<JsonNode>()
        val triggerId = TriggerId(node["id"].asText().asName())
        val action = JSON_SERDE.convertValue(node["action"], Action::class.java)

        return Trigger(triggerId, action)
    }
}

/**
 * Deserializer for [ExecuteTriggerEventFilter]
 */
object ExecuteTriggerEventFilterDeserializer : JsonDeserializer<ExecuteTriggerEventFilter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ExecuteTriggerEventFilter {
        val node = p.readValueAsTree<JsonNode>()
        val triggerId = TriggerId(node["trigger"].asText().asName())
        val authority = JSON_SERDE.convertValue(node["authority"], AccountId::class.java)

        return ExecuteTriggerEventFilter(triggerId, authority)
    }
}

/**
 * Deserializer for [Action]
 */
object ActionDeserializer : JsonDeserializer<Action>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Action {
        val node = p.readValueAsTree<JsonNode>()
        val executable = JSON_SERDE.convertValue(node["executable"], Executable::class.java)
        val repeats = JSON_SERDE.convertValue(node["repeats"], Repeats::class.java)
        val authority = JSON_SERDE.convertValue(node["authority"], AccountId::class.java)
        val filter = JSON_SERDE.convertValue(node["filter"], EventFilterBox::class.java)
        val metadata = JSON_SERDE.convertValue(node["metadata"], Metadata::class.java)

        return Action(executable, repeats, authority, filter, metadata)
    }
}

/**
 * Deserializer for [Executable]
 */
object ExecutableDeserializer : JsonDeserializer<Executable>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Executable {
        val node = p.readValueAsTree<JsonNode>().fields().next()

        val paramClass = node.key.toArg()
        val value = JSON_SERDE.convertValue(node.value, paramClass)

        return getExecutable(value)
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Wasm" -> WasmSmartContract::class.java
            "Instructions" -> List::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun getExecutable(arg: Any): Executable {
        return when (arg) {
            is WasmSmartContract -> Executable.Wasm(arg)
            is List<*> -> Executable.Instructions(arg as List<InstructionBox>)
            else -> throw DeserializationException("Executable `$arg` not found")
        }
    }
}

/**
 * Deserializer for [IpfsPath]
 */
object IpfsPathDeserializer : JsonDeserializer<IpfsPath>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): IpfsPath {
        return IpfsPath(p.readValueAs(String::class.java))
    }
}

/**
 * Deserializer for [Repeats]
 */
object RepeatsDeserializer : JsonDeserializer<Repeats>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Repeats {
        return when (val node = p.readValueAsTree<JsonNode>()) {
            is TextNode -> Repeats.Indefinitely()
            is ObjectNode -> {
                val field = node.fields().next()
                Repeats.Exactly(JSON_SERDE.convertValue(field.value, Long::class.java))
            }

            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [Parameter]
 */
object ParameterDeserializer : JsonDeserializer<Parameter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Parameter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        return get(JSON_SERDE.convertValue(node.value, node.key.toArg()), node.key)
    }

    private fun String.toArg(): Class<*> {
        return when (this) {
            "Sumeragi" -> SumeragiParameter::class.java
            "Block" -> BlockParameter::class.java
            "Transaction" -> TransactionParameter::class.java
            "SmartContract" -> SmartContractParameter::class.java
            "Executor" -> SmartContractParameter::class.java
            "Custom" -> CustomParameter::class.java
            else -> throw DeserializationException("Unknown type: $this")
        }
    }

    private fun get(arg: Any, type: String): Parameter {
        return when (type) {
            "Sumeragi" -> Parameter.Sumeragi(arg as SumeragiParameter)
            "Block" -> Parameter.Block(arg as BlockParameter)
            "Transaction" -> Parameter.Transaction(arg as TransactionParameter)
            "Executor" -> Parameter.Executor(arg as SmartContractParameter)
            "SmartContract" -> Parameter.SmartContract(arg as SmartContractParameter)
            "CustomParameter" -> Parameter.Custom(arg as CustomParameter)
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [SumeragiParameter]
 */
object SumeragiParameterDeserializer : JsonDeserializer<SumeragiParameter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): SumeragiParameter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        val arg = JSON_SERDE.convertValue(node.value, BigInteger::class.java)
        return get(arg, node.key)
    }

    private fun get(arg: BigInteger, type: String): SumeragiParameter {
        return when (type) {
            "BlockTimeMs" -> SumeragiParameter.BlockTimeMs(arg)
            "CommitTimeMs" -> SumeragiParameter.CommitTimeMs(arg)
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [BlockParameter]
 */
object BlockParameterDeserializer : JsonDeserializer<BlockParameter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): BlockParameter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        val arg = JSON_SERDE.convertValue(node.value, BigInteger::class.java)
        return BlockParameter.MaxTransactions(NonZeroOfu64(arg))
    }
}

/**
 * Deserializer for [TransactionParameter]
 */
object TransactionParameterDeserializer : JsonDeserializer<TransactionParameter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TransactionParameter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        val arg = JSON_SERDE.convertValue(node.value, BigInteger::class.java)
        return get(arg, node.key)
    }

    private fun get(arg: BigInteger, type: String): TransactionParameter {
        return when (type) {
            "MaxInstructions" -> TransactionParameter.MaxInstructions(NonZeroOfu64(arg))
            "SmartContractSize" -> TransactionParameter.SmartContractSize(NonZeroOfu64(arg))
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [SmartContractParameter]
 */
object SmartContractParameterDeserializer : JsonDeserializer<SmartContractParameter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): SmartContractParameter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        val arg = JSON_SERDE.convertValue(node.value, BigInteger::class.java)
        return get(arg, node.key)
    }

    private fun get(arg: BigInteger, type: String): SmartContractParameter {
        return when (type) {
            "Fuel" -> SmartContractParameter.Fuel(NonZeroOfu64(arg))
            "Memory" -> SmartContractParameter.Memory(NonZeroOfu64(arg))
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [Schedule]
 */
object ScheduleDeserializer : JsonDeserializer<Schedule>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Schedule {
        val node = p.readValueAsTree<JsonNode>()
        return Schedule(
            startMs = JSON_SERDE.convertValue(node["start_ms"], BigInteger::class.java),
            periodMs = JSON_SERDE.convertValue(node["period_ms"], BigInteger::class.java),
        )
    }
}

/**
 * Deserializer for [ExecutionTime]
 */
object ExecutionTimeDeserializer : JsonDeserializer<ExecutionTime>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): ExecutionTime {
        return when (val node = p.readValueAsTree<JsonNode>()) {
            is TextNode -> ExecutionTime.PreCommit()
            is ObjectNode -> ExecutionTime.Schedule(JSON_SERDE.convertValue(node, Schedule::class.java))
            else -> throw DeserializationException("Unknown type: $this")
        }
    }
}

/**
 * Deserializer for [TimeEventFilter]
 */
object TimeEventFilterDeserializer : JsonDeserializer<TimeEventFilter>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TimeEventFilter {
        val node = p.readValueAsTree<JsonNode>().fields().next()
        return TimeEventFilter(JSON_SERDE.convertValue(node.value, ExecutionTime::class.java))
    }
}

/**
 * Deserializer for [PublicKey]
 */
object PublicKeyDeserializer : JsonDeserializer<PublicKey>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): PublicKey {
        val key = p.readValueAs(String::class.java)
        return PublicKey(Algorithm.Ed25519(), key.substring(6, key.length).fromHex())
    }
}

/**
 * Deserializer for [Name]
 */
object NameDeserializer : JsonDeserializer<Name>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Name {
        return Name(p.readValueAs(String::class.java))
    }
}

/**
 * Deserializer for [Mintable]
 */
object MintableDeserializer : JsonDeserializer<Mintable>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Mintable {
        return when (val value = p.readValueAs(String::class.java)) {
            Mintable.Once::class.simpleName -> Mintable.Once()
            Mintable.Not::class.simpleName -> Mintable.Not()
            Mintable.Infinitely::class.simpleName -> Mintable.Infinitely()
            else -> throw DeserializationException("Unknown Mintable type: $value")
        }
    }
}

/**
 * Deserializer for [asset ID][AssetId]
 */
object AssetIdDeserializer : JsonDeserializer<AssetId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AssetId {
        return p.readValueAs(String::class.java).asAssetId()
    }
}

/**
 * Deserializer for [asset definition ID][AssetDefinitionId]
 */
object AssetDefinitionIdDeserializer : JsonDeserializer<AssetDefinitionId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AssetDefinitionId {
        return p.readValueAs(String::class.java).asAssetDefinitionId()
    }
}

/**
 * Deserializer for [account ID][AccountId]
 */
object AccountIdDeserializer : JsonDeserializer<AccountId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AccountId {
        return p.readValueAs(String::class.java).asAccountId()
    }
}

/**
 * Deserializer for [role ID][RoleId]
 */
object RoleIdDeserializer : JsonDeserializer<RoleId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): RoleId {
        return p.readValueAs(String::class.java).asRoleId()
    }
}

/**
 * Deserializer for [domain ID][DomainId]
 */
object DomainIdDeserializer : JsonDeserializer<DomainId>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): DomainId {
        return p.readValueAs(String::class.java).asDomainId()
    }
}

/**
 * Deserializer for [asset definition ID][AssetDefinitionId]
 */
object AssetDefinitionIdKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): AssetDefinitionId? {
        return JSON_SERDE.readValue(key, AssetDefinitionId::class.java)
    }
}

/**
 * Deserializer for [account ID][AccountId]
 */
object AccountIdKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): AccountId? {
        return JSON_SERDE.readValue(key, AccountId::class.java)
    }
}

/**
 * Deserializer for [asset ID][AssetId]
 */
object AssetIdKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String, ctxt: DeserializationContext?): AssetId? {
        return JSON_SERDE.readValue(key, AssetId::class.java)
    }
}

/**
 * Deserializer for [domain ID][DomainId]
 */
object DomainIdKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String, ctxt: DeserializationContext?): DomainId? {
        return JSON_SERDE.readValue(key, DomainId::class.java)
    }
}

// ==================================================

/**
 * Serializer for [RawGenesisTransaction]
 */
object RawGenesisTransactionSerializer : JsonSerializer<RawGenesisTransaction>() {
    override fun serialize(tx: RawGenesisTransaction, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeObjectField("chain", tx.chain.string)
        gen.writeObjectField("executor", tx.executor)
        gen.writeObjectField("parameters", tx.parameters)
        when (tx.instructions.isEmpty()) {
            true -> gen.writeObjectField("instructions", listOf<InstructionBox>())
            false -> gen.writeObjectField("instructions", tx.instructions)
        }
        gen.writeObjectField("topology", tx.topology)
        gen.writeEndObject()
    }
}

/**
 * Serializer for [AssetDefinitionId]
 */
object AssetDefinitionIdSerializer : JsonSerializer<AssetDefinitionId>() {
    override fun serialize(value: AssetDefinitionId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString())
    }
}

/**
 * Serializer for [AssetId]
 */
object AssetIdSerializer : JsonSerializer<AssetId>() {
    override fun serialize(value: AssetId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString(true))
    }
}

/**
 * Serializer for [AccountId]
 */
object AccountIdSerializer : JsonSerializer<AccountId>() {
    override fun serialize(value: AccountId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString(true))
    }
}

/**
 * Serializer for [DomainId]
 */
object DomainIdSerializer : JsonSerializer<DomainId>() {
    override fun serialize(value: DomainId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString())
    }
}

/**
 * Serializer for [RoleId]
 */
object RoleIdSerializer : JsonSerializer<RoleId>() {
    override fun serialize(value: RoleId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString())
    }
}

object SocketAddrSerializer : JsonSerializer<SocketAddr>() {
    override fun serialize(value: SocketAddr, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString())
    }
}

/**
 * Serializer for [TriggerId]
 */
object TriggerIdSerializer : JsonSerializer<TriggerId>() {
    override fun serialize(value: TriggerId, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.asString())
    }
}

/**
 * Serializer for [TimeEventFilter]
 */
object TimeEventFilterSerializer : JsonSerializer<TimeEventFilter>() {
    override fun serialize(value: TimeEventFilter, gen: JsonGenerator, serializers: SerializerProvider) {
        value.serializeEnum(gen)
    }
}

/**
 * Serializer for [Schedule]
 */
object ScheduleSerializer : JsonSerializer<Schedule>() {
    override fun serialize(value: Schedule, gen: JsonGenerator, serializers: SerializerProvider) {
        val schedule = mapOf(Pair("start_ms", value.startMs), Pair("period_ms", value.periodMs))
        gen.writeObject(schedule)
    }
}

/**
 * Serializer for [Name] as key
 */
object NameAsKeySerializer : JsonSerializer<Name>() {
    override fun serialize(value: Name, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeFieldName(value.string)
    }
}

/**
 * Serializer for [Name]
 */
object NameSerializer : JsonSerializer<Name>() {
    override fun serialize(value: Name, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.string)
    }
}

/**
 * Serializer for [Executor]
 */
object ExecutorSerializer : JsonSerializer<Executor>() {
    override fun serialize(value: Executor, gen: JsonGenerator, serializers: SerializerProvider) {
        when (value) {
//            is Executor -> gen.writeString(value.wasm)
            else -> throw IrohaSdkException("Unsupported type ${this::class}")
        }
    }
}

/**
 * Serializer for [InstructionBox]
 */
object InstructionBoxSerializer : JsonSerializer<InstructionBox>() {
    override fun serialize(value: InstructionBox, gen: JsonGenerator, serializers: SerializerProvider) {
        when (value) {
            is InstructionBox.Register -> value.serializeBox<RegisterBox>(gen)
            is InstructionBox.SetKeyValue -> value.serializeBox<SetKeyValueBox>(gen)
            is InstructionBox.Mint -> value.serializeBox<MintBox>(gen)
            is InstructionBox.Burn -> value.serializeBox<BurnBox>(gen)
            is InstructionBox.Transfer -> value.serializeBox<TransferBox>(gen)
            is InstructionBox.Grant -> value.serializeBox<GrantBox>(gen)
            else -> throw IrohaSdkException("Unsupported type ${this::class}")
        }
    }
}

/**
 * Serializer for [RegisterOfDomain]
 */
object RegisterOfDomainSerializer : JsonSerializer<RegisterOfDomain>() {
    override fun serialize(value: RegisterOfDomain, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfTrigger]
 */
object RegisterOfTriggerSerializer : JsonSerializer<RegisterOfTrigger>() {
    override fun serialize(value: RegisterOfTrigger, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfRole]
 */
object RegisterOfRoleSerializer : JsonSerializer<RegisterOfRole>() {
    override fun serialize(value: RegisterOfRole, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfAsset]
 */
object RegisterOfAssetSerializer : JsonSerializer<RegisterOfAsset>() {
    override fun serialize(value: RegisterOfAsset, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfAssetDefinition]
 */
object RegisterOfAssetDefinitionSerializer : JsonSerializer<RegisterOfAssetDefinition>() {
    override fun serialize(value: RegisterOfAssetDefinition, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfPeer]
 */
object RegisterOfPeerSerializer : JsonSerializer<RegisterOfPeer>() {
    override fun serialize(value: RegisterOfPeer, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [RegisterOfAccount]
 */
object RegisterOfAccountSerializer : JsonSerializer<RegisterOfAccount>() {
    override fun serialize(value: RegisterOfAccount, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.`object`)
    }
}

/**
 * Serializer for [AssetTransferBox]
 */
object AssetTransferBoxSerializer : JsonSerializer<AssetTransferBox>() {
    override fun serialize(value: AssetTransferBox, gen: JsonGenerator, serializers: SerializerProvider) {
        when (value) {
            is AssetTransferBox.Numeric -> gen.writeObject(value.transferOfAssetAndNumericAndAccount)
            is AssetTransferBox.Store -> gen.writeObject(value.transferOfAssetAndMetadataAndAccount)
            else -> throw IrohaSdkException("Unexpected type ${value::class}")
        }
    }
}

/**
 * Serializer for [NonZeroOfu64]
 */
object NonZeroOfu64Serializer : JsonSerializer<NonZeroOfu64>() {
    override fun serialize(value: NonZeroOfu64, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.u64)
    }
}

/**
 * Serializer for [Executable.Instructions]
 */
object ExecutableInstructionsSerializer : JsonSerializer<Executable.Instructions>() {
    override fun serialize(value: Executable.Instructions, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeObjectField(Executable.Instructions::class.simpleName, value.vec)
        gen.writeEndObject()
    }
}

/**
 * Serializer for [ExecuteTriggerEventFilter]
 */
object ExecuteTriggerEventFilterSerializer : JsonSerializer<ExecuteTriggerEventFilter>() {
    override fun serialize(value: ExecuteTriggerEventFilter, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeObjectField("trigger", value.triggerId)
        gen.writeObjectField("authority", value.authority)
        gen.writeEndObject()
    }
}

/**
 * Serializer for [AssetType]
 */
object AssetTypeSerializer : JsonSerializer<AssetType>() {
    override fun serialize(value: AssetType, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value::class.simpleName)
    }
}

/**
 * Serializer for [Numeric]
 */
object NumericSerializer : JsonSerializer<Numeric>() {
    override fun serialize(value: Numeric, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeObject(value.asString())
    }
}

/**
 * Serializer for [Permission]
 */
object PermissionSerializer : JsonSerializer<Permission>() {
    override fun serialize(value: Permission, gen: JsonGenerator, serializers: SerializerProvider) {
        val payload = JSON_SERDE.readTree(value.payload)
        gen.writeStartObject()
        gen.writeObjectField(Permission::name.name, value.name)
        gen.writeObjectField(Permission::payload.name, payload)
        gen.writeEndObject()
    }
}

/**
 * Custom serializer for [UInt]
 */
object UIntSerializer : JsonSerializer<UInt>() {
    override fun serialize(value: UInt, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeNumber(value.toLong())
    }
}

/**
 * Custom serializer for [PublicKey]
 */
object PublicKeySerializer : JsonSerializer<PublicKey>() {
    override fun serialize(value: PublicKey, gen: JsonGenerator, serializers: SerializerProvider) {
        val res = ByteArrayOutputStream()
        Multihash.putUvarint(res, Ed25519.index.toLong())
        Multihash.putUvarint(res, value.payload.size.toLong())
        res.write(value.payload)
        gen.writeString(res.toByteArray().toHex())
    }
}

/**
 * Custom serializer for [Metadata]
 */
object MetadataSerializer : JsonSerializer<Metadata>() {
    override fun serialize(value: Metadata, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        value.sortedMapOfName.forEach { (k, v) ->
            gen.writeStringField(k.string, v)
        }
        gen.writeEndObject()
    }
}

/**
 * Custom serializer for [IdentifiableBox.NewRole]
 */
object IdentifiableBoxNewRoleSerializer : JsonSerializer<IdentifiableBox.NewRole>() {
    override fun serialize(value: IdentifiableBox.NewRole, gen: JsonGenerator, serializers: SerializerProvider) {
        serializeSingleMember(gen, value.role)
    }
}

/**
 * Custom serializer for [Parameter]
 */
object ParameterSerializer : JsonSerializer<Parameter>() {
    override fun serialize(value: Parameter, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        when (value) {
            is Parameter.Block -> gen.writeObjectField(Parameter.Block::class.simpleName, value.blockParameter)
            is Parameter.Custom -> gen.writeObjectField(Parameter.Custom::class.simpleName, value.customParameter)
            is Parameter.Executor -> gen.writeObjectField(Parameter.Executor::class.simpleName, value.smartContractParameter)
            is Parameter.SmartContract -> gen.writeObjectField(
                Parameter.SmartContract::class.simpleName,
                value.smartContractParameter,
            )

            is Parameter.Sumeragi -> gen.writeObjectField(Parameter.Sumeragi::class.simpleName, value.sumeragiParameter)
            is Parameter.Transaction -> gen.writeObjectField(Parameter.Transaction::class.simpleName, value.transactionParameter)
            else -> throw IrohaSdkException("Unexpected type ${value::class}")
        }
        gen.writeEndObject()
    }
}

/**
 * Custom serializer for Iroha2 enumeration types
 */
object EnumerationSerializer : JsonSerializer<ModelEnum>() {
    override fun serialize(value: ModelEnum, gen: JsonGenerator, serializers: SerializerProvider) {
        when (value) {
            is InstructionBox.Grant -> value.serialize(gen)
            is InstructionBox.Burn -> value.serialize(gen)
            is InstructionBox.Mint -> value.serialize(gen)
            is InstructionBox.SetKeyValue -> value.serialize(gen)
            is InstructionBox.Register -> value.serialize(gen)
            else -> serializeSingleMember(gen, value)
        }
    }
}

private fun InstructionBox.SetKeyValue.serialize(gen: JsonGenerator) = this.serializeBox<SetKeyValueBox>(gen)

private fun InstructionBox.Grant.serialize(gen: JsonGenerator) = this.serializeBox<GrantBox>(gen)

private fun InstructionBox.Burn.serialize(gen: JsonGenerator) = this.serializeBox<BurnBox>(gen)

private fun InstructionBox.Mint.serialize(gen: JsonGenerator) = this.serializeBox<MintBox>(gen)

private fun InstructionBox.Register.serialize(gen: JsonGenerator) = this.serializeBox<RegisterBox>(gen)

/**
 * Serializes BurnBox, MintBox, GrantBox etc...
 */
private inline fun <reified B> InstructionBox.serializeBox(gen: JsonGenerator) {
    val clazz = this::class
    val memberProperties = clazz.memberProperties
    when (memberProperties.size) {
        0 -> gen.writeString(clazz.simpleName)
        1 -> {
            gen.writeStartObject()
            gen.writeObjectFieldStart(clazz.simpleName)
            memberProperties.first().call(this)?.cast<B>()?.serializeBox(gen)
            gen.writeEndObject()
            gen.writeEndObject()
        }

        else -> throw SerializationException("Expected enum that accepts exactly 0 or 1 members as tuple")
    }
}

private inline fun <reified B> B.serializeBox(
    gen: JsonGenerator,
) = when (B::class) {
    BurnBox::class -> this?.cast<BurnBox>()?.serializeBox(gen)
    MintBox::class -> this?.cast<MintBox>()?.serializeBox(gen)
    GrantBox::class -> this?.cast<GrantBox>()?.serializeBox(gen)
    TransferBox::class -> this?.cast<TransferBox>()?.serializeBox(gen)
    SetKeyValueBox::class -> this?.cast<SetKeyValueBox>()?.serializeBox(gen)
    RegisterBox::class -> this?.cast<RegisterBox>()?.serializeBox(gen)
    else -> throw IrohaSdkException("Unexpected type ${B::class}")
}

private fun BurnBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun MintBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun GrantBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun TransferBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun RegisterBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun SetKeyValueBox.serializeBox(gen: JsonGenerator) = serializeBox(this, gen)

private fun serializeBox(obj: Any, gen: JsonGenerator) {
    val memberProperties = obj::class.memberProperties
    when (memberProperties.size) {
        0 -> gen.writeString(obj::class.simpleName)
        1 -> gen.writeObjectField(obj::class.simpleName, memberProperties.first().call(obj))

        else -> throw SerializationException("Expected enum that accepts exactly 0 or 1 members as tuple")
    }
}

/**
 * Serialise a single member object or nothing at all
 */
private fun serializeSingleMember(gen: JsonGenerator, value: Any) {
    val clazz = value::class
    val memberProperties = clazz.memberProperties
    when (memberProperties.size) {
        0 -> gen.writeString(clazz.simpleName)
        1 -> {
            gen.writeStartObject()
            gen.writeObjectField(clazz.simpleName, memberProperties.first().call(value))
            gen.writeEndObject()
        }

        else -> throw SerializationException("Expected enum that accepts exactly 0 or 1 members as tuple")
    }
}

/**
 * Serialise an enum
 */
private inline fun <reified T> T.serializeEnum(gen: JsonGenerator) {
    val clazz = this!!::class
    val memberProperties = clazz.memberProperties
    when (memberProperties.size) {
        0 -> gen.writeString(clazz.simpleName)
        1 -> gen.writeObject(memberProperties.first().call(this))
        else -> throw SerializationException("Expected enum that accepts exactly 0 or 1 members as tuple")
    }
}

private fun String.asClass() = runCatching {
    Class.forName(this)
}.getOrNull() ?: run {
    when (this) {
        "kotlin.Long" -> Long::class.java
        "kotlin.Int" -> Int::class.java
        else -> null
    }
} ?: throw DeserializationException("Class $this not found")

private fun getClazzByParam(param: String): KClass<out Any> {
    return when (param) {
        "SetKeyValue" -> SetKeyValueBox::class
        "Bool" -> Boolean::class
        "String" -> String::class
        "Name" -> Name::class
        "LimitedMetadata" -> Metadata::class
        "Id" -> IdBox::class
        "Identifiable" -> IdentifiableBox::class
        "PublicKey" -> PublicKey::class
        "TransactionQueryOutput" -> TransactionQueryOutput::class
        "Hash" -> Hash::class
        "Block" -> SignedBlock::class
        "BlockHeader" -> BlockHeader::class
        "Ipv4Addr" -> Ipv4Addr::class
        "Ipv6Addr" -> Ipv6Addr::class
        "U32" -> Numeric::class
        "U64" -> Numeric::class
        "U128" -> Numeric::class
        "Fixed" -> Numeric::class
        else -> throw DeserializationException("Value key $param not found")
    }
}

private fun sealedDeserializeIdBox(p: JsonParser, mapper: ObjectMapper): IdBox {
    val node = p.readValueAsTree<JsonNode>().fields().next()
    val param = node.key

    val subtype = IdBox::class.nestedClasses.find { clazz ->
        !clazz.isCompanion && clazz.simpleName == param
    } ?: throw DeserializationException("Class with constructor($param) not found")

    val argTypeName = subtype.primaryConstructor?.parameters
        ?.firstOrNull()?.type?.toString()
        ?: throw DeserializationException("Subtype parameter not found by $param")

    val arg = mapper.convertValue(node.value, argTypeName.asClass())
    return subtype.primaryConstructor?.call(arg) as IdBox
}

private fun getTriggerId(triggerName: String): TriggerId {
    return when (triggerName.contains("$")) {
        true -> TriggerId(name = triggerName.split("$")[0].asName())
        false -> TriggerId(name = triggerName.asName())
    }
}

private fun Any.toInstructionBox(): InstructionBox {
    return when (this) {
        is GrantBox -> InstructionBox.Grant(this)
        is RevokeBox -> InstructionBox.Revoke(this)
        is ExecuteTrigger -> InstructionBox.ExecuteTrigger(this)
        is SetParameter -> InstructionBox.SetParameter(this)
        is Upgrade -> InstructionBox.Upgrade(this)
        is Log -> InstructionBox.Log(this)
        is CustomInstruction -> InstructionBox.Custom(this)
        is SetKeyValueBox -> InstructionBox.SetKeyValue(this)
        is RemoveKeyValueBox -> InstructionBox.RemoveKeyValue(this)
        is TransferBox -> InstructionBox.Transfer(this)
        is BurnBox -> InstructionBox.Burn(this)
        is MintBox -> InstructionBox.Mint(this)
        is RegisterBox -> InstructionBox.Register(this)
        is UnregisterBox -> InstructionBox.Unregister(this)
        else -> throw DeserializationException("Unknown type: $this")
    }
}
