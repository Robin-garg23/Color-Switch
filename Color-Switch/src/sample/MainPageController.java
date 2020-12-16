package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.io.IOException;
import java.util.*;

public class MainPageController {
    ArrayList<Pane> obstacles=new ArrayList<>();
    ArrayList<Pane> switchers=new ArrayList<>();
    Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
    StackPane pane;
    @FXML
    public void play(MouseEvent event) throws IOException {
        pane=new StackPane();
        System.out.println("playing");
        ConCircle a = new ConCircle();
        circle op=new circle();
        ColorSwitcher j=new ColorSwitcher();
        j.switchu().setTranslateY(200);
        switchers.add(j.root);
        balljump b=new balljump();
//        Star d=new Star();
//        d.spawnstar();
        obstacles.add(a.circu());
        Shape ball=(Circle)b.root.getChildren().get(0);
//        obstacles.add(new Pane(d.circu()));
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(Pane i:obstacles){
                    newCollide(i,ball);
                }
                    b.root.toFront();
//               System.out.println(obstacles.get(0).getTranslateY());
//                System.out.println(obstacles.size());
//                System.out.println(obstacles.get(obstacles.size()-1).getTranslateY());
               if(obstacles.get(obstacles.size()-1).getTranslateY()>100)
               {
                   try {
                       ConCircle gg=new ConCircle();
                       ColorSwitcher jj=new ColorSwitcher();
                       double hola=obstacles.get(obstacles.size()-1).getTranslateY()-400;
                       System.out.println(hola);
                       gg.circu().setTranslateY(hola);
                       jj.switchu().setTranslateY(switchers.get(switchers.size()-1).getTranslateY()-400);
                       gg.playCon();
//                       gg.circu().toBack();
                       obstacles.add(gg.circu());
                       switchers.add(jj.switchu());
//                       obstacles.get(obstacles.size()-1)
//                       System.out.println("dfgfhggfd");
                       pane.getChildren().addAll(gg.circu(),jj.switchu());
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

        }.start();

        pauseSymbol c=new pauseSymbol();
//        StackPane pane= FXMLLoader.load(getClass().getResource("/sample/concircle.fxml"));
        a.playCon();



        Score e=new Score();

        c.root.setTranslateX(400);
        c.root.setTranslateY(25);
        b.root.setTranslateX(50);
        b.root.setTranslateY(400);

        pane.getChildren().addAll(a.concircl,b.root,c.root,e.a,j.root);


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
    public void checkCollision(Pane obstacle,balljump ball ){
        Pane obstacleRoot= obstacle;
        StackPane ballRoot= ball.root;
        List<Node> groups=obstacleRoot.getChildren();
        Group outerCircle=(Group)groups.get(0);
        Group innerCircle=(Group)groups.get(1);

        Bounds outerbound=outerCircle.localToScene(outerCircle.getBoundsInLocal());
        Bounds ballbound = ballRoot.localToScene(ballRoot.getBoundsInLocal());
//        System.out.println( ballbound.getCenterY());
        Circle a=new Circle();

//        Shape.intersect(ballRoot,outerCircle);
        if(obstacle.intersects(ballbound)){
            System.out.println("ye kya hai");
        }
        if(ballRoot.intersects(outerCircle.getBoundsInLocal())){
            System.out.println("outerhit");
        }
        if(innerCircle.intersects(ballbound)){
            System.out.println("innerhit");
        }
        double ballx=ballRoot.getTranslateX();
        double bally= ball.getBallPos();

        double obstaclex=obstacleRoot.getTranslateX();
        double obstacley=obstacleRoot.getTranslateY();

        double distx=obstaclex-ballx;
        double disty=obstacley-bally;

        double dist=Math.sqrt(distx*distx+disty*disty);

        double ballradii=15;
        double outcircleradii=130;
        double innercircleradii=100;

//        if(dist<Math.abs(ballradii-outcircleradii)){
//            System.out.println("ball in inside bruh");
//        }
//        else if(dist<=ballradii+outcircleradii ){
//            System.out.println("Outer circle hit");
//
//        }
//        if(dist<Math.abs(ballradii-innercircleradii)){
//            System.out.println("ball in inside bruh");
//        }
//        else if(dist<=ballradii+innercircleradii){
//            System.out.println("inner circle hit");
//
//        }



    }

    public void newCollide(Pane root, Shape ball){


        List<Node> firstChildren=root.getChildren();
        if(firstChildren.get(0) instanceof Pane){
            for(Node i:firstChildren){
                if(i instanceof Pane) {
                    for (Node j : ((Pane) i).getChildren()) {
                        Shape checkShape = (Shape) j;
                        if (!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()) {
                            Paint color = checkShape.getStroke();

                            if (!color.toString().equals(ball.getFill().toString())) {
                                System.out.println("diff colour");
                                System.exit(0);

                            }
                        }


                    }
                }

            }
        }
        else{
            for(Node j:((Pane) firstChildren).getChildren()){
                Shape checkShape=(Shape)j;
                if(!Shape.intersect(checkShape, ball).getBoundsInLocal().isEmpty()){
                    Paint color=checkShape.getStroke();

                    if(!color.toString().equals(ball.getFill().toString())){
                        System.out.println("diff colour");
                        System.exit(0);

                    }
                }


            }

        }













//
//
//        List<Node> children = root.getChildren();
//        GridPane inbetween = (GridPane) children.get(0);
//        List<Node> allacrs = inbetween.getChildren();
//        Arc arc1 = (Arc) allacrs.get(0);
//        Arc arc2 = (Arc) allacrs.get(1);
//        Arc arc3 = (Arc) allacrs.get(2);
//        Arc arc4 = (Arc) allacrs.get(3);
//
//        if(!Shape.intersect(arc1, ball).getBoundsInLocal().isEmpty()){
//            Paint color=arc1.getStroke();
//
//            if(!color.toString().equals(ball.getFill().toString())){
//                System.out.println("diff colour");
//                System.exit(0);
//
//            }
//        }
//        if(!Shape.intersect(arc2, ball).getBoundsInLocal().isEmpty()){
//            Paint color=arc2.getStroke();
//
//            if(!color.toString().equals(ball.getFill().toString())){
//                System.out.println("diff colour");
//                System.exit(0);
//
//            }
//        }
//        if(!Shape.intersect(arc3, ball).getBoundsInLocal().isEmpty()){
//            Paint color=arc3.getStroke();
//
//            if(!color.toString().equals(ball.getFill().toString())){
//                System.out.println("diff colour");
//                System.exit(0);
//
//            }
//        }
//        if(!Shape.intersect(arc4, ball).getBoundsInLocal().isEmpty()){
//            Paint color=arc4.getStroke();
//
//            if(!color.toString().equals(ball.getFill().toString())){
//                System.out.println("diff colour");
//                System.exit(0);
//
//            }
//        }
//        System.out.println(Shape.intersect(arc1,ball).getBoundsInLocal().isEmpty()+" "+Shape.intersect(arc2,ball).getBoundsInLocal().isEmpty()+" "+Shape.intersect(arc3,ball).getBoundsInLocal().isEmpty()+" "+Shape.intersect(arc4,ball).getBoundsInLocal().isEmpty());


    }

}
