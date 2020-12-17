package sample;

import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gameOverController {
    @FXML
    Text more;


    @FXML
    public void restart(MouseEvent event) throws IOException {
//        System.out.println("Restarting");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MainPageController newController=new MainPageController();
//        GameSaver Main.database = new GameSaver(sdsd);
        Main.database.deserializeArrayList();
        Main.database.namesList.remove(Main.database.namesList.size() - 1);
        Main.database.serializeArrayList();
        newController.resumeGame=false;
        newController.play(event);

    }

    @FXML
    public void home( MouseEvent event) throws IOException {
//        System.out.println("going to home");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mainPage a=new mainPage();
        Main.database.deserializeArrayList();
        Main.database.namesList.remove(Main.database.namesList.size() - 1);
        Main.database.serializeArrayList();
        a.initiateTransitions();
        Main.root1.getChildren().setAll(a.root);
    }

    @FXML
    public void Continue( MouseEvent event) throws IOException, InterruptedException {
        HighStarSaver ff=new HighStarSaver(0,0);
        ff.deserializeArrayList();
        Main.database.deserializeArrayList();
        if(ff.highStar.get(1)>10) {
//            System.out.println("continuing using stars");
            ff.highStar.set(1,ff.highStar.get(1)-10);
            MainPageController newController = new MainPageController();
            Main.database.namesList.get(Main.database.namesList.size() - 1).ballY += 50;
            newController.currentGame = Main.database.namesList.get(Main.database.namesList.size() - 1);
            for (GameData s : Main.database.namesList)
//                System.out.println(s.ballY);
            newController.resumeGame = true;
            newController.play(null);

        }
        else
        {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Insufficient Stars");
            errorAlert.setContentText("You need more than 10 Stars to resume!");

// <<<<<<< HEAD
// //        System.out.println("continuing using stars");
// =======
//            errorAlert.showAndWait(5000);
            errorAlert.showAndWait();
//            errorAlert.wait(5000);
        }
        Main.database.namesList.remove(Main.database.namesList.size() - 1);
        Main.database.serializeArrayList();
        ff.serializeArrayList();

    }

    @FXML
    public void moreStars(MouseEvent mouseEvent) {
        Random rand=new Random();
        HighStarSaver jojo=new HighStarSaver(0,0);
        jojo.deserializeArrayList();
        jojo.highStar.set(1,jojo.highStar.get(1)+5);
        jojo.serializeArrayList();
        more.setText(""+jojo.highStar.get(1));
        int web=rand.nextInt(4);
        switch (web)
        {
            case 0:
                try {
                    Desktop.getDesktop().browse(new URL("https://utkarshdubey.me/MajorProject/").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            case 1:
                try {
                    Desktop.getDesktop().browse(new URL("https://github.com/Robin-garg23").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            case 2:
                try {
                    Desktop.getDesktop().browse(new URL("https://github.com/utkarsh-dubey").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            case 3:
                try {
                    Desktop.getDesktop().browse(new URL("https://utkarshdubey.me/").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
        }

    }
}
