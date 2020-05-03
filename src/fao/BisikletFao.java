/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fao;

import entity.Arac;
import entity.Bisiklet;
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
public class BisikletFao extends Fao {

    public List<Arac> getAracList() {
        List<Arac> list = new ArrayList<>();

        try {
            File myObj = new File("bisiklet.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Bisiklet tmp = new Bisiklet();
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
                tmp.setJantBoyu(Integer.valueOf(data.substring(data.indexOf(']') + 1, data.indexOf(')'))));
                tmp.setVitesSayisi(Integer.valueOf(data.substring(data.indexOf(')') + 1, data.indexOf('}'))));

         
                System.out.println(tmp.getPlaka()+"*------------burasi getAraclist");
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
        Bisiklet bis = (Bisiklet) obj;
        bis.setArac_id(getId());

        try {
            FileWriter fw = new FileWriter("bisiklet.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(bis.toFile());
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public List<String> plakaList() {
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File("bisiklet.txt");
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
        Bisiklet bis = (Bisiklet) obj;
        List<Bisiklet> bisikletList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (!arac.getPlaka().equals(bis.getPlaka())) {
                bisikletList.add((Bisiklet) arac);
            }
        }

        try {
            FileWriter fw = new FileWriter("bisiklet.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Bisiklet bisiklet : bisikletList) {
                bw.write(bisiklet.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    @Override
    public void guncelleme(Object obj) {
        Bisiklet bis = (Bisiklet) obj;
        List<Bisiklet> bisikletList = new ArrayList<>();

        for (Arac arac : getAracList()) {
            if (arac.getPlaka().equals(bis.getPlaka())) {
                arac = bis;
            }
            bisikletList.add((Bisiklet) arac);
        }

        try {
            FileWriter fw = new FileWriter("bisiklet.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Bisiklet bisiklet : bisikletList) {
                bw.write(bisiklet.toFile());
                bw.newLine();
            }
            bw.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();

        }
    }

    public int getId() {
        return getAracList().size();
    }
}
