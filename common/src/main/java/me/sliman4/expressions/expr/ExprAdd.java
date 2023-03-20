package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprAdd implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("add", (queue, ctx) -> {
            double n = 0;
            boolean isFloat = false;
            while (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                if (s.contains(".")) {
                    isFloat = true;
                }
                n += Utils.parseDouble(ctx, s);
            }
            return Tag.selfClosingInserting(isFloat ? Component.text(n) : Component.text((int) Math.round(n)));
        });
    }
}
