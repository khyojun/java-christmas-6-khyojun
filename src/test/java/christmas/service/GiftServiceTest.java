package christmas.service;

import static christmas.domain.Menu.BEVERAGE_CHAMPAGNE;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftServiceTest {


    GiftService giftService;

    @BeforeEach
    void init(){
        giftService = new GiftService();
    }



    @ParameterizedTest
    @DisplayName("증정 선물 시 가격이 기준을 넘는 경우")
    @ValueSource(ints = {125000, 140000})
    void calculateGiftBenefit(int calculateTotalMoney) {
        Assertions.assertThat(giftService.calculateGiftBenefit(calculateTotalMoney)).isEqualTo(
            BEVERAGE_CHAMPAGNE.getPrice());
    }

    @ParameterizedTest
    @DisplayName("증정 선물 시 가격이 기준을 넘지 않는 경우")
    @ValueSource(ints = {100000, 5000})
    void calculateGiftBenefitNotOverStandard(int calculateTotalMoney) {
        Assertions.assertThat(giftService.calculateGiftBenefit(calculateTotalMoney)).isEqualTo(
            0);
    }
}