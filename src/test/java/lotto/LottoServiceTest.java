package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("주어진 금액에 알맞는 개수의 로또를 생성한다.")
    void purchaseLottos_shouldCreateLottosBasedOnPurchaseAmount() {
        int purchaseAmount = 8000;

        LottoService lottoService = new LottoService();

        int lottoPrice = 1000;
        int count = purchaseAmount / lottoPrice;
        assertThat(lottoService.purchaseLottos(purchaseAmount)).hasSize(count);
    }

    @Test
    @DisplayName("주어진 당첨 번호와 보너스 번호로 WinningLotto 객체를 생성한다.")
    void createWinningLotto_shouldCreateWinningLottoWithGivenNumbers() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoService lottoService = new LottoService();
        WinningLotto winningLotto = lottoService.createWinningLotto(winningNumbers, bonusNumber);

        assertThat(winningLotto.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

}
