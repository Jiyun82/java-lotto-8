package lotto.domain;

public class WinningLottoFactory {

    public WinningLotto createWinningLotto(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

}
