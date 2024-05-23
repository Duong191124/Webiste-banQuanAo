package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHang {
    private Integer id;
    @NotBlank(message = "Không được để trống mã")
    private String ma;
    @NotBlank(message = "Không được để trống tên")
    private String ten;
    @NotBlank(message = "Không được để trống số điện thoại")
    private String soDienThoai;
    private int trangThai;
}
