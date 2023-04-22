enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "expressions-parent"

listOf(
    "paper",
    "velocity",
    "krypton",
    "common"
).forEach {
    include("expressions-$it")
    project(":expressions-$it").projectDir = file(it)
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}
