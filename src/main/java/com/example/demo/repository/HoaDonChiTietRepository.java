package com.example.demo.repository;

import com.example.demo.entity.HoaDonChiTiet;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HoaDonChiTietRepository {
    private List<HoaDonChiTiet> ds;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public HoaDonChiTietRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new HoaDonChiTiet(1, 1,1, 10, 500000, localDateTime, 1));
        this.ds.add(new HoaDonChiTiet(2, 2,2, 5, 500000, localDateTime, 0));
    }

    public List<HoaDonChiTiet> findAll(){
        return this.ds;
    }

    public HoaDonChiTiet findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hdct = this.ds.get(i);
            if(hdct.getId() == id){
                return hdct;
            }
        }
        return null;
    }

    public List<HoaDonChiTiet> findByTrangThai(int trangThai){
        return this.ds.stream()
                .filter(s -> s.getTrangThai() == trangThai)
                .collect(Collectors.toList());
    }

    public void Update(HoaDonChiTiet newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hdct = this.ds.get(i);
            if(hdct.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<HoaDonChiTiet> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
