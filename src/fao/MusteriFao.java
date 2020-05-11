package fao;

import entity.Musteri;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Barsan
 */
public class MusteriFao {

    private List<Musteri> mlist = null;

    public void Ekle(Object obj) {
        Musteri mus = (Musteri) obj;
        mus.setMusteri_id(getId());
        try {

            FileWriter fw = new FileWriter("musteri.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mus.toString());
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Musteri> MusteriListesi() {
        List<Musteri> list = new ArrayList<>();
        try {
            File myObj = new File("musteri.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Musteri tmp = new Musteri();
                tmp.setMusteri_id(Integer.valueOf(data.substring(data.indexOf('!') + 1, data.indexOf('#'))));
                tmp.setAdi(data.substring(data.indexOf('#') + 1, data.indexOf('+')));
                tmp.setSoyadi(data.substring(data.indexOf('+') + 1, data.indexOf('$')));
                tmp.setParola(data.substring(data.indexOf('$') + 1, data.indexOf('%')));
                tmp.setKullaniciAdi(data.substring(data.indexOf('%') + 1, data.indexOf('&'))); 
                tmp.setEmail(data.substring(data.indexOf('&') + 1, data.indexOf(']')));
                tmp.setAdmin(Byte.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf('*'))));
                list.add(tmp);
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
    public Musteri bul(int id){
        Musteri tmp = null;
        for (Musteri musteri : MusteriListesi()) {
            if (musteri.getMusteri_id() == id) {
                return tmp;
            }
        }
        
        return null;
    }
   
    public Musteri giris(int id,String parola){
        for (Musteri musteri : getMlist()) {
            if (id == musteri.getMusteri_id()&& parola.equals(musteri.getParola()) ) {
                return musteri;
            }
        }
        return null;
    } 
     public Musteri giris(String email,String parola){
        for (Musteri musteri : getMlist()) {
            if (email.equals(musteri.getEmail())&& parola.equals(musteri.getParola()) ) {
                return musteri;
            }
        }
        return null;
    } 

    public int getId() {
        return getMlist().size();
    }
    
    public Musteri bulMusteri(int id){
        for (Musteri musteri : MusteriListesi()) {
            if (musteri.getMusteri_id() == id) {
                return musteri;
            }
        }
        return null;
    }

    public List<Musteri> getMlist() {
        return MusteriListesi();
    }

}
