/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Motor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barsan
 */
public class MotorFao extends Fao{
    
    @Override
    public List<Arac> getAracList(){
        List<Arac> MotorList = new ArrayList<>();
        
       MotorList.add(new Motor());
        
        return MotorList;
    }
    
      @Override
    public void ekle(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void silme(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guncelleme(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> plakaList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
