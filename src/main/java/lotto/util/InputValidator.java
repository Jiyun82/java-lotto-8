package lotto.util;

import java.util.List;

public class InputValidator {

    public static void validatePurchaseAmount(String input) {
        if(!isPositiveInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER);
        }
        if(!isMultipleOfThousand(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    public static void validateWinningNumbers(String input) {
        List<String> parts = List.of(input.split(","));
        for (String part : parts) {
            if (!isInteger(part.trim())) {
                throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
            }
        }
    }

    public static void validateBonusNumber(String input) {
        if(!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    private static boolean isPositiveInteger(String input) {
        return input.matches("[1-9]\\d*");
    }

    private static boolean isMultipleOfThousand(int input) {
        return input % 1000 == 0;
    }

    private static boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }

}
