package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.Serializable;

public class TheftResultTableModel extends AbstractTableModel implements TableModel, Serializable {

    private String[][] theftResult;

    public TheftResultTableModel() {
        theftResult = new String[][]{{"   Направлено листів в поліцію", ""},
                                     {"   Отримано відповідей", ""},
                                     {"   Загальний матеріальний збиток (в гривнях)", ""},
                                     {"   Відшкодування (в гривнях)", ""}};
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return theftResult[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        theftResult[rowIndex][columnIndex] = (String) aValue;
    }
}
