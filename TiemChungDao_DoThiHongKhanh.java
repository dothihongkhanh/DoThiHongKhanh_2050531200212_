/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao_DoThiHongKhanh;

import Model_DoThiHongKhanh.TiemChung_DoThiHongKhanh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class TiemChungDao_DoThiHongKhanh {
     public List<TiemChung_DoThiHongKhanh> getAllUsers() throws SQLException {
        List<TiemChung_DoThiHongKhanh> users = new ArrayList<TiemChung_DoThiHongKhanh>();

        Connection connection = ConnectDB_DoThiHongKhanh.getJBDCConnection();

        String sql = "SELECT * FROM TiemChung_DoThiHongKhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TiemChung_DoThiHongKhanh tc = new TiemChung_DoThiHongKhanh();
                tc.setSTT_12(rs.getInt("STT"));
                tc.setSoCMND_12(rs.getInt("SOCMND"));
                tc.setHoTen_12(rs.getString("HOTEN"));
                tc.setSDT_12(rs.getString("SDT"));
                tc.setDiaChi_12(rs.getString("DIACHI"));
                tc.setNgayTiem_12(rs.getString("NGAYTIEM"));
                tc.setDiaChiTiem_12(rs.getString("DIACGITIEM"));
                tc.setTenVacxin_12(rs.getString("TENVACXIN"));
                users.add(tc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public void addTC(TiemChung_DoThiHongKhanh tc) throws SQLException {
        Connection connection = ConnectDB_DoThiHongKhanh.getJBDCConnection();
        String sql = "INSERT INTO TiemChung_DoThiHongKhanh (STT, SOCMND, HOTEN, SDT, DIACHI, NGAYTIEM,  TENVACXIN) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tc.getSoCMND_12());
            preparedStatement.setString(2, tc.getHoTen_12());
            preparedStatement.setString(3, tc.getSDT_12());
            preparedStatement.setString(4, tc.getDiaChi_12());
            preparedStatement.setString(5, tc.getNgayTiem_12());
            preparedStatement.setString(6, tc.getTenVacxin_12());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTC(TiemChung_DoThiHongKhanh tc) throws SQLException {
        Connection connection = ConnectDB_DoThiHongKhanh.getJBDCConnection();
        String sql = "UPDATE TiemChung_DoThiHongKhanh SET SOCMND = ?, HOTEN = ?, SDT = ?,DIACHI = ?," + "NGAYTIEM = ?, TENVACXIN = ? WHERE STT =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tc.getSoCMND_12());
            preparedStatement.setString(2, tc.getHoTen_12());
            preparedStatement.setString(3, tc.getSDT_12());
            preparedStatement.setString(4, tc.getDiaChi_12());
            preparedStatement.setString(5, tc.getNgayTiem_12());
            preparedStatement.setString(6, tc.getTenVacxin_12());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
