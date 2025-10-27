package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

import static racingcar.model.ErrorMessage.CAR_NAME_IS_BLANK;
import static racingcar.model.ErrorMessage.CAR_NAME_LENGTH_OVER;
import static racingcar.model.ErrorMessage.NON_ENGLISH_CAR_NAME;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]*$";
    private static final int MOVEMENT_CONDITION_NUMBER = 4;

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
        if (Randoms.pickNumberInRange(0, 9) >= MOVEMENT_CONDITION_NUMBER) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, distance));
    }

    private void validateName(String name) {
        validateNameBlank(name);
        validateOnlyLetters(name);
        validateNameLength(name);
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_IS_BLANK);
        }
    }

    private void validateOnlyLetters(String name) {
        if (!Pattern.matches(NAME_REGEX, name)) {
            throw new IllegalArgumentException(NON_ENGLISH_CAR_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() >= NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }
    }
}
