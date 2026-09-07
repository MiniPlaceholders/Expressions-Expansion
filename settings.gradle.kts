@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "expressions-provider"

dependencyResolutionManagement {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.quiltmc.org/repository/release/")
    }
}

listOf(
    "common",
    "paper",
    "velocity",
    "fabric",
    "sponge",
).forEach {
    include("expressions-$it")
    project(":expressions-$it").projectDir = file(it)
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("fabric-loom") version "1.17.20"
    id("org.spongepowered.gradle.plugin") version "2.3.0"
}
