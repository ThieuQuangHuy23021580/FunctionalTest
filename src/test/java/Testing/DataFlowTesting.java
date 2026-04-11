package Testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFlowTesting {

    @Test
    @DisplayName("TC1 [path: 1-2(F)-5(F)-6(REGULAR)-7(F)-13(F)-19(T)-22] input=(7, REGULAR) EO=10")
    void dataFlowTest1() {
        assertEquals(10, CoffeeDiscount.getDiscount(7, "REGULAR"));
    }

    @Test
    @DisplayName("TC2 [path: 1-2(F)-5(F)-6(MEMBER)-8(F)-14(F)-20(T)-23] input=(7, MEMBER) EO=15")
    void dataFlowTest2() {
        assertEquals(15, CoffeeDiscount.getDiscount(7, "MEMBER"));
    }

    @Test
    @DisplayName("TC3 [path: 1-2(F)-5(F)-6(VIP)-9(F)-15(F)-21(T)-24] input=(7, VIP) EO=20")
    void dataFlowTest3() {
        assertEquals(20, CoffeeDiscount.getDiscount(7, "VIP"));
    }
}
