/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Traktor;
import entity.Traktor;
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
public class TraktorFao extends Fao{
    
    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("traktor.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Traktor tmp = new Traktor();
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
                tmp.setBeygir(Integer.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));
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
        Traktor tra = (Traktor) obj;
        tra.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("traktor.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(tra.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Traktor kaydetme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }
    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File("traktor.txt");
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
        Traktor tra = (Traktor) obj;
        List<Traktor> traktorList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(tra.getPlaka())) {
                traktorList.add((Traktor) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("traktor.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Traktor traktor : traktorList) {
                bw.write(traktor.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Traktor silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Traktor tra = (Traktor) obj;
        List<Traktor> traktorList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(tra.getPlaka())) {
                arac = tra;
            }
            traktorList.add((Traktor) arac);
        }

        try {
            FileWriter fw = new FileWriter("traktor.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Traktor traktor : traktorList) {
                bw.write(traktor.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Traktor guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
}
