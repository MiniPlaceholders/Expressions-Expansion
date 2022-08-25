package me.sliman4.expressions.paper;

import me.sliman4.expressions.Expressions;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting Expressions Expansion for Paper");

        Expressions.initialize(getDataFolder(), getResource("config.yml"), new PaperPlatform());
    }
}
