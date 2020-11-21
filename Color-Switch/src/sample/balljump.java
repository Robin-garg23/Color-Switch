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
import java.util.List;

public class balljump extends Application {
    @FXML
    Circle ball;
    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane root = FXMLLoader.load(getClass().getResource("ball.fxml"));
        TranslateTransition translateTransition = new TranslateTransition();
        List<Node> aa=root.getChildren();
        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(400000));

        //Setting the node for the transition
        translateTransition.setNode(root);
        translateTransition.setRate(4);

        //Setting the value of the transition along the x axis.
        translateTransition.setFromX(50);
        translateTransition.setFromY(100);
//        translateTransition.setByY(100);
        translateTransition.setToY(10001);
        translateTransition.setInterpolator(Interpolator.LINEAR);

        //Setting the cycle count for the transition
//        translateTransition.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(false);

        //Playing the animation
        translateTransition.play();

        primaryStage.setTitle("Color Switch");
        Group root1 = new Group();
        root1.getChildren().add(root);
        Scene maina=new Scene(root1, 470, 452, Color.BLACK);
        maina.setOnMousePressed(new EventHandler<>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                TranslateTransition translateTransition = new TranslateTransition();

                //Setting the duration of the transition
                translateTransition.setDuration(Duration.millis(500));

                //Setting the node for the transition
                translateTransition.setNode(aa.get(0));

                //Setting the value of the transition along the x axis.
                translateTransition.setByY(-100);

                //Setting the cycle count for the transition
                translateTransition.setCycleCount(1);

                //Setting auto reverse value to false
                translateTransition.setAutoReverse(false);

                //Playing the animation
                translateTransition.play();
                System.out.println("mouse click detected! " );
            }
        });
        primaryStage.setScene(maina);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void jump(javafx.scene.input.MouseEvent mouseEvent) {

    }
}


