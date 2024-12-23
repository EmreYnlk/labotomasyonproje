package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class anaekranKontrol {

    @FXML
    private Label hosgeldinMesaji;
    @FXML
    private ImageView profilResmi;
    @FXML
    private ImageView anaekran_gorselpencere;
    @FXML
    private Button yonetimButonu;

    @FXML
    private void anaEkranCik(MouseEvent event) {
        ButtonType evetButonu = new ButtonType("Evet.Çıkalım", ButtonBar.ButtonData.OK_DONE);
        ButtonType hayirButonu = new ButtonType("Hayır.Çıkmayalım", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Çıkış Onayı");
        alert.setHeaderText("Uygulamadan çıkmak istiyor musunuz?");
        alert.getButtonTypes().setAll(evetButonu, hayirButonu);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == evetButonu) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("giris-ekrani.fxml"));
                Parent root = fxmlLoader.load();

                Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
                if (window instanceof Stage) {
                    ((Stage) window).close();
                }

                Stage stage = new Stage();
                stage.setTitle("Giriş Ekranı");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setKullaniciBilgisi(String cinsiyet, String isimSoyisim,boolean yetkilimi) {
        hosgeldinMesaji.setText("Hoşgeldin, " + isimSoyisim);
        yonetimButonu.setVisible(yetkilimi);

        String resimYolu;
        String resimYoluCinsiyet;
        if ("Erkek".equalsIgnoreCase(cinsiyet)) {
            resimYolu = "/resimler/anaekran-erkeksilüet.png";
            resimYoluCinsiyet = "/resimler/anaekran-Egörsel.png";
        } else {
            resimYolu = "/resimler/anaekran-kadınsilüet.png";
            resimYoluCinsiyet = "/resimler/anaekran-Kgörsel.png";
        }
        Image profilResim = new Image(getClass().getResourceAsStream(resimYolu));
        profilResmi.setImage(profilResim);
        Image anaekran_gorselpenceresi = new Image(getClass().getResourceAsStream(resimYoluCinsiyet));
        anaekran_gorselpencere.setImage(anaekran_gorselpenceresi);
    }

    private void malzemeListele(){

    }
    private void EkipmanListele(){

    }
    private void DeneyYap(){

    }



}