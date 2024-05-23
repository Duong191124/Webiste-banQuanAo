package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.HoaDonRepository;
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
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @GetMapping("hoadon")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<HoaDon> products = hoaDonRepository.findPage(page, pageSize);
        int totalProducts = hoaDonRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("data", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "hoa_don/hoadon";
    }

    @GetMapping("searchhoadon")
    public String searchSanPhams(@RequestParam("trangThai") int trangThai, Model model) {
        List<HoaDon> ds = hoaDonRepository.findByTrangThai(trangThai);
        model.addAttribute("data", ds);
        return "hoa_don/hoadon";
    }

    @GetMapping("hoadonedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDon hd = this.hoaDonRepository.findById(id);
        model.addAttribute("data", hd);
        return "hoa_don/hoadonedit";
    }

    @PostMapping("hoadonupdate/{id}")
    public String update(HoaDon hd){
        this.hoaDonRepository.Update(hd);
        return "redirect:/hoa-don/hoadon";
    }
}
