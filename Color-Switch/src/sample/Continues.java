package sample;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class Continues {
    AnchorPane root;
    Continues() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/sample/continue.fxml"));
        root.setTranslateX(150);
//        root.setId("1");
    }
//    void wannaContinue()
//    {
//        PauseTransition wait = new PauseTransition(Duration.seconds(5));
//        wait.setOnFinished((e) -> {
//            System.out.println("hello sfkdsfnkdf");
//            gameOver bye = null;
//            try {
//                bye = new gameOver(this.e.getScore());
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            Main.root1.getChildren().setAll(bye.root);
//        });
//        wait.play();
//    }
}
