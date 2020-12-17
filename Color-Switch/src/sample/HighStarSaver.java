package sample;

import java.io.*;
import java.util.ArrayList;

public class HighStarSaver {
    ArrayList<Integer> highStar;
    int HighScore;
    int Stars;

    HighStarSaver(int HighScore,int Stars)
    {
        highStar=new ArrayList<>();
        highStar.add(HighScore);
        highStar.add(Stars);
    }
    void serializeArrayList()
    {


        try {
            // an OutputStream file
            // "namesListData" is
            // created

            FileOutputStream fos
                    = new FileOutputStream("starData");

            // an ObjectOutputStream object is
            // created on the FileOutputStream
            // object
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);

            // calling the writeObject()
            // method of the
            // ObjectOutputStream on the
            // OutputStream file "namesList"
            oos.writeObject(highStar);

            // close the ObjectOutputStream
            oos.close();

            // close the OutputStream file
            fos.close();

            System.out.println("namesList serialized");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    void deserializeArrayList()
    {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("namesListData");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            highStar = (ArrayList<Integer>) in.readObject();


            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
//            System.out.println("a = " + object1);
            //System.out.println("b = " + object1.b);
            //Parent root=object1.pane;
            //primaryStage.setTitle("Color Switch");
            //primaryStage.setScene(new Scene(root, 400, 600));
            //primaryStage.show();
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

}

