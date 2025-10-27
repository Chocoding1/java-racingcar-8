package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipatingCarsTest {

    @Test
    @DisplayName("참가 자동차 수가 2대 미만일 시 IllegalArgumentException 예외 발생")
    void throw_exception_when_number_of_cars_less_than_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new ParticipationCars("cho"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}