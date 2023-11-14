package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StarDateServiceTest {


    StarDateService starDateService;

    @BeforeEach
    void init(){
        starDateService = new StarDateService();
    }

    @ParameterizedTest
    @DisplayName("별표 날이 아닌 경우!")
    @ValueSource(ints = {1,2,4,5})
    void noStarDate(int date){
        Assertions.assertThat(starDateService.calculateStarDateSale(date)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("별표 날인 경우!")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void starDate(int date){
        Assertions.assertThat(starDateService.calculateStarDateSale(date)).isEqualTo(-1000);
    }
}