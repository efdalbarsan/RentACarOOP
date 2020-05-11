/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Suv;
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
public class SuvFao extends Fao {

    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("suv.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Suv tmp = new Suv();
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
                tmp.setYukseklik(Integer.valueOf(data.substring(data.indexOf('[') + 1, data.indexOf(']'))));
                tmp.setAgirlik(Integer.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf(')'))));
                tmp.setCekis(Integer.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));
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
        Suv sv = (Suv) obj;
        sv.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("suv.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sv.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Suv kaydetme basarili");
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
            File myObj = new File("suv.txt");
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
        Suv sv = (Suv) obj;
        List<Suv> suvList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(sv.getPlaka())) {
                suvList.add((Suv) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("suv.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Suv suv : suvList) {
                bw.write(suv.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Suv silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Suv sv = (Suv) obj;
        List<Suv> suvList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(sv.getPlaka())) {
                arac = sv;
            }
            suvList.add((Suv) arac);
        }

        try {
            FileWriter fw = new FileWriter("suv.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Suv suv : suvList) {
                bw.write(suv.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Suv guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }

}
