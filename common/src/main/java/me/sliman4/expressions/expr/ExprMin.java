package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ExprMin implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("min", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String s1 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_min> requires at least 1 argument").value());
        boolean isFloat = s1.indexOf('.') != -1;
        double min = Utils.parseDouble(context, s1);
        while (argumentQueue.hasNext()) {
            String s = Utils.parseToPlainText(context, argumentQueue.pop().value());
            if (s.indexOf('.') != -1) {
                isFloat = true;
            }
            min = Math.min(min, Utils.parseDouble(context, s));
        }
        final String value = isFloat
                ? Double.toString(min)
                : Integer.toString((int) Math.round(min));
        return Tag.preProcessParsed(value);
    }
}
