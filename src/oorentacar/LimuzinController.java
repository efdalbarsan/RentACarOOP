/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Limuzin;
import fao.LimuzinFao;
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
public class LimuzinController implements Initializable {

    private LimuzinFao lfao;
    private Limuzin arac;
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
    private TextField kapiSayisi;
    @FXML
    private TextField uzunluk;
    @FXML
    private TextField renk;

    @FXML
    private AnchorPane limuzinPane;

    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        limuzinPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        limuzinPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Limuzin limuzin = new Limuzin();
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (!sayiMi(fiyat.getText()) || fiyat.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (!sayiMi(kapiSayisi.getText()) || kapiSayisi.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (vites.getText().equals("")) {
            uyariLabel.setText("Lütfen vites için düzgün deger giriniz!");
        } else if (model.getText().equals("")) {
            uyariLabel.setText("Lütfen model için düzgün deger giriniz!");
        } else if (plaka.getText().equals("")) {
            uyariLabel.setText("Lütfen plaka için düzgün deger giriniz!");
        } else if (renk.getText().equals("")) {
            uyariLabel.setText("Lütfen renk için düzgün deger giriniz!");
        } else if (yakit.getText().equals("")) {
            uyariLabel.setText("Lütfen yakit için düzgün deger giriniz!");
        } else if (!sayiMi(motor.getText()) || motor.getText().equals("")) {
            uyariLabel.setText("Lütfen mmotor için düzgün deger giriniz!");
        } else if (!sayiMi(uzunluk.getText()) || uzunluk.getText().equals("")) {
            uyariLabel.setText("Lütfen vites sayisi için düzgün deger giriniz!");
        } else if (!sayiMi(yil.getText()) || yil.getText().equals("")) {
            uyariLabel.setText("Lütfen yil için düzgün deger giriniz!");
        } else {
            limuzin.setFiyat(Integer.valueOf(fiyat.getText()));
            limuzin.setKapiSayisi(Integer.valueOf(kapiSayisi.getText()));
            limuzin.setKilometre(Integer.valueOf(kilometre.getText()));
            limuzin.setMarka(marka.getText());
            limuzin.setModel(model.getText());
            limuzin.setPlaka(plaka.getText());
            limuzin.setMotor(Double.valueOf(motor.getText()));
            limuzin.setRenk(renk.getText());
            limuzin.setVites(vites.getText());
            limuzin.setUzunluk(Double.valueOf(uzunluk.getText()));
            limuzin.setYakit(yakit.getText());
            limuzin.setYil(Integer.valueOf(yil.getText()));

            getLfao().ekle(limuzin);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getLfao().plakaList();

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
        getLfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getLfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setKapiSayisi(Integer.valueOf(kapiSayisi.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setRenk(renk.getText());
        getArac().setVites(vites.getText());
        getArac().setUzunluk(Double.valueOf(uzunluk.getText()));
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
        for (Arac lim : getLfao().getAracList()) {
            System.out.println("dongu" + lim.getPlaka());
            if (lim.getPlaka().equals(term)) {
                setArac((Limuzin) lim);
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
        kapiSayisi.setText(String.valueOf(getArac().getKapiSayisi()));
        uzunluk.setText(String.valueOf(getArac().getUzunluk()));
        renk.setText(getArac().getRenk());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public LimuzinFao getLfao() {
        if (lfao == null) {
            lfao = new LimuzinFao();
        }
        return lfao;
    }

    public Limuzin getArac() {
        if (arac == null) {
            arac = new Limuzin();
        }
        return arac;
    }

    public void setArac(Limuzin arac) {
        this.arac = arac;
    }

}
