package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoFactory;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final LottoFactory lottoFactory = new LottoFactory();

    private final WinningLottoFactory winningLottoFactory = new WinningLottoFactory();

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        return lottoFactory.createLottos(purchaseAmount / LOTTO_PRICE);
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = lottoFactory.createLotto(winningNumbers);
        return winningLottoFactory.createWinningLotto(lotto, bonusNumber);
    }

}
