
package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprSubstring implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("substring", (queue, ctx) -> {
            String s = Utils.parseToPlainText(ctx, queue.popOr("<expr_substring> requires exactly 3 arguments").value());
            String s2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_substring> requires exactly 3 arguments").value());
            String s3 = Utils.parseToPlainText(ctx, queue.popOr("<expr_substring> requires exactly 3 arguments").value());
            if (queue.hasNext()) {
                throw ctx.newException("<expr_substring> requires exactly 3 arguments");
            }
            int n, n2;
            try {
                n = Integer.parseInt(s2);
            } catch (NumberFormatException exception) {
                throw ctx.newException("Not a number: `" + s2 + "`");
            }
            try {
                n2 = Integer.parseInt(s3);
            } catch (NumberFormatException exception) {
                throw ctx.newException("Not a number: `" + s3 + "`");
            }
            return Tag.inserting(Component.text(s.substring(n, n2)));
        });
    }
}
