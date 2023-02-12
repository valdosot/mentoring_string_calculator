import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    void shouldReturnTheSumOfUnknownAmountOfNumbers() {

        Integer actual = stringCalculator.add("1,2,3,4,5");

        assertThat(actual).isEqualTo(15);
    }

    @Test
    void shouldToHandleNewLinesBetweenNumbers() {

        Integer actual = stringCalculator.add("1,2\n3,4,5");

        assertThat(actual).isEqualTo(15);
    }

    @Test
    void shouldSupportDifferentDelimiters() {

        Integer actual = stringCalculator.add("//;\n1;2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void shouldAvoidNegativeValues() {
        assertThatThrownBy(() -> {
            Integer actual = stringCalculator.add("//;\n1;2,-3,-4");

        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("negatives not allowed\n[-3, -4]");
    }

    @Test
    void shouldAvoidNumbersBiggersThan1000() {

        Integer actual = stringCalculator.add("//;\n1;2, 1005");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void shouldAllowDelimitersOfAnyLengt() {

        Integer actual = stringCalculator.add("//[***]\n1***2***3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void shouldAllowMultiplesDelimiters() {

        Integer actual = stringCalculator.add("//[*][%]\n1*2%3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void shouldHandleMultipleDelimitersWithLengthLongerThanOneChar() {

        Integer actual = stringCalculator.add("//[***][%%%]\n1***2%%%3");

        assertThat(actual).isEqualTo(6);
    }
}