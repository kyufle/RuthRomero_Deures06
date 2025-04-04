package com.exercici0601;

import java.util.Objects;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ControllerFitxaConsola {
    @FXML
    private Label nomConsola;
    @FXML
    private Rectangle colorConsola;
    @FXML
    private Label dataConsola;
    @FXML
    private ImageView imatgeConsola;
    @FXML
    private Label titolNombreConsola;
    @FXML
    private Label procesadorConsola;
    @FXML
    private Label unitatVenudesConsola;

    public void setTitolNombreConsola(String titolNombreConsola){
        this.titolNombreConsola.setText(titolNombreConsola);
    }
    public void setNomConsola(String nomConsola){
        this.nomConsola.setText(nomConsola);
    }
    public void setColorConsola(String color) {
        colorConsola.setStyle("-fx-fill: " + color);
    }
    public void setDataConsola(String dataConsola){
        this.dataConsola.setText(dataConsola);
    }
    public void setProcesadorConsola(String procesadorConsola){
        this.procesadorConsola.setText(procesadorConsola);
    }
    public void setUnitatVenudes(Integer unitatVenudesConsola){
        this.unitatVenudesConsola.setText(String.valueOf(unitatVenudesConsola));
    }
     public void setImatgeConsola(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imatgeConsola.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }
    @FXML
    private void toViewConsoles(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewConsoles");
    }
}

