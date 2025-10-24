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
        String racingResult = cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));

        System.out.print(racingResult + "\n");
    }

    public void renderingWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(RACING_WINNERS_TITLE);

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        sb.append(winnerNames);

        System.out.println(sb);
    }
}
