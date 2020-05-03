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
public class Arac {

    private int arac_id;
    private String plaka;
    private String marka;
    private String model;
    private int yil;
    private int kilometre;
    private double motor;
    private String yakit;
    private String vites;
    private int fiyat;

    public Arac() {
    }

    public Arac(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        this.arac_id = arac_id;
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.kilometre = kilometre;
        this.motor = motor;
        this.yakit = yakit;
        this.vites = vites;
        this.fiyat = fiyat;
    }

    public int getArac_id() {
        return arac_id;
    }

    public void setArac_id(int arac_id) {
        this.arac_id = arac_id;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    

    @Override
    public String toString() {
        return "Arac{" + "arac_id=" + arac_id + ", plaka=" + plaka + ", marka=" + marka + ", model=" + model + ", yil=" + yil + ", kilometre=" + kilometre + ", motor=" + motor + ", yakit=" + yakit + ", vites=" + vites + ", fiyat=" + fiyat + '}';
    }

}
