package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;

import javax.swing.*;
import java.util.ArrayList;

class PanelObjectsAndReasonsByDepartmentE extends JPanel implements GetData {

    private JComboBox<String> comboBox1;

    PanelObjectsAndReasonsByDepartmentE() {

        this.setSize(800, 280);
        this.setLayout(null);

        comboBox1 = new JComboBox<>(new String[]{"Відсутність електроенергії", "Відхилення від номінальної напруги"});
        this.add(comboBox1);
        comboBox1.setBounds(10, 10, 210, 20);

        this.setVisible(true);

    }

    @Override
    public boolean canContinue() {
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Відповідальна служба - Е;");
        tempArray.add("Причина: ".concat((String) comboBox1.getSelectedItem()).concat(";"));

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
        stat.paramsPanelObjectsAndReasons = new String[][]{{String.valueOf(comboBox1.getSelectedIndex())}, {}};
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        comboBox1.setSelectedIndex(Integer.valueOf(stat.paramsPanelObjectsAndReasons[0][0]));
    }
}
