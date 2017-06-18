package ua.andrewblake.tablemodels;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.Serializable;
import java.util.ArrayList;

public class TableModel2_1 extends AbstractTableModel implements TableModel, Serializable {

    private String[] numberOfTrains;
    private int countOfTrains;
    private transient JTable table;

    public TableModel2_1() {
        numberOfTrains = new String[100];
        for (int i = 0; i < 100; i++) {
            numberOfTrains[i] = new String("");
        }
        countOfTrains = 0;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    @Override
    public int getRowCount() {
        return countOfTrains + 1;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "№ поїзда";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (numberOfTrains[rowIndex].equals("")) {
            return "";
        }
        return "   ".concat(numberOfTrains[rowIndex]);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (numberOfTrains[rowIndex].equals("")) {
            countOfTrains++;
        }
        numberOfTrains[rowIndex] = ((String) aValue).trim();
        if (numberOfTrains[rowIndex].trim().equals("")) {
            ArrayList<String> tempArray = new ArrayList<>();
            for (String s : numberOfTrains) {
                if (!s.trim().equals("")) {
                    tempArray.add(s);
                }
            }
            countOfTrains = tempArray.size();
            for (int i = 0; i < 100; i++) {
                if (i < tempArray.size()) {
                    numberOfTrains[i] = tempArray.get(i);
                } else {
                    numberOfTrains[i] = new String("");;
                }
            }
        }

        this.fireTableDataChanged();
        table.updateUI();
    }
}