package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class bai1 {

    // 2. Kiểm tra tính tích của 2 số nguyên
    int multiply(int a, int b) {
        return a * b;
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(6, multiply(2, 3)); // Trung tâm
        Assertions.assertEquals(-6, multiply(-2, 3)); // Giá trị âm
        Assertions.assertEquals(-6, multiply(2, -3)); // Giá trị âm
        Assertions.assertEquals(6, multiply(-2, -3)); // Cả hai âm
        Assertions.assertEquals(0, multiply(0, 5)); // Nhân với 0
        Assertions.assertEquals(0, multiply(5, 0)); // Nhân với 0
        Assertions.assertEquals(1, multiply(1, 1)); // Biên nhỏ nhất
        Assertions.assertEquals(1000000, multiply(1000, 1000)); // Giá trị lớn
        Assertions.assertEquals(-1000000, multiply(-1000, 1000)); // Giá trị lớn âm
        Assertions.assertEquals(2147395600, multiply(46340, 46340)); // Gần giá trị tối đa của int
    }

    @Test
    void testMultiplyInputsAreIntegers() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("xyz");
        });
    }

}
