package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.util.ErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "0", "-14000"})
    @DisplayName("입력값이 양의 정수가 아니면 예외를 던진다.")
    void validatePurchaseAmount_shouldThrowExceptionWhenInputIsNotNumber(String input) {

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_INTEGER);
    }

    @Test
    @DisplayName("입력값이 1000원 단위가 아니면 예외를 던진다.")
    void validatePurchaseAmount_shouldThrowExceptionWhenAmountIsNotMultipleOfThousand() {
        String input = "123456";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
    }

    @Test
    @DisplayName("입력값이 유효하면 예외를 던지지 않는다.")
    void validatePurchaseAmount_shouldNotThrowExceptionWhenAmountIsValid() {
        String input = "14000";

        assertDoesNotThrow(() -> InputValidator.validatePurchaseAmount(input));
    }

    @Test
    @DisplayName("입력값이 정수로 이루어져있지 않으면 예외를 던진다.")
    void validateWinningNumbers_shouldThrowExceptionWhenInputIsNotInteger() {
        String input = "1, 2, 3, 4, 5, a";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER);
    }

    @Test
    @DisplayName("입력값이 유효하면 예외를 던지지 않는다.")
    void validateWinningNumbers_shouldNotThrowExceptionWhenInputIsValid() {
        String input = "1, 2, 3, 4, 5, 6";

        assertDoesNotThrow(() -> InputValidator.validateWinningNumbers(input));
    }

    @Test
    @DisplayName("입력값이 정수가 아니라면 예외를 던진다.")
    void validateBonusNumber_shouldThrowExceptionWhenInputIsNotInteger() {
        String input = "h";

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER);
    }

    @Test
    @DisplayName("입력값이 유효하면 예외를 던지지 않는다.")
    void validateBonusNumber_shouldNotThrowExceptionWhenInputIsValid() {
        String input = "7";

        assertDoesNotThrow(() -> InputValidator.validateBonusNumber(input));
    }

}
