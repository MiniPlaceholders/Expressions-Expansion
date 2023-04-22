package me.sliman4.expressions.fabric;

import me.sliman4.expressions.Expressions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class FabricMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("expressions-expansion");

    @Override
    public void onInitialize() {
        LOGGER.info("Starting Expressions Expansion for Fabric");

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            final FabricPlatform platform = new FabricPlatform(server);
            final Path dataFolder = FabricLoader.getInstance().getConfigDir().resolve("Expressions-Expansion");
            Expressions.initialize(dataFolder, getClass().getClassLoader().getResourceAsStream("config.yml"), platform);
        });
    }
}
