package com.exercici0601;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerFitxa {
    @FXML
    private Label nomPersonatge;
    
    public void setNomPersonatge(String nomPersonatge){
        this.nomPersonatge.setText(nomPersonatge);
    }
    @FXML
    private void toViewCharacters(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewCharacters");
    }
}

