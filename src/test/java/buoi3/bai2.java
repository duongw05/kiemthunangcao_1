package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class bai2 {
    //  Kiểm tra phép chia của 2 số nguyên
    int divide(int a, int b) {
        return a / b;
    }

    // chia 2 số nguyên
    @Test
    void testDivide() {
        Assertions.assertEquals(2, divide(6, 3)); // Trung tâm
        Assertions.assertEquals(-2, divide(-6, 3)); // Giá trị âm
        Assertions.assertEquals(-2, divide(6, -3)); // Giá trị âm
        Assertions.assertEquals(2, divide(-6, -3)); // Cả hai âm
        Assertions.assertEquals(0, divide(0, 5)); // Chia 0 cho số dương
        Assertions.assertEquals(0, divide(0, -5)); // Chia 0 cho số âm
        Assertions.assertEquals(1, divide(5, 5)); // Chia 2 số giống nhau
        Assertions.assertEquals(1000, divide(1000000, 1000)); // Giá trị lớn
        Assertions.assertEquals(-1000, divide(-1000000, 1000)); // Giá trị lớn âm
        Assertions.assertThrows(ArithmeticException.class, () -> divide(5, 0)); // Chia cho 0
    }

    @Test
    void testDivideInputsAreIntegers() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("xyz");
        });
    }
}
