
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprRound implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("round", (queue, ctx) -> {
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_round> requires exactly 1 argument").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_round> requires exactly 1 argument");
            }
            final double n = Utils.parseDouble(ctx, s);
            return Tag.preProcessParsed(Integer.toString((int) Math.round(n)));
        });
    }
}
