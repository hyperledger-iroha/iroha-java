//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * QueryWithFilterOfFindDomainsAndDomainPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindDomainsAndDomainPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindDomainsAndDomainPredicateBox(
    public val query: FindDomains,
    public val predicate: CompoundPredicateOfDomainPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindDomainsAndDomainPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindDomainsAndDomainPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindDomainsAndDomainPredicateBox =
            try {
                QueryWithFilterOfFindDomainsAndDomainPredicateBox(
                    FindDomains.read(reader),
                    CompoundPredicateOfDomainPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindDomainsAndDomainPredicateBox,
        ): Unit = try {
            FindDomains.write(writer, instance.query)
            CompoundPredicateOfDomainPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
