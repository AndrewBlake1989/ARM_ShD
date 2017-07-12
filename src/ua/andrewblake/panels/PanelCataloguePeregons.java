package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.CataloguePeregonsTableModel;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.util.ArrayList;

public class PanelCataloguePeregons extends JPanel {

    private JLabel labelHeader;
    private JLabel labelDist;
    private JComboBox<String> comboBoxDist;
    private JCheckBox checkBoxShowDeleted;
    private JLabel labelImagePeregon;
    private JScrollPane scrollPaneForTablePeregons;
    private CataloguePeregonsTableModel cataloguePeregonsTableModel;
    private JTable tablePeregons;
    private JTextField textFieldSelectedPeregon;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JTextField textFieldPeregonName;
    private JComboBox<String> comboBoxDistAdd;
    private JButton buttonOk;
    private JButton buttonDelete;
    private JButton buttonRepair;
    private JButton buttonBack;
    private boolean edit;
    private String[] allPeregons;
    private String nameBeforeEdit;
    private String shchBeforeEdit;

    public PanelCataloguePeregons() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelHeader = new JLabel("Довідник перегонів");
        this.add(labelHeader);
        labelHeader.setBounds(340, 10, 110, 15);

        labelDist = new JLabel("Дистанція сигналізації та зв'язку");
        this.add(labelDist);
        labelDist.setBounds(10, 33, 165, 15);

        String[] temp = StringModels.getShch();
        temp[0] = "Усі";
        comboBoxDist = new JComboBox<>(temp);
        this.add(comboBoxDist);
        comboBoxDist.setBounds(180, 30, 60, 20);
        comboBoxDist.addActionListener(this::comboBoxDistActionPerformed);

        checkBoxShowDeleted = new JCheckBox("Показати видалені", false);
        this.add(checkBoxShowDeleted);
        checkBoxShowDeleted.setBounds(280, 30, 130, 25);
        checkBoxShowDeleted.addActionListener(this::checkBoxShowDeletedActionPerformed);

        labelImagePeregon = new JLabel(new ImageIcon("src/ua/andrewblake/resources/Peregin.jpg"));
        this.add(labelImagePeregon);
        labelImagePeregon.setBounds(0, 60, 520, 410);

