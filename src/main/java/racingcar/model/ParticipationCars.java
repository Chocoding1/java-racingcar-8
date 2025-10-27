package racingcar.model;

import java.util.Arrays;
import java.util.List;

import static racingcar.model.ErrorMessage.INSUFFICIENT_NUMBER_OF_CARS;

public class ParticipationCars {

    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private static final String NAME_SPLIT_DELIMITER = ",";

    private final List<Car> cars;

    public ParticipationCars(String initialCarNames) {
        List<Car> cars = namesToCars(initialCarNames);
        validateNumberOfCars(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getDistance() == getMaxDistance())
                .toList();
    }

    private List<Car> namesToCars(String initialCarNames) {
        String[] carNames = initialCarNames.split(NAME_SPLIT_DELIMITER);

        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    private void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(INSUFFICIENT_NUMBER_OF_CARS);
        }
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

}
