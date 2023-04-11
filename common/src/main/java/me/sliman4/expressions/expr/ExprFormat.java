package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

import java.util.ArrayList;
import java.util.List;

public class ExprFormat implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("format", (queue, ctx) -> {
            String format = Utils.parseToPlainText(ctx, queue.popOr("<expr_format> requires at least 1 argument").value());
            List<Object> arguments = new ArrayList<>();
            while (queue.hasNext()) {
                String argument = Utils.parseToPlainText(ctx, queue.pop().value());
                try {
                    arguments.add(Integer.parseInt(argument));
                } catch (NumberFormatException exception1) {
                    try {
                        arguments.add(Double.parseDouble(argument));
                    } catch (NumberFormatException exception2) {
                        arguments.add(argument);
                    }
                }
            }
            return Tag.preProcessParsed(String.format(format, arguments.toArray(Object[]::new)));
        });
    }
}
