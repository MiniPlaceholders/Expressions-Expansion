plugins {
    alias(libs.plugins.runpaper)
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
