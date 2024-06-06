package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.repository.NhanVienRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private NhanVienRepo nhanVienRepository;

    @GetMapping("nhanvien")
    public String index(Model model,HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber,
                        @RequestParam(name = "limit", defaultValue = "20") int pageSize,
                        @RequestParam(value = "keyword", defaultValue = "") String keyword){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        keyword = "%" + keyword + "%";
        Page<NhanVien> ds = this.nhanVienRepository.findByTenLike(keyword, PageRequest.of(pageNumber, pageSize));
        Page<NhanVien> maskedEmployees = ds.map(this::maskPassword);
        model.addAttribute("data", ds);
        model.addAttribute("data", maskedEmployees);
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
    public String create(@ModelAttribute("data") NhanVien nhanVien)
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
        this.nhanVienRepository.save(nv);
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
        NhanVien nv = this.nhanVienRepository.findById(id).get();
        model.addAttribute("data", nv);
        return "nhan_vien/nhanvienedit";
    }

    @PostMapping("nhanvienupdate/{id}")
    public String update(NhanVien nv){
        this.nhanVienRepository.save(nv);
        return "redirect:/nhan-vien/nhanvien";
    }
}
