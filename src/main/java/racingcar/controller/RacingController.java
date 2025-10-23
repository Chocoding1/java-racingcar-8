package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView = InputView.getInstance();

    public void startRacing() {
        // 자동차 이름 입력받기
        String carNames = inputView.getCarNames();
        // 횟수 입력받기
        int frequency = inputView.getFrequency();
    }

}
