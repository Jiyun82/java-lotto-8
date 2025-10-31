package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_LOTTO_NUMBERS);
        }

        for(int n : numbers) {
            if(n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
            }
        }
    }
}
