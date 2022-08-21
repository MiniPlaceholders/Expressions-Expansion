import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFormat {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testFormat() {
        Utils.assertExpands("<expr_format:'hello %s':world>", "hello world");
        Utils.assertExpands("<expr_format:'I have %02d diamonds':5>", "I have 05 diamonds");
        Utils.assertExpands("<expr_format:'I have %d diamonds, %d apples and %d diamond swords named `%s`':5:10:2:MySword>", "I have 5 diamonds, 10 apples and 2 diamond swords named `MySword`");
    }
}
