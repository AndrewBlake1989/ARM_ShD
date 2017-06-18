package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CatalogueStationsTableModel extends AbstractTableModel implements TableModel {

    private String[][] stations;

    public CatalogueStationsTableModel() {
        // NOP
    }

    public void refresh(String[][] stations) {
        this.stations = stations;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (stations != null) {
            return stations.length;
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
            return "Назва станції";
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
            return (Integer.valueOf(stations[rowIndex][columnIndex]) > 6) ? String.valueOf(Integer.valueOf(stations[rowIndex][columnIndex]) + 1) : stations[rowIndex][columnIndex];
        }
        return stations[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // NOP
    }

}
