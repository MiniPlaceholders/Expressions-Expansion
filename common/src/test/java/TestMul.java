import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMul {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testMul() {
        Utils.assertExpands("<expr_mul:1:2>", "2");
        Utils.assertExpands("<expr_mul:1>", "1");
        Utils.assertExpands("<expr_mul>", "1");
        Utils.assertExpands("<expr_mul:1:2:3>", "6");
        Utils.assertExpands("<expr_mul:0:1:2:3:4:5>", "0");
        Utils.assertExpands("<expr_mul:-1:2.1>", "-2.1");
        Utils.assertExpands("<expr_mul:1:2.0>", "2.0");
    }
}
