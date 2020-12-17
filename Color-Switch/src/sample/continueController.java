package sample;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class continueController {
    ArrayList<GameData> sdsd;
    @FXML
    public void continueGame(MouseEvent e) throws IOException {
        GameSaver dodo=new GameSaver(sdsd);
        dodo.deserializeArrayList();
//        dodo.namesList.get(dodo);
        MainPageController bsdk=new MainPageController();
        dodo.namesList.get(dodo.namesList.size()-1).ballY+=30;
        bsdk.currentGame=dodo.namesList.get(dodo.namesList.size()-1);
        for(GameData s:dodo.namesList)
//            System.out.println(s.ballY);
        bsdk.resumeGame=true;
        bsdk.play(null);

    }

//    public void continueGame(jmouseEvent) {
//    }
}
