// Do not change. Autogenerated code
package jp.co.soramitsu.iroha2.generated.datamodel.query.account

import jp.co.soramitsu.iroha2.generated.datamodel.expression.EvaluatesTo
import kotlin.String

/**
 * FindAccountsByName
 *
 * Matched to regular structure in Rust
 */
public class FindAccountsByName(
  private val name: EvaluatesTo
) {
  public companion object {
    public const val IROHA_FULL_NAME: String =
        "iroha_data_model::query::account::FindAccountsByName"
  }
}
