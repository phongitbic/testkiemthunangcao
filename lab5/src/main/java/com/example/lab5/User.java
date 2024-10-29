package com.example.lab5;

import jakarta.persistence.*;

@Entity
@Table(name="sanpham")
public class SanPham {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer namBaoHanh;
    Integer soLuongLon;
    Long giaNhap;
    // getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNamBaoHanh() {
        return namBaoHanh;
    }

    public void setNamBaoHanh(Integer namBaoHanh) {
        this.namBaoHanh = namBaoHanh;
    }

    public Integer getSoLuongLon() {
        return soLuongLon;
    }

    public void setSoLuongLon(Integer soLuongLon) {
        this.soLuongLon = soLuongLon;
    }

    public Long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Long giaNhap) {
        this.giaNhap = giaNhap;
    }
}
