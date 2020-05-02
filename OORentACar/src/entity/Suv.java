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
public class Suv extends Arac{
    private double yukseklik;
    private double agirlik;
    private String cekis;

    public Suv() {
    }

    public Suv(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public double getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(double yukseklik) {
        this.yukseklik = yukseklik;
    }

    public double getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(double agirlik) {
        this.agirlik = agirlik;
    }

    public String getCekis() {
        return cekis;
    }

    public void setCekis(String cekis) {
        this.cekis = cekis;
    }

    @Override
    public String toString() {
        return "Suv{" + "yukseklik=" + yukseklik + ", agirlik=" + agirlik + ", cekis=" + cekis + '}';
    }

}
