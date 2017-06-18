package ua.andrewblake.utils;

import java.io.File;
import java.io.FileFilter;

public class FileFilterForSaveReportFileChooser extends javax.swing.filechooser.FileFilter {

    public FileFilterForSaveReportFileChooser() {
        // NOP
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }

    @Override
    public String getDescription() {
        return null;
    }
}
