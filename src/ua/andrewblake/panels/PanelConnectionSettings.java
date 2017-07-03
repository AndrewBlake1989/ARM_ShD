package ua.andrewblake.panels;

import ua.andrewblake.MainClass;
import ua.andrewblake.settings.ConnectionSettings;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.SerializeConnectionSettings;

import javax.swing.*;

public class PanelConnectionSettings extends JPanel {

    private JLabel labelImage;
    private JLabel labelIP;
    private JTextField textFieldIP1;
    private JTextField textFieldIP2;
    private JTextField textFieldIP3;
    private JTextField textFieldIP4;
    private JLabel labelPort;
    private JTextField textFieldPort;
    private JLabel labelDB;
    private JTextField textFieldDB;
    private JLabel labelUserName;
    private JTextField textFieldUserName;
    private JLabel labelPassword;
    private JPasswordField passwordFieldPassword;
    private JButton buttonSave;

    public PanelConnectionSettings() {

        this.setSize(400, 400);
        this.setLayout(null);

        labelImage = new JLabel(new ImageIcon("src/ua/andrewblake/resources/ConnectionSettings.png"));
        this.add(labelImage);
        labelImage.setBounds(100, 0, 200, 200);

        labelIP = new JLabel("IP адреса сервера:");
        this.add(labelIP);
        labelIP.setBounds(10, 223, 100, 15);

        textFieldIP1 = new JTextField();
        this.add(textFieldIP1);
        textFieldIP1.setBounds(110, 220, 25, 20);

        textFieldIP2 = new JTextField();
        this.add(textFieldIP2);
        textFieldIP2.setBounds(140, 220, 25, 20);

        textFieldIP3 = new JTextField();
        this.add(textFieldIP3);
        textFieldIP3.setBounds(170, 220, 25, 20);

        textFieldIP4 = new JTextField();
        this.add(textFieldIP4);
        textFieldIP4.setBounds(200, 220, 25, 20);

        labelPort = new JLabel("Порт:");
        this.add(labelPort);
        labelPort.setBounds(10, 253, 30, 15);

        textFieldPort = new JTextField();
        this.add(textFieldPort);
        textFieldPort.setBounds(45, 250, 30, 20);

        labelDB = new JLabel("Назва БД:");
        this.add(labelDB);
        labelDB.setBounds(10, 283, 55, 15);

        textFieldDB = new JTextField();
        this.add(textFieldDB);
        textFieldDB.setBounds(65, 280, 160, 20);

        labelUserName = new JLabel("Username:");
        this.add(labelUserName);
        labelUserName.setBounds(10, 313, 55, 15);

        textFieldUserName = new JTextField();
        this.add(textFieldUserName);
        textFieldUserName.setBounds(65, 310, 160, 20);

        labelPassword = new JLabel("Password:");
        this.add(labelPassword);
        labelPassword.setBounds(10, 343, 55, 15);

        passwordFieldPassword = new JPasswordField();
        this.add(passwordFieldPassword);
        passwordFieldPassword.setBounds(65, 340, 160, 20);

        buttonSave = new JButton("Зберегти");
        this.add(buttonSave);
        buttonSave.setBounds(280, 340, 80, 25);
        buttonSave.addActionListener(this::buttonConnectSettingsActionPerformed);

        this.setVisible(false);
        GlobalSettings.setPanelConnectionSettings(this);

    }

    public void fillParams() {
        buttonSave.setVisible(true);
        ConnectionSettings connectionSettings = SerializeConnectionSettings.deserialize();
        textFieldIP1.setText(String.valueOf(connectionSettings.ip1));
        textFieldIP2.setText(String.valueOf(connectionSettings.ip2));
        textFieldIP3.setText(String.valueOf(connectionSettings.ip3));
        textFieldIP4.setText(String.valueOf(connectionSettings.ip4));
        textFieldPort.setText(String.valueOf(connectionSettings.port));
        textFieldDB.setText(connectionSettings.nameDB);
        textFieldUserName.setText(connectionSettings.username);
        passwordFieldPassword.setText(connectionSettings.password);
    }

//    @SuppressWarnings("all")
    private void buttonConnectSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        buttonSave.setVisible(false);
        ConnectionSettings connectionSettings = new ConnectionSettings();
        try {
            connectionSettings.ip1 = Integer.valueOf(textFieldIP1.getText());
            connectionSettings.ip2 = Integer.valueOf(textFieldIP2.getText());
            connectionSettings.ip3 = Integer.valueOf(textFieldIP3.getText());
            connectionSettings.ip4 = Integer.valueOf(textFieldIP4.getText());
            connectionSettings.port = Integer.valueOf(textFieldPort.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Введено некоректні параметри");
            return;
        }
        if ((connectionSettings.ip1 < 0) || (connectionSettings.ip1 > 255) || (connectionSettings.ip2 < 0) || (connectionSettings.ip2 > 255) || (connectionSettings.ip3 < 0) || (connectionSettings.ip3 > 255) || (connectionSettings.ip4 < 0) || (connectionSettings.ip4 > 255) || (connectionSettings.port < 0)) {
            JOptionPane.showMessageDialog(null, "Введено некоректні параметри");
            return;
        }
        connectionSettings.nameDB = textFieldDB.getText();
        connectionSettings.username = textFieldUserName.getText();
        connectionSettings.password = passwordFieldPassword.getText();
        SerializeConnectionSettings.serialize(connectionSettings);
        MainClass.main(null);
    }
}
