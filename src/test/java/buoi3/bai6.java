package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class bai6 {
    // bài 7. Tìm phần tử bé nhất trong mảng
    int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return Arrays.stream(array).min().getAsInt();
    }

    @Test
    void testFindMin() {
        Assertions.assertEquals(1, findMin(new int[]{3, 2, 1, 4, 5}));
        Assertions.assertEquals(-5, findMin(new int[]{-1, -2, -3, -4, -5}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> findMin(new int[]{})); // Mảng rỗng
    }

}
