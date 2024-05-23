package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("kichthuoc")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page){
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        int pageSize = 4;
        List<KichThuoc> products = kichThuocRepository.findPage(page, pageSize);
        int totalProducts = kichThuocRepository.findAll().size();
        int maxPage = (int) Math.ceil((double) totalProducts / pageSize);
        model.addAttribute("data", products);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        return "kich_thuoc/kichthuoc";
    }

    @GetMapping("createkichthuoc")
    public String create()
    {
        return "kich_thuoc/createkichthuoc";
    }

    @PostMapping("kichthuocstore")
    public String store(@Valid KichThuoc kt, BindingResult validateResult, Model model) {
        if(validateResult.hasErrors()){
            List<FieldError> fieldErrors = validateResult.getFieldErrors();
            Map<String , String> error = new HashMap<>();
            for(FieldError f : fieldErrors){
                error.put(f.getField(), f.getDefaultMessage());
            }
            model.addAttribute("error", error);
            model.addAttribute("data", kt);
            return "kich_thuoc/createkichthuoc";
        }
        this.kichThuocRepository.create(kt);
        return "redirect:/kich-thuoc/kichthuoc";
    }

    @GetMapping("kichthuocdelete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/kichthuoc";
    }

    @GetMapping("kichthuocedit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KichThuoc kt = this.kichThuocRepository.findById(id);
        model.addAttribute("data", kt);
        return "kich_thuoc/kichthuocedit";
    }

    @PostMapping("kichthuocupdate/{id}")
    public String update(KichThuoc kt){
        this.kichThuocRepository.Update(kt);
        return "redirect:/kich-thuoc/kichthuoc";
    }
}
