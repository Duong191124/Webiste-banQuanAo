package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.repository.SanPhamChiTietRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("spct")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @RequestMapping("spct")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<SanPhamChiTiet> products = sanPhamChiTietRepository.findPage(page, pageSize);
        int totalProducts = sanPhamChiTietRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("foundData",products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "spct/spct";
    }

    @RequestMapping("createspct")
    public String create(@ModelAttribute("data") SanPhamChiTiet spct) {
        return "spct/createspct";
    }

    @PostMapping("spctstore")
    public String store(@Valid SanPhamChiTiet spct, BindingResult valiResult, Model model) {
        if(valiResult.hasErrors()){
            List<FieldError> fieldErrors =  valiResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for(FieldError f : fieldErrors){
                errors.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", errors);
            model.addAttribute("data", spct);
            return "spct/createspct";
        }
        this.sanPhamChiTietRepository.create(spct);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("spctdelete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamChiTietRepository.deleteById(id);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("spctedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(id);
        model.addAttribute("data", spct);
        return "san_pham/sanphamedit";
    }

    @PostMapping("spctupdate/{id}")
    public String update(SanPhamChiTiet spct){
        this.sanPhamChiTietRepository.Update(spct);
        return "redirect:/san-pham/sanpham";
    }
}
