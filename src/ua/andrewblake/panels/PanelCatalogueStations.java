package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.CatalogueStationsTableModel;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.util.ArrayList;

public class PanelCatalogueStations extends JPanel {

    private JLabel labelHeader;
    private JLabel labelDist;
    private JComboBox<String> comboBoxDist;
    private JCheckBox checkBoxShowDeleted;
    private JLabel labelImageStation;
    private JScrollPane scrollPaneForTableStations;
    private CatalogueStationsTableModel catalogueStationsTableModel;
    private JTable tableStations;
    private JTextField textFieldSelectedStation;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JTextField textFieldStationName;
    private JComboBox<String> comboBoxDistAdd;
    private JButton buttonOk;
    private JButton buttonDelete;
    private JButton buttonRepair;
    private JButton buttonBack;
    private boolean edit;
    private String[] allStations;
    private String nameBeforeEdit;
    private String shchBeforeEdit;

    public PanelCatalogueStations() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelHeader = new JLabel("Довідник станцій");
        this.add(labelHeader);
        labelHeader.setBounds(350, 10, 90, 15);

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

        labelImageStation = new JLabel(new ImageIcon("src/ua/andrewblake/resources/Station.jpg"));
        this.add(labelImageStation);
        labelImageStation.setBounds(0, 60, 560, 410);

