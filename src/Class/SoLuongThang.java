/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author trisu
 */
public class SoLuongThang {
    private String thang;
    private int tong;

    public SoLuongThang(String thang, int tong) {
        this.thang = thang;
        this.tong = tong;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

    
    
    public Object[] toArray(){
        return new Object[]{thang, tong};
    }
    
}
