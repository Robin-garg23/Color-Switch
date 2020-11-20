package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.SQLOutput;


public class Circles extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("Circle.fxml"));
        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(2),root);

        rotateTransition.setByAngle(360);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(400);
        rotateTransition.play();
        primaryStage.setTitle("Color Switch");
        Group root1 = new Group();
        root1.getChildren().add(root);
        primaryStage.setScene(new Scene(root1, 300, 275,Color.BLACK));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
