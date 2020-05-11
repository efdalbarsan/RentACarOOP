/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Rezervasyon;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Barsan
 */
public class RezervasyonFao extends Fao {

    private List<Rezervasyon> rlist = null;
    private MusteriFao mfao = null;

    private Fao afao = null;

    @Override
    public void ekle(Object obj) {
        Rezervasyon rez = (Rezervasyon) obj;
        rez.setRezervasyon_id(getId());

        try {
            FileWriter fw = new FileWriter("rezervasyon.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(rez.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Rezervasyon kaydetme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        for (Rezervasyon rez : RezervasyonListesi()) {
            list.add(rez.getArac().getPlaka());
        }
        return list;
    }

    public List<Rezervasyon> RezervasyonListesi() {
        List<Rezervasyon> list = new ArrayList<>();
        try {
            File myObj = new File("rezervasyon.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Rezervasyon tmp = new Rezervasyon();
                tmp.setRezervasyon_id(Integer.valueOf(data.substring(data.indexOf('!') + 1, data.indexOf('#'))));
                tmp.setKullanici_id(Integer.valueOf(data.substring(data.indexOf('#') + 1, data.indexOf('+'))));
                tmp.setArac_id(Integer.valueOf(data.substring(data.indexOf('+') + 1, data.indexOf('$'))));
                tmp.setAlisTarih(data.substring(data.indexOf('$') + 1, data.indexOf('%')));
                tmp.setVerisTarih(data.substring(data.indexOf('%') + 1, data.indexOf('&')));
                tmp.setTipi(data.substring(data.indexOf('&') + 1, data.indexOf(']')));
                tmp.setArac(getAfao(tmp.getTipi()).bul(tmp.getArac_id()));
                tmp.setMusteri(getMfao().bulMusteri(tmp.getKullanici_id()));
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

    @Override
    public void silme(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guncelleme(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Arac> getAracList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return 1;
    }

    public List<Rezervasyon> getRlist() {
        return rlist;
    }

    public Fao getAfao(String tip) {
        if (tip.equals("taksi")) {
            afao = new TaksiFao();
        } else if (tip.equals("kamyon")) {
            afao = new KamyonFao();
        } else if (tip.equals("tir")) {
            afao = new TirFao();
        } else if (tip.equals("traktor")){
            afao = new TraktorFao();
        } else if (tip.equals("pikap")){
            afao = new PikapFao();
        } else if (tip.equals("bisiklet")){
            afao = new BisikletFao();
        }else if (tip.equals("suv")){
            afao = new SuvFao();
        }else if (tip.equals("yat")){
            afao = new YatFao();
        }else if(tip.equals("limuzin")){
            afao = new LimuzinFao();
        }else{
            afao = new MotorAracFao();
        }

        return afao;
    }

    public MusteriFao getMfao() {
        return mfao == null ? mfao = new MusteriFao() : mfao;
    }
}
