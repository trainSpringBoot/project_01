/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.entity;

/**
 *
 * @author diemp
 */
public class NguoiDung {

    String TenND;
    String MatKhau;
    String Email;
    String DiaChi;
    String Hinh;
    boolean VaiTro;

    public NguoiDung(String TenND, String MatKhau, String Email, String DiaChi, String Hinh, boolean VaiTro) {
        this.TenND = TenND;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.Hinh = Hinh;
        this.VaiTro = VaiTro;
    }

    public NguoiDung() {
    }

    public String getTenND() {
        return TenND;
    }

    public void setTenND(String TenND) {
        this.TenND = TenND;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean role) {
        this.VaiTro = VaiTro;
    }

}
