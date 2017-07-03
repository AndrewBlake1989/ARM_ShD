package ua.andrewblake.utils;

import ua.andrewblake.settings.ConnectionSettings;

import java.io.*;

public class SerializeConnectionSettings {
    public static void serialize(ConnectionSettings connectionSettings) {
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/settings/ConnectionSettings.svf"));
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(connectionSettings);
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

    public static ConnectionSettings deserialize() {
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        ConnectionSettings connectionSettings = null;
        try (FileInputStream fis = new FileInputStream(new File("src/ua/andrewblake/settings/ConnectionSettings.svf"));
             ObjectInputStream ois = new ObjectInputStream(fis)){
            connectionSettings = (ConnectionSettings) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        return connectionSettings;
    }
}
