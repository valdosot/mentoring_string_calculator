import java.util.Arrays;

public class StringCalculator {
    public Integer add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String regex = ",";

        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sum();

    }


}
