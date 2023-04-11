package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprNeg implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("neg", (queue, ctx) -> {
            boolean isFloat = false;
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_neg> requires exactly 1 argument").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_neg> requires exactly 1 argument");
            }
            if (s.contains(".")) {
                isFloat = true;
            }
            double n = Utils.parseDouble(ctx, s);

            final String value = isFloat
                    ? Double.toString(-n)
                    : Integer.toString((int) Math.round(-n));
            return Tag.preProcessParsed(value);
        });
    }
}
