package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SanPhamRepository {
    private List<SanPham> sp;

    public SanPhamRepository(){
        this.sp = new ArrayList<>();
        this.sp.add(new SanPham(1, "SP01", "Ao", 1));
        this.sp.add(new SanPham(2, "SP02", "Ao", 1));
        this.sp.add(new SanPham(3, "SP03", "Quan", 1));
        this.sp.add(new SanPham(4, "SP04", "Ao", 1));
        this.sp.add(new SanPham(5, "SP05", "Quan", 1));
        this.sp.add(new SanPham(6, "SP06", "Ao", 1));
    }

    public List<SanPham> findAll(){
        return this.sp;
    }

    public void create(SanPham sp1){
        this.sp.add(sp1);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.sp.size(); i++) {
            SanPham sp1 = this.sp.get(i);
            if(sp1.getId() == id){
                this.sp.remove(i);
            }
        }
    }

    public SanPham findById(int id){
        for (int i = 0; i < this.sp.size(); i++) {
            SanPham sp1 = this.sp.get(i);
            if(sp1.getId() == id){
                return sp1;
            }
        }
        return null;
    }

    public List<SanPham> findByName(String ten){
        List<SanPham> result = new ArrayList<>();
        for(SanPham s : this.sp){
            if(s.getTen().equals(ten)){
                result.add(s);
            }
        }
        return result;
    }

    public List<String> getDistinctProductNames() {
        return sp.stream()
                .map(SanPham::getTen)
                .distinct()
                .collect(Collectors.toList());
    }

    public void Update(SanPham newValue){
        for (int i = 0; i < this.sp.size(); i++) {
            SanPham spold = this.sp.get(i);
            if(spold.getId() == newValue.getId()){
                this.sp.set(i, newValue);
            }
        }
    }

    public List<SanPham> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, sp.size());
        return sp.subList(start, end);
    }
}
