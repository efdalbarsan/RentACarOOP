/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Barsan
 */
public class AdminController implements Initializable {

    @FXML
    private AnchorPane adminPane;

    @FXML
    private void taksiIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Taksi.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void kamyonIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Kamyon.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void motorIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Motor.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void suvIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("SUV.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void traktorIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Traktor.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void rezervasyonIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("RezervasyonGoruntule.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void limuzinIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Limuzin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void tirIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Tir.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void yatIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Yat.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void hasarKaydiIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HasarKaydi.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void bisikletIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Bisiklet.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @FXML
    private void pikapIslem(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Pikap.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
