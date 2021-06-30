// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * QueryBox
 *
 * Generated from 'iroha_data_model::query::QueryBox' enum
 */
public abstract class QueryBox {
  /**
   * 'FindAllAccounts' variant
   */
  public class FindAllAccounts(
    private val findAllAccounts:
        jp.co.soramitsu.schema.generated.datamodel.query.account.FindAllAccounts
  ) : QueryBox(), ScaleReader<FindAllAccounts>, ScaleWriter<FindAllAccounts> {
    public override fun read(reader: ScaleCodecReader): FindAllAccounts {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAllAccounts): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 0
    }
  }

  /**
   * 'FindAccountById' variant
   */
  public class FindAccountById(
    private val findAccountById:
        jp.co.soramitsu.schema.generated.datamodel.query.account.FindAccountById
  ) : QueryBox(), ScaleReader<FindAccountById>, ScaleWriter<FindAccountById> {
    public override fun read(reader: ScaleCodecReader): FindAccountById {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountById): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 1
    }
  }

  /**
   * 'FindAccountKeyValueByIdAndKey' variant
   */
  public class FindAccountKeyValueByIdAndKey(
    private val findAccountKeyValueByIdAndKey:
        jp.co.soramitsu.schema.generated.datamodel.query.account.FindAccountKeyValueByIdAndKey
  ) : QueryBox(), ScaleReader<FindAccountKeyValueByIdAndKey>,
      ScaleWriter<FindAccountKeyValueByIdAndKey> {
    public override fun read(reader: ScaleCodecReader): FindAccountKeyValueByIdAndKey {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountKeyValueByIdAndKey):
        Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 2
    }
  }

  /**
   * 'FindAccountsByName' variant
   */
  public class FindAccountsByName(
    private val findAccountsByName:
        jp.co.soramitsu.schema.generated.datamodel.query.account.FindAccountsByName
  ) : QueryBox(), ScaleReader<FindAccountsByName>, ScaleWriter<FindAccountsByName> {
    public override fun read(reader: ScaleCodecReader): FindAccountsByName {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByName): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 3
    }
  }

  /**
   * 'FindAccountsByDomainName' variant
   */
  public class FindAccountsByDomainName(
    private val findAccountsByDomainName:
        jp.co.soramitsu.schema.generated.datamodel.query.account.FindAccountsByDomainName
  ) : QueryBox(), ScaleReader<FindAccountsByDomainName>, ScaleWriter<FindAccountsByDomainName> {
    public override fun read(reader: ScaleCodecReader): FindAccountsByDomainName {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountsByDomainName): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 4
    }
  }

  /**
   * 'FindAllAssets' variant
   */
  public class FindAllAssets(
    private val findAllAssets: jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAllAssets
  ) : QueryBox(), ScaleReader<FindAllAssets>, ScaleWriter<FindAllAssets> {
    public override fun read(reader: ScaleCodecReader): FindAllAssets {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAllAssets): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 5
    }
  }

  /**
   * 'FindAllAssetsDefinitions' variant
   */
  public class FindAllAssetsDefinitions(
    private val findAllAssetsDefinitions:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAllAssetsDefinitions
  ) : QueryBox(), ScaleReader<FindAllAssetsDefinitions>, ScaleWriter<FindAllAssetsDefinitions> {
    public override fun read(reader: ScaleCodecReader): FindAllAssetsDefinitions {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAllAssetsDefinitions): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 6
    }
  }

  /**
   * 'FindAssetById' variant
   */
  public class FindAssetById(
    private val findAssetById: jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetById
  ) : QueryBox(), ScaleReader<FindAssetById>, ScaleWriter<FindAssetById> {
    public override fun read(reader: ScaleCodecReader): FindAssetById {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetById): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 7
    }
  }

  /**
   * 'FindAssetsByName' variant
   */
  public class FindAssetsByName(
    private val findAssetsByName:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByName
  ) : QueryBox(), ScaleReader<FindAssetsByName>, ScaleWriter<FindAssetsByName> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByName {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByName): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 8
    }
  }

  /**
   * 'FindAssetsByAccountId' variant
   */
  public class FindAssetsByAccountId(
    private val findAssetsByAccountId:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByAccountId
  ) : QueryBox(), ScaleReader<FindAssetsByAccountId>, ScaleWriter<FindAssetsByAccountId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByAccountId {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAccountId): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 9
    }
  }

  /**
   * 'FindAssetsByAssetDefinitionId' variant
   */
  public class FindAssetsByAssetDefinitionId(
    private val findAssetsByAssetDefinitionId:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByAssetDefinitionId
  ) : QueryBox(), ScaleReader<FindAssetsByAssetDefinitionId>,
      ScaleWriter<FindAssetsByAssetDefinitionId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByAssetDefinitionId {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByAssetDefinitionId):
        Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 10
    }
  }

  /**
   * 'FindAssetsByDomainName' variant
   */
  public class FindAssetsByDomainName(
    private val findAssetsByDomainName:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByDomainName
  ) : QueryBox(), ScaleReader<FindAssetsByDomainName>, ScaleWriter<FindAssetsByDomainName> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByDomainName {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByDomainName): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 11
    }
  }

  /**
   * 'FindAssetsByAccountIdAndAssetDefinitionId' variant
   */
  public class FindAssetsByAccountIdAndAssetDefinitionId(
    private val findAssetsByAccountIdAndAssetDefinitionId:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByAccountIdAndAssetDefinitionId
  ) : QueryBox(), ScaleReader<FindAssetsByAccountIdAndAssetDefinitionId>,
      ScaleWriter<FindAssetsByAccountIdAndAssetDefinitionId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByAccountIdAndAssetDefinitionId {
    }

    public override fun write(writer: ScaleCodecWriter,
        instance: FindAssetsByAccountIdAndAssetDefinitionId): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 12
    }
  }

  /**
   * 'FindAssetsByDomainNameAndAssetDefinitionId' variant
   */
  public class FindAssetsByDomainNameAndAssetDefinitionId(
    private val findAssetsByDomainNameAndAssetDefinitionId:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetsByDomainNameAndAssetDefinitionId
  ) : QueryBox(), ScaleReader<FindAssetsByDomainNameAndAssetDefinitionId>,
      ScaleWriter<FindAssetsByDomainNameAndAssetDefinitionId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByDomainNameAndAssetDefinitionId {
    }

    public override fun write(writer: ScaleCodecWriter,
        instance: FindAssetsByDomainNameAndAssetDefinitionId): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 13
    }
  }

  /**
   * 'FindAssetQuantityById' variant
   */
  public class FindAssetQuantityById(
    private val findAssetQuantityById:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetQuantityById
  ) : QueryBox(), ScaleReader<FindAssetQuantityById>, ScaleWriter<FindAssetQuantityById> {
    public override fun read(reader: ScaleCodecReader): FindAssetQuantityById {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetQuantityById): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 14
    }
  }

  /**
   * 'FindAssetKeyValueByIdAndKey' variant
   */
  public class FindAssetKeyValueByIdAndKey(
    private val findAssetKeyValueByIdAndKey:
        jp.co.soramitsu.schema.generated.datamodel.query.asset.FindAssetKeyValueByIdAndKey
  ) : QueryBox(), ScaleReader<FindAssetKeyValueByIdAndKey>, ScaleWriter<FindAssetKeyValueByIdAndKey>
      {
    public override fun read(reader: ScaleCodecReader): FindAssetKeyValueByIdAndKey {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetKeyValueByIdAndKey):
        Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 15
    }
  }

  /**
   * 'FindAllDomains' variant
   */
  public class FindAllDomains(
    private val findAllDomains:
        jp.co.soramitsu.schema.generated.datamodel.query.domain.FindAllDomains
  ) : QueryBox(), ScaleReader<FindAllDomains>, ScaleWriter<FindAllDomains> {
    public override fun read(reader: ScaleCodecReader): FindAllDomains {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAllDomains): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 16
    }
  }

  /**
   * 'FindDomainByName' variant
   */
  public class FindDomainByName(
    private val findDomainByName:
        jp.co.soramitsu.schema.generated.datamodel.query.domain.FindDomainByName
  ) : QueryBox(), ScaleReader<FindDomainByName>, ScaleWriter<FindDomainByName> {
    public override fun read(reader: ScaleCodecReader): FindDomainByName {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindDomainByName): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 17
    }
  }

  /**
   * 'FindAllPeers' variant
   */
  public class FindAllPeers(
    private val findAllPeers: jp.co.soramitsu.schema.generated.datamodel.query.peer.FindAllPeers
  ) : QueryBox(), ScaleReader<FindAllPeers>, ScaleWriter<FindAllPeers> {
    public override fun read(reader: ScaleCodecReader): FindAllPeers {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindAllPeers): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 18
    }
  }

  /**
   * 'FindTransactionsByAccountId' variant
   */
  public class FindTransactionsByAccountId(
    private val findTransactionsByAccountId:
        jp.co.soramitsu.schema.generated.datamodel.query.transaction.FindTransactionsByAccountId
  ) : QueryBox(), ScaleReader<FindTransactionsByAccountId>, ScaleWriter<FindTransactionsByAccountId>
      {
    public override fun read(reader: ScaleCodecReader): FindTransactionsByAccountId {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindTransactionsByAccountId):
        Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 19
    }
  }

  /**
   * 'FindPermissionTokensByAccountId' variant
   */
  public class FindPermissionTokensByAccountId(
    private val findPermissionTokensByAccountId:
        jp.co.soramitsu.schema.generated.datamodel.query.permissions.FindPermissionTokensByAccountId
  ) : QueryBox(), ScaleReader<FindPermissionTokensByAccountId>,
      ScaleWriter<FindPermissionTokensByAccountId> {
    public override fun read(reader: ScaleCodecReader): FindPermissionTokensByAccountId {
    }

    public override fun write(writer: ScaleCodecWriter, instance: FindPermissionTokensByAccountId):
        Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 20
    }
  }
}
