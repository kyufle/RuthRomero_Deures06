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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerConsoles implements Initializable {
    @FXML
    private AnchorPane container;
    @FXML
    private VBox lista;
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
            setConsoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setConsoles() throws Exception {
        URL resource = this.getClass().getResource("/assets/viewConsolesInfo.fxml");
        lista.getChildren().clear();
        for (int i = 0; i < jsonInfo.length(); i++) {
            JSONObject console = jsonInfo.getJSONObject(i);
            String imagen = console.getString("image");
            String name = console.getString("name");

            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerConsolesInfo itemController = loader.getController();
            itemController.setName(name);
            itemController.setImatge("/assets/images0601/" + imagen.toLowerCase());
            itemController.setId(i);
            lista.getChildren().add(itemTemplate);
        }
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }
}
