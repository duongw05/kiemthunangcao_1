package buoi4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaiHat {
    private String id;
    private String ten;
    private String tenCaSi;
    private Integer doDai;
    private String tenNhacSi;
}
