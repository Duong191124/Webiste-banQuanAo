package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NhanVien {
    private Integer id;
    @NotBlank(message = "Không được để trống mã")
    private String ma;
    @NotBlank(message = "Không được để trống tên")
    private String ten;
    @NotBlank(message = "Không được để trống tên đăng nhập")
    private String tenDangNhap;
    @NotBlank(message = "Không được để trống mật khẩu")
    private String matKhau;
    private int trangThai;
    private String role;
}
