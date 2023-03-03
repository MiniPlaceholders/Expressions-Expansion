package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprMul implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("mul", (queue, ctx) -> {
            double n = 1;
            boolean isFloat = false;
            while (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                try {
                    if (s.contains(".")) {
                        isFloat = true;
                    }
                    n *= Double.parseDouble(s);
                } catch (NumberFormatException exception) {
                    throw ctx.newException("Not a number: `" + s + "`");
                }
            }
            return Tag.inserting(isFloat ? Component.text(n) : Component.text((int) Math.round(n)));
        });
    }
}
