/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBController;

import Class.DonNhapHang;
import Class.CTDonNhapHang;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author quan
 */
public class DonNhapHangController {
    public static ArrayList<DonNhapHang> import_history_list(String month, String year) {
        ArrayList<DonNhapHang> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement dn = conn.createStatement();
            String query = "select * from DonNhapHang where MONTH(NgayLapDon) = ? and YEAR(NgayLapDon) = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, month);
            preparedStatement.setString(2, year);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String maDNH = rs.getString("MaDNH");
                String ngayLapDon = rs.getString("NgayLapDon");
                String nguoiLap = rs.getString("NguoiLap");
                long tongTien = rs.getLong("TongTien");
                String maNSX = rs.getString("MaNSX");

                DonNhapHang dnh;
                dnh = new DonNhapHang(maDNH, ngayLapDon, nguoiLap, tongTien, maNSX);
                list.add(dnh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static ArrayList<CTDonNhapHang> get_CTDNH_by_maDNH(String maDN) {
        ArrayList<CTDonNhapHang> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement dn = conn.createStatement();
            String query = "select * from CT_DonNhapHang where MaDNH = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maDN);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String maDNH = rs.getString("MaDNH");
                String maSP = rs.getString("MaSP");
                int soLuong = rs.getInt("SoLuong");
                int giaNhap = rs.getInt("GiaNhap");

                CTDonNhapHang ctdnh;
                ctdnh = new CTDonNhapHang(maDNH, maSP, soLuong, giaNhap);
                list.add(ctdnh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
