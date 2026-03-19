package Testing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecisionTableTesting {

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
    @DisplayName("T1: hour 1–3, REGULAR → 0%")
    void decisionTest1() {
        assertEquals(0, CoffeeDiscount.getDiscount(2, "REGULAR"));
    }

    @Test
    @DisplayName("T2: hour 1–3, MEMBER → 5%")
    void decisionTest2() {
        assertEquals(5, CoffeeDiscount.getDiscount(2, "MEMBER"));
    }

    @Test
    @DisplayName("T3: hour 1–3, VIP → 10%")
    void decisionTest3() {
        assertEquals(10, CoffeeDiscount.getDiscount(2, "VIP"));
    }

    @Test
    @DisplayName("T4: hour 4–6, REGULAR → 5%")
    void decisionTest4() {
        assertEquals(5, CoffeeDiscount.getDiscount(5, "REGULAR"));
    }

    @Test
    @DisplayName("T5: hour 4–6, MEMBER → 10%")
    void decisionTest5() {
        assertEquals(10, CoffeeDiscount.getDiscount(5, "MEMBER"));
    }

    @Test
    @DisplayName("T6: hour 4–6, VIP → 15%")
    void decisionTest6() {
        assertEquals(15, CoffeeDiscount.getDiscount(5, "VIP"));
    }

    @Test
    @DisplayName("T7: hour > 6, REGULAR → 10%")
    void decisionTest7() {
        assertEquals(10, CoffeeDiscount.getDiscount(10, "REGULAR"));
    }

    @Test
    @DisplayName("T8: hour > 6, MEMBER → 15%")
    void decisionTest8() {
        assertEquals(15, CoffeeDiscount.getDiscount(10, "MEMBER"));
    }

    @Test
    @DisplayName("T9: hour > 6, VIP → 20%")
    void decisionTest9() {
        assertEquals(20, CoffeeDiscount.getDiscount(10, "VIP"));
    }
}