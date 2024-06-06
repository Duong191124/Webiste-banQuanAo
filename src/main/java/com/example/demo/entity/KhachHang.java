package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống mã")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống tên")
    private String ten;

    @Column(name = "SDT")
    @NotBlank(message = "Không được để trống số điện thoại")
    private String soDienThoai;

    @Column(name = "TrangThai")
    private int trangThai;
}
