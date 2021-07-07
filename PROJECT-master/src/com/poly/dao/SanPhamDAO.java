/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.entity.LoaiSanPham;
import com.poly.entity.NguoiDung;
import com.poly.entity.SanPham;
import com.poly.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diemp
 */
public class SanPhamDAO extends DADAO<SanPham, String> {

    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT * FROM product";
        return selectBySql(sql);
    }

    @Override
    public void insert(SanPham entity) {
        String sql = "INSERT INTO product (IdProduct,NameProduct,Amount,Price,Image,IdCategory) VALUES (?,?,?,?,?,?)";
        XJdbc.update(sql, entity.getMaSP(),
                entity.getTenSP(),
                entity.getSoLuong(),
                entity.getDonGia(),
                entity.getHinh(),
                entity.getMaLoaiSP());
    }

    @Override
    public void update(SanPham entity) {
        String sql = "UPDATE product SET NameProduct=?,Amount=?,Price=?,Image=?,IdCategory=? WHERE IdProduct=?";
        XJdbc.update(sql, entity.getTenSP(),
                entity.getSoLuong(),
                entity.getDonGia(),
                entity.getHinh(),
                entity.getMaLoaiSP(),
                entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM product WHERE IdProduct=?";
        XJdbc.update(sql, id);
    }

    @Override
    public SanPham selectById(String MaSP) {
        String sql = "SELECT * FROM product WHERE IdProduct=?";
        List<SanPham> list = this.selectBySql(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaSP(rs.getString("IdProduct"));
                    sp.setTenSP(rs.getString("NameProduct"));
                    sp.setSoLuong(rs.getDouble("Amount"));
                    sp.setDonGia(rs.getDouble("Price"));
                    sp.setHinh(rs.getString("Image"));
                    sp.setMaLoaiSP(rs.getString("IdCategory"));
                    list.add(sp);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }

    public List<SanPham> selectById(LoaiSanPham kh) {
        String sql = "SELECT * FROM product WHERE IdCategory=?";
        List<SanPham> list = this.selectBySql(sql, kh);
        return selectBySql(sql);
    }

    public List<SanPham> selectById(SanPham MaSP) {
        String sql = "SELECT * FROM product WHERE IdCategory=?";
        List<SanPham> list = this.selectBySql(sql, MaSP);
        return selectBySql(sql);
    }

    public List<SanPham> selectNotInCourse(String keyword) {
        String sql = "SELECT * FROM product "
                + " WHERE IdProduct LIKE ? ";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<SanPham> selectAZ() {
        String sql = "SELECT * FROM product "
                + " ORDER BY IdProduct desc";
        return this.selectBySql(sql);
    }

    public List<SanPham> selectZA() {
        String sql = "SELECT * FROM product "
                + " ORDER BY IdProduct asc";
        return this.selectBySql(sql);
    }
}
