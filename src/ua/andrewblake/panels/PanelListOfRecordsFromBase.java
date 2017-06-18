package ua.andrewblake.panels;

import com.sun.glass.ui.View;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.ListOfRecordsTableModel;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.DateTime;
import ua.andrewblake.utils.SerializeToBlob;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class PanelListOfRecordsFromBase extends JPanel {

    private JLabel labelFilter;
    private JLabel labelPeriod;
    private JLabel labelFromYear;
//    private JTextField textFieldFromYear;
    private JComboBox<String> comboBoxFromYear;
    private JLabel labelFromMonth;
    private JComboBox<String> comboBoxFromMonth;
    private JLabel labelHyphen;
    private JLabel labelToYear;
    private JComboBox<String> comboBoxToYear;
//    private JTextField textFieldToYear;
    private JLabel labelToMonth;
    private JComboBox<String> comboBoxToMonth;
    private JLabel labelDistance;
    private JComboBox<String> comboBoxDistance;
    private JLabel labelDepartment;
    private JComboBox<String> comboBoxDepartment;
    private JCheckBox checkBoxShowDeleted;
    private JScrollPane scrollPaneForTableRecords;
    private ListOfRecordsTableModel tableModelListOfRecords;
    private JTable tableRecords;
    private JScrollPane scrollPaneForAreaShowSimple;
    private JTextArea textAreaShowSimple;
    private Blob[] blobs;
    private String[][] strings;
    private Stat currentStat;
    private JButton buttonBack;
    private JButton buttonShowOrEdit;
    private JButton buttonDeleteRecord;
    private JButton buttonRepair;

    public PanelListOfRecordsFromBase() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelFilter = new JLabel("Фільтр:");
        this.add(labelFilter);
        labelFilter.setBounds(360, 10, 40, 14);

        labelPeriod = new JLabel("Показати записи за період");
        this.add(labelPeriod);
        labelPeriod.setBounds(10, 33, 140, 14);

        labelFromYear = new JLabel("Рік:");
        this.add(labelFromYear);
        labelFromYear.setBounds(180, 33, 20, 14);

//        textFieldFromYear = new JTextField();
//        this.add(textFieldFromYear);
//        textFieldFromYear.setBounds(220, 30, 30, 20);
//        textFieldFromYear.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                textFieldFromYearFocusLost(evt);
//            }
//        });
//        textFieldFromYear.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(KeyEvent evt) {textFieldFromYearKeyPressed(evt);}
//        });

        comboBoxFromYear = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxFromYear);
        comboBoxFromYear.setBounds(200, 30, 50, 20);
        comboBoxFromYear.addActionListener(this::comboBoxFromYearActionPerformed);

        labelFromMonth = new JLabel("Місяць:");
        this.add(labelFromMonth);
        labelFromMonth.setBounds(260, 33, 40, 14);

        comboBoxFromMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxFromMonth);
        comboBoxFromMonth.setBounds(300, 30, 80, 20);
        comboBoxFromMonth.addActionListener(this::comboBoxFromMonthActionPerformed);

        labelHyphen = new JLabel("---");
        this.add(labelHyphen);
        labelHyphen.setBounds(390, 33, 15, 14);

        labelToYear = new JLabel("Рік:");
        this.add(labelToYear);
        labelToYear.setBounds(410, 33, 20, 14);

