package racingcar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
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

        // 자동차 이름 분리해서 리스트로 만들기
        String[] carNames = initialCarNames.split(",");

        // 각 리스트 돌면서 자동차 객체 생성하여 자동차 객체 리스트 만들기
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        // 횟수 반복
        for (int i = 0; i < frequency; i++) {
            // 리스트 돌면서 자동차 전진
            for (Car car : cars) {
                car.move();
            }
            // 진행 상황 출력
            if (i == 0) {
                outputView.renderingRacingResultTitle();
            }
            outputView.renderingRacingProgress(cars);
        }
    }
}
