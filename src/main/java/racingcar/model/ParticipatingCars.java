package racingcar.model;

import java.util.Arrays;
import java.util.List;

import static racingcar.model.ErrorMessage.INSUFFICIENT_NUMBER_OF_CARS;

public class ParticipatingCars {

    private final List<Car> cars;

    public ParticipatingCars(String initialCarNames) {
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
        // maxDistance 구해
        int maxDistance = getMaxDistance();

        // stream api로 maxdistance와 같은 것들만 뽑아
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private List<Car> namesToCars(String initialCarNames) {
        String[] carNames = initialCarNames.split(",");

        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    private void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < 2) {
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
