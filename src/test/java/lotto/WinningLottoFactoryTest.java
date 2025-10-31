package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoFactory;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoFactoryTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 주어지면 WinningLotto 객체를 생성한다.")
    void shouldCreateWinningLottoWhenValidInput() {
        List<Integer> winningNumbers = List.of(2, 10, 16, 22, 30, 43);
        int bonusNumber = 7;

        LottoFactory lottoFactory = new LottoFactory();
        Lotto lotto = lottoFactory.createLotto(winningNumbers);
        WinningLottoFactory winningLottoFactory = new WinningLottoFactory();
        WinningLotto winningLotto = winningLottoFactory.createWinningLotto(lotto, bonusNumber);

        assertThat(winningLotto.getWinningNumbers())
                .hasSize(6)
                .isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46})
    @DisplayName("보너스 번호의 범위가 1~45를 벗어날 경우 예외를 던진다.")
    void shouldThrowExceptionWhenBonusNumberOutOfRange(int bonusNumber) {
        List<Integer> winningNumbers = List.of(2, 10, 16, 22, 30, 43);

        LottoFactory lottoFactory = new LottoFactory();
        Lotto lotto = lottoFactory.createLotto(winningNumbers);
        WinningLottoFactory winningLottoFactory = new WinningLottoFactory();

        assertThatThrownBy(() -> winningLottoFactory.createWinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE);
    }


}
