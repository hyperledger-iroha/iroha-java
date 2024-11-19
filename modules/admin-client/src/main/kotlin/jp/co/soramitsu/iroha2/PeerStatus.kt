package jp.co.soramitsu.iroha2

import java.time.Duration

/**
 * The status of a peer
 * @property peers The number of connected peers, except for the reporting peer itself
 * @property blocks The number of commited blocks
 * @property txs_accepted Total number of accepted transactions
 * @property txs_rejected Total number of rejected transactions
 * @property uptime Uptime with nanosecond precision since creation of the genesis block
 * @property view_changes The number of view changes in the current round
 */
data class PeerStatus(
    val peers: Int,
    val blocks: Long,
    val txs_approved: Long,
    val txs_rejected: Long,
    val uptime: Duration,
    val view_changes: Long,
    val queue_size: Long,
)
