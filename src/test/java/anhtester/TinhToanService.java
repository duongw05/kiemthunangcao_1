package anhtester;

public class TinhToanService {
    public static int tinhTong(int a,int b){
        return a+b;
    }

    public static int tinhHieu(int a,int b){
        return a-b;
    }

    public static int tinhTich(int a,int b){
        return a*b;
    }

    public static int tinhThuong(int a,int b){
        return a/b;
    }

    public static double tinhTrungBinhCong(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }



    // Phương thức tìm vị trí của một phần tử trong mảng
    public int timViTri(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;  // Trả về vị trí (index) nếu tìm thấy
            }
        }
        return -1;  // Trả về -1 nếu không tìm thấy
    }

    public static int tinhTongNSoNguyen(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    public static int tinhTongSoLe(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0) {  // Kiểm tra nếu số là số lẻ
                sum += num;
            }
        }
        return sum;
    }

}
