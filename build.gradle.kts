import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    java
    alias(libs.plugins.shadow)
}

tasks {
    clean {
        delete("jar")
    }
}

subprojects {
    apply<JavaPlugin>()
    apply<ShadowPlugin>()
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(25))

    tasks {
        withType<JavaCompile> {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(25)
        }
        val external = listOf("common", "fabric")
        if (!external.any { project.name.contains(it) }) {
            build {
                dependsOn(shadowJar)
            }
            shadowJar {
                val jarName = project.name
                    .replace("expressions-", "")
                    .capitalized()
                archiveFileName.set("ExpressionsProvider-$jarName-${project.version}.jar")
                archiveClassifier.set("")

                doLast {
                    copy {
                        from(archiveFile)
                        into("${rootProject.projectDir}/jar")
                    }
                }
                duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            }
        }
    }
}
