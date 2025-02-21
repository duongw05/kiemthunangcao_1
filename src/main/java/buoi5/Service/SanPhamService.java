package buoi5.Service;

import buoi5.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> danhSachSanPham = new ArrayList<>();

    public void themSanPham(SanPham sp) {
        danhSachSanPham.add(sp);
    }

    public boolean xoaSanPham(String id) {
        return danhSachSanPham.removeIf(sp -> sp.getId().equals(id));
    }

    public boolean kiemTraMaTonTai(String id) {
        return danhSachSanPham.stream().anyMatch(sp -> sp.getId().equals(id));
    }
}
