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
        String initialCarNames = inputView.getInitialCarNames();
        int frequency = inputView.getFrequency();

        ParticipatingCars participatingCars = new ParticipatingCars(initialCarNames);

        outputView.renderingRacingResultTitle();
        for (int i = 0; i < frequency; i++) {
            participatingCars.moveCars();

            outputView.renderingRacingResult(participatingCars);
        }

        outputView.renderingWinners(participatingCars.getWinners());
    }
}
