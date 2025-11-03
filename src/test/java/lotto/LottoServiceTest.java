package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    @DisplayName("구입 금액이 양수가 아닐 경우 예외를 던진다.")
    void purchaseLottos_shouldThrowExceptionWhenPurchaseAmountIsNotPositive(int purchaseAmount) {
        LottoService lottoService = new LottoService();

        assertThatThrownBy(() -> lottoService.purchaseLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_INTEGER);
    }

    @Test
    @DisplayName("구입 금액이 1000 단위가 아닐 경우 예외를 던진다.")
    void purchaseLottos_shouldThrowExceptionWhenPurchaseAmountIsNotMultipleOfThousand(){
        int purchaseAmount = 10;

        LottoService lottoService = new LottoService();

        assertThatThrownBy(() -> lottoService.purchaseLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
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
