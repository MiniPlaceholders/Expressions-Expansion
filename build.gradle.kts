plugins {
	java
    id("com.github.johnrengelman.shadow") version "7.1.2"
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
    shadow(project(":expressions-common"))
}

subprojects {
    repositories {
		mavenCentral()
        maven("https://jitpack.io")
        maven("https://papermc.io/repo/repository/maven-public/")
    }
	
	dependencies {
		compileOnly("com.github.4drian3d:MiniPlaceholders:1.1.1")
	}
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
