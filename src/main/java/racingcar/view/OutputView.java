package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static OutputView instance;

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_WINNERS = "최종 우승자 : ";

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

    public void renderingRacingProgress(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }

        System.out.print(sb);
    }
}
