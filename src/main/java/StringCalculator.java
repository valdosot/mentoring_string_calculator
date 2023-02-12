import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        System.out.println(sc.add("//[***]\n1***2***3"));
    }

    public Integer add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String regex = "[//***;%,\n]";
        input = input.replace("[", "").replace("]", "");

        List<String> negativesValues =
                Arrays.stream(input.split(regex))
                        .map(String::trim)
                        .filter((x) -> x.startsWith("-"))
                        .collect(Collectors.toList());

        if (!negativesValues.isEmpty()) {
            throw new ArithmeticException("negatives not allowed\n" + negativesValues);
        }

        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(x -> x < 1001)
                .sum();

    }


}
