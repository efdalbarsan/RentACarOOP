/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Suv;
import fao.SuvFao;
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
public class SUVController implements Initializable {

    private SuvFao sfao;
    private Suv arac;
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
    private TextField cekis;
    @FXML
    private AnchorPane suvPane;
    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        suvPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        suvPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Suv suv = new Suv();
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
        } else if (!sayiMi(cekis.getText()) || cekis.getText().equals("")) {
            uyariLabel.setText("Lütfen cekis için düzgün deger giriniz!");
        } else if (yakit.getText().equals("")) {
            uyariLabel.setText("Lütfen yakit için düzgün deger giriniz!");
        } else if (!sayiMi(motor.getText()) || motor.getText().equals("")) {
            uyariLabel.setText("Lütfen mmotor için düzgün deger giriniz!");
        } else if (!sayiMi(agirlik.getText()) || agirlik.getText().equals("")) {
            uyariLabel.setText("Lütfen agirlik için düzgün deger giriniz!");
        } else if (!sayiMi(yil.getText()) || yil.getText().equals("")) {
            uyariLabel.setText("Lütfen yil için düzgün deger giriniz!");
        } else {
            suv.setFiyat(Integer.valueOf(fiyat.getText()));
            suv.setAgirlik(Integer.valueOf(agirlik.getText()));
            suv.setKilometre(Integer.valueOf(kilometre.getText()));
            suv.setMarka(marka.getText());
            suv.setModel(model.getText());
            suv.setPlaka(plaka.getText());
            suv.setMotor(Double.valueOf(motor.getText()));
            suv.setCekis(Integer.valueOf(cekis.getText()));
            suv.setVites(vites.getText());
            suv.setYukseklik(Integer.valueOf(yukseklik.getText()));
            suv.setYakit(yakit.getText());
            suv.setYil(Integer.valueOf(yil.getText()));

            getSfao().ekle(suv);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getSfao().plakaList();

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
        getSfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getSfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setAgirlik(Integer.valueOf(agirlik.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setCekis(Integer.valueOf(cekis.getText()));
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
        for (Arac sv : getSfao().getAracList()) {
            System.out.println("dongu" + sv.getPlaka());
            if (sv.getPlaka().equals(term)) {
                setArac((Suv) sv);
                break;
            }
        }
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
        cekis.setText(String.valueOf(getArac().getCekis()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public SuvFao getSfao() {
        if (sfao == null) {
            sfao = new SuvFao();
        }
        return sfao;
    }

    public Suv getArac() {
        if (arac == null) {
            arac = new Suv();
        }
        return arac;
    }

    public void setArac(Suv arac) {
        this.arac = arac;
    }

}
