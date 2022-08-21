package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprCeil implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("ceil", (queue, ctx) -> {
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_ceil> requires exactly 1 argument").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_ceil> requires exactly 1 argument");
            }
            try {
                double n = Double.parseDouble(s);
                return Tag.inserting(Component.text((int) Math.ceil(n)));
            } catch (NumberFormatException exception) {
                throw ctx.newException("Not a number: `" + s + "`");
            }
        });
    }
}
