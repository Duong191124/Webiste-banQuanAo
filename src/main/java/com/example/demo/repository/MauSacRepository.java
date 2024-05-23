package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MauSacRepository {
    private List<MauSac> ds;

    public MauSacRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1, "MS01", "Đỏ", 1));
        this.ds.add(new MauSac(2, "MS02", "Đen", 0));
    }

    public List<MauSac> findAll(){
        return this.ds;
    }

    public void create(MauSac ms){
        this.ds.add(ms);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac mauSac = this.ds.get(i);
            if(mauSac.getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public MauSac findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if(ms.getId() == id){
                return ms;
            }
        }
        return null;
    }

    public void Update(MauSac newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if(ms.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<MauSac> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
