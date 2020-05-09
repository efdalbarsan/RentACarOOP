/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Kamyon;
import fao.KamyonFao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Barsan
 */
public class KamyonController implements Initializable {

    private KamyonFao kfao;
    private Kamyon arac;
    @FXML
    private TextField plaka;
    @FXML
    private TextField marka;
    @FXML
    private TextField model;
    @FXML
    private TextField yil;
    @FXML
    private TextField kilometre;
    @FXML
    private TextField motor;
    @FXML
    private TextField yakit;
    @FXML
    private TextField vites;
    @FXML
    private TextField fiyat;
    @FXML
    private TextField yukseklik;
    @FXML
    private TextField agirlik;
    @FXML
    private TextField beygir;
    @FXML
    private AnchorPane kamyonPane;

    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        kamyonPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        kamyonPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Kamyon kamyon = new Kamyon();
        // marka.getText().equals("")
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (!sayiMi(fiyat.getText()) || fiyat.getText().equals("")) {
            uyariLabel.setText("Lütfen fiyat için düzgün deger giriniz!");
        } else if (!sayiMi(yukseklik.getText()) || yukseklik.getText().equals("")) {
            uyariLabel.setText("Lütfen yukseklik için düzgün deger giriniz!");
        } else if (vites.getText().equals("")) {
            uyariLabel.setText("Lütfen vites için düzgün deger giriniz!");
        } else if (model.getText().equals("")) {
            uyariLabel.setText("Lütfen model için düzgün deger giriniz!");
        } else if (plaka.getText().equals("")) {
            uyariLabel.setText("Lütfen plaka için düzgün deger giriniz!");
        } else if (!sayiMi(beygir.getText()) ||beygir.getText().equals("")) {
            uyariLabel.setText("Lütfen beygir için düzgün deger giriniz!");
        } else if (yakit.getText().equals("")) {
            uyariLabel.setText("Lütfen yakit için düzgün deger giriniz!");
        } else if (!sayiMi(motor.getText()) || motor.getText().equals("")) {
            uyariLabel.setText("Lütfen mmotor için düzgün deger giriniz!");
        } else if (!sayiMi(agirlik.getText()) || agirlik.getText().equals("")) {
            uyariLabel.setText("Lütfen dingil sayisi için düzgün deger giriniz!");
        } else if (!sayiMi(yil.getText()) || yil.getText().equals("")) {
            uyariLabel.setText("Lütfen yil için düzgün deger giriniz!");
        } else {
            kamyon.setFiyat(Integer.valueOf(fiyat.getText()));
            kamyon.setAgirlik(Integer.valueOf(agirlik.getText()));
            kamyon.setKilometre(Integer.valueOf(kilometre.getText()));
            kamyon.setMarka(marka.getText());
            kamyon.setModel(model.getText());
            kamyon.setPlaka(plaka.getText());
            kamyon.setMotor(Double.valueOf(motor.getText()));
            kamyon.setBeygir(Integer.valueOf(beygir.getText()));
            kamyon.setVites(vites.getText());
            kamyon.setYukseklik(Integer.valueOf(yukseklik.getText()));
            kamyon.setYakit(yakit.getText());
            kamyon.setYil(Integer.valueOf(yil.getText()));

            getKfao().ekle(kamyon);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getKfao().plakaList();

        observableList = FXCollections.observableArrayList();

        observableList.setAll(stringList);

        listView.setItems(observableList);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue + " " + observable.getValue());
                updateForm(newValue);
            }
        });

    }

    @FXML
    private void update(ActionEvent event) {
        getForm();
        getKfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getKfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setAgirlik(Integer.valueOf(agirlik.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setBeygir(Integer.valueOf(beygir.getText()));
        getArac().setVites(vites.getText());
        getArac().setYukseklik(Integer.valueOf(yukseklik.getText()));
        getArac().setYakit(yakit.getText());
        getArac().setYil(Integer.valueOf(yil.getText()));

    }

    boolean sayiMi(String terim) {
        for (int i = 0; i < terim.length(); i++) {
            System.out.println(Character.isAlphabetic(terim.charAt(i)));
            if (Character.isAlphabetic(terim.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void updateForm(String term) {
        for (Arac kam : getKfao().getAracList()) {
            System.out.println("dongu" + kam.getPlaka());
            if (kam.getPlaka().equals(term)) {
                setArac((Kamyon) kam);
                System.out.println("-------------->" + kam.toString());
                break;
            }
        }
        System.out.println("--------------------" + getArac().getPlaka());
        plaka.setText(getArac().getPlaka());
        marka.setText(getArac().getMarka());
        model.setText(getArac().getModel());
        yil.setText(String.valueOf(getArac().getYil()));
        kilometre.setText(String.valueOf(getArac().getKilometre()));
        motor.setText(String.valueOf(getArac().getMotor()));
        yakit.setText(getArac().getYakit());
        vites.setText(getArac().getVites());
        fiyat.setText(String.valueOf(getArac().getFiyat()));
        yukseklik.setText(String.valueOf(getArac().getYukseklik()));
        agirlik.setText(String.valueOf(getArac().getAgirlik()));
        beygir.setText(String.valueOf(getArac().getBeygir()));

        //marka.setText(arc.getModel());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public KamyonFao getKfao() {
        if (kfao == null) {
            kfao = new KamyonFao();
        }
        return kfao;
    }

    public Kamyon getArac() {
        if (arac == null) {
            arac = new Kamyon();
        }
        return arac;
    }

    public void setArac(Kamyon arac) {
        this.arac = arac;
    }

}
