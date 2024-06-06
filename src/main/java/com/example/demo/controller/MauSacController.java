package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepo;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepo mauSacRepository;

    @GetMapping("mausac")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "10") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<MauSac> p = this.mauSacRepository.findAll(pageRequest);
        model.addAttribute("data", p);
        return "mau_sac/mausac";
    }

    @GetMapping("createmausac")
    public String create()
    {
        return "mau_sac/createmausac";
    }

    @PostMapping("mausacstore")
    public String store(@Valid MauSac ms, BindingResult validateResult, Model model) {
        if(validateResult.hasErrors()){
            List<FieldError> fieldErrors = validateResult.getFieldErrors();
            Map<String , String> error = new HashMap<>();
            for(FieldError f : fieldErrors){
                error.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", error);
            model.addAttribute("data", ms);
            return "mau_sac/createmausac";
        }
        this.mauSacRepository.save(ms);
        return "redirect:/mau-sac/mausac";
    }

    @GetMapping("mausacdelete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/mausac";
    }

    @GetMapping("mausacedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MauSac ms = this.mauSacRepository.findById(id).get();
        model.addAttribute("data", ms);
        return "mau_sac/mausacedit";
    }

    @PostMapping("mausacupdate/{id}")
    public String update(MauSac ms){
        this.mauSacRepository.save(ms);
        return "redirect:/mau-sac/mausac";
    }
}
