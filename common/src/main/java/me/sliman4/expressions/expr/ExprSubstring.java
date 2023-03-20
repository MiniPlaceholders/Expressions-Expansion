
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
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
            int n = Utils.parseInt(ctx, s2);
            int n2 = Utils.parseInt(ctx, s3);
            return Tag.inserting(ctx.deserialize(s.substring(n, n2)));
        });
    }
}
