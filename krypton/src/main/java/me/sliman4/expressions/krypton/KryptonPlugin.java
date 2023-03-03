package me.sliman4.expressions.krypton;

import com.google.inject.Inject;
import me.sliman4.expressions.Expressions;
import me.sliman4.expressions.Platform;
import org.apache.logging.log4j.Logger;
import org.kryptonmc.api.Server;
import org.kryptonmc.api.event.Listener;
import org.kryptonmc.api.event.server.ServerStartEvent;
import org.kryptonmc.api.plugin.annotation.DataFolder;
import org.kryptonmc.api.plugin.annotation.Dependency;
import org.kryptonmc.api.plugin.annotation.Plugin;

import java.nio.file.Path;

@Plugin(
        name = "Expressions-Expansion",
        id = "expressionsexpansion",
        version = "1.0.0",
        authors = {"Sliman4"},
        dependencies = {
                @Dependency(id = "miniplaceholders")
        }
)
public final class KryptonPlugin {
    private final Logger logger;
    private final Path dataFolder;
    private final Platform platform;

    @Inject
    public KryptonPlugin(Logger logger, Server server, @DataFolder final Path dataFolder) {
        this.logger = logger;
        this.dataFolder = dataFolder;
        this.platform = new KryptonPlatform(server);
    }

    @Listener
    public void onProxyInitialize(ServerStartEvent event) {
        logger.info("Starting Expressions Expansion for Krypton");

        Expressions.initialize(dataFolder, getClass().getClassLoader().getResourceAsStream("config.yml"), platform);
    }
}
