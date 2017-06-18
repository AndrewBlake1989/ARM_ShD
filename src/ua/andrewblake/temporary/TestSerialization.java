package ua.andrewblake.temporary;

import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;
import java.io.*;

/**
 * Created by AndrewBlake on 04.05.2017.
 */
public class TestSerialization {

    public static void serialize(Object object) {
        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/save/save.ssf"));
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(object);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void serialize2(Object object) {
//        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/save/save2.ssf"));
//             ObjectOutputStream oos = new ObjectOutputStream(fos))
//        {
//            oos.writeObject(object);
//            oos.flush();
//            oos.close();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static Stat deserialize() {
        Stat stat = null;
        try (FileInputStream fis = new FileInputStream(new File("src/ua/andrewblake/save/save.ssf"));
             ObjectInputStream ois = new ObjectInputStream(fis)){
            stat = (Stat) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stat;
    }

}
