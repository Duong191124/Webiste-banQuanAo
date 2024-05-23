package com.example.demo.repository;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KichThuocRepository {
    private List<KichThuoc> ds;

    public KichThuocRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1, "KT01", "Size S", 1));
        this.ds.add(new KichThuoc(2, "KT02", "Size L", 0));
    }

    public List<KichThuoc> findAll(){
        return this.ds;
    }

    public void create(KichThuoc kt){
        this.ds.add(kt);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kichThuoc = this.ds.get(i);
            if(kichThuoc.getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public KichThuoc findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt = this.ds.get(i);
            if(kt.getId() == id){
                return kt;
            }
        }
        return null;
    }

    public void Update(KichThuoc newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt = this.ds.get(i);
            if(kt.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<KichThuoc> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
