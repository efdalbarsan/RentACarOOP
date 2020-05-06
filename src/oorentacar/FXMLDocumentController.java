/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Musteri;
import fao.MusteriFao;
import fao.MusteriManager;
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
 *
 * @author Barsan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField emailField;
    @FXML
    private TextField parolaField;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void kayitOl(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("KullaniciKaydol.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void girisYap(ActionEvent event) throws IOException {
        MusteriFao mfao = new MusteriFao();
        Musteri musteri = null;
        if (sayiMi(emailField.getText())) {
            musteri = mfao.giris(Integer.valueOf(emailField.getText()), parolaField.getText());
        } else {
            musteri = mfao.giris(emailField.getText(), parolaField.getText());
        }

        if (musteri != null) {
            MusteriManager.setGecerliMusteri(musteri);
            System.out.println("Başarılı giriş!");
            if (musteri.getAdmin() == 0) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("KullaniciKiralama.fxml"));
                rootPane.getChildren().setAll(pane);
            } else if (musteri.getAdmin() == 1) {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                rootPane.getChildren().setAll(pane);
            }

        } else {
            System.out.println("Hatalı giriş!!!!");
        }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
