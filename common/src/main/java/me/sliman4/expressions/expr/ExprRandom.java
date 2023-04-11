
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.tag.Tag;

import java.security.SecureRandom;

public class ExprRandom implements Expression {
    private static final SecureRandom random = new SecureRandom();
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("random", (queue, ctx) -> {
            final double min, max, step;
            if (queue.hasNext()) {
                String s = Utils.parseToPlainText(ctx, queue.pop().value());
                min = Utils.parseDouble(ctx, s);
                String s2 = Utils.parseToPlainText(ctx, queue.popOr("<expr_random> requires 0, 2 or 3 arguments").value());
                max = Utils.parseDouble(ctx, s2);
                if (queue.hasNext()) {
                    String s3 = Utils.parseToPlainText(ctx, queue.pop().value());
                    step = Utils.parseDouble(ctx, s3);
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
            int steps = random.nextInt(stepsAvailable + 1);
            double result = min + (step * steps);

            final String value = isFloat
                    ? Double.toString(result)
                    : Integer.toString((int) Math.round(result));
            return Tag.preProcessParsed(value);
        });
    }
}
