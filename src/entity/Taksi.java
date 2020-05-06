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
public class Taksi extends Arac{
    private String tipi;
    private String sunroof;
    private int hiz;

    public Taksi() {
    }

    public Taksi(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public String toFile() {
        return "<"+getArac_id()+">"+getPlaka()+"^"+getMarka()+"#"+getModel()+"*"+getYil()+"$"
                +getKilometre()+"%"+getMotor()+"&"+getYakit()+"{"+getVites()+"("+getFiyat()+"["+tipi +"]"+sunroof+")"+hiz+"}";
    }
    @Override
    public String toString() {
        return "Plaka"+getPlaka();
    } 
}
