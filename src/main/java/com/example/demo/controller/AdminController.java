package com.example.demo.controller;

import com.example.demo.repository.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class AdminController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("admin/adminindex")
    public String adminAccess(Model model) {
        if (nhanVienRepository.isAdmin()) {
            model.addAttribute("username", nhanVienRepository.getLoggedInUsername());
            return "admin/adminindex";
        } else {
            model.addAttribute("error", "Access Denied!");
            return "login";
        }
    }
}
