package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.ParsingException;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprIf implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("if", (queue, ctx) -> {
            String o1 = Utils.parseToPlainText(ctx, queue.popOr("<expr_if> requires 3 or 4 arguments").value());
            String o2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_if> requires 3 or 4 arguments").value());
            String p1 = queue.popOr("<expr_if> requires 3 or 4 arguments").value();
            String p2;
            try {
                p2 = queue.pop().value();
            } catch (ParsingException exception) {
                p2 = "";
            }
            return Tag.inserting(ctx.deserialize(o1.equals(o2) ? p1 : p2));
        });
    }
}
