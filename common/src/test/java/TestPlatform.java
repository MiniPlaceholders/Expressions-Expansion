import me.sliman4.expressions.Platform;
import net.kyori.adventure.audience.Audience;

import java.util.Optional;
import java.util.UUID;

public class TestPlatform implements Platform {
    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return Optional.empty();
    }
}
