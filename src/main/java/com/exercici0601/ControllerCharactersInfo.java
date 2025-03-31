package com.exercici0601;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerCharactersInfo {

    @FXML
    private Label nomPersonatge;
    @FXML
    private ImageView imatgePersonatge;

    public void setName(String nomPersonatge) {
        this.nomPersonatge.setText(nomPersonatge);
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
}


