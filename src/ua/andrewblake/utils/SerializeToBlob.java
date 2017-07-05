package ua.andrewblake.utils;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
        return SerializeToBlob.deserialize();
    }

}
