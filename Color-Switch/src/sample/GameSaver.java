package sample;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {
        ArrayList<GameData> namesList;
        GameSaver(ArrayList<GameData> namesList)
        {
            this.namesList=namesList;

        }
         void serializeArrayList()
        {
            try {
                FileOutputStream fos
                        = new FileOutputStream("namesListData");

                ObjectOutputStream oos
                        = new ObjectOutputStream(fos);

                oos.writeObject(namesList);
                oos.close();
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
            namesList = (ArrayList<GameData>) in.readObject();


            in.close();
            file.close();

            System.out.println("Object has been deserialized ");

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

