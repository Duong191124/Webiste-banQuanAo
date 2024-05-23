package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private SanPhamRepository sanPhamRepository;

    @RequestMapping("sanpham")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<String> productNames = sanPhamRepository.getDistinctProductNames();
        List<SanPham> products = sanPhamRepository.findPage(page, pageSize);
        int totalProducts = sanPhamRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("productNames", productNames);
        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "san_pham/sanpham";
    }

    @GetMapping("searchsanpham")
    public String searchSanPhams(@RequestParam("name") String name, Model model) {
        List<SanPham> products = sanPhamRepository.findByName(name);
        model.addAttribute("products", products);
        List<String> productNames = sanPhamRepository.getDistinctProductNames();
        model.addAttribute("productNames", productNames);
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
        this.sanPhamRepository.create(sp);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("sanphamdelete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("sanphamedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPham sp = this.sanPhamRepository.findById(id);
        model.addAttribute("data", sp);
        return "san_pham/sanphamedit";
    }

    @PostMapping("sanphamupdate/{id}")
    public String update(SanPham sp){
        this.sanPhamRepository.Update(sp);
        return "redirect:/san-pham/sanpham";
    }
}
