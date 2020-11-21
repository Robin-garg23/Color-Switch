package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
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

        StackPane rootr = FXMLLoader.load(getClass().getResource("ball.fxml"));
        TranslateTransition translateTransition = new TranslateTransition();
        List<Node> aa=rootr.getChildren();
        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(400000));

        //Setting the node for the transition
        translateTransition.setNode(rootr);
        translateTransition.setRate(4);

        //Setting the value of the transition along the x axis.
        translateTransition.setFromX(120);
        translateTransition.setFromY(300);
//        translateTransition.setByY(100);
        translateTransition.setToY(10001);
        translateTransition.setInterpolator(Interpolator.LINEAR);

        //Setting the cycle count for the transition
//        translateTransition.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(false);

        //Playing the animation
        translateTransition.play();





        StackPane root = FXMLLoader.load(getClass().getResource("concircle.fxml"));
        List<Node> parentChildren = root.getChildren();
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(4000),parentChildren.get(0));
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        RotateTransition rotateTransition1=new RotateTransition(Duration.millis(4000),parentChildren.get(1));
        rotateTransition1.setFromAngle(360);
        rotateTransition1.setToAngle(0);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.setAxis(Rotate.Z_AXIS);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.play();
        primaryStage.setTitle("Color Switch");
        Group root1 = new Group();
        root1.getChildren().add(root);
        root1.getChildren().add(rootr);
        Scene maina=new Scene(root1, 500, 575,Color.BLACK);

        maina.setOnMousePressed(new EventHandler<>() {
                                    @Override
                                    public void handle(javafx.scene.input.MouseEvent event) {
                                        TranslateTransition translateTransition = new TranslateTransition();

                                        //Setting the duration of the transition
                                        translateTransition.setDuration(Duration.millis(500));

                                        //Setting the node for the transition
                                        translateTransition.setNode(aa.get(0));

                                        //Setting the value of the transition along the x axis.
                                        translateTransition.setByY(-150);

                                        //Setting the cycle count for the transition
                                        translateTransition.setCycleCount(1);

                                        //Setting auto reverse value to false
                                        translateTransition.setAutoReverse(false);

                                        //Playing the animation
                                        translateTransition.play();
                                        System.out.println("mouse click detected! ");
                                    }
        });
                primaryStage.setScene(maina);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
