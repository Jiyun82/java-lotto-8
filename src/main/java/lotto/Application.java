package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinningChecker;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResults;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoService lottoService = new LottoService();
            WinningChecker winningChecker = new WinningChecker();
            ProfitCalculator profitCalculator = new ProfitCalculator();

            int purchaseAmount = inputView.inputPurchaseAmount();

            List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);

            outputView.printLottos(lottos);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            WinningLotto winningLotto = lottoService.createWinningLotto(winningNumbers, bonusNumber);

            WinningResults winningResults = winningChecker.calculateWinningResults(lottos, winningLotto);
            double profit = profitCalculator.calculateProfit(winningResults, purchaseAmount);

            outputView.printWinningResult(winningResults, profit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
