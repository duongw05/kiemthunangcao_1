package anhtester;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTinhToan {
    TinhToanService service = new TinhToanService();

    @Test
    public void tinhTong_ValidPositiveNumbers() {
        Assertions.assertEquals(15, service.tinhTong(5, 10));
    }

    @Test
    public void tinhTong_ValidNegativeNumbers() {
        Assertions.assertEquals(-15, service.tinhTong(-5, -10));
    }

    @Test
    public void tinhTong_ValidMixedNumbers() {
        Assertions.assertEquals(5, service.tinhTong(10, -5));
    }

    @Test
    public void tinhTong_ValidZero() {
        Assertions.assertEquals(10, service.tinhTong(0, 10));
    }

    @Test
    public void tinhTong_ValidZeroAndNegative() {
        Assertions.assertEquals(-5, service.tinhTong(0, -5));
    }

    @Test
    public void tinhTong_BothZero() {
        Assertions.assertEquals(0, service.tinhTong(0, 0));
    }

    // Kiểm tra với số dương và số âm lớn
    @Test
    public void tinhTong_LargeMixedNumbers() {
        Assertions.assertEquals(0, service.tinhTong(50000000, -50000000));
    }

    @Test
    public void tinhTong_CloseToMaxValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, service.tinhTong(Integer.MAX_VALUE - 1, 1));
    }


    @Test
    public void tinhTong_CloseToMinValue() {
        Assertions.assertEquals(Integer.MIN_VALUE, service.tinhTong(Integer.MIN_VALUE + 1, -1));
    }



    @Test
    public void tinhHieu_ValidPositiveNumbers() {
        Assertions.assertEquals(5, service.tinhHieu(10, 5));
    }

    @Test
    public void tinhHieu_ValidNegativeNumbers() {
        Assertions.assertEquals(5, service.tinhHieu(-10, -15));
    }

    @Test
    public void tinhHieu_ValidMixedNumbers() {
        Assertions.assertEquals(15, service.tinhHieu(10, -5));
    }

    @Test
    public void tinhHieu_ValidZero() {
        Assertions.assertEquals(0, service.tinhHieu(10, 10));
    }

    @Test
    public void tinhHieu_ZeroAndNegative() {
        Assertions.assertEquals(5, service.tinhHieu(0, -5));
    }

    @Test
    public void tinhHieu_ZeroAndPositive() {
        Assertions.assertEquals(-5, service.tinhHieu(0, 5));
    }

    @Test
    public void tinhHieu_LargePositiveNumbers() {
        Assertions.assertEquals(Integer.MAX_VALUE - 1, service.tinhHieu(Integer.MAX_VALUE, 1));
    }

    @Test
    public void tinhHieu_LargeNegativeNumbers() {
        Assertions.assertEquals(Integer.MIN_VALUE + 1, service.tinhHieu(Integer.MIN_VALUE, -1));
    }


    @Test
    public void tinhTich_ValidPositiveNumbers() {
        Assertions.assertEquals(50, service.tinhTich(5, 10));
    }

    @Test
    public void tinhTich_ValidNegativeNumbers() {
        Assertions.assertEquals(50, service.tinhTich(-5, -10));
    }

    @Test
    public void tinhTich_ValidMixedNumbers() {
        Assertions.assertEquals(-50, service.tinhTich(5, -10));
    }

    @Test
    public void tinhTich_ZeroAndPositive() {
        Assertions.assertEquals(0, service.tinhTich(0, 10));
    }

    @Test
    public void tinhTich_ZeroAndNegative() {
        Assertions.assertEquals(0, service.tinhTich(0, -10));
    }

    @Test
    public void tinhTich_LargePositiveNumbers() {
        // Dùng long để tránh overflow
        long expected = (long) (Integer.MAX_VALUE / 2) * 2;

        // Kiểm tra với giá trị trả về từ phương thức
        Assertions.assertEquals(expected, service.tinhTich(Integer.MAX_VALUE / 2, 2));
    }


    @Test
    public void tinhTich_LargeNegativeNumbers() {
        Assertions.assertEquals(Integer.MIN_VALUE, service.tinhTich(Integer.MIN_VALUE / 2, 2));
    }


    @Test
    public void tinhThuong_ValidPositiveNumbers() {
        Assertions.assertEquals(2, service.tinhThuong(10, 5));
    }

    @Test
    public void tinhThuong_ValidNegativeNumbers() {
        Assertions.assertEquals(2, service.tinhThuong(-10, -5));
    }

    @Test
    public void tinhThuong_ValidMixedNumbers() {
        Assertions.assertEquals(-2, service.tinhThuong(10, -5));
    }

    @Test
    public void tinhThuong_ZeroDividend() {
        Assertions.assertEquals(0, service.tinhThuong(0, 5));
    }

    @Test
    public void tinhThuong_ZeroDivisor() {
        try {
            service.tinhThuong(10, 0);
            Assertions.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void tinhThuong_LargePositiveNumbers() {
        Assertions.assertEquals(Integer.MAX_VALUE, service.tinhThuong(Integer.MAX_VALUE, 1));
    }

    @Test
    public void tinhThuong_LargeNegativeNumbers() {
        Assertions.assertEquals(Integer.MIN_VALUE, service.tinhThuong(Integer.MIN_VALUE, 1));
    }


    @Test
    public void tinhTrungBinhCong_ValidPositiveNumbers() {
        int[] arr = {10, 5, 0};  // Mảng có giá trị dương
        Assertions.assertEquals(5, service.tinhTrungBinhCong(arr));
    }

    @Test
    public void tinhTrungBinhCong_ValidNegativeNumbers() {
        int[] arr = {-10, -5, 0};  // Mảng có giá trị âm
        Assertions.assertEquals(-5, service.tinhTrungBinhCong(arr));
    }

    @Test
    public void tinhTrungBinhCong_ValidMixedNumbers() {
        int[] arr = {10, -10, 0};  // Mảng có giá trị dương và âm
        Assertions.assertEquals(0, service.tinhTrungBinhCong(arr));
    }

    @Test
    public void tinhTrungBinhCong_ValidZero() {
        int[] arr = {0, 0, 0};  // Mảng chỉ có giá trị 0
        Assertions.assertEquals(0, service.tinhTrungBinhCong(arr));
    }

    @Test
    public void tinhTrungBinhCong_LargeNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE};  // Mảng có số lớn
        Assertions.assertEquals(Integer.MAX_VALUE / 2, service.tinhTrungBinhCong(arr));
    }

    @Test
    public void tinhTrungBinhCong_EmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.tinhTrungBinhCong(new int[]{});  // Mảng rỗng
        });
    }


    @Test
    public void tinhTongNSoNguyen_ValidPositiveNumbers() {
        int[] arr = {1, 2, 3, 4, 5};  // Mảng số nguyên dương
        Assertions.assertEquals(15, service.tinhTongNSoNguyen(arr));
    }

    @Test
    public void tinhTongNSoNguyen_ValidNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};  // Mảng số nguyên âm
        Assertions.assertEquals(-15, service.tinhTongNSoNguyen(arr));
    }

    @Test
    public void tinhTongNSoNguyen_ValidMixedNumbers() {
        int[] arr = {10, -5, 5};  // Mảng số nguyên hỗn hợp
        Assertions.assertEquals(10, service.tinhTongNSoNguyen(arr));
    }

    @Test
    public void tinhTongNSoNguyen_ValidZero() {
        int[] arr = {0, 0, 0};  // Mảng số không
        Assertions.assertEquals(0, service.tinhTongNSoNguyen(arr));
    }

    @Test
    public void tinhTongNSoNguyen_LargeNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE};  // Mảng số lớn
        Assertions.assertEquals(Integer.MAX_VALUE * 2L, service.tinhTongNSoNguyen(arr));
    }

    @Test
    public void tinhTongNSoNguyen_EmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.tinhTongNSoNguyen(new int[]{});  // Mảng rỗng
        });
    }


    @Test
    public void tinhTongNSoLe_ValidPositiveNumbers() {
        int[] arr = {1, 3, 5, 7};  // Mảng số lẻ dương
        Assertions.assertEquals(16, service.tinhTongSoLe(arr));
    }

    @Test
    public void tinhTongNSoLe_ValidNegativeNumbers() {
        int[] arr = {-1, -3, -5, -7};  // Mảng số lẻ âm
        Assertions.assertEquals(-16, service.tinhTongSoLe(arr));
    }

    @Test
    public void tinhTongNSoLe_ValidMixedNumbers() {
        int[] arr = {1, -3, 4, -5};  // Mảng số lẻ hỗn hợp
        Assertions.assertEquals(-2, service.tinhTongSoLe(arr));
    }

    @Test
    public void tinhTongNSoLe_ValidZero() {
        int[] arr = {0, 2, 4};  // Mảng không có số lẻ
        Assertions.assertEquals(0, service.tinhTongSoLe(arr));
    }

    @Test
    public void tinhTongNSoLe_LargeNumbers() {
        int[] arr = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 3};  // Mảng số lẻ lớn
        Assertions.assertEquals((long) (Integer.MAX_VALUE - 1) + (Integer.MAX_VALUE - 3), service.tinhTongSoLe(arr));
    }

    @Test
    public void tinhTongNSoLe_EmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.tinhTongSoLe(new int[]{});  // Mảng rỗng
        });
    }

    @Test
    public void timViTri_ValidValue() {
        int[] arr = {1, 2, 3, 4, 5};
        int value = 3;
        Assertions.assertEquals(2, service.timViTri(arr, value));  // Vị trí của 3 là 2 (bắt đầu từ 0)
    }

    @Test
    public void timViTri_ValueNotFound() {
        int[] arr = {1, 2, 3, 4, 5};
        int value = 6;
        Assertions.assertEquals(-1, service.timViTri(arr, value));  // Không tìm thấy, nên trả về -1
    }

    @Test
    public void timViTri_EmptyArray() {
        int[] arr = {};
        int value = 3;
        Assertions.assertEquals(-1, service.timViTri(arr, value));  // Mảng rỗng, không thể tìm thấy
    }

    @Test
    public void timViTri_FirstElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int value = 1;
        Assertions.assertEquals(0, service.timViTri(arr, value));  // Vị trí của 1 là 0
    }

    @Test
    public void timViTri_LastElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int value = 5;
        Assertions.assertEquals(4, service.timViTri(arr, value));  // Vị trí của 5 là 4
    }

    @Test
    public void timViTri_NegativeValue() {
        int[] arr = {-1, -2, -3, -4, -5};
        int value = -3;
        Assertions.assertEquals(2, service.timViTri(arr, value));  // Vị trí của -3 là 2
    }

    @Test
    public void timViTri_DuplicateValues() {
        int[] arr = {1, 2, 3, 3, 5};
        int value = 3;
        Assertions.assertEquals(2, service.timViTri(arr, value));  // Vị trí đầu tiên của 3 là 2
    }

    @Test
    public void timViTri_LargeAndSmallNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int value = Integer.MIN_VALUE;
        Assertions.assertEquals(1, service.timViTri(arr, value));  // Vị trí của Integer.MIN_VALUE là 1
    }




}
