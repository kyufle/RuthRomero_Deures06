package com.exercici0601;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ControllerConsolesInfo implements Initializable{
    @FXML
    private Label nomConsola;
    @FXML
    private ImageView imatgeConsola;
    @FXML
    private HBox llistarConsoles;
    private int idConsola;
    private JSONArray jsonInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/data/consoles.json");
            if (jsonFileURL == null) {
                System.out.println("Error: El archivo JSON no se encuentra en la ruta especificada.");
                return;
            }
    
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            System.out.println("Contenido del archivo JSON: " + content);
            jsonInfo = new JSONArray(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setName(String nomConsola) {
        this.nomConsola.setText(nomConsola);
    }

    public int getId() {
        return idConsola;
    }

    public void setId(int idConsola) {
        this.idConsola = idConsola;
    }

    public HBox getHBox() {
        return llistarConsoles;
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            this.imatgeConsola.setImage(image);

        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void clicarHbox(MouseEvent event) {
        for (int i = 0; i < jsonInfo.length(); i++) {
            if (i==getId()) {
                JSONObject consoles = jsonInfo.getJSONObject(i);
                ControllerFitxaConsola crtl = (ControllerFitxaConsola) UtilsViews.getController("ViewConsolesFitxa");
                crtl.setTitolNombreConsola(consoles.getString("name"));
                crtl.setImatgeConsola("/assets/images0601/"+consoles.getString("image"));
                crtl.setNomConsola(consoles.getString("name"));
                crtl.setDataConsola(consoles.getString("date"));
                crtl.setProcesadorConsola(consoles.getString("procesador"));
                crtl.setUnitatVenudes(consoles.getInt("units_sold"));
                crtl.setColorConsola(consoles.getString("color"));
                UtilsViews.setViewAnimating("ViewConsolesFitxa");
            }   
        }
    }
}
