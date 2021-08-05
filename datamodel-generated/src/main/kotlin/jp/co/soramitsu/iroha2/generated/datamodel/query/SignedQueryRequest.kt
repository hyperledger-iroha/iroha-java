// Do not change. Autogenerated code
package jp.co.soramitsu.iroha2.generated.datamodel.query

import jp.co.soramitsu.iroha2.generated.crypto.Signature
import kotlin.Int
import kotlin.String

/**
 * SignedQueryRequest
 *
 * Matched to regular structure in Rust
 */
public class SignedQueryRequest(
  private val timestampMs: Int,
  private val signature: Signature,
  private val query: QueryBox
) {
  public companion object {
    public const val IROHA_FULL_NAME: String = "iroha_data_model::query::SignedQueryRequest"
  }
}
