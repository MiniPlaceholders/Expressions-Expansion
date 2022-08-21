import me.sliman4.expressions.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdd {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }
    
    @Test
    public void testAdd() {
        Utils.assertExpands("<expr_add:1:2>", "3");
        Utils.assertExpands("<expr_add:1>", "1");
        Utils.assertExpands("<expr_add>", "0");
        Utils.assertExpands("<expr_add:1:2:3:4:5>", "15");
        Utils.assertExpands("<expr_add:1:2.1>", "3.1");
        Utils.assertExpands("<expr_add:1:2.0>", "3.0");
        Utils.assertExpands("<expr_add:3:-1>", "2");
    }
}
