import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestConcat {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testConcat() {
        Utils.assertExpands("<expr_concat:hello:world>", "helloworld");
        Utils.assertExpands("<expr_concat:a:b:c:d>", "abcd");
        Utils.assertExpands("<expr_concat:3:-1>", "3-1");
        Utils.assertExpands("<expr_concat>", "");
    }
}
