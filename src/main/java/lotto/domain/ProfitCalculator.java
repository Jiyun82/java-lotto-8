package lotto.domain;

public class ProfitCalculator {

    public double calculateProfit(WinningResults results, int purchaseAmount) {
        long earnings = calculateEarnings(results);

        return Math.round(((double) earnings / purchaseAmount) * 100) / 100.0;
    }

    private long calculateEarnings(WinningResults results) {
        long earnings = 0;
        for (WinningType winningType : WinningType.values()) {
            int count = results.getCountByWinningType(winningType);
            earnings += (long) count * winningType.getPrize();
        }
        return earnings;
    }

}