        scrollPaneForTablePeregons = new JScrollPane();
        this.add(scrollPaneForTablePeregons);
        scrollPaneForTablePeregons.setBounds(530, 60, 250, 380);
        scrollPaneForTablePeregons.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneForTablePeregons.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        cataloguePeregonsTableModel = new CataloguePeregonsTableModel();
        tablePeregons = new JTable(cataloguePeregonsTableModel);
        scrollPaneForTablePeregons.setViewportView(tablePeregons);
        tablePeregons.getTableHeader().setReorderingAllowed(false);
        tablePeregons.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        tablePeregons.getColumnModel().getColumn(0).setResizable(false);
        tablePeregons.getColumnModel().getColumn(0).setPreferredWidth(210);
        tablePeregons.getColumnModel().getColumn(0).setMaxWidth(210);
        tablePeregons.getColumnModel().getColumn(1).setResizable(false);
        tablePeregons.getColumnModel().getColumn(1).setPreferredWidth(40);
        tablePeregons.getColumnModel().getColumn(1).setMaxWidth(40);
        tablePeregons.setSelectionBackground(new Color(255, 255, 0));
        tablePeregons.setSelectionForeground(new Color(0, 0, 0));
        tablePeregons.setDefaultRenderer(tablePeregons.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (cataloguePeregonsTableModel.getValueAt(row, 2).equals("1")) {
                    setBackground(Color.PINK);
                } else {
                    setBackground(Color.WHITE);
                }
                if (column == 0) {
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
        tablePeregons.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePeregons.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tableStationMouseClicked(evt); }
        });
        tablePeregons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableStationsKeyPressed(evt);
            }
        });

        textFieldSelectedPeregon = new JTextField();
        this.add(textFieldSelectedPeregon);
        textFieldSelectedPeregon.setBounds(530, 450, 250, 20);
        textFieldSelectedPeregon.setEnabled(false);

        buttonAdd = new JButton("Додати");
        this.add(buttonAdd);
        buttonAdd.setBounds(10, 480, 100, 30);
        buttonAdd.addActionListener(this::buttonAddActionPerformed);

        buttonEdit = new JButton("Редагувати");
        this.add(buttonEdit);
        buttonEdit.setBounds(130, 480, 100, 30);
        buttonEdit.addActionListener(this::buttonEditActionPerformed);

        textFieldPeregonName = new JTextField();
        this.add(textFieldPeregonName);
        textFieldPeregonName.setBounds(120, 485, 200, 20);
        textFieldPeregonName.setVisible(false);

        comboBoxDistAdd = new JComboBox<>(StringModels.getShch());
        this.add(comboBoxDistAdd);
        comboBoxDistAdd.setBounds(330, 485, 60, 20);
        comboBoxDistAdd.setVisible(false);

        buttonOk = new JButton("Додати");
        this.add(buttonOk);
        buttonOk.setBounds(400, 480, 100, 30);
        buttonOk.addActionListener(this::buttonOkActionPerformed);
        buttonOk.setVisible(false);

        buttonDelete = new JButton("Видалити");
        this.add(buttonDelete);
        buttonDelete.setBounds(530, 480, 100, 30);
        buttonDelete.addActionListener(this::buttonDeleteActionPerformed);
        buttonDelete.setVisible(false);

        buttonRepair = new JButton("Відновити");
        this.add(buttonRepair);
        buttonRepair.setBounds(680, 480, 100, 30);
        buttonRepair.addActionListener(this::buttonRepairActionPerformed);
        buttonRepair.setVisible(true);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelCataloguePeregons(this);

    }

    void viewOrEdit(boolean edit) {
        this.edit = edit;
    }

    void refresh() {
        comboBoxDist.setEnabled(true);
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String query = "LOCK TABLE peregons READ;";
            statement.executeQuery(query);
            ResultSet res = statement.executeQuery("SELECT name FROM peregons;");
            ArrayList<String> allPeregonsList = new ArrayList<>(512);
            while (res.next()) {
                allPeregonsList.add(res.getString(1));
            }
            allPeregons = new String[allPeregonsList.size()];
            for (int i = 0; i < allPeregonsList.size(); i++) {
                allPeregons[i] = allPeregonsList.get(i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT name, shch, closed FROM peregons");
            stringBuilder.append(comboBoxDist.getSelectedIndex() == 0 ? "" : " WHERE shch = ".concat(String.valueOf(comboBoxDist.getSelectedIndex())).concat(" "));
            stringBuilder.append((!checkBoxShowDeleted.isSelected() && comboBoxDist.getSelectedIndex() == 0) ? " WHERE closed = 0" : "");
            stringBuilder.append((!checkBoxShowDeleted.isSelected() && comboBoxDist.getSelectedIndex() != 0) ?  "AND closed = 0" : "");
            stringBuilder.append(" ORDER BY shch, name");
            stringBuilder.append(";");
            res = statement.executeQuery(stringBuilder.toString());
            ArrayList<String> stationsList = new ArrayList<>(512);
            ArrayList<String> shchList = new ArrayList<>(512);
            ArrayList<String> closedList = new ArrayList<>(512);
            while (res.next()) {
                stationsList.add(res.getString(1));
                shchList.add(res.getString(2));
                closedList.add(String.valueOf(res.getByte(3)));
            }
            String[][] stations = new String[stationsList.size()][3];
            for (int i = 0; i < stations.length; i++) {
                stations[i][0] = stationsList.get(i);
                stations[i][1] = shchList.get(i);
                stations[i][2] = closedList.get(i);
            }
            cataloguePeregonsTableModel.refresh(stations);
            query = "UNLOCK TABLES;";
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());

        }
        buttonAdd.setVisible(edit);
        buttonDelete.setVisible(edit);
        buttonEdit.setVisible(edit);
        textFieldSelectedPeregon.setText("");
        textFieldPeregonName.setVisible(false);
        comboBoxDistAdd.setVisible(false);
        buttonOk.setVisible(false);
        buttonRepair.setVisible(false);
        checkBoxShowDeleted.setVisible(true);
        whatShCh();
    }

    private void whatShCh() {
        if ((GlobalSettings.getUserPosition() > 3) && (GlobalSettings.getUserPosition() < 16)) {
            comboBoxDist.setSelectedIndex(GlobalSettings.getUserPosition() - 3);
            comboBoxDist.setEnabled(false);
        }
    }

    private void comboBoxDistActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void checkBoxShowDeletedActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void tableStationMouseClicked(java.awt.event.MouseEvent evt) {
        if ((evt.getClickCount() == 0) || (evt.getClickCount() == 1) || (evt.getClickCount() == 2)) {
            textFieldSelectedPeregon.setText((String) tablePeregons.getValueAt(tablePeregons.getSelectedRow(), 0));
            buttonRepair.setVisible(cataloguePeregonsTableModel.getValueAt(tablePeregons.getSelectedRow(), 2).equals("1"));
        }
    }

    private void tableStationsKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            tablePeregons.getSelectionModel().clearSelection();
            buttonDelete.setVisible(false);
            textFieldSelectedPeregon.setText("");
        }
        if (evt.getKeyCode() == 38) {
            if (tablePeregons.getSelectedRow() == 0) {
                return;
            } else {
                textFieldSelectedPeregon.setText((String) tablePeregons.getValueAt(tablePeregons.getSelectedRow() - 1, 0));
            }
        }
        if (evt.getKeyCode() == 40) {
            if (tablePeregons.getSelectedRow() == tablePeregons.getRowCount() - 1) {
                return;
            } else {
                textFieldSelectedPeregon.setText((String) tablePeregons.getValueAt(tablePeregons.getSelectedRow() + 1, 0));
            }
        }
    }

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (buttonOk.isVisible()) {
            textFieldPeregonName.setText("");
            textFieldPeregonName.setVisible(false);
            comboBoxDistAdd.setSelectedIndex(0);
            comboBoxDistAdd.setVisible(false);
            buttonOk.setVisible(false);
            buttonAdd.setText("Додати");
            checkBoxShowDeleted.setVisible(true);
            buttonEdit.setVisible(true);
        } else {
            textFieldPeregonName.setVisible(true);
            comboBoxDistAdd.setVisible(true);
            buttonOk.setVisible(true);
            buttonOk.setText("Додати");
            buttonAdd.setText("Відміна");
            buttonEdit.setVisible(false);
            checkBoxShowDeleted.setVisible(false);
        }

    }

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldSelectedPeregon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не обрано перегону");
            return;
        }
        textFieldPeregonName.setVisible(true);
        comboBoxDistAdd.setVisible(true);
        buttonOk.setVisible(true);
        buttonOk.setText("Редагувати");
        buttonAdd.setText("Відміна");
        buttonEdit.setVisible(false);
        checkBoxShowDeleted.setVisible(false);
        nameBeforeEdit = String.valueOf(tablePeregons.getValueAt(tablePeregons.getSelectedRow(), 0));
        shchBeforeEdit = String.valueOf(tablePeregons.getValueAt(tablePeregons.getSelectedRow(), 1));
        textFieldPeregonName.setText(nameBeforeEdit);
        comboBoxDistAdd.setSelectedIndex(Integer.valueOf(shchBeforeEdit) < 7 ? Integer.valueOf(shchBeforeEdit) : Integer.valueOf(shchBeforeEdit) - 1);
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldPeregonName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не вказано назву перегону");
            return;
        }
        if (comboBoxDistAdd.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не обрано дистанцію сигналізації та зв'язку");
            return;
        }
        for (String s : allPeregons) {
            if (s.equals(textFieldPeregonName.getText())) {
                JOptionPane.showMessageDialog(null, "Такий перегін вже існує");
                return;
            }
        }
        if (buttonOk.getText().equals("Додати")) {
            try {
                buttonOk.setVisible(false);
                Connection connection = ConnectionToMySQL.getConnectionToMySQL();
                PreparedStatement preparedStatement = connection.prepareStatement("");
                preparedStatement.execute("LOCK TABLE peregons WRITE;");
                preparedStatement = connection.prepareStatement("INSERT INTO peregons (name, shch, closed) values (?, ?, 0);");
                preparedStatement.setString(1, textFieldPeregonName.getText());
                preparedStatement.setInt(2, comboBoxDistAdd.getSelectedIndex());
                preparedStatement.execute();
                preparedStatement.execute("UNLOCK TABLES;");
                StringModels.resetPeregons();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                buttonOk.setVisible(true);
            }
        } else {
            try {
                buttonOk.setVisible(false);
                Connection connection = ConnectionToMySQL.getConnectionToMySQL();
                PreparedStatement preparedStatement = connection.prepareStatement("");
                preparedStatement.execute("LOCK TABLE peregons WRITE;");
                preparedStatement = connection.prepareStatement("UPDATE peregons SET name = ?, shch = ? WHERE name = ? AND shch = ?;");
                preparedStatement.setString(1, textFieldPeregonName.getText());
                preparedStatement.setInt(2, comboBoxDistAdd.getSelectedIndex());
                preparedStatement.setString(3, nameBeforeEdit);
                preparedStatement.setInt(4, Integer.valueOf(shchBeforeEdit) < 7 ? Integer.valueOf(shchBeforeEdit) : Integer.valueOf(shchBeforeEdit) - 1);
                preparedStatement.executeUpdate();
                preparedStatement.execute("UNLOCK TABLES;");
                StringModels.resetPeregons();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                buttonOk.setVisible(true);
            }
        }
        textFieldPeregonName.setText("");
        textFieldPeregonName.setVisible(false);
        comboBoxDistAdd.setSelectedIndex(0);
        comboBoxDistAdd.setVisible(false);
        buttonOk.setVisible(false);
        buttonAdd.setText("Додати");
        refresh();
    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldSelectedPeregon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не обрано перегону");
            return;
        }
        try {
            buttonDelete.setVisible(false);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.execute("LOCK TABLE peregons WRITE;");
            preparedStatement = connection.prepareStatement("UPDATE peregons SET closed = 1 WHERE name = ?;");
            preparedStatement.setString(1, textFieldSelectedPeregon.getText());
            preparedStatement.executeUpdate();
            preparedStatement.execute("UNLOCK TABLES;");
            StringModels.resetPeregons();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            buttonDelete.setVisible(true);
        }
        refresh();
    }

    private void buttonRepairActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            buttonRepair.setVisible(false);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.execute("LOCK TABLE peregons WRITE;");
            preparedStatement = connection.prepareStatement("UPDATE peregons SET closed = 0 WHERE name = ?;");
            preparedStatement.setString(1, textFieldSelectedPeregon.getText());
            preparedStatement.executeUpdate();
            preparedStatement.execute("UNLOCK TABLES;");
            StringModels.resetPeregons();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            buttonRepair.setVisible(true);
        }
        refresh();
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelViewOrEditCatalogues().setVisible(true);
    }

}
