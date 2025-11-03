package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private final int NUMBER_COUNT = 6;

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
        if (!hasSizeNumberCount(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_LOTTO_NUMBERS);
        }
        if (!areNumbersInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }
        if(!areNumbersUnique(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_NUMBERS);
        }
    }

    private boolean hasSizeNumberCount(List<Integer> numbers) {
        return numbers.size() == NUMBER_COUNT;
    }

    private boolean areNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(n -> n >= 1 && n <= 45);
    }

    private boolean areNumbersUnique(List<Integer> numbers) {
        return numbers.size() == new HashSet<>(numbers).size();
    }
}
