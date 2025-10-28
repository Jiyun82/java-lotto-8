package lotto.util;

public class InputValidator {

    public static void validatePurchaseAmount(String input) {
        if(!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER);
        }
        if(!isMultipleOfThousand(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("[1-9]\\d*");
    }

    private static boolean isMultipleOfThousand(int input) {
        return input % 1000 == 0;
    }

}
