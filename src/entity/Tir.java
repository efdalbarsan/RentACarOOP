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
public class Tir extends Arac {

    private int yukseklik;
    private int dingilSayisi;
    private int beygir;

    public Tir() {
    }

    public Tir(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }

    public int getDingilSayisi() {
        return dingilSayisi;
    }

    public void setDingilSayisi(int dingilSayisi) {
        this.dingilSayisi = dingilSayisi;
    }

    public int getBeygir() {
        return beygir;
    }

    public void setBeygir(int beygir) {
        this.beygir = beygir;
    }

    

    public String toFile() {
        return "<"+getArac_id()+">"+getPlaka()+"^"+getMarka()+"#"+getModel()+"*"+getYil()+"$"
                +getKilometre()+"%"+getMotor()+"&"+getYakit()+"{"+getVites()+"("+getFiyat()+"["+yukseklik +"]"+dingilSayisi+")"+beygir+"}";
    }
    @Override
    public String toString() {
        return "Plaka"+getPlaka();
    }

}
