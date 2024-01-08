package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

public final class ExprConcat implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("concat", this);
    }

    @Override
    public Tag apply(ArgumentQueue argumentQueue, Context context) {
        final StringBuilder s = new StringBuilder();
        while (argumentQueue.hasNext()) {
            s.append(Utils.parseToPlainText(context, argumentQueue.pop().value()));
        }
        return Tag.preProcessParsed(s.toString());
    }
}
