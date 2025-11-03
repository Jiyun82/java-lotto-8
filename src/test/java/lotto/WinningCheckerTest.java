package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningChecker;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResults;
import lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호 및 보너스 번호를 비교하여 당첨 결과를 반환한다.")
    void calculateWinningResults_shouldReturnWinningResultsWhenLottosAndWinningLottoGiven() {
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(13, 14, 15, 16, 17, 18)));
        Lotto lotto4 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);

        Lotto winningNumbers = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningChecker winningChecker = new WinningChecker();
        WinningResults results = winningChecker.calculateWinningResults(lottos, winningLotto);

        assertThat(results.getCountByWinningType(WinningType.THREE_MATCH)).isEqualTo(0);
        assertThat(results.getCountByWinningType(WinningType.FOUR_MATCH)).isEqualTo(0);
        assertThat(results.getCountByWinningType(WinningType.FIVE_MATCH)).isEqualTo(0);
        assertThat(results.getCountByWinningType(WinningType.FIVE_BONUS)).isEqualTo(1);
        assertThat(results.getCountByWinningType(WinningType.SIX_MATCH)).isEqualTo(1);
    }

}
