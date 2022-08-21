import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSubstring {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testSubstring() {
        Utils.assertExpands("<expr_substring:hello:0:5>", "hello".substring(0, 5));
        Utils.assertExpands("<expr_substring:hello:1:4>", "hello".substring(1, 4));
        Utils.assertExpands("<expr_substring:hello:2:2>", "hello".substring(2, 2));
        Utils.assertExpands("<expr_substring:hello:1:3>", "hello".substring(1, 3));
    }
}
