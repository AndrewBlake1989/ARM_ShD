package ua.andrewblake.tablemodels;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AndrewBlake on 01.05.2017.
 */
public class TableModel4_1 extends AbstractTableModel implements TableModel, Serializable {

    private String[][] trainLatency;
    private int countOfTrains;
    private transient JTable table;

    public TableModel4_1() {
        trainLatency = new String[100][4];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 4; j++) {
                trainLatency[i][j] = "";
            }
        }
        countOfTrains = 0;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public int getCountOfTrains() {
        return countOfTrains;
    }

    @Override
    public int getRowCount() {
        return countOfTrains + 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "№ поїзда";
            case 1:
                return "Категорія";
            case 2:
                return "Час затримки";
            default:
                return "";
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
        if (columnIndex == 2) {
            if (rowIndex >= countOfTrains) {
                return "";
            }
            return trainLatency[rowIndex][2].concat(":").concat(trainLatency[rowIndex][3]);
        } else {
            return "   ".concat(trainLatency[rowIndex][columnIndex]);
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        trainLatency[rowIndex][columnIndex] = (String) aValue;
    }

    public void recalculationCountOfTrains() {
        ArrayList<String[]> tempArray = new ArrayList<String[]>();
        for (int i = 0; i < 100; i++) {
            if ((!trainLatency[i][0].trim().equals("")) || (!trainLatency[i][1].trim().equals("")) || (!trainLatency[i][2].trim().equals("")) || (!trainLatency[i][3].trim().equals(""))) {
                tempArray.add(new String[]{trainLatency[i][0], trainLatency[i][1], trainLatency[i][2], trainLatency[i][3]});
            }
        }
        for (int i = 0; i < 100; i++) {
            if (i < tempArray.size()) {
                trainLatency[i] = tempArray.get(i);
            } else {
                trainLatency[i][0] = "";
                trainLatency[i][1] = "";
                trainLatency[i][2] = "";
                trainLatency[i][3] = "";
            }
        }

        countOfTrains = tempArray.size();

        this.fireTableDataChanged();
    }
}