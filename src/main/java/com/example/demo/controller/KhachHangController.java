package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.KhachHangRepository;
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

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("khachhang")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<String> productNames = khachHangRepository.getDistinctProductName();
        List<KhachHang> products = khachHangRepository.findPage(page, pageSize);
        int totalProducts = khachHangRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("productNames", productNames);
        model.addAttribute("data", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "khach_hang/khachhang";
    }

    @GetMapping("searchkhachhang")
    public String searchSanPhams(@RequestParam("ten") String ten, Model model) {
        List<KhachHang> products = khachHangRepository.findByName(ten);
        model.addAttribute("data", products);
        List<String> productNames = khachHangRepository.getDistinctProductName();
        model.addAttribute("productNames", productNames);
        return "khach_hang/khachhang";
    }

    @GetMapping("khachhangcreate")
    public String create()
    {
        return "khach_hang/createkhachhang";
    }

    @PostMapping("khachhangstore")
    public String store(@Valid KhachHang kh, BindingResult validateResult, Model model) {
        if(validateResult.hasErrors()){
            List<FieldError> fieldErrors = validateResult.getFieldErrors();
            Map<String , String> error = new HashMap<>();
            for(FieldError f : fieldErrors){
                error.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", error);
            model.addAttribute("data", kh);
            return "khach_hang/createkhachhang";
        }
        this.khachHangRepository.create(kh);
        return "redirect:/khach-hang/khachhang";
    }

    @GetMapping("khachhangdelete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/khachhang";
    }

    @GetMapping("khachhangedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KhachHang kh = this.khachHangRepository.findById(id);
        model.addAttribute("data", kh);
        return "khach_hang/khachhangedit";
    }

    @PostMapping("khachhangupdate/{id}")
    public String update(KhachHang kh){
        this.khachHangRepository.Update(kh);
        return "redirect:/khach-hang/khachhang";
    }
}
