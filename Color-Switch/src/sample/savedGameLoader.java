package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class savedGameLoader {

    public void home(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        System.out.println("going to home");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mainPage a=new mainPage();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }


}
