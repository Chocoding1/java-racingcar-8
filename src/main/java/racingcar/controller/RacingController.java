package racingcar.controller;

import racingcar.model.ParticipatingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static RacingController instance;

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private RacingController() {
    }

    public static RacingController getInstance() {
        if (instance == null) {
            instance = new RacingController();
        }
        return instance;
    }

    public void startRacing() {
        // 자동차 이름 입력받기
        String initialCarNames = inputView.getInitialCarNames();
        // 횟수 입력받기
        int frequency = inputView.getFrequency();

        // 자동차 이름 분리해서 자동차 객체 리스트 만들기
        ParticipatingCars participatingCars = new ParticipatingCars(initialCarNames);

        // 횟수 반복
        outputView.renderingRacingResultTitle();
        for (int i = 0; i < frequency; i++) {
            // 리스트 돌면서 자동차 전진
            participatingCars.moveCars();
            // 진행 상황 출력
            outputView.renderingRacingResult(participatingCars);
        }

        //최종 우승자 출력
        outputView.renderingWinners(participatingCars.getWinners());
    }
}
