/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Yat;
import fao.YatFao;
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
public class YatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private YatFao yfao;
    private Yat arac;
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
    private TextField yolcuKapesitesi;
    @FXML
    private TextField motorAdeti;
    @FXML
    private TextField motorGucu;
    @FXML
    private AnchorPane yatPane;

    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        yatPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        yatPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Yat yat = new Yat();
        // marka.getText().equals("")
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else {
            yat.setFiyat(Integer.valueOf(fiyat.getText()));
            yat.setYolcuKapesitesi(Integer.valueOf(yolcuKapesitesi.getText()));
            yat.setKilometre(Integer.valueOf(kilometre.getText()));
            yat.setMarka(marka.getText());
            yat.setModel(model.getText());
            yat.setPlaka(plaka.getText());
            yat.setMotor(Double.valueOf(motor.getText()));
            yat.setMotorGucu(Double.valueOf(motorGucu.getText()));
            yat.setVites(vites.getText());
            yat.setMotorAdeti(Integer.valueOf(motorAdeti.getText()));
            yat.setYakit(yakit.getText());
            yat.setYil(Integer.valueOf(yil.getText()));

            getYfao().ekle(yat);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getYfao().plakaList();

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
        getYfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getYfao().silme(getArac());
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setYolcuKapesitesi(Integer.valueOf(yolcuKapesitesi.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setMotorGucu(Double.valueOf(motorGucu.getText()));
        getArac().setVites(vites.getText());
        getArac().setMotorAdeti(Integer.valueOf(motorAdeti.getText()));
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
        for (Arac ya : getYfao().getAracList()) {
            System.out.println("dongu" + ya.getPlaka());
            if (ya.getPlaka().equals(term)) {
                setArac((Yat) ya);
                System.out.println("-------------->" + ya.toString());
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
        yolcuKapesitesi.setText(String.valueOf(getArac().getYolcuKapesitesi()));
        motorAdeti.setText(String.valueOf(getArac().getMotorAdeti()));
        motorGucu.setText(String.valueOf(getArac().getMotorGucu()));

        //marka.setText(arc.getModel());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public YatFao getYfao() {
        if (yfao == null) {
            yfao = new YatFao();
        }
        return yfao;
    }

    public Yat getArac() {
        if (arac == null) {
            arac = new Yat();
        }
        return arac;
    }

    public void setArac(Yat arac) {
        this.arac = arac;
    }

}
