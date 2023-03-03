
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.MiniPlaceholders;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Platform;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import java.util.NoSuchElementException;
import java.util.UUID;

public class ExprPlayer implements Expression {
    private final Platform platform;

    public ExprPlayer(Platform platform) {
        this.platform = platform;
    }

    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("player", (queue, ctx) -> {            
            String player = Utils.parseToPlainText(ctx, queue.popOr("<expr_player> requires exactly 2 arguments").value());
            String text = Utils.parseToPlainText(ctx, queue.popOr("<expr_player> requires exactly 2 arguments").value());

            if (queue.hasNext()) {
                throw ctx.newException("<expr_player> requires exactly 2 arguments");
            }

            Audience audience;
            try {
                UUID uuid = UUID.fromString(player);
                audience = platform.getPlayerByUniqueId(uuid).orElseThrow();
            } catch (IllegalArgumentException | NoSuchElementException exception) {
                audience = platform.getPlayerByName(player).orElse(null);
            }
            TagResolver placeholders = audience == null
                    ? MiniPlaceholders.getGlobalPlaceholders()
                    : MiniPlaceholders.getAudienceGlobalPlaceholders(audience);

            return Tag.inserting(MiniMessage.miniMessage().deserialize(text, placeholders));
        });
    }
}
