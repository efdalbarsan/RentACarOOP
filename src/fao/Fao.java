/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import java.util.List;

/**
 *
 * @author Barsan
 */
public abstract class Fao {

    public abstract void ekle(Object obj);

    public abstract void silme(Object obj);

    public abstract void guncelleme(Object obj);

    public abstract List<Arac> getAracList();
    
    public abstract List<String> plakaList();
    public abstract Arac bul(int id);
    
  

}
