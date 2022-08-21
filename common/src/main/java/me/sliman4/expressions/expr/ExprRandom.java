
package me.sliman4.expressions.expr;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;

import java.util.Random;

public class ExprRandom implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("random", (queue, ctx) -> {
            double min, max, step;
            if (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                try {
                    min = Double.parseDouble(s);
                } catch (NumberFormatException exception) {
                    throw ctx.newException("Not a number: `" + s + "`");
                }
                if (!queue.hasNext()) {
                    throw ctx.newException("<expr_random> requires 0, 2 or 3 arguments");
                }
                String s2 = Utils.parseToPlainText(ctx, queue.pop().value());
                try {
                    max = Double.parseDouble(s2);
                } catch (NumberFormatException exception) {
                    throw ctx.newException("Not a number: `" + s2 + "`");
                }
                if (queue.hasNext()) {
                    String s3 = Utils.parseToPlainText(ctx, queue.pop().value());
                    try {
                        step = Double.parseDouble(s3);
                    } catch (NumberFormatException exception) {
                        throw ctx.newException("Not a number: `" + s3 + "`");
                    }
                } else {
                    step = 1.00;
                }
            } else {
                min = 0.00;
                max = 1.00;
                step = 0.01;
            }
            if (step == 0 || step > (max - min)) {
                throw ctx.newException("Invalid step");
            }
            boolean isFloat = (step % 1.00) != 0;
            int stepsAvailable = (int) ((max - min) / step);
            int steps = new Random().nextInt(stepsAvailable + 1);
            double result = min + (step * steps);
            return Tag.inserting(isFloat ? Component.text(result) : Component.text((int) Math.round(result)));
        });
    }
}
