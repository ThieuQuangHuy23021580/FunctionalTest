package Testing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConditionalTesting {
    @Test
    @DisplayName("TC1 [path: 1-2(T)-3-4] hour=0 (< 1) → IllegalArgumentException")
    void getDiscount_hourLessThan1_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> CoffeeDiscount.getDiscount(0, "VIP"));
    }

    @Test
    @DisplayName("TC2 [path: 1-2(F)-5(T)-3-4] hour=25 (> 24) → IllegalArgumentException")
    void getDiscount_hourGreaterThan24_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> CoffeeDiscount.getDiscount(25, "VIP"));
    }

    @Test
    @DisplayName("TC6 [path: 1-2(F)-5(F)-6(MEMBER)-8(T)-11-25] hour=2, MEMBER → 5%")
    void conditionalTest1() {
        assertEquals(5, CoffeeDiscount.getDiscount(2, "MEMBER"));
    }

    @Test
    @DisplayName("TC7 [path: 1-2(F)-5(F)-6(MEMBER)-8(F)-14(T)-17-25] hour=5, MEMBER → 10%")
    void conditionalTest2() {
        assertEquals(10, CoffeeDiscount.getDiscount(5, "MEMBER"));
    }

    @Test
    @DisplayName("TC8 [path: 1-2(F)-5(F)-6(MEMBER)-8(F)-14(F)-20-23-25] hour=7, MEMBER → 15%")
    void conditionalTest3() {
        assertEquals(15, CoffeeDiscount.getDiscount(7, "MEMBER"));
    }

    @Test
    @DisplayName("TC9 [path: 1-2(F)-5(F)-6(VIP)-9(T)-12-25] hour=2, VIP → 10%")
    void conditionalTest4() {
        assertEquals(10, CoffeeDiscount.getDiscount(2, "VIP"));
    }

    @Test
    @DisplayName("TC10 [path: 1-2(F)-5(F)-6(VIP)-9(F)-15(T)-18-25] hour=5, VIP → 15%")
    void conditionalTest5() {
        assertEquals(15, CoffeeDiscount.getDiscount(5, "VIP"));
    }

    @Test
    @DisplayName("TC11 [path: 1-2(F)-5(F)-6(VIP)-9(F)-15(F)-21-24-25] hour=7, VIP → 20%")
    void conditionalTest6() {
        assertEquals(20, CoffeeDiscount.getDiscount(7, "VIP"));
    }
    
}
