package ua.andrewblake.utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AndrewBlake on 02.05.2017.
 */
public class SortComponents {

    public SortComponents() {
        // NOP
    }

    public static ArrayList<Component> sort(ArrayList<Component> components) {
        ArrayList<Component> components1 = new ArrayList<>();
        while (!components.isEmpty()) {
            Component minComponent = components.get(0);
            int tempJ = 0;
            for (int j = 0; j < components.size(); j++) {
                if (components.get(j).getY() - minComponent.getY() < 5) {
                    minComponent = components.get(j);
                    tempJ = j;
                }
            }
            components1.add(components.get(tempJ));
            components.remove(tempJ);
        }
        for (int j = 0; j < components1.size() - 1; j++) {
            for (int i = 0; i < components1.size() - 1; i++) {
                if ((components1.get(i + 1).getX() < components1.get(i).getX()) && (Math.abs(components1.get(i).getY() - components1.get(i + 1).getY()) < 5)) {
                    Component tempComponent = components1.get(i);
                    components1.remove(i);
                    components1.add(i + 1, tempComponent);
                }
            }
        }
        return components1;
    }

    public static String sortAndWrite(ArrayList<Component> components) {
        ArrayList<Component> components1 = new ArrayList<>();
        while (!components.isEmpty()) {
            Component minComponent = components.get(0);
            int tempJ = 0;
            for (int j = 0; j < components.size(); j++) {
                if (components.get(j).getY() - minComponent.getY() < 5) {
                    minComponent = components.get(j);
                    tempJ = j;
                }
            }
            components1.add(components.get(tempJ));
            components.remove(tempJ);
        }
        for (int j = 0; j < components1.size() - 1; j++) {
            for (int i = 0; i < components1.size() - 1; i++) {
                if ((components1.get(i + 1).getX() < components1.get(i).getX()) && (Math.abs(components1.get(i).getY() - components1.get(i + 1).getY()) < 5)) {
                    Component tempComponent = components1.get(i);
                    components1.remove(i);
                    components1.add(i + 1, tempComponent);
                }
            }
        }

        components = components1;
        String result = "";
        for (Component component : components) {
            if (component instanceof JLabel) {
                result = result.concat(((JLabel) component).getText()).concat(" ");
                continue;
            }
            if (component instanceof JTextField) {
                result = result.concat(((JTextField) component).getText()).concat(" ");
                continue;
            }
            if (component instanceof JComboBox) {
                result = result.concat((String) ((JComboBox) component).getSelectedItem()).concat(" ");
                continue;
            }
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
