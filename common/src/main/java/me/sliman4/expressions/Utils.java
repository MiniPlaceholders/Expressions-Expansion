package me.sliman4.expressions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public final class Utils {
    private Utils() {}
    public static String parseToPlainText(final Context context, final String s) {
        final Component result = context.deserialize(s);
        return PlainTextComponentSerializer.plainText().serialize(result);
    }

    public static double parseDouble(final Context context, final String s) {
        try {
            return Double.parseDouble(s);
        } catch (final NumberFormatException exception) {
            throw context.newException("Not a number: `" + s + "`");
        }
    }

    public static int parseInt(final Context context, final String s) {
        try {
            return Integer.parseInt(s);
        } catch (final NumberFormatException exception) {
            throw context.newException("Not a number: `" + s + "`");
        }
    }
}
