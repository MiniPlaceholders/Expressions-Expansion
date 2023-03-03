repositories {
    maven("https://repo.kryptonmc.org/releases")
}

dependencies {
    compileOnly(project(":expressions-common"))
    compileOnly(libs.krypton.api)
    compileOnly(libs.miniplaceholders)
    annotationProcessor(libs.krypton.annotation.processor)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))