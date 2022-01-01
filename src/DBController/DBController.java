/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;


import Class.DoanhThuThang;
import Class.DonHang;
import Class.NhanVien;
import Class.SanPham;
import Class.SoLuongThang;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
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
    
    public static ArrayList<DonHang> getDonHang(String MANV) {
        ArrayList<DonHang> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select NV.MaNV, TenNV, TongTien, NgayDat from NhanVien NV, DonHang DH where NV.MaNV=DH.MaNV and NV.MaNV=?");
            ps.setString(1, MANV);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String manv = rs.getString("MaNV");
                String tennv = rs.getString("TenNV");
                int tongtien = rs.getInt("TongTien");
                Date ngaydat = rs.getDate("NgayDat");
                DonHang dh;
                dh = new DonHang(manv, tennv, tongtien, ngaydat);
                list.add(dh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return list;
    }

    public static ArrayList<NhanVien> getNhanVien(String MANV) {
        ArrayList<NhanVien> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select NV.MaNV, TenNV, TrangThai from NhanVien NV, DiemDanhNV DDNV where NV.MaNV=DDNV.MaNV and NV.MaNV=?");
            ps.setString(1, MANV);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String manv = rs.getString("MaNV");
                String tennv = rs.getString("TenNV");
                String trangthai = rs.getString("TrangThai");
                NhanVien nv;
                nv = new NhanVien(manv, tennv, trangthai);
                list.add(nv);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return list;
    }

    public static ArrayList<SoLuongThang> getSoLuongThang(String year) {
        ArrayList<SoLuongThang> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "exec SoLuongThang ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String thang = rs.getString("Tháng");
                int tong = rs.getInt("Số lượng hàng hóa");
                SoLuongThang model = new SoLuongThang(thang, tong);
                list.add(model);
            }          
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<DoanhThuThang> getDoanhThuThang(String year) {
        ArrayList<DoanhThuThang> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "exec DoanhThuThang ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String thang = rs.getString("Tháng");
                int tong = rs.getInt("Tổng tiền");
                DoanhThuThang model = new DoanhThuThang(thang, tong);
                list.add(model);
            }          
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
