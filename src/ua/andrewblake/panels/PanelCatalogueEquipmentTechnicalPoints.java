package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.EquipmentTechnicalPointsTableModel;
import ua.andrewblake.tablemodels.ListOfRecordsTableModel;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.DateTime;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PanelCatalogueEquipmentTechnicalPoints extends JPanel {


    private JLabel labelHeader;
    private JLabel labelImage;
    private JLabel labelYear;
    private JComboBox<String> comboBoxYear;
    private JScrollPane scrollPaneForTableEquipmentTechnicalPoints;
    private JTable tableEquipmentTechnicalPoints;
    private EquipmentTechnicalPointsTableModel equipmentTechnicalPointsTableModel;
    private JButton buttonSave;
    private JButton buttonBack;


    public PanelCatalogueEquipmentTechnicalPoints() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelHeader = new JLabel("Оснащення в технічних балах:");
        this.add(labelHeader);
        labelHeader.setBounds(310, 10, 160, 15);

        labelImage = new JLabel(new ImageIcon("src/ua/andrewblake/resources/ImageForPanelEquipmentTechnicalPoints.jpg"));
        this.add(labelImage);
        labelImage.setBounds(60, 30, 680, 280);
        labelImage.setHorizontalAlignment(SwingConstants.LEFT);

        comboBoxYear = new JComboBox<>(StringModels.getYears()); // comboBoxYear must be before table (NullPointerException)
        this.add(comboBoxYear);
        comboBoxYear.setBounds(380, 535, 60, 20);
        comboBoxYear.setSelectedIndex(DateTime.getYearInt() - 2010);
        comboBoxYear.addActionListener(this::comboBoxYearActionPerformed);

        scrollPaneForTableEquipmentTechnicalPoints = new JScrollPane();
        this.add(scrollPaneForTableEquipmentTechnicalPoints);
        scrollPaneForTableEquipmentTechnicalPoints.setBounds(10, 320, 770, 205);
        scrollPaneForTableEquipmentTechnicalPoints.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneForTableEquipmentTechnicalPoints.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        equipmentTechnicalPointsTableModel = new EquipmentTechnicalPointsTableModel(comboBoxYear);
        tableEquipmentTechnicalPoints = new JTable(equipmentTechnicalPointsTableModel);
        scrollPaneForTableEquipmentTechnicalPoints.setViewportView(tableEquipmentTechnicalPoints);
        tableEquipmentTechnicalPoints.getTableHeader().setReorderingAllowed(false);
        tableEquipmentTechnicalPoints.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(0).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(0).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(0).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(1).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(1).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(1).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(2).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(2).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(2).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(3).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(3).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(4).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(4).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(4).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(5).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(5).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(5).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(6).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(6).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(6).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(7).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(7).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(7).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(8).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(8).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(8).setMaxWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(9).setResizable(false);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(9).setPreferredWidth(77);
        tableEquipmentTechnicalPoints.getColumnModel().getColumn(9).setMaxWidth(77);
        tableEquipmentTechnicalPoints.setSelectionBackground(new Color(255, 255, 0));
        tableEquipmentTechnicalPoints.setSelectionForeground(new Color(0, 0, 0));
        tableEquipmentTechnicalPoints.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEquipmentTechnicalPoints.setDefaultRenderer(tableEquipmentTechnicalPoints.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return this;
            }
        });

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        labelYear = new JLabel("Рік:");
        this.add(labelYear);
        labelYear.setBounds(350, 538, 20, 15);

        buttonSave = new JButton("Зберегти");
        this.add(buttonSave);
        buttonSave.setBounds(670, 530, 100, 30);
        buttonSave.addActionListener(this::buttonSaveActionPerformed);

        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelCatalogueEquipmentTechnicalPoints(this);

    }

    private void comboBoxYearActionPerformed(java.awt.event.ActionEvent evt) {
        equipmentTechnicalPointsTableModel.refresh();
        equipmentTechnicalPointsTableModel.fireTableDataChanged();
    }

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        buttonSave.setVisible(false);
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE equipment_technical_points WRITE;");
            for (int i = 1; i <= 12; i++) {
                if (i == 7) {
                    continue;
                }
                int j = i < 7 ? i - 1 : i - 2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE equipment_technical_points SET ec = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 1));
                stringBuilder.append(", klz = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 2));
                stringBuilder.append(", ab = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 3));
                stringBuilder.append(", rpb = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 4));
                stringBuilder.append(", ps = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 5));
                stringBuilder.append(", gac = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 6));
                stringBuilder.append(", dc = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 7));
                stringBuilder.append(", other = ");
                stringBuilder.append(tableEquipmentTechnicalPoints.getValueAt(j, 8));
                stringBuilder.append(" WHERE year = ");
                stringBuilder.append(comboBoxYear.getSelectedItem());
                stringBuilder.append(" AND shch = ");
                stringBuilder.append(i);
                stringBuilder.append(";");
                statement.execute(stringBuilder.toString());
            }
            statement.executeQuery("UNLOCK TABLES;");
            JOptionPane.showMessageDialog(null, "Успішно збережено.");
        } catch (SQLException e) {
            e.printStackTrace();
            // todo noConnection
        } finally {
            buttonSave.setVisible(true);
        }
        equipmentTechnicalPointsTableModel.refresh();
        equipmentTechnicalPointsTableModel.fireTableDataChanged();
        this.updateUI();
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }
}
