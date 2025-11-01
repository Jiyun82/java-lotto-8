package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.WinningChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningCheckerTest {

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    @DisplayName("로또 번호와 당첨 번호의 일치 개수를 반환한다.")
    void countMatchingNumbers_shouldReturnCorrectCount(List<Integer> numbers, List<Integer> winningNumbers, int expected) {
        WinningChecker winningChecker = new WinningChecker();

        int matchCount = winningChecker.countMatchingNumbers(numbers, winningNumbers);

        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있다면 true를 반환한다.")
    void isBonusMatched_shouldReturnTrueWhenBonusIsIncluded() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 2;

        WinningChecker winningChecker = new WinningChecker();

        assertThat(winningChecker.isBonusMatched(numbers, bonusNumber)).isTrue();
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않다면 false를 반환한다.")
    void isBonusMatched_shouldReturnFalseWhenBonusIsNotIncluded() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningChecker winningChecker = new WinningChecker();

        assertThat(winningChecker.isBonusMatched(numbers, bonusNumber)).isFalse();
    }

    static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6), 6),
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,7,8,9), 3)
        );
    }

}
