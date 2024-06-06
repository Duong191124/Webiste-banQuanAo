package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HoaDonRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepo hoaDonRepository;

    @GetMapping("hoadon")
    public String index(Model model,HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "20") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<HoaDon> p = this.hoaDonRepository.findAll(pageRequest);
        model.addAttribute("data", p);
        return "hoa_don/hoadon";
    }

    @GetMapping("hoadonedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDon hd = this.hoaDonRepository.findById(id).get();
        model.addAttribute("data", hd);
        return "hoa_don/hoadonedit";
    }

    @PostMapping("hoadonupdate/{id}")
    public String update(HoaDon hd){
        this.hoaDonRepository.save(hd);
            return "redirect:/hoa-don/hoadon";
    }
}
