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


public class pauseSymbol {

    public AnchorPane root;

    pauseSymbol() throws IOException {
        root=FXMLLoader.load(getClass().getResource("pauseSymbol.fxml"));
    }
    public void pause() throws IOException {
//        root.setOnMouseClicked(event -> {

            pauseMenu pause = null;
            try {
                pause = new pauseMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
            StackPane pane = new StackPane();
            pane.getChildren().add(pause.root);
            Main.root1.getChildren().setAll(pane);
//        });
    }



}
