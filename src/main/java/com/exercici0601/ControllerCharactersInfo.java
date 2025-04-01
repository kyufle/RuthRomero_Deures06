package com.exercici0601;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ControllerCharactersInfo {

    @FXML
    private Label nomPersonatge;
    @FXML
    private ImageView imatgePersonatge;
    @FXML
    private HBox llistarPersonatge;
    private int idPersonatge;
    public void setName(String nomPersonatge) {
        this.nomPersonatge.setText(nomPersonatge);
    }
    public int getId(){
        return idPersonatge;
    }
    public void setId(int idPersonatge){
        this.idPersonatge = idPersonatge;
    }
    public HBox getHBox(){
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


    @FXML
    private void clicarHbox(MouseEvent event) {
        System.out.println(getId());
    }
}


