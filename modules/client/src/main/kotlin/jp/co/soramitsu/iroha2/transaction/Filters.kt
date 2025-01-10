package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.asHashOf
import jp.co.soramitsu.iroha2.generated.AccountEventFilter
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionEventFilter
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetEventFilter
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.DataEventFilter
import jp.co.soramitsu.iroha2.generated.DomainEventFilter
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.ExecuteTriggerEventFilter
import jp.co.soramitsu.iroha2.generated.ExecutionTime
import jp.co.soramitsu.iroha2.generated.GenericPredicateBox
import jp.co.soramitsu.iroha2.generated.NonTrivial
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.PeerEventFilter
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.PipelineEventFilterBox
import jp.co.soramitsu.iroha2.generated.QueryOutputPredicate
import jp.co.soramitsu.iroha2.generated.RoleEventFilter
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.Schedule
import jp.co.soramitsu.iroha2.generated.StringPredicate
import jp.co.soramitsu.iroha2.generated.TimeEventFilter
import jp.co.soramitsu.iroha2.generated.TransactionEventFilter
import jp.co.soramitsu.iroha2.generated.TransactionStatus
import jp.co.soramitsu.iroha2.generated.TriggerEventFilter
import jp.co.soramitsu.iroha2.generated.TriggerId
import java.math.BigInteger

/**
 * Filters are used to filter out events
 */
@Suppress("unused")
object Filters {

    /**
     * Create a data filter
     */
    fun data(entityFilter: DataEventFilter) = EventFilterBox.Data(
        entityFilter,
    )

    /**
     * Create a [time based event filter][TimeEventFilter]
     */
    fun time(eventFilter: TimeEventFilter) = EventFilterBox.Time(eventFilter)

    /**
     * Execute a given trigger based on a specified [authority]
     */
    fun executeTrigger(
        triggerId: TriggerId,
        authority: AccountId,
    ) = EventFilterBox.ExecuteTrigger(
        ExecuteTriggerEventFilter(triggerId, authority),
    )

    /**
     * Create an event filter that matches events based on associated [hash], [blockHeight], [status],
     * or any combination of these.
     *
     * @see jp.co.soramitsu.iroha2.generated.TransactionStatus
     */
    fun pipelineTransaction(
        hash: ByteArray? = null,
        blockHeight: BigInteger? = null,
        status: TransactionStatus? = null,
    ) = EventFilterBox.Pipeline(
        PipelineEventFilterBox.Transaction(
            TransactionEventFilter(
                hash?.asHashOf(),
                blockHeight?.let { NonZeroOfu64(it) },
                status,
            ),
        ),
    )
}

/**
 * `EntityFilters` match events associated with a given entity
 * and either return all matching events or additionally apply another filter to them.
 */
object EntityFilters {

    /**
     * Match events associated with asset definition and apply another filter referenced by
     * its [id][OriginFilterOfAssetDefinitionEvent] or [event type][AssetDefinitionEventFilter]
     */
    fun byAssetDefinition(
        eventSet: Long,
        definitionId: AssetDefinitionId? = null,
    ) = DataEventFilter.AssetDefinition(
        AssetDefinitionEventFilter(definitionId, eventSet),
    )

    /**
     * Match events associated with accounts and apply another filter referenced by
     * its [id][OriginFilterOfAccountEvent] or [event type][AccountEventFilter]
     */
    fun byAccount(
        eventSet: Long,
        accountId: AccountId? = null,
    ) = DataEventFilter.Account(
        AccountEventFilter(accountId, eventSet),
    )

    /**
     * Match events associated with assets and apply another filter referenced by
     * its [id][FilterOptOfOriginFilterOfAssetEvent] or [event type][AssetEventFilter]
     */
    fun byAsset(
        eventSet: Long,
        assetId: AssetId? = null,
    ) = DataEventFilter.Asset(
        AssetEventFilter(assetId, eventSet),
    )

    /**
     * Match events associated with triggers and apply another filter referenced by
     * its [id][FilterOptOfOriginFilterOfTriggerEvent] or [event type][TriggerEventFilter]
     */
    fun byTrigger(
        eventSet: Long,
        triggerId: TriggerId? = null,
    ) = DataEventFilter.Trigger(
        TriggerEventFilter(triggerId, eventSet),
    )

    /**
     * Match events associated with domains and apply another filter referenced by
     * its [id][FilterOptOfOriginFilterOfDomainEvent] or [event type][DomainEventFilter]
     */
    fun byDomain(
        eventSet: Long,
        domainId: DomainId? = null,
    ) = DataEventFilter.Domain(
        DomainEventFilter(domainId, eventSet),
    )

    /**
     * Match events associated with peers and apply another filter referenced by
     * its [id][FilterOptOfOriginFilterOfPeerEvent] or [event type][PeerEventFilter]
     */
    fun byPeer(
        eventSet: Long,
        peerId: PeerId? = null,
    ) = DataEventFilter.Peer(
        PeerEventFilter(peerId, eventSet),
    )

    /**
     * Match events associated with roles and apply another filter referenced by
     * its [id][FilterOptOriginFilterRoleEvent] or [event type][RoleEventFilter]
     */
    fun byRole(
        eventSet: Long,
        roleId: RoleId? = null,
    ) = DataEventFilter.Role(
        RoleEventFilter(roleId, eventSet),
    )
}

/**
 * Timed filters
 */
object EventFilters {

    /**
     * Create a filter with a timed execution
     */
    fun timeEventFilter(
        start: BigInteger,
        period: BigInteger? = null,
    ) = TimeEventFilter(ExecutionTime.Schedule(Schedule(start, period)))

    /**
     * Create a pre-commit filter
     */
    fun timeEventFilter() = TimeEventFilter(ExecutionTime.PreCommit())
}

/**
 * Query filters
 */
object QueryFilters {

    /**
     * Starts with filter
     */
    fun startsWith(prefix: String) = GenericPredicateBox.Raw(
        QueryOutputPredicate.Identifiable(StringPredicate.StartsWith(prefix)),
    )

    /**
     * Ends with filter
     */
    fun endsWith(suffix: String) = GenericPredicateBox.Raw(
        QueryOutputPredicate.Identifiable(StringPredicate.EndsWith(suffix)),
    )

    /**
     * Contains filter
     */
    fun contains(value: String) = GenericPredicateBox.Raw(
        QueryOutputPredicate.Identifiable(StringPredicate.Contains(value)),
    )

    /**
     * Is filter
     */
    fun `is`(value: String) = GenericPredicateBox.Raw(
        QueryOutputPredicate.Identifiable(StringPredicate.Is(value)),
    )

    /**
     * Filter for multiple matches (OR)
     */
    fun or(vararg predicates: StringPredicate) = predicates
        .map { GenericPredicateBox.Raw(QueryOutputPredicate.Identifiable(it)) }.toList()
        .let { NonTrivial<GenericPredicateBox<QueryOutputPredicate>>(it) }
        .let { GenericPredicateBox.Or(it) }

    /**
     * Filter for multiple matches (AND)
     */
    fun and(vararg predicates: StringPredicate) = predicates
        .map { GenericPredicateBox.Raw(QueryOutputPredicate.Identifiable(it)) }.toList()
        .let { NonTrivial<GenericPredicateBox<QueryOutputPredicate>>(it) }
        .let { GenericPredicateBox.And(it) }
}
