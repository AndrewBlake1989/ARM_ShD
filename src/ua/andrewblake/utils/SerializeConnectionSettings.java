package ua.andrewblake.utils;

import ua.andrewblake.settings.ConnectionSettings;

import javax.swing.*;
import java.io.*;

public class SerializeConnectionSettings {
    public static void serialize(ConnectionSettings connectionSettings) {
        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/settings/ConnectionSettings.svf"));
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(connectionSettings);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        }
    }

    public static ConnectionSettings deserialize() {
        ConnectionSettings connectionSettings = null;
        try (FileInputStream fis = new FileInputStream(new File("src/ua/andrewblake/settings/ConnectionSettings.svf"));
             ObjectInputStream ois = new ObjectInputStream(fis)){
            connectionSettings = (ConnectionSettings) ois.readObject();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        } catch (ClassNotFoundException e) {
            // NOP
        }
        return connectionSettings;
    }
}
