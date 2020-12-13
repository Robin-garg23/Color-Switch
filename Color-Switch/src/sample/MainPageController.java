package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

import java.util.*;


public class MainPageController {
    ArrayList<Pane> obstacles=new ArrayList<>();
    Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        pane=new StackPane();
        System.out.println("playing");

//        ConCircle a = new ConCircle();
//        circle a=new circle();
//        pauseSymbol c=new pauseSymbol();
////        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
//        a.initiateTransition();
//        pane=new StackPane();
//        balljump b=new balljump();
//        Star d=new Star();

        ConCircle a = new ConCircle();
        circle op=new circle();
        balljump b=new balljump();
        Star d=new Star();
        d.spawnstar();
        obstacles.add(a.circu());
//        obstacles.add(new Pane(d.circu()));
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                    b.root.toFront();
//               System.out.println(obstacles.get(0).getTranslateY());
//                System.out.println(obstacles.size());
//                System.out.println(obstacles.get(obstacles.size()-1).getTranslateY());
               if(obstacles.get(obstacles.size()-1).getTranslateY()>100)
               {
                   try {
                       ConCircle gg=new ConCircle();
                       double hola=obstacles.get(obstacles.size()-1).getTranslateY()-400;
                       System.out.println(hola);
                       gg.circu().setTranslateY(hola);
                       gg.playCon();
//                       gg.circu().toBack();
                       obstacles.add(gg.circu());
//                       obstacles.get(obstacles.size()-1)
//                       System.out.println("dfgfhggfd");
                       pane.getChildren().add(gg.circu());
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
//                   obstacles.get(0).setTranslateY(obstacles.get(0).getTranslateY() + 1);
////                   System.out.println(obstacles.get(0).getTranslateY());
//                   obstacles.get(1).setTranslateY(obstacles.get(1).getTranslateY() + 1);
               }
               if(obstacles.size()>4)
                   obstacles.remove(0);

//                System.out.println(b.getBallPos());

            }

        }.start();

        pauseSymbol c=new pauseSymbol();
//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
        a.playCon();



        Score e=new Score();

        c.root.setTranslateX(400);
        c.root.setTranslateY(25);
        b.root.setTranslateX(50);
        b.root.setTranslateY(400);


        pane.getChildren().addAll(a.concircl,b.root,c.root,d.imageView,e.a);



//        pane.getChildren().addAll(a.concircl,b.root,c.root,d.imageView,e.a);
//        pane.setOnMouseClicked(event2 -> {
//            System.out.println("Something happened");
//            a.things();
//                });

        b.jump(pane);
        Main.root1.getChildren().setAll(pane);

    }

//    public void collision(balljump b)
//    {
//        List<Node> aa=b.root.getChildren();
//        System.out.println(aa.get(0).getTranslateY());
//    }

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

}
