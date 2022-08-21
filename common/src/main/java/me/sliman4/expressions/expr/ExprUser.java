
package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public class ExprUser implements Expression {
    private final Configuration config;

    public ExprUser(Configuration config) {
        this.config = config;
    }

    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("user", (queue, ctx) -> {
            String expressionName = Utils.parseToPlainText(ctx, queue.popOr("<expr_user> requires at least 1 argument").value());
            TagResolver.Builder resolverBuilder = TagResolver.builder();
            int i = 1;
            while (queue.hasNext()) {
                resolverBuilder.resolver(Placeholder.parsed("arg" + i, Utils.parseToPlainText(ctx, queue.pop().value())));
                i++;
            }
            String expression = config.getUserExpressions().get(expressionName);
            return Tag.inserting(ctx.deserialize(expression, resolverBuilder.build()));
        });
    }
}
