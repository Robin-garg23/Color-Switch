package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MainPageController {

    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        System.out.println("playing");
        ConCircle a = new ConCircle();
        pauseSymbol c=new pauseSymbol();
//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
        a.playCon();
        pane=new StackPane();
        balljump b=new balljump();
        c.root.setTranslateX(400);
        c.root.setTranslateY(25);
        b.root.setTranslateX(50);
        b.root.setTranslateY(400);
        pane.getChildren().addAll(a.concircl,b.root,c.root);
        pane.setOnMouseClicked(event2 -> {
            collision(b);
                });

        b.jump(pane);
        Main.root1.getChildren().setAll(pane);

    }

    public void collision(balljump b)
    {
        List<Node> aa=b.root.getChildren();
        System.out.println(aa.get(0).getTranslateY());
    }
    @FXML
    public void savedGames(MouseEvent event){
        System.out.println("saved games");
    }

    @FXML
    public void exit(MouseEvent event){
        System.out.println("exiting");
        System.exit(0);
    }
    @FXML
    public void help(MouseEvent event){
        System.out.println("Made by Utkarsh");

    }

}
