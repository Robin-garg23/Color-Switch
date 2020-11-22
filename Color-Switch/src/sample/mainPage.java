package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class mainPage {

    public AnchorPane root;

    mainPage() throws IOException {
        root = FXMLLoader.load(getClass().getResource("NewMainPage.fxml"));
        root.setTranslateX(-50);
    }

    public void initiateTransitions(){

        List<Node> parentChildren = root.getChildren();


        StackPane first=(StackPane)parentChildren.get(2);
        StackPane second=(StackPane)parentChildren.get(3);
        List<Node> firstone=first.getChildren();
        List<Node> secondone=second.getChildren();
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(4000),firstone.get(2));
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        RotateTransition rotateTransition1=new RotateTransition(Duration.millis(4000),firstone.get(3));
        rotateTransition1.setFromAngle(360);
        rotateTransition1.setToAngle(0);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.setAxis(Rotate.Z_AXIS);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.play();
        RotateTransition rotateTransition2=new RotateTransition(Duration.millis(4000),secondone.get(1));
        rotateTransition2.setFromAngle(0);
        rotateTransition2.setToAngle(360);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.setAxis(Rotate.Z_AXIS);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();
        RotateTransition rotateTransition3=new RotateTransition(Duration.millis(4000),secondone.get(2));
        rotateTransition3.setFromAngle(360);
        rotateTransition3.setToAngle(0);
        rotateTransition3.setInterpolator(Interpolator.LINEAR);
        rotateTransition3.setAxis(Rotate.Z_AXIS);
        rotateTransition3.setCycleCount(Timeline.INDEFINITE);
        rotateTransition3.setAutoReverse(false);
        rotateTransition3.play();
        RotateTransition rotateTransition4=new RotateTransition(Duration.millis(4000),parentChildren.get(4));
        rotateTransition4.setFromAngle(0);
        rotateTransition4.setToAngle(360);
        rotateTransition4.setInterpolator(Interpolator.LINEAR);
        rotateTransition4.setAxis(Rotate.Z_AXIS);
        rotateTransition4.setCycleCount(Timeline.INDEFINITE);
        rotateTransition4.setAutoReverse(false);
        rotateTransition4.play();
        RotateTransition rotateTransition5=new RotateTransition(Duration.millis(4000),parentChildren.get(5));
        rotateTransition5.setFromAngle(0);
        rotateTransition5.setToAngle(360);
        rotateTransition5.setInterpolator(Interpolator.LINEAR);
        rotateTransition5.setAxis(Rotate.Z_AXIS);
        rotateTransition5.setCycleCount(Timeline.INDEFINITE);
        rotateTransition5.setAutoReverse(false);
        rotateTransition5.play();
        RotateTransition rotateTransition6=new RotateTransition(Duration.millis(4000),parentChildren.get(13));
        rotateTransition6.setFromAngle(360);
        rotateTransition6.setToAngle(0);
        rotateTransition6.setInterpolator(Interpolator.LINEAR);
        rotateTransition6.setAxis(Rotate.Z_AXIS);
        rotateTransition6.setCycleCount(Timeline.INDEFINITE);
        rotateTransition6.setAutoReverse(false);
        rotateTransition6.play();

    }



}
