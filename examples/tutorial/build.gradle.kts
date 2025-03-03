val ktorVer = project.properties["ktorVer"] as String

dependencies {
    implementation(project(":admin-client"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("io.ktor:ktor-client-logging:$ktorVer")
}

tasks.jacocoTestReport {
    mustRunAfter(":admin-client:jacocoTestReport")
    mustRunAfter(":block:jacocoTestReport")
    mustRunAfter(":client:jacocoTestReport")
    mustRunAfter(":codegen:jacocoTestReport")
    mustRunAfter(":model:jacocoTestReport")
    mustRunAfter(":test-tools:jacocoTestReport")
}
