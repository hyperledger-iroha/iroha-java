package jp.co.soramitsu.iroha2.annotations

import io.qameta.allure.LabelAnnotation
import java.lang.annotation.Inherited

@MustBeDocumented
@Inherited
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@LabelAnnotation(name = "sdk_test_id")
@Repeatable
annotation class SdkTestId(
    val value: String,
)
