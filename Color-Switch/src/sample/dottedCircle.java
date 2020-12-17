package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class dottedCircle extends Obstacles{
    Pane root;
    dottedCircle() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/sample/dottedCircle.fxml"));
        root.setTranslateX(60);
        root.setId("3");
    }
    protected void playdotted() {
        List<Node> parentChildren =root.getChildren();
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(4000),parentChildren.get(0));
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

    }
    void transparentStar()
    {
        List<Node> firstChildren = root.getChildren();
        ((SVGPath)firstChildren.get(firstChildren.size()-1)).setFill(Color.TRANSPARENT);
    }
    @Override
    Pane returnPane()
    {
        return root;
    }
}
