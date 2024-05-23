package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamChiTietRepository {
    private List<SanPhamChiTiet> ds;
    public SanPhamChiTietRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new SanPhamChiTiet(1, 1, 1, 1, "SPCT01", 6, 500000,1));
        this.ds.add(new SanPhamChiTiet(2, 2, 2, 2, "SPCT02", 3, 200000,1));
        this.ds.add(new SanPhamChiTiet(3, 3, 3, 1, "SPCT03", 0, 100000,0));
    }

    public List<SanPhamChiTiet> findAll(){
        return this.ds;
    }

    public void create(SanPhamChiTiet spct){
        this.ds.add(spct);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet spct = this.ds.get(i);
            if(spct.getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public SanPhamChiTiet findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet spct = this.ds.get(i);
            if(spct.getId() == id){
                return spct;
            }
        }
        return null;
    }


    public List<SanPhamChiTiet> findBySPId(int id){
        List<SanPhamChiTiet> spct = new ArrayList<>();
        for(SanPhamChiTiet s : ds ){
            if(s.getId() == id){
                spct.add(s);
            }
        }
        return spct;
    }

    public void Update(SanPhamChiTiet newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet spctold = this.ds.get(i);
            if(spctold.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<SanPhamChiTiet> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
