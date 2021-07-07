/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.entity.LoaiSanPham;
import com.poly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diemp
 */
public class LoaiSanPhamDAO extends DADAO<LoaiSanPham, String> {

    @Override
    public void insert(LoaiSanPham entity) {
        String sql = "INSERT INTO category(IdCategory,NameCategory) VALUES (?,?)";
        XJdbc.update(sql,
                entity.getMaLSP(),
                entity.getTenLSP());
    }

    @Override
    public void update(LoaiSanPham entity) {
        String sql = "UPDATE category SET  NameCategory=? WHERE IdCategory=?";
        XJdbc.update(sql,
                entity.getTenLSP(),
                entity.getMaLSP()
        );
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM category WHERE IdCategory=?";
        XJdbc.update(sql, id);
    }

    @Override
    public LoaiSanPham selectById(String id) {
        String sql = "SELECT * FROM category WHERE IdCategory=?";
        List<LoaiSanPham> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String sql = "SELECT * FROM category";
        return selectBySql(sql);
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    LoaiSanPham entity = new LoaiSanPham();
                    entity.setMaLSP(rs.getString("IdCategory"));
                    entity.setTenLSP(rs.getString("NameCategory"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
