package buoi5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {
    String id, ten, danhMuc;
    int namBaoHanh;
    float gia;
    long soLuong;
}
