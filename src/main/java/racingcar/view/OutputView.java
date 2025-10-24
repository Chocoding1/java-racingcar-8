package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    private static OutputView instance;

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_WINNERS_TITLE = "최종 우승자 : ";

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void renderingRacingResultTitle() {
        System.out.println(RACING_RESULT_TITLE);
    }

    public void renderingRacingResult(List<Car> cars) {
        System.out.println(getRacingResult(cars));
    }

    public void renderingWinners(List<Car> winners) {
        System.out.print(RACING_WINNERS_TITLE);
        System.out.println(getWinnerNames(winners));
    }

    private static String getRacingResult(List<Car> cars) {
        return cars.stream()
                .map(car -> car.toString() + "\n")
                .collect(Collectors.joining(""));
    }

    private static String getWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
