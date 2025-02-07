package buoi4.service;

import buoi4.model.SinhVien;
import buoi4.model.XeOto;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> sinhVienList = new ArrayList<>();

    public void add(SinhVien sv){
        sinhVienList.add(sv);
    }

    public List<SinhVien> getAll(){
        return sinhVienList;
    }

    public void update(SinhVien sinhVien,Integer maSV){
        for(int i=0;i<sinhVienList.size();i++){
            if(sinhVienList.get(i).getMaSV() == maSV){
                sinhVienList.set(i,sinhVien);
                return;
            }
        }
    }

    public void delete(Integer ma){
        sinhVienList.removeIf(xe -> xe.getMaSV() == ma);
    }

    public SinhVien searchSinhVien(int ma) {
        for (SinhVien sv : sinhVienList) {
            if (sv.getMaSV() == ma) {
                return sv;
            }
        }
        return null;
    }
}
