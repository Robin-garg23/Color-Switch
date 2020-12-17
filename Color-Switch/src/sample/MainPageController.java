package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MainPageController {
    ArrayList<GameData> games=new ArrayList<>();
    GameData currentGame;
    ArrayList<Obstacles> obstacles;
//    ArrayList<Pane> switchers;
    ArrayList<ColorSwitcher> switches;
//    ConCircle a;
    Obstacles firstObs;
    ColorSwitcher j;
    balljump b;
    AnimationTimer ddd;
    pauseSymbol c;
    Score e;
    Shape ball;
    boolean resumeGame=false;

    Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        pane = new StackPane();
        if(resumeGame)
        {
//            switchers=new ArrayList<>();//currentGame.switchers;
            obstacles=new ArrayList<>();//currentGame.obstacles;
            switches=new ArrayList<>();//currentGame.switchers;

//          switchers = new ArrayList<>();
//            obstacles = new ArrayList<>();
            for(int i=0;i<currentGame.obstacles.size();i++)
            {
                Obstacles oops=randObstacle(currentGame.obstacles.get(i).obstaclesType);

                oops.returnPane().setTranslateY(currentGame.obstacles.get(i).obstaclesY);
                if(currentGame.obstacles.get(i).star) {
                    oops.transparentStar();
                    oops.starUsed=true;
                }
                obstacles.add(oops);

            }
            for(int i=0;i<currentGame.switchers.size();i++)
            {
                ColorSwitcher jj=new ColorSwitcher();
                jj.returnPane().setTranslateY(currentGame.switchers.get(i));
                if(currentGame.switcherused.get(i))
                {
                    jj.useIt();
                    jj.transparentSwitcher();
                }
                switches.add(jj);
            }

//            System.out.println("playing");
//            a = new ConCircle();
//        circle op=new circle();
//            j = new ColorSwitcher();
//            j.switchu().setTranslateY(200);
//            switchers.add(j.root);
            b = new balljump();
            b.root.setTranslateY(currentGame.ballY);

            e = new Score();
            e.setScore(currentGame.score);
            ball=(Circle)b.root.getChildren().get(0);
            ball.setFill(Color.web(currentGame.ballColor));
            ball.setStroke(Color.web(currentGame.ballColor));
//            obstacles.add(a.circu());
        }
        if(!resumeGame){
//            switchers = new ArrayList<>();
            obstacles = new ArrayList<>();
            switches = new ArrayList<>();


//            System.out.println("playing");
            ConCircle a = new ConCircle();
            firstObs=a;
            a.playCon();

//        circle op=new circle();
            j = new ColorSwitcher();
            switches.add(j);
            j.returnPane().setTranslateY(200);
//            switches.add(j);
            b = new balljump();
            e = new Score();
            obstacles.add(firstObs);
            ball=(Circle)b.root.getChildren().get(0);
//            a.playCon();
            b.root.setTranslateY(400);
        }
        c = new pauseSymbol();
//        Star d=new Star();
//        d.spawnstar();


//        obstacles.add(new Pane(d.circu()));

        ddd=new AnimationTimer() {
            @Override
            public void handle(long now) {




//
                for(Obstacles i:obstacles){
                    try {
                        newCollide(i,ball);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
                for(ColorSwitcher i:switches){
                    changeColor(i,ball);
                }
                b.root.toFront();
//               System.out.println(obstacles.get(0).getTranslateY());
//                System.out.println(obstacles.size());
//                System.out.println(obstacles.get(obstacles.size()-1).getTranslateY());
               if(obstacles.get(obstacles.size()-1).returnPane().getTranslateY()>100)
               {
                   try {
//                       ConCircle gg=new ConCircle();
                       Obstacles gg=randObstacle();
                       ColorSwitcher jj=new ColorSwitcher();
                       double hola=obstacles.get(obstacles.size()-1).returnPane().getTranslateY()-400;
//                       System.out.println(hola);
                       gg.returnPane().setTranslateY(hola);
                       jj.returnPane().setTranslateY(switches.get(switches.size()-1).returnPane().getTranslateY()-400);
//                       gg.playCon();
//                       gg.circu().toBack();
                       obstacles.add(gg);
//                       switchers.add(jj.returnPane());
                       switches.add(jj);
//                       obstacles.get(obstacles.size()-1)
//                       System.out.println("dfgfhggfd");
                       pane.getChildren().addAll(gg.returnPane(),jj.returnPane());
                   } catch (IOException e) {
//                       e.printStackTrace();
                   }

               }
               if(b.getBallPos()<350) {
                   for(Obstacles fo:obstacles)
                   {
                       fo.returnPane().toBack();
//                       System.out.println(fo.getId());
                       fo.returnPane().setTranslateY(fo.returnPane().getTranslateY() + 1);
                       if(b.getBallPos()<200)
                           fo.returnPane().setTranslateY(fo.returnPane().getTranslateY() + 1);

                   }
                   for(ColorSwitcher fo:switches)
                   {
                        
                       fo.returnPane().setTranslateY(fo.returnPane().getTranslateY() + 1);
                       if(b.getBallPos()<200)
                           fo.returnPane().setTranslateY(fo.returnPane().getTranslateY() + 1);
                   }
//                   obstacles.get(0).setTranslateY(obstacles.get(0).getTranslateY() + 1);
////                   System.out.println(obstacles.get(0).getTranslateY());
//                   obstacles.get(1).setTranslateY(obstacles.get(1).getTranslateY() + 1);
               }
               if(obstacles.size()>4)
                   obstacles.remove(0);
               if(switches.size()>4) {
//                   switchers.remove(0);
                   switches.remove(0);
               }



//                System.out.println(b.getBallPos());

            }

        };
        if(!resumeGame)
        ddd.start();
        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent ee) {
//                System.out.println("Hello World\nfgfdg\ngdfgfdg");
                ddd.start();


                //                circle.setFill(Color.DARKSLATEBLUE);
            }
        };
        if(resumeGame)
        pane.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler2);
