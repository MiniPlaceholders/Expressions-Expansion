package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

public class ExprConcat implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("concat", (queue, ctx) -> {
            StringBuilder s = new StringBuilder();
            while (queue.hasNext()) {
                s.append(Utils.parseToPlainText(ctx, queue.pop().value()));
            }
            return Tag.selfClosingInserting(Component.text(s.toString()));
        });
    }
}
