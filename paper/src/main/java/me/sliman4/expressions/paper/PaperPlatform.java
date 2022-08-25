package me.sliman4.expressions.paper;

import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;

import java.util.Optional;
import java.util.UUID;

public class PaperPlatform implements Platform {
    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return Optional.ofNullable(Bukkit.getPlayer(name));
    }
}
