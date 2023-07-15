package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public class ExprCeil implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("ceil", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_ceil> requires exactly 1 argument").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_ceil> requires exactly 1 argument");
        }
        double n = Utils.parseDouble(context, s);
        return Tag.selfClosingInserting(Component.text((int) Math.ceil(n)));
    }
}
