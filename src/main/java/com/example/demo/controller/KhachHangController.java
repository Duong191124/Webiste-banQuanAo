package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
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
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepo khachHangRepository;

    @GetMapping("khachhang")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "20") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<KhachHang> p = this.khachHangRepository.findAll(pageRequest);
        model.addAttribute("data", p);
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
        this.khachHangRepository.save(kh);
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
        KhachHang kh = this.khachHangRepository.findById(id).get();
        model.addAttribute("data", kh);
        return "khach_hang/khachhangedit";
    }

    @PostMapping("khachhangupdate/{id}")
    public String update(KhachHang kh){
        this.khachHangRepository.save(kh);
        return "redirect:/khach-hang/khachhang";
    }
}
