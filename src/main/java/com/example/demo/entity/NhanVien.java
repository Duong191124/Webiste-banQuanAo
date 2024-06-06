package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống mã")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống tên")
    private String ten;

    @Column(name = "TenDangNhap")
    @NotBlank(message = "Không được để trống tên đăng nhập")
    private String tenDangNhap;

    @Column(name = "MatKhau")
    @NotBlank(message = "Không được để trống mật khẩu")
    private String matKhau;

    @Column(name = "TrangThai")
    private int role;
}
