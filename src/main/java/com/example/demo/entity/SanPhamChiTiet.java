package com.example.demo.entity;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SanPhamChiTiet {
    private Integer id;
    private Integer idMauSac;
    private Integer idKichThuoc;
    private Integer idSanPham;
    @NotBlank(message = "Không được để trống mã")
    private String ma;
    @NotBlank(message = "không được để trống số lượng")
    private int soLuong;
    @NotBlank(message = "Không được để trống giá")
    @Negative(message = "Giá lớn hơn 0")
    private double donGia;
    private int trangThai;
}
