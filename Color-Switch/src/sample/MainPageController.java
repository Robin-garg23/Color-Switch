package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class MainPageController {

    @FXML
    public void play(MouseEvent event){
        System.out.println("playing");
    }

    @FXML
    public void savedGames(MouseEvent event){
        System.out.println("saved games");
    }

    @FXML
    public void exit(MouseEvent event){
        System.out.println("exiting");
    }

}
