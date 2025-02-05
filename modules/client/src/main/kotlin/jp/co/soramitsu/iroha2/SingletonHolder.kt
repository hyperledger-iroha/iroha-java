package jp.co.soramitsu.iroha2

open class SingletonHolder<out T : Any, in A>(
    private val creator: (A) -> T,
) {
    @Volatile
    private var instance: T? = null

    fun destroy() {
        instance = null
    }

    fun getInstance(arg: A): T {
        val checkInstance = instance
        if (checkInstance != null) {
            return checkInstance
        }

        return synchronized(this) {
            val checkInstanceAgain = instance
            if (checkInstanceAgain != null) {
                checkInstanceAgain
            } else {
                val created = creator(arg)
                instance = created
                created
            }
        }
    }
}
