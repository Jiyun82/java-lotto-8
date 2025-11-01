package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.WinningChecker;
import lotto.domain.WinningLotto;
import lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningCheckerTest {

    @ParameterizedTest
    @MethodSource("winningTypeProvider")
    @DisplayName("로또 번호와 당첨 번호 및 보너스 번호를 비교하여 당첨 결과를 반환한다.")
    void calculateWinningType_returnsWinningResult(Lotto lotto, WinningLotto winningLotto, WinningType expectedType) {
        WinningChecker winningChecker = new WinningChecker();

        assertThat(winningChecker.calculateWinningType(lotto, winningLotto)).isEqualTo(expectedType);
    }

    static Stream<Arguments> winningTypeProvider() {
        return Stream.of(
                arguments(
                        new Lotto(new ArrayList<>(List.of(1, 2, 3, 7, 8, 9))),
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10),
                        WinningType.THREE_MATCH
                ),
                arguments(
                        new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 8, 9))),
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10),
                        WinningType.FOUR_MATCH
                ),
                arguments(
                        new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 9))),
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10),
                        WinningType.FIVE_MATCH
                ),
                arguments(
                        new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10),
                        WinningType.FIVE_BONUS
                ),
                arguments(
                        new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10),
                        WinningType.SIX_MATCH
                )
        );
    }

}
