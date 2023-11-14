package christmas.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekServiceTest {

    WeekService weekService;

    @BeforeEach
    void init() {
        weekService = new WeekService();
    }


    @ParameterizedTest
    @DisplayName("평일일 때의 경우")
    @MethodSource("weekDayCase")
    void weekDayTest(Map<String, Integer> menuInfo, Integer date) {
        Assertions.assertThat(weekService.calculateWeekBenefit(menuInfo,date).getSalePrice()).isEqualTo(-4046);
    }

    @ParameterizedTest
    @DisplayName("평일일 때의 경우")
    @MethodSource("weekendDayCase")
    void weekendDayTest(Map<String, Integer> menuInfo, Integer date) {
        Assertions.assertThat(weekService.calculateWeekBenefit(menuInfo,date).getSalePrice()).isEqualTo(-6069);
    }


    static Stream<Arguments> weekendDayCase() {
        return Stream.of(
            Arguments.arguments(new HashMap() {{
                put("아이스크림", 2);
                put("바비큐립", 3);
            }}, 1),
            Arguments.arguments(new HashMap() {{
                put("아이스크림", 2);
                put("바비큐립", 3);
            }}, 2)
        );
    }

    static Stream<Arguments> weekDayCase() {
        return Stream.of(
            Arguments.arguments(new HashMap() {{
                put("아이스크림", 2);
                put("바비큐립", 3);
            }}, 3),
            Arguments.arguments(new HashMap() {{
                put("아이스크림", 2);
                put("바비큐립", 3);
            }}, 4),
            Arguments.arguments(new HashMap() {{
                put("아이스크림", 2);
                put("바비큐립", 3);
            }}, 7)
        );
    }

}
