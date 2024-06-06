package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "ID")
    private MauSac ms;

    @ManyToOne
    @JoinColumn(name = "IdKichThuoc", referencedColumnName = "ID")
    private KichThuoc kt;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "ID")
    private SanPham sp;

    @Column(name = "MaSPCT")
    @NotBlank(message = "Không được để trống mã")
    private String maSPCT;

    @Column(name = "SoLuong")
    @Min(value = 1, message = "Số lượng lớn hơn 0")
    private int soLuong;

    @Column(name = "DonGia")
    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private double donGia;

    @Column(name = "TrangThai")
    private int trangThai;
}
