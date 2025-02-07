package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class bai4 {
    // 4. Truy xuất phần tử từ mảng
    int getElementAtIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return array[index];
    }

    @Test
    void testGetElementAtIndex() {
        int[] array = {1, 2, 3, 4, 5};
        Assertions.assertEquals(1, getElementAtIndex(array, 0)); // Biên đầu
        Assertions.assertEquals(5, getElementAtIndex(array, 4)); // Biên cuối
        Assertions.assertEquals(3, getElementAtIndex(array, 2)); // Trung tâm
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> getElementAtIndex(array, -1)); // Index âm
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> getElementAtIndex(array, 5)); // Index ngoài phạm vi
    }
}
