/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Bisiklet;
import fao.BisikletFao;
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
public class BisikletController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private BisikletFao bfao;
    private Bisiklet arac;
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
    private TextField jantboyu;
    @FXML
    private TextField vitesSayisi;
    @FXML
    private AnchorPane bisikletPane;

    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        bisikletPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        bisikletPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Bisiklet bisiklet = new Bisiklet();
        // marka.getText().equals("")
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else if (!sayiMi(fiyat.getText()) || fiyat.getText().equals("")) {
            uyariLabel.setText("Lütfen fiyat için düzgün deger giriniz!");
        } else if (!sayiMi(jantboyu.getText()) || jantboyu.getText().equals("")) {
            uyariLabel.setText("Lütfen jant boyu için düzgün deger giriniz!");
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
        } else if (!sayiMi(vitesSayisi.getText()) || vitesSayisi.getText().equals("")) {
            uyariLabel.setText("Lütfen vites sayisi için düzgün deger giriniz!");
        } else if (!sayiMi(yil.getText()) || yil.getText().equals("")) {
            uyariLabel.setText("Lütfen yil için düzgün deger giriniz!");
        } else {
            bisiklet.setFiyat(Integer.valueOf(fiyat.getText()));
            bisiklet.setJantBoyu(Integer.valueOf(jantboyu.getText()));
            bisiklet.setKilometre(Integer.valueOf(kilometre.getText()));
            bisiklet.setMarka(marka.getText());
            bisiklet.setModel(model.getText());
            bisiklet.setPlaka(plaka.getText());
            bisiklet.setMotor(Double.valueOf(motor.getText()));
            bisiklet.setRenk(renk.getText());
            bisiklet.setVites(vites.getText());
            bisiklet.setVitesSayisi(Integer.valueOf(vitesSayisi.getText()));
            bisiklet.setYakit(yakit.getText());
            bisiklet.setYil(Integer.valueOf(yil.getText()));

            getBfao().ekle(bisiklet);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getBfao().plakaList();

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
        getBfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getBfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setJantBoyu(Integer.valueOf(jantboyu.getText()));
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
        for (Arac bis : getBfao().getAracList()) {
            System.out.println("dongu" + bis.getPlaka());
            if (bis.getPlaka().equals(term)) {
                setArac((Bisiklet) bis);
                System.out.println("-------------->" + bis.toString());
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
        renk.setText(getArac().getRenk());
        jantboyu.setText(String.valueOf(getArac().getJantBoyu()));
        vitesSayisi.setText(String.valueOf(getArac().getVitesSayisi()));

        //marka.setText(arc.getModel());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public BisikletFao getBfao() {
        if (bfao == null) {
            bfao = new BisikletFao();
        }
        return bfao;
    }

    public Bisiklet getArac() {
        if (arac == null) {
            arac = new Bisiklet();
        }
        return arac;
    }

    public void setArac(Bisiklet arac) {
        this.arac = arac;
    }

}
