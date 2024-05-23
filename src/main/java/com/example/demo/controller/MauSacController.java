package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.MauSacRepository;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("mausac")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<MauSac> products = mauSacRepository.findPage(page, pageSize);
        int totalProducts = mauSacRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("data", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
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
        this.mauSacRepository.create(ms);
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
        MauSac ms = this.mauSacRepository.findById(id);
        model.addAttribute("data", ms);
        return "mau_sac/mausacedit";
    }

    @PostMapping("mausacupdate/{id}")
    public String update(MauSac ms){
        this.mauSacRepository.Update(ms);
        return "redirect:/mau-sac/mausac";
    }
}
