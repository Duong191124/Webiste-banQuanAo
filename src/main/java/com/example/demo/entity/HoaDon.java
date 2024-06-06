package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdKH", referencedColumnName = "ID")
    private KhachHang kh;

    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "ID")
    private NhanVien nv;

    @Column(name = "NgayMuaHang")
    private LocalDate ngayMuaHang;

    @Column(name = "TrangThai")
    private int trangThai;
}
