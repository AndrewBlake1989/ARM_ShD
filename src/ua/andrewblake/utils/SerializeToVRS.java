package ua.andrewblake.utils;

import ua.andrewblake.version.Version;

import java.io.*;

public class SerializeToVRS {

    public static void main(String[] args) {
        serialize(new Version("0.7", 9, "2017-07-13"));
    }

    public static void serialize(Version vrs) {
        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/version/Version.vrs"));
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(vrs);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Version deserialize() {
        Version vrs = null;
        try (FileInputStream fis = new FileInputStream(new File("src/ua/andrewblake/version/Version.vrs"));
             ObjectInputStream ois = new ObjectInputStream(fis)){
            vrs = (Version) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vrs;
    }
}
