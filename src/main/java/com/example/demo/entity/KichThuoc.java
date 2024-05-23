package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KichThuoc {
    private Integer id;
    @NotBlank(message = "Không được để trống mã")
    private String ma;
    @NotBlank(message = "Không được để trống tên")
    private String ten;
    private int trangThai;
}
