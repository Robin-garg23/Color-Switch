package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

import java.io.IOException;
import java.util.*;

public class MainPageController {
    ArrayList<GameData> games=new ArrayList<>();
    GameData currentGame;
    ArrayList<Pane> obstacles;
    ArrayList<Pane> switchers;
    ArrayList<ColorSwitcher> switches;
//    ConCircle a;
    Pane firstObs;
    ColorSwitcher j;
    balljump b;
    AnimationTimer ddd;
    pauseSymbol c;
    Score e;
    boolean resumeGame=false;

    Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        pane = new StackPane();
        if(resumeGame)
        {
            switchers=new ArrayList<>();//currentGame.switchers;
            obstacles=new ArrayList<>();//currentGame.obstacles;
            switches=new ArrayList<>();//currentGame.switchers;

//          switchers = new ArrayList<>();
//            obstacles = new ArrayList<>();
            for(int i=0;i<currentGame.obstaclesType.size();i++)
            {

                ConCircle a=new ConCircle();
                a.circu().setTranslateY(currentGame.obstaclesY.get(i));
                obstacles.add(a.circu());

            }
            for(Integer g:currentGame.switchers)
            {
                ColorSwitcher jj=new ColorSwitcher();
                switches.add(jj);
                jj.switchu().setTranslateY(g);
                switchers.add(jj.switchu());
            }

            System.out.println("playing");
//            a = new ConCircle();
//        circle op=new circle();
//            j = new ColorSwitcher();
//            j.switchu().setTranslateY(200);
//            switchers.add(j.root);
            b = new balljump();
            b.root.setTranslateY(currentGame.ballY);

            e = new Score();
            e.setScore(currentGame.score);
//            obstacles.add(a.circu());
        }
        if(!resumeGame) {
            switchers = new ArrayList<>();
            obstacles = new ArrayList<>();
            switches = new ArrayList<>();


            System.out.println("playing");
            ConCircle a = new ConCircle();
            firstObs=a.circu();
            a.playCon();

//        circle op=new circle();
            j = new ColorSwitcher();
            switches.add(j);
            j.switchu().setTranslateY(200);
            switchers.add(j.root);
            b = new balljump();
            e = new Score();
            obstacles.add(firstObs);
//            a.playCon();
            b.root.setTranslateY(400);
        }
        c = new pauseSymbol();
//        Star d=new Star();
//        d.spawnstar();

        Shape ball=(Circle)b.root.getChildren().get(0);
//        obstacles.add(new Pane(d.circu()));

        ddd=new AnimationTimer() {
            @Override
            public void handle(long now) {


                for(Pane i:obstacles){
                    newCollide(i,ball);
                }
                for(ColorSwitcher i:switches){
                    changeColor(i,ball);
                }
                b.root.toFront();
//               System.out.println(obstacles.get(0).getTranslateY());
//                System.out.println(obstacles.size());
//                System.out.println(obstacles.get(obstacles.size()-1).getTranslateY());
               if(obstacles.get(obstacles.size()-1).getTranslateY()>100)
               {
                   try {
//                       ConCircle gg=new ConCircle();
                       Pane gg=randObstacle();
                       ColorSwitcher jj=new ColorSwitcher();
                       double hola=obstacles.get(obstacles.size()-1).getTranslateY()-400;
                       System.out.println(hola);
                       gg.setTranslateY(hola);
                       jj.switchu().setTranslateY(switchers.get(switchers.size()-1).getTranslateY()-400);
//                       gg.playCon();
//                       gg.circu().toBack();
                       obstacles.add(gg);
                       switchers.add(jj.switchu());
                       switches.add(jj);
//                       obstacles.get(obstacles.size()-1)
//                       System.out.println("dfgfhggfd");
                       pane.getChildren().addAll(gg,jj.switchu());
                   } catch (IOException e) {
//                       e.printStackTrace();
                   }

               }
               if(b.getBallPos()<350) {
                   for(Pane fo:obstacles)
                   {
                       fo.toBack();
                       fo.setTranslateY(fo.getTranslateY() + 1);
                   }
                   for(Pane fo:switchers)
                   {

                       fo.setTranslateY(fo.getTranslateY() + 1);
                   }
//                   obstacles.get(0).setTranslateY(obstacles.get(0).getTranslateY() + 1);
////                   System.out.println(obstacles.get(0).getTranslateY());
//                   obstacles.get(1).setTranslateY(obstacles.get(1).getTranslateY() + 1);
               }
               if(obstacles.size()>4)
                   obstacles.remove(0);

//                System.out.println(b.getBallPos());

            }

        };
        ddd.start();


//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent ee) {
//                System.out.println("Hello World\nfgfdg\ngdfgfdg");
                try {
                    ddd.stop();
//                    ArrayList<Pane> obstacles,ArrayList<Pane> switchers,ConCircle a,ColorSwitcher j,balljump b,Score e
                    ArrayList<Integer> obsy=new ArrayList<>();
                    ArrayList<Integer> swi=new ArrayList<>();
                    for(Pane i:obstacles){
                        obsy.add((int) i.getTranslateY());
                    }
                    for(Pane i:switchers){
                        swi.add((int) i.getTranslateY());
                    }
                    currentGame=new GameData(obsy,obsy,swi, (int) b.getBallPos(),e.getScore());
                    GameSaver dodo=new GameSaver(games);
                    dodo.deserializeArrayList();
                    dodo.namesList.add(currentGame);
                    dodo.serializeArrayList();

                    resumeGame=true;
                    c.pause();
                    System.out.println("sfghggfdsgdhgfdhgfdhddfg");



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
        for(Pane i:obstacles)
        {
            pane.getChildren().add(i);
        }
        for(Pane i:switchers)
        {
            pane.getChildren().add(i);
        }
        pane.getChildren().addAll(b.root,c.root,e.a);


        b.jump(pane);
        Main.root1.getChildren().setAll(pane);

    }


