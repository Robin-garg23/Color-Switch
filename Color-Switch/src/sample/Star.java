package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Star {



    //Setting the image view
    ImageView imageView;
    Star() throws FileNotFoundException {
        Image image = new Image(new FileInputStream("@../../assets/star.png"));
        imageView = new ImageView(image);

    }



    public void spawnstar() throws FileNotFoundException {
//        imageView.setX(0);
//        imageView.setY(25);
        imageView.setTranslateX(50);

        //setting the fit height and width of the image view
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        //Setting the preserve ratio of the image view

        imageView.setPreserveRatio(true);
    }
}
