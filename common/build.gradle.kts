plugins {
    alias(libs.plugins.blossom)
}

dependencies {
    compileOnly(libs.bundles.minimessage)
    compileOnly(libs.snakeyaml)
    compileOnly(libs.miniplaceholders)
    testImplementation(libs.bundles.minimessage)
    testImplementation(libs.snakeyaml)
    testImplementation(libs.miniplaceholders)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
}

tasks {
    test {
        useJUnitPlatform()
    }
}

blossom {
    replaceToken("{version}", project.version)
    replaceTokenIn("src/main/java/me/sliman4/expressions/Utils.java")
}
