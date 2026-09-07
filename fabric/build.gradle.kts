plugins {
    id("net.fabricmc.fabric-loom")
    alias(libs.plugins.shadow)
}

val shade: Configuration by configurations.creating

dependencies {
    implementation(projects.expressionsCommon)
    shade(projects.expressionsCommon)
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(libs.fabric.api)
    implementation(libs.adventure.platform.fabric)
}

tasks {
    processResources {
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
    shadowJar {
        configurations = listOf(shade)
        archiveFileName.set("ExpressionsProvider-Fabric-${project.version}.jar")
        destinationDirectory.set(file("${rootDir}/jar"))
    }
}

java {
    withSourcesJar()
}
