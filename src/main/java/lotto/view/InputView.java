package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

}
