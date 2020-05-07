/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Yat;
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
public class YatFao extends Fao{
    
    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("yat.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Yat tmp = new Yat();
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
                tmp.setYolcuKapesitesi(Integer.valueOf(data.substring(data.indexOf('[') + 1, data.indexOf(']'))));
                tmp.setMotorAdeti(Integer.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf(')'))));
                tmp.setMotorGucu(Double.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));
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
        Yat ya = (Yat) obj;
        ya.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("yat.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ya.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Yat kaydetme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }
    @Override
    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File("yat.txt");
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
        Yat ya = (Yat) obj;
        List<Yat> yatList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(ya.getPlaka())) {
                yatList.add((Yat) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("yat.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Yat yat : yatList) {
                bw.write(yat.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Yat silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Yat ya = (Yat) obj;
        List<Yat> yatList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(ya.getPlaka())) {
                arac = ya;
            }
            yatList.add((Yat) arac);
        }

        try {
            FileWriter fw = new FileWriter("yat.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Yat yat : yatList) {
                bw.write(yat.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Yat guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
}
