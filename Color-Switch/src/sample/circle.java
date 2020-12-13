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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;


public class circle {

    public AnchorPane root;

    circle() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Circle.fxml"));
    }
    public double x1,x2,x3,x4,y1,y2,y3,y4;
    Paint color1,color2,color3,color4;
    public void initiateTransition(){
        root.setTranslateX(50);
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(4000),root);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

    }

    public void things(){
        List<Node> children=root.getChildren();
        Group inbetween=(Group)children.get(0);
        List<Node> allacrs=inbetween.getChildren();
        Arc arc1=(Arc)allacrs.get(0);
        Arc arc2=(Arc)allacrs.get(1);
        Arc arc3=(Arc)allacrs.get(2);
        Arc arc4=(Arc)allacrs.get(3);

        x1=root.getTranslateX()+arc1.getTranslateX();
        x2=root.getTranslateX()+arc2.getTranslateX();
        x3=root.getTranslateX()+arc3.getTranslateX();
        x4=root.getTranslateX()+arc4.getTranslateX();
        y1=root.getTranslateY()+arc1.getTranslateY();
        y2=root.getTranslateY()+arc2.getTranslateY();
        y3=root.getTranslateY()+arc3.getTranslateY();
        y4=root.getTranslateY()+arc4.getTranslateY();
        color1=arc1.getStroke();
        color2=arc2.getStroke();
        color3=arc3.getStroke();
        color4=arc4.getStroke();
        System.out.println(x1+" "+x2+" "+x3+" "+x4+" "+y1+" "+y2+" "+y3+" "+y4);
    }

}
