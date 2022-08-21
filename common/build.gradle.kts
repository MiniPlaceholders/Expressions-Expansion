dependencies {
    compileOnly("net.kyori:adventure-text-minimessage:4.11.0")
    compileOnly("net.kyori:adventure-text-serializer-plain:4.11.0")
    compileOnly("org.yaml:snakeyaml:1.30")
    testImplementation("net.kyori:adventure-text-minimessage:4.11.0")
    testImplementation("net.kyori:adventure-text-serializer-plain:4.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.yaml:snakeyaml:1.30")
    testImplementation("com.github.4drian3d:MiniPlaceholders:1.1.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
