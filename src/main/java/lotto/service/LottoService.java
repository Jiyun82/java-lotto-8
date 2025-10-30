package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        LottoFactory lottoFactory = new LottoFactory();
        return lottoFactory.createLottos(purchaseAmount / LOTTO_PRICE);
    }

}
