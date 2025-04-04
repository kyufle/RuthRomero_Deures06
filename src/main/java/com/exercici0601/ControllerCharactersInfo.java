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

public class ControllerCharactersInfo implements Initializable{

    @FXML
    private Label nomPersonatge;
    @FXML
    private ImageView imatgePersonatge;
    @FXML
    private HBox llistarPersonatge;
    private int idPersonatge;
    private JSONArray jsonInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/data/characters.json");
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

    public void setName(String nomPersonatge) {
        this.nomPersonatge.setText(nomPersonatge);
    }

    public int getId() {
        return idPersonatge;
    }

    public void setId(int idPersonatge) {
        this.idPersonatge = idPersonatge;
    }

    public HBox getHBox() {
        return llistarPersonatge;
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            this.imatgePersonatge.setImage(image);

        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void clicarHbox(MouseEvent event) {
        for (int i = 0; i < jsonInfo.length(); i++) {
            if (i==getId()) {
                JSONObject character = jsonInfo.getJSONObject(i);
                ControllerFitxa crtl = (ControllerFitxa) UtilsViews.getController("ViewFitxa");
                crtl.setTitolNombrePersonatge(character.getString("name"));
                crtl.setImatgePersonatge("/assets/images0601/"+character.getString("image"));
                crtl.setNomPersonatge(character.getString("name"));
                crtl.setColorPersonatge(character.getString("color"));
                crtl.setJocPersonatge(character.getString("game"));
                UtilsViews.setViewAnimating("ViewFitxa");
            }
            
            

            
        }


    }
}
