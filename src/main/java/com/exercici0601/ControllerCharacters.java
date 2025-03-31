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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerCharacters implements Initializable {
    @FXML
    private AnchorPane container;
    @FXML
    private VBox lista = new VBox();
    private JSONArray jsonInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("src/main/resources/assets/data/characters.json");
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            jsonInfo = new JSONArray(content);
            // setSeasons(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setCharacters(ActionEvent event) throws Exception {
        URL resource = this.getClass().getResource("/assets/viewPersonatgeFormulari.fxml");
        lista.getChildren().clear();
        for (int i = 0; i < jsonInfo.length(); i++) {
            JSONObject character = jsonInfo.getJSONObject(i);
            String imagen = character.getString("image");
            String name = character.getString("name");

            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerCharacters itemController = loader.getController();
            // itemController.setTitle(name);
            // itemController.setImatge("/assets/images0601/" + imagen.toLowerCase() + ".png");

            lista.getChildren().add(itemTemplate);
        }
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }


}
