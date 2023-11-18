import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    id("org.spongepowered.gradle.plugin")
}

dependencies {
    compileOnly(projects.expressionsCommon)
    compileOnly(libs.miniplaceholders)
}

sponge {
    apiVersion("10.0.0")
    license("GPL-3")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("miniplaceholders-expressions-expansion") {
        displayName("MiniPlaceholders-Expressions-Expansion")
        entrypoint("io.github.miniplaceholders.expansion.expressions.sponge.SpongePlugin")
        description(project.description)
        links {
            homepage("https://github.com/MiniPlaceholders/Expressions-Expansion")
            source("https://github.com/MiniPlaceholders/Expressions-Expansion")
            issues("https://github.com/MiniPlaceholders/Expressions-Expansion/issues")
        }
        contributor("4drian3d") {
            description("Lead Developer")
        }
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}