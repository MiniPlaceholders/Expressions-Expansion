plugins {
    java
    alias(libs.plugins.shadow)
}

allprojects {
    apply<JavaPlugin>()
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    tasks.withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
}

dependencies {
    implementation(projects.expressionsCommon)
    implementation(projects.expressionsVelocity)
    implementation(projects.expressionsPaper)
    implementation(projects.expressionsSponge)
}

tasks {
    shadowJar {
        archiveFileName.set("Expressions-Expansion-${project.version}.jar")
        archiveClassifier.set("")
        doLast {
            copy {
                from(archiveFile)
                into("${rootProject.projectDir}/build")
            }
        }
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