//        textFieldToYear = new JTextField();
//        this.add(textFieldToYear);
//        textFieldToYear.setBounds(430, 30, 30, 20);
//        textFieldToYear.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                textFieldToYearFocusLost(evt);
//            }
//        });
//        textFieldToYear.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(KeyEvent evt) {textFieldToYearKeyPressed(evt);}
//        });

        comboBoxToYear = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxToYear);
        comboBoxToYear.setBounds(430, 30, 50, 20);
        comboBoxToYear.addActionListener(this::comboBoxToYearActionPerformed);

        labelToMonth = new JLabel("Місяць:");
        this.add(labelToMonth);
        labelToMonth.setBounds(490, 33, 40, 14);

        comboBoxToMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxToMonth);
        comboBoxToMonth.setBounds(530, 30, 80, 20);
        comboBoxToMonth.addActionListener(this::comboBoxToMonthActionPerformed);

        labelDistance = new JLabel("Дистанція сигналізації та зв'язку:");
        this.add(labelDistance);
        labelDistance.setBounds(10, 63, 170, 14);

        String[] temp = StringModels.getShch();
        temp[0] = "Усі";
        comboBoxDistance = new JComboBox<>(temp);
        this.add(comboBoxDistance);
        comboBoxDistance.setBounds(185, 60, 90, 20);
        comboBoxDistance.addActionListener(this::comboBoxDistanceActionPerformed);

        labelDepartment = new JLabel("Відповідальна служба:");
        this.add(labelDepartment);
        labelDepartment.setBounds(340, 63, 120, 14);

        temp = StringModels.getDepartments();
        temp[0] = "Усі";
        comboBoxDepartment = new JComboBox<>(temp);
        this.add(comboBoxDepartment);
        comboBoxDepartment.setBounds(460, 60, 50, 20);
        comboBoxDepartment.addActionListener(this::comboBoxDepartmentActionPerformed);

        checkBoxShowDeleted = new JCheckBox("Показувати видалені записи", false);
        this.add(checkBoxShowDeleted);
        checkBoxShowDeleted.setBounds(590, 60, 180, 23);
        checkBoxShowDeleted.addActionListener(this::checkBoxShowDeletedActionPerformed);

        scrollPaneForTableRecords = new JScrollPane();
        this.add(scrollPaneForTableRecords);
        scrollPaneForTableRecords.setBounds(10, 90, 390, 400);
        scrollPaneForTableRecords.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneForTableRecords.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        tableModelListOfRecords = new ListOfRecordsTableModel();
        tableRecords = new JTable(tableModelListOfRecords);
        scrollPaneForTableRecords.setViewportView(tableRecords);
        tableRecords.getTableHeader().setReorderingAllowed(false);
        tableRecords.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        tableRecords.getColumnModel().getColumn(0).setResizable(false);
        tableRecords.getColumnModel().getColumn(0).setPreferredWidth(70);
        tableRecords.getColumnModel().getColumn(0).setMaxWidth(70);
        tableRecords.getColumnModel().getColumn(1).setResizable(false);
        tableRecords.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableRecords.getColumnModel().getColumn(1).setMaxWidth(70);
        tableRecords.getColumnModel().getColumn(2).setResizable(false);
        tableRecords.getColumnModel().getColumn(2).setPreferredWidth(70);
        tableRecords.getColumnModel().getColumn(2).setMaxWidth(70);
        tableRecords.getColumnModel().getColumn(3).setResizable(false);
        tableRecords.getColumnModel().getColumn(3).setPreferredWidth(180);
        tableRecords.getColumnModel().getColumn(3).setMaxWidth(180);
        tableRecords.setSelectionBackground(new Color(255, 255, 0));
        tableRecords.setSelectionForeground(new Color(0, 0, 0));
        tableRecords.setDefaultRenderer(tableRecords.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (tableModelListOfRecords.getValueAt(row, 4).equals("1")) {
                    setBackground(Color.PINK);
                } else {
                    setBackground(Color.WHITE);
                }
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return this;
            }
        });
        tableRecords.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRecords.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tableRecordsMouseClicked(evt); }
        });
        tableRecords.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableRecordsKeyPressed(evt);
            }
        });

        scrollPaneForAreaShowSimple = new JScrollPane();
        this.add(scrollPaneForAreaShowSimple);
        scrollPaneForAreaShowSimple.setBounds(410, 90, 370, 400);
        scrollPaneForAreaShowSimple.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneForAreaShowSimple.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        textAreaShowSimple = new JTextArea();
        this.add(textAreaShowSimple);
        textAreaShowSimple.setLineWrap(true);
        textAreaShowSimple.setWrapStyleWord(true);
        textAreaShowSimple.setFont(new java.awt.Font("Tahoma", 0, 11));
        textAreaShowSimple.setEditable(false);
        scrollPaneForAreaShowSimple.setViewportView(textAreaShowSimple);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        buttonShowOrEdit = new JButton();
        this.add(buttonShowOrEdit);
        buttonShowOrEdit.setBounds(150, 530, 120, 30);
        buttonShowOrEdit.addActionListener(this::buttonShowOrEditActionPerformed);

        buttonDeleteRecord = new JButton("Видалити");
        this.add(buttonDeleteRecord);
        buttonDeleteRecord.setBounds(290, 530, 120, 30);
        buttonDeleteRecord.setIcon(new ImageIcon("src/ua/andrewblake/resources/Delete.png"));
        buttonDeleteRecord.addActionListener(this::buttonDeleteRecordActionPerformed);

        buttonRepair = new JButton("Відновити");
        this.add(buttonRepair);
        buttonRepair.setBounds(150, 530, 120, 30);
        buttonRepair.setIcon(new ImageIcon("src/ua/andrewblake/resources/Repair.png"));
        buttonRepair.addActionListener(this::buttonRepairActionPerformed);
        buttonRepair.setVisible(false);

        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelListOfRecordsFromBase(this);
    }

    public void fillCurrentDate() {
        comboBoxFromYear.setSelectedIndex(DateTime.getYearInt() - 2010);
        comboBoxToYear.setSelectedIndex(DateTime.getYearInt() - 2010);
//        textFieldFromYear.setText(DateTime.getYearString());
//        textFieldToYear.setText(DateTime.getYearString());
        comboBoxFromMonth.setSelectedIndex(DateTime.getMonthInt() - 1);
        comboBoxToMonth.setSelectedIndex(DateTime.getMonthInt() - 1);
    }

