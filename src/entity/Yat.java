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
public class Yat extends Arac{
    private int yolcuKapesitesi;
    private int motorAdeti;
    private double motorGucu;

    public Yat() {
    }

    public Yat(int arac_id, String plaka, String marka, String model, int yil, int kilometre, double motor, String yakit, String vites, int fiyat) {
        super(arac_id, plaka, marka, model, yil, kilometre, motor, yakit, vites, fiyat);
    }

    public int getYolcuKapesitesi() {
        return yolcuKapesitesi;
    }

    public void setYolcuKapesitesi(int yolcuKapesitesi) {
        this.yolcuKapesitesi = yolcuKapesitesi;
    }

    public int getMotorAdeti() {
        return motorAdeti;
    }

    public void setMotorAdeti(int motorAdeti) {
        this.motorAdeti = motorAdeti;
    }

    public double getMotorGucu() {
        return motorGucu;
    }

    public void setMotorGucu(double motorGucu) {
        this.motorGucu = motorGucu;
    }

    @Override
    public String toString() {
        return "Yat{" + "yolcuKapesitesi=" + yolcuKapesitesi + ", motorAdeti=" + motorAdeti + ", motorGucu=" + motorGucu + '}';
    }
    
    
}
