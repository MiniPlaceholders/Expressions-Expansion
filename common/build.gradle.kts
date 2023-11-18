plugins {
    alias(libs.plugins.idea.ext)
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

sourceSets {
    main {
        blossom {
            javaSources {
                property("version", project.version.toString())
            }
        }
    }
}
