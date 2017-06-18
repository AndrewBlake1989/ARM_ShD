package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ListOfRecordsTableModel extends AbstractTableModel implements TableModel {

    private String[][] strings;

    public ListOfRecordsTableModel() {
        // NOP
    }

    public void refresh(String[][] strings) {
        this.strings = strings;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (strings != null) {
            return strings.length;
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Дата";
            case 1:
                return "№ запису";
            case 2:
                return "Дистанція";
            case 3:
                return "Відповідальна служба";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            return "ШЧ-".concat(strings[rowIndex][columnIndex]);
        }
        if (columnIndex == 3) {
            switch (Integer.valueOf(strings[rowIndex][columnIndex])) {
                case 1:
                    return "Ш";
                case 2:
                    return "П";
                case 3:
                    return "Д";
                case 4:
                    return "Е";
                case 5:
                    return "Інша";
            }
        }
        return strings[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // NOP
    }

}
