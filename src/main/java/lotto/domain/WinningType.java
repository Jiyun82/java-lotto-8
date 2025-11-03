package lotto.domain;

import java.util.Arrays;

public enum WinningType {

    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private final int matchCount;

    private final boolean bonusMatched;

    private final int prize;

    WinningType(int matchCount, boolean bonusMatched, int prize) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
    }

    public String toString() {
        if(bonusMatched) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d", prize) + "원) - ";
        }
        return matchCount + "개 일치 (" + String.format("%,d", prize) + "원) - ";
    }

    public int getPrize() {
        return prize;
    }

    public static WinningType from(int matchCount, boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(type -> type.matchCount == matchCount && type.bonusMatched == bonusMatched)
                .findFirst()
                .orElse(null);
    }

}
