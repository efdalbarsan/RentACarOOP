/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Taksi;
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
public class TaksiFao extends Fao{
        public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("taksi.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Taksi tmp = new Taksi();
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
                tmp.setTipi(data.substring(data.indexOf('[') + 1, data.indexOf(']')));
                tmp.setSunroof(data.substring(data.indexOf(']') + 1, data.indexOf(')')));
                tmp.setHiz(Integer.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));
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
        Taksi tak = (Taksi) obj;
        tak.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("taksi.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(tak.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Taksi kaydetme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File("taksi.txt");
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
        Taksi tak = (Taksi) obj;
        List<Taksi> taksiList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(tak.getPlaka())) {
                taksiList.add((Taksi) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("taksi.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Taksi taksi : taksiList) {
                bw.write(taksi.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Taksi silme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Taksi tak = (Taksi) obj;
        List<Taksi> taksiList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(tak.getPlaka())) {
                arac = tak;
            }
            taksiList.add((Taksi) arac);
        }

        try {
            FileWriter fw = new FileWriter("taksi.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Taksi taksi : taksiList) {
                bw.write(taksi.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Taksi guncelleme basarili");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
    
}
