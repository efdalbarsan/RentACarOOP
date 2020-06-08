/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.MotorArac;
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
public class MotorAracFao extends Fao {

    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("motorArac.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                MotorArac tmp = new MotorArac();
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
                tmp.setRenk(data.substring(data.indexOf('[') + 1, data.indexOf(']')));
                tmp.setTekerlekSayisi(Integer.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf(')'))));
                tmp.setVitesSayisi(Integer.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));
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
        MotorArac mot = (MotorArac) obj;
        mot.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("motorArac.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mot.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Motor kaydetme basarili");
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
            File myObj = new File("motorArac.txt");
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
        MotorArac mot = (MotorArac) obj;
        List<MotorArac> motorAracList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(mot.getPlaka())) {
                motorAracList.add((MotorArac) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("motorArac.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (MotorArac motorArac : motorAracList) {
                bw.write(motorArac.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Motor silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        MotorArac mot = (MotorArac) obj;
        List<MotorArac> motorAracList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(mot.getPlaka())) {
                arac = mot;
            }
            motorAracList.add((MotorArac) arac);
        }

        try {
            FileWriter fw = new FileWriter("motorArac.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (MotorArac motorArac : motorAracList) {
                bw.write(motorArac.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Motor guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
}
