package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.repository.KichThuocRepo;
import com.example.demo.repository.MauSacRepo;
import com.example.demo.repository.SanPhamChiTietRepo;
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

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("spct")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private KichThuocRepo kichThuocRepo;

    @RequestMapping("spct")
    public String index(Model model, HttpSession session, @RequestParam("idSanPham") Integer idSanPham, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "10") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        Page<SanPhamChiTiet> p;
        if (idSanPham != null) {
            p = sanPhamChiTietRepo.findBySpId(idSanPham, PageRequest.of(pageNumber - 1, pageSize));
        } else {
            p = sanPhamChiTietRepo.findAll(PageRequest.of(pageNumber - 1, pageSize));
        }

        model.addAttribute("foundData", p);
        model.addAttribute("idSanPham", idSanPham);
        model.addAttribute("pageSize", pageSize);
        return "spct/spct";
    }

    @RequestMapping("createspct")
    public String create(Model model, @ModelAttribute("data") SanPhamChiTiet spct) {

        List<SanPham> sp = sanPhamRepo.findAll();

        List<MauSac> ms = mauSacRepo.findAll();

        List<KichThuoc> kt = kichThuocRepo.findAll();

        model.addAttribute("availableProducts", sp);
        model.addAttribute("availableColors", ms);
        model.addAttribute("availableSizes", kt);

        return "spct/createspct";
    }


    @PostMapping("spctstore")
    public String store(@Valid @ModelAttribute("spct") SanPhamChiTiet spct, BindingResult valiResult, Model model) {
        if(valiResult.hasErrors()){
            List<FieldError> fieldErrors =  valiResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for(FieldError f : fieldErrors){
                errors.put(f.getField(), f.getDefaultMessage());
            }
            List<SanPham> sp = sanPhamRepo.findAll();

            List<MauSac> ms = mauSacRepo.findAll();

            List<KichThuoc> kt = kichThuocRepo.findAll();

            model.addAttribute("error", errors);
            model.addAttribute("data", spct);
            model.addAttribute("availableProducts", sp);
            model.addAttribute("availableColors", ms);
            model.addAttribute("availableSizes", kt);
            return "spct/createspct";
        }
        this.sanPhamChiTietRepo.save(spct);

        int sanPhamId = spct.getSp().getId();

        return "redirect:/spct/spct?idSanPham=" + sanPhamId;
    }

    @GetMapping("spctdelete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamChiTietRepo.deleteById(id);
        return "redirect:/san-pham/sanpham";
    }

    @GetMapping("spctedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPhamChiTiet spct = this.sanPhamChiTietRepo.findById(id).get();

        List<SanPham> sp = sanPhamRepo.findAll();

        List<MauSac> ms = mauSacRepo.findAll();

        List<KichThuoc> kt = kichThuocRepo.findAll();

        model.addAttribute("availableProducts", sp);
        model.addAttribute("availableColors", ms);
        model.addAttribute("availableSizes", kt);
        model.addAttribute("data", spct);
        return "spct/spctedit";
    }

    @PostMapping("spctupdate/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute SanPhamChiTiet spct){

        SanPhamChiTiet existingSpct = sanPhamChiTietRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product detail ID:" + id));

        existingSpct.setSp(spct.getSp());
        existingSpct.setMs(spct.getMs());
        existingSpct.setKt(spct.getKt());
        existingSpct.setMaSPCT(spct.getMaSPCT());
        existingSpct.setSoLuong(spct.getSoLuong());
        existingSpct.setDonGia(spct.getDonGia());
        existingSpct.setTrangThai(spct.getTrangThai());

        sanPhamChiTietRepo.save(existingSpct);

        int sanPhamId = existingSpct.getSp().getId();
        return "redirect:/spct/spct?idSanPham=" + sanPhamId;
    }
}
