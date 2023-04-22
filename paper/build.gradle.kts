plugins {
    alias(libs.plugins.runpaper)
}

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly(projects.expressionsCommon)
    compileOnly(libs.paper.api)
    compileOnly(libs.miniplaceholders)
}

tasks {
    processResources {
        filesMatching("paper-plugin.yml") {
            expand("version" to project.version)
        }
    }
}
