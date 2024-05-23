package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NhanVienRepository {
    private List<NhanVien> ds = new ArrayList<>();
    private NhanVien LoginRole = null;

    public NhanVienRepository(){
        this.ds.add(new NhanVien(1, "Admin", "Duong", "Admin", "123", 1, "Admin"));
        this.ds.add(new NhanVien(2, "NV02", "Duong", "NV02", "123", 1, "NhanVien"));
        this.ds.add(new NhanVien(3, "NV03", "Nam", "NV03", "123", 1, "NhanVien"));
        this.ds.add(new NhanVien(4, "NV04", "Quan", "NV04", "123", 0, "NhanVien"));
        this.ds.add(new NhanVien(5, "NV05", "Nam", "NV05", "123", 0, "NhanVien"));
    }

    public List<NhanVien> findAll(){
        return this.ds;
    }

    public void create(NhanVien nv){
        this.ds.add(nv);
    }

    public void deleteById(Integer id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if(nv.getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public NhanVien findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if(nv.getId() == id){
                return nv;
            }
        }
        return null;
    }

    public List<NhanVien> findByName(String ten){
        List<NhanVien> result = new ArrayList<>();
        for(NhanVien s : this.ds){
            if(s.getTen().equals(ten)){
                result.add(s);
            }
        }
        return result;
    }

    public List<String> getDistinctProductName() {
        return ds.stream()
                .map(NhanVien::getTen)
                .distinct()
                .collect(Collectors.toList());
    }

    public void Update(NhanVien newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nvold = this.ds.get(i);
            if(nvold.getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

    public List<NhanVien> findPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, ds.size());
        return ds.subList(start, end);
    }

    //Login
    public boolean loginRole(String username, String password){
        for(NhanVien nv : ds){
            if(nv.getTenDangNhap().equals(username) && nv.getMatKhau().equals(password)){
                LoginRole = nv;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        LoginRole = null;
    }

    public String getLoggedInUsername() {
        return LoginRole != null ? LoginRole.getTenDangNhap() : null;
    }

    public NhanVien getLoggedInUser() {
        return LoginRole;
    }

    public boolean isAdmin() {
        return LoginRole != null && "Admin".equals(LoginRole.getRole());
    }

    public boolean isEmployee() {
        return LoginRole != null && "NhanVien".equals(LoginRole.getRole());
    }

}
