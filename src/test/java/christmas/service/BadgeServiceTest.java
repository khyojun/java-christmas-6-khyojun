package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeServiceTest {


    BadgeService badgeService;

    @BeforeEach
    void init(){
        badgeService = new BadgeService();
    }

    @ParameterizedTest
    @DisplayName("뱃지 케이스에 따른 뱃지 발급")
    @MethodSource("badgeInfo")
    void decideBadge(long totalBenefitPrice, String badge) {
        Assertions.assertThat(badgeService.decideBadge(totalBenefitPrice)).isEqualTo(badge);
    }



    static Stream<Arguments> badgeInfo() {
        return Stream.of(
            Arguments.arguments(20000, "산타"),
            Arguments.arguments(10000, "트리"),
            Arguments.arguments(5000, "별"),
            Arguments.arguments(3000, "없음")
        );
    }

}