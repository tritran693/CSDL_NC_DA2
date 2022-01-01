/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.DecimalFormat;

/**
 *
 * @author trisu
 */
public class DoanhThuThang {
    private String thang;
    private int tongTien;

    public DoanhThuThang(String thang, int tongTien) {
        this.thang = thang;
        this.tongTien = tongTien;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    public Object[] toArray(){ 
        DecimalFormat format = new DecimalFormat("###,###,###");
        String tongTienFormat = format.format(tongTien);
        return new Object[]{thang, tongTienFormat};
    }
    
}
