package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ExprFloor implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("floor", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_floor> requires exactly 1 argument").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_floor> requires exactly 1 argument");
        }
        final double n = Utils.parseDouble(context, s);
        return Tag.preProcessParsed(Integer.toString((int) Math.floor(n)));
    }
}
