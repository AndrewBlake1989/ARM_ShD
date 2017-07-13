package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.CatalogueUsersTableModel;
import ua.andrewblake.utils.ConnectionToMySQL;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.util.ArrayList;

public class PanelCatalogueUsers extends JPanel {

    private JLabel labelHeader;
    private JScrollPane scrollPaneForTableUsers;
    private CatalogueUsersTableModel catalogueUsersTableModel;
    private JTable tableUsers;
    private JTextField textFieldSelectedUser;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JPanel panelNewOrEditUser;
    private JLabel labelId;
    private JTextField textFieldId;
    private JLabel labelPosition;
    private JComboBox<String> comboBoxPosition;
    private JCheckBox checkBoxAdministrator;
    private JLabel labelName;
    private JTextField textFieldName;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JButton buttonBack;
    private String login;
    private boolean edit;
    private String[] allLogins;

    public PanelCatalogueUsers() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelHeader = new JLabel("Довідник користувачів");
        this.add(labelHeader);
        labelHeader.setBounds(340, 10, 120, 15);

        scrollPaneForTableUsers = new JScrollPane();
        this.add(scrollPaneForTableUsers);
        scrollPaneForTableUsers.setBounds(10, 40, 620, 300);
        scrollPaneForTableUsers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneForTableUsers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        catalogueUsersTableModel = new CatalogueUsersTableModel();
        tableUsers = new JTable(catalogueUsersTableModel);
        scrollPaneForTableUsers.setViewportView(tableUsers);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        tableUsers.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        tableUsers.getColumnModel().getColumn(0).setResizable(false);
        tableUsers.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableUsers.getColumnModel().getColumn(0).setMaxWidth(100);
        tableUsers.getColumnModel().getColumn(1).setResizable(false);
        tableUsers.getColumnModel().getColumn(1).setPreferredWidth(350);
        tableUsers.getColumnModel().getColumn(1).setMaxWidth(350);
        tableUsers.getColumnModel().getColumn(2).setResizable(false);
        tableUsers.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableUsers.getColumnModel().getColumn(2).setMaxWidth(50);
        tableUsers.getColumnModel().getColumn(3).setResizable(false);
        tableUsers.getColumnModel().getColumn(3).setPreferredWidth(120);
        tableUsers.getColumnModel().getColumn(3).setMaxWidth(120);
        tableUsers.setSelectionBackground(new Color(255, 255, 0));
        tableUsers.setSelectionForeground(new Color(0, 0, 0));
        tableUsers.setDefaultRenderer(tableUsers.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if ((column == 0) || (column == 1)) {
                    super.setHorizontalAlignment(SwingConstants.LEFT);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                } else {
                    super.setHorizontalAlignment(SwingConstants.CENTER);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                }

            }
        });
        tableUsers.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableUsers.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tableUsersMouseClicked(evt); }
        });
        tableUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableUsersKeyPressed(evt);
            }
        });

        textFieldSelectedUser = new JTextField();
        this.add(textFieldSelectedUser);
        textFieldSelectedUser.setBounds(10, 350, 620, 20);
        textFieldSelectedUser.setEnabled(false);

        buttonAdd = new JButton("Додати");
        this.add(buttonAdd);
        buttonAdd.setBounds(640, 60, 140, 25);
        buttonAdd.addActionListener(this::buttonAddActionPerformed);

        buttonEdit = new JButton("Редагувати");
        this.add(buttonEdit);
        buttonEdit.setBounds(640, 100, 140, 25);
        buttonEdit.addActionListener(this::buttonEditActionPerformed);

        buttonDelete = new JButton("Видалити");
        this.add(buttonDelete);
        buttonDelete.setBounds(640, 140, 140, 25);
        buttonDelete.addActionListener(this::buttonDeleteActionPerformed);

        panelNewOrEditUser = new JPanel(null);
        this.add(panelNewOrEditUser);
        panelNewOrEditUser.setBounds(10, 390, 620, 120);
        panelNewOrEditUser.setVisible(false);

        labelId = new JLabel("Ідентифікатор (Логін):");
        panelNewOrEditUser.add(labelId);
        labelId.setBounds(10, 23, 120, 15);

        textFieldId = new JTextField();
        panelNewOrEditUser.add(textFieldId);
        textFieldId.setBounds(130, 20, 100, 20);

        labelPosition = new JLabel("Посада:");
        panelNewOrEditUser.add(labelPosition);
        labelPosition.setBounds(290, 23, 45, 15);
            String[] positions = {"-"};
            try {
                Connection connection = ConnectionToMySQL.getConnectionToMySQL();
                Statement statement = connection.createStatement();
                statement.executeQuery("LOCK TABLE positions READ;");
                ResultSet resultSet = statement.executeQuery("SELECT position_short FROM positions WHERE id > 1 ORDER BY id");
                ArrayList<String> positionsList = new ArrayList<>();
                while (resultSet.next()) {
                    positionsList.add(resultSet.getString(1));
                }
                positions = new String[positionsList.size()];
                for (int i = 0; i < positions.length; i++) {
                    positions[i] = positionsList.get(i);
                }
                statement.executeQuery("UNLOCK TABLES;");
            } catch (SQLException e) {
                if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                    JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
                } else {
                    JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
                }
            }
        comboBoxPosition = new JComboBox<>(positions);
        panelNewOrEditUser.add(comboBoxPosition);
        comboBoxPosition.setBounds(340, 20, 70, 20);

        checkBoxAdministrator = new JCheckBox("Права Адміністратора", false);
        panelNewOrEditUser.add(checkBoxAdministrator);
        checkBoxAdministrator.setBounds(470, 20, 140, 25);

        labelName = new JLabel("П.І.Б.:");
        panelNewOrEditUser.add(labelName);
        labelName.setBounds(10, 53, 35, 15);

        textFieldName = new JTextField();
        panelNewOrEditUser.add(textFieldName);
        textFieldName.setBounds(50, 50, 350, 20);

        buttonOk = new JButton("Ok");
        panelNewOrEditUser.add(buttonOk);
        buttonOk.setBounds(200, 80, 80, 25);
        buttonOk.addActionListener(this::buttonOkActionPerformed);

        buttonCancel = new JButton("Відміна");
        panelNewOrEditUser.add(buttonCancel);
        buttonCancel.setBounds(340, 80, 80, 25);
        buttonCancel.addActionListener(this::buttonCancelActionPerformed);

        buttonBack = new JButton("Назад", new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelCatalogueUsers(this);

    }

    void refresh() {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLES users READ, positions READ;");
            ResultSet resultSet = statement.executeQuery("SELECT access_id FROM users");
            ArrayList<String> allLoginsList = new ArrayList<>();
            while (resultSet.next()) {
                allLoginsList.add(resultSet.getString(1));
            }
            allLogins = new String[allLoginsList.size()];
            for (int i = 0; i < allLogins.length; i++) {
                allLogins[i] = allLoginsList.get(i);
            }
            resultSet = statement.executeQuery("SELECT users.access_id, users.name, positions.position_short, users.administrator FROM users, positions WHERE users.position = positions.id AND users.deleted = 0 AND users.id > 1;");
            ArrayList<String[]> usersList = new ArrayList<>();
            while (resultSet.next()) {
                String[] temp = new String[4];
                temp[0] = resultSet.getString(1);
                temp[1] = resultSet.getString(2);
                temp[2] = resultSet.getString(3);
                temp[3] = resultSet.getByte(4) == 0 ? "Ні" : "Так";
                usersList.add(temp);
            }
            String[][] users = new String[usersList.size()][4];
            for (int i = 0; i < users.length; i++) {
                users[i] = usersList.get(i);
            }
            catalogueUsersTableModel.refresh(users);
            this.updateUI();
            statement.executeQuery("UNLOCK TABLES;");
        } catch (SQLException e) {
            if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
            } else {
                JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            }
        }
        textFieldSelectedUser.setText("");
        login = null;
    }

    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {
        if ((evt.getClickCount() == 0) || (evt.getClickCount() == 1) || (evt.getClickCount() == 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Логін: ");
            stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0));
            stringBuilder.append("\t");
            stringBuilder.append("П.І.Б.: ");
            stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1));
            stringBuilder.append("\t");
            stringBuilder.append("Посада: ");
            stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2));
            stringBuilder.append("\t");
            stringBuilder.append("Права Адміністратора: ");
            stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3));
            textFieldSelectedUser.setText(stringBuilder.toString());
            login = (String) tableUsers.getValueAt(tableUsers.getSelectedRow(), 0);
        }
    }

    private void tableUsersKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            tableUsers.clearSelection();
            textFieldSelectedUser.setText("");
            login = null;
        }
        if (evt.getKeyCode() == 38) {
            if (tableUsers.getSelectedRow() == 0) {
                return;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Логін: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() - 1, 0));
                stringBuilder.append("\t");
                stringBuilder.append("П.І.Б.: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() - 1, 1));
                stringBuilder.append("\t");
                stringBuilder.append("Посада: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() - 1, 2));
                stringBuilder.append("\t");
                stringBuilder.append("Права Адміністратора: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() - 1, 3));
                textFieldSelectedUser.setText(stringBuilder.toString());
                login = (String) tableUsers.getValueAt(tableUsers.getSelectedRow() - 1, 0);
            }
        }
        if (evt.getKeyCode() == 40) {
            if (tableUsers.getSelectedRow() == tableUsers.getRowCount() - 1) {
                return;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Логін: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() + 1, 0));
                stringBuilder.append("\t");
                stringBuilder.append("П.І.Б.: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() + 1, 1));
                stringBuilder.append("\t");
                stringBuilder.append("Посада: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() + 1, 2));
                stringBuilder.append("\t");
                stringBuilder.append("Права Адміністратора: ");
                stringBuilder.append(tableUsers.getValueAt(tableUsers.getSelectedRow() + 1, 3));
                textFieldSelectedUser.setText(stringBuilder.toString());
                login = (String) tableUsers.getValueAt(tableUsers.getSelectedRow() + 1, 0);
            }
        }
    }

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {
        panelNewOrEditUser.setVisible(true);
        panelNewOrEditUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Дані нового користувача"));
        textFieldId.setText("");
        textFieldName.setText("");
        comboBoxPosition.setSelectedIndex(0);
        checkBoxAdministrator.setSelected(false);
        edit = false;
        buttonAdd.setVisible(false);
        buttonEdit.setVisible(false);
        buttonDelete.setVisible(false);
    }

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (login == null) {
            JOptionPane.showMessageDialog(null, "Не обрано жодного запису користувача");
            return;
        }
        panelNewOrEditUser.setVisible(true);
        panelNewOrEditUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Редагувати дані користувача"));
        textFieldId.setText(login);
        textFieldName.setText((String) tableUsers.getValueAt(tableUsers.getSelectedRow(), 1));
        comboBoxPosition.setSelectedItem(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2));
        checkBoxAdministrator.setSelected(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3).equals("Так"));
        edit = true;
        tableUsers.setEnabled(false);
        buttonAdd.setVisible(false);
        buttonEdit.setVisible(false);
        buttonDelete.setVisible(false);
    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (login == null) {
            JOptionPane.showMessageDialog(null, "Не обрано жодного запису користувача");
            return;
        }
        try {
            buttonDelete.setVisible(false);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.execute("LOCK TABLE users WRITE;");
            preparedStatement = connection.prepareStatement("UPDATE users SET deleted = 1 WHERE access_id = ?;");
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
            preparedStatement.execute("UNLOCK TABLES;");
        } catch (SQLException e) {
            if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
            } else {
                JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            }
        } finally {
            buttonDelete.setVisible(true);
        }
        refresh();
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Не заповнено поле ідентифікатора доступу");
            return;
        }
        if (!edit) {
            for (String s : allLogins) {
                if (s.equals(textFieldId.getText())) {
                    JOptionPane.showMessageDialog(null, "Заповнений Вами ідентифікатор доступу вже існує");
                    return;
                }
            }
        }
        if (textFieldId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Не заповнено поле \"П.І.Б.\"");
            return;
        }
        try {
            buttonOk.setVisible(false);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.execute("LOCK TABLE users WRITE, positions READ;");
            String position = "";
            preparedStatement = connection.prepareStatement("select id from positions where position_short = ?;");
            preparedStatement.setString(1, (String) comboBoxPosition.getSelectedItem());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                position = resultSet.getString(1);
            }
            if (edit) {
                String id = "";
                preparedStatement = connection.prepareStatement("select id from users where access_id = ?;");
                preparedStatement.setString(1, login);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getString(1);
                }
                preparedStatement = connection.prepareStatement("UPDATE users SET access_id = ?, name = ?, position = ?, administrator = ? WHERE id = ?;");
                preparedStatement.setString(1, textFieldId.getText());
                preparedStatement.setString(2, textFieldName.getText());
                preparedStatement.setInt(3, Integer.parseInt(position));
                preparedStatement.setInt(4, checkBoxAdministrator.isSelected() ? 1 : 0);
                preparedStatement.setInt(5, Integer.parseInt(id));
                preparedStatement.executeUpdate();
            } else {
                preparedStatement = connection.prepareStatement("INSERT INTO users (access_id, name, position, administrator) values (?, ?, ?, ?);");
                preparedStatement.setString(1, textFieldId.getText());
                preparedStatement.setString(2, textFieldName.getText());
                preparedStatement.setInt(3, Integer.parseInt(position));
                preparedStatement.setInt(4, checkBoxAdministrator.isSelected() ? 1 : 0);
                preparedStatement.execute();
            }
            preparedStatement.execute("UNLOCK TABLES;");
        } catch (SQLException e) {
            if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
            } else {
                JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            }
        } finally {
            buttonOk.setVisible(true);
        }
        panelNewOrEditUser.setVisible(false);
        tableUsers.setEnabled(true);
        buttonAdd.setVisible(true);
        buttonEdit.setVisible(true);
        buttonDelete.setVisible(true);
        refresh();
    }

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        panelNewOrEditUser.setVisible(false);
        tableUsers.setEnabled(true);
        buttonAdd.setVisible(true);
        buttonEdit.setVisible(true);
        buttonDelete.setVisible(true);
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelViewOrEditCatalogues().setVisible(true);
    }

}
