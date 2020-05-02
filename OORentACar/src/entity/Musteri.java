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
public class Musteri {
    private int musteri_id;
    private String adi;
    private String soyadi;
    private String parola;
    private String kullaniciAdi;
    private String email;
    private byte admin;

    public Musteri() {
    }

    public Musteri(int musteri_id, String adi, String soyadi, String parola, String kullaniciAdi, String email,byte admin) {
        this.musteri_id = musteri_id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.parola = parola;
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.admin = admin;
    }


    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAdmin() {
        return admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
    }
    
    

    @Override
    public String toString() {
        return "!" + musteri_id + "#" + adi + "+" + soyadi + "$" + parola + "%" + kullaniciAdi + "&" + email + "]"+admin+"*";
    }
    
}