    @FXML
    public void savedGames(MouseEvent event){
        System.out.println("saved games");
    }

    @FXML
    public void exit(MouseEvent event){
        System.out.println("exiting");
        System.exit(0);
    }
    @FXML
    public void help(MouseEvent event){
        System.out.println("Made by Utkarsh");

    }


    public void newCollide(Pane root, Shape ball) {


        List<Node> firstChildren = root.getChildren();
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
//                                    System.out.println("diff colour");
//                                    gameOver bye = new gameOver();
//                                    Main.root1.getChildren().setAll(bye.root);
                                    System.exit(0);

                                }
                            }
                        }
                        else if(j instanceof Group){
                            for(Node k:((Group)j).getChildren()){
                                Shape checkShape = (Shape) k;
                                if (!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()) {
                                    Paint color = checkShape.getStroke();

                                    if (!color.toString().equals(ball.getFill().toString())) {
//                                    System.out.println("diff colour");
//                                    gameOver bye = new gameOver();
//                                    Main.root1.getChildren().setAll(bye.root);
                                        System.exit(0);

                                    }
                                }

                            }
                        }


                    }
                }
                if( i instanceof ImageView){


                }
                if(i instanceof SVGPath){
                    if(!Shape.intersect((Shape)i, ball).getBoundsInLocal().isEmpty()){
                        if(!((SVGPath) i).getFill().equals(Color.TRANSPARENT)){
                            ((SVGPath) i).setFill(Color.TRANSPARENT);
                            this.e.setScore(this.e.getScore()+1);
                            this.e.updateScore();
                        }
                    }
                }
            }
        } else {
            System.out.println("bruh");
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
                switcher.useIt();
                Random rand = new Random();
                int color=rand.nextInt(4);
                String[] colors={"#fae100","#ff0181","#32dbf0","#900dff"};
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

        Pane randObstacle() throws IOException {
            Random rand = new Random();
            Pane randObsPane;
            int obstacleNum=rand.nextInt(6);
//        obstacleNum=0;
            switch(obstacleNum)
            {
                case 0:
                    ConCircle a=new ConCircle();
                    randObsPane=a.circu();
                    a.playCon();
                    break;
                case 1:
                    Cross aa=new Cross();
                    randObsPane=aa.root;
                    aa.playCross();
                    break;
                case 2:
                    circle ab=new circle();
                    randObsPane=ab.root;
                    ab.initiateTransition();
                    break;
                case 3:
                    dottedCircle abc=new dottedCircle();
                    randObsPane=abc.root;
                    abc.playdotted();
                    break;
                case 4:
                    ninjaStar abcd=new ninjaStar();
                    randObsPane=abcd.root;
                    abcd.initiateTransition();
                    break;

                case 5:
                    doubleCross doublecross=new doubleCross();
                    randObsPane= doublecross.root;
                    doublecross.playTransition();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + obstacleNum);
            }

            return randObsPane;
        }

}
