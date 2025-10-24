package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름에 영문자 외의 문자 포함 시 IllegalArgumentException 예외 발생")
    void throw_exception_when_carName_contains_not_letters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("!letters"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 시 IllegalArgumentException 예외 발생")
    void throw_exception_when_carName_longer_than_five() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("longerThanFive"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 객체 정상 생성")
    void create_car_success() {
        //given
        String carName = "name";

        //when & then
        assertSimpleTest(() -> {
            Car car = new Car(carName);
            assertThat(car.getDistance()).isEqualTo(0);
        });
    }
}