plugins {
    java
    alias(libs.plugins.shadow)
}

allprojects {
    apply(plugin = "java")
    group = "me.sliman4.expressions"
    version = "1.0.0"
    description = "Expressions-Expansion"
}

dependencies {
    shadow(project(":expressions-velocity"))
    shadow(project(":expressions-paper"))
    shadow(project(":expressions-krypton"))
    shadow(project(":expressions-common"))
}

tasks {
    shadowJar {
        archiveFileName.set("Expressions-Expansion.jar")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        configurations = listOf(project.configurations.shadow.get())
    }
    build {
        dependsOn(shadowJar)
    }
}
