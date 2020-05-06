/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Taksi;
import entity.Taksi;
import entity.Taksi;
import fao.TaksiFao;
import fao.TaksiFao;
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
public class TaksiController implements Initializable {

    private TaksiFao tfao;
    private Taksi arac;
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
    private TextField tipi;
    @FXML
    private TextField sunroof;
    @FXML
    private TextField hiz;
    @FXML
    private AnchorPane taksiPane;
    @FXML
    private ListView listView;
    @FXML
    private Label uyariLabel;

    private List<String> stringList;
    private ObservableList observableList;

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        taksiPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        taksiPane.getChildren().setAll(pane);
    }

    @FXML
    private void kaydet(ActionEvent event) throws IOException {
        Taksi taksi = new Taksi();
        // marka.getText().equals("")
        if (!sayiMi(kilometre.getText()) || kilometre.getText().equals("")) {
            uyariLabel.setText("Lütfen kilometre için düzgün deger giriniz!");
        } else if (marka.getText().equals("")) {
            uyariLabel.setText("Lütfen marka için düzgün deger giriniz!");
        } else {
            taksi.setFiyat(Integer.valueOf(fiyat.getText()));
            taksi.setHiz(Integer.valueOf(hiz.getText()));
            taksi.setKilometre(Integer.valueOf(kilometre.getText()));
            taksi.setMarka(marka.getText());
            taksi.setModel(model.getText());
            taksi.setPlaka(plaka.getText());
            taksi.setMotor(Double.valueOf(motor.getText()));
            taksi.setSunroof(sunroof.getText());
            taksi.setVites(vites.getText());
            taksi.setTipi(tipi.getText());
            taksi.setYakit(yakit.getText());
            taksi.setYil(Integer.valueOf(yil.getText()));

            getTfao().ekle(taksi);
            listeyiGoster();
        }

    }

    public void listeyiGoster() {
        stringList = getTfao().plakaList();

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
        System.out.println(getArac().toFile() + "---------------------------burasi update");
        getTfao().guncelleme(getArac());
        listeyiGoster();
    }

    @FXML
    private void delete(ActionEvent event) {
        getForm();
        getTfao().silme(getArac());
        listeyiGoster();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public void getForm() {
        getArac().setFiyat(Integer.valueOf(fiyat.getText()));
        getArac().setHiz(Integer.valueOf(hiz.getText()));
        getArac().setKilometre(Integer.valueOf(kilometre.getText()));
        getArac().setMarka(marka.getText());
        getArac().setModel(model.getText());
        getArac().setMotor(Double.valueOf(motor.getText()));
        getArac().setSunroof(sunroof.getText());
        getArac().setVites(vites.getText());
        getArac().setTipi(tipi.getText());
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
        for (Arac tak : getTfao().getAracList()) {
            System.out.println("dongu" + tak.getPlaka());
            if (tak.getPlaka().equals(term)) {
                setArac((Taksi) tak);
                System.out.println("-------------->" + tak.toString());
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
        tipi.setText(getArac().getTipi());
        sunroof.setText(getArac().getSunroof());
        hiz.setText(String.valueOf(getArac().getHiz()));

        //marka.setText(arc.getModel());
    }

    public TaksiFao getTfao() {
        if (tfao == null) {
            tfao = new TaksiFao();
        }
        return tfao;
    }

    public Taksi getArac() {
        if (arac == null) {
            arac = new Taksi();
        }
        return arac;
    }

    public void setArac(Taksi arac) {
        this.arac = arac;
    }

}
