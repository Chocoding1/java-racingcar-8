package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

import static racingcar.model.ErrorMessage.CAR_NAME_LENGTH_OVER;
import static racingcar.model.ErrorMessage.NON_ENGLISH_CAR_NAME;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }

    private void validateName(String name) {
        validateOnlyLetters(name);
        validateNameLength(name);
    }

    private void validateOnlyLetters(String name) {
        String lettersRegex = "^[a-zA-Z]*$";

        if (!Pattern.matches(lettersRegex, name)) {
            throw new IllegalArgumentException(NON_ENGLISH_CAR_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }
    }

    @Override
    public int compareTo(Car car) {
        return car.distance - this.distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, distance));
    }
}
