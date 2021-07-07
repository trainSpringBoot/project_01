/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuong
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            //tạo danh sách
            List<Object[]> list = new ArrayList<>();
            //hứng kết quả từ câu lệnh sql
            ResultSet rs = XJdbc.query(sql, args);
            //đặc trưng của ResultSet là next() và sự linh hoạt của con trỏ 
            while (rs.next()) {
                //tạo đối tượng với kích thước bằng với số cột trong store procedure
                Object[] vals = new Object[cols.length];
                //vòng lặp truyền dữ liệu trong ResultSet vào đối tượng khai báo phía trên
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                //thêm các đối tượng có trong Object vào danh sách ArrayList
                list.add(vals);
            }
            //đóng kết nối JDBC để tiết kiệm tài nguyên 
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getThongKeSanPham(String idCate) {
        String sql = "{CALL sumOfProduct (?)}";
        //các cột có trong store procedure khai báo trong sql
        String[] cols = {"IdProduct", "NameProduct", "Amount", "Price", "Image", "IdCategory"};
        return this.getListOfArray(sql, cols, idCate);
    }

}
