/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;


import Class.SanPham;
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
 * @author trisu
 */
public class DBController {
    //Demo cho 2 trường hợp các lệnh thêm, xóa sửa và lệnh get dữ liệu
    public static boolean insert(String maHD, String maKH, String date){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO HoaDon VALUES(?,?,?,0)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, maHD);
            preparedStatement.setString(2, maKH);
            preparedStatement.setString(3, date);
            
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ArrayList<DoiTac> getTenDoiTac(){
        ArrayList<DoiTac> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select MaDT,TenDoiTac from DoiTac");
            while(rs.next()){
                String id = rs.getString("MaDT");
                String ten = rs.getString("TenDoiTac");
                
                DoiTac dt = new DoiTac(id,ten);
                list.add(dt);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<SanPham> getSanPham1() {
        ArrayList<SanPham> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select * from SanPham");
            while(rs.next()){
                String madh = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                int soluongtrenquay = rs.getInt("SoLuongTrenQuay");
                 
                SanPham dh;
                dh = new SanPham(madh, tensp, soluongtrenquay);
                list.add(dh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<SanPham> getSanPham2() {
        ArrayList<SanPham> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select * from SanPham");
            while(rs.next()){
                String madh = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                int soluongton = rs.getInt("SoLuongTon");
                 
                SanPham dh;
                dh = new SanPham(madh, tensp, soluongton);
                list.add(dh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
