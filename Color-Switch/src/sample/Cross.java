package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;


public class Cross extends Obstacles{
    AnchorPane root;
    Cross() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/sample/Cross2.fxml"));
        root.setTranslateX(150);
        root.setId("1");
    }
    protected void playCross() {
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
