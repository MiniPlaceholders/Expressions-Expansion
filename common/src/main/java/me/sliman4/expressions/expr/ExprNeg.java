package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ExprNeg implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("neg", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_neg> requires exactly 1 argument").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_neg> requires exactly 1 argument");
        }

        final double n = Utils.parseDouble(context, s);
        final boolean isFloat = s.indexOf('.') != -1;

        final String value = isFloat
                ? Double.toString(-n)
                : Integer.toString((int) Math.round(-n));
        return Tag.preProcessParsed(value);
    }
}
