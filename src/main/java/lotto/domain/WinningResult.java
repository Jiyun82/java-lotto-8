package lotto.domain;

public class WinningResult {

    private final WinningType winningType;

    private int count;

    public WinningResult(WinningType winningType) {
        this.winningType = winningType;
        this.count = 0;
    }

    public void increaseCount() {
        count++;
    }

    public WinningType getWinningType() {
        return winningType;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return winningType + "" + count + "개";
    }
}
