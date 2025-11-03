package lotto.util;

public class ErrorMessage {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String NOT_POSITIVE_INTEGER = ERROR_PREFIX + "양의 정수를 입력해주세요.";

    public static final String NOT_MULTIPLE_OF_THOUSAND = ERROR_PREFIX + "1000 단위로 입력해주세요.";

    public static final String NOT_INTEGER = ERROR_PREFIX + "정수를 입력해주세요.";

    public static final String NOT_SIX_LOTTO_NUMBERS = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";

    public static final String OUT_OF_RANGE = ERROR_PREFIX + "로또 번호의 숫자 범위는 1~45까지 입니다.";

    public static final String DUPLICATE_WINNING_AND_BONUS_NUMBER = ERROR_PREFIX + "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    public static final String NOT_UNIQUE_NUMBERS = ERROR_PREFIX + "로또 번호는 중복이 없어야 합니다.";

}
