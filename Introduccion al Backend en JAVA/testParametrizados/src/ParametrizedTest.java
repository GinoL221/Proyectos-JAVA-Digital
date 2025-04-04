
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

public class ParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void checkValue(int number){
        Assertions.assertTrue(number > 0 && number < 5, "Number should be positive");
    }

    @ParameterizedTest
    @ValueSource(strings = {"java exercise","digital house","junit test"})
    public void checkContainsWhiteSpace(String argument){
        Assertions.assertTrue(StringUtils.containsWhitespace(argument));
    }
}
