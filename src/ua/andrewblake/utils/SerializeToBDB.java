package ua.andrewblake.utils;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import ua.andrewblake.exceptions.AccessingFileException;
import ua.andrewblake.exceptions.CommunicateFileSystemException;
import ua.andrewblake.save.BackupDataBase;
import ua.andrewblake.settings.GlobalSettings;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.*;

public class SerializeToBDB {

    public static void serialize(BackupDataBase bdb, File file) throws AccessingFileException, CommunicateFileSystemException {
        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        String fileExtension = getFileExtension(file);
        String fileName = ((fileExtension != null) && (fileExtension.equals("bdb"))) ? file.getPath() : file.getPath() + ".bdb";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(bdb);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new AccessingFileException(null);
        } catch (IOException e) {
            throw new CommunicateFileSystemException();
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
    }

    private static String getFileExtension(File file) {
        String ext = null;
        String name = file.getName();
        int i = name.lastIndexOf('.');
        if ((i > 0) && (i < name.length() - 1)) {
            ext = name.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static BackupDataBase deserialize(File file) throws AccessingFileException, CommunicateFileSystemException {
        SkinUtil.changeSkin(GlobalSettings.getFrame(), new MetalLookAndFeel());
        BackupDataBase bdb = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            bdb = (BackupDataBase) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new AccessingFileException(null);
        } catch (IOException e) {
            throw new CommunicateFileSystemException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            SkinUtil.changeSkin(GlobalSettings.getFrame(), new WindowsLookAndFeel());
        }
        return bdb;
    }

}
