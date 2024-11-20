package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Permission

/**
 * Permission
 */
interface ModelPermission {
    fun asRaw(): Permission = Permission(this.javaClass.name, Json("KITA"))
}