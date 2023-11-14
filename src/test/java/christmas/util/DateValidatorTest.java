package christmas.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DateValidatorTest {

    DateValidator dateValidator;

    @BeforeEach
    void init(){
        dateValidator = new DateValidator();
    }

    @ParameterizedTest
    @DisplayName("날짜 입력이 잘못된 경우! - 문자 입력의 예시")
    @ValueSource(strings = {"a", "b", "!2"})
    void validateNotNumber(String inputDate) {
        Assertions.assertThatThrownBy(() -> dateValidator.validate(inputDate)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]" + );
    }


    @ParameterizedTest
    @DisplayName("날짜 입력이 잘못된 경우! - 숫자 입력시 범위가 1 - 31 사이의 숫자가 아닐 때")
    @ValueSource(strings = {"-1", "32"})
    void validateNotRange(String inputDate) {
        Assertions.assertThatThrownBy(() -> dateValidator.validate(inputDate)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }




}