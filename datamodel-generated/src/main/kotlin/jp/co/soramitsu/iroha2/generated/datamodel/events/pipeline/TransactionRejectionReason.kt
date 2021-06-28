// Do not change. Autogenerated code
package jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline

import kotlin.Int
import kotlin.String

/**
 * TransactionRejectionReason
 *
 * Matched to enum in Rust
 */
public abstract class TransactionRejectionReason {
  public companion object {
    public const val IROHA_FULL_NAME: String =
        "iroha_data_model::events::pipeline::TransactionRejectionReason"
  }

  /**
   * 'NotPermitted' variant
   */
  public class NotPermitted(
    private val notPermitted: NotPermittedFail
  ) : TransactionRejectionReason() {
    public companion object {
      public const val DISCRIMINANT: Int = 0
    }
  }

  /**
   * 'UnsatisfiedSignatureCondition' variant
   */
  public class UnsatisfiedSignatureCondition(
    private val unsatisfiedSignatureCondition: UnsatisfiedSignatureConditionFail
  ) : TransactionRejectionReason() {
    public companion object {
      public const val DISCRIMINANT: Int = 1
    }
  }

  /**
   * 'InstructionExecution' variant
   */
  public class InstructionExecution(
    private val instructionExecution: InstructionExecutionFail
  ) : TransactionRejectionReason() {
    public companion object {
      public const val DISCRIMINANT: Int = 2
    }
  }

  /**
   * 'SignatureVerification' variant
   */
  public class SignatureVerification(
    private val signatureVerification: SignatureVerificationFail
  ) : TransactionRejectionReason() {
    public companion object {
      public const val DISCRIMINANT: Int = 3
    }
  }

  /**
   * 'UnexpectedGenesisAccountSignature' variant
   */
  public class UnexpectedGenesisAccountSignature : TransactionRejectionReason() {
    public companion object {
      public const val DISCRIMINANT: Int = 4
    }
  }
}
