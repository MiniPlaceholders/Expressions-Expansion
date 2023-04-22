package me.sliman4.expressions.fabric;

import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;
import net.minecraft.server.MinecraftServer;

import java.util.Optional;
import java.util.UUID;

final class FabricPlatform implements Platform {
    private final MinecraftServer server;

    FabricPlatform(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return Optional.ofNullable(server.getPlayerList().getPlayer(uuid));
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return Optional.ofNullable(server.getPlayerList().getPlayerByName(name));
    }
}
