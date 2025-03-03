package jp.co.soramitsu.iroha2.annotations

import io.qameta.allure.LabelAnnotation
import java.lang.annotation.Inherited

@MustBeDocumented
@Inherited
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@LabelAnnotation(name = "permission")
@Repeatable
annotation class Permission(
    val value: String,
)
