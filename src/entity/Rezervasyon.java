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
public class Rezervasyon {
    private int rezervasyon_id;
    private int kullanici_id;
    private int arac_id;
    private String tipi;
    private String alisTarih;
    private String verisTarih;
    private Arac arac;
    private Musteri musteri;
    public Rezervasyon() {
    }

    public Rezervasyon(int rezervasyon_id, String alisTarih, String verisTarih) {
        this.rezervasyon_id = rezervasyon_id;
        this.alisTarih = alisTarih;
        this.verisTarih = verisTarih;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public int getRezervasyon_id() {
        return rezervasyon_id;
    }

    public void setRezervasyon_id(int rezervasyon_id) {
        this.rezervasyon_id = rezervasyon_id;
    }

    public String getAlisTarih() {
        return alisTarih;
    }

    public void setAlisTarih(String alisTarih) {
        this.alisTarih = alisTarih;
    }

    public String getVerisTarih() {
        return verisTarih;
    }

    public void setVerisTarih(String verisTarih) {
        this.verisTarih = verisTarih;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getArac_id() {
        return arac_id;
    }

    public void setArac_id(int arac_id) {
        this.arac_id = arac_id;
    }
    
    @Override
    public String toString() {
        return "Rezervasyon{" + "rezervasyon_id=" + rezervasyon_id + ", alisTarih=" + alisTarih + ", verisTarih=" + verisTarih + '}';
    }
    public String toFile() {
        return "!"+rezervasyon_id+"#"+kullanici_id+"+"+arac_id+"$"+alisTarih+"%"+verisTarih+"&"+tipi+"]";
    }
    
}
