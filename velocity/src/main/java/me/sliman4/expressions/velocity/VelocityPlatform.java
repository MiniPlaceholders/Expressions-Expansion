package me.sliman4.expressions.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;

import java.util.Optional;
import java.util.UUID;

public class VelocityPlatform implements Platform {
    private final ProxyServer server;

    public VelocityPlatform(ProxyServer server) {
        this.server = server;
    }

    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return server.getPlayer(uuid).map(player -> player);
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return server.getPlayer(name).map(player -> player);
    }
}
