import me.dreamerzero.miniplaceholders.api.Expansion;
import me.dreamerzero.miniplaceholders.api.MiniPlaceholders;
import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Utils {
    public static void assertExpands(String placeholderRequest, String expectedResult) {
        Component component = MiniMessage.miniMessage().deserialize(placeholderRequest, MiniPlaceholders.getGlobalPlaceholders());
        String actualResult = PlainTextComponentSerializer.plainText().serialize(component);
        assertEquals(expectedResult, actualResult, String.format("Placeholder request: `%s`. Expected: `%s`, got: `%s`", placeholderRequest, expectedResult, actualResult));
    }

    public static void registerPlaceholders(Configuration configuration) {
        try {
            Field field = MiniPlaceholders.class.getDeclaredField("expansions");
            field.setAccessible(true);
            Set<Expansion> expansions = (Set<Expansion>) field.get(null);
            expansions.clear();
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        Expressions.registerPlaceholders(configuration);
    }
}
