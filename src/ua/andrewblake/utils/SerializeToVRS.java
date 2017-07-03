package ua.andrewblake.utils;

import ua.andrewblake.version.Version;

import java.io.*;

public class SerializeToVRS {

    public static void serialize(Version vrs) {
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
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
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
    }

    public static Version deserialize() {
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
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
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        return vrs;
    }
}
