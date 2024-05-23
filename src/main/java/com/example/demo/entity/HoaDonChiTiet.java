package com.example.demo.entity;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HoaDonChiTiet {
    private Integer id;
    private Integer idHoaDon;
    private Integer idSPCT;
    @NotBlank(message = "Không bỏ trống số lượng")
    @Negative(message = "Số lượng lớn hơn 0")
    private int soLuong;
    @NotBlank(message = "Không bỏ trống giá")
    @Negative(message = "Giá lớn hơn 0")
    private double donGia;
    private LocalDateTime thoiGian;
    private int trangThai;
}
