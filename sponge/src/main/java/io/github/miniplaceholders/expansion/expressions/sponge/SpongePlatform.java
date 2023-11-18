package io.github.miniplaceholders.expansion.expressions.sponge;

import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;
import org.spongepowered.api.Server;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public record SpongePlatform(Server server) implements Platform {
    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return server.player(uuid).map(Function.identity());
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return server.player(name).map(Function.identity());
    }
}
