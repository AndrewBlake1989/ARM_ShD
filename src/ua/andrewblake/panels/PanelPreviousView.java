package ua.andrewblake.panels;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.SerializeToBlob;
import ua.andrewblake.utils.SkinUtil;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class PanelPreviousView extends JPanel {

    private JLabel label;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JButton buttonBack;
    private JButton buttonRegister;

    public PanelPreviousView() {

        this.setSize(800, 600);
        this.setLayout(null);

        label = new JLabel("Попередній перегляд (спрощений вигляд):");
        this.add(label);
        label.setBounds(285, 10, 220, 15);

        scrollPane = new JScrollPane();
        this.add(scrollPane);
        scrollPane.setBounds(10, 30, 770, 480);

        textArea = new JTextArea();
        this.add(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setName("textArea");
        textArea.setFont(new java.awt.Font("Tahoma", 0, 11));
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 100, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        buttonRegister = new JButton("Зберегти");
        this.add(buttonRegister);
        buttonRegister.setBounds(690, 530, 100, 30);
        buttonRegister.setIcon(new ImageIcon("src/ua/andrewblake/resources/Save.png"));
        buttonRegister.addActionListener(this::buttonRegisterActionPerformed);


        this.setVisible(false);

        GlobalSettings.setPanelPreviousView(this);

    }

    public void showSimpleRecord(String[] simple, String[] createAndEditUsers) {
        textArea.setText("");
        for (String s : simple) {
            textArea.append(s.concat("\n"));
        }
        textArea.append("\n");
        if ((createAndEditUsers != null) && (createAndEditUsers.length > 0)) {
            for (String s : createAndEditUsers) {
                textArea.append(s.concat("\n"));
            }
        }
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelIntroductionError3().setVisible(true);
    }

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        buttonRegister.setVisible(false);
        try {
            Stat stat = GlobalSettings.getPanelIntroductionError3().getParams(null);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String query = "LOCK TABLES records WRITE, positions WRITE;";
            statement.executeQuery(query);
            ResultSet res;
            boolean created = stat.numberOfRecord == 0;
            if (stat.numberOfRecord == 0) {
                query = "select max(number_of_record) from `records` where date >= '".concat(String.valueOf(stat.year)).concat("-").concat(stat.month < 10 ? "0".concat(String.valueOf(stat.month)) : String.valueOf(stat.month)).concat("-01' and date < '").concat(stat.month < 12 ? String.valueOf(stat.year) : String.valueOf(stat.year + 1)).concat("-").concat(stat.month < 12 ? (stat.month + 1 < 10 ? "0".concat(String.valueOf(stat.month + 1)) : String.valueOf(stat.month + 1)) : "01").concat("-01';");
                res = statement.executeQuery(query);
                while (res.next()) {
                    stat.numberOfRecord = res.getInt(1) + 1;
                    stat.simpleRecord[0] = new String("№ несправності: ".concat(String.valueOf(stat.numberOfRecord)).concat(";"));
                }
            }
            String[] tempCreateAndEditUsers;
            if (stat.createAndEditUsers == null) {
                tempCreateAndEditUsers = new String[1];
            } else {
                tempCreateAndEditUsers = new String[stat.createAndEditUsers.length + 1];
                for (int i = 0; i < stat.createAndEditUsers.length; i++) {
                    tempCreateAndEditUsers[i] = stat.createAndEditUsers[i];
                }
            }
            res = statement.executeQuery("select position_full, position_short from positions where id = " + GlobalSettings.getUserID() + ";");
            while (res.next()) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                tempCreateAndEditUsers[tempCreateAndEditUsers.length - 1] = (created ? "Створено: " : "Редаговано: ").concat(formatForDateNow.format(date).toString()).concat("\t\t").concat("Користувач: ").concat(res.getString(1)).concat(" (").concat(res.getString(2)).concat(") ").concat(GlobalSettings.getUserName()).concat(";");
            }
            stat.createAndEditUsers = tempCreateAndEditUsers;
            SerializeToBlob.serialize(stat);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into `records` (date, number_of_record, dist, department, first_create, edited, deleted, file_record) values (?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, String.valueOf(stat.year).concat("-").concat(stat.month < 10 ? "0".concat(String.valueOf(stat.month)) : String.valueOf(stat.month)).concat("-").concat(stat.day<10 ? "0".concat(String.valueOf(stat.day)) : String.valueOf(stat.day)));
            preparedStatement.setInt(2, stat.numberOfRecord);
            preparedStatement.setByte(3, (byte) stat.dist);
            preparedStatement.setByte(4, (byte) stat.department);
            preparedStatement.setByte(5, (byte) (created ? 1 : 0));
            preparedStatement.setByte(6, (byte) (created ? 0 : 1));
            preparedStatement.setByte(7, (byte) 0);
            preparedStatement.setBlob(8, new FileInputStream("src/ua/andrewblake/save/SaveStatToBlob.svf"));
            preparedStatement.execute();
            statement.executeQuery("UNLOCK TABLES;");
            GlobalSettings.setCurrentStat(stat);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            return;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою.");
            return;
        } finally {
            buttonRegister.setVisible(true);
        }
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }
}
