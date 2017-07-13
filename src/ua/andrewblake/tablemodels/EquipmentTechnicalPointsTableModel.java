package ua.andrewblake.tablemodels;

import ua.andrewblake.utils.ConnectionToMySQL;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipmentTechnicalPointsTableModel extends AbstractTableModel implements TableModel {

    private String[][] equipmentTechnicalPoints;
    private JComboBox<String> year;

    public EquipmentTechnicalPointsTableModel(JComboBox<String> year) {
        this.year = year;
        refresh();
    }

    public void refresh() {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            equipmentTechnicalPoints = new String[11][10];
            equipmentTechnicalPoints[0][0] = "ШЧ-1";
            equipmentTechnicalPoints[1][0] = "ШЧ-2";
            equipmentTechnicalPoints[2][0] = "ШЧ-3";
            equipmentTechnicalPoints[3][0] = "ШЧ-4";
            equipmentTechnicalPoints[4][0] = "ШЧ-5";
            equipmentTechnicalPoints[5][0] = "ШЧ-6";
            equipmentTechnicalPoints[6][0] = "ШЧ-8";
            equipmentTechnicalPoints[7][0] = "ШЧ-9";
            equipmentTechnicalPoints[8][0] = "ШЧ-10";
            equipmentTechnicalPoints[9][0] = "ШЧ-11";
            equipmentTechnicalPoints[10][0] = "ШЧ-12";
            statement.executeQuery("LOCK TABLE equipment_technical_points READ;");
            ResultSet res = statement.executeQuery("SELECT * FROM equipment_technical_points WHERE year = ".concat((String) year.getSelectedItem()).concat(";"));
            int i = 0;
            while (res.next()) {
                equipmentTechnicalPoints[i][1] = res.getString(4);
                equipmentTechnicalPoints[i][2] = res.getString(5);
                equipmentTechnicalPoints[i][3] = res.getString(6);
                equipmentTechnicalPoints[i][4] = res.getString(7);
                equipmentTechnicalPoints[i][5] = res.getString(8);
                equipmentTechnicalPoints[i][6] = res.getString(9);
                equipmentTechnicalPoints[i][7] = res.getString(10);
                equipmentTechnicalPoints[i][8] = res.getString(11);
                double result = 0;
                for (int j = 1; j <= 8 ; j++) {
                    result += Double.valueOf(equipmentTechnicalPoints[i][j]);
                }
                equipmentTechnicalPoints[i][9] = String.valueOf(result);
                i++;
            }
            statement.executeQuery("UNLOCK TABLES;");
        } catch (SQLException e) {
            if (e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException) {
                JOptionPane.showMessageDialog(null, "Збій зв'язку з Базою Даних. Перевірте мережеве з'єднання або зверніться до вашого Адміністратора");
            } else {
                JOptionPane.showMessageDialog(null, "При роботі з Базою Даних MySQL виникла помилка. Перевірте з'єднання та повідомте про це Вашого адміністратора.");
            }
        }
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return 11;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ШЧ";
            case 1:
                return "ЕЦ";
            case 2:
                return "КлЗ";
            case 3:
                return "АБ";
            case 4:
                return "РПБ";
            case 5:
                return "ПС";
            case 6:
                return "ГАЦ";
            case 7:
                return "ДЦ";
            case 8:
                return "Інші";
            case 9:
                return "Всього";
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
        return (columnIndex != 0) && (columnIndex != 9);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 9) {
            return String.valueOf(new BigDecimal(Double.valueOf(equipmentTechnicalPoints[rowIndex][columnIndex])).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }
        return equipmentTechnicalPoints[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            aValue = ((String) aValue).replaceAll(",", ".");
            Double.valueOf((String) aValue);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Спроба введення нечислового значення");
            return;
        }
        equipmentTechnicalPoints[rowIndex][columnIndex] = (String) aValue;
        double result = 0;
        for (int i = 1; i <= 8 ; i++) {
            result += Double.valueOf(equipmentTechnicalPoints[rowIndex][i]);
        }
        equipmentTechnicalPoints[rowIndex][9] = String.valueOf(new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }
}
