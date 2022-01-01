/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Vector;

/**
 *
 * @author TienCris
 */
public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String TrangThai;

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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public NhanVien(String MaNV, String TenNV, String TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.TrangThai = TrangThai;
    }

    public Object[] toArray(){
        return new Object[]{MaNV, TenNV, TrangThai};
    }
    
}
