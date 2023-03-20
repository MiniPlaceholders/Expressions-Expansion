plugins {
    java
    alias(libs.plugins.shadow)
}

allprojects {
    apply<JavaPlugin>()
}

dependencies {
    implementation(project(":expressions-velocity"))
    implementation(project(":expressions-paper"))
    implementation(project(":expressions-krypton"))
    implementation(project(":expressions-common"))
}

tasks {
    shadowJar {
        archiveFileName.set("Expressions-Expansion-${project.version}.jar")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
