repositories {
    mavenCentral()
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

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
