package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static javafx.application.Application.STYLESHEET_MODENA;

public class Score {
    Text a;
    int score=0;
    public Score()
    {
        a= new Text(""+score);
        a.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 40));
        a.setTranslateX(-100);
        a.setTranslateY(-110);
        a.setFill(Color.WHITE);
        a.setOpacity(1);
    }
    int getScore() {
        return score;
    }
    void setScore(int score)
    {
        this.score=score;
    }
    void updateScore(){
        a.setText(""+score);
    }
}
