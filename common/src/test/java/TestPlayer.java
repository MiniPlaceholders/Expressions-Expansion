import me.sliman4.expressions.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayer {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }
    
    @Test
    public void testGlobalPlaceholders() {
        Utils.assertExpands("<expr_player:Sliman4:'<expr_add:1:2>'>", "3");
        Utils.assertExpands("<expr_player:71f04c4c-47af-42fa-a27c-246a141e8326:'<expr_add:1:2>'>", "3");
    }
}
