package ua.andrewblake;

import ua.andrewblake.panels.*;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    PanelNoConnection panelNoConnection = new PanelNoConnection();
    PanelConnectionSettings panelConnectionSettings = new PanelConnectionSettings();
    PanelMain panelMain = new PanelMain();
    PanelAuthorization panelAuthorization = new PanelAuthorization();
    PanelIntroductionError panelIntroductionError = new PanelIntroductionError();
    PanelIntroductionError2 panelIntroductionError2 = new PanelIntroductionError2();
    PanelIntroductionError3 panelIntroductionError3 = new PanelIntroductionError3();
    PanelPreviousView panelPreviousView = new PanelPreviousView();
    PanelListOfRecordsFromBase panelListOfRecordsFromBase = new PanelListOfRecordsFromBase();
    PanelViewRecord panelViewRecord = new PanelViewRecord();
    PanelViewOrEditCatalogues panelViewOrEditCatalogues = new PanelViewOrEditCatalogues();
    PanelCatalogueStations panelCatalogueStations = new PanelCatalogueStations();
    PanelCataloguePeregons panelCataloguePeregons = new PanelCataloguePeregons();
    PanelCatalogueUsers panelCatalogueUsers;
    PanelReportGenerating panelReportGenerating = new PanelReportGenerating();
    PanelCatalogueEquipmentTechnicalPoints panelCatalogueEquipmentTechnicalPoints;
    PanelDatabaseAdministration panelDatabaseAdministration = new PanelDatabaseAdministration();

    private Frame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("АРМ ШД");
        setPreferredSize(new Dimension(400, 400));
        setResizable(false);
        setSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        this.add(panelNoConnection);
        this.add(panelConnectionSettings);
        this.add(panelAuthorization);
        this.add(panelMain);
        this.add(panelIntroductionError);
        this.add(panelIntroductionError2);
        this.add(panelIntroductionError3);
        this.add(panelPreviousView);
        this.add(panelListOfRecordsFromBase);
        this.add(panelViewRecord);
        this.add(panelViewOrEditCatalogues);
        this.add(panelCatalogueStations);
        this.add(panelCataloguePeregons);
        this.add(panelReportGenerating);
        this.add(panelDatabaseAdministration);

        GlobalSettings.setFrame(this);

        pack();

        if (!GlobalSettings.isAvailabilityConnectionWithBD()) {
            panelNoConnection.setVisible(true);
        } else {
            panelAuthorization.setVisible(true);
            panelCatalogueUsers = new PanelCatalogueUsers();
            panelCatalogueEquipmentTechnicalPoints = new PanelCatalogueEquipmentTechnicalPoints();
            this.add(panelCatalogueUsers);
            this.add(panelCatalogueEquipmentTechnicalPoints);
        }
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            // NOP
            return;
        }
        EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        ConnectionToMySQL.closeConnectionToMySQL();
    }



}
