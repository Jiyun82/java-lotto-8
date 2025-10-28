package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    @DisplayName("주어진 갯수만큼 로또를 생성한다.")
    void shouldCreateCorrectNumberOfLottos() {
        int count = 5;

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(5);

        assertThat(lottos).hasSize(count);
    }

}
