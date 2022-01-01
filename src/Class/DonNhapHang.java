/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author quan
 */
public class DonNhapHang {
    private String maDNH;
    private String ngayLapDon;
    private String nguoiLap;
    private long tongTien;
    private String maNSX;

    public String getMaDNH() {
        return maDNH;
    }

    public void setMaDNH(String maDNH) {
        this.maDNH = maDNH;
    }

    public String getNgayLapDon() {
        return ngayLapDon;
    }

    public void setNgayLapDon(String ngayLapDon) {
        this.ngayLapDon = ngayLapDon;
    }

    public String getNguoiLap() {
        return nguoiLap;
    }

    public void setNguoiLap(String nguoiLap) {
        this.nguoiLap = nguoiLap;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public DonNhapHang(String maDNH, String ngayLapDon, String nguoiLap, long tongTien, String maNSX) {
        this.maDNH = maDNH;
        this.ngayLapDon = ngayLapDon;
        this.nguoiLap = nguoiLap;
        this.tongTien = tongTien;
        this.maNSX = maNSX;
    }
 
    public Object[] toArray() {
        return new Object[]{maDNH, ngayLapDon, nguoiLap, tongTien, maNSX};
    }
}
