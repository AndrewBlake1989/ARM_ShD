package ua.andrewblake.tablemodels;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.Serializable;

public class TheftTableModel extends AbstractTableModel implements TableModel, Serializable {

    private String[][] theft;

    public TheftTableModel() {
        theft = new String[][]{{"   Лінзові світлофори", "", "   шт."},
                               {"   Лінзові комплекти", "", "   шт."},
                               {"   Акумулятори", "", "   шт."},
                               {"   Рейкові з'єднувачі", "", "   шт."},
                               {"   Перемички", "", "   м."},
                               {"   Проводи ПЛЗ", "", "   м"},
                               {"   Стовпи ПЛЗ і траверс", "", "   шт."},
                               {"   Гучномовці", "", "   шт."},
                               {"   Перегонні телефони", "", "   шт."},
                               {"   Апаратура в РШ, коробках", "", "   шт."},
                               {"   Апаратура в приміщеннях", "", "   шт."},
                               {"   Дзвінки на переїздах", "", "   шт."},
                               {"   Кабелі СЦБ і зв'язку", "", "   м."},
                               {"   Пристрої ПОНАБ", "", "   шт."},
                               {"   Дросель-трансформатори", "", "   шт."},
                               {"   Електроприводи", "", "   шт."},
                               {"   Замки Мелентьєва", "", "   шт."},
                               {"   Батарейні шафи", "", "   шт."},
                               {"   НУП зв'язку", "", "   шт."},
                               {"   Кол. коробки і кабельні ящики", "", "   шт."},
                               {"   Радіостанція", "", "   шт."}};
    }

    @Override
    public int getRowCount() {
        return 21;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Найменування";
            case 1:
                return "Кількість";
            case 2:
                return "Одиниця виміру";
        }
        return null;
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
        return theft[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        theft[rowIndex][columnIndex] = ((String) aValue).replaceAll(",", ".");
    }
}
