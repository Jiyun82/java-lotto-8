package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int purchaseAmount = inputView.inputPurchaseAmount();

        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);

        OutputView outputView = new OutputView();
        outputView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
    }
}
