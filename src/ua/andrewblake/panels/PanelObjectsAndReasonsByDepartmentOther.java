package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.tablemodels.TheftResultTableModel;
import ua.andrewblake.tablemodels.TheftTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class PanelObjectsAndReasonsByDepartmentOther extends JPanel implements GetData {

    private JComboBox<String> comboBox1;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JTable table2;
    private JSeparator separator;
    private JTextField textField;
    private TheftTableModel theftTableModel;
    private TheftResultTableModel theftResultTableModel;

    PanelObjectsAndReasonsByDepartmentOther() {

        this.setSize(800, 280);
        this.setLayout(null);

        comboBox1 = new JComboBox<>(new String[]{"-", "Крадіжка", "Рейкове коло", "Інше"});
        this.add(comboBox1);
        comboBox1.setBounds(10, 10, 80, 20);
        comboBox1.addActionListener(this::comboBox1ActionPerformed);

        scrollPane1 = new JScrollPane();
        this.add(scrollPane1);
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setBounds(10, 40, 380, 230);
        JPanel p = this;

        theftTableModel = new TheftTableModel();
        table1 = new JTable(theftTableModel);
        scrollPane1.setViewportView(table1);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        table1.getColumnModel().getColumn(0).setResizable(false);
        table1.getColumnModel().getColumn(0).setPreferredWidth(200);
        table1.getColumnModel().getColumn(0).setMaxWidth(200);
        table1.getColumnModel().getColumn(1).setResizable(false);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setMaxWidth(100);
        table1.getColumnModel().getColumn(2).setResizable(false);
        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setMaxWidth(100);
        table1.setSelectionBackground(new Color(255, 255, 0));
        table1.setSelectionForeground(new Color(0, 0, 0));
        table1.setDefaultRenderer(table1.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 1) {
                    super.setHorizontalAlignment(SwingConstants.CENTER);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                } else {
                    super.setHorizontalAlignment(SwingConstants.LEFT);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                }
            }
        });
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane1.setVisible(false);

        separator = new JSeparator(1);
        this.add(separator);
        separator.setBounds(400, 40, 5, 240);
        separator.setVisible(false);

        scrollPane2 = new JScrollPane();
        this.add(scrollPane2);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane2.setBounds(410, 40, 370, 80);

        theftResultTableModel = new TheftResultTableModel();
        table2 = new JTable(theftResultTableModel);
        scrollPane2.setViewportView(table2);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        table2.getColumnModel().getColumn(0).setResizable(false);
        table2.getColumnModel().getColumn(0).setPreferredWidth(250);
        table2.getColumnModel().getColumn(0).setMaxWidth(250);
        table2.getColumnModel().getColumn(1).setResizable(false);
        table2.getColumnModel().getColumn(1).setPreferredWidth(120);
        table2.getColumnModel().getColumn(1).setMaxWidth(120);
        table2.setSelectionBackground(new Color(255, 255, 0));
        table2.setSelectionForeground(new Color(0, 0, 0));
        table2.setDefaultRenderer(table2.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 1) {
                    super.setHorizontalAlignment(SwingConstants.CENTER);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                } else {
                    super.setHorizontalAlignment(SwingConstants.LEFT);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                }
            }
        });
        table2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane2.setVisible(false);

        textField = new JTextField();
        this.add(textField);
        textField.setBounds(100, 10, 680, 20);
        textField.setVisible(false);

        this.setVisible(true);

    }

    private void comboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        scrollPane1.setVisible(comboBox1.getSelectedIndex() == 1);
        scrollPane2.setVisible(comboBox1.getSelectedIndex() == 1);
        separator.setVisible(comboBox1.getSelectedIndex() == 1);
        textField.setVisible((comboBox1.getSelectedIndex() == 2) || (comboBox1.getSelectedIndex() == 3));
        textField.setText("");
    }

    @Override
    public boolean canContinue() {
        if (comboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не зроблено вибір");
            return false;
        }
        if ((textField.isVisible()) && (textField.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "Не вказано конкретну причину");
            return false;
        }
        for (int i = 0; i < 21; i++) {
            if (!((String) table1.getValueAt(i,1)).trim().equals("")) {
                if ((i == 4) || (i == 5) || (i == 12)) {
                    double d = 0;
                    try {
                        d = Double.valueOf(((String) table1.getValueAt(i,1)).trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Для елементу \"".concat(((String) table1.getValueAt(i, 0)).substring(3)).concat("\" неправильно введено кількість. Допускаються тільки числові значення."));
                        return false;
                    }
                    if (d < 0) {
                        JOptionPane.showMessageDialog(null, "Для елементу \"".concat(((String) table1.getValueAt(i, 0)).substring(3)).concat("\" введено мінусове значення"));
                        return false;
                    }
                } else {
                    int n = 0;
                    try {
                        n = Integer.valueOf(((String) table1.getValueAt(i,1)).trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Для елементу \"".concat(((String) table1.getValueAt(i, 0)).substring(3)).trim().concat("\" неправильно введено кількість. Допускаються тільки цілі числові значення."));
                        return false;
                    }
                    if (n < 0) {
                        JOptionPane.showMessageDialog(null, "Для елементу \"".concat(((String) table1.getValueAt(i, 0)).substring(3)).trim().concat("\" введено мінусове значення"));
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!((String) table2.getValueAt(i,1)).trim().equals("")) {
                if ((i == 2) || (i == 3)) {
                    double d = 0;
                    try {
                        d = Double.valueOf(((String) table2.getValueAt(i,1)).trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "В рядку \"".concat(((String) table2.getValueAt(i, 0)).substring(3)).trim().concat("\" неправильно введено дані. Допускаються тільки числові значення."));
                        return false;
                    }
                    if (d < 0) {
                        JOptionPane.showMessageDialog(null, "В рядку \"".concat(((String) table2.getValueAt(i, 0)).substring(3)).trim().concat("\" введено мінусове значення"));
                        return false;
                    }
                } else {
                    int n = 0;
                    try {
                        n = Integer.valueOf(((String) table2.getValueAt(i,1)).trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "В рядку \"".concat(((String) table2.getValueAt(i, 0)).substring(3)).trim().concat("\" неправильно введено дані. Допускаються тільки числові значення."));
                        return false;
                    }
                    if (n < 0) {
                        JOptionPane.showMessageDialog(null, "В рядку \"".concat(((String) table2.getValueAt(i, 0)).substring(3)).trim().concat("\" введено мінусове значення"));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Відповідальна служба - Інша;");
        if (comboBox1.getSelectedIndex() == 1) { // Крадіжка
            tempArray.add("Причина - крадіжка;");
            tempArray.add("Викрадено:");
            boolean haveAnyRecord = false;
            for (int i = 0; i < 21; i++) {
                if (!((String) table1.getValueAt(i, 1)).trim().equals("")) {
                    haveAnyRecord = true;
                    tempArray.add("\t".concat(((String) table1.getValueAt(i, 0)).trim()).concat(": ").concat((String) table1.getValueAt(i, 1)).concat(" ").concat(((String) table1.getValueAt(i, 2)).trim()));
                }
            }
            if (!haveAnyRecord) {
                tempArray.add("\tВикрадених елементів не зазначено...");
            }
            tempArray.add("");
            for (int i = 0; i < 4; i++) {
                if (!((String) table2.getValueAt(i, 1)).trim().equals("")) {
                    tempArray.add(((String) table2.getValueAt(i, 0)).trim().concat(": ").concat((String) table2.getValueAt(i, 1)));
                }
            }
        }
        if (comboBox1.getSelectedIndex() == 2) { // Рейкове коло
            tempArray.add("Рейкове коло - ".concat(textField.getText()).concat(";"));
        }
        if (comboBox1.getSelectedIndex() == 3) { // Інше
            tempArray.add("Інші причини - ".concat(textField.getText()).concat(";"));
        }

        // Create array of this class:
        String[] newSimple = new String[simple.length + tempArray.size()];
        for (int i = 0; i < newSimple.length; i++) {
            if (i < simple.length) {
                newSimple[i] = simple[i];
            } else {
                newSimple[i] = tempArray.get(i - simple.length);
            }
        }
        return newSimple;
    }

    @Override
    public Stat getParams(Stat stat) {
        stat.paramsPanelObjectsAndReasons = new String[][]{{"comboBox1", String.valueOf(comboBox1.getSelectedIndex())}, {"textField", textField.getText()}};
        stat.theftTableModel = theftTableModel;
        stat.theftResultTableModel = theftResultTableModel;
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        String[][] params = stat.paramsPanelObjectsAndReasons;
        comboBox1.setSelectedIndex(Integer.valueOf(params[0][1]));
        if (textField.isVisible()) {
            textField.setText(params[1][1]);
        }
        if (scrollPane1.isVisible()) {
            theftTableModel = stat.theftTableModel;
            table1.setModel(theftTableModel);
        }
        if (scrollPane2.isVisible()) {
            theftResultTableModel = stat.theftResultTableModel;
            table2.setModel(theftResultTableModel);
        }
    }
}
