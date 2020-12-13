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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
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
            List<Node> bb=pane.getChildren();
        pane.setOnMouseClicked(event -> {
//            things((AnchorPane)bb.get(0));
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

                translateTransition1.setByY(-100);
                translateTransition1.setCycleCount(1);
                translateTransition1.setAutoReverse(false);
                translateTransition1.play();
            System.out.println(root.getTranslateY()+aa.get(0).getTranslateY());
                System.out.println("mouse click detected! " );
        });



    }

    public void things(AnchorPane root) {
        double x1, x2, x3, x4, y1, y2, y3, y4;
        Paint color1, color2, color3, color4;
        List<Node> children = root.getChildren();
        Group inbetween = (Group) children.get(0);
        List<Node> allacrs = inbetween.getChildren();
        Arc arc1 = (Arc) allacrs.get(0);
        Arc arc2 = (Arc) allacrs.get(1);
        Arc arc3 = (Arc) allacrs.get(2);
        Arc arc4 = (Arc) allacrs.get(3);
        x1 = root.getTranslateX() + arc1.getTranslateX();
        x2 = root.getTranslateX() + arc2.getTranslateX();
        x3 = root.getTranslateX() + arc3.getTranslateX();
        x4 = root.getTranslateX() + arc4.getTranslateX();
        y1 = root.getTranslateY() + arc1.getTranslateY();
        y2 = root.getTranslateY() + arc2.getTranslateY();
        y3 = root.getTranslateY() + arc3.getTranslateY();
        y4 = root.getTranslateY() + arc4.getTranslateY();
        color1 = arc1.getStroke();
        color2 = arc2.getStroke();
        color3 = arc3.getStroke();
        color4 = arc4.getStroke();
        List<Node> ballchild = this.root.getChildren();
        Circle ball = (Circle) ballchild.get(0);
        Paint ballColor = ball.getFill();
        System.out.println(ballColor.toString());

        double angle = root.getRotate();
        if (0 <= angle && angle < 90) {
            System.out.println("Purple");
            if (ballColor.toString().equals("0x900dffff") && this.root.getTranslateY() + ballchild.get(0).getTranslateY() >= 95 && this.root.getTranslateY() + ballchild.get(0).getTranslateY() <= 105) {
                System.out.println("Nice pass");
            }


        } else if (90 <= angle && angle < 180) {
            System.out.println("pink");
        } else if (180 <= angle && angle < 270) {
            System.out.println("yellow");
        } else {
            System.out.println("light blue");
        }
        System.out.println(root.getTranslateY());
        System.out.println(root.getRotate());
        System.out.println(x1 + " " + x2 + " " + x3 + " " + x4 + " " + y1 + " " + y2 + " " + y3 + " " + y4);

    }
    double getBallPos()
    {
        return ballPos;

    }

}


