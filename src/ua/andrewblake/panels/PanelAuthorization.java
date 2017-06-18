package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by AndrewBlake on 17.04.2017.
 */
public class PanelAuthorization extends JPanel {

    private JFrame frame;
    private JButton buttonAuthorization;
    private JLabel imageAccess;
    private JLabel labelAuthorization;
    private JPasswordField passwordFieldAuthorization;
    private ResultSet resultSetForMySQL;
    private Statement statementForMySQL;

    public PanelAuthorization() {
        this.setSize(400, 400);
        this.setLayout(null);

        imageAccess = new JLabel();
        this.add(imageAccess);
        imageAccess.setBounds(70, 0, 258, 252);
        imageAccess.setIcon(new ImageIcon("src/ua/andrewblake/resources/AccessImage_1.jpg"));

        labelAuthorization = new JLabel();
        this.add(labelAuthorization);
        labelAuthorization.setBounds(40, 260, 315, 15);
        labelAuthorization.setText("Для роботи з програмою введіть свій ідентифікатор доступу:");

        passwordFieldAuthorization = new JPasswordField();
        this.add(passwordFieldAuthorization);
        passwordFieldAuthorization.setBounds(100, 280, 200, 20);
        passwordFieldAuthorization.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {passwordFieldAuthorizationKeyPressed(evt);}
        });

        buttonAuthorization = new JButton();
        this.add(buttonAuthorization);
        buttonAuthorization.setBounds(160, 305, 80, 25);
        buttonAuthorization.setText("Увійти");
        buttonAuthorization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorizationActionPerformed(evt);
            }
        });

        this.setVisible(false);

        GlobalSettings.setPanelAuthorization(this);

    }

    private void passwordFieldAuthorizationKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonAuthorizationActionPerformed(null);
        }
    }

    private void buttonAuthorizationActionPerformed(java.awt.event.ActionEvent evt) {
        statementForMySQL = ConnectionToMySQL.getStatementForMySQL();
        GlobalSettings.setUserID(0);
        char[] passwordChars = passwordFieldAuthorization.getPassword();
        String accessID = new String(passwordChars);
        try {
            resultSetForMySQL = statementForMySQL.executeQuery("select count(*) from users;");
            int count = 0;
            while (resultSetForMySQL.next()) {
                count = resultSetForMySQL.getInt(1);
            }
            String[] users = new String[count];
            statementForMySQL = ConnectionToMySQL.getStatementForMySQL();
            resultSetForMySQL = statementForMySQL.executeQuery("select * from users;");
            count = 0;
            L1: while (resultSetForMySQL.next()) {
                users[count] = resultSetForMySQL.getString(2);
                if (accessID.equals(users[count])) {
                    if (resultSetForMySQL.getInt(6) == 1) {
                        JOptionPane.showMessageDialog(null, "Даний ідентифікатор більше не має прав для роботи з програмою. Для уточнення інформації зверніться до Вашого адміністратора.");
                        passwordFieldAuthorization.setText("");
                        return;
                    }
                    GlobalSettings.setUserID(resultSetForMySQL.getInt(1));
                    GlobalSettings.setUserName(resultSetForMySQL.getString(3));
                    GlobalSettings.setUserPosition(resultSetForMySQL.getInt(4));
                    GlobalSettings.setUserIsAdministrator(resultSetForMySQL.getInt(5) == 0 ? false : true);
                    frame = GlobalSettings.getFrame();
                    frame.setSize(800,600);
                    frame.setLocationRelativeTo(null);
                    frame.setMinimumSize(new Dimension(800, 600));
                    PanelMain panelMain = (PanelMain) GlobalSettings.getPanelMain();
                    panelMain.drawUserData();
                    panelMain.setVisible(true);
                    this.setVisible(false);
                    passwordFieldAuthorization.setText("");
                    break L1;
                }
                count++;
            }
            if (GlobalSettings.getUserID() == 0) {
                JOptionPane.showMessageDialog(null, "Введений Вами ідентифікатор доступу відсутній в Базі Даних. Спробуйте ще раз, або зверніться до Вашого адміністратора.");
                passwordFieldAuthorization.setText("");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
        }
    }

}
