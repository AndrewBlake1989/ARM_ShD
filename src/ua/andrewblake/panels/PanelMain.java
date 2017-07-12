package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.SerializeToVRS;
import ua.andrewblake.version.Version;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PanelMain extends JPanel {

    private JLabel pictureOnPanelMain;

    private JLabel labelErrorsOnPanelMain;
    private JButton buttonCreateErrorOnPanelMain;
    private JButton buttonViewErrorOnPanelMain;
    private JButton buttonEditErrorOnPanelMain;

    private JSeparator separator1OnPanelMain;

    private JLabel labelCatalogueOnPanelMain;
    private JButton buttonViewCatalogueOnPanelMain;
    private JButton buttonEditCatalogueOnPanelMain;

    private JSeparator separator2OnPanelMain;

    private JButton buttonCreateReportOnPanelMain;

    private JSeparator separator3OnPanelMain;

    private JButton buttonDatabaseAdministration;

    private JSeparator separator4OnPanelMain;

    private JButton buttonChangeUserOnPanelMain;
    private JButton buttonExitOnPanelMain;

    private JLabel labelUserStatus1OnPanelMain;
    private JLabel labelUserStatus2OnPanelMain;
    private JLabel labelUserStatus3OnPanelMain;
    private JLabel labelUserStatus4OnPanelMain;
    private JLabel labelUserStatus5OnPanelMain;
    private JLabel labelProgramStatus1OnPanelMain;
    private JLabel labelProgramStatus2OnPanelMain;

    public PanelMain() {

        this.setSize(800, 600);
        this.setLayout(null);

        pictureOnPanelMain = new JLabel(new ImageIcon("src/ua/andrewblake/resources/MainImage.jpg"));
        this.add(pictureOnPanelMain);
        pictureOnPanelMain.setBounds(0, 0, 610, 385);

        labelErrorsOnPanelMain = new JLabel("            Несправності:");
        this.add(labelErrorsOnPanelMain);
        labelErrorsOnPanelMain.setBounds(625,10,150,15);

        buttonCreateErrorOnPanelMain = new JButton("Введення");
        this.add(buttonCreateErrorOnPanelMain);
        buttonCreateErrorOnPanelMain.setBounds(625,40,150,25);
        buttonCreateErrorOnPanelMain.addActionListener(this::buttonCreateErrorOnPanelMainActionPerformed);

        buttonViewErrorOnPanelMain = new JButton("Перегляд");
        this.add(buttonViewErrorOnPanelMain);
        buttonViewErrorOnPanelMain.setBounds(625, 80, 150, 25);
        buttonViewErrorOnPanelMain.addActionListener(this::buttonViewErrorOnPanelMainActionPerformed);

        buttonEditErrorOnPanelMain = new JButton("Редагування");
        this.add(buttonEditErrorOnPanelMain);
        buttonEditErrorOnPanelMain.setBounds(625, 120, 150, 25);
        buttonEditErrorOnPanelMain.addActionListener(this::buttonEditErrorOnPanelMainActionPerformed);

        separator1OnPanelMain = new JSeparator();
        this.add(separator1OnPanelMain);
        separator1OnPanelMain.setBounds(625, 160, 150, 5);

        labelCatalogueOnPanelMain = new JLabel("                Довідники:");
        this.add(labelCatalogueOnPanelMain);
        labelCatalogueOnPanelMain.setBounds(625, 180, 105, 15);

        buttonViewCatalogueOnPanelMain = new JButton("Перегляд");
        this.add(buttonViewCatalogueOnPanelMain);
        buttonViewCatalogueOnPanelMain.setBounds(625, 210, 150, 25);
        buttonViewCatalogueOnPanelMain.addActionListener(this::buttonViewCatalogueOnPanelMainActionPerformed);

        buttonEditCatalogueOnPanelMain = new JButton("Редагування");
        this.add(buttonEditCatalogueOnPanelMain);
        buttonEditCatalogueOnPanelMain.setBounds(625, 250, 150, 25);
        buttonEditCatalogueOnPanelMain.addActionListener(this::buttonEditCatalogueOnPanelMainActionPerformed);

        separator2OnPanelMain = new JSeparator();
        this.add(separator2OnPanelMain);
        separator2OnPanelMain.setBounds(625, 300, 150, 5);

        buttonCreateReportOnPanelMain = new JButton("Формування звіту");
        this.add(buttonCreateReportOnPanelMain);
        buttonCreateReportOnPanelMain.setBounds(625, 325, 150, 25);
        buttonCreateReportOnPanelMain.addActionListener(this::buttonCreateReportOnPanelMainActionPerformed);

        separator3OnPanelMain = new JSeparator();
        this.add(separator3OnPanelMain);
        separator3OnPanelMain.setBounds(625, 370, 150, 5);

        buttonDatabaseAdministration = new JButton("Адміністрування БД");
        this.add(buttonDatabaseAdministration);
        buttonDatabaseAdministration.setBounds(625, 395, 150, 25);
        buttonDatabaseAdministration.addActionListener(this::buttonDatabaseAdministrationActionPerformed);

        separator4OnPanelMain = new JSeparator();
        this.add(separator4OnPanelMain);
        separator4OnPanelMain.setBounds(625, 440, 150, 5);

        buttonChangeUserOnPanelMain = new JButton("Змінити користувача");
        this.add(buttonChangeUserOnPanelMain);
        buttonChangeUserOnPanelMain.setBounds(625, 465, 150, 25);
        buttonChangeUserOnPanelMain.addActionListener(this::buttonChangeUserOnPanelMainActionPerformed);

        buttonExitOnPanelMain = new JButton("Вихід");
        this.add(buttonExitOnPanelMain);
        buttonExitOnPanelMain.setBounds(625, 505, 150, 25);
        buttonExitOnPanelMain.addActionListener(this::buttonExitOnPanelMainActionPerformed);

        labelUserStatus1OnPanelMain = new JLabel("Поточний користувач:");
        this.add(labelUserStatus1OnPanelMain);
        labelUserStatus1OnPanelMain.setBounds(10, 425, 200, 15);

        labelUserStatus2OnPanelMain = new JLabel();
        this.add(labelUserStatus2OnPanelMain);
        labelUserStatus2OnPanelMain.setBounds(10, 440, 500, 15);
        labelUserStatus2OnPanelMain.setText("");

        labelUserStatus3OnPanelMain = new JLabel();
        this.add(labelUserStatus3OnPanelMain);
        labelUserStatus3OnPanelMain.setBounds(10, 455, 500, 15);
        labelUserStatus3OnPanelMain.setText("");

        labelUserStatus4OnPanelMain = new JLabel("Права адміністратора:");
        this.add(labelUserStatus4OnPanelMain);
        labelUserStatus4OnPanelMain.setBounds(10, 485, 200, 15);

        labelUserStatus5OnPanelMain = new JLabel();
        this.add(labelUserStatus5OnPanelMain);
        labelUserStatus5OnPanelMain.setBounds(10, 500, 200, 15);
        labelUserStatus5OnPanelMain.setText("");

        labelProgramStatus1OnPanelMain = new JLabel("Версія програми:");
        this.add(labelProgramStatus1OnPanelMain);
        labelProgramStatus1OnPanelMain.setBounds(10, 530, 200, 15);

        labelProgramStatus2OnPanelMain = new JLabel();
        this.add(labelProgramStatus2OnPanelMain);
        labelProgramStatus2OnPanelMain.setBounds(10, 545, 200, 15);
        Version vrs = SerializeToVRS.deserialize();
        labelProgramStatus2OnPanelMain.setText(vrs.sVersion.concat("     [").concat(String.valueOf(vrs.countVersion)).concat("]     ").concat(vrs.sDate));

        this.setVisible(false);

        GlobalSettings.setPanelMain(this);

    }

    private void buttonCreateErrorOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        PanelIntroductionError panelIntroductionError = GlobalSettings.getPanelIntroductionError();
        panelIntroductionError.reset();
        GlobalSettings.getPanelIntroductionError2().reset();
        GlobalSettings.getPanelIntroductionError3().reset();
        panelIntroductionError.setVisible(true);
        panelIntroductionError.fillCurrentDateTime();
        GlobalSettings.setCurrentStat(null);
    }

    private void buttonViewErrorOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelListOfRecordsFromBase().setVisible(true);
        GlobalSettings.getPanelListOfRecordsFromBase().fillCurrentDate();
        GlobalSettings.getPanelListOfRecordsFromBase().refresh();
        GlobalSettings.getPanelListOfRecordsFromBase().reset(false);
    }

    private void buttonEditErrorOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelListOfRecordsFromBase().setVisible(true);
        GlobalSettings.getPanelListOfRecordsFromBase().fillCurrentDate();
        GlobalSettings.getPanelListOfRecordsFromBase().refresh();
        GlobalSettings.getPanelListOfRecordsFromBase().reset(true);
    }

    private void buttonViewCatalogueOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelViewOrEditCatalogues().setVisible(true);
        GlobalSettings.getPanelViewOrEditCatalogues().viewOrEdit(false);
    }

    private void buttonEditCatalogueOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelViewOrEditCatalogues().setVisible(true);
        GlobalSettings.getPanelViewOrEditCatalogues().viewOrEdit(true);
    }

    private void buttonCreateReportOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelReportGenerating().setVisible(true);
        GlobalSettings.getPanelReportGenerating().reset();
    }

    private void buttonDatabaseAdministrationActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelDatabaseAdministration().setVisible(true);
    }

    private void buttonChangeUserOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelAuthorization().setVisible(true);
        GlobalSettings.getPanelAuthorization().setBounds(200, 100, 400, 400);
    }

    private void buttonExitOnPanelMainActionPerformed(java.awt.event.ActionEvent evt) {
        ConnectionToMySQL.closeConnectionToMySQL();
        System.exit(0);
    }

    public void drawUserData() {
        String fullUserPosition;
        String shortUserPosition;
        Statement statementForMySQL = ConnectionToMySQL.getStatementForMySQL();
        try {
            ResultSet resultSetForMySQL = statementForMySQL.executeQuery("select position_full, position_short from positions where id = " + GlobalSettings.getUserPosition() + ";");
            while (resultSetForMySQL.next()) {
                fullUserPosition = resultSetForMySQL.getString(1);
                shortUserPosition = resultSetForMySQL.getString(2);
                labelUserStatus2OnPanelMain.setText(fullUserPosition + " (" + shortUserPosition + ")");
                labelUserStatus3OnPanelMain.setText(GlobalSettings.getUserName());
                labelUserStatus5OnPanelMain.setText(GlobalSettings.isUserIsAdministrator()?"Так":"Ні");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
        }
        buttonEditErrorOnPanelMain.setEnabled(GlobalSettings.isUserIsAdministrator());
        buttonEditCatalogueOnPanelMain.setEnabled(GlobalSettings.isUserIsAdministrator());
    }

}
