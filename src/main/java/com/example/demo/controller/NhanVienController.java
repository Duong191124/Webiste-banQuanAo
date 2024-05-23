package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @RequestMapping("nhanvien")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<String> productNames = nhanVienRepository.getDistinctProductName();
        List<NhanVien> products = nhanVienRepository.findPage(page, pageSize);
        List<NhanVien> maskedEmployees = products.stream().map(this::maskPassword).collect(Collectors.toList());
        int totalProducts = nhanVienRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("productNames", productNames);
        model.addAttribute("data", maskedEmployees);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "nhan_vien/nhanvien";
    }

    @GetMapping("searchnhanvien")
    public String searchSanPhams(@RequestParam("ten") String ten, Model model) {
        List<NhanVien> products = nhanVienRepository.findByName(ten);
        List<NhanVien> maskedEmployees = products.stream().map(this::maskPassword).collect(Collectors.toList());
        model.addAttribute("data", maskedEmployees);
        List<String> productNames = nhanVienRepository.getDistinctProductName();
        model.addAttribute("productNames", productNames);
        return "nhan_vien/nhanvien";
    }

    //security password
    private NhanVien maskPassword(NhanVien nhanVien) {
        String password = nhanVien.getMatKhau();
        if (password != null) {
            nhanVien.setMatKhau("*".repeat(password.length()));
        }
        return nhanVien;
    }

    @GetMapping("createnhanvien")
    public String create()
    {
        return "nhan_vien/createnhanvien";
    }

    @PostMapping("nhanvienstore")
    public String store(@Valid NhanVien nv, BindingResult validateResult, Model model) {
        if(validateResult.hasErrors()){
            List<FieldError> fieldErrors = validateResult.getFieldErrors();
            Map<String , String> error = new HashMap<>();
            for(FieldError f : fieldErrors){
                error.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", error);
            model.addAttribute("data", nv);
            return "nhan_vien/createnhanvien";
        }
        this.nhanVienRepository.create(nv);
        return "redirect:/nhan-vien/nhanvien";
    }

    @GetMapping("nhanviendelete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/nhanvien";
    }

    @GetMapping("nhanvienedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        NhanVien nv = this.nhanVienRepository.findById(id);
        model.addAttribute("data", nv);
        return "nhan_vien/nhanvienedit";
    }

    @PostMapping("nhanvienupdate/{id}")
    public String update(NhanVien nv){
        this.nhanVienRepository.Update(nv);
        return "redirect:/nhan-vien/nhanvien";
    }
}
