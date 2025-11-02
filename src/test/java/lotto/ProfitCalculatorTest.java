package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.ProfitCalculator;
import lotto.domain.WinningResults;
import lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;

public class ProfitCalculatorTest {

    @DisplayName("당첨 결과와 구입 금액이 주어지면 수익률을 계산한다.")
    void calculateProfit() {
        WinningResults winningResults = new WinningResults();
        winningResults.addResult(WinningType.THREE_MATCH);
        winningResults.addResult(WinningType.THREE_MATCH);
        winningResults.addResult(WinningType.FIVE_BONUS);
        int purchaseAmount = 20000;

        ProfitCalculator profitCalculator = new ProfitCalculator();

        assertThat(profitCalculator.calculateProfit(winningResults, purchaseAmount)).isEqualTo(6.67);
    }

}
