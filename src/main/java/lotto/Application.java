package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.inputPurchaseAmount();

        List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);

        outputView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        lottoService.createWinningLotto(winningNumbers, bonusNumber);
    }
}
