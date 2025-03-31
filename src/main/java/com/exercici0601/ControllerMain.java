package com.exercici0601;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class ControllerMain {
    @FXML 
    private HBox characterButton;
    @FXML 
    private HBox gameButton;
    @FXML 
    private HBox consolesButton;

    public void initialize() {
        characterButton.setOnMouseClicked(event -> {
            UtilsViews.setViewAnimating("ViewCharacters");
        });
        gameButton.setOnMouseClicked(event -> {
                UtilsViews.setViewAnimating("ViewGames");
        });
        consolesButton.setOnMouseClicked(event -> {
                UtilsViews.setViewAnimating("ViewConsoles");
        });
    characterButton.setStyle("-fx-cursor: hand;");
    gameButton.setStyle("-fx-cursor: hand;");
    consolesButton.setStyle("-fx-cursor: hand;");
}
}
