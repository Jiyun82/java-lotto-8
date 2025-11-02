package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.ProfitCalculator;
import lotto.domain.WinningResults;
import lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("당첨 결과와 구입 금액이 주어지면 수익률을 계산한다.")
    void calculateProfit_shouldCalculateProfitWhenWinningResultsAndPurchaseAmountGiven() {
        WinningResults winningResults = new WinningResults();
        winningResults.addResult(WinningType.THREE_MATCH);
        winningResults.addResult(WinningType.THREE_MATCH);
        winningResults.addResult(WinningType.FIVE_BONUS);
        int purchaseAmount = 20000;

        ProfitCalculator profitCalculator = new ProfitCalculator();

        assertThat(profitCalculator.calculateProfit(winningResults, purchaseAmount)).isEqualTo(150050);
    }

}
