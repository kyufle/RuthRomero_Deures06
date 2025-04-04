package com.exercici0601;

import java.util.Objects;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ControllerFitxa {
    @FXML
    private Label nomPersonatge;
    @FXML
    private Rectangle colorPersonatge;
    @FXML
    private Label jocPersonatge;
    @FXML
    private ImageView imatgePersonatge;
    @FXML
    private Label titolNombrePersonatge;

    public void setTitolNombrePersonatge(String titolNombrePersonatge){
        this.titolNombrePersonatge.setText(titolNombrePersonatge);
    }
    public void setNomPersonatge(String nomPersonatge){
        this.nomPersonatge.setText(nomPersonatge);
    }
    public void setColorPersonatge(String color) {
        colorPersonatge.setStyle("-fx-fill: " + color);
    }
    public void setJocPersonatge(String jocPersonatge){
        this.jocPersonatge.setText(jocPersonatge);
    }
     public void setImatgePersonatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imatgePersonatge.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }
    @FXML
    private void toViewCharacters(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewCharacters");
    }
}

