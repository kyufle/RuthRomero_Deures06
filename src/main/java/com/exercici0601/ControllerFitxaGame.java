package com.exercici0601;

import java.util.Objects;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ControllerFitxaGame {
    @FXML
    private Label nomGame;
    @FXML
    private Rectangle colorGame;
    @FXML
    private Label plotGame;
    @FXML
    private ImageView imatgeGame;
    @FXML
    private Label titolNombreGames;
    @FXML
    private Label typeGame;
    @FXML
    private Label yearGame;

    public void setTitolNombreGame(String titolNombreGames){
        this.titolNombreGames.setText(titolNombreGames);
    }
    public void setNomGame(String nomGame){
        this.nomGame.setText(nomGame);
    }
    public void setColorGame(String color) {
        colorGame.setStyle("-fx-fill: " + color);
    }
    public void setTypeGame(String typeGame){
        this.typeGame.setText(typeGame);
    }
    public void setPlotGame(String plotGame){
        this.plotGame.setText(plotGame);
    }
    public void setYearGame(Integer yearGame){
        this.yearGame.setText(String.valueOf(yearGame));
    }
     public void setImatgeGame(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imatgeGame.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }
    @FXML
    private void toViewGames(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewGames");
    }
}

