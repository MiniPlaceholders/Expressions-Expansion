package me.sliman4.expressions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class Utils {
    public static final String VERSION = "{version}";
    public static String parseToPlainText(Context context, String s) {
        Component result = context.deserialize(s);
        return PlainTextComponentSerializer.plainText().serialize(result);
    }

    public static double parseDouble(Context context, String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException exception) {
            throw context.newException("Not a number: `" + s + "`");
        }
    }

    public static int parseInt(Context context, String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw context.newException("Not a number: `" + s + "`");
        }
    }
}
