import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIf {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testIf() {
        Utils.assertExpands("<expr_if:1:1:true:false>", "true");
        Utils.assertExpands("<expr_if:1:2:true:false>", "false");
        Utils.assertExpands("<expr_if:3.0:3.0:true:false>", "true");
        Utils.assertExpands("<expr_if:'<expr_add:1:1>':2:true:false>", "true");
    }
}
