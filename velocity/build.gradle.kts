repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly(project(":expressions-common"))
    compileOnly(libs.velocity.api)
    compileOnly(libs.miniplaceholders)
    annotationProcessor(libs.velocity.api)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
