package fao;

import entity.Musteri;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Barsan
 */
public class MusteriManager {
    private static Musteri gecerliMusteri = null;

    public static Musteri getGecerliMusteri() {
        return gecerliMusteri;
    }

    public static void setGecerliMusteri(Musteri gecerliMusteri) {
        MusteriManager.gecerliMusteri = gecerliMusteri;
    }
    
}
