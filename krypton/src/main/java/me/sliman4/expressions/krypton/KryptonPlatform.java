package me.sliman4.expressions.krypton;

import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;
import org.kryptonmc.api.Server;

import java.util.Optional;
import java.util.UUID;

public class KryptonPlatform implements Platform {
    private final Server server;

    public KryptonPlatform(Server server) {
        this.server = server;
    }

    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return Optional.ofNullable(server.player(uuid));
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return Optional.ofNullable(server.player(name));
    }
}
