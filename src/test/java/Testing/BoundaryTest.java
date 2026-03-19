package Testing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoundaryTest {

    @Test
    @DisplayName("hour âm → Exception")
    void invalidTest1() {
        assertThrows(IllegalArgumentException.class, () ->
                CoffeeDiscount.getDiscount(-1, "REGULAR"));
    }

    @Test
    @DisplayName("userType không thuộc {REGULAR, MEMBER, VIP} → Exception")
    void invalidTest2() {
        assertThrows(IllegalArgumentException.class, () ->
                CoffeeDiscount.getDiscount(5, "GUEST"));
    }

    @Test
    @DisplayName("userType là chuỗi rỗng → Exception")
    void invalidTest3() {
        assertThrows(IllegalArgumentException.class, () ->
                CoffeeDiscount.getDiscount(5, ""));
    }

    @Test
    @DisplayName("userType sai định dạng → Exception")
    void invalidTest4() {
        assertThrows(IllegalArgumentException.class, () ->
                CoffeeDiscount.getDiscount(5, "vip"));
    }

    @Test
    @DisplayName("T1: hour=0 (dưới biên hợp lệ) → IllegalArgumentException")
    void boundaryTest1() {
        assertThrows(IllegalArgumentException.class, () ->
                CoffeeDiscount.getDiscount(0, "REGULAR"));
    }

    @DisplayName("T3: hour = 2 (trong khoảng 1–3), REGULAR → 0%")
    @Test
    void boundaryTest3() {
        assertEquals(0, CoffeeDiscount.getDiscount(2, "REGULAR"));
    }


    @Test
    @DisplayName("T4: hour = 3 (biên trên của khoảng 1–3), MEMBER → 5%")
    void boundaryTest4() {
        assertEquals(5, CoffeeDiscount.getDiscount(3, "MEMBER"));
    }

    @Test
    @DisplayName("T5: hour = 4 (biên dưới của khoảng 4–6), MEMBER → 10%")
    void boundaryTest5() {
        assertEquals(10, CoffeeDiscount.getDiscount(4, "MEMBER"));
    }

    @Test
    @DisplayName("T6: hour = 5 (trong khoảng 4–6), MEMBER → 10%")
    void boundaryTest6() {
        assertEquals(10, CoffeeDiscount.getDiscount(5, "MEMBER"));
    }

    @Test
    @DisplayName("T7: hour = 6 (biên trên của khoảng 4–6), VIP → 15%")
    void boundaryTest7() {
        assertEquals(15, CoffeeDiscount.getDiscount(6, "VIP"));
    }

    @Test
    @DisplayName("T8: hour = 7 (biên dưới của khoảng > 6), MEMBER → 15%")
    void boundaryTest8() {
        assertEquals(15, CoffeeDiscount.getDiscount(7, "MEMBER"));
    }

    @Test
    @DisplayName("T9: hour = 24 (biên trên hợp lệ), VIP → 20%")
    void boundaryTest9() {
        assertEquals(20, CoffeeDiscount.getDiscount(24, "VIP"));
    }

    @Test
    @DisplayName("T10: hour=25 (ngoài biên) → IllegalArgumentException")
    void boundaryTest10() {
        assertThrows(IllegalArgumentException.class,
                () -> CoffeeDiscount.getDiscount(25, "VIP"));
    }
}
