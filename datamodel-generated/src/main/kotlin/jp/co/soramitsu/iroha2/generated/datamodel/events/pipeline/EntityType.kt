// Do not change. Autogenerated code
package jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline

import kotlin.Int
import kotlin.String

/**
 * EntityType
 *
 * Matched to enum in Rust
 */
public abstract class EntityType {
  public companion object {
    public const val IROHA_FULL_NAME: String = "iroha_data_model::events::pipeline::EntityType"
  }

  /**
   * 'Block' variant
   */
  public class Block : EntityType() {
    public companion object {
      public const val DISCRIMINANT: Int = 0
    }
  }

  /**
   * 'Transaction' variant
   */
  public class Transaction : EntityType() {
    public companion object {
      public const val DISCRIMINANT: Int = 1
    }
  }
}
