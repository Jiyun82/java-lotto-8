package lotto.domain;

import java.util.List;

public class WinningChecker {

    public WinningType calculateWinningType(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(lotto.getNumbers(), winningLotto.getWinningNumbers());
        boolean bonusMatched = isBonusMatched(lotto.getNumbers(), winningLotto.getBonusNumber());

        if (matchCount == 3) {
            return WinningType.THREE_MATCH;
        } else if (matchCount == 4) {
            return WinningType.FOUR_MATCH;
        } else if (matchCount == 5 && !bonusMatched) {
            return WinningType.FIVE_MATCH;
        } else if (matchCount == 5 && bonusMatched) {
            return WinningType.FIVE_BONUS;
        } else if (matchCount == 6) {
            return WinningType.SIX_MATCH;
        }
        return null;
    }

    private int countMatchingNumbers(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatched(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
