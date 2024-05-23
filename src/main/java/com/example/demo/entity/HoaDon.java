package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HoaDon {
    private Integer id;
    private Integer idKH;
    private Integer idNV;
    private Date ngayMuaHang;

    private int trangThai;
}
