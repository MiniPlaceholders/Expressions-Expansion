import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMin {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testMin() {
        Utils.assertExpands("<expr_min:10:5>", "5");
        Utils.assertExpands("<expr_min:5:2>", "2");
        Utils.assertExpands("<expr_min:0:4>", "0");
        Utils.assertExpands("<expr_min:5:0>", "0");
        Utils.assertExpands("<expr_min:5:-2>", "-2");
        Utils.assertExpands("<expr_min:5.6:1.2>", "1.2");
        Utils.assertExpands("<expr_min:-5:-2>", "-5");
    }
}
