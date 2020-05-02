/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oorentacar;

import entity.Arac;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Barsan
 */
public class KullaniciKiralamaController implements Initializable {

    private List<Arac> aracList=null;
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
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private void aracListesi(ActionEvent event){
        String tip = event.getSource().toString().substring(event.getSource().toString().indexOf('[')+1, event.getSource().toString().indexOf(','));
        System.out.println(tip);
        Fao fao ;
        if (tip.equals("id=taksiButton")) {
            fao = new TaksiFao();
            aracList = fao.getAracList();
        }else if (tip.equals("id=suvButton")) {
            fao = new SuvFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=limuzinButton")) {
            fao = new LimuzinFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=kamyonButton")) {
            fao = new KamyonFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=bisikletButton")) {
            fao = new BisikletFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=tirButton")) {
            fao = new TirFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=yatButton")) {
            fao = new YatFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=motorButton")) {
            fao = new MotorFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=traktorButton")) {
            fao = new TraktorFao();
            aracList = fao.getAracList();            
        }else if (tip.equals("id=pikapButton")) {
            fao = new PikapFao();
            aracList = fao.getAracList();            
        }
        
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
