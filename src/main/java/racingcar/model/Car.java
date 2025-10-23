package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{

    private final String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
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

    private void validateNameLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
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
