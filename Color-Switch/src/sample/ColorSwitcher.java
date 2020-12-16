package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ColorSwitcher {
    AnchorPane root;
    boolean used;
    ColorSwitcher() throws IOException {

        root = FXMLLoader.load(getClass().getResource("colorswitcher.fxml"));
        root.setTranslateX(50);
        used=false;
    }
    AnchorPane switchu(){ return root;}
    public boolean isUsed(){
        return this.used;
    }
}
