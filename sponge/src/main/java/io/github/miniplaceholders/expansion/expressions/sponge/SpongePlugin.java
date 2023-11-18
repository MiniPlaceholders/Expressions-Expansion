package io.github.miniplaceholders.expansion.expressions.sponge;

import com.google.inject.Inject;
import me.sliman4.expressions.Expressions;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

import java.nio.file.Path;

@Plugin("miniplaceholders-expressions-expansion")
public class SpongePlugin {
    @Inject
    private Logger logger;
    @Inject
    @ConfigDir(sharedRoot = false)
    private Path dataFolder;

    @Listener
    public void onServerStart(StartedEngineEvent<Server> event) {
        logger.info("Starting Expressions Expansion for Sponge");
        final Server server = event.engine();

        Expressions.initialize(dataFolder, getClass().getClassLoader().getResourceAsStream("config.yml"), new SpongePlatform(server));
    }
}
