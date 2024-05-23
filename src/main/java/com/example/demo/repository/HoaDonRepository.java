package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HoaDonRepository {
    private List<HoaDon> ds;
    private Date date;

    public HoaDonRepository(){
        this.date = new Date();
        this.ds = new ArrayList<>();
        this.ds.add(new HoaDon(1, 1, 1, date, 1));
        this.ds.add(new HoaDon(2, 2, 1, date, 0));
        this.ds.add(new HoaDon(3, 1, 1, date, 1));
        this.ds.add(new HoaDon(4, 3, 1, date, 0));
    }

    public List<HoaDon> findAll(){
        return this.ds;
    }

    public HoaDon findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if(hd.getId() == id){
                return hd;
            }
        }
        return null;
    }

    public List<HoaDon> findByTrangThai(int trangThai){
        return this.ds.stream()
                .filter(s -> s.getTrangThai() == trangThai)
                .collect(Collectors.toList());
    }

    public void Update(HoaDon newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if(hd.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<HoaDon> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
