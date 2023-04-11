package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprMax implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("max", (queue, ctx) -> {
            double max;
            boolean isFloat = false;
            String s1 = Utils.parseToPlainText(ctx, queue.popOr("<expr_max> requires at least 1 argument").value());
            if (s1.contains(".")) {
                isFloat = true;
            }
            max = Utils.parseDouble(ctx, s1);
            while (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                if (s.contains(".")) {
                    isFloat = true;
                }
                max = Math.max(max, Utils.parseDouble(ctx, s));
            }
            final String value = isFloat
                    ? Double.toString(max)
                    : Integer.toString((int) Math.round(max));
            return Tag.preProcessParsed(value);
        });
    }
}
