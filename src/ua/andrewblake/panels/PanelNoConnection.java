package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;

import javax.swing.*;

/**
 * Created by AndrewBlake on 17.04.2017.
 */
public class PanelNoConnection extends JPanel {
    private JButton buttonExit;
    private JLabel imageMySQL;
    private JLabel labelNoConnection;
    private JButton buttonConnectSettings;

    public PanelNoConnection() {

        this.setSize(400, 400);
        this.setLayout(null);

        imageMySQL = new JLabel();
        this.add(imageMySQL);
        imageMySQL.setBounds(70, 20, 256, 256);
        imageMySQL.setIcon(new ImageIcon("src/ua/andrewblake/resources/mysql.png"));

        labelNoConnection = new JLabel();
        this.add(labelNoConnection);
        labelNoConnection.setBounds(100, 305, 200, 15);
        labelNoConnection.setText("Відсутній зв'язок з Базою Даних MySQL");

        buttonExit = new JButton();
        this.add(buttonExit);
        buttonExit.setBounds(170, 330, 60, 25);
        buttonExit.setText("Вихід");
        buttonExit.addActionListener(this::buttonExitActionPerformed);

        buttonConnectSettings = new JButton();
        this.add(buttonConnectSettings);
        buttonConnectSettings.setBounds(360, 330, 25, 25);
        buttonConnectSettings.setIcon(new ImageIcon("src/ua/andrewblake/resources/Settings.png"));
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
