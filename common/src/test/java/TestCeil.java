import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCeil {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testCeil() {
        Utils.assertExpands("<expr_ceil:1.1>", "2");
        Utils.assertExpands("<expr_ceil:5.93>", "6");
        Utils.assertExpands("<expr_ceil:-2>", "-2");
    }
}
