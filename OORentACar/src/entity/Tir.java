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
public class Tir extends Arac{
    private double motor;
    private int dingilSayisi;
    private int yukseklik;

    public Tir() {
    }

    public Tir(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public int getDingilSayisi() {
        return dingilSayisi;
    }

    public void setDingilSayisi(int dingilSayisi) {
        this.dingilSayisi = dingilSayisi;
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }

    @Override
    public String toString() {
        return "Tir{" + "motor=" + motor + ", dingilSayisi=" + dingilSayisi + ", yukseklik=" + yukseklik + '}';
    }
    
    
}
