package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class bai3 {
    // 4. Tính trung bình cộng của danh sách số nguyên
    double average(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numbers.stream().mapToDouble(Integer::doubleValue).sum() / numbers.size();
    }

    @Test
    void testAverage() {
        Assertions.assertEquals(3.0, average(List.of(2, 3, 4)), 0.0001); // Trung tâm
        Assertions.assertEquals(-2.0, average(List.of(-2, -2, -2)), 0.0001); // Giá trị âm
        Assertions.assertEquals(0.0, average(List.of(0, 0, 0)), 0.0001); // Tất cả là 0
        Assertions.assertEquals(5.5, average(List.of(10, 1)), 0.0001); // Hai số
        Assertions.assertEquals(2.5, average(List.of(1, 2, 3, 4)), 0.0001); // Số chẵn phần tử
        Assertions.assertEquals(3.0, average(List.of(1, 3, 5)), 0.0001); // Số lẻ phần tử
        Assertions.assertEquals(1000.0, average(List.of(1000, 1000, 1000)), 0.0001); // Giá trị lớn
        Assertions.assertEquals(-1000.0, average(List.of(-1000, -1000, -1000)), 0.0001); // Giá trị lớn âm
        Assertions.assertEquals(0.5, average(List.of(0, 1)), 0.0001); // Số 0 và số khác
        Assertions.assertThrows(ArithmeticException.class, () -> average(List.of())); // Danh sách rỗng
    }
}
