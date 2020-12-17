package sample;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class gameOverController {


    @FXML
    public void restart(MouseEvent event) throws IOException {
//        System.out.println("Restarting");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MainPageController bsdk=new MainPageController();
        bsdk.resumeGame=false;
        bsdk.play(event);

    }

    @FXML
    public void home( MouseEvent event) throws IOException {
//        System.out.println("going to home");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mainPage a=new mainPage();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }

    @FXML
    public void Continue( MouseEvent event){

//        System.out.println("continuing using stars");
    }


}
