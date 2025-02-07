package buoi4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVien {
    private Integer maSV;
    private String tenSV;
    private String lop;
    private String khoaHoc;
    private String monHoc;
}
