// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * _VersionedSignedQueryRequestV1
 *
 * Generated from 'iroha_data_model::query::_VersionedSignedQueryRequestV1' tuple structure
 */
public class _VersionedSignedQueryRequestV1(
  private val signedQueryRequest: SignedQueryRequest
) {
  public companion object CODEC : ScaleReader<_VersionedSignedQueryRequestV1>,
      ScaleWriter<_VersionedSignedQueryRequestV1> {
    public override fun read(reader: ScaleCodecReader): _VersionedSignedQueryRequestV1 =
        _VersionedSignedQueryRequestV1(SignedQueryRequest.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: _VersionedSignedQueryRequestV1):
        Unit {
      SignedQueryRequest.write(writer, instance.signedQueryRequest)
    }
  }
}
