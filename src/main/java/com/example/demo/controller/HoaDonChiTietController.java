package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
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
@RequestMapping("hdct")
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @GetMapping("hdct")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<HoaDonChiTiet> products = hoaDonChiTietRepository.findPage(page, pageSize);
        int totalProducts = hoaDonChiTietRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("data", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "hdct/hdct";
    }


    @GetMapping("hdctedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDonChiTiet hdct = this.hoaDonChiTietRepository.findById(id);
        model.addAttribute("data", hdct);
        return "hdct/hdctedit";
    }

    @PostMapping("hdctupdate/{id}")
    public String update(HoaDonChiTiet hdct){
        this.hoaDonChiTietRepository.Update(hdct);
        return "redirect:/hdct/hdct";
    }
}
