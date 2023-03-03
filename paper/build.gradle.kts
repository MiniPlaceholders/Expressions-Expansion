plugins {
    alias(libs.plugins.pluginyml)
    alias(libs.plugins.runpaper)
}

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly(project(":expressions-common"))
    compileOnly(libs.paper.api)
    compileOnly(libs.miniplaceholders)
}

val pluginVersion = version

bukkit {
    main = "me.sliman4.expressions.paper.PaperPlugin"
    apiVersion = "1.18"
    authors = listOf("Sliman4")
    depend = listOf("MiniPlaceholders")
    version = pluginVersion as String
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()

        options.release.set(17)
    }
}
