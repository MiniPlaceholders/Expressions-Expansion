
package me.sliman4.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.Expression;
import me.sliman4.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

import java.security.SecureRandom;

public final class ExprRandom implements Expression {
    private static final SecureRandom random = new SecureRandom();
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("random", this);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final double min, max, step;
        if (argumentQueue.hasNext()) {
            final String s = Utils.parseToPlainText(context, argumentQueue.pop().value());
            min = Utils.parseDouble(context, s);
            final String s2 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_random> requires 0, 2 or 3 arguments").value());
            max = Utils.parseDouble(context, s2);
            if (argumentQueue.hasNext()) {
                final String s3 = Utils.parseToPlainText(context, argumentQueue.pop().value());
                step = Utils.parseDouble(context, s3);
            } else {
                step = 1.00;
            }
        } else {
            min = 0.00;
            max = 1.00;
            step = 0.01;
        }
        if (step == 0 || step > (max - min)) {
            throw context.newException("Invalid step");
        }
        final boolean isFloat = (step % 1.00) != 0;
        final int stepsAvailable = (int) ((max - min) / step);
        final int steps = random.nextInt(stepsAvailable + 1);
        final double result = min + (step * steps);

        final String value = isFloat
                ? Double.toString(result)
                : Integer.toString((int) Math.round(result));
        return Tag.preProcessParsed(value);
    }
}
