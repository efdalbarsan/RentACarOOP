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
public class Motor extends Arac{
    private String renk;
    private int tekerlekSayisi;
    private int motorGucu;

    public Motor() {
    }

    public Motor(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getTekerlekSayisi() {
        return tekerlekSayisi;
    }

    public void setTekerlekSayisi(int tekerlekSayisi) {
        this.tekerlekSayisi = tekerlekSayisi;
    }

    public int getMotorGucu() {
        return motorGucu;
    }

    public void setMotorGucu(int motorGucu) {
        this.motorGucu = motorGucu;
    }

    @Override
    public String toString() {
        return "Motor{" + "renk=" + renk + ", tekerlekSayisi=" + tekerlekSayisi + ", motorGucu=" + motorGucu + '}';
    }

 
    
    
}
