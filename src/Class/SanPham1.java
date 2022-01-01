/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author quan
 */
public class SanPham1 {
    private String masp;
    private String tensp;
    private String nhasx;
    private String moTa;
    private String ngaySX;
    private String ngayhethan; 
    private int slton;
    private int sltrenquay;
    private int giaban;

    public SanPham1(String masp, String tensp, String nhasx, String moTa, String ngaySX, String ngayhethan, int slton, int sltrenquay, int giaban) {
        this.masp = masp;
        this.tensp = tensp;
        this.nhasx = nhasx;
        this.moTa = moTa;
        this.ngaySX = ngaySX;
        this.ngayhethan = ngayhethan;
        this.slton = slton;
        this.sltrenquay = sltrenquay;
        this.giaban = giaban;
    }
    
    public Object[] toArray() {
        return new Object[]{ masp, tensp, nhasx, moTa, ngaySX, ngayhethan, slton, sltrenquay, giaban};
    }
}
