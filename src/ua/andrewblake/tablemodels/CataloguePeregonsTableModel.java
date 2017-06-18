package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CataloguePeregonsTableModel extends AbstractTableModel implements TableModel {

    private String[][] peregons;

    public CataloguePeregonsTableModel() {
        // NOP
    }

    public void refresh(String[][] stations) {
        this.peregons = stations;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (peregons != null) {
            return peregons.length;
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Перегін";
        } else {
            return "ШЧ";
        }
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
        if (columnIndex == 1) {
            return (Integer.valueOf(peregons[rowIndex][columnIndex]) > 6) ? String.valueOf(Integer.valueOf(peregons[rowIndex][columnIndex]) + 1) : peregons[rowIndex][columnIndex];
        }
        return peregons[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // NOP
    }

}
