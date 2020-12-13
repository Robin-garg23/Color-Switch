package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class balljump {

    StackPane root;
    double ballPos=500;
    double gg=0;

    public balljump() throws IOException {
        root = FXMLLoader.load(getClass().getResource("ball.fxml"));


    }

    public void jump(StackPane pane) throws IOException {

            gameOver bye=new gameOver();
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setDuration(Duration.millis(400000));
            translateTransition.setNode(root);
            translateTransition.setRate(6);

            translateTransition.setFromX(50);
            translateTransition.setFromY(400);
            translateTransition.setToY(10001);
            translateTransition.setInterpolator(Interpolator.LINEAR);
            translateTransition.setAutoReverse(false);
            List<Node> aa=root.getChildren();
        pane.setOnMouseClicked(event -> {
            translateTransition.play();
            TranslateTransition translateTransition1 = new TranslateTransition();
                translateTransition1.setDuration(Duration.millis(300));
                translateTransition1.setNode(aa.get(0));
//                translateTransition.setRate(translateTransition.getRate()+0.5);
            ballPos=root.getTranslateY()+aa.get(0).getTranslateY();
            System.out.println(root.getTranslateY()+aa.get(0).getTranslateY());
            gg=root.getTranslateY()+aa.get(0).getTranslateY();
            if(gg>600)
            {
                StackPane pane1=new StackPane();

                pane1.getChildren().add(bye.root);
                Main.root1.getChildren().setAll(pane1);
            }
            System.out.println();

                translateTransition1.setByY(-150);
                translateTransition1.setCycleCount(1);
                translateTransition1.setAutoReverse(false);
                translateTransition1.play();
                System.out.println("mouse click detected! " );
        });



    }
    double getBallPos()
    {
        return ballPos;
    }

}


