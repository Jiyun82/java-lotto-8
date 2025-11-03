package lotto.util;

import java.util.List;

public class InputValidator {

    public static void validatePurchaseAmount(String input) {
        if(!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
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

    private static boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }

}
