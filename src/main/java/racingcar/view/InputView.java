package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private static final String CAR_NAMES_INPUT_SCREEN = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String FREQUENCY_INPUT_SCREEN = "시도할 횟수는 몇 회인가요?";

    public String getInitialCarNames() {
        System.out.println(CAR_NAMES_INPUT_SCREEN);
        return Console.readLine();
    }

    public int getFrequency() {
        System.out.println(FREQUENCY_INPUT_SCREEN);
        return Integer.parseInt(Console.readLine());
    }
}
