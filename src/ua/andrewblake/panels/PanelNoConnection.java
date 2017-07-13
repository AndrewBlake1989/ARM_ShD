package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;

public class PanelNoConnection extends JPanel {
    private JButton buttonExit;
    private JLabel imageMySQL;
    private JLabel labelNoConnection;
    private JButton buttonConnectSettings;

    public PanelNoConnection() {

        this.setSize(400, 400);
        this.setLayout(null);

        imageMySQL = new JLabel(new ImageIcon("src/ua/andrewblake/resources/mysql.png"));
        this.add(imageMySQL);
        imageMySQL.setBounds(70, 20, 256, 256);

        labelNoConnection = new JLabel("Відсутній зв'язок з Базою Даних MySQL");
        this.add(labelNoConnection);
        labelNoConnection.setBounds(100, 305, 200, 15);

        buttonExit = new JButton("Вихід");
        this.add(buttonExit);
        buttonExit.setBounds(170, 330, 60, 25);
        buttonExit.addActionListener(this::buttonExitActionPerformed);

        buttonConnectSettings = new JButton(new ImageIcon("src/ua/andrewblake/resources/Settings.png"));
        this.add(buttonConnectSettings);
        buttonConnectSettings.setBounds(360, 330, 25, 25);
        buttonConnectSettings.setToolTipText("Змінити налаштування підключення");
        buttonConnectSettings.addActionListener(this::buttonConnectSettingsActionPerformed);

        this.setVisible(false);

    }

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void buttonConnectSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelConnectionSettings().setVisible(true);
        GlobalSettings.getPanelConnectionSettings().fillParams();
    }
}
