package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprDiv implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("div", (queue, ctx) -> {
            boolean isFloat = false;
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_div> requires exactly 2 arguments").value());
            String s2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_div> requires exactly 2 arguments").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_div> requires exactly 2 arguments");
            }
            double n, n2;
            try {
                n = Double.parseDouble(s);
            } catch (NumberFormatException exception) {
                throw ctx.newException("Not a number: `" + s + "`");
            }
            try {
                n2 = Double.parseDouble(s2);
            } catch (NumberFormatException exception) {
                throw ctx.newException("Not a number: `" + s2 + "`");
            }
            if(n2 == 0.0) {
                throw ctx.newException("Second argument of <expr_div> cannot be zero");
            }
            if (s.contains(".") || s2.contains(".") || (n / n2) - Math.floor(n / n2) > 0.001) {
                isFloat = true;
            }

            return Tag.inserting(isFloat ? Component.text(n / n2) : Component.text((int) Math.round(n / n2)));
        });
    }
}
