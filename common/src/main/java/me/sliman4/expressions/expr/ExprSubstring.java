
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ExprSubstring implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("substring", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_substring> requires exactly 3 arguments").value());
        final String s2 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_substring> requires exactly 3 arguments").value());
        final String s3 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_substring> requires exactly 3 arguments").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_substring> requires exactly 3 arguments");
        }
        final int n = Utils.parseInt(context, s2);
        final int n2 = Utils.parseInt(context, s3);
        return Tag.preProcessParsed(s.substring(n, n2));
    }
}
