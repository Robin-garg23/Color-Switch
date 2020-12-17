package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PauseMenuController {
    boolean gameSaved=false;
    @FXML
    public void resume(MouseEvent event) throws IOException {
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("resuming");
//        mainPage a=new mainPage();
//        a.initiateTransitions();
//        Main.root1.getChildren().setAll(a.root);
//        GameSaver Main.database=new GameSaver(sdsd);
        Main.database.deserializeArrayList();
//        Main.database.namesList.get(Main.database);
        MainPageController newController=new MainPageController();
        newController.currentGame=Main.database.namesList.get(Main.database.namesList.size()-1);
        for(GameData s:Main.database.namesList)
        System.out.println(s.ballY);
        newController.resumeGame=true;
        newController.play(null);
        if(!gameSaved) {
            Main.database.namesList.remove(Main.database.namesList.size() - 1);
            Main.database.serializeArrayList();
        }
        gameSaved=false;
    }

    @FXML
    public void saveGame(MouseEvent event){
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("saving game");
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Game Saved!!");

//            errorAlert.showAndWait(5000);
        errorAlert.showAndWait();
        gameSaved=true;


    }

    @FXML
    public void home(MouseEvent event) throws IOException {
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.out.println("going to home");
        if(!gameSaved) {
            Main.database.deserializeArrayList();
            Main.database.namesList.remove(Main.database.namesList.size() - 1);
            Main.database.serializeArrayList();

        }
        gameSaved=false;
        mainPage a=new mainPage();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }

}
