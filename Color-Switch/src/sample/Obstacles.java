package sample;

import javafx.scene.layout.Pane;

abstract public class Obstacles {
    boolean starUsed=false;
    Obstacles()
    {

    }
    abstract Pane returnPane();
    abstract void transparentStar();
}