//        if(resumeGame) {
//            ddd.stop();
//            pane.setOnMouseClicked(event2 -> {
//            });
//            }
//        }

//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));


        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent ee) {
//                System.out.println("Hello World\nfgfdg\ngdfgfdg");
                try {
                    ddd.stop();
//                    ArrayList<Pane> obstacles,ArrayList<Pane> switchers,ConCircle a,ColorSwitcher j,balljump b,Score e
                    ArrayList<obstacleData> obs=new ArrayList<>();
                    ArrayList<Double> swi=new ArrayList<>();
                    ArrayList<String>  obsID=new ArrayList<>();
                    ArrayList<Boolean> swiused=new ArrayList<>();
                    for(Obstacles i:obstacles){
                        obs.add( new obstacleData(i.starUsed,i.returnPane().getTranslateY(),i.returnPane().getId()));
//                        obsID.add(i.getId());
                    }
                    for(ColorSwitcher i:switches){
                        swi.add(i.returnPane().getTranslateY());
                        swiused.add(i.isUsed());
                    }
                    currentGame=new GameData(obs,swiused,swi, (int) b.getBallPos(),e.getScore(),ball.getFill().toString());
                    Main.database.deserializeArrayList();
                    Main.database.namesList.add(currentGame);
                    Main.database.serializeArrayList();

                    resumeGame=true;
                    c.pause();
//                    System.out.println("sfghggfdsgdhgfdhgfdhddfg");


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//                circle.setFill(Color.DARKSLATEBLUE);
            }
        };



        c.root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        c.root.setTranslateX(400);
        c.root.setTranslateY(25);
        b.root.setTranslateX(50);

