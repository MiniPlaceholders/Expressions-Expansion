plugins {
    id("fabric-loom")
    alias(libs.plugins.shadow)
}

val shade: Configuration by configurations.creating

dependencies {
    implementation(projects.expressionsCommon)
    shade(projects.expressionsCommon)
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
    modImplementation(libs.adventure.platform.fabric)
    modImplementation(libs.snakeyaml)
    include(libs.snakeyaml)
}

tasks {
    processResources {
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
        archiveFileName.set("MiniPlaceholders-Expressions-Expansion-Fabric-${project.version}.jar")
        destinationDirectory.set(file("${rootProject.projectDir}/build"))
    }
    shadowJar {
        configurations = listOf(shade)
    }
}

java {
    withSourcesJar()
}
