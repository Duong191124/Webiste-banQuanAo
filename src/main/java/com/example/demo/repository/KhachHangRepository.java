package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class KhachHangRepository {
    private List<KhachHang> ds = new ArrayList<>();

    public KhachHangRepository(){
        this.ds.add(new KhachHang(1, "KH01", "Duong", "03927242725", 1));
        this.ds.add(new KhachHang(2, "KH02", "Duong2", "03927242725", 0));
    }

    public List<KhachHang> findAll(){
        return this.ds;
    }

    public void create(KhachHang kh){
        this.ds.add(kh);
    }

    public void deleteById(Integer id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khachHang = this.ds.get(i);
            if(khachHang.getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public KhachHang findById(Integer id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh = this.ds.get(i);
            if(kh.getId() == id){
                return kh;
            }
        }
        return null;
    }

    public List<KhachHang> findByName(String ten){
        List<KhachHang> result = new ArrayList<>();
        for(KhachHang s : this.ds){
            if(s.getTen().equals(ten)){
                result.add(s);
            }
        }
        return result;
    }

    public List<String> getDistinctProductName() {
        return ds.stream()
                .map(KhachHang::getTen)
                .distinct()
                .collect(Collectors.toList());
    }

    public void Update(KhachHang newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang khold = this.ds.get(i);
            if(khold.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<KhachHang> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }
}
