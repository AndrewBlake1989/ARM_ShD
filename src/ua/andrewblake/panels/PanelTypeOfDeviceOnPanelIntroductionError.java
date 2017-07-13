package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.utils.SortComponents;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelTypeOfDeviceOnPanelIntroductionError extends JPanel implements GetData {

    private JSeparator separator;
    private JLabel labelTypeOfDevice;
    private JComboBox<String> comboBoxTypeOfDevice;
    private JLabel labelTypicalReason;
    private JComboBox<String> comboBoxTypicalReason;
    private JLabel labelTypicalReasonTemp1;
    private JLabel labelTypicalReasonTemp2;
    private JLabel labelTypicalReasonTemp3;
    private JComboBox<String> comboBoxTypicalReasonTemp1;
    private JComboBox<String> comboBoxTypicalReasonTemp2;
    private JTextField textFieldTypicalReasonTemp1;
    private JTextField textFieldTypicalReasonTemp2;

    PanelTypeOfDeviceOnPanelIntroductionError() {

        this.setSize(800, 70);
        this.setLayout(null);

        separator = new JSeparator(0);
        this.add(separator);
        separator.setBounds(0, 0, 800, 5);

        labelTypeOfDevice = new JLabel("Тип пристрою:");
        this.add(labelTypeOfDevice);
        labelTypeOfDevice.setBounds(10, 13, 75, 15);

        comboBoxTypeOfDevice = new JComboBox<>(StringModels.getTypesOfDevices());
        this.add(comboBoxTypeOfDevice);
        comboBoxTypeOfDevice.setBounds(90, 10, 70, 20);
        comboBoxTypeOfDevice.addActionListener(this::comboBoxTypeOfDeviceActionPerformed);

        labelTypicalReason = new JLabel("Характерна причина:");
        this.add(labelTypicalReason);
        labelTypicalReason.setBounds(185, 13, 110, 15);

        comboBoxTypicalReason = new JComboBox<>();
        this.add(comboBoxTypicalReason);
        comboBoxTypicalReason.setBounds(300, 10, 480, 20);
        comboBoxTypicalReason.addActionListener(this::comboBoxTypicalReasonActionPerformed);

        labelTypicalReasonTemp1 = new JLabel();
        this.add(labelTypicalReasonTemp1);
        labelTypicalReasonTemp1.setVisible(false);

        labelTypicalReasonTemp2 = new JLabel();
        this.add(labelTypicalReasonTemp2);
        labelTypicalReasonTemp2.setVisible(false);

        labelTypicalReasonTemp3 = new JLabel();
        this.add(labelTypicalReasonTemp3);
        labelTypicalReasonTemp3.setVisible(false);

        comboBoxTypicalReasonTemp1 = new JComboBox<>();
        this.add(comboBoxTypicalReasonTemp1);
        comboBoxTypicalReasonTemp1.setVisible(false);
        comboBoxTypicalReasonTemp1.addActionListener(this::comboBoxTypicalReasonTemp1ActionPerformed);
        comboBoxTypicalReasonTemp1.setName("comboBoxTypicalReasonTemp1");

        comboBoxTypicalReasonTemp2 = new JComboBox<>();
        this.add(comboBoxTypicalReasonTemp2);
        comboBoxTypicalReasonTemp2.setVisible(false);
        comboBoxTypicalReasonTemp2.setName("comboBoxTypicalReasonTemp2");

        textFieldTypicalReasonTemp1 = new JTextField();
        this.add(textFieldTypicalReasonTemp1);
        textFieldTypicalReasonTemp1.setVisible(false);
        textFieldTypicalReasonTemp1.setName("textFieldTypicalReasonTemp1");

        textFieldTypicalReasonTemp2 = new JTextField();
        this.add(textFieldTypicalReasonTemp2);
        textFieldTypicalReasonTemp2.setVisible(false);
        textFieldTypicalReasonTemp2.setName("textFieldTypicalReasonTemp2");

        this.setVisible(true);
    }

    private void comboBoxTypeOfDeviceActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxTypicalReason.removeAllItems();
        switch (comboBoxTypeOfDevice.getSelectedIndex()) {
            case 1:
                for (int i = 0; i < StringModels.getTypicalReasonForEC().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForEC()[i]);
                }
                break;
            case 2:
                for (int i = 0; i < StringModels.getTypicalReasonForKlZ().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForKlZ()[i]);
                }
                break;
            case 3:
                for (int i = 0; i < StringModels.getTypicalReasonForAB().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForAB()[i]);
                }
                break;
            case 4:
                for (int i = 0; i < StringModels.getTypicalReasonForNAB().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForNAB()[i]);
                }
                break;
            case 5:
                for (int i = 0; i < StringModels.getTypicalReasonForPS().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForPS()[i]);
                }
                break;
            case 6:
                for (int i = 0; i < StringModels.getTypicalReasonForGAC().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForGAC()[i]);
                }
                break;
            case 7:
                for (int i = 0; i < StringModels.getTypicalReasonForDC().length; i++) {
                    comboBoxTypicalReason.addItem(StringModels.getTypicalReasonForDC()[i]);
                }
                break;
        }
        comboBoxTypicalReasonActionPerformed(null);
    }

    private void comboBoxTypicalReasonActionPerformed(java.awt.event.ActionEvent evt) {
        labelTypicalReasonTemp1.setVisible(false);
        labelTypicalReasonTemp1.setText("");
        labelTypicalReasonTemp2.setVisible(false);
        labelTypicalReasonTemp2.setText("");
        labelTypicalReasonTemp3.setVisible(false);
        labelTypicalReasonTemp3.setText("");
        comboBoxTypicalReasonTemp1.setVisible(false);
        comboBoxTypicalReasonTemp1.removeAllItems();
        comboBoxTypicalReasonTemp2.setVisible(false);
        comboBoxTypicalReasonTemp2.removeAllItems();
        textFieldTypicalReasonTemp1.setVisible(false);
        textFieldTypicalReasonTemp1.setText("");
        textFieldTypicalReasonTemp2.setVisible(false);
        textFieldTypicalReasonTemp2.setText("");

        switch (comboBoxTypeOfDevice.getSelectedIndex()) {
            case 0:
                return;
            case 1: // ЕЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Не працює ЕЦ
                        labelTypicalReasonTemp1.setBounds(10, 43, 80, 15);
                        labelTypicalReasonTemp1.setText("Не працює ЕЦ");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(100, 40, 90, 20);
                        comboBoxTypicalReasonTemp1.addItem("повністю");
                        comboBoxTypicalReasonTemp1.addItem("горловина");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 2: // Несправжня зайнятість
                    case 3: // Несправжня вільність
                        comboBoxTypicalReasonTemp1.setBounds(10, 40, 90, 20);
                        comboBoxTypicalReasonTemp1.addItem("Секції");
                        comboBoxTypicalReasonTemp1.addItem("Колії");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(110, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 4: // Перекрився сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 70, 15);
                        labelTypicalReasonTemp1.setText("Перекрився");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(90, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("вхідний");
                        comboBoxTypicalReasonTemp1.addItem("вихідний");
                        comboBoxTypicalReasonTemp1.addItem("маршрутний");
                        comboBoxTypicalReasonTemp1.addItem("маневровий");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(200, 43, 40, 15);
                        labelTypicalReasonTemp2.setText("сигнал");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp2.setBounds(350, 40, 100, 20);
                        comboBoxTypicalReasonTemp2.addItem("з проїздом");
                        comboBoxTypicalReasonTemp2.addItem("без проїзду");
                        comboBoxTypicalReasonTemp2.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(460, 43, 50, 15);
                        labelTypicalReasonTemp3.setText("поїзду №");
                        labelTypicalReasonTemp3.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(515, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 5: // Не відкривається сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 100, 15);
                        labelTypicalReasonTemp1.setText("Не відкривається");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(110, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("вхідний");
                        comboBoxTypicalReasonTemp1.addItem("вихідний");
                        comboBoxTypicalReasonTemp1.addItem("маршрутний");
                        comboBoxTypicalReasonTemp1.addItem("маневровий");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(220, 43, 40, 15);
                        labelTypicalReasonTemp2.setText("сигнал");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(260, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(370, 43, 50, 15);
                        labelTypicalReasonTemp3.setText("поїзду №");
                        labelTypicalReasonTemp3.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(430, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 6: // Неможливо задати маршрут
                        labelTypicalReasonTemp1.setBounds(10, 43, 210, 15);
                        labelTypicalReasonTemp1.setText("Неможливо задати маршрут від сигналу");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(220, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(330, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("на");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(350, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("колію");
                        comboBoxTypicalReasonTemp1.addItem("перегін");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(460, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 7: // Неможливо розробити маршрут
                        labelTypicalReasonTemp1.setBounds(10, 43, 230, 15);
                        labelTypicalReasonTemp1.setText("Неможливо розробити маршрут від сигналу");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(350, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("на");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(370, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("колію");
                        comboBoxTypicalReasonTemp1.addItem("перегін");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(480, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp2.setBounds(590, 40, 100, 20);
                        comboBoxTypicalReasonTemp2.addItem("нормальним");
                        comboBoxTypicalReasonTemp2.addItem("штучним");
                        comboBoxTypicalReasonTemp2.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(700, 43, 50, 15);
                        labelTypicalReasonTemp3.setText("режимом");
                        labelTypicalReasonTemp3.setVisible(true);
                        break;
                    case 8: // Не переводиться стрілка
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Не переводиться стрілка №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(270, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("в");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(290, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem(" +");
                        comboBoxTypicalReasonTemp1.addItem(" -");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(400, 43, 70, 15);
                        labelTypicalReasonTemp3.setText("положення");
                        labelTypicalReasonTemp3.setVisible(true);
                        break;
                    case 9: // Стрілка втратила контроль положення
                        labelTypicalReasonTemp1.setBounds(10, 43, 70, 15);
                        labelTypicalReasonTemp1.setText("Стрілка №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(80, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(190, 43, 100, 15);
                        labelTypicalReasonTemp2.setText("втратила контроль");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(300, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem(" +");
                        comboBoxTypicalReasonTemp1.addItem(" -");
                        comboBoxTypicalReasonTemp1.addItem(" + i -");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(410, 43, 70, 15);
                        labelTypicalReasonTemp3.setText("положення");
                        labelTypicalReasonTemp3.setVisible(true);
                        break;
                    case 10: // Неможливість аварійного переводу стрілки
                        labelTypicalReasonTemp1.setBounds(10, 43, 240, 15);
                        labelTypicalReasonTemp1.setText("Неможливість аварійного переводу стрілки №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(250, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 12: // Вихід з ладу акумуляторної батареї
                        labelTypicalReasonTemp1.setBounds(10, 43, 210, 15);
                        labelTypicalReasonTemp1.setText("Вихід з ладу акумуляторної батареї при");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(220, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("наявності");
                        comboBoxTypicalReasonTemp1.addItem("відсутності");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(330, 43, 100, 15);
                        labelTypicalReasonTemp2.setText("фідера живлення");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                }
                break;
            case 2: // КлЗ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Несправжня зайнятість
                    case 2: // Несправжня вільність
                        comboBoxTypicalReasonTemp1.setBounds(10, 40, 90, 20);
                        comboBoxTypicalReasonTemp1.addItem("Секції");
                        comboBoxTypicalReasonTemp1.addItem("Колії");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(110, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 3: // Перекрився сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 70, 15);
                        labelTypicalReasonTemp1.setText("Перекрився");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(80, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("вхідний");
                        comboBoxTypicalReasonTemp1.addItem("вихідний");
                        comboBoxTypicalReasonTemp1.addItem("запрошуючий");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(200, 43, 40, 15);
                        labelTypicalReasonTemp2.setText("сигнал");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp2.setBounds(350, 40, 100, 20);
                        comboBoxTypicalReasonTemp2.addItem("з проїздом");
                        comboBoxTypicalReasonTemp2.addItem("без проїзду");
                        comboBoxTypicalReasonTemp2.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(460, 43, 50, 15);
                        labelTypicalReasonTemp3.setText("поїзду №");
                        labelTypicalReasonTemp3.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(515, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 4: // Не відкривається сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 100, 15);
                        labelTypicalReasonTemp1.setText("Не відкривається");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(110, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("вхідний");
                        comboBoxTypicalReasonTemp1.addItem("вихідний");
                        comboBoxTypicalReasonTemp1.addItem("запрошуючий");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(220, 43, 40, 15);
                        labelTypicalReasonTemp2.setText("сигнал");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(260, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(370, 43, 60, 15);
                        labelTypicalReasonTemp3.setText("поїзду №");
                        labelTypicalReasonTemp3.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(430, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 5: // Нема контролю маршруту горловини
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("Нема контролю маршруту");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(150, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("парної");
                        comboBoxTypicalReasonTemp1.addItem("непарної");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(260, 43, 70, 15);
                        labelTypicalReasonTemp2.setText("горловини");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 6: // Не переводиться стрілка
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Не переводиться стрілка №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(270, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("в");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(290, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem(" +");
                        comboBoxTypicalReasonTemp1.addItem(" -");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(400, 43, 70, 15);
                        labelTypicalReasonTemp3.setText("положення");
                        labelTypicalReasonTemp3.setVisible(true);
                        break;
                    case 8: // Розряд батареї горловини
                        labelTypicalReasonTemp1.setBounds(10, 43, 90, 15);
                        labelTypicalReasonTemp1.setText("Розряд батареї");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(100, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("парної");
                        comboBoxTypicalReasonTemp1.addItem("непарної");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(210, 43, 70, 15);
                        labelTypicalReasonTemp2.setText("горловини");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 9: // Неможливість аварійного відкриття сигналу
                        labelTypicalReasonTemp1.setBounds(10, 43, 230, 15);
                        labelTypicalReasonTemp1.setText("Неможливість аварійного відкриття сигналу");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(350, 43, 90, 15);
                        labelTypicalReasonTemp2.setText("(зняття ізоляції)");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 10: // Неспрацювала схема фіксації прибуття
                        labelTypicalReasonTemp1.setBounds(10, 43, 260, 15);
                        labelTypicalReasonTemp1.setText("Не спрацювала схема фіксації прибуття поїзда №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(270, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(380, 43, 90, 15);
                        labelTypicalReasonTemp2.setText("на станцію");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                }
                break;
            case 3: // АБ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // На прохідному світлофорі горить червоний вогонь
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("На прохідному світлофорі");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(150, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(260, 43, 140, 15);
                        labelTypicalReasonTemp2.setText("горить червоний вогонь");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 2: // На прохідному світлофорі горить більш дозволяючий вогонь
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("На прохідному світлофорі");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(150, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(260, 43, 190, 15);
                        labelTypicalReasonTemp2.setText("горить більш дозволяючий вогонь");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 3: // Несправжня зайнятість блок-дільниці
                        labelTypicalReasonTemp1.setBounds(10, 43, 200, 15);
                        labelTypicalReasonTemp1.setText("Несправжня зайнятість блок-дільниці");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(210, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("парного");
                        comboBoxTypicalReasonTemp1.addItem("непарного");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(320, 43, 190, 15);
                        labelTypicalReasonTemp2.setText("віддалення");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 4: // Погашені вогні прохідного світлофора
                        labelTypicalReasonTemp1.setBounds(10, 43, 200, 15);
                        labelTypicalReasonTemp1.setText("Погашені вогні прохідного світлофора");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(210, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 5: // Перекрився прохідний світлофор
                        labelTypicalReasonTemp1.setBounds(10, 43, 180, 15);
                        labelTypicalReasonTemp1.setText("Перекрився прохідний світлофор");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(190, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(300, 43, 60, 15);
                        labelTypicalReasonTemp2.setText("поїзду №");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(360, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(470, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("з проїздом");
                        comboBoxTypicalReasonTemp1.addItem("без проїзду");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 6: // Неможливо змінити напрям
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("Неможливо змінити напрям");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(150, 40, 170, 20);
                        comboBoxTypicalReasonTemp1.addItem("нормальним");
                        comboBoxTypicalReasonTemp1.addItem("допоміжним");
                        comboBoxTypicalReasonTemp1.addItem("нормальним і допоміжним");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(330, 43, 60, 15);
                        labelTypicalReasonTemp2.setText("режимом");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 8: // Відсутність живлення
                        labelTypicalReasonTemp1.setBounds(10, 43, 100, 15);
                        labelTypicalReasonTemp1.setText("Нема живлення на");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(110, 40, 150, 20);
                        comboBoxTypicalReasonTemp1.addItem("перегоні");
                        comboBoxTypicalReasonTemp1.addItem("сигнальній установці");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                }
                break;
            case 4: // HАБ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Не проходить блок-сигнал "Даю згоду" (ДС) поїзду №
                        labelTypicalReasonTemp1.setBounds(10, 43, 290, 15);
                        labelTypicalReasonTemp1.setText("Не проходить блок-сигнал \"Даю згоду\" (ДС)  поїзду №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(300, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 2: // Не пройшов блок-сигнал прибуття (ПП) поїзда №
                        labelTypicalReasonTemp1.setBounds(10, 43, 260, 15);
                        labelTypicalReasonTemp1.setText("Не пройшов блок-сигнал прибуття (ПП) поїзда №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(270, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 3: // Не спрацювала схема фіксації прибуття
                        labelTypicalReasonTemp1.setBounds(10, 43, 260, 15);
                        labelTypicalReasonTemp1.setText("Не спрацювала схема фіксації прибуття поїзда №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(270, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(380, 43, 60, 15);
                        labelTypicalReasonTemp2.setText("на станцію");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 4: // Не працює схема штучного прибуття
                        labelTypicalReasonTemp1.setBounds(10, 43, 250, 15);
                        labelTypicalReasonTemp1.setText("Не працює схема штучного прибуття поїзда №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(260, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 5: // Несправжня зайнятість дільниці
                        labelTypicalReasonTemp1.setBounds(10, 43, 170, 15);
                        labelTypicalReasonTemp1.setText("Несправжня зайнятість дільниці");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(180, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("парного");
                        comboBoxTypicalReasonTemp1.addItem("непарного");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(290, 43, 80, 15);
                        labelTypicalReasonTemp2.setText("наближення");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                }
                break;
            case 5: // ПС
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Не подається оповіщення
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("Не подається оповіщення");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(150, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("парного");
                        comboBoxTypicalReasonTemp1.addItem("непарного");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(260, 43, 80, 15);
                        labelTypicalReasonTemp2.setText("наближення");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 3: // Не закривається шлагбаум
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Не закривається шлагбаум");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("А");
                        comboBoxTypicalReasonTemp1.addItem("Б");
                        comboBoxTypicalReasonTemp1.addItem("А і Б");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 4: // Не відкривається шлагбаум
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Не відкривається шлагбаум");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("А");
                        comboBoxTypicalReasonTemp1.addItem("Б");
                        comboBoxTypicalReasonTemp1.addItem("А і Б");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 5: // Не вмикається загороджуючий сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 210, 15);
                        labelTypicalReasonTemp1.setText("Не вмикається загороджуючий сигнал");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(220, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 6: // Не вимикається загороджуючий сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 210, 15);
                        labelTypicalReasonTemp1.setText("Не вимикається загороджуючий сигнал");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(220, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 7: // Довільне включення загороджуючого сигналу
                        labelTypicalReasonTemp1.setBounds(10, 43, 250, 15);
                        labelTypicalReasonTemp1.setText("Довільне включення загороджуючого сигналу");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(260, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 8: // Не горить дорожній світлофор
                        labelTypicalReasonTemp1.setBounds(10, 43, 160, 15);
                        labelTypicalReasonTemp1.setText("Не горить дорожній світлофор");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(170, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("А");
                        comboBoxTypicalReasonTemp1.addItem("Б");
                        comboBoxTypicalReasonTemp1.addItem("А і Б");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 9: // Не працює дзвінок дорожнього світлофора
                        labelTypicalReasonTemp1.setBounds(10, 43, 230, 15);
                        labelTypicalReasonTemp1.setText("Не працює дзвінок дорожнього світлофора");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("А");
                        comboBoxTypicalReasonTemp1.addItem("Б");
                        comboBoxTypicalReasonTemp1.addItem("А і Б");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 11: // Не горять вогні переїздного світлофора
                        labelTypicalReasonTemp1.setBounds(10, 43, 220, 15);
                        labelTypicalReasonTemp1.setText("Не горять вогні переїздного світлофора");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(230, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("А");
                        comboBoxTypicalReasonTemp1.addItem("Б");
                        comboBoxTypicalReasonTemp1.addItem("А і Б");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                }
                break;
            case 6: // ГАЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 2: // Неможливо встановити маршрут
                        labelTypicalReasonTemp1.setBounds(10, 43, 240, 15);
                        labelTypicalReasonTemp1.setText("Неможливо встановити маршрут на пучок №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(250, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(360, 43, 60, 15);
                        labelTypicalReasonTemp2.setText(", колія №");
                        labelTypicalReasonTemp2.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(420, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 3: // Не переводиться стрілка
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Не переводиться стрілка №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(273, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("в");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(290, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem(" +");
                        comboBoxTypicalReasonTemp1.addItem(" -");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp3.setBounds(400, 43, 60, 15);
                        labelTypicalReasonTemp3.setText("положення");
                        labelTypicalReasonTemp3.setVisible(true);
                        break;
                    case 4: // Відсутність контролю положення стрілки
                        labelTypicalReasonTemp1.setBounds(10, 43, 180, 15);
                        labelTypicalReasonTemp1.setText("Відсутність контролю стрілки №");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(180, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(290, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem(" +");
                        comboBoxTypicalReasonTemp1.addItem(" -");
                        comboBoxTypicalReasonTemp1.addItem(" + i -");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(400, 43, 60, 15);
                        labelTypicalReasonTemp2.setText("положення");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 5: // Несправжня зайнятість секції
                        labelTypicalReasonTemp1.setBounds(10, 43, 160, 15);
                        labelTypicalReasonTemp1.setText("Несправжня зайнятість секції");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(170, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(280, 40, 120, 20);
                        comboBoxTypicalReasonTemp1.addItem("рейкове коло");
                        comboBoxTypicalReasonTemp1.addItem("фотодіод");
                        comboBoxTypicalReasonTemp1.addItem("магнітна педаль");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 6: // Несправність сповільнювача
                        labelTypicalReasonTemp1.setBounds(10, 43, 160, 15);
                        labelTypicalReasonTemp1.setText("Несправність сповільнювача -");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(170, 40, 160, 20);
                        comboBoxTypicalReasonTemp1.addItem("невідповідність розмірів");
                        comboBoxTypicalReasonTemp1.addItem("нема вагонового режиму");
                        comboBoxTypicalReasonTemp1.addItem("заклинювання механізмів");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 7: // Не працює пневмопошта
                        labelTypicalReasonTemp1.setBounds(10, 43, 140, 15);
                        labelTypicalReasonTemp1.setText("Не працює пневмопошта -");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(150, 40, 120, 20);
                        comboBoxTypicalReasonTemp1.addItem("автоматика");
                        comboBoxTypicalReasonTemp1.addItem("застряг патрон");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 8: // Відсутність живлення
                        labelTypicalReasonTemp1.setBounds(10, 43, 130, 15);
                        labelTypicalReasonTemp1.setText("Відсутність живлення -");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(140, 40, 130, 20);
                        comboBoxTypicalReasonTemp1.addItem("постова апаратура");
                        comboBoxTypicalReasonTemp1.addItem("пневмопошта");
                        comboBoxTypicalReasonTemp1.addItem("компресорна");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                }
                break;
            case 7: // ДЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Невірна інформація на пульт-табло
                        labelTypicalReasonTemp1.setBounds(10, 43, 190, 15);
                        labelTypicalReasonTemp1.setText("Невірна інформація на пульт-табло");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(200, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("дільниці");
                        comboBoxTypicalReasonTemp1.addItem("станції");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(310, 40, 200, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 2: // Не проходять сигнали
                        labelTypicalReasonTemp1.setBounds(10, 43, 120, 15);
                        labelTypicalReasonTemp1.setText("Не проходять сигнали");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(130, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("ТУ");
                        comboBoxTypicalReasonTemp1.addItem("ТС");
                        comboBoxTypicalReasonTemp1.addItem("ТУ + ТС");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        break;
                    case 3: // Неможливо встановити маршрут
                        labelTypicalReasonTemp1.setBounds(10, 43, 230, 15);
                        labelTypicalReasonTemp1.setText("Неможливо встановити маршрут від сигналу");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(240, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(350, 43, 20, 15);
                        labelTypicalReasonTemp2.setText("на");
                        labelTypicalReasonTemp2.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(370, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("колію");
                        comboBoxTypicalReasonTemp1.addItem("перегон");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp2.setBounds(480, 40, 100, 20);
                        textFieldTypicalReasonTemp2.setText("");
                        textFieldTypicalReasonTemp2.setVisible(true);
                        break;
                    case 4: // Неможливо відкрити сигнал
                        labelTypicalReasonTemp1.setBounds(10, 43, 150, 15);
                        labelTypicalReasonTemp1.setText("Неможливо відкрити сигнал");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(160, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        break;
                    case 5: // Неможливо передати станцію на резервне управління
                        labelTypicalReasonTemp1.setBounds(10, 43, 160, 15);
                        labelTypicalReasonTemp1.setText("Неможливо передати станцію");
                        labelTypicalReasonTemp1.setVisible(true);
                        textFieldTypicalReasonTemp1.setBounds(170, 40, 100, 20);
                        textFieldTypicalReasonTemp1.setText("");
                        textFieldTypicalReasonTemp1.setVisible(true);
                        labelTypicalReasonTemp2.setBounds(280, 43, 200, 15);
                        labelTypicalReasonTemp2.setText("на резервне управління");
                        labelTypicalReasonTemp2.setVisible(true);
                        break;
                    case 6: // Пошкодження
                        labelTypicalReasonTemp1.setBounds(10, 43, 80, 15);
                        labelTypicalReasonTemp1.setText("Пошкодження");
                        labelTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp1.setBounds(90, 40, 100, 20);
                        comboBoxTypicalReasonTemp1.addItem("лінії (пари)");
                        comboBoxTypicalReasonTemp1.addItem("каналу ВЧ");
                        comboBoxTypicalReasonTemp1.setVisible(true);
                        comboBoxTypicalReasonTemp2.setBounds(200, 40, 100, 20);
                        comboBoxTypicalReasonTemp2.addItem("кодової");
                        comboBoxTypicalReasonTemp2.addItem("ПЗ");
                        comboBoxTypicalReasonTemp2.addItem("ДСН");
                        comboBoxTypicalReasonTemp2.setVisible(true);
                        break;
                }
                break;
        }
    }

    private void comboBoxTypicalReasonTemp1ActionPerformed(java.awt.event.ActionEvent evt) {
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 1) && (comboBoxTypicalReason.getSelectedIndex() == 1)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                comboBoxTypicalReasonTemp2.setVisible(false);
            } else {
                comboBoxTypicalReasonTemp2.setBounds(200, 40, 90, 20);
                comboBoxTypicalReasonTemp2.addItem("Парна");
                comboBoxTypicalReasonTemp2.addItem("Непарна");
                comboBoxTypicalReasonTemp2.addItem("Центральна");
                comboBoxTypicalReasonTemp2.setVisible(true);
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 1) && (comboBoxTypicalReason.getSelectedIndex() == 6)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                textFieldTypicalReasonTemp2.setBounds(460, 40, 100, 20);
                textFieldTypicalReasonTemp2.setText("");
                textFieldTypicalReasonTemp2.setVisible(true);
            } else {
                textFieldTypicalReasonTemp2.setVisible(false);
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 1) && (comboBoxTypicalReason.getSelectedIndex() == 7)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                textFieldTypicalReasonTemp2.setVisible(true);
                textFieldTypicalReasonTemp2.setText("");
                comboBoxTypicalReasonTemp2.setBounds(590, 40, 100, 20);
                labelTypicalReasonTemp3.setBounds(700, 43, 50, 15);
            } else {
                textFieldTypicalReasonTemp2.setVisible(false);
                comboBoxTypicalReasonTemp2.setBounds(480, 40, 100, 20);
                labelTypicalReasonTemp3.setBounds(590, 43, 50, 15);
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 3) && (comboBoxTypicalReason.getSelectedIndex() == 8)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                textFieldTypicalReasonTemp1.setVisible(false);
            } else {
                textFieldTypicalReasonTemp1.setBounds(270, 40, 100, 20);
                textFieldTypicalReasonTemp1.setVisible(true);
                textFieldTypicalReasonTemp1.setText("");
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 6) && (comboBoxTypicalReason.getSelectedIndex() == 7)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                comboBoxTypicalReasonTemp2.setVisible(false);
                comboBoxTypicalReasonTemp2.removeAllItems();
            } else {
                comboBoxTypicalReasonTemp2.setBounds(280, 40, 120, 20);
                comboBoxTypicalReasonTemp2.addItem("несправний");
                comboBoxTypicalReasonTemp2.addItem("погано закритий");
                comboBoxTypicalReasonTemp2.setVisible(true);
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 7) && (comboBoxTypicalReason.getSelectedIndex() == 3)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                textFieldTypicalReasonTemp2.setVisible(true);
                textFieldTypicalReasonTemp2.setText("");
            } else {
                textFieldTypicalReasonTemp2.setVisible(false);
            }
            return;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() == 7) && (comboBoxTypicalReason.getSelectedIndex() == 6)) {
            if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                comboBoxTypicalReasonTemp2.setVisible(true);
            } else {
                comboBoxTypicalReasonTemp2.setVisible(false);
            }
        }
    }

    void reset() {
        comboBoxTypeOfDevice.setSelectedIndex(0);
    }

    @Override
    public boolean canContinue() {
        if (comboBoxTypeOfDevice.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вибрано тип пристрою");
            return false;
        }
        if ((comboBoxTypeOfDevice.getSelectedIndex() >= 1) && (comboBoxTypeOfDevice.getSelectedIndex() <= 7)) {
            if (comboBoxTypicalReason.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Не обрано характерну причину несправності");
                return false;
            }
        }
        switch (comboBoxTypeOfDevice.getSelectedIndex()) {
            case 1: // ЕЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 2: // Несправжня зайнятість
                    case 3: // Несправжня вільність
                    case 8: // Не переводиться стрілка
                    case 9: // Стрілка втратила контроль положення
                    case 10: // Неможливість аварійного переводу стрілки
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 4: // Перекрився сигнал
                    case 5: // Не відкривається сигнал
                        if ((textFieldTypicalReasonTemp1.getText().trim().equals("")) || (textFieldTypicalReasonTemp2.getText().trim().equals(""))) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 6: // Неможливо задати маршрут
                    case 7: // Неможливо розробити маршрут
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                            if (textFieldTypicalReasonTemp2.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                                return false;
                            }
                        }
                        break;
                }
                break;
            case 2: // КЛЗ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Несправжня зайнятість
                    case 2: // Несправжня вільність
                    case 6: // Не переводиться стрілка
                    case 9: // Неможливість відкриття аварійного сигналу
                    case 10: // Не спрацювала схема фіксації прибуття
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 3: // Перекрився сигнал
                    case 4: // Не відкривається сигнал
                        if ((textFieldTypicalReasonTemp1.getText().trim().equals("")) || (textFieldTypicalReasonTemp2.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                }
                break;
            case 3: // АБ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // На прохідному світлофорі горить червоний вогонь
                    case 2: // На прохідному світлофорі горить більш-дозволяючий вогонь
                    case 4: // Погашені вогні прохідного світлофора
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 5: // Перекрився прохідний світлофор
                        if ((textFieldTypicalReasonTemp1.getText().trim().equals("")) || (textFieldTypicalReasonTemp2.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 8: // Відсутність живлення
                        if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 1) {
                            if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                                return false;
                            }
                        }
                        break;
                }
                break;
            case 4: // РПБ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Не проходить блок сигнал даю згоду
                    case 2: // Не пройшов блок сигнал прибутя поїзда
                    case 3: // Не спрацювала схема фіксації прибутя поїзда
                    case 4: // Не працює схема штучного прибутя поїзда
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                }
                break;
            case 5: // ПС
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 5: // Не вмикається загороджуючий сигнал
                    case 6: // Не вимикається загороджуючий сигнал
                    case 7: // Довільне включення загороджуючого сигналу
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                }
                break;
            case 6: // ГАЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 2: // Неможливо встановити маршрут
                        if ((textFieldTypicalReasonTemp1.getText().trim().equals("")) || (textFieldTypicalReasonTemp2.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 3: // Не переводиться стрілка
                    case 4: // Відстуність контролю положення стрілки
                    case 5: // Несправжня зайнятість секції
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                }
                break;
            case 7: // ДЦ
                switch (comboBoxTypicalReason.getSelectedIndex()) {
                    case 1: // Невірна інформація на пульт-табло
                    case 4: // Неможливо відкрити сигнал
                    case 5: // Неможливо передати станцію на резервне управління
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        break;
                    case 3: // Неможливо встановити маршрут
                        if (textFieldTypicalReasonTemp1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                            return false;
                        }
                        if (comboBoxTypicalReasonTemp1.getSelectedIndex() == 0) {
                            if (textFieldTypicalReasonTemp2.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                                return false;
                            }
                        }
                        break;
                }
                break;
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        String[] mySimple = new String[8];
        System.arraycopy(simple, 0, mySimple, 0, 6);
        mySimple[6] = "Тип пристрою: ".concat((String) comboBoxTypeOfDevice.getSelectedItem()).concat(";");
        if ((comboBoxTypeOfDevice.getSelectedIndex() != 8) && (comboBoxTypeOfDevice.getSelectedIndex() != 9) && (comboBoxTypeOfDevice.getSelectedIndex() != 10) && (comboBoxTypeOfDevice.getSelectedIndex() != 11)) {
            mySimple[7] = "Характерна причина: ".concat((String) comboBoxTypicalReason.getSelectedItem()).concat(";");
        } else {
            mySimple[7] = "";
        }
        ArrayList<Component> components = new ArrayList<>();
        if (labelTypicalReasonTemp1.isVisible()) {components.add(labelTypicalReasonTemp1);}
        if (labelTypicalReasonTemp2.isVisible()) {components.add(labelTypicalReasonTemp2);}
        if (labelTypicalReasonTemp3.isVisible()) {components.add(labelTypicalReasonTemp3);}
        if (comboBoxTypicalReasonTemp1.isVisible()) {components.add(comboBoxTypicalReasonTemp1);}
        if (comboBoxTypicalReasonTemp2.isVisible()) {components.add(comboBoxTypicalReasonTemp2);}
        if (textFieldTypicalReasonTemp1.isVisible()) {components.add(textFieldTypicalReasonTemp1);}
        if (textFieldTypicalReasonTemp2.isVisible()) {components.add(textFieldTypicalReasonTemp2);}
        if (components.isEmpty()) {
            return mySimple;
        }
        int tmp = 8;
        if (mySimple[7].equals("")) {
            tmp = 7;
        }
        String[] tempS = new String[tmp + 1];
        System.arraycopy(mySimple, 0, tempS, 0, tmp);
        mySimple = tempS;
        mySimple[tmp] = (SortComponents.sortAndWrite(components)).concat(";");
        return mySimple;
    }

    @Override
    public Stat getParams(Stat stat) {
        ArrayList<String[]> paramsList = new ArrayList<>();
        String[] temp = new String[2];
        temp[0] = "comboBoxTypeOfDevice";
        temp[1] = String.valueOf(comboBoxTypeOfDevice.getSelectedIndex());
        paramsList.add(temp);
        if (comboBoxTypicalReason.getItemCount() != 0) {
            String[] temp2 = new String[2];
            temp2[0] = "comboBoxTypicalReason";
            temp2[1] = String.valueOf(comboBoxTypicalReason.getSelectedIndex());
            paramsList.add(temp2);
        }
        ArrayList<Component> components = new ArrayList<>();
        if (comboBoxTypicalReasonTemp1.isVisible()) {components.add(comboBoxTypicalReasonTemp1);}
        if (comboBoxTypicalReasonTemp2.isVisible()) {components.add(comboBoxTypicalReasonTemp2);}
        if (textFieldTypicalReasonTemp1.isVisible()) {components.add(textFieldTypicalReasonTemp1);}
        if (textFieldTypicalReasonTemp2.isVisible()) {components.add(textFieldTypicalReasonTemp2);}
        components = SortComponents.sort(components);
        for (Component c : components) {
            String[] temp1 = new String[2];
            temp1[0] = c.getName();
            if (c instanceof JComboBox) {
                temp1[1] = String.valueOf(((JComboBox) c).getSelectedIndex());
            }
            if (c instanceof JTextField) {
                temp1[1] = ((JTextField) c).getText();
            }
            paramsList.add(temp1);
        }
        String[][] params = new String[paramsList.size()][2];
        for (int i = 0; i < paramsList.size(); i++) {
            params[i] = paramsList.get(i);
        }
        stat.paramsPanelTypeOfDeviceOnPanelIntroductionError = params;
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        String[][] params = stat.paramsPanelTypeOfDeviceOnPanelIntroductionError;
        for (String[] s : params) {
            switch (s[0]) {
                case "comboBoxTypeOfDevice":
                    comboBoxTypeOfDevice.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxTypicalReason":
                    comboBoxTypicalReason.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxTypicalReasonTemp1":
                    comboBoxTypicalReasonTemp1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxTypicalReasonTemp2":
                    comboBoxTypicalReasonTemp2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldTypicalReasonTemp1":
                    textFieldTypicalReasonTemp1.setText(s[1]);
                    break;
                case "textFieldTypicalReasonTemp2":
                    textFieldTypicalReasonTemp2.setText(s[1]);
                    break;
            }
        }
    }
}
