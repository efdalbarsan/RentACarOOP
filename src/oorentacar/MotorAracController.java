/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.MotorArac;
import fao.MotorAracFao;
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
public class MotorAracController implements Initializable {

    private MotorAracFao mfao;
    private MotorArac arac;
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
    private TextField renk;
    @FXML
    private TextField tekerlekSayisi;
    @FXML
    private TextField vitesSayisi;
    @FXML
    private AnchorPane motorPane;
    
    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        motorPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        motorPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        MotorArac motorArac = new MotorArac();
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (!sayiMi(fiyat.getText()) || fiyat.getText().equals("")) {
            uyariLabel.setText("Lütfen fiyat için düzgün deger giriniz!");
        } else if (!sayiMi(tekerlekSayisi.getText()) || tekerlekSayisi.getText().equals("")) {
            uyariLabel.setText("Lütfen tekerlek sayisi için düzgün deger giriniz!");
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
            uyariLabel.setText("Lütfen motor için düzgün deger giriniz!");
        } else if (!sayiMi(vitesSayisi.getText()) || vitesSayisi.getText().equals("")) {
            uyariLabel.setText("Lütfen vites sayisi için düzgün deger giriniz!");
        } else if (!sayiMi(yil.getText()) || yil.getText().equals("")) {
            uyariLabel.setText("Lütfen yil için düzgün deger giriniz!");
        } else {
            motorArac.setFiyat(Integer.valueOf(fiyat.getText()));
            motorArac.setTekerlekSayisi(Integer.valueOf(tekerlekSayisi.getText()));
            motorArac.setKilometre(Integer.valueOf(kilometre.getText()));
            motorArac.setMarka(marka.getText());
            motorArac.setModel(model.getText());
            motorArac.setPlaka(plaka.getText());
            motorArac.setMotor(Double.valueOf(motor.getText()));
            motorArac.setRenk(renk.getText());
            motorArac.setVites(vites.getText());
            motorArac.setVitesSayisi(Integer.valueOf(vitesSayisi.getText()));
            motorArac.setYakit(yakit.getText());
            motorArac.setYil(Integer.valueOf(yil.getText()));

            getMfao().ekle(motorArac);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getMfao().plakaList();

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
        getMfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getMfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setTekerlekSayisi(Integer.valueOf(tekerlekSayisi.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setRenk(renk.getText());
        getArac().setVites(vites.getText());
        getArac().setVitesSayisi(Integer.valueOf(vitesSayisi.getText()));
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
        for (Arac mot : getMfao().getAracList()) {
            System.out.println("dongu" + mot.getPlaka());
            if (mot.getPlaka().equals(term)) {
                setArac((MotorArac) mot);
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
        renk.setText(getArac().getRenk());
        tekerlekSayisi.setText(String.valueOf(getArac().getTekerlekSayisi()));
        vitesSayisi.setText(String.valueOf(getArac().getVitesSayisi()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public MotorAracFao getMfao() {
        if (mfao == null) {
            mfao = new MotorAracFao();
        }
        return mfao;
    }

    public MotorArac getArac() {
        if (arac == null) {
            arac = new MotorArac();
        }
        return arac;
    }

    public void setArac(MotorArac arac) {
        this.arac = arac;
    }

}