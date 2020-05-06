/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Musteri;
import fao.MusteriFao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Barsan
 */
public class KullaniciKaydolController implements Initializable {

    @FXML
    private TextField isimField;
    @FXML
    private TextField soyisimField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField kullaniciadiField;
    @FXML
    private TextField parolaField;
    @FXML
    private TextField parolatekrarField;
    @FXML
    private Label uyari;
    @FXML
    private AnchorPane kayitPane;

    @FXML
    private void kayitOl(ActionEvent event) {
        if (parolaKontrol()) {
            
        
        Musteri musteri = new Musteri();
        musteri.setAdi(isimField.getText());
        musteri.setSoyadi(soyisimField.getText());
        musteri.setEmail(emailField.getText());
        musteri.setKullaniciAdi(kullaniciadiField.getText());
        musteri.setParola(parolaField.getText());

        MusteriFao mfao = new MusteriFao();
        mfao.Ekle(musteri);
        }else{
            uyari.setVisible(true);
        }

    }
    @FXML
    private void cikis(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        kayitPane.getChildren().setAll(pane);
    }
    
    boolean parolaKontrol(){
        return parolaField.getText().equals(parolatekrarField.getText());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uyari.setVisible(false);
    }

}
