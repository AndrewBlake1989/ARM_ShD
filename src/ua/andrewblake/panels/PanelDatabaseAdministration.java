package ua.andrewblake.panels;

import ua.andrewblake.exceptions.AccessingFileException;
import ua.andrewblake.exceptions.CommunicateFileSystemException;
import ua.andrewblake.exceptions.FailureLoadDataFromDatabaseException;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.CreateBDB;
import ua.andrewblake.utils.FileFilterForBackupDataBase;
import ua.andrewblake.utils.RestoreDB;
import ua.andrewblake.utils.SerializeToBDB;

import javax.swing.*;
import java.io.File;

public class PanelDatabaseAdministration extends JPanel {

    private JLabel pictureOnPanelDatabaseAdministration;
    private JButton buttonRestore;
    private JButton buttonCreate;
    private JButton buttonBack;
    private JFileChooser fileChooser;

    public PanelDatabaseAdministration() {

        this.setSize(800, 600);
        this.setLayout(null);

        pictureOnPanelDatabaseAdministration = new JLabel(new ImageIcon("src/ua/andrewblake/resources/DataBase.png"));
        this.add(pictureOnPanelDatabaseAdministration);
        pictureOnPanelDatabaseAdministration.setBounds(0, 0, 520, 520);

        buttonRestore = new JButton("Відновити");
        this.add(buttonRestore);
        buttonRestore.setBounds(590, 40, 150, 30);
        buttonRestore.addActionListener(this::buttonRestoreActionPerformed);

        buttonCreate = new JButton("Створити");
        this.add(buttonCreate);
        buttonCreate.setBounds(590, 90, 150, 30);
        buttonCreate.addActionListener(this::buttonCreateActionPerformed);

        buttonBack = new JButton("Назад", new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilterForBackupDataBase());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(false);

        this.setVisible(false);

        GlobalSettings.setPanelDatabaseAdministration(this);

    }

    private void buttonRestoreActionPerformed(java.awt.event.ActionEvent evt) {
        int result = fileChooser.showOpenDialog(this);
        File file;
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        } else {
            return;
        }
        buttonCreate.setVisible(false);
        buttonRestore.setVisible(false);
        buttonBack.setVisible(false);
        this.updateUI();
        try {
            RestoreDB.restoreDB(SerializeToBDB.deserialize(file));
        } catch (AccessingFileException e) {
            if (e.getFileName() == null) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з файлом резервної копії");
                return;
            } else {
                if (e.getFileName().equals("Stat")) {
                    JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
                    return;
                }
            }
        } catch (CommunicateFileSystemException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return;
        } catch (FailureLoadDataFromDatabaseException e) {
            JOptionPane.showMessageDialog(null, "Невідомий збій");
            return;
        }
        JOptionPane.showMessageDialog(null, "База Даних успішно відновлена");
        buttonCreate.setVisible(true);
        buttonRestore.setVisible(true);
        buttonBack.setVisible(true);
        this.updateUI();
    }

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {
        int result = fileChooser.showSaveDialog(this);
        File file;
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        } else {
            return;
        }
        buttonCreate.setVisible(false);
        buttonRestore.setVisible(false);
        buttonBack.setVisible(false);
        this.updateUI();
        try {
            SerializeToBDB.serialize(CreateBDB.create(), file);
        } catch (FailureLoadDataFromDatabaseException e) {
            JOptionPane.showMessageDialog(null, "Збій завантаження інформації з Бази Даних");
            return;
        } catch (CommunicateFileSystemException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return;
        } catch (AccessingFileException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файлом резервної копії");
            return;
        }
        JOptionPane.showMessageDialog(null, "Файл резервної копії Бази Даних успішно створений");
        buttonCreate.setVisible(true);
        buttonRestore.setVisible(true);
        buttonBack.setVisible(true);
        this.updateUI();
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }
}



