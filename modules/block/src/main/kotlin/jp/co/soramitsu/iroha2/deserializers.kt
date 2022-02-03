package jp.co.soramitsu.iroha2

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.KeyDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.google.crypto.tink.subtle.Hex
import jp.co.soramitsu.iroha2.generated.crypto.PublicKey
import jp.co.soramitsu.iroha2.generated.datamodel.IdBox
import jp.co.soramitsu.iroha2.generated.datamodel.IdentifiableBox
import jp.co.soramitsu.iroha2.generated.datamodel.Name
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetValueType
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.generated.datamodel.expression.Expression
import jp.co.soramitsu.iroha2.generated.datamodel.isi.Instruction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor
import jp.co.soramitsu.iroha2.generated.datamodel.account.Id as AccountId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.Id as AssetId

val iroha2Mapper = ObjectMapper().also { mapper ->
    val module = SimpleModule()
    module.addDeserializer(Instruction::class.java, InstructionDeserializer())
    module.addDeserializer(Expression::class.java, ExpressionDeserializer())
    module.addDeserializer(Value::class.java, ValueDeserializer())
    module.addDeserializer(IdentifiableBox::class.java, IdentifiableBoxDeserializer())
    module.addDeserializer(PublicKey::class.java, PublicKeyDeserializer())
    module.addDeserializer(IdBox::class.java, IdBoxDeserializer())
    module.addDeserializer(AssetValueType::class.java, AssetValueTypeDeserializer())
    module.addDeserializer(Name::class.java, NameDeserializer())
    module.addKeyDeserializer(DefinitionId::class.java, DefinitionIdDeserializer())
    module.addKeyDeserializer(AccountId::class.java, AccountIdDeserializer())
    module.addKeyDeserializer(AssetId::class.java, AssetIdDeserializer())
    mapper.registerModule(module)

    mapper.registerModule(
        KotlinModule.Builder()
            .configure(KotlinFeature.NullToEmptyCollection, true)
            .configure(KotlinFeature.NullToEmptyMap, true)
            .build()
    )

    mapper.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
}

private fun String.asClass(): Class<*> {
    return runCatching {
        Class.forName(this)
    }.getOrNull() ?: run {
        when (this) {
            "kotlin.Long" -> Long::class.java
            "kotlin.Int" -> Int::class.java
            else -> null
        }
    } ?: throw RuntimeException("Class $this not found")
}

private inline fun <reified T : ModelEnum> sealedDeserialize(p: JsonParser, mapper: ObjectMapper): T {
    val node = p.readValueAsTree<JsonNode>().fields().next()
    val param = node.key

    val subtype = T::class.nestedClasses.find { clazz ->
        !clazz.isCompanion && clazz.simpleName == param
    } ?: throw RuntimeException("Class with constructor($param) not found")

    val argTypeName = subtype.primaryConstructor?.parameters
        ?.firstOrNull()?.type?.toString()
        ?: throw RuntimeException("Subtype parameter not found by $param")

    val toConvert: JsonNode
    if (T::class.java.isAssignableFrom(Instruction::class.java)) {
        var jsonNode: ObjectNode = node.value.deepCopy()
        jsonNode.fields().forEach { field ->
            val key = field.key
            val child = mapper.createObjectNode()
            child.set<ObjectNode>("expression", node.value.get(key))
            val value: ObjectNode = jsonNode.deepCopy()
            value.set<ObjectNode>(key, child)

            jsonNode = value
        }

        toConvert = jsonNode
    } else {
        toConvert = node.value as JsonNode
    }

    val arg = mapper.convertValue(toConvert, argTypeName.asClass())
    return subtype.primaryConstructor?.call(arg) as T
}

class InstructionDeserializer : JsonDeserializer<Instruction>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Instruction {
        return sealedDeserialize(p, iroha2Mapper)
    }
}

class ExpressionDeserializer : JsonDeserializer<Expression>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Expression {
        return sealedDeserialize(p, iroha2Mapper)
    }
}

class ValueDeserializer : JsonDeserializer<Value>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Value {
        return sealedDeserialize(p, iroha2Mapper)
    }
}

class IdentifiableBoxDeserializer : JsonDeserializer<IdentifiableBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): IdentifiableBox {
        return sealedDeserialize(p, iroha2Mapper)
    }
}

class IdBoxDeserializer : JsonDeserializer<IdBox>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): IdBox {
        return sealedDeserialize(p, iroha2Mapper)
    }
}

class AssetValueTypeDeserializer : JsonDeserializer<AssetValueType>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): AssetValueType {
        val text = p.readValueAs(String::class.java)
        return AssetValueType::class.nestedClasses
            .findLast { it.simpleName == text }
            ?.createInstance() as AssetValueType?
            ?: throw RuntimeException("AssetValueType $text not found")
    }
}

class PublicKeyDeserializer : JsonDeserializer<PublicKey>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): PublicKey {
        val key = p.readValueAs(String::class.java)
        return PublicKey("ed25519", Hex.decode(key))
    }
}

class NameDeserializer : JsonDeserializer<Name>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Name {
        val key = p.readValueAs(String::class.java)
        return Name(key)
    }
}

class DefinitionIdDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): DefinitionId? {
        return iroha2Mapper.readValue(key, DefinitionId::class.java)
    }
}

class AccountIdDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): AccountId? {
        return iroha2Mapper.readValue(key, AccountId::class.java)
    }
}

class AssetIdDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): AssetId? {
        return iroha2Mapper.readValue(key, AssetId::class.java)
    }
}
