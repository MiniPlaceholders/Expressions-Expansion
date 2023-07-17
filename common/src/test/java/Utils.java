import io.github.miniplaceholders.api.MiniPlaceholders;
import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Utils {
    private static final MethodHandle GET_EXPANSIONS;
    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final PlainTextComponentSerializer PLAIN_SERIALIZER = PlainTextComponentSerializer.plainText();

    static {
        try {
            final MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(MiniPlaceholders.class, MethodHandles.lookup());
            GET_EXPANSIONS = lookup.findStaticGetter(MiniPlaceholders.class, "expansions", Set.class);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public static void assertExpands(final String placeholderRequest, final String expectedResult) {
        final Component component = MINI_MESSAGE.deserialize(placeholderRequest, MiniPlaceholders.getGlobalPlaceholders());
        final String actualResult = PLAIN_SERIALIZER.serialize(component);

        assertEquals(expectedResult, actualResult, "Placeholder request: `%s`. Expected: `%s`, got: `%s`".formatted(placeholderRequest, expectedResult, actualResult));
    }

    public static void registerPlaceholders(final Configuration configuration) {
        try {
            final Set<?> expansions = (Set<?>) GET_EXPANSIONS.invoke();
            expansions.clear();
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
        Expressions.registerPlaceholders(configuration, new TestPlatform());
    }
}