//        c.pause();
        for(Obstacles i:obstacles)
        {
            pane.getChildren().add(i.returnPane());
        }
        for(ColorSwitcher i:switches)
        {
            pane.getChildren().add(i.root);
        }
        pane.getChildren().addAll(b.root,c.root,e.a);


        b.jump(pane);
        Main.root1.getChildren().setAll(pane);
//        resumeGame=false;

    }


    @FXML
    public void savedGames(MouseEvent event) throws IOException {
//        System.out.println("saved games");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        savedGames ok=new savedGames();
        Main.root1.getChildren().setAll(ok.root);
    }

    @FXML
    public void exit(MouseEvent event){
//        System.out.println("exiting");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        System.exit(0);
    }
    @FXML
    public void help(MouseEvent event){
//        System.out.println("Made by Utkarsh");
        Media media=new Media(new File("@../../assets/sounds/buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Help");
        errorAlert.setContentText("");

//            errorAlert.showAndWait(5000);
        errorAlert.showAndWait();

    }


    public void newCollide(Obstacles root, Shape ball) throws IOException {


        List<Node> firstChildren = root.returnPane().getChildren();
        if (firstChildren.get(0) instanceof Pane || firstChildren.get(0) instanceof Group) {
            for (Node i : firstChildren) {
                if (i instanceof Pane || i instanceof Group) {
                    List<Node> sendLoop;
                    if(i instanceof Pane){
                        sendLoop=((Pane) i).getChildren();

                    }
                    else{
                        sendLoop=((Group) i).getChildren();
                    }
                    for (Node j:sendLoop) {
                        if (j instanceof Shape) {
                            Shape checkShape = (Shape) j;
                            if (!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()) {
                                Paint color;
                                if(checkShape instanceof SVGPath) {
                                    color = checkShape.getFill();
                                }
                                else{
                                    color = checkShape.getStroke();
                                }

                                if (!color.toString().equals(ball.getFill().toString())) {
                                    Media media=new Media(new File("@../../assets/sounds/gameOver.wav").toURI().toString());
                                    MediaPlayer mediaPlayer=new MediaPlayer(media);
                                    mediaPlayer.setAutoPlay(true);

//                                    System.out.println("diff colour");
//                                    Continue fit=new Continue();
//                                    Main.root1.
                                    ddd.stop();
//                    ArrayList<Pane> obstacles,ArrayList<Pane> switchers,ConCircle a,ColorSwitcher j,balljump b,Score e
                                    ArrayList<obstacleData> obs=new ArrayList<>();
                                    ArrayList<Double> swi=new ArrayList<>();
                                    ArrayList<String>  obsID=new ArrayList<>();
                                    ArrayList<Boolean> swiused=new ArrayList<>();
                                    for(Obstacles ij:obstacles){
                                        obs.add( new obstacleData(ij.starUsed,ij.returnPane().getTranslateY(),ij.returnPane().getId()));
                                    }
                                    for(ColorSwitcher ij:switches){
                                        swi.add(ij.returnPane().getTranslateY());
                                        swiused.add(ij.isUsed());
                                    }
                                    currentGame=new GameData(obs,swiused,swi, (int) b.getBallPos(),e.getScore(),ball.getFill().toString());
                                    Main.database.deserializeArrayList();
                                    Main.database.namesList.add(currentGame);
                                    Main.database.serializeArrayList();

//                                    resumeGame=true;
//                                            c.pause();
//                                    System.out.println("sfghggfdsgdhgfdhgfdhddfg");


// <<<<<<< HEAD
//                                     Continues asd=new Continues();
//                                     Main.root1.getChildren().setAll(asd.root);
//                                     PauseTransition wait = new PauseTransition(Duration.seconds(3));
//                                     wait.setOnFinished((e) -> {
// //                                        System.out.println("hello sfkdsfnkdf");
                                        if(!resumeGame) {
// =======
//                                    Continues asd=new Continues();
//                                    Main.root1.getChildren().setAll(asd.root);

                                            gameOver bye = null;
                                            try {
                                                bye = new gameOver(this.e.getScore());
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }
                                            Main.root1.getChildren().setAll(bye.root);


                                }
                            }
                        }
                        else if(j instanceof Group){
                            for(Node k:((Group)j).getChildren()){
                                Shape checkShape = (Shape) k;
                                if (!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()) {
                                    Paint color = checkShape.getStroke();

                                    if (!color.toString().equals(ball.getFill().toString())) {
                                    Media media=new Media(new File("@../../assets/sounds/gameOver.wav").toURI().toString());
                                    MediaPlayer mediaPlayer=new MediaPlayer(media);
                                    mediaPlayer.setAutoPlay(true);
//                                    System.out.println("diff colour");

                                        ddd.stop();
//                    ArrayList<Pane> obstacles,ArrayList<Pane> switchers,ConCircle a,ColorSwitcher j,balljump b,Score e
                                        ArrayList<obstacleData> obs=new ArrayList<>();
                                        ArrayList<Double> swi=new ArrayList<>();
                                        ArrayList<String>  obsID=new ArrayList<>();
                                        ArrayList<Boolean> swiused=new ArrayList<>();
                                        for(Obstacles ij:obstacles){
                                            obs.add( new obstacleData(ij.starUsed,ij.returnPane().getTranslateY(),ij.returnPane().getId()));
                                        }
                                        for(ColorSwitcher ij:switches){
                                            swi.add(ij.returnPane().getTranslateY());
                                            swiused.add(ij.isUsed());
                                        }
                                        currentGame=new GameData(obs,swiused,swi, (int) b.getBallPos(),e.getScore(),ball.getFill().toString());

                                        Main.database.deserializeArrayList();
                                        Main.database.namesList.add(currentGame);
                                        Main.database.serializeArrayList();

//                                        resumeGame=true;
//                                            c.pause();
// <<<<<<< HEAD
// //                                        System.out.println("sfghggfdsgdhgfdhgfdhddfg");


//                                         Continues asd=new Continues();
//                                         Main.root1.getChildren().setAll(asd.root);
//                                         PauseTransition wait = new PauseTransition(Duration.seconds(5));
//                                         wait.setOnFinished((e) -> {
// //                                            System.out.println("hello sfkdsfnkdf");
//                                             if(!resumeGame) {
// =======
//                                         System.out.println("sfghggfdsgdhgfdhgfdhddfg");
// //                                            System.out.println("hello sfkdsfnkdf");
// >>>>>>> 6f8325f4fc8fe589e7d37c5a2cfa4e9351724654
                                                gameOver bye = null;
                                                try {
                                                    bye = new gameOver(this.e.getScore());
                                                } catch (IOException ex) {
                                                    ex.printStackTrace();
                                                }
                                                Main.root1.getChildren().setAll(bye.root);
                                            
//                                        wait.play();
//                                        System.exit(0);



                                    }
                                }

                            }
                        }


                    }
                }

                if(i instanceof SVGPath){
                    if(!Shape.intersect((Shape)i, ball).getBoundsInLocal().isEmpty()){
                        if(!((SVGPath) i).getFill().equals(Color.TRANSPARENT)){
                            Media media=new Media(new File("@../../assets/sounds/star.wav").toURI().toString());
                            MediaPlayer mediaPlayer=new MediaPlayer(media);
                            mediaPlayer.setAutoPlay(true);
                            ((SVGPath) i).setFill(Color.TRANSPARENT);
                            root.starUsed=true;
                            this.e.setScore(this.e.getScore()+1);
                            this.e.updateScore();
                        }
                    }
                }
            }
        } else {
//            System.out.println("bruh");
            Pane top=(Pane)firstChildren.get(0);
            List<Node> shapes=top.getChildren();
            for (Node j : shapes) {
                if (j instanceof Shape) {
                    Shape checkShape = (Shape) j;
                    if (!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()) {
                        Paint color = checkShape.getStroke();

                        if (!color.toString().equals(ball.getFill().toString())) {
//                            System.out.println("diff colour");
//                            System.out.println("diff colour");
//                            gameOver bye = new gameOver();
//                            Main.root1.getChildren().setAll(bye.root);
                            System.exit(0);

                        }
                    }
                }

            }

        }

    }

        public void changeColor(ColorSwitcher switcher,Shape ball){

            if(switcher.isUsed()){
                return;
            }
            List<Node> smallswitch=switcher.root.getChildren();
            Shape one=(Shape)smallswitch.get(0);
            if (!Shape.intersect(one, ball).getBoundsInLocal().isEmpty()) {
                Media media=new Media(new File("@../../assets/sounds/colorswitch.wav").toURI().toString());
                MediaPlayer mediaPlayer=new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                switcher.useIt();
                Random rand = new Random();

                String[] colors={"0xfae100ff","0xff0181ff","0x32dbf0ff","0x900dffff"};
                int color=rand.nextInt(4);
                while(ball.getFill().toString().equals(colors[color])){
                    color=rand.nextInt(4);
                }
                ball.setFill(Color.web(colors[color]));
                ball.setStroke(Color.web(colors[color]));
                ((Shape) smallswitch.get(0)).setFill(Color.TRANSPARENT);
                ((Shape) smallswitch.get(1)).setFill(Color.TRANSPARENT);
                ((Shape) smallswitch.get(2)).setFill(Color.TRANSPARENT);
                ((Shape) smallswitch.get(3)).setFill(Color.TRANSPARENT);
                ((Shape) smallswitch.get(0)).setStroke(Color.TRANSPARENT);
                ((Shape) smallswitch.get(1)).setStroke(Color.TRANSPARENT);
                ((Shape) smallswitch.get(2)).setStroke(Color.TRANSPARENT);
                ((Shape) smallswitch.get(3)).setStroke(Color.TRANSPARENT);




            }



        }

        Obstacles randObstacle() throws IOException {
            Random rand = new Random();
            Obstacles randObstacle;
            int obstacleNum=rand.nextInt(6);
//        obstacleNum=0;
            switch(obstacleNum)
            {
                case 0:
                    ConCircle a=new ConCircle();
                    randObstacle=a;
                    a.playCon();
                    break;
                case 1:
                    Cross aa=new Cross();
                    randObstacle=aa;
                    aa.playCross();
                    break;
                case 2:
                    circle ab=new circle();
                    randObstacle=ab;
                    ab.initiateTransition();
                    break;
                case 3:
                    dottedCircle abc=new dottedCircle();
                    randObstacle=abc;
                    abc.playdotted();
                    break;
                case 4:
                    ninjaStar abcd=new ninjaStar();
                    randObstacle=abcd;
                    abcd.initiateTransition();
                    break;

                case 5:
                    doubleCross doublecross=new doubleCross();
                    randObstacle= doublecross;
                    doublecross.playTransition();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + obstacleNum);
            }


            return randObstacle;
        }
    Obstacles randObstacle(String a) throws IOException {
        Random rand = new Random();
        Obstacles randObstacle;
        int obstacleNum=Integer.parseInt(a);
//        obstacleNum=0;
        switch(obstacleNum)
        {
            case 0:
                ConCircle ao=new ConCircle();
                randObstacle=ao;
                ao.playCon();
                break;
            case 1:
                Cross aa=new Cross();
                randObstacle=aa;
                aa.playCross();
                break;
            case 2:
                circle ab=new circle();
                randObstacle=ab;
                ab.initiateTransition();
                break;
            case 3:
                dottedCircle abc=new dottedCircle();
                randObstacle=abc;
                abc.playdotted();
                break;
            case 4:
                ninjaStar abcd=new ninjaStar();
                randObstacle=abcd;
                abcd.initiateTransition();
                break;

            case 5:
                doubleCross doublecross=new doubleCross();
                randObstacle= doublecross;
                doublecross.playTransition();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + obstacleNum);
        }


        return randObstacle;
    }

}
