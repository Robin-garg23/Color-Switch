package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


//    public static void main(String[] args) {
//        System.out.println("jig");
//
//        System.out.println("checkcheck");
//        launch(args);
//    }
}
