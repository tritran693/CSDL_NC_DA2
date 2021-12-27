/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author D4 Computer
 */
public class SanPham {
    private String masp;
    private String tensp;
    private int soluong;

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    public SanPham(String masp, String tensp, int soluong) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
    }
    
    
    public Object[] toArray(){
        return new Object[]{masp, tensp, soluong};
    }
}
