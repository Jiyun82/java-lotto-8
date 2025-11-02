package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResults;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(WinningResults winningResults, double profit) {
        System.out.println("당첨 통계\n---");
        System.out.println(winningResults);
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

}
