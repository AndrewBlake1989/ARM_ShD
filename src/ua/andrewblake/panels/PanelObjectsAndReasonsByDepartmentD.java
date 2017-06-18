package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

class PanelObjectsAndReasonsByDepartmentD extends JPanel implements GetData{

    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField textField;

    PanelObjectsAndReasonsByDepartmentD() {

        this.setSize(800, 280);
        this.setLayout(null);

        comboBox1 = new JComboBox<>(new String[]{"Неправильне користування", "Поріз стрілки", "Інші причини"});
        this.add(comboBox1);
        comboBox1.setBounds(10, 10, 170, 20);
        comboBox1.addActionListener(this::comboBox1ActionPerformed);

        comboBox2 = new JComboBox<>(new String[]{"Обрив рейкових з'єднувачів", "Інша"});
        this.add(comboBox2);
        comboBox2.setBounds(190, 10, 170, 20);
        comboBox2.setVisible(false);
        comboBox2.addActionListener(this::comboBox2ActionPerformed);

        textField = new JTextField();
        this.add(textField);
        textField.setBounds(370, 10, 410, 20);
        textField.setVisible(false);

        this.setVisible(true);

    }

    private void comboBox1ActionPerformed(ActionEvent evt) {
        switch (comboBox1.getSelectedIndex()) {
            case 2:
                comboBox2.setVisible(true);
                break;
            default:
                comboBox2.setVisible(false);
                textField.setVisible(false);
                break;
        }
    }

    private void comboBox2ActionPerformed(ActionEvent evt) {
        switch (comboBox2.getSelectedIndex()) {
            case 0:
                textField.setVisible(false);
                break;
            case 1:
                textField.setVisible(true);
                textField.setText("");
                break;
        }
    }

    @Override
    public boolean canContinue() {
        if (textField.isVisible()) {
            if (textField.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Не вказано конкретну причину");
                return false;
            }
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Відповідальна служба - Д;");
        String temp = (String) comboBox1.getSelectedItem();
        if (comboBox2.isVisible()) {
            temp = temp.concat(" - ").concat((String) comboBox2.getSelectedItem());
        }
        if (textField.isVisible()) {
            temp = temp.concat(" - ").concat(textField.getText());
        }
        tempArray.add(temp.concat(";"));

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
        paramsList.add(new String[]{"comboBox1", String.valueOf(comboBox1.getSelectedIndex())});
        if (comboBox2.isVisible()) {
            paramsList.add(new String[]{"comboBox2", String.valueOf(comboBox2.getSelectedIndex())});
        }
        if (textField.isVisible()) {
            paramsList.add(new String[]{"textField", textField.getText()});
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
                case "comboBox1":
                    comboBox1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBox2":
                    comboBox2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textField":
                    textField.setText(s[1]);
                    break;
            }
        }
    }
}
