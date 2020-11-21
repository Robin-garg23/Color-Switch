package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Random;

public class MainPageController {

    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        System.out.println("playing");
        ConCircle a = new ConCircle();
//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
        a.playCon();
        pane=new StackPane();
//        pane=a.concircl;
        balljump b=new balljump();
        b.jump();
        pane.getChildren().addAll(a.concircl,b.root);
        Main.root1.getChildren().setAll(pane);

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
