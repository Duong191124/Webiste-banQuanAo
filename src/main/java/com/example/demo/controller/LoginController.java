package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes({"tenDangNhap", "role"})
public class LoginController {

    @Autowired
    private NhanVienRepo nhanVienRepo;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @PostMapping("login")
    public String login(@RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String matKhau, Model model) {
        NhanVien nv = nhanVienRepo.findByTenDangNhap(tenDangNhap);
        if (nv != null && nv.getMatKhau().equals(matKhau)) {
            model.addAttribute("tenDangNhap", tenDangNhap);
            model.addAttribute("role", nv.getRole());
            if (nv.getRole() == 1) {
                return "redirect:/admin/adminindex";
            } else {
                return "redirect:/user/userindex";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("admin/adminindex")
    public String admin(HttpSession session, Model model) {
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        Integer role = (Integer) session.getAttribute("role");
        if (tenDangNhap == null || role == null || role != 1) {
            return "redirect:/login";
        }

        // Add necessary attributes to the model
        model.addAttribute("adminName", tenDangNhap);
        return "admin/adminindex";
    }

    @GetMapping("user/userindex")
    public String user(HttpSession session, Model model) {
        String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        Integer role = (Integer) session.getAttribute("role");
        if (tenDangNhap == null|| role == null || role != 0) {
            return "redirect:/login";
        }

        model.addAttribute("userName", tenDangNhap);
        return "user/userindex";
    }

    @GetMapping("logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }

}
