package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.io.Serializable;

public class ColorSwitcher implements Serializable {
    AnchorPane root;
    private boolean used;
    ColorSwitcher() throws IOException {

        root = FXMLLoader.load(getClass().getResource("colorswitcher.fxml"));
        root.setTranslateX(50);
        used=false;
    }
    AnchorPane switchu(){ return root;}
    public boolean isUsed(){
        return this.used;
    }
    public void useIt(){
        used=true;
    }
}
