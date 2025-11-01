package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    private final int LOTTO_NUMBER_COUNT = 6;

    @Test
    @DisplayName("주어진 갯수만큼 로또를 생성한다.")
    void createLottos_shouldCreateCorrectNumberOfLottos() {
        int count = 5;

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(5);

        assertThat(lottos).hasSize(count);
    }

    @Test
    @DisplayName("로또의 번호는 중복 없이 6개여야 한다.")
    void createLottos_shouldHaveSixUniqueNumbers() {
        int count = 1;

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(count);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);

            assertThat(numbers).hasSize(LOTTO_NUMBER_COUNT);
            assertThat(uniqueNumbers).hasSize(LOTTO_NUMBER_COUNT);
        }
    }

    @Test
    @DisplayName("로또의 번호는 1~45 범위를 벗어나지 않아야 한다.")
    void createLottos_shouldHaveNumbersWithinRange() {
        int count = 1;

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(count);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
        }
    }

    @Test
    @DisplayName("입력 받은 번호로 로또를 생성한다.")
    void createLotto_shouldCreateLottoWhenInputIsValid() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 15, 20, 25, 30, 35));

        LottoFactory lottoFactory = new LottoFactory();
        Lotto lotto = lottoFactory.createLotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또의 번호가 6개가 아니라면 예외를 던진다.")
    void createLotto_shouldThrowExceptionWhenNumberCountIsNotSix() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        LottoFactory lottoFactory = new LottoFactory();

        assertThatThrownBy(() -> lottoFactory.createLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_SIX_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("로또의 번호가 1~45 범위를 벗어난다면 예외를 던진다.")
    void createLotto_shouldThrowExceptionWhenNumberOutOfRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        LottoFactory lottoFactory = new LottoFactory();

        assertThatThrownBy(() -> lottoFactory.createLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE);
    }


}
