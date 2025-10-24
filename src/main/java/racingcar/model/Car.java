package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

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
        String lettersRegex = "^[a-zA-Z]$";

        if (!Pattern.matches(lettersRegex, name)) {
            throw new IllegalArgumentException("이름에 영문자 외의 문자가 포함되어 있습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public int compareTo(Car car) {
        return car.distance - this.distance;
    }

    @Override
    public String toString() {
        StringBuilder distanceForRendering = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceForRendering.append("-");
        }
        return name + " : " + distanceForRendering;
    }
}
