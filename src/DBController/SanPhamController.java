/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBController;


import Class.SanPham1;
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
public class SanPhamController {
    public static boolean insert(String maSP, String tenSP, String nhaSX, String moTa, String ngaySX, String ngayHH, int slTon, int slTrenQuay, int giaBan){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO SanPham VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, maSP);
            preparedStatement.setString(2, tenSP);
            preparedStatement.setString(3, nhaSX);
            preparedStatement.setString(4, moTa);
            preparedStatement.setString(5, ngaySX);
            preparedStatement.setString(6, ngayHH);
            preparedStatement.setInt(7, slTon);
            preparedStatement.setInt(8, slTrenQuay);
            preparedStatement.setInt(9, giaBan);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList<SanPham1> getSanPham() {
        ArrayList<SanPham1> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select * from SanPham");
            while(rs.next()){
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String nhaSX = rs.getString("NhaSX");
                String moTa = rs.getString("MoTa");
                String ngaySX = rs.getString("NgaySX");
                String ngayHH = rs.getString("NgayHetHan");
                int slTon = rs.getInt("SoLuongTon");
                int slTrenQuay = rs.getInt("SoLuongTrenQuay");
                int giaBan = rs.getInt("GiaBan");

                SanPham1 sp;
                sp = new SanPham1(maSP, tenSP, nhaSX, moTa, ngaySX, ngayHH, slTon, slTrenQuay, giaBan);
                list.add(sp);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static boolean update(String maSP, String tenSP, String nhaSX, String moTa, String ngaySX, String ngayHH, int slTon, int slTrenQuay, int giaBan){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "Update SanPham set TenSP=?, NhaSX=?, MoTa=?, NgaySX=?, NgayHetHan=?, SoLuongTon=?, SoLuongTrenQuay=?, GiaBan=? where MaSP=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, tenSP);
            preparedStatement.setString(2, nhaSX);
            preparedStatement.setString(3, moTa);
            preparedStatement.setString(4, ngaySX);
            preparedStatement.setString(5, ngayHH);
            preparedStatement.setInt(6, slTon);
            preparedStatement.setInt(7, slTrenQuay);
            preparedStatement.setInt(8, giaBan);
            preparedStatement.setString(9, maSP);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ArrayList<SanPham1> searchSanPham(String opt, String value){
        ArrayList<SanPham1> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement sp = conn.createStatement();
            
            String query = "";
            
            if(opt == "Mã SP"){
                query = "select * from SanPham where MaSP = ?";
            }else if(opt == "Tên SP"){
                query = "select * from SanPham where TenSP like ?";
                value = "%" + value + "%";
            }else if(opt == "Nhà SX"){
                query = "select * from SanPham where NhaSX = ?";
            }
            
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String nhaSX = rs.getString("NhaSX");
                String moTa = rs.getString("MoTa");
                String ngaySX = rs.getString("NgaySX");
                String ngayHH = rs.getString("NgayHetHan");
                int slTon = rs.getInt("SoLuongTon");
                int slTrenQuay = rs.getInt("SoLuongTrenQuay");
                int giaBan = rs.getInt("GiaBan");

                SanPham1 sp1;
                sp1 = new SanPham1(maSP, tenSP, nhaSX, moTa, ngaySX, ngayHH, slTon, slTrenQuay, giaBan);
                list.add(sp1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
