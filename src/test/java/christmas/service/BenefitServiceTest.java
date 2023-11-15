package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BenefitServiceTest {


    BenefitService benefitService;
    @BeforeEach
    void init(){
        benefitService = new BenefitService();
    }


    @ParameterizedTest
    @MethodSource("noBenefitParameter")
    @DisplayName("혜택이 없는 경우 계산")
    void checkBenefit(Integer date, Map<String, Integer> menuInfo,
        long beforeBenefitMoney) {

        Assertions.assertThat(benefitService.checkBenefit(date, menuInfo, beforeBenefitMoney).isNone()).isEqualTo(true);


    }


    static Stream<Arguments> noBenefitParameter(){
        return Stream.of(
            Arguments.arguments(26,new HashMap() {{
                put("제로콜라", 2);
                put("바비큐립", 3);
            }}, 60000),
            Arguments.arguments(26,new HashMap() {{
                put("샴페인", 1);
                put("타파스", 2);
            }}, 30500)
        );

    }

}