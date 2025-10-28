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
    void shouldThrowExceptionWhenInputIsNotNumber(String input) {

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_INTEGER);
    }

    @Test
    @DisplayName("입력값이 1000원 단위가 아니면 예외를 던진다.")
    void shouldThrowExceptionWhenAmountIsNotMultipleOfThousand() {
        String input = "123456";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
    }

    @Test
    @DisplayName("입력값이 유효하면 예외를 던지지 않는다.")
    void shouldNotThrowExceptionWhenAmountIsValid() {
        String input = "14000";

        assertDoesNotThrow(() -> InputValidator.validatePurchaseAmount(input));
    }

}
