package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.KichThuocRepo;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepo kichThuocRepository;

    @GetMapping("kichthuoc")
    public String index(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "1") int pageNumber, @RequestParam(name = "limit", defaultValue = "10") int pageSize){
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        if (tenDangNhap == null) {
            return "redirect:/login";
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<KichThuoc> p = this.kichThuocRepository.findAll(pageRequest);
        model.addAttribute("data", p);
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
        this.kichThuocRepository.save(kt);
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
        KichThuoc kt = this.kichThuocRepository.findById(id).get();
        model.addAttribute("data", kt);
        return "kich_thuoc/kichthuocedit";
    }

    @PostMapping("kichthuocupdate/{id}")
    public String update(KichThuoc kt){
        this.kichThuocRepository.save(kt);
        return "redirect:/kich-thuoc/kichthuoc";
    }
}
