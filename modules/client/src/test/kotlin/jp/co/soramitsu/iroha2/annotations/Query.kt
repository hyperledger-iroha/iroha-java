package jp.co.soramitsu.iroha2.annotations

import io.qameta.allure.LabelAnnotation
import java.lang.annotation.Inherited

@MustBeDocumented
@Inherited
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@LabelAnnotation(name = "query")
@Repeatable
annotation class Query(
    val value: String,
)
