package christmas.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuValidatorTest {

    MenuValidator menuValidator;


    @BeforeEach
    void init(){
        menuValidator = new MenuValidator();
    }



    @ParameterizedTest
    @DisplayName("comma 갯수가 잘못 입력된 경우!")
    @ValueSource(strings = {"menu-1,,", ",,menu-1", "menu-1,,,menu-2"})
    void validateNoComma(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }






}