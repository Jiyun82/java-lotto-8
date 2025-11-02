package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6))));
        }
        return lottos;
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}
