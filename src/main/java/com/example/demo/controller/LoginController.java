package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("login")
    public String loginPage(Model model) {
        if (nhanVienRepository.getLoggedInUser() != null) {
            return nhanVienRepository.isAdmin() ? "redirect:/admin/adminindex" : "redirect:/user/userindex";
        }
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if(nhanVienRepository.loginRole(username, password)){
            boolean isAdmin = nhanVienRepository.isAdmin();
            boolean isEmployee = nhanVienRepository.isEmployee();
            session.setAttribute("username", username);
            if(isAdmin){
                session.setAttribute("role", "Admin");
                return "redirect:/admin/adminindex";
            }
            if(isEmployee){
                session.setAttribute("role", "NhanVien");
                return "redirect:/user/userindex";
            }
        }
        else{
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        return "login";
    }

    @GetMapping("back")
    public String back(HttpSession session) {
        String role = (String) session.getAttribute("role");

        if ("Admin".equals(role)) {
            return "redirect:/admin/adminindex";
        } else if ("NhanVien".equals(role)) {
            return "redirect:/user/userindex";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("user/userindex")
    public String NhanVien(Model model) {
        if (nhanVienRepository.isEmployee()) {
            model.addAttribute("username", nhanVienRepository.getLoggedInUsername());
            return "user/userindex";
        } else {
            model.addAttribute("error", "Access Denied!");
            return "login";
        }
    }

    @GetMapping("logout")
    public String logout() {
        System.out.println("123");
        nhanVienRepository.logout();
        return "redirect:/login";
    }


}
