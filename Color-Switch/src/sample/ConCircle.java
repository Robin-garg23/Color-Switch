package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ConCircle extends Obstacles implements Serializable {

    public StackPane concircl;

//    StackPane root;
    ConCircle() throws IOException {
        concircl = FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
        concircl.setTranslateX(50);
        concircl.setId("0");
    }

     protected void playCon() {

        List<Node> parentChildren = concircl.getChildren();
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(8000),parentChildren.get(0));
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        RotateTransition rotateTransition1=new RotateTransition(Duration.millis(8000),parentChildren.get(1));
        rotateTransition1.setFromAngle(0);
        rotateTransition1.setToAngle(360);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.setAxis(Rotate.Z_AXIS);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.play();
    }
    @Override
    Pane returnPane()
    {
        return concircl;
    }
}
