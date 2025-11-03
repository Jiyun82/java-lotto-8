package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoFactory;
import lotto.util.ErrorMessage;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final LottoFactory lottoFactory = new LottoFactory();

    private final WinningLottoFactory winningLottoFactory = new WinningLottoFactory();

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return lottoFactory.createLottos(purchaseAmount / LOTTO_PRICE);
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = lottoFactory.createLotto(winningNumbers);
        return winningLottoFactory.createWinningLotto(lotto, bonusNumber);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (!isPositiveInteger(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER);
        }
        if (!isMultipleOfThousand(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private boolean isPositiveInteger(int number) {
        return number > 0;
    }

    private boolean isMultipleOfThousand(int number) {
        return number % 1000 == 0;
    }

}
