package ua.andrewblake.utils;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public class SerializeToBlob {

    public static void serialize(Stat stat) {
        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        try (FileOutputStream fos = new FileOutputStream(new File("src/ua/andrewblake/save/SaveStatToBlob.svf"));
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(stat);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
    }

    public static Stat deserialize() {
        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        Stat stat = null;
        try (FileInputStream fis = new FileInputStream(new File("src/ua/andrewblake/save/SaveStatToBlob.svf"));
             ObjectInputStream ois = new ObjectInputStream(fis)){
            stat = (Stat) ois.readObject();
        } catch (IOException e) {
                 e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        } catch (ClassNotFoundException e) {
            // NOP
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
        return stat;
    }

    public static Stat fromBlobToStat(Blob blob) {
        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        try {
            Blob file = blob;
            InputStream x = file.getBinaryStream();
            int size = x.available();
            byte b[] = new byte[size];
            x.read(b);
            try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                targetFile.write(b);
            }
        } catch (SQLException e) {
            if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
            } else {
                JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
        return SerializeToBlob.deserialize();
    }
}
