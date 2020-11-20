package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
public class PauseMenuController {

    @FXML
    public void resume(MouseEvent event){
        System.out.println("resuming");
    }

    @FXML
    public void saveGame(MouseEvent event){
        System.out.println("saving game");
    }

    @FXML
    public void home(MouseEvent event){
        System.out.println("going to home");
    }

}
