/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
import entity.Bisiklet;
import entity.Taksi;
import entity.Tir;
import fao.BisikletFao;
import fao.Fao;
import fao.KamyonFao;
import fao.LimuzinFao;
import fao.MotorFao;
import fao.MusteriManager;
import fao.PikapFao;
import fao.SuvFao;
import fao.TaksiFao;
import fao.TirFao;
import fao.TraktorFao;
import fao.YatFao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Barsan
 */
public class KullaniciKiralamaController implements Initializable {

    private List<String> stringList;
    private ObservableList observableList;
    private List<Arac> aracList = null;
    @FXML
    private Button taksiButton;
    @FXML
    private Button suvButton;
    @FXML
    private Button limuzinButton;
    @FXML
    private Button kamyonButton;
    @FXML
    private Button bisikletButton;
    @FXML
    private Button tirButton;
    @FXML
    private Button yatButton;
    @FXML
    private Button motorButton;
    @FXML
    private Button traktorButton;
    @FXML
    private Button pikapButton;
    @FXML
    private AnchorPane kiralamaPane;
    @FXML
    private ListView listView;
    @FXML
    private Label plakaLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label markaLabel;
    @FXML
    private Label rezLabel;
    @FXML
    private Label yakitLabel;
    @FXML
    private Label vitesLabel;

    Fao fao;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void aracListesi(ActionEvent event) {
        String tip = event.getSource().toString().substring(event.getSource().toString().indexOf('[') + 1, event.getSource().toString().indexOf(','));
        System.out.println(tip);

        if (tip.equals("id=taksiButton")) {
            fao = new TaksiFao();
            aracList = fao.getAracList();
            listeyiGoster();
        } else if (tip.equals("id=suvButton")) {
            fao = new SuvFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=limuzinButton")) {
            fao = new LimuzinFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=kamyonButton")) {
            fao = new KamyonFao();
            aracList = fao.getAracList();
            listeyiGoster();
        } else if (tip.equals("id=bisikletButton")) {
            fao = new BisikletFao();
            aracList = fao.getAracList();
            listeyiGoster();
        } else if (tip.equals("id=tirButton")) {
            fao = new TirFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=yatButton")) {
            fao = new YatFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=motorButton")) {
            fao = new MotorFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=traktorButton")) {
            fao = new TraktorFao();
            aracList = fao.getAracList();
        } else if (tip.equals("id=pikapButton")) {
            fao = new PikapFao();
            aracList = fao.getAracList();
        }

    }

    public void updateForm(String term) {

        for (Arac bis : fao.getAracList()) {
            System.out.println("dongu" + bis.getPlaka());
            if (bis.getPlaka().equals(term)) {
                markaLabel.setText(bis.getMarka());
                modelLabel.setText(bis.getModel());
                plakaLabel.setText(bis.getPlaka());
                yakitLabel.setText(bis.getYakit());
                vitesLabel.setText(bis.getVites());
                System.out.println("-------------->" + bis.toString());
                break;
            }
        }

        //marka.setText(arc.getModel());
    }

    // FXML elementi element.setVisibility(true);
    // element.setText("");
    @FXML
    public void rezervasyonYap(ActionEvent event) {
        rezLabel.setText("Rezervasyon başarıyla yapıldı!");
        System.out.println("Rezervasyon başarıyla yapıldı!");
    }

    public void listeyiGoster() {

        stringList = fao.plakaList();

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
    private void cikis(ActionEvent event) throws IOException {
        MusteriManager.setGecerliMusteri(null);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        kiralamaPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
