/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author tiencris
 */
public class DonHang {
    private String MaNV;
    private String TenNV;
    private int TongTien;
    private Date NgayDat;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTongTien() {
        return TongTien;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public DonHang(String MaNV, String TenNV, int TongTien, Date NgayDat) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.TongTien = TongTien;
        this.NgayDat = NgayDat;
    }
    
    public Object[] toArray(){
        DecimalFormat format = new DecimalFormat("###,###,###");
        String tongTienString =format.format(TongTien);
        return new Object[]{MaNV, TenNV, tongTienString, NgayDat};
    }
}
