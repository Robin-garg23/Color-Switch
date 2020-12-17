package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;

class obstacleData implements Serializable
{
    Double obstaclesY;
    String obstaclesType;
    boolean star;
    obstacleData(boolean star,Double obstaclesY,String obstaclesType)
    {
        this.obstaclesType=obstaclesType;
        this.obstaclesY=obstaclesY;
        this.star=star;
    }
}
public class GameData implements Serializable {
//    ArrayList<Pane> obstacles;
//    ArrayList<Pane> switchers;
    ArrayList<obstacleData> obstacles;
//    ArrayList<String> obstaclesType;
    ArrayList<Double> switchers;
    ArrayList<Boolean> switcherused;
//    ConCircle a;
//    ColorSwitcher j;
    int ballY;
    String ballColor;
    int score;
    GameData(ArrayList<obstacleData> obstacles,ArrayList<Boolean> switcherused,ArrayList<Double> switchers,int ballY,int score,String ballColor)
    {
        this.obstacles=obstacles;
//        this.obstaclesType=obstaclesType;
        this.switcherused=switcherused;
        this.switchers=switchers;
        this.ballY=ballY;
//        this.obstacles=obstacles;
        this.score=score;
        this.ballColor=(String)ballColor;
//        this.switchers=switchers;
    }
}