//    private void textFieldFromYearFocusLost(FocusEvent evt) {
//        try {
//            if ((Integer.valueOf(textFieldFromYear.getText().trim()) < 1900) || (Integer.valueOf(textFieldFromYear.getText().trim()) > 2100) || (Integer.valueOf(textFieldFromYear.getText().trim()) > DateTime.getYearInt())) {
//                JOptionPane.showMessageDialog(null, "Неправильно введено рік пошуку");
//                textFieldFromYear.setText(DateTime.getYearString());
//                return;
//            }
//            refresh();
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "Неправильно введено рік пошуку");
//            textFieldFromYear.setText(DateTime.getYearString());
//        }
//    }
//
//    private void textFieldFromYearKeyPressed(KeyEvent evt) {
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            textFieldFromYearFocusLost(null);
//            labelFilter.requestFocus();
//        }
//    }
//
//    private void textFieldToYearFocusLost(FocusEvent evt) {
//        try {
//            if ((Integer.valueOf(textFieldToYear.getText().trim()) < 1900) || (Integer.valueOf(textFieldToYear.getText().trim()) > 2100) || (Integer.valueOf(textFieldToYear.getText().trim()) > DateTime.getYearInt())) {
//                JOptionPane.showMessageDialog(null, "Неправильно введено рік пошуку");
//                textFieldToYear.setText(DateTime.getYearString());
//                return;
//            }
//            refresh();
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "Неправильно введено рік пошуку");
//            textFieldToYear.setText(DateTime.getYearString());
//        }
//    }
//
//    private void textFieldToYearKeyPressed(KeyEvent evt) {
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            textFieldToYearFocusLost(null);
//            labelFilter.requestFocus();
//        }
//    }

    private void comboBoxFromYearActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void comboBoxToYearActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void comboBoxFromMonthActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void comboBoxToMonthActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void comboBoxDistanceActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void comboBoxDepartmentActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void checkBoxShowDeletedActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void tableRecordsMouseClicked(java.awt.event.MouseEvent evt) {
        if (tableRecords.getSelectedRow() < 0) {
            return;
        }
        if ((evt.getClickCount() == 0) || (evt.getClickCount() == 1) || (evt.getClickCount() == 2)) {
            try {
                Blob file = blobs[tableRecords.getSelectedRow()];
                InputStream x = file.getBinaryStream();
                int size = x.available();
                byte b[] = new byte[size];
                x.read(b);
                try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                    targetFile.write(b);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentStat = SerializeToBlob.deserialize();
            textAreaShowSimple.setText("");
            for (String s : currentStat.simpleRecord) {
                textAreaShowSimple.append(s.concat("\n"));
            }
            textAreaShowSimple.append("\n");
            if ((currentStat.createAndEditUsers != null) && (currentStat.createAndEditUsers.length > 0)) {
                for (String s : currentStat.createAndEditUsers) {
                    textAreaShowSimple.append(s.concat("\n"));
                }
            }
            buttonRepair.setVisible(tableModelListOfRecords.getValueAt(tableRecords.getSelectedRow(), 4).equals("1"));
            buttonShowOrEdit.setVisible(!(tableModelListOfRecords.getValueAt(tableRecords.getSelectedRow(), 4).equals("1")));
        }

    }

    private void tableRecordsKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            tableRecords.getSelectionModel().clearSelection();
            textAreaShowSimple.setText("");
            currentStat = null;
        }
        if (evt.getKeyCode() == 38) {
            if (tableRecords.getSelectedRow() == 0) {
                return;
            } else {
                try {
                    Blob file = blobs[tableRecords.getSelectedRow() - 1];
                    InputStream x = file.getBinaryStream();
                    int size = x.available();
                    byte b[] = new byte[size];
                    x.read(b);
                    try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                        targetFile.write(b);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                currentStat = SerializeToBlob.deserialize();
                textAreaShowSimple.setText("");
                for (String s : currentStat.simpleRecord) {
                    textAreaShowSimple.append(s.concat("\n"));
                }
                textAreaShowSimple.append("\n");
                if ((currentStat.createAndEditUsers != null) && (currentStat.createAndEditUsers.length > 0)) {
                    for (String s : currentStat.createAndEditUsers) {
                        textAreaShowSimple.append(s.concat("\n"));
                    }
                }
            }
        }
        if (evt.getKeyCode() == 40) {
            if (tableRecords.getSelectedRow() == tableRecords.getRowCount() - 1) {
                return;
            } else {
                try {
                    Blob file = blobs[tableRecords.getSelectedRow() + 1];
                    InputStream x = file.getBinaryStream();
                    int size = x.available();
                    byte b[] = new byte[size];
                    x.read(b);
                    try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                        targetFile.write(b);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                currentStat = SerializeToBlob.deserialize();
                textAreaShowSimple.setText("");
                for (String s : currentStat.simpleRecord) {
                    textAreaShowSimple.append(s.concat("\n"));
                }
                textAreaShowSimple.append("\n");
                if ((currentStat.createAndEditUsers != null) && (currentStat.createAndEditUsers.length > 0)) {
                    for (String s : currentStat.createAndEditUsers) {
                        textAreaShowSimple.append(s.concat("\n"));
                    }
                }
            }
        }
    }

    public void refresh() {
        if (Integer.valueOf((String) comboBoxFromYear.getSelectedItem()) - Integer.valueOf((String) comboBoxToYear.getSelectedItem()) > 0) {
            tableModelListOfRecords.refresh(null);
        }
        if ((Integer.valueOf((String) comboBoxFromYear.getSelectedItem()) == Integer.valueOf((String) comboBoxToYear.getSelectedItem())) && (comboBoxFromMonth.getSelectedIndex() > comboBoxToMonth.getSelectedIndex())) {
            tableModelListOfRecords.refresh(null);
        }
        try {
            String[] month = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE records READ;");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT COUNT(*) FROM records WHERE date >= '");
            stringBuilder.append((String) comboBoxFromYear.getSelectedItem());
            stringBuilder.append("-");
            stringBuilder.append(month[comboBoxFromMonth.getSelectedIndex()]);
            stringBuilder.append("-01' AND date < '");
            stringBuilder.append(comboBoxToMonth.getSelectedIndex() == 11 ? Integer.valueOf((String) comboBoxToYear.getSelectedItem()) + 1 : (String) comboBoxToYear.getSelectedItem());
            stringBuilder.append("-");
            stringBuilder.append(comboBoxToMonth.getSelectedIndex() == 11 ? "01" : month[comboBoxToMonth.getSelectedIndex() + 1]);
            stringBuilder.append("-01' ");
            stringBuilder.append(comboBoxDistance.getSelectedIndex() == 0 ? "" : "AND dist = ".concat(String.valueOf(comboBoxDistance.getSelectedIndex())).concat(" "));
            stringBuilder.append(comboBoxDepartment.getSelectedIndex() == 0 ? "" : "AND department = ".concat(String.valueOf(comboBoxDepartment.getSelectedIndex())).concat(" "));
            stringBuilder.append(checkBoxShowDeleted.isSelected() ? "" : "AND deleted = 0");
            stringBuilder.append(";");
            ResultSet res = statement.executeQuery(stringBuilder.toString());
            while (res.next()) {
                blobs = new Blob[res.getInt(1)];
                strings = new String[res.getInt(1)][5];
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT date, number_of_record, dist, department, deleted, file_record FROM records WHERE date >= '");
            stringBuilder.append((String) comboBoxFromYear.getSelectedItem());
            stringBuilder.append("-");
            stringBuilder.append(month[comboBoxFromMonth.getSelectedIndex()]);
            stringBuilder.append("-01' AND date < '");
            stringBuilder.append(comboBoxToMonth.getSelectedIndex() == 11 ? Integer.valueOf((String) comboBoxToYear.getSelectedItem()) + 1 : (String) comboBoxToYear.getSelectedItem());
            stringBuilder.append("-");
            stringBuilder.append(comboBoxToMonth.getSelectedIndex() == 11 ? "01" : month[comboBoxToMonth.getSelectedIndex() + 1]);
            stringBuilder.append("-01' ");
            stringBuilder.append(comboBoxDistance.getSelectedIndex() == 0 ? "" : "AND dist = ".concat(String.valueOf(comboBoxDistance.getSelectedIndex())).concat(" "));
            stringBuilder.append(comboBoxDepartment.getSelectedIndex() == 0 ? "" : "AND department = ".concat(String.valueOf(comboBoxDepartment.getSelectedIndex())).concat(" "));
            stringBuilder.append(checkBoxShowDeleted.isSelected() ? "" : "AND deleted = 0");
            stringBuilder.append(" ORDER BY date;");
            res = statement.executeQuery(stringBuilder.toString());
            int i = 0;
            while (res.next()) {
                strings[i][0] = String.valueOf(res.getDate(1));
                strings[i][1] = String.valueOf(res.getInt(2));
                strings[i][2] = String.valueOf(res.getInt(3));
                strings[i][3] = String.valueOf(res.getInt(4));
                strings[i][4] = String.valueOf(res.getInt(5));
                blobs[i] = res.getBlob(6);
                i++;
            }
            ArrayList<String[]> stringsArrayList = new ArrayList<>();
            ArrayList<Blob> blobsArrayList = new ArrayList<>();
            ArrayList<String> dateWithNumberList = new ArrayList<>();
            for (int j = 0; j < strings.length; j++) {
                f1:
                for (int i1 = 0; i1 < dateWithNumberList.size(); i1++) {
                    if (strings[j][0].concat(" ").concat(strings[j][1]).equals(dateWithNumberList.get(i1))) {
                        stringsArrayList.remove(i1);
                        blobsArrayList.remove(i1);
                        dateWithNumberList.remove(i1);
                        break f1;
                    }
                }
                stringsArrayList.add(strings[j]);
                blobsArrayList.add(blobs[j]);
                dateWithNumberList.add(strings[j][0].concat(" ").concat(strings[j][1]));
            }
            strings = new String[stringsArrayList.size()][5];
            blobs = new Blob[blobsArrayList.size()];
            for (int j = 0; j < stringsArrayList.size(); j++) {
                strings[j] = stringsArrayList.get(j);
                blobs[j] = blobsArrayList.get(j);
            }
            tableModelListOfRecords.refresh(strings);
            this.updateUI();
            statement.executeQuery("UNLOCK TABLES;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableRecords.getSelectionModel().clearSelection();
        textAreaShowSimple.setText("");
        currentStat = null;
        buttonShowOrEdit.setVisible(true);
        buttonRepair.setVisible(false);
    }

    public void reset(boolean edit) {
        comboBoxDistance.setSelectedIndex(0);
        comboBoxDepartment.setSelectedIndex(0);
        checkBoxShowDeleted.setSelected(false);
        if (edit) {
            buttonShowOrEdit.setIcon(new ImageIcon("src/ua/andrewblake/resources/Edit.png"));
            buttonShowOrEdit.setText("Редагувати");
            buttonDeleteRecord.setVisible(true);
        } else {
            buttonShowOrEdit.setIcon(new ImageIcon("src/ua/andrewblake/resources/PreviousView.png"));
            buttonShowOrEdit.setText("Перегляд");
            buttonDeleteRecord.setVisible(false);
        }
        tableRecords.getSelectionModel().clearSelection();
        textAreaShowSimple.setText("");
        currentStat = null;
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }

    private void buttonShowOrEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStat == null) {
            JOptionPane.showMessageDialog(null, "Не обрано жодного запису");
            return;
        }
        if (buttonShowOrEdit.getText().equals("Перегляд")) {
            this.setVisible(false);
            GlobalSettings.getPanelViewRecord().setVisible(true);
            GlobalSettings.getPanelViewRecord().showSimpleRecord(currentStat.simpleRecord, currentStat.createAndEditUsers);
        } else {
            this.setVisible(false);
            PanelIntroductionError panelIntroductionError = GlobalSettings.getPanelIntroductionError();
            panelIntroductionError.setVisible(true);
            panelIntroductionError.fillParams(currentStat);
            GlobalSettings.setCurrentStat(currentStat);
        }
    }

    private void buttonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStat == null) {
            JOptionPane.showMessageDialog(null, "Не обрано жодного запису");
            return;
        }
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String query = "LOCK TABLE records WRITE;";
            statement.executeQuery(query);
            ArrayList<Long> id = new ArrayList<>();
            query = "SELECT id FROM records WHERE date = '".concat((String) tableRecords.getValueAt(tableRecords.getSelectedRow(), 0)).concat("' AND number_of_record = ").concat((String) tableRecords.getValueAt(tableRecords.getSelectedRow(), 1)).concat(";");
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                id.add(res.getLong(1));
            }
            for (long l : id) {
                statement.addBatch("UPDATE records SET deleted = 1 WHERE id = ".concat(String.valueOf(l)).concat(";"));
            }
            statement.executeBatch();
            statement.clearBatch();
            query = "UNLOCK TABLES;";
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        refresh();
    }

    private void buttonRepairActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            String query = "LOCK TABLE records WRITE;";
            statement.executeQuery(query);
            ArrayList<Long> id = new ArrayList<>();
            query = "SELECT id FROM records WHERE date = '".concat((String) tableRecords.getValueAt(tableRecords.getSelectedRow(), 0)).concat("' AND number_of_record = ").concat((String) tableRecords.getValueAt(tableRecords.getSelectedRow(), 1)).concat(";");
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                id.add(res.getLong(1));
            }
            for (long l : id) {
                statement.addBatch("UPDATE records SET deleted = 0 WHERE id = ".concat(String.valueOf(l)).concat(";"));
            }
            statement.executeBatch();
            statement.clearBatch();
            query = "UNLOCK TABLES;";
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        refresh();
    }

}
