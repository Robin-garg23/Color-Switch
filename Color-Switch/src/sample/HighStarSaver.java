package sample;

import java.io.*;
import java.util.ArrayList;

public class HighStarSaver {
    ArrayList<Integer> highStar;
    HighStarSaver(int Highscore,int star)
    {
        highStar=new ArrayList<>();
        highStar.add(Highscore);
        highStar.add(star);
    }


    void serializeArrayList()
    {


        try {
            FileOutputStream fos
                    = new FileOutputStream("starData");
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);
            oos.writeObject(highStar);
            oos.close();
            fos.close();

//            System.out.println("namesList serialized");
        }
        catch (IOException ioe) {
            highStar=new ArrayList<>();
            ioe.printStackTrace();
        }
    }
    void deserializeArrayList()
    {
        try
        {

            FileInputStream file = new FileInputStream("starData");
            ObjectInputStream in = new ObjectInputStream(file);
            highStar = (ArrayList<Integer>) in.readObject();


            in.close();
            file.close();

//            System.out.println("Object has been deserialized ");
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

