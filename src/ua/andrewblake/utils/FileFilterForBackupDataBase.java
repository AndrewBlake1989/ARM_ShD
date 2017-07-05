package ua.andrewblake.utils;

import java.io.File;

public class FileFilterForBackupDataBase extends javax.swing.filechooser.FileFilter {

    public FileFilterForBackupDataBase() {
        // NOP
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() || pathname.getAbsolutePath().endsWith("bdb");
    }

    @Override
    public String getDescription() {
        return "Резрвні копії Бази Даних (*.bdb)";
    }

}
