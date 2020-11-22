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

import java.sql.SQLOutput;
import java.util.List;
import sample.mainPage;
public class Main extends Application {
    public static Group root1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        mainPage page=new mainPage();
        page.initiateTransitions();
        primaryStage.setTitle("Color Switch");
        root1 = new Group();
        root1.getChildren().add(page.root);
        primaryStage.setScene(new Scene(root1, 500, 700,Color.web("#272727")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
