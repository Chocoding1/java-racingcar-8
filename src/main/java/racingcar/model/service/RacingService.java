package racingcar.model.service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class RacingService {

    private static RacingService instance;

    private RacingService() {
    }

    public static RacingService getInstance() {
        if (instance == null) {
            instance = new RacingService();
        }
        return instance;
    }

    public List<Car> namesToCars(String initialCarNames) {
        String[] carNames = initialCarNames.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .toList();

        if (cars.size() < 2) {
            throw new IllegalArgumentException("참가 자동차는 2대 이상이어야 합니다.");
        }

        return cars;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        // maxDistance 구해
        int maxDistance = getMaxDistance(cars);

        // stream api로 maxdistance와 같은 것들만 뽑아
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
