/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Limuzin;
import entity.Limuzin;
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
public class LimuzinFao extends Fao {

    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("limuzin.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Limuzin tmp = new Limuzin();
                tmp.setArac_id(Integer.valueOf(data.substring(data.indexOf('<') + 1, data.indexOf('>'))));
                tmp.setPlaka(data.substring(data.indexOf('>') + 1, data.indexOf('^')));
                tmp.setMarka(data.substring(data.indexOf('^') + 1, data.indexOf('#')));
                tmp.setModel(data.substring(data.indexOf('#') + 1, data.indexOf('*')));
                tmp.setYil(Integer.valueOf(data.substring(data.indexOf('*') + 1, data.indexOf('$'))));
                tmp.setKilometre(Integer.valueOf(data.substring(data.indexOf('$') + 1, data.indexOf('%'))));
                tmp.setMotor(Double.valueOf(data.substring(data.indexOf('%') + 1, data.indexOf('&'))));
                tmp.setYakit(data.substring(data.indexOf('&') + 1, data.indexOf('{')));
                tmp.setVites(data.substring(data.indexOf('{') + 1, data.indexOf('(')));
                tmp.setFiyat(Integer.valueOf(data.substring(data.indexOf('(') + 1, data.indexOf('['))));
                tmp.setKapiSayisi(Integer.valueOf(data.substring(data.indexOf('[') + 1, data.indexOf(']'))));
                tmp.setUzunluk(Double.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf(')'))));
                tmp.setRenk(data.substring(data.indexOf(')') + 1, data.indexOf('}')));
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
    public void ekle(Object obj) {
        Limuzin lim = (Limuzin) obj;
        lim.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("limuzin.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lim.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Limuzin kaydetme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public Arac bul(int id) {

        for (Arac arac : getAracList()) {
            if (arac.getArac_id() == id) {
                return arac;
            }
        }
        return null;
    }

    @Override
    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File("limuzin.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String tmp = data.substring(data.indexOf('>') + 1, data.indexOf('^'));

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
        Limuzin lim = (Limuzin) obj;
        List<Limuzin> limuzinList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(lim.getPlaka())) {
                limuzinList.add((Limuzin) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("limuzin.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Limuzin limuzin : limuzinList) {
                bw.write(limuzin.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Limuzin silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Limuzin lim = (Limuzin) obj;
        List<Limuzin> limuzinList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(lim.getPlaka())) {
                arac = lim;
            }
            limuzinList.add((Limuzin) arac);
        }

        try {
            FileWriter fw = new FileWriter("limuzin.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Limuzin limuzin : limuzinList) {
                bw.write(limuzin.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Limuzin guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
}
