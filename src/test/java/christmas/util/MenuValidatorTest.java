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

    @ParameterizedTest
    @DisplayName("메뉴 중복되게 입력한 경우!")
    @ValueSource(strings = {"menu-1,menu-2", "menu-3,menu-5"})
    void validateDuplicate(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("메뉴 형식 맞지 않게 입력한 경우!")
    @ValueSource(strings = {"menu*4,menu-2", "4-menu,menu-5"})
    void validateNoFormat(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("음료수 입력한 경우!")
    @ValueSource(strings = {"제로콜라-1", "제로콜라-1,레드와인-1", "제로콜라-1,레드와인-1,샴페인-1"})
    void validateOnlyBeverage(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("메뉴 갯수 입력이 잘못된 경우! - 문자로 온 경우")
    @ValueSource(strings = {"제로콜라-a", "아이스크림-*"})
    void validateWrongMenuCount(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력이 잘못된 경우! - '-' 갯수가 옳지 않게 온 경우")
    @ValueSource(strings = {"제로콜라--1", "아이스크림--4"})
    void validateWrongMenuCountNegative(String inputMenu){
        Assertions.assertThatThrownBy(() -> menuValidator.validate(inputMenu)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }







}