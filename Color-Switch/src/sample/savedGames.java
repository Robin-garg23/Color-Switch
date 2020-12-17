package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class savedGames {

    public AnchorPane root;

    savedGames() throws IOException {
        root = FXMLLoader.load(getClass().getResource("savedgames.fxml"));
        ArrayList<GameData> allGames=new ArrayList<>();
        GameSaver games=new GameSaver(allGames);
        games.deserializeArrayList();
        List<Node> children=root.getChildren();
        ScrollPane a=(ScrollPane)children.get(1);
        a.setPannable(true);
        a.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        VBox table=(VBox) a.getContent();

//        VBox table=(VBox)b.getChildren().get(0);

        int num=1;
        for(GameData i:games.namesList){
            Text newgame= new Text();
            newgame.setStrokeType(StrokeType.valueOf("OUTSIDE"));
            newgame.setStrokeWidth(0.0);
            newgame.setTextAlignment(TextAlignment.valueOf("CENTER"));
            newgame.setWrappingWidth(409.4700736999512);
            newgame.setAccessibleRole(AccessibleRole.valueOf("BUTTON"));
//            newgame.getparen
            newgame.setOnMouseClicked((MouseEvent event) -> {
                MainPageController bsdk=new MainPageController();
                bsdk.currentGame=i;
//                for(GameData s:dodo.namesList)
//                    System.out.println(s.ballY);
                bsdk.resumeGame=true;
                try {
                    bsdk.play(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            newgame.setText("Game "+num);
            newgame.setStyle("-fx-font: 24 arial;");
            num++;
            table.getChildren().add(newgame);





        }





    }

}
