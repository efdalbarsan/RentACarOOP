/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Barsan
 */
public class Rezervasyon {
    private int rezervasyon_id;
    private Date alisTarih;
    private Date verisTarih;

    public Rezervasyon() {
    }

    public Rezervasyon(int rezervasyon_id, Date alisTarih, Date verisTarih) {
        this.rezervasyon_id = rezervasyon_id;
        this.alisTarih = alisTarih;
        this.verisTarih = verisTarih;
    }

    public int getRezervasyon_id() {
        return rezervasyon_id;
    }

    public void setRezervasyon_id(int rezervasyon_id) {
        this.rezervasyon_id = rezervasyon_id;
    }

    public Date getAlisTarih() {
        return alisTarih;
    }

    public void setAlisTarih(Date alisTarih) {
        this.alisTarih = alisTarih;
    }

    public Date getVerisTarih() {
        return verisTarih;
    }

    public void setVerisTarih(Date verisTarih) {
        this.verisTarih = verisTarih;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" + "rezervasyon_id=" + rezervasyon_id + ", alisTarih=" + alisTarih + ", verisTarih=" + verisTarih + '}';
    }

    
}
