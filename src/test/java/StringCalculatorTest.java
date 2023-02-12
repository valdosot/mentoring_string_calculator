import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void shouldReturnZeroWhenInputIsEmptyString() {

        Integer actual = stringCalculator.add("");

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void shouldReturnOneWhenInputIsNumberOne() {

        Integer actual = stringCalculator.add("1");

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void shouldReturnThreeWhenInputIsOneAndTwo() {

        Integer actual = stringCalculator.add("1,2");

        assertThat(actual).isEqualTo(3);
    }
}