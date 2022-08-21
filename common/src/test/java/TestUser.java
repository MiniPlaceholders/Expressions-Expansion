import me.dreamerzero.miniplaceholders.api.MiniPlaceholders;
import me.sliman4.expressions.Configuration;
import me.sliman4.expressions.Expressions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUser {
    @BeforeEach
    public void init() {
        Configuration configuration = new Configuration();
        configuration.getUserExpressions().put("add_and_multiply", "<expr_add:'<arg1>':'<expr_mul:\\'<arg2>\\':\\'<arg3>\\'>'>");
        Utils.registerPlaceholders(configuration);
    }
    
    @Test
    public void testFloor() {
        Utils.assertExpands("<expr_user:add_and_multiply:2:3:4>", String.valueOf(2 + (3 * 4)));
    }
}
