package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.WinningResults;
import lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultsTest {

    @Test
    @DisplayName("WinningResults 객체를 생성하면 키로 모든 WinningType을 갖고 값은 0 이다.")
    void constructor_shouldSetAllWinningTypeCountsToZero() {
        WinningResults winningResults = new WinningResults();

        assertThat(winningResults.getWinningTypes()).containsExactlyInAnyOrder(WinningType.values());
        List<Integer> counts = winningResults.getCounts();
        for (Integer count : counts) {
            assertThat(count).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("주어진 WinningType의 count가 1 증가한다.")
    void addResult_shouldIncreaseCountByOne() {
        WinningType winningType = WinningType.FIVE_MATCH;

        WinningResults winningResults = new WinningResults();
        winningResults.addResult(winningType);

        assertThat(winningResults.getCountByWinningType(winningType)).isEqualTo(1);
    }

}
