package buoi4.service;

import buoi4.model.BaiHat;
import buoi4.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private List<BaiHat> baiHatList = new ArrayList<>();

    public void add(BaiHat bh){
        baiHatList.add(bh);
    }

    public List<BaiHat> getAll(){
        return baiHatList;
    }

    public void update(BaiHat bh,String id){
        for(int i=0;i<baiHatList.size();i++){
            if(baiHatList.get(i).getId() == id){
                baiHatList.set(i,bh);
                return;
            }
        }
    }

    public void delete(String id){
        baiHatList.removeIf(bh -> bh.getId() == id);
    }

    public BaiHat search(String id) {
        for (BaiHat e : baiHatList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
