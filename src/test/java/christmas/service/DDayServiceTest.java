package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DDayServiceTest {

    DDayService dDayService;

    @BeforeEach
    void beforeAll() {
       dDayService = new DDayService();
    }

    @ParameterizedTest
    @DisplayName("1-25일 날짜 이내의 할인가격 검증")
    @ValueSource(ints = {1,2,3,25})
    void calculateDdayBenefit(int date) {
        Assertions.assertThat(dDayService.calculateDdayBenefit(date)).isLessThan(0);
    }




}