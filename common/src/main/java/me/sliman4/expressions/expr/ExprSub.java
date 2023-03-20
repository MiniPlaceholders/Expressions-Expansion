
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprSub implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("sub", (queue, ctx) -> {
            boolean isFloat = false;
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_sub> requires exactly 2 arguments").value());
            String s2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_sub> requires exactly 2 arguments").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_sub> requires exactly 2 arguments");
            }

            if (s.contains(".") || s2.contains(".")) {
                isFloat = true;
            }
            double n = Utils.parseDouble(ctx, s);
            double n2 = Double.parseDouble(s2);

            return Tag.selfClosingInserting(isFloat ? Component.text(n - n2) : Component.text((int) Math.round(n - n2)));
        });
    }
}
