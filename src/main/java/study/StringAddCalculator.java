package study;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return getSum(textParser(text));
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static String[] textParser(String text) {
        if (text.contains("//")) {
            String delimiter = String.valueOf(text.charAt(2));
            return text.substring(4).split(delimiter);
        }
        return text.split("[,:]");
    }

    public static int getSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .peek(number -> {
                    if (number < 0) {
                        throw new RuntimeException();
                    }
                })
                .sum();
    }
}
