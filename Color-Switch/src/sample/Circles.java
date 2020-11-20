package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    @FXML
    Pane circlepane;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("Circle.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
//    @FXML
//    public void rotata(MouseEvent event)
//    {
//
//    }
    public static void main(String[] args) {
        System.out.println("jig");

        System.out.println("checkcheck");
        launch(args);
    }
    @FXML
    public void rotata(MouseEvent mouseEvent) {
        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(5),circlepane);
        rotateTransition.setFromAngle(0);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(400);
        rotateTransition.play();

    }
}
