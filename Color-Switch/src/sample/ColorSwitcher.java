package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ColorSwitcher implements Serializable {
    AnchorPane root;
    private boolean used;
    ColorSwitcher() throws IOException {

        root = FXMLLoader.load(getClass().getResource("colorswitcher.fxml"));
        root.setTranslateX(50);
        used=false;
    }
    Pane returnPane(){ return root;}
    public boolean isUsed(){
        return this.used;
    }
    void transparentSwitcher()
    {
        List<Node> smallswitch=root.getChildren();
        ((Shape) smallswitch.get(0)).setFill(Color.TRANSPARENT);
        ((Shape) smallswitch.get(1)).setFill(Color.TRANSPARENT);
        ((Shape) smallswitch.get(2)).setFill(Color.TRANSPARENT);
        ((Shape) smallswitch.get(3)).setFill(Color.TRANSPARENT);
        ((Shape) smallswitch.get(0)).setStroke(Color.TRANSPARENT);
        ((Shape) smallswitch.get(1)).setStroke(Color.TRANSPARENT);
        ((Shape) smallswitch.get(2)).setStroke(Color.TRANSPARENT);
        ((Shape) smallswitch.get(3)).setStroke(Color.TRANSPARENT);
    }
    public void useIt(){
        used=true;
    }
}
