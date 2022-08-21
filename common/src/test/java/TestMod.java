import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMod {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testMod() {
        Utils.assertExpands("<expr_mod:5:2>", "1");
        Utils.assertExpands("<expr_mod:-5:3>", "-2");
        Utils.assertExpands("<expr_mod:0:1>", "0");
        Utils.assertExpands("<expr_mod:1:0>", "0");
    }
}
