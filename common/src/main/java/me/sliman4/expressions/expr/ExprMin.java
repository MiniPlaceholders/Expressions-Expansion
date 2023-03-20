package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprMin implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("min", (queue, ctx) -> {
            double min;
            boolean isFloat = false;
            String s1 = Utils.parseToPlainText(ctx, queue.popOr("<expr_min> requires at least 1 argument").value());
            if (s1.contains(".")) {
                isFloat = true;
            }
            min = Utils.parseDouble(ctx, s1);
            while (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                if (s.contains(".")) {
                    isFloat = true;
                }
                min = Math.min(min, Utils.parseDouble(ctx, s));
            }
            return Tag.selfClosingInserting(isFloat ? Component.text(min) : Component.text((int) Math.round(min)));
        });
    }
}
