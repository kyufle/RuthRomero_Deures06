package com.exercici0601;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ControllerConsoles {

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }

    
}
