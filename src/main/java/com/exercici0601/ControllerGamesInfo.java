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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ControllerGamesInfo implements Initializable{
    @FXML
    private Label nomGame;
    @FXML
    private ImageView imatgeGame;
    @FXML
    private HBox llistarGames;
    private int idGame;
    private JSONArray jsonInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/data/games.json");
            if (jsonFileURL == null) {
                System.out.println("Error: El archivo JSON no se encuentra en la ruta especificada.");
                return;
            }
    
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            System.out.println("Contenido del archivo JSON: " + content);
            jsonInfo = new JSONArray(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setName(String nomGame) {
        this.nomGame.setText(nomGame);
    }

    public int getId() {
        return idGame;
    }

    public void setId(int idGame) {
        this.idGame = idGame;
    }

    public HBox getHBox() {
        return llistarGames;
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            this.imatgeGame.setImage(image);

        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void clicarHbox(MouseEvent event) {
        for (int i = 0; i < jsonInfo.length(); i++) {
            System.out.println("1");
            if (i==getId()) {
                System.out.println("2");
                JSONObject games = jsonInfo.getJSONObject(i);
                ControllerFitxaGame crtl = (ControllerFitxaGame) UtilsViews.getController("ViewGamesFitxa");
                crtl.setTitolNombreGame(games.getString("name"));
                crtl.setNomGame(games.getString("name"));
                crtl.setTypeGame(games.getString("type"));
                crtl.setPlotGame(games.getString("plot"));
                crtl.setYearGame(games.getInt("year"));
                crtl.setImatgeGame("/assets/images0601/"+games.getString("image"));
                UtilsViews.setViewAnimating("ViewGamesFitxa");
            }   
        }
        System.out.println("3");
    }
}
