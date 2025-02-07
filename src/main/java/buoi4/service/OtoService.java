package buoi4.service;

import buoi4.model.XeOto;

import java.util.ArrayList;
import java.util.List;

public class OtoService {
    private List<XeOto> otoList = new ArrayList<>();

    public void addXeOto(XeOto xe){
        otoList.add(xe);
    }

    public List<XeOto> getAll(){
        return otoList;
    }

    public void updateXeOto(XeOto xeOto,Integer id){
        for(int i=0;i<otoList.size();i++){
            if(otoList.get(i).getId() == id){
                otoList.set(i,xeOto);
                return;
            }
        }
    }

    public void deleteOto(Integer id){
       otoList.removeIf(xe -> xe.getId() == id);
    }

    public XeOto searchXeOTO(int id) {
        for (XeOto xe : otoList) {
            if (xe.getId() == id) {
                return xe;
            }
        }
        return null;
    }
}
