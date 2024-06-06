package com.example.demo.controller;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.repository.HoaDonChiTietRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("hdct")
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietRepo hoaDonChiTietRepository;

    @GetMapping("hdctdetail")
    public String index(Model model, HttpSession session, @RequestParam("idHoaDon") Integer idHoaDon, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "20") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        Page<HoaDonChiTiet> p;
        if (idHoaDon != null) {
            p = hoaDonChiTietRepository.findByHdId(idHoaDon, PageRequest.of(pageNumber - 1, pageSize));
        } else {
            p = hoaDonChiTietRepository.findAll(PageRequest.of(pageNumber - 1, pageSize));
        }

        model.addAttribute("data", p);
        model.addAttribute("idHoaDon", idHoaDon);
        model.addAttribute("pageSize", pageSize);
        return "hdct/hdct";
    }


    @GetMapping("hdctedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDonChiTiet hdct = this.hoaDonChiTietRepository.findById(id).get();
        model.addAttribute("data", hdct);
        return "hdct/hdctedit";
    }

    @PostMapping("hdctupdate/{id}")
    public String update(HoaDonChiTiet hdct){
        this.hoaDonChiTietRepository.save(hdct);
        return "redirect:/hdct/hdct";
    }
}
