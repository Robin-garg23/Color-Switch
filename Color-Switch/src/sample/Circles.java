package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.SQLOutput;
import java.util.List;


public class Circles extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


        AnchorPane root = FXMLLoader.load(getClass().getResource("Circle.fxml"));




        RotateTransition rotateTransition=new RotateTransition(Duration.millis(4000),root);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();


        primaryStage.setTitle("Color Switch");
        Group root1 = new Group();
        root1.getChildren().add(root);
        primaryStage.setScene(new Scene(root1, 500, 500,Color.BLACK));
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
//    @FXML
//    public void rotata(MouseEvent mouseEvent) {
//        circlepane.setMaxHeight(250);
//        circlepane.setMaxWidth(250);
//        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(1),circlepane);
//        rotateTransition.setFromAngle(0);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(400);
//        rotateTransition.play();
//
//    }
}
