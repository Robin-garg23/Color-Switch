package sample;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class gameOverController {

    @FXML
    public void restart(MouseEvent event) throws IOException {
        System.out.println("Restarting");

        MainPageController bsdk=new MainPageController();
        bsdk.resumeGame=false;
        bsdk.play(event);

    }

    @FXML
    public void home( MouseEvent event) throws IOException {
        System.out.println("going to home");
        mainPage a=new mainPage();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }

    @FXML
    public void Continue( MouseEvent event){
        System.out.println("continuing using stars");
    }


}
