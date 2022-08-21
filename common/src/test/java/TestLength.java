import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLength {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testLength() {
        Utils.assertExpands("<expr_length:hello>", String.valueOf("hello".length()));
        Utils.assertExpands("<expr_length:'hello world'>", String.valueOf("hello world".length()));
        Utils.assertExpands("<expr_length:>", "0");
    }
}
