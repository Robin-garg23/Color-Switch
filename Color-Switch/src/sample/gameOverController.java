package sample;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class gameOverController {

    @FXML
    public void restart(MouseEvent event){
        System.out.println("Restarting");

    }

    @FXML
    public void home( MouseEvent event){
        System.out.println("going to home");
    }

    @FXML
    public void Continue( MouseEvent event){
        System.out.println("continuing using stars");
    }


}
