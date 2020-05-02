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
public class HasarKaydi {
    private int hasarkaydi_id;
    private boolean boya;
    private boolean cizik;
    private boolean degisim;

    public HasarKaydi() {
    }

    public HasarKaydi(int hasarkaydi_id, boolean boya, boolean cizik, boolean degisim) {
        this.hasarkaydi_id = hasarkaydi_id;
        this.boya = boya;
        this.cizik = cizik;
        this.degisim = degisim;
    }

    public int getHasarkaydi_id() {
        return hasarkaydi_id;
    }

    public void setHasarkaydi_id(int hasarkaydi_id) {
        this.hasarkaydi_id = hasarkaydi_id;
    }

    public boolean isBoya() {
        return boya;
    }

    public void setBoya(boolean boya) {
        this.boya = boya;
    }

    public boolean isCizik() {
        return cizik;
    }

    public void setCizik(boolean cizik) {
        this.cizik = cizik;
    }

    public boolean isDegisim() {
        return degisim;
    }

    public void setDegisim(boolean degisim) {
        this.degisim = degisim;
    }

    @Override
    public String toString() {
        return "HasarKaydi{" + "hasarkaydi_id=" + hasarkaydi_id + ", boya=" + boya + ", cizik=" + cizik + ", degisim=" + degisim + '}';
    }
    
    
    
}
