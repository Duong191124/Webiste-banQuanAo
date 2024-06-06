package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
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

@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamRepo sanPhamRepository;

    @RequestMapping("sanpham")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "10") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<SanPham> p = this.sanPhamRepository.findAll(pageRequest);
        model.addAttribute("products", p);
        return "san_pham/sanpham";
    }


    @RequestMapping("createsanpham")
    public String create(@ModelAttribute("data") SanPham sp) {
        return "san_pham/createsanpham";
    }

    @PostMapping("sanphamstore")
    public String store(@Valid SanPham sp, BindingResult valiResult, Model model) {
        if(valiResult.hasErrors()){
            List<FieldError> fieldErrors =  valiResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for(FieldError f : fieldErrors){
                errors.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", errors);
            model.addAttribute("data", sp);
            return "san_pham/createsanpham";
        }
        this.sanPhamRepository.save(sp);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("sanphamdelete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("sanphamedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPham sp = this.sanPhamRepository.findById(id).get();
        model.addAttribute("data", sp);
        return "san_pham/sanphamedit";
    }

    @PostMapping("sanphamupdate/{id}")
    public String update(SanPham sp){
        this.sanPhamRepository.save(sp);
        return "redirect:/san-pham/sanpham";
    }
}
