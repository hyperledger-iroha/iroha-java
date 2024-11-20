package jp.co.soramitsu.iroha2.codegen.generator

import com.squareup.kotlinpoet.TypeSpec
import jp.co.soramitsu.iroha2.codegen.blueprint.TupleStructBlueprint

/**
 * Generator for [TupleStructBlueprint]
 */
object TupleStructGenerator : AbstractGenerator<TupleStructBlueprint>() {
    override fun implKDoc(blueprint: TupleStructBlueprint, clazz: TypeSpec.Builder) {
        super.implKDoc(blueprint, clazz)
        clazz.addKdoc("\n\nGenerated from '${blueprint.source.name}' tuple structure")
    }
}
