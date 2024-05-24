package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SanPhamChiTietRepository {
    private List<SanPhamChiTiet> ds;
    public SanPhamChiTietRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new SanPhamChiTiet(1, 1, 1, 1, "SPCT01", 6, 500000,1));
        this.ds.add(new SanPhamChiTiet(2, 2, 2, 2, "SPCT02", 3, 200000,1));
        this.ds.add(new SanPhamChiTiet(3, 3, 3, 1, "SPCT03", 5, 100000,1));
        this.ds.add(new SanPhamChiTiet(4, 4, 4, 3, "SPCT04", 6, 500000,1));
        this.ds.add(new SanPhamChiTiet(5, 5, 5, 4, "SPCT05", 3, 200000,1));
        this.ds.add(new SanPhamChiTiet(6, 6, 6, 5, "SPCT06", 10, 100000,1));
        this.ds.add(new SanPhamChiTiet(7, 1, 1, 6, "SPCT07", 6, 500000,1));
        this.ds.add(new SanPhamChiTiet(8, 2, 2, 2, "SPCT08", 3, 200000,1));
        this.ds.add(new SanPhamChiTiet(9, 3, 3, 3, "SPCT09", 8, 100000,1));
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


    public List<SanPhamChiTiet> findBySPId(int idSanPham) {
        return ds.stream()
                .filter(s -> s.getIdSanPham() == idSanPham)
                .collect(Collectors.toList());
    }

    public List<SanPhamChiTiet> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }

    public List<SanPhamChiTiet> findPageBySPId(int idSanPham, int page, int pageSize) {
        List<SanPhamChiTiet> filteredList = findBySPId(idSanPham);
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, filteredList.size());
        return filteredList.subList(start, end);
    }

    public void Update(SanPhamChiTiet newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet spctold = this.ds.get(i);
            if(spctold.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

}
