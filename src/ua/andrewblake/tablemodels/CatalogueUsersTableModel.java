package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CatalogueUsersTableModel extends AbstractTableModel implements TableModel {

    private String[][] users;

    public CatalogueUsersTableModel() {
        // NOP
    }

    public void refresh(String[][] users) {
        this.users = users;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (users != null) {
            return users.length;
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
                return "Логін";
            case 1:
                return "П. І. Б.";
            case 2:
                return "Посада";
            case 3:
                return "Права Адміністратора";
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
        return users[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // NOP
    }
}
