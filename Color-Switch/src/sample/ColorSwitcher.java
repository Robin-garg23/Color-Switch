package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.io.Serializable;

public class ColorSwitcher implements Serializable {
    AnchorPane root;
    ColorSwitcher() throws IOException {

        root = FXMLLoader.load(getClass().getResource("colorswitcher.fxml"));
        root.setTranslateX(50);
    }
    AnchorPane switchu(){ return root;}
}
