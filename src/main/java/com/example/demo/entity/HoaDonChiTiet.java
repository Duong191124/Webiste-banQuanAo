package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "ID")
    private HoaDon hd;

    @ManyToOne
    @JoinColumn(name = "IdSPCT", referencedColumnName = "ID")
    private SanPhamChiTiet spct;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;

    @Column(name = "ThoiGian")
    private LocalDateTime thoiGian;

    @Column(name = "TrangThai")
    private int trangThai;
}
