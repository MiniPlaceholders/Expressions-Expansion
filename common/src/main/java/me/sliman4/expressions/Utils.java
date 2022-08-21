package me.sliman4.expressions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class Utils {
    public static String parseToPlainText(Context context, String s) {
        Component result = context.deserialize(s);
        return PlainTextComponentSerializer.plainText().serialize(result);
    }
}
