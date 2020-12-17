package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PauseMenuController {
    ArrayList<GameData> sdsd;
    @FXML
    public void resume(MouseEvent event) throws IOException {
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("resuming");
//        mainPage a=new mainPage();
//        a.initiateTransitions();
//        Main.root1.getChildren().setAll(a.root);
        GameSaver dodo=new GameSaver(sdsd);
        dodo.deserializeArrayList();
//        dodo.namesList.get(dodo);
        MainPageController bsdk=new MainPageController();
        bsdk.currentGame=dodo.namesList.get(dodo.namesList.size()-1);
        for(GameData s:dodo.namesList)
        System.out.println(s.ballY);
        bsdk.resumeGame=true;
        bsdk.play(null);




    }

    @FXML
    public void saveGame(MouseEvent event){
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("saving game");


    }

    @FXML
    public void home(MouseEvent event) throws IOException {
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("going to home");
        mainPage a=new mainPage();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }

}
