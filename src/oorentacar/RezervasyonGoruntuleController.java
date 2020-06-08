/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Rezervasyon;
import fao.RezervasyonFao;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *  
 * @author Barsan
 */
public class RezervasyonGoruntuleController implements Initializable {

    private Rezervasyon rezervasyon;
    @FXML
    private Label kullaniciLabel;
    
    @FXML
    private Label alisLabel;
    
    @FXML
    private Label teslimLabel;
    
    @FXML
    private ListView listView;

    private List<String> stringList;
    private ObservableList observableList;
    @FXML
    private AnchorPane rezervasyonPane;
    
    RezervasyonFao fao;
    

    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        rezervasyonPane.getChildren().setAll(pane);
    }

    @FXML
    private void geri(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        rezervasyonPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeyiGoster();
    }

    public void listeyiGoster() {

        stringList = getFao().plakaList();

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
    public void updateForm(String term) {

        for (Rezervasyon rez : getFao().RezervasyonListesi()) {
            System.out.println("dongu" + rez.getArac().getPlaka());
            if (rez.getArac().getPlaka().equals(term)) {
                kullaniciLabel.setText(rez.getMusteri().getAdi()+" "+rez.getMusteri().getSoyadi());
                alisLabel.setText(rez.getAlisTarih());
                teslimLabel.setText(rez.getVerisTarih());
                setRezervasyon(rez);
                break;
            }
        }
    }

  

    public Rezervasyon getRezervasyon() {
        if(rezervasyon == null){
            rezervasyon = new Rezervasyon();
        }
        return rezervasyon;
    }

    public void setRezervasyon(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

  

    public RezervasyonFao getFao() {
        if (fao ==null) {
            fao = new RezervasyonFao();
        }
        return fao;
    }

    
}
