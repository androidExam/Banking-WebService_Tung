package com.example.hoangminhk4b.bankingwebservice.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("maDoiTac")
    @Expose
    private String maDoiTac;
    @SerializedName("maKhachHang")
    @Expose
    private String maKhachHang;
    @SerializedName("maDonHang")
    @Expose
    private Object maDonHang;
    @SerializedName("soTien")
    @Expose
    private Integer soTien;
    @SerializedName("phi")
    @Expose
    private Integer phi;
    @SerializedName("ngayChuyenTien")
    @Expose
    private String ngayChuyenTien;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDoiTac() {
        return maDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        this.maDoiTac = maDoiTac;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Object getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Object maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Integer getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public Integer getPhi() {
        return phi;
    }

    public void setPhi(Integer phi) {
        this.phi = phi;
    }

    public String getNgayChuyenTien() {
        return ngayChuyenTien;
    }

    public void setNgayChuyenTien(String ngayChuyenTien) {
        this.ngayChuyenTien = ngayChuyenTien;
    }

}