        scrollPaneForTableStations = new JScrollPane();
        this.add(scrollPaneForTableStations);
        scrollPaneForTableStations.setBounds(570, 60, 210, 380);
        scrollPaneForTableStations.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneForTableStations.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        catalogueStationsTableModel = new CatalogueStationsTableModel();
        tableStations = new JTable(catalogueStationsTableModel);
        scrollPaneForTableStations.setViewportView(tableStations);
        tableStations.getTableHeader().setReorderingAllowed(false);
        tableStations.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        tableStations.getColumnModel().getColumn(0).setResizable(false);
        tableStations.getColumnModel().getColumn(0).setPreferredWidth(170);
        tableStations.getColumnModel().getColumn(0).setMaxWidth(170);
        tableStations.getColumnModel().getColumn(1).setResizable(false);
        tableStations.getColumnModel().getColumn(1).setPreferredWidth(40);
        tableStations.getColumnModel().getColumn(1).setMaxWidth(40);
        tableStations.setSelectionBackground(new Color(255, 255, 0));
        tableStations.setSelectionForeground(new Color(0, 0, 0));
        tableStations.setDefaultRenderer(tableStations.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (catalogueStationsTableModel.getValueAt(row, 2).equals("1")) {
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
        tableStations.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableStations.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tableStationMouseClicked(evt); }
        });
        tableStations.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableStationsKeyPressed(evt);
            }
        });

        textFieldSelectedStation = new JTextField();
        this.add(textFieldSelectedStation);
        textFieldSelectedStation.setBounds(570, 450, 210, 20);
        textFieldSelectedStation.setEnabled(false);

        buttonAdd = new JButton("Додати");
        this.add(buttonAdd);
        buttonAdd.setBounds(10, 480, 100, 30);
        buttonAdd.addActionListener(this::buttonAddActionPerformed);

        buttonEdit = new JButton("Редагувати");
        this.add(buttonEdit);
        buttonEdit.setBounds(130, 480, 100, 30);
        buttonEdit.addActionListener(this::buttonEditActionPerformed);

        textFieldStationName = new JTextField();
        this.add(textFieldStationName);
        textFieldStationName.setBounds(120, 485, 200, 20);
        textFieldStationName.setVisible(false);

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
        buttonDelete.setBounds(570, 480, 100, 30);
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

        GlobalSettings.setPanelCatalogueStations(this);

    }

    public void viewOrEdit(boolean edit) {
        this.edit = edit;
    }

    void refresh() {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String query = "LOCK TABLE stations READ;";
            statement.executeQuery(query);
            ResultSet res = statement.executeQuery("SELECT name FROM stations;");
            ArrayList<String> allStationsList = new ArrayList<>(512);
            while (res.next()) {
                allStationsList.add(res.getString(1));
            }
            allStations = new String[allStationsList.size()];
            for (int i = 0; i < allStationsList.size(); i++) {
                allStations[i] = allStationsList.get(i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT name, shch, closed FROM stations");
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
            catalogueStationsTableModel.refresh(stations);
            query = "UNLOCK TABLES;";
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());

        }
        buttonAdd.setVisible(edit);
        buttonDelete.setVisible(edit);
        buttonEdit.setVisible(edit);
        textFieldSelectedStation.setText("");
        textFieldStationName.setVisible(false);
        comboBoxDistAdd.setVisible(false);
        buttonOk.setVisible(false);
        buttonRepair.setVisible(false);
    }

    private void comboBoxDistActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void checkBoxShowDeletedActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void tableStationMouseClicked(java.awt.event.MouseEvent evt) {
        if ((evt.getClickCount() == 0) || (evt.getClickCount() == 1) || (evt.getClickCount() == 2)) {
            textFieldSelectedStation.setText((String) tableStations.getValueAt(tableStations.getSelectedRow(), 0));
            buttonRepair.setVisible(catalogueStationsTableModel.getValueAt(tableStations.getSelectedRow(), 2).equals("1"));
        }
    }

    private void tableStationsKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            tableStations.getSelectionModel().clearSelection();
            buttonDelete.setVisible(false);
            textFieldSelectedStation.setText("");
        }
        if (evt.getKeyCode() == 38) {
            if (tableStations.getSelectedRow() == 0) {
                return;
            } else {
                textFieldSelectedStation.setText((String) tableStations.getValueAt(tableStations.getSelectedRow() - 1, 0));
            }
        }
        if (evt.getKeyCode() == 40) {
            if (tableStations.getSelectedRow() == tableStations.getRowCount() - 1) {
                return;
            } else {
                textFieldSelectedStation.setText((String) tableStations.getValueAt(tableStations.getSelectedRow() + 1, 0));
            }
        }
    }

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (buttonOk.isVisible()) {
            textFieldStationName.setText("");
            textFieldStationName.setVisible(false);
            comboBoxDistAdd.setSelectedIndex(0);
            comboBoxDistAdd.setVisible(false);
            buttonOk.setVisible(false);
            buttonAdd.setText("Додати");
            buttonEdit.setVisible(true);
        } else {
            textFieldStationName.setVisible(true);
            comboBoxDistAdd.setVisible(true);
            buttonOk.setVisible(true);
            buttonOk.setText("Додати");
            buttonAdd.setText("Відміна");
            buttonEdit.setVisible(false);
        }

    }

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldSelectedStation.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не обрано станції");
            return;
        }
        textFieldStationName.setVisible(true);
        comboBoxDistAdd.setVisible(true);
        buttonOk.setVisible(true);
        buttonOk.setText("Редагувати");
        buttonAdd.setText("Відміна");
        buttonEdit.setVisible(false);
        nameBeforeEdit = String.valueOf(tableStations.getValueAt(tableStations.getSelectedRow(), 0));
        shchBeforeEdit = String.valueOf(tableStations.getValueAt(tableStations.getSelectedRow(), 1));
        textFieldStationName.setText(nameBeforeEdit);
        comboBoxDistAdd.setSelectedIndex(Integer.valueOf(shchBeforeEdit) < 7 ? Integer.valueOf(shchBeforeEdit) : Integer.valueOf(shchBeforeEdit) - 1);
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {
        textFieldStationName.getText().replaceAll("'", "\\'");
        if (textFieldStationName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не вказано назву станції");
            return;
        }
        if (comboBoxDistAdd.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не обрано дистанцію сигналізації та зв'язку");
            return;
        }
        for (String s : allStations) {
            if (s.equals(textFieldStationName.getText())) {
                JOptionPane.showMessageDialog(null, "Станція з такою назвою вже існує");
                return;
            }
        }
        if (buttonOk.getText().equals("Додати")) {
            try {
                buttonOk.setVisible(false);
                Connection connection = ConnectionToMySQL.getConnectionToMySQL();
                PreparedStatement preparedStatement = connection.prepareStatement("");
                preparedStatement.execute("LOCK TABLE stations WRITE;");
                preparedStatement = connection.prepareStatement("INSERT INTO stations (name, shch, closed) values (?, ?, 0);");
                preparedStatement.setString(1, textFieldStationName.getText());
                preparedStatement.setInt(2, comboBoxDistAdd.getSelectedIndex());
                preparedStatement.execute();
                preparedStatement.execute("UNLOCK TABLES;");
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
                preparedStatement.execute("LOCK TABLE stations WRITE;");
                preparedStatement = connection.prepareStatement("UPDATE stations SET name = ?, shch = ? WHERE name = ? AND shch = ?;");
                preparedStatement.setString(1, textFieldStationName.getText());
                preparedStatement.setInt(2, comboBoxDistAdd.getSelectedIndex());
                preparedStatement.setString(3, nameBeforeEdit);
                preparedStatement.setInt(4, Integer.valueOf(shchBeforeEdit) < 7 ? Integer.valueOf(shchBeforeEdit) : Integer.valueOf(shchBeforeEdit) - 1);
                preparedStatement.executeUpdate();
                preparedStatement.execute("UNLOCK TABLES;");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                buttonOk.setVisible(true);
            }
        }
        textFieldStationName.setText("");
        textFieldStationName.setVisible(false);
        comboBoxDistAdd.setSelectedIndex(0);
        comboBoxDistAdd.setVisible(false);
        buttonOk.setVisible(false);
        buttonAdd.setText("Додати");
        refresh();
    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldSelectedStation.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не обрано станції");
            return;
        }
        try {
            buttonDelete.setVisible(false);
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.execute("LOCK TABLE stations WRITE;");
            preparedStatement = connection.prepareStatement("UPDATE stations SET closed = 1 WHERE name = ?;");
            preparedStatement.setString(1, textFieldSelectedStation.getText());
            preparedStatement.executeUpdate();
            preparedStatement.execute("UNLOCK TABLES;");
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
            preparedStatement.execute("LOCK TABLE stations WRITE;");
            preparedStatement = connection.prepareStatement("UPDATE stations SET closed = 0 WHERE name = ?;");
            preparedStatement.setString(1, textFieldSelectedStation.getText());
            preparedStatement.executeUpdate();
            preparedStatement.execute("UNLOCK TABLES;");
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
