package lotto.domain;

import java.util.List;

public class WinningChecker {

    public WinningResults calculateWinningResults(List<Lotto> lottos, WinningLotto winningLotto) {
        WinningResults results = new WinningResults();
        for (Lotto lotto : lottos) {
            WinningType winningType = calculateWinningType(lotto, winningLotto);
            results.addResult(winningType);
        }
        return results;
    }

    private WinningType calculateWinningType(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(lotto.getNumbers(), winningLotto.getWinningNumbers());
        boolean bonusMatched = isBonusMatched(lotto.getNumbers(), winningLotto.getBonusNumber());

        return WinningType.from(matchCount, bonusMatched);
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
