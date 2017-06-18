package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;

public class PanelViewOrEditCatalogues extends JPanel {

    private JLabel labelImage;
    private JLabel labelCatalogue;
    private JButton buttonStations;
    private JButton buttonPeregons;
    private JButton buttonUsers;
    private JButton buttonEquipmentTechnicalPoints;
    private JButton buttonBack;
    private boolean edit;

    public PanelViewOrEditCatalogues() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelImage = new JLabel();
        this.add(labelImage);
        labelImage.setBounds(-60, 0, 670, 520);
        labelImage.setIcon(new ImageIcon("src/ua/andrewblake/resources/Catalogue.jpg"));

        labelCatalogue = new JLabel("Довідники:");
        this.add(labelCatalogue);
        labelCatalogue.setBounds(675, 10, 60, 15);

        buttonStations = new JButton("Станції");
        this.add(buttonStations);
        buttonStations.setBounds(630, 40, 150, 25);
        buttonStations.addActionListener(this::buttonStationsActionPerformed);

        buttonPeregons = new JButton("Перегони");
        this.add(buttonPeregons);
        buttonPeregons.setBounds(630, 80, 150, 25);
        buttonPeregons.addActionListener(this::buttonPeregonsActionPerformed);

        buttonUsers = new JButton("Користувачі");
        this.add(buttonUsers);
        buttonUsers.setBounds(630, 120, 150, 25);
        buttonUsers.addActionListener(this::buttonUsersActionPerformed);

        buttonEquipmentTechnicalPoints = new JButton("Бали ТО");
        this.add(buttonEquipmentTechnicalPoints);
        buttonEquipmentTechnicalPoints.setBounds(630, 160, 150, 25);
        buttonEquipmentTechnicalPoints.addActionListener(this::buttonEquipmentTechnicalPointsActionPerformed);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelViewOrEditCatalogues(this);

    }


    public void viewOrEdit(boolean edit) {
        this.edit = edit;
        buttonUsers.setVisible(edit);
        buttonEquipmentTechnicalPoints.setVisible(edit);
    }

    private void buttonStationsActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelCatalogueStations().setVisible(true);
        GlobalSettings.getPanelCatalogueStations().viewOrEdit(edit);
        GlobalSettings.getPanelCatalogueStations().refresh();
    }

    private void buttonPeregonsActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelCataloguePeregons().setVisible(true);
        GlobalSettings.getPanelCataloguePeregons().viewOrEdit(edit);
        GlobalSettings.getPanelCataloguePeregons().refresh();
    }

    private void buttonUsersActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelCatalogueUsers().setVisible(true);
        GlobalSettings.getPanelCatalogueUsers().refresh();
    }

    private void buttonEquipmentTechnicalPointsActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelCatalogueEquipmentTechnicalPoints().setVisible(true);
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }

}
