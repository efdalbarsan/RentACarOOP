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
public class Kamyon extends Arac{
    private int yukseklik;
    private int agirlik;
    private int beygir;

    public Kamyon() {
    }

    public Kamyon(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
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

    public int getBeygir() {
        return beygir;
    }

    public void setBeygir(int beygir) {
        this.beygir = beygir;
    }

    public String toFile() {
        return "<"+getArac_id()+">"+getPlaka()+"^"+getMarka()+"#"+getModel()+"*"+getYil()+"$"
                +getKilometre()+"%"+getMotor()+"&"+getYakit()+"{"+getVites()+"("+getFiyat()+"["+yukseklik +"]"+agirlik+")"+beygir+"}";
    }
    @Override
    public String toString() {
        return "Plaka"+getPlaka();
    }
    
}
