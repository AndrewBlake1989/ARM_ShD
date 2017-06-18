package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.utils.SortComponents;
import ua.andrewblake.utils.StringModels;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PanelObjectsAndReasonsByDepartmentP extends JPanel implements GetData {

    private JComboBox<String> comboBoxListPCh;
    private JLabel labelObject;
    private JComboBox<String> comboBoxObject;
    private JLabel labelElement;
    private JComboBox<String> comboBoxElement;
    private JComboBox<String> comboBoxElement_additionally1;
    private JLabel labelReason;
    private JComboBox<String> comboBoxReason;
    private JTextField textFieldReason_additionally1;
    private JTextField textFieldReason_additionally2;
    private JTextField textFieldReason_additionally3;
    private JLabel labelReason_additionally1;
    private JLabel labelReason_additionally2;
    private JLabel labelReason_additionally3;
    private JComboBox<String> comboBoxReason_additionally1;

    PanelObjectsAndReasonsByDepartmentP(){

        this.setSize(800, 280);
        this.setLayout(null);

        comboBoxListPCh = new JComboBox<>(StringModels.getListPCh());
        this.add(comboBoxListPCh);
        comboBoxListPCh.setBounds(10, 10, 60, 20);
        comboBoxListPCh.addActionListener(this::comboBoxListPChActionPerformed);

        labelObject = new JLabel("Об'єкт:");
        this.add(labelObject);
        labelObject.setBounds(80, 13, 40, 15);
        labelObject.setVisible(false);

        comboBoxObject = new JComboBox<>(new String[]{"-", "Рейкове коло", "Стрілка", "Інша причина"});
        this.add(comboBoxObject);
        comboBoxObject.setBounds(120, 10, 100, 20);
        comboBoxObject.setVisible(false);
        comboBoxObject.addActionListener(this::comboBoxObjectActionPerformed);
        comboBoxObject.setName("comboBoxObject");

        labelElement = new JLabel("Елемент:");
        this.add(labelElement);
        labelElement.setBounds(230, 13, 50, 15);
        labelElement.setVisible(false);

        comboBoxElement = new JComboBox<>();
        this.add(comboBoxElement);
        comboBoxElement.setBounds(280, 10, 200, 20);
        comboBoxElement.setVisible(false);
        comboBoxElement.addActionListener(this::comboBoxElementActionPerformed);
        comboBoxElement.setName("comboBoxElement");

        comboBoxElement_additionally1 = new JComboBox<>();
        this.add(comboBoxElement_additionally1);
        comboBoxElement_additionally1.setVisible(false);
        comboBoxElement_additionally1.setName("comboBoxElement_additionally1");

        labelReason = new JLabel("Причина:");
        this.add(labelReason);
        labelReason.setBounds(10, 43, 50, 15);
        labelReason.setVisible(false);

        comboBoxReason = new JComboBox<>();
        this.add(comboBoxReason);
        comboBoxReason.setBounds(60, 40, 300, 20);
        comboBoxReason.setVisible(false);
        comboBoxReason.addActionListener(this::comboBoxReasonActionPerformed);
        comboBoxReason.setName("comboBoxReason");

        textFieldReason_additionally1 = new JTextField();
        this.add(textFieldReason_additionally1);
        textFieldReason_additionally1.setVisible(false);
        textFieldReason_additionally1.setName("textFieldReason_additionally1");

        textFieldReason_additionally2 = new JTextField();
        this.add(textFieldReason_additionally2);
        textFieldReason_additionally2.setVisible(false);
        textFieldReason_additionally2.setName("textFieldReason_additionally2");

        textFieldReason_additionally3 = new JTextField();
        this.add(textFieldReason_additionally3);
        textFieldReason_additionally3.setVisible(false);
        textFieldReason_additionally3.setName("textFieldReason_additionally3");

        labelReason_additionally1 = new JLabel();
        this.add(labelReason_additionally1);
        labelReason_additionally1.setVisible(false);

        labelReason_additionally2 = new JLabel();
        this.add(labelReason_additionally2);
        labelReason_additionally2.setVisible(false);

        labelReason_additionally3 = new JLabel();
        this.add(labelReason_additionally3);
        labelReason_additionally3.setVisible(false);

        comboBoxReason_additionally1 = new JComboBox<>();
        this.add(comboBoxReason_additionally1);
        comboBoxReason_additionally1.setVisible(false);
        comboBoxReason_additionally1.setName("comboBoxReason_additionally1");

        this.setVisible(true);

    }

    private void comboBoxListPChActionPerformed(java.awt.event.ActionEvent evt) {
        if (comboBoxListPCh.getSelectedIndex() == 0) {
            labelObject.setVisible(false);
            comboBoxObject.setVisible(false);
            labelElement.setVisible(false);
            comboBoxElement.removeAllItems();
            comboBoxElement.setVisible(false);
            comboBoxElement_additionally1.removeAllItems();
            comboBoxElement_additionally1.setVisible(false);
        } else {
            labelObject.setVisible(true);
            comboBoxObject.setVisible(true);
        }
    }

    private void comboBoxObjectActionPerformed(java.awt.event.ActionEvent evt) {
        labelElement.setVisible(false);
        comboBoxElement.removeAllItems();
        comboBoxElement.setVisible(false);
        labelReason.setVisible(false);
        comboBoxReason.removeAllItems();
        comboBoxReason.setVisible(false);
        textFieldReason_additionally1.setText("");
        textFieldReason_additionally1.setVisible(false);
        textFieldReason_additionally2.setText("");
        textFieldReason_additionally2.setVisible(false);
        textFieldReason_additionally3.setText("");
        textFieldReason_additionally3.setVisible(false);
        labelReason_additionally1.setVisible(false);
        labelReason_additionally2.setVisible(false);
        labelReason_additionally3.setVisible(false);
        comboBoxReason_additionally1.removeAllItems();
        comboBoxReason_additionally1.setVisible(false);
        switch (comboBoxObject.getSelectedIndex()) {
            case 0:
                labelElement.setVisible(false);
                comboBoxElement.removeAllItems();
                comboBoxElement.setVisible(false);
                comboBoxElement_additionally1.removeAllItems();
                comboBoxElement_additionally1.setVisible(false);
                break;
            case 1: // Рейкове коло
                labelElement.setVisible(true);
                comboBoxElement.addItem("Рейковий з'єднувач");
                comboBoxElement.addItem("Ізостик");
                comboBoxElement.addItem("Пониження ізоляції баласту");
                comboBoxElement.addItem("Перемичка");
                comboBoxElement.addItem("Інші причини");
                comboBoxElement.setVisible(true);
                break;
            case 2: // Стрілка
                labelElement.setVisible(true);
                comboBoxElement.addItem("Тяга");
                comboBoxElement.addItem("Сережка");
                comboBoxElement.addItem("Стягуюча полоса");
                comboBoxElement.addItem("Вістряк");
                comboBoxElement.addItem("Кореневі болти");
                comboBoxElement.addItem("Стрілочна гарнітура");
                comboBoxElement.setVisible(true);
                labelReason.setVisible(true);
                comboBoxReason.addItem("Пробита ізоляція");
                comboBoxReason.addItem("Заклинювання");
                comboBoxReason.addItem("Механічне пошкодження під час виконання робіт");
                comboBoxReason.setVisible(true);
                break;
            case 3: // Інша причина
                textFieldReason_additionally1.setBounds(230, 10, 550, 20);
                textFieldReason_additionally1.setVisible(true);
                textFieldReason_additionally1.setText("");
                break;
        }
    }

    private void comboBoxElementActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxElement_additionally1.removeAllItems();
        comboBoxElement_additionally1.setVisible(false);
        if (comboBoxObject.getSelectedIndex() != 2) {
            comboBoxReason.removeAllItems();
            comboBoxReason.setVisible(false);
            labelReason.setVisible(false);
            textFieldReason_additionally1.setText("");
            textFieldReason_additionally1.setVisible(false);
            textFieldReason_additionally2.setText("");
            textFieldReason_additionally2.setVisible(false);
            textFieldReason_additionally3.setText("");
            textFieldReason_additionally3.setVisible(false);
            labelReason_additionally1.setVisible(false);
            labelReason_additionally2.setVisible(false);
            labelReason_additionally3.setVisible(false);
            comboBoxReason_additionally1.removeAllItems();
            comboBoxReason_additionally1.setVisible(false);
        }
        switch (comboBoxObject.getSelectedIndex()) {
            case 1: // Рейкове коло
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // Рейковий з'єднувач
                        labelReason.setVisible(true);
                        comboBoxReason.addItem("Обрив");
                        comboBoxReason.addItem("Відсутність");
                        comboBoxReason.addItem("Втрата контакту в тарілчаній шайбі");
                        comboBoxReason.addItem("Обрив рейкового з'єднувача під час колійних робіт");
                        comboBoxReason.setVisible(true);
                        break;
                    case 1: // Ізостик
                        labelReason.setVisible(true);
                        comboBoxReason.addItem("Порушення ізоляції");
                        comboBoxReason.addItem("Несправний клеєболтовий");
                        comboBoxReason.addItem("Несправний надміцний");
                        comboBoxReason.addItem("Закорочування");
                        comboBoxReason.setVisible(true);
                        break;
                    case 2: // Пониження ізоляції баласту
                        labelReason.setVisible(true);
                        labelReason_additionally1.setBounds(60, 43, 40, 15);
                        labelReason_additionally1.setText("R(б) =");
                        labelReason_additionally1.setVisible(true);
                        textFieldReason_additionally1.setBounds(100, 40, 50, 20);
                        textFieldReason_additionally1.setVisible(true);
                        labelReason_additionally2.setBounds(155, 43, 20, 15);
                        labelReason_additionally2.setText("Ом");
                        labelReason_additionally2.setVisible(true);
                        break;
                    case 3: // Перемичка
                        comboBoxElement_additionally1.setBounds(490, 10, 100, 20);
                        comboBoxElement_additionally1.addItem("дросельна");
                        comboBoxElement_additionally1.addItem("міждросельна");
                        comboBoxElement_additionally1.addItem("джемперна");
                        comboBoxElement_additionally1.addItem("інша");
                        comboBoxElement_additionally1.setVisible(true);
                        labelReason.setVisible(true);
                        comboBoxReason.addItem("Обрив");
                        comboBoxReason.addItem("Обрив під час колійних робіт");
                        comboBoxReason.addItem("Закорочування під час колійних робіт");
                        comboBoxReason.addItem("Інша причина");
                        comboBoxReason.setVisible(true);
                        break;
                    case 4: // Інші причини
                        labelReason.setVisible(true);
                        comboBoxReason.addItem("Закорочування рейкового кола під час робіт");
                        comboBoxReason.addItem("Закорочування рейкового кола стороннім предметом");
                        comboBoxReason.addItem("Зламалась (тріснула) рейка");
                        comboBoxReason.addItem("Інша причина");
                        comboBoxReason.addItem("Нез'ясована причина");
                        comboBoxReason.setVisible(true);
                        break;
                }
                break;
            case 2: // Стрілка
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // Тяга
                        comboBoxElement_additionally1.setBounds(490, 10, 100, 20);
                        comboBoxElement_additionally1.addItem("робоча");
                        comboBoxElement_additionally1.addItem("контрольна");
                        comboBoxElement_additionally1.addItem("з'єднуюча");
                        comboBoxElement_additionally1.setVisible(true);
                        break;
                    case 1: // Сережка
                        comboBoxElement_additionally1.setBounds(490, 10, 120, 20);
                        comboBoxElement_additionally1.addItem("робочої тяги");
                        comboBoxElement_additionally1.addItem("з'єднуючої тяги");
                        comboBoxElement_additionally1.addItem("контрольної тяги");
                        comboBoxElement_additionally1.setVisible(true);
                        break;
                    case 3: // Вістряк
                        comboBoxElement_additionally1.setBounds(490, 10, 120, 20);
                        comboBoxElement_additionally1.addItem("лівий");
                        comboBoxElement_additionally1.addItem("правий");
                        comboBoxElement_additionally1.setVisible(true);
                        break;
                }
                break;
        }
        if (comboBoxReason.isVisible()) {
            comboBoxReasonActionPerformed(null);
        }
    }

    private void comboBoxReasonActionPerformed(java.awt.event.ActionEvent evt) {
        textFieldReason_additionally1.setText("");
        textFieldReason_additionally1.setVisible(false);
        textFieldReason_additionally2.setText("");
        textFieldReason_additionally2.setVisible(false);
        textFieldReason_additionally3.setText("");
        textFieldReason_additionally3.setVisible(false);
        labelReason_additionally1.setVisible(false);
        labelReason_additionally2.setVisible(false);
        labelReason_additionally3.setVisible(false);
        comboBoxReason_additionally1.removeAllItems();
        comboBoxReason_additionally1.setVisible(false);
        switch (comboBoxObject.getSelectedIndex()) {
            case 1: // Рейкове коло
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // Рейковий з'єднувач
                        switch (comboBoxReason.getSelectedIndex()) {
                            case 0: // Обрив
                            case 1: // Відсутність
                                textFieldReason_additionally1.setBounds(370, 40, 50, 20);
                                textFieldReason_additionally1.setVisible(true);
                                labelReason_additionally1.setBounds(425, 43, 20, 15);
                                labelReason_additionally1.setText("км.");
                                labelReason_additionally1.setVisible(true);
                                textFieldReason_additionally2.setBounds(455, 40, 50, 20);
                                textFieldReason_additionally2.setVisible(true);
                                labelReason_additionally2.setBounds(510, 43, 20, 15);
                                labelReason_additionally2.setText("пк");
                                labelReason_additionally2.setVisible(true);
                                textFieldReason_additionally3.setBounds(535, 40, 50, 20);
                                textFieldReason_additionally3.setVisible(true);
                                labelReason_additionally3.setBounds(590, 43, 20, 15);
                                labelReason_additionally3.setText("шт.");
                                labelReason_additionally3.setVisible(true);
                                break;
                        }
                        break;
                    case 2: // Ізостик
                        switch (comboBoxReason.getSelectedIndex()) {
                            case 1: // Несправний клеєболтовий
                                comboBoxReason_additionally1.setBounds(370, 40, 100, 20);
                                comboBoxReason_additionally1.addItem("біля сигналу");
                                comboBoxReason_additionally1.addItem("на стрілці");
                                comboBoxReason_additionally1.addItem("між секціями");
                                comboBoxReason_additionally1.setVisible(true);
                                textFieldReason_additionally1.setBounds(480, 40, 100, 20);
                                textFieldReason_additionally1.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Інша причина
                        switch (comboBoxReason.getSelectedIndex()) {
                            case 0: // Закорочення рейкового кола
                                comboBoxReason_additionally1.setBounds(370, 40, 190, 20);
                                comboBoxReason_additionally1.addItem("під час виконання робіт");
                                comboBoxReason_additionally1.addItem("стороннім металевим предметом");
                                comboBoxReason_additionally1.addItem("інші");
                                comboBoxReason_additionally1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    @Override
    public boolean canContinue() {
        if (comboBoxListPCh.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вибрано дистанцію колії");
            return false;
        }
        if (comboBoxObject.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вказано об'єкт");
            return false;
        }
        if ((textFieldReason_additionally1.isVisible()) && (textFieldReason_additionally1.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
            return false;
        }
        if ((textFieldReason_additionally2.isVisible()) && (textFieldReason_additionally2.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
            return false;
        }
        if ((textFieldReason_additionally3.isVisible()) && (textFieldReason_additionally3.getText().trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
            return false;
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        ArrayList<String> tempArray = new ArrayList<>();
        ArrayList<Component> components = new ArrayList<>();
        tempArray.add("Відповідальна служба - П;");
        tempArray.add("Дистанція колії - ".concat((String) comboBoxListPCh.getSelectedItem()).concat(";"));
        tempArray.add("Об'єкт: ".concat((String) comboBoxObject.getSelectedItem()).concat(";"));
        if (comboBoxElement.isVisible()) {
            if (labelElement.isVisible()) {components.add(labelElement);}
            if (comboBoxElement.isVisible()) {components.add(comboBoxElement);}
            if (comboBoxElement_additionally1.isVisible()) {components.add(comboBoxElement_additionally1);}
            tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
            components.clear();
        }
        if (comboBoxReason.isVisible()) {
            if (labelReason.isVisible()) {components.add(labelReason);}
            if (comboBoxReason.isVisible()) {components.add(comboBoxReason);}
            if (textFieldReason_additionally1.isVisible()) {components.add(textFieldReason_additionally1);}
            if (textFieldReason_additionally2.isVisible()) {components.add(textFieldReason_additionally2);}
            if (textFieldReason_additionally3.isVisible()) {components.add(textFieldReason_additionally3);}
            if (labelReason_additionally1.isVisible()) {components.add(labelReason_additionally1);}
            if (labelReason_additionally2.isVisible()) {components.add(labelReason_additionally2);}
            if (labelReason_additionally3.isVisible()) {components.add(labelReason_additionally3);}
            if (comboBoxReason_additionally1.isVisible()) {components.add(comboBoxReason_additionally1);}
            tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
            components.clear();
        }
        if (comboBoxObject.getSelectedIndex() == 3) {
            tempArray.add(textFieldReason_additionally1.getText().concat(";"));
        }

        // Create array of this class:
        String[] newSimple = new String[simple.length + tempArray.size()];
        for (int i = 0; i < newSimple.length; i++) {
            if (i < simple.length) {
                newSimple[i] = simple[i];
            } else {
                newSimple[i] = tempArray.get(i - simple.length);
            }
        }
        return newSimple;
    }

    @Override
    public Stat getParams(Stat stat) {

        ArrayList<String[]> paramsList = new ArrayList<>();
        ArrayList<Component> components = new ArrayList<>();

        paramsList.add(new String[]{"comboBoxListPCh", String.valueOf(comboBoxListPCh.getSelectedIndex())});
        if (comboBoxObject.isVisible()) {components.add(comboBoxObject);}
        if (comboBoxElement.isVisible()) {components.add(comboBoxElement);}
        if (comboBoxElement_additionally1.isVisible()) {components.add(comboBoxElement_additionally1);}
        if (comboBoxReason.isVisible()) {components.add(comboBoxReason);}
        if (textFieldReason_additionally1.isVisible()) {components.add(textFieldReason_additionally1);}
        if (textFieldReason_additionally2.isVisible()) {components.add(textFieldReason_additionally2);}
        if (textFieldReason_additionally3.isVisible()) {components.add(textFieldReason_additionally3);}
        if (comboBoxReason_additionally1.isVisible()) {components.add(comboBoxReason_additionally1);}
        components = SortComponents.sort(components);
        for (Component c : components) {
            String[] temp = new String[2];
            temp[0] = c.getName();
            if (c instanceof JComboBox) {
                temp[1] = String.valueOf(((JComboBox) c).getSelectedIndex());
            }
            if (c instanceof JTextField) {
                temp[1] = ((JTextField) c).getText();
            }
            paramsList.add(temp);
        }
        String[][] params = new String[paramsList.size()][2];
        for (int i = 0; i < paramsList.size(); i++) {
            params[i] = paramsList.get(i);
        }
        stat.paramsPanelObjectsAndReasons = params;
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        String[][] params = stat.paramsPanelObjectsAndReasons;
        for (String[] s : params) {
            switch (s[0]) {
                case "comboBoxListPCh":
                    comboBoxListPCh.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxObject":
                    comboBoxObject.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxElement":
                    comboBoxElement.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxElement_additionally1":
                    comboBoxElement_additionally1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxReason":
                    comboBoxReason.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldReason_additionally1":
                    textFieldReason_additionally1.setText(s[1]);
                    break;
                case "textFieldReason_additionally2":
                    textFieldReason_additionally2.setText(s[1]);
                    break;
                case "textFieldReason_additionally3":
                    textFieldReason_additionally3.setText(s[1]);
                    break;
                case "comboBoxReason_additionally1":
                    comboBoxReason_additionally1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
            }
        }
    }
}
