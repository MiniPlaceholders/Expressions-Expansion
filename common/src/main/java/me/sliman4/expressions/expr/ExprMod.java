package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprMod implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("mod", (queue, ctx) -> {
            boolean isFloat = false;
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_mod> requires exactly 2 arguments").value());
            String s2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_mod> requires exactly 2 arguments").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_mod> requires exactly 2 arguments");
            }
            double n = Utils.parseDouble(ctx, s);
            double n2 = Utils.parseDouble(ctx, s2);

            if (s.contains(".") || s2.contains(".")) {
                isFloat = true;
            }
            final String value = isFloat
                    ? Double.toString(n % n2)
                    : Integer.toString((int) Math.round(n % n2));

            return Tag.preProcessParsed(value);
        });
    }
}
