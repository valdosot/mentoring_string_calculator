import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenInputIsEmptyString() {
        StringCalculator calc = new StringCalculator();

        Integer actual = calc.add("");

        Assertions.assertThat(actual).isEqualTo(0);


    }
}