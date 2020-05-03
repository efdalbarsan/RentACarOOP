/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Barsan
 */
public class Pikap extends Arac{
    private int yukseklik;
    private int agirlik;
    private int cekis;

    public Pikap() {
    }

    public Pikap(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }

    public int getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(int agirlik) {
        this.agirlik = agirlik;
    }

    public int getCekis() {
        return cekis;
    }

    public void setCekis(int cekis) {
        this.cekis = cekis;
    }

    @Override
    public String toString() {
        return "Pikap{" + "yukseklik=" + yukseklik + ", agirlik=" + agirlik + ", cekis=" + cekis + '}';
    }
    
    
}
