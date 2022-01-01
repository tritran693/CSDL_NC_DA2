/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author quan
 */
public class CTDonNhapHang {
    private String maDNH;
    private String maSP;
    private int soLuong;
    private int giaNhap;

    public CTDonNhapHang(String maDNH, String maSP, int soLuong, int giaNhap) {
        this.maDNH = maDNH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }
    
    public Object[] toArray() {
        return new Object[]{maDNH, maSP, soLuong, giaNhap};
    }
}
