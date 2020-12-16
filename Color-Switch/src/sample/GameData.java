package sample;

import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable {
//    ArrayList<Pane> obstacles;
//    ArrayList<Pane> switchers;
    ArrayList<Integer> obstaclesY;
    ArrayList<Integer> obstaclesType;
    ArrayList<Integer> switchers;
//    ConCircle a;
//    ColorSwitcher j;
    int ballY;
    int score;
    GameData(ArrayList<Integer> obstaclesY,ArrayList<Integer> obstaclesType,ArrayList<Integer> switchers,int ballY,int score)
    {
        this.obstaclesY=obstaclesY;
        this.obstaclesType=obstaclesType;
        this.switchers=switchers;
        this.ballY=ballY;
//        this.obstacles=obstacles;
        this.score=score;
//        this.switchers=switchers;
    }
}
