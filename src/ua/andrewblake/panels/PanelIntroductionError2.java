package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.tablemodels.TableModel2_1;
import ua.andrewblake.tablemodels.TableModel4_1;
import ua.andrewblake.temporary.TestSerialization;
import ua.andrewblake.utils.ConnectionToMySQL;
import ua.andrewblake.utils.DateTime;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PanelIntroductionError2 extends JPanel implements GetData {

    private JCheckBox checkBox1;
    private JLabel label1_1;
    private JTextField textField1_1;
    private JComboBox<String> comboBox1_1;
    private JLabel label1_2;
    private JTextField textField1_2;

    private JCheckBox checkBox2;
    private JLabel label2_1;
    private JScrollPane scrollPane2_1;
    private JTable table2_1;
    private TableModel2_1 tm2_1;

    private JCheckBox checkBox3;
    private JLabel label3_1;
    private JComboBox<String> comboBox3_1;
    private JComboBox<String> comboBox3_2;

    private JCheckBox checkBox4;
    private JScrollPane scrollPane4_1;
    private JTable table4_1;
    private int selectedRowTable4_1;
    private boolean isSelectedTable4_1;
    private TableModel4_1 tm4_1;
    private JLabel label4_1;
    private JTextField textField4_1;
    private JComboBox<String> comboBox4_1;
    private JLabel label4_2;
    private JTextField textField4_2;
    private JLabel label4_3;
    private JTextField textField4_3;
    private JButton button4_Add;
    private JButton button4_DeleteSelected;

    private JCheckBox checkBox5;
    private JLabel label5_1;
    private JComboBox<String> comboBox5_1;

    private JCheckBox checkBox6;
    private JLabel label6_1;
    private JCheckBox checkBox6_1;
    private JCheckBox checkBox6_2;
    private JCheckBox checkBox6_3;

    private JCheckBox checkBox7;

    private JButton buttonBack;
    private JButton buttonNext;

    public PanelIntroductionError2() {

        this.setSize(800, 600);
        this.setLayout(null);

        checkBox1 = new JCheckBox("Перекриття сигналу", false);
        this.add(checkBox1);
        checkBox1.setBounds(10, 30, 130, 25);
        checkBox1.addActionListener(this::checkBox1ActionPerformed);

        label1_1 = new JLabel("Перекриття сигналу");
        this.add(label1_1);
        label1_1.setBounds(10, 133, 105, 15);
        label1_1.setEnabled(false);

        textField1_1 = new JTextField("");
        this.add(textField1_1);
        textField1_1.setBounds(120, 130, 50, 20);
        textField1_1.setEnabled(false);

        comboBox1_1 = new JComboBox<>(new String[]{"з проїздом", "без проїзду"});
        this.add(comboBox1_1);
        comboBox1_1.setBounds(175, 130, 90, 20);
        comboBox1_1.setEnabled(false);

        label1_2 = new JLabel("поїзду №");
        this.add(label1_2);
        label1_2.setBounds(271, 133, 50, 15);
        label1_2.setEnabled(false);

        textField1_2 = new JTextField("");
        this.add(textField1_2);
        textField1_2.setBounds(325, 130, 50, 20);
        textField1_2.setEnabled(false);



        checkBox2 = new JCheckBox("Прийом (відправлення) за наказом (запрошуючим сигналом)", false);
        this.add(checkBox2);
        checkBox2.setBounds(10, 50, 340, 25);
        checkBox2.addActionListener(this::checkBox2ActionPerformed);

        label2_1 = new JLabel("Прийом (відправлення) за наказом (запрошуючим сигналом):");
        this.add(label2_1);
        label2_1.setBounds(10, 160, 310, 15);
        label2_1.setEnabled(false);

        scrollPane2_1 = new JScrollPane();
        this.add(scrollPane2_1);
        scrollPane2_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2_1.setBounds(10, 180, 100, 100);
        scrollPane2_1.setEnabled(false);

        tm2_1 = new TableModel2_1();
        table2_1 = new JTable(tm2_1);
        scrollPane2_1.setViewportView(table2_1);
        table2_1.setDefaultRenderer(table2_1.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.LEFT);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return this;
            }
        });
        table2_1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        table2_1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tm2_1.setTable(table2_1);
        scrollPane2_1.setVisible(true);
        table2_1.setEnabled(false);



        checkBox3 = new JCheckBox("Закриття основних засобів зв\'язку", false);
        this.add(checkBox3);
        checkBox3.setBounds(10, 70, 210, 25);
        checkBox3.addActionListener(this::checkBox3ActionPerformed);

        label3_1 = new JLabel("Закриття основних засобів  зв\'язку:");
        this.add(label3_1);
        label3_1.setBounds(10, 303, 310, 15);
        label3_1.setEnabled(false);

        comboBox3_1 = new JComboBox<>(new String[]{"АБ", "НАБ"});
        this.add(comboBox3_1);
        comboBox3_1.setBounds(200, 300, 45, 20);
        comboBox3_1.addActionListener(this::comboBox3_1ActionPerformed);
        comboBox3_1.setEnabled(false);

        comboBox3_2 = new JComboBox<>();
        this.add(comboBox3_2);
        comboBox3_2.addItem("Погаслі сигнальні вогні на 2-ох і більше розміщених підряд світлофорах на перегоні");
        comboBox3_2.addItem("Наявність дозволяючого вогню на прохідному світлофорі при зайнятій блок-дільниці");
        comboBox3_2.addItem("Неможливість зміни напрямку");
        comboBox3_2.setBounds(250, 300, 530, 20);
        comboBox3_2.setEnabled(false);



        checkBox4 = new JCheckBox("Затримки поїздів", false);
        this.add(checkBox4);
        checkBox4.setBounds(10, 90, 120, 25);
        checkBox4.addActionListener(this::checkBox4ActionPerformed);

        scrollPane4_1 = new JScrollPane();
        this.add(scrollPane4_1);
        scrollPane4_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane4_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane4_1.setBounds(10, 350, 290, 100);
        scrollPane4_1.setEnabled(false);

        tm4_1 = new TableModel4_1();
        table4_1 = new JTable(tm4_1);
        scrollPane4_1.setViewportView(table4_1);
        table4_1.getTableHeader().setReorderingAllowed(false);
        table4_1.getTableHeader().setResizingAllowed(false);
        table4_1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        });
        table4_1.getColumnModel().getColumn(0).setResizable(false);
        table4_1.getColumnModel().getColumn(0).setPreferredWidth(70);
        table4_1.getColumnModel().getColumn(0).setMaxWidth(70);
        table4_1.getColumnModel().getColumn(1).setResizable(false);
        table4_1.getColumnModel().getColumn(1).setPreferredWidth(130);
        table4_1.getColumnModel().getColumn(1).setMaxWidth(130);
        table4_1.getColumnModel().getColumn(2).setResizable(false);
        table4_1.getColumnModel().getColumn(2).setPreferredWidth(90);
        table4_1.getColumnModel().getColumn(2).setMaxWidth(90);
        table4_1.setSelectionBackground(new Color(255, 255, 0));
        table4_1.setSelectionForeground(new Color(0, 0, 0));
        table4_1.setDefaultRenderer(table4_1.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 2) {
                    super.setHorizontalAlignment(SwingConstants.CENTER);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                } else {
                    super.setHorizontalAlignment(SwingConstants.LEFT);
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return this;
                }
            }
        });
        table4_1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table4_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { table4_1MouseClicked(evt); }
        });
        table4_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table4_1KeyPressed(evt);
            }
        });
        tm4_1.setTable(table4_1);
        table4_1.setEnabled(false);

        label4_1 = new JLabel("№ поїзда:");
        this.add(label4_1);
        label4_1.setBounds(320, 353, 55, 15);
        label4_1.setEnabled(false);

        textField4_1 = new JTextField("");
        this.add(textField4_1);
        textField4_1.setBounds(380, 350, 50, 20);
        textField4_1.setEnabled(false);

        comboBox4_1 = new JComboBox<>(new String[]{"Пасажирський", "Приміський", "Вантажний"});
        this.add(comboBox4_1);
        comboBox4_1.setBounds(320, 380, 110, 20);
        comboBox4_1.setEnabled(false);

        label4_2 = new JLabel("Час затримки:");
        this.add(label4_2);
        label4_2.setBounds(320, 410, 75, 15);
        label4_2.setEnabled(false);

        textField4_2 = new JTextField("0");
        this.add(textField4_2);
        textField4_2.setBounds(320, 430, 25, 20);
        textField4_2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField4_2.setEnabled(false);

        label4_3 = new JLabel(":");
        this.add(label4_3);
        label4_3.setBounds(350, 433, 5, 15);
        label4_3.setEnabled(false);

        textField4_3 = new JTextField("00");
        this.add(textField4_3);
        textField4_3.setBounds(358, 430, 20, 20);
        textField4_3.setEnabled(false);

        button4_Add = new JButton("Додати");
        this.add(button4_Add);
        button4_Add.setBounds(440, 420, 130, 30);
        button4_Add.addActionListener(this::button4_AddActionPerformed);
        button4_Add.setEnabled(false);

        button4_DeleteSelected = new JButton("Видалити обраний");
        this.add(button4_DeleteSelected);
        button4_DeleteSelected.setBounds(590, 420, 130, 30);
        button4_DeleteSelected.addActionListener(this::button4_DeleteSelectedActionPerformed);
        button4_DeleteSelected.setEnabled(false);



        checkBox5 = new JCheckBox("Брак", false);
        this.add(checkBox5);
        checkBox5.setBounds(410, 30, 50, 25);
        checkBox5.addActionListener(this::checkBox5ActionPerformed);

        label5_1 = new JLabel("Брак");
        this.add(label5_1);
        label5_1.setBounds(10, 463, 25, 15);
        label5_1.setEnabled(false);

        comboBox5_1 = new JComboBox<>(new String[]{"особливого обліку", "інший"});
        this.add(comboBox5_1);
        comboBox5_1.setBounds(40, 460, 120, 20);
        comboBox5_1.setEnabled(false);



        checkBox6 = new JCheckBox("Наслідки за гірочними системами", false);
        this.add(checkBox6);
        checkBox6.setBounds(410, 50, 200, 25);
        checkBox6.addActionListener(this::checkBox6ActionPerformed);

        label6_1 = new JLabel("Наслідки за гірочними системами:");
        this.add(label6_1);
        label6_1.setBounds(10, 493, 170, 15);
        label6_1.setEnabled(false);

        checkBox6_1 = new JCheckBox("Бій вагонів", false);
        this.add(checkBox6_1);
        checkBox6_1.setBounds(200, 490, 80, 25);
        checkBox6_1.setEnabled(false);

        checkBox6_2 = new JCheckBox("Запуск", false);
        this.add(checkBox6_2);
        checkBox6_2.setBounds(300, 490, 70, 25);
        checkBox6_2.setEnabled(false);

        checkBox6_3 = new JCheckBox("Загублено документацію", false);
        this.add(checkBox6_3);
        checkBox6_3.setBounds(400, 490, 160, 25);
        checkBox6_3.setEnabled(false);



        checkBox7 = new JCheckBox("Інші", false);
        this.add(checkBox7);
        checkBox7.setBounds(410, 70, 50, 25);



        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 100, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        buttonNext = new JButton("Далі");
        this.add(buttonNext);
        buttonNext.setBounds(690, 530, 100, 30);
        buttonNext.setIcon(new ImageIcon("src/ua/andrewblake/resources/Next.png"));
        buttonNext.addActionListener(this::buttonNextActionPerformed);

        this.setVisible(false);

        GlobalSettings.setPanelIntroductionError2(this);

    }

    private void comboBox3_1ActionPerformed(java.awt.event.ActionEvent evt) {
        comboBox3_2.removeAllItems();
        if (comboBox3_1.getSelectedIndex() == 0) {
            comboBox3_2.addItem("Погаслі сигнальні вогні на 2-ох і більше розміщених підряд світлофорах на перегоні");
            comboBox3_2.addItem("Наявність дозволяючого вогню на прохідному світлофорі при зайнятій блок-дільниці");
            comboBox3_2.addItem("Неможливість зміни напрямку");
        } else {
            comboBox3_2.addItem("Неможливість закриття вихідного світлофора");
            comboBox3_2.addItem("Неможливість відкриття вихідного світлофора при вільній дільниці");
            comboBox3_2.addItem("Довільне отримання блокуючих сигналів");
            comboBox3_2.addItem("Неможливість подачі або отримання блокуючих сигналів");
        }
    }

    private void button4_AddActionPerformed(java.awt.event.ActionEvent evt) {
        if (textField4_1.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Не зазначено № поїзда");
        }
        try {
            int i = Integer.valueOf(textField4_2.getText());
            if (i < 0) {
                JOptionPane.showMessageDialog(null, "Нерпавильно введено години затримки поїзда");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Нерпавильно введено години затримки поїзда");
            return;
        }
        try {
            int i = Integer.valueOf(textField4_3.getText());
            if ((i < 0) || (i > 59)) {
                JOptionPane.showMessageDialog(null, "Нерпавильно введено хвилини затримки поїзда");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Нерпавильно введено хвилини затримки поїзда");
            return;
        }
        if (Integer.valueOf(textField4_2.getText()) + Integer.valueOf(textField4_3.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Зазначено нульовий час затримки поїзда");
            return;
        }
        if (textField4_3.getText().length() == 1) {
            textField4_3.setText("0".concat(textField4_3.getText()));
        }
        tm4_1.setValueAt(textField4_1.getText(), tm4_1.getCountOfTrains(), 0);
        tm4_1.setValueAt(comboBox4_1.getSelectedItem(), tm4_1.getCountOfTrains(), 1);
        tm4_1.setValueAt(textField4_2.getText(), tm4_1.getCountOfTrains(), 2);
        tm4_1.setValueAt(textField4_3.getText(), tm4_1.getCountOfTrains(), 3);
        tm4_1.recalculationCountOfTrains();
        textField4_1.setText("");
        textField4_2.setText("0");
        textField4_3.setText("00");

    }

    private void button4_DeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {
        if (isSelectedTable4_1) {
            tm4_1.setValueAt(new String(""), selectedRowTable4_1, 0);
            tm4_1.setValueAt(new String(""), selectedRowTable4_1, 1);
            tm4_1.setValueAt(new String(""), selectedRowTable4_1, 2);
            tm4_1.setValueAt(new String(""), selectedRowTable4_1, 3);
            tm4_1.recalculationCountOfTrains();
        } else {
            JOptionPane.showMessageDialog(null, "Не обрано жодного запису");
        }
    }

    private void table4_1MouseClicked(java.awt.event.MouseEvent evt) {
        JTable target = (JTable) evt.getSource();
        selectedRowTable4_1 = target.getSelectedRow();
        isSelectedTable4_1 = true;
    }

    private void table4_1KeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            table4_1.getSelectionModel().clearSelection();
            isSelectedTable4_1 = false;
        }
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        GlobalSettings.getPanelIntroductionError().setVisible(true);
        this.setVisible(false);
    }

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {

        if (!canContinue()) {
            return;
        }

        this.setVisible(false);
        GlobalSettings.getPanelIntroductionError3().setVisible(true);

    }

    private void checkBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        label1_1.setEnabled(checkBox1.isSelected());
        textField1_1.setEnabled(checkBox1.isSelected());
        comboBox1_1.setEnabled(checkBox1.isSelected());
        label1_2.setEnabled(checkBox1.isSelected());
        textField1_2.setEnabled(checkBox1.isSelected());
    }

    private void checkBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        label2_1.setEnabled(checkBox2.isSelected());
        scrollPane2_1.setEnabled(checkBox2.isSelected());
        table2_1.setEnabled(checkBox2.isSelected());
    }

    private void checkBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        label3_1.setEnabled(checkBox3.isSelected());
        comboBox3_1.setEnabled(checkBox3.isSelected());
        comboBox3_2.setEnabled(checkBox3.isSelected());
    }

    private void checkBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        scrollPane4_1.setEnabled(checkBox4.isSelected());
        table4_1.setEnabled(checkBox4.isSelected());
        label4_1.setEnabled(checkBox4.isSelected());
        textField4_1.setEnabled(checkBox4.isSelected());
        comboBox4_1.setEnabled(checkBox4.isSelected());
        label4_2.setEnabled(checkBox4.isSelected());
        textField4_2.setEnabled(checkBox4.isSelected());
        label4_3.setEnabled(checkBox4.isSelected());
        textField4_3.setEnabled(checkBox4.isSelected());
        button4_Add.setEnabled(checkBox4.isSelected());
        button4_DeleteSelected.setEnabled(checkBox4.isSelected());
    }

    private void checkBox5ActionPerformed(java.awt.event.ActionEvent evt) {
        label5_1.setEnabled(checkBox5.isSelected());
        comboBox5_1.setEnabled(checkBox5.isSelected());
    }

    private void checkBox6ActionPerformed(java.awt.event.ActionEvent evt) {
        label6_1.setEnabled(checkBox6.isSelected());
        checkBox6_1.setEnabled(checkBox6.isSelected());
        checkBox6_2.setEnabled(checkBox6.isSelected());
        checkBox6_3.setEnabled(checkBox6.isSelected());
    }

    public void reset() {
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox5.setSelected(false);
        checkBox6.setSelected(false);
        checkBox7.setSelected(false);
        textField1_1.setText("");
        textField1_2.setText("");
        tm2_1 = new TableModel2_1();
        tm2_1.setTable(table2_1);
        table2_1.setModel(tm2_1);
        tm4_1 = new TableModel4_1();
        tm4_1.setTable(table4_1);
        table4_1.setModel(tm4_1);
        comboBox3_1.setSelectedIndex(0);
        comboBox3_2.setSelectedIndex(0);
        textField4_1.setText("");
        textField4_2.setText("0");
        textField4_3.setText("00");
        comboBox5_1.setSelectedIndex(0);
        checkBox6_1.setSelected(false);
        checkBox6_2.setSelected(false);
        checkBox6_3.setSelected(false);
        checkBox1ActionPerformed(null);
        checkBox2ActionPerformed(null);
        checkBox3ActionPerformed(null);
        checkBox4ActionPerformed(null);
        checkBox5ActionPerformed(null);
        checkBox6ActionPerformed(null);
    }

    @Override
    public boolean canContinue() {
        if (checkBox1.isSelected()) {
            if (textField1_1.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Не зазначено сигнал, який перекрився");
                return false;
            }
            if (textField1_2.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Не зазначено № поїзда, якому перекрився сигнал");
                return false;
            }
        }
        if ((checkBox2.isSelected()) && (table2_1.getRowCount() == 1)) {
            JOptionPane.showMessageDialog(null, "Не введено жодного поїзда в таблицю прийнятих (відправлених) за наказом (запрошуючим сигналом)");
            return false;
        }
        if ((checkBox4.isSelected()) && (table4_1.getRowCount() == 1)) {
            JOptionPane.showMessageDialog(null, "Не введено жодного поїзда в таблицю затриманих поїздів");
            return false;
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        simple = GlobalSettings.getPanelIntroductionError().getSimple(null);
        if ((checkBox1.isSelected()) || (checkBox2.isSelected()) || (checkBox3.isSelected()) || (checkBox4.isSelected()) || (checkBox5.isSelected()) || (checkBox6.isSelected()) || (checkBox7.isSelected())) {
            ArrayList<String> tempArray = new ArrayList<>();
            tempArray.add("Наслідки:");
            if (checkBox1.isSelected()) {
                tempArray.add("\t".concat(label1_1.getText()).concat(" ").concat(textField1_1.getText()).concat(" ").concat((String) comboBox1_1.getSelectedItem()).concat(" ").concat(label1_2.getText()).concat(textField1_2.getText()).concat(";"));
            }
            if (checkBox2.isSelected()) {
                tempArray.add("\t".concat(label2_1.getText()));
                for (int i = 0; i < table2_1.getRowCount() - 1; i++) {
                    tempArray.add("\t\t".concat(((String) table2_1.getValueAt(i, 0)).trim()));
                }
            }
            if (checkBox3.isSelected()) {
                tempArray.add("\t".concat(label3_1.getText()).concat("   ").concat((String) comboBox3_1.getSelectedItem()).concat(" - ").concat((String) comboBox3_2.getSelectedItem()).concat(";"));
            }
            if (checkBox4.isSelected()) {
                tempArray.add("\tЗатримки поїздів");
                for (int i = 0; i < table4_1.getRowCount() - 1; i++) {
                    tempArray.add("\t\t".concat("№ поїзда: ").concat(((String) table4_1.getValueAt(i, 0)).trim()).concat("     Категорія: ").concat(((String) table4_1.getValueAt(i, 1)).trim()).concat("     Час затримки: ").concat((String) table4_1.getValueAt(i, 2)));
                }
            }
            if (checkBox5.isSelected()) {
                tempArray.add("\t".concat(label5_1.getText()).concat(" ").concat((String) comboBox5_1.getSelectedItem()).concat(";"));
            }
            if (checkBox6.isSelected()) {
                if ((!checkBox6_1.isSelected()) && (!checkBox6_2.isSelected()) && (!checkBox6_3.isSelected())) {
                    tempArray.add("\t".concat("Наслідки за гірочними системами;"));
                } else {
                    tempArray.add("\t".concat("Наслідки за гірочними системами:"));
                    if (checkBox6_1.isSelected()) {
                        tempArray.add("\t\t".concat(checkBox6_1.getText()));
                    }
                    if (checkBox6_2.isSelected()) {
                        tempArray.add("\t\t".concat(checkBox6_2.getText()));
                    }
                    if (checkBox6_3.isSelected()) {
                        tempArray.add("\t\t".concat(checkBox6_3.getText()));
                    }
                }
            }
            if (checkBox7.isSelected()) {
                tempArray.add("\t".concat(checkBox7.getText()).concat(";"));
            }

            String[] newSimple = new String[simple.length + tempArray.size()];
            for (int i = 0; i < newSimple.length; i++) {
                if (i < simple.length) {
                    newSimple[i] = simple[i];
                } else {
                    newSimple[i] = tempArray.get(i - simple.length);
                }
            }
            simple = newSimple;
        }
        return simple;
    }

    @Override
    public Stat getParams(Stat stat) {
        stat = GlobalSettings.getPanelIntroductionError().getParams(GlobalSettings.getCurrentStat());
        String[] params = new String[16];
        params[0] = String.valueOf(checkBox1.isSelected());
        params[1] = String.valueOf(checkBox2.isSelected());
        params[2] = String.valueOf(checkBox3.isSelected());
        params[3] = String.valueOf(checkBox4.isSelected());
        params[4] = String.valueOf(checkBox5.isSelected());
        params[5] = String.valueOf(checkBox6.isSelected());
        params[6] = String.valueOf(checkBox7.isSelected());
        if (checkBox1.isSelected()) {
            params[7] = textField1_1.getText();
            params[8] = String.valueOf(comboBox1_1.getSelectedIndex());
            params[9] = textField1_2.getText();
        }
        if (checkBox2.isSelected()) {
            stat.tableModel2_1 = tm2_1;
        }
        if (checkBox3.isSelected()) {
            params[10] = String.valueOf(comboBox3_1.getSelectedIndex());
            params[11] = String.valueOf(comboBox3_2.getSelectedIndex());
        }
        if (checkBox4.isSelected()) {
            stat.tableModel4_1 = tm4_1;
        }
        if (checkBox5.isSelected()) {
            params[12] = String.valueOf(comboBox5_1.getSelectedIndex());
        }
        if (checkBox6.isSelected()) {
            params[13] = String.valueOf(checkBox6_1.isSelected());
            params[14] = String.valueOf(checkBox6_2.isSelected());
            params[15] = String.valueOf(checkBox6_3.isSelected());
        }
        stat.paramsPanelIntroductionError2 = params;
        stat.simpleRecord = getSimple(null);
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        String[] params = stat.paramsPanelIntroductionError2;
        checkBox1.setSelected(Boolean.valueOf(params[0]));
        checkBox2.setSelected(Boolean.valueOf(params[1]));
        checkBox3.setSelected(Boolean.valueOf(params[2]));
        checkBox4.setSelected(Boolean.valueOf(params[3]));
        checkBox5.setSelected(Boolean.valueOf(params[4]));
        checkBox6.setSelected(Boolean.valueOf(params[5]));
        checkBox7.setSelected(Boolean.valueOf(params[6]));
        if (checkBox1.isSelected()) {
            textField1_1.setText(params[7]);
            comboBox1_1.setSelectedIndex(Integer.valueOf(params[8]));
            textField1_2.setText(params[9]);
        } else {
            textField1_1.setText("");
            comboBox1_1.setSelectedIndex(0);
            textField1_2.setText("");
        }
        if (checkBox2.isSelected()) {
            tm2_1 = stat.tableModel2_1;
            table2_1.setModel(tm2_1);
        }
        if (checkBox3.isSelected()) {
            comboBox3_1.setSelectedIndex(Integer.valueOf(params[10]));
            comboBox3_2.setSelectedIndex(Integer.valueOf(params[11]));
        }
        if (checkBox4.isSelected()) {
            tm4_1 = stat.tableModel4_1;
            table4_1.setModel(tm4_1);
        }
        if (checkBox5.isSelected()) {
            comboBox5_1.setSelectedIndex(Integer.valueOf(params[12]));
        } else {
            comboBox5_1.setSelectedIndex(0);
        }
        if (checkBox6.isSelected()) {
            checkBox6_1.setSelected(Boolean.valueOf(params[13]));
            checkBox6_2.setSelected(Boolean.valueOf(params[14]));
            checkBox6_3.setSelected(Boolean.valueOf(params[15]));
        } else {
            checkBox6_1.setSelected(false);
            checkBox6_2.setSelected(false);
            checkBox6_3.setSelected(false);
        }
        checkBox1ActionPerformed(null);
        checkBox2ActionPerformed(null);
        checkBox3ActionPerformed(null);
        checkBox4ActionPerformed(null);
        checkBox5ActionPerformed(null);
        checkBox6ActionPerformed(null);
    }
}
