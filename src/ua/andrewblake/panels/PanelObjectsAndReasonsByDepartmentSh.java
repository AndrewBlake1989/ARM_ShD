package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.utils.DateTime;
import ua.andrewblake.utils.SortComponents;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class PanelObjectsAndReasonsByDepartmentSh extends JPanel implements GetData {

    // Declaration:
    // Object:
    private JLabel labelObject;
    private JComboBox<String> comboBoxShObjects;
    private JComboBox<String> comboBoxShObjects_additionally_1;
    private JComboBox<String> comboBoxShObjects_additionally_2;
    private JTextField textFieldShObjects2_additionally;
    private JComboBox<String> comboBoxShObjects2_additionally;
    private JLabel labelCheckingOnSchedule_1;
    private JTextField textFieldCheckingOnSchedule_1;
    private JComboBox<String> comboBoxCheckingOnSchedule;
    private JTextField textFieldCheckingOnSchedule_2;
    private JLabel labelCheckingOnSchedule_2;
    private JLabel labelNumberOfWires;
    private JTextField textFieldNumberOfWires;
    private JLabel labelNameOfWires;
    private JTextField textFieldNameOfWires;
    private JLabel labelCable_1;
    private JTextField textFieldCable_1;
    private JLabel labelCable_2;
    private JTextField textFieldCable_2;
    private JLabel labelCable_3;
    private JTextField textFieldCable_3;
    private JLabel labelCable_4;
    private JLabel labelResistance_1;
    private JTextField textFieldResistanceDay;
    private JComboBox<String> comboBoxResistanceMonth;
    private JTextField textFieldResistanceYear;
    private JLabel labelResistance_2;

    // Element:
    private JLabel labelElement;
    private JComboBox<String> comboBoxElement;
    private JComboBox<String> comboBoxElement_additionally_1;
    private JTextField textFieldElement_additionally_1;
    private JLabel labelElement_additionally_1;
    private JComboBox<String> comboBoxElement_additionally_2;
    private JLabel labelElement_additionally_2;
    private JTextField textFieldElement_additionally_2;
    private JLabel labelElement_additionally_3;
    private JTextField textFieldElement_additionally_3;
    private JComboBox<String> comboBoxElement_additionally_3;
    private JTextField textFieldElement_additionally_4;
    private JTextField textFieldElement_additionally_5;
    private JLabel labelElement_additionally_4;
    private JLabel labelTested_1;
    private JTextField textFieldTested_1;
    private JLabel labelTested_2;
    private JTextField textFieldTestedDay;
    private JComboBox<String> comboBoxTestedMonth;
    private JTextField textFieldTestedYear;
    private JLabel labelTested_3;
    private JTextField textFieldElementRemote_additionally_1;
    private JComboBox<String> comboBoxElement_additionally_4;
    private JLabel labelCheckingOnScheduleRK_1;
    private JTextField textFieldCheckingOnScheduleRK_1;
    private JComboBox<String> comboBoxCheckingOnScheduleRK;
    private JTextField textFieldCheckingOnScheduleRK_2;
    private JLabel labelCheckingOnScheduleRK_2;

    // Element-2:
    private JComboBox<String> comboBoxElement2;
    private JTextField textFieldElement2_additionally_1;
    private JTextField textFieldElement2_additionally_2;
    private JTextField textFieldElement2_additionally_3;
    private JComboBox<String> comboBoxElement2_additionally_1;
    private JLabel labelElement2_additionally_1;
    private JLabel labelElement2_additionally_2;

    // Reason-1:
    private JLabel labelReason1;
    private JComboBox<String> comboBoxReason1;
    private JTextField textFieldReason1_additionally_1;
    private JTextField textFieldReason1_additionally_2;
    private JTextField textFieldReason1_additionally_3;
    private JTextField textFieldReason1_additionally_4;
    private JComboBox<String> comboBoxReason1_additionally_1;
    private JComboBox<String> comboBoxReason1_additionally_2;
    private JComboBox<String> comboBoxReason1_additionally_3;
    private JLabel labelReason1_additionally_1;
    private JLabel labelReason1_additionally_2;
    private JLabel labelReason1_additionally_3;
    private JLabel labelControlKVP_1;
    private JLabel labelControlKVP_2;
    private JTextField textFieldDayControlKVP;
    private JTextField textFieldYearControlKVP;
    private JComboBox<String> comboBoxMonthControlKVP;
    private JLabel labelYearLamp_1;
    private JLabel labelYearLamp_2;
    private JTextField textFieldYearLamp;
    private JLabel labelVoltage_1;
    private JTextField textFieldVoltage;
    private JLabel labelVoltage_2;

    // Reason-2:
    private JLabel labelReason2;
    private JComboBox<String> comboBoxReason2;
    private JComboBox<String> comboBoxReason2_additionally_1;
    private JLabel labelReason2_additionally_1;
    private JTextField textFieldReason2_additionally_1;

    // Constructor:
    PanelObjectsAndReasonsByDepartmentSh() {

        this.setSize(800, 280);
        this.setLayout(null);

        // Object:
        labelObject = new JLabel("Об'єкт:");
        this.add(labelObject);
        labelObject.setBounds(10, 13, 40, 15);

        comboBoxShObjects = new JComboBox<>(StringModels.getShObjects());
        this.add(comboBoxShObjects);
        comboBoxShObjects.setBounds(60, 10, 220, 20);
        comboBoxShObjects.addActionListener(this::comboBoxShObjectsActionPerformed);
        comboBoxShObjects.setName("comboBoxShObjects");

        comboBoxShObjects_additionally_1 = new JComboBox<>();
        this.add(comboBoxShObjects_additionally_1);
        comboBoxShObjects_additionally_1.setBounds(290, 10, 260, 20);
        comboBoxShObjects_additionally_1.addActionListener(this::comboBoxShObjects_additionally_1ActionPerformed);
        comboBoxShObjects_additionally_1.setName("comboBoxShObjects_additionally_1");

        comboBoxShObjects_additionally_2 = new JComboBox<>();
        this.add(comboBoxShObjects_additionally_2);
        comboBoxShObjects_additionally_2.setVisible(false);
        comboBoxShObjects_additionally_2.addActionListener(this::comboBoxShObjects_additionally_2ActionPerformed);
        comboBoxShObjects_additionally_2.setName("comboBoxShObjects_additionally_2");

        comboBoxShObjects2_additionally = new JComboBox<>();
        this.add(comboBoxShObjects2_additionally);
        comboBoxShObjects2_additionally.setVisible(false);
        comboBoxShObjects2_additionally.setName("comboBoxShObjects2_additionally");

        textFieldShObjects2_additionally = new JTextField();
        this.add(textFieldShObjects2_additionally);
        textFieldShObjects2_additionally.setVisible(false);
        textFieldShObjects2_additionally.setName("textFieldShObjects2_additionally");

        labelCheckingOnSchedule_1 = new JLabel("Перевірка по графіку:");
        this.add(labelCheckingOnSchedule_1);
        labelCheckingOnSchedule_1.setBounds(10, 43, 120, 15);
        labelCheckingOnSchedule_1.setVisible(false);

        textFieldCheckingOnSchedule_1 = new JTextField("");
        this.add(textFieldCheckingOnSchedule_1);
        textFieldCheckingOnSchedule_1.setBounds(130, 40, 20, 20);
        textFieldCheckingOnSchedule_1.setVisible(false);
        textFieldCheckingOnSchedule_1.setName("textFieldCheckingOnSchedule_1");

        comboBoxCheckingOnSchedule = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxCheckingOnSchedule);
        comboBoxCheckingOnSchedule.setBounds(155, 40, 75, 20);
        comboBoxCheckingOnSchedule.setVisible(false);
        comboBoxCheckingOnSchedule.setName("comboBoxCheckingOnSchedule");

        textFieldCheckingOnSchedule_2 = new JTextField("");
        this.add(textFieldCheckingOnSchedule_2);
        textFieldCheckingOnSchedule_2.setBounds(235, 40, 30, 20);
        textFieldCheckingOnSchedule_2.setVisible(false);
        textFieldCheckingOnSchedule_2.setName("textFieldCheckingOnSchedule_2");

        labelCheckingOnSchedule_2 = new JLabel("року");
        this.add(labelCheckingOnSchedule_2);
        labelCheckingOnSchedule_2.setBounds(270, 43, 25, 15);
        labelCheckingOnSchedule_2.setVisible(false);

        labelNumberOfWires = new JLabel("Кількість проводів:");
        this.add(labelNumberOfWires);
        labelNumberOfWires.setBounds(10, 43, 100, 15);
        labelNumberOfWires.setVisible(false);

        textFieldNumberOfWires = new JTextField();
        this.add(textFieldNumberOfWires);
        textFieldNumberOfWires.setBounds(115, 40, 30, 20);
        textFieldNumberOfWires.setVisible(false);
        textFieldNumberOfWires.setName("textFieldNumberOfWires");

        labelNameOfWires = new JLabel("назва:");
        this.add(labelNameOfWires);
        labelNameOfWires.setBounds(155, 43, 35, 15);
        labelNameOfWires.setVisible(false);

        textFieldNameOfWires = new JTextField();
        this.add(textFieldNameOfWires);
        textFieldNameOfWires.setBounds(195, 40, 100, 20);
        textFieldNameOfWires.setVisible(false);
        textFieldNameOfWires.setName("textFieldNameOfWires");

        labelCable_1 = new JLabel("Тип:");
        this.add(labelCable_1);
        labelCable_1.setBounds(10, 43, 25, 15);
        labelCable_1.setVisible(false);

        textFieldCable_1 = new JTextField();
        this.add(textFieldCable_1);
        textFieldCable_1.setBounds(40, 40, 100, 20);
        textFieldCable_1.setVisible(false);
        textFieldCable_1.setName("textFieldCable_1");

        labelCable_2 = new JLabel("прокладений");
        this.add(labelCable_2);
        labelCable_2.setBounds(145, 43, 70, 15);
        labelCable_2.setVisible(false);

        textFieldCable_2 = new JTextField();
        this.add(textFieldCable_2);
        textFieldCable_2.setBounds(215, 40, 30, 20);
        textFieldCable_2.setVisible(false);
        textFieldCable_2.setName("textFieldCable_2");

        labelCable_3 = new JLabel("р., глибиною");
        this.add(labelCable_3);
        labelCable_3.setBounds(250, 43, 70, 15);
        labelCable_3.setVisible(false);

        textFieldCable_3 = new JTextField();
        this.add(textFieldCable_3);
        textFieldCable_3.setBounds(320, 40, 40, 20);
        textFieldCable_3.setVisible(false);
        textFieldCable_3.setName("textFieldCable_3");

        labelCable_4 = new JLabel("м.");
        this.add(labelCable_4);
        labelCable_4.setBounds(365, 43, 10, 15);
        labelCable_4.setVisible(false);

        labelResistance_1 = new JLabel("Перевірка по графіку (вимір опору ізоляції):");
        this.add(labelResistance_1);
        labelResistance_1.setBounds(400, 43, 220, 15);
        labelResistance_1.setVisible(false);

        textFieldResistanceDay = new JTextField();
        this.add(textFieldResistanceDay);
        textFieldResistanceDay.setBounds(630, 40, 20, 20);
        textFieldResistanceDay.setVisible(false);
        textFieldResistanceDay.setName("textFieldResistanceDay");

        comboBoxResistanceMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxResistanceMonth);
        comboBoxResistanceMonth.setBounds(655, 40, 75, 20);
        comboBoxResistanceMonth.setVisible(false);
        comboBoxResistanceMonth.setName("comboBoxResistanceMonth");

        textFieldResistanceYear = new JTextField();
        this.add(textFieldResistanceYear);
        textFieldResistanceYear.setBounds(740, 40, 30, 20);
        textFieldResistanceYear.setVisible(false);
        textFieldResistanceYear.setName("textFieldResistanceYear");

        labelResistance_2 = new JLabel("p.");
        this.add(labelResistance_2);
        labelResistance_2.setBounds(775, 43, 20, 15);
        labelResistance_2.setVisible(false);


        // Element:
        labelElement = new JLabel("Елемент:");
        this.add(labelElement);
        labelElement.setBounds(10, 73, 50, 15);
        labelElement.setVisible(false);

        comboBoxElement = new JComboBox<>();
        this.add(comboBoxElement);
        comboBoxElement.setBounds(60, 70, 200, 20);
        comboBoxElement.setVisible(false);
        comboBoxElement.addActionListener(this::comboBoxElementActionPerformed);
        comboBoxElement.setName("comboBoxElement");

        comboBoxElement_additionally_1 = new JComboBox<>();
        this.add(comboBoxElement_additionally_1);
        comboBoxElement_additionally_1.setVisible(false);
        comboBoxElement_additionally_1.addActionListener(this::comboBoxElement_additionally_1ActionPerformed);
        comboBoxElement_additionally_1.setName("comboBoxElement_additionally_1");

        textFieldElement_additionally_1 = new JTextField();
        this.add(textFieldElement_additionally_1);
        textFieldElement_additionally_1.setVisible(false);
        textFieldElement_additionally_1.setName("textFieldElement_additionally_1");

        labelElement_additionally_1 = new JLabel();
        this.add(labelElement_additionally_1);
        labelElement_additionally_1.setVisible(false);

        comboBoxElement_additionally_2 = new JComboBox<>();
        this.add(comboBoxElement_additionally_2);
        comboBoxElement_additionally_2.setVisible(false);
        comboBoxElement_additionally_2.addActionListener(this::comboBoxElement_additionally_2ActionPerformed);
        comboBoxElement_additionally_2.setName("comboBoxElement_additionally_2");

        textFieldElement_additionally_2 = new JTextField();
        this.add(textFieldElement_additionally_2);
        textFieldElement_additionally_2.setVisible(false);
        textFieldElement_additionally_2.setName("textFieldElement_additionally_2");

        labelElement_additionally_2 = new JLabel();
        this.add(labelElement_additionally_2);
        labelElement_additionally_2.setVisible(false);

        textFieldElement_additionally_3 = new JTextField();
        this.add(textFieldElement_additionally_3);
        textFieldElement_additionally_3.setVisible(false);
        textFieldElement_additionally_3.setName("textFieldElement_additionally_3");

        labelElement_additionally_3 = new JLabel();
        this.add(labelElement_additionally_3);
        labelElement_additionally_3.setVisible(false);

        comboBoxElement_additionally_3 = new JComboBox<>();
        this.add(comboBoxElement_additionally_3);
        comboBoxElement_additionally_3.setVisible(false);
        comboBoxElement_additionally_3.addActionListener(this::comboBoxElement_additionally_3ActionPerformed);
        comboBoxElement_additionally_3.setName("comboBoxElement_additionally_3");

        textFieldElement_additionally_4 = new JTextField();
        this.add(textFieldElement_additionally_4);
        textFieldElement_additionally_4.setVisible(false);
        textFieldElement_additionally_4.setName("textFieldElement_additionally_4");

        textFieldElement_additionally_5 = new JTextField();
        this.add(textFieldElement_additionally_5);
        textFieldElement_additionally_5.setVisible(false);
        textFieldElement_additionally_5.setName("textFieldElement_additionally_5");

        labelElement_additionally_4 = new JLabel();
        this.add(labelElement_additionally_4);
        labelElement_additionally_4.setVisible(false);

        labelTested_1 = new JLabel("№");
        this.add(labelTested_1);
        labelTested_1.setBounds(10, 133, 15, 15);
        labelTested_1.setVisible(false);

        textFieldTested_1 = new JTextField();
        this.add(textFieldTested_1);
        textFieldTested_1.setBounds(25, 130, 100, 20);
        textFieldTested_1.setVisible(false);
        textFieldTested_1.setName("textFieldTested_1");

        labelTested_2 = new JLabel("перев.");
        this.add(labelTested_2);
        labelTested_2.setBounds(140, 133, 35, 15);
        labelTested_2.setVisible(false);

        textFieldTestedDay = new JTextField();
        this.add(textFieldTestedDay);
        textFieldTestedDay.setBounds(180, 130, 20, 20);
        textFieldTestedDay.setVisible(false);
        textFieldTestedDay.setName("textFieldTestedDay");

        comboBoxTestedMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxTestedMonth);
        comboBoxTestedMonth.setBounds(205, 130, 75, 20);
        comboBoxTestedMonth.setVisible(false);
        comboBoxTestedMonth.setName("comboBoxTestedMonth");

        textFieldTestedYear = new JTextField();
        this.add(textFieldTestedYear);
        textFieldTestedYear.setBounds(285, 130, 30, 20);
        textFieldTestedYear.setVisible(false);
        textFieldTestedYear.setName("textFieldTestedYear");

        labelTested_3 = new JLabel("p.");
        this.add(labelTested_3);
        labelTested_3.setBounds(320, 133, 20, 15);
        labelTested_3.setVisible(false);

        textFieldElementRemote_additionally_1 = new JTextField();
        this.add(textFieldElementRemote_additionally_1);
        textFieldElementRemote_additionally_1.setVisible(false);
        textFieldElementRemote_additionally_1.setName("textFieldElementRemote_additionally_1");

        comboBoxElement_additionally_4 = new JComboBox<>();
        this.add(comboBoxElement_additionally_4);
        comboBoxElement_additionally_4.setVisible(false);
        comboBoxElement_additionally_4.setName("comboBoxElement_additionally_4");

        labelCheckingOnScheduleRK_1 = new JLabel("Перевірка по графіку Техпроцесу");
        this.add(labelCheckingOnScheduleRK_1);
        labelCheckingOnScheduleRK_1.setBounds(10, 103, 180, 15);
        labelCheckingOnScheduleRK_1.setVisible(false);

        textFieldCheckingOnScheduleRK_1 = new JTextField("");
        this.add(textFieldCheckingOnScheduleRK_1);
        textFieldCheckingOnScheduleRK_1.setBounds(190, 100, 20, 20);
        textFieldCheckingOnScheduleRK_1.setVisible(false);
        textFieldCheckingOnScheduleRK_1.setName("textFieldCheckingOnScheduleRK_1");

        comboBoxCheckingOnScheduleRK = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxCheckingOnScheduleRK);
        comboBoxCheckingOnScheduleRK.setBounds(215, 100, 75, 20);
        comboBoxCheckingOnScheduleRK.setVisible(false);
        comboBoxCheckingOnScheduleRK.setName("comboBoxCheckingOnScheduleRK");

        textFieldCheckingOnScheduleRK_2 = new JTextField("");
        this.add(textFieldCheckingOnScheduleRK_2);
        textFieldCheckingOnScheduleRK_2.setBounds(295, 100, 30, 20);
        textFieldCheckingOnScheduleRK_2.setVisible(false);
        textFieldCheckingOnScheduleRK_2.setName("textFieldCheckingOnScheduleRK_2");

        labelCheckingOnScheduleRK_2 = new JLabel("року");
        this.add(labelCheckingOnScheduleRK_2);
        labelCheckingOnScheduleRK_2.setBounds(330, 103, 25, 15);
        labelCheckingOnScheduleRK_2.setVisible(false);

        // Element-2:
        comboBoxElement2 = new JComboBox<>();
        this.add(comboBoxElement2);
        comboBoxElement2.setBounds(10, 160, 150, 20);
        comboBoxElement2.setVisible(false);
        comboBoxElement2.addActionListener(this::comboBoxElement2ActionPerformed);
        comboBoxElement2.setName("comboBoxElement2");

        textFieldElement2_additionally_1 = new JTextField();
        this.add(textFieldElement2_additionally_1);
        textFieldElement2_additionally_1.setVisible(false);
        textFieldElement2_additionally_1.setName("textFieldElement2_additionally_1");

        textFieldElement2_additionally_2 = new JTextField();
        this.add(textFieldElement2_additionally_2);
        textFieldElement2_additionally_2.setVisible(false);
        textFieldElement2_additionally_2.setName("textFieldElement2_additionally_2");

        textFieldElement2_additionally_3 = new JTextField();
        this.add(textFieldElement2_additionally_3);
        textFieldElement2_additionally_3.setVisible(false);
        textFieldElement2_additionally_3.setName("textFieldElement2_additionally_3");

        comboBoxElement2_additionally_1 = new JComboBox<>();
        this.add(comboBoxElement2_additionally_1);
        comboBoxElement2_additionally_1.setVisible(false);
        comboBoxElement2_additionally_1.setName("comboBoxElement2_additionally_1");

        labelElement2_additionally_1 = new JLabel();
        this.add(labelElement2_additionally_1);
        labelElement2_additionally_1.setVisible(false);

        labelElement2_additionally_2 = new JLabel();
        this.add(labelElement2_additionally_2);
        labelElement2_additionally_2.setVisible(false);

        // Reason-1:
        labelReason1 = new JLabel("Причина:");
        this.add(labelReason1);
        labelReason1.setBounds(10, 193, 50, 15);
        labelReason1.setVisible(false);

        comboBoxReason1 = new JComboBox<>();
        this.add(comboBoxReason1);
        comboBoxReason1.setBounds(60, 190, 300, 20);
        comboBoxReason1.addActionListener(this::comboBoxReason1ActionPerformed);
        comboBoxReason1.setVisible(false);
        comboBoxReason1.setName("comboBoxReason1");

        textFieldReason1_additionally_1 = new JTextField();
        this.add(textFieldReason1_additionally_1);
        textFieldReason1_additionally_1.setVisible(false);
        textFieldReason1_additionally_1.setName("textFieldReason1_additionally_1");

        textFieldReason1_additionally_2 = new JTextField();
        this.add(textFieldReason1_additionally_2);
        textFieldReason1_additionally_2.setVisible(false);
        textFieldReason1_additionally_2.setName("textFieldReason1_additionally_2");

        textFieldReason1_additionally_3 = new JTextField();
        this.add(textFieldReason1_additionally_3);
        textFieldReason1_additionally_3.setVisible(false);
        textFieldReason1_additionally_3.setName("textFieldReason1_additionally_3");

        textFieldReason1_additionally_4 = new JTextField();
        this.add(textFieldReason1_additionally_4);
        textFieldReason1_additionally_4.setVisible(false);
        textFieldReason1_additionally_4.setName("textFieldReason1_additionally_4");

        comboBoxReason1_additionally_1 = new JComboBox<>();
        this.add(comboBoxReason1_additionally_1);
        comboBoxReason1_additionally_1.setVisible(false);
        comboBoxReason1_additionally_1.addActionListener(this::comboBoxReason1_additionally_1ActionPerformed);
        comboBoxReason1_additionally_1.setName("comboBoxReason1_additionally_1");

        comboBoxReason1_additionally_2 = new JComboBox<>();
        this.add(comboBoxReason1_additionally_2);
        comboBoxReason1_additionally_2.setVisible(false);
        comboBoxReason1_additionally_2.addActionListener(this::comboBoxReason1_additionally_2ActionPerformed);
        comboBoxReason1_additionally_2.setName("comboBoxReason1_additionally_2");

        comboBoxReason1_additionally_3 = new JComboBox<>();
        this.add(comboBoxReason1_additionally_3);
        comboBoxReason1_additionally_3.setVisible(false);
        comboBoxReason1_additionally_3.setName("comboBoxReason1_additionally_3");

        labelReason1_additionally_1 = new JLabel();
        this.add(labelReason1_additionally_1);
        labelReason1_additionally_1.setVisible(false);

        labelReason1_additionally_2 = new JLabel();
        this.add(labelReason1_additionally_2);
        labelReason1_additionally_2.setVisible(false);

        labelReason1_additionally_3 = new JLabel();
        this.add(labelReason1_additionally_3);
        labelReason1_additionally_3.setVisible(false);

        labelControlKVP_1 = new JLabel("Перевірка в КВП");
        this.add(labelControlKVP_1);
        labelControlKVP_1.setBounds(215, 223, 90, 15);
        labelControlKVP_1.setVisible(false);

        textFieldDayControlKVP = new JTextField("");
        this.add(textFieldDayControlKVP);
        textFieldDayControlKVP.setBounds(300, 220, 20, 20);
        textFieldDayControlKVP.setVisible(false);
        textFieldDayControlKVP.setName("textFieldDayControlKVP");

        comboBoxMonthControlKVP = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxMonthControlKVP);
        comboBoxMonthControlKVP.setBounds(325, 220, 75, 20);
        comboBoxMonthControlKVP.setVisible(false);
        comboBoxMonthControlKVP.setName("comboBoxMonthControlKVP");

        textFieldYearControlKVP = new JTextField("");
        this.add(textFieldYearControlKVP);
        textFieldYearControlKVP.setBounds(405, 220, 30, 20);
        textFieldYearControlKVP.setVisible(false);
        textFieldYearControlKVP.setName("textFieldYearControlKVP");

        labelControlKVP_2 = new JLabel("року");
        this.add(labelControlKVP_2);
        labelControlKVP_2.setBounds(440, 223, 25, 15);
        labelControlKVP_2.setVisible(false);

        labelYearLamp_1 = new JLabel("Рік випуску лампи: ");
        this.add(labelYearLamp_1);
        labelYearLamp_1.setBounds(480, 223, 100, 15);
        labelYearLamp_1.setVisible(false);

        textFieldYearLamp = new JTextField("");
        this.add(textFieldYearLamp);
        textFieldYearLamp.setBounds(580, 220, 30, 20);
        textFieldYearLamp.setVisible(false);
        textFieldYearLamp.setName("textFieldYearLamp");

        labelYearLamp_2 = new JLabel("року");
        this.add(labelYearLamp_2);
        labelYearLamp_2.setBounds(615, 223, 25, 15);
        labelYearLamp_2.setVisible(false);

        labelVoltage_1 = new JLabel("Напруга в мережі");
        this.add(labelVoltage_1);
        labelVoltage_1.setBounds(650, 223, 90, 15);
        labelVoltage_1.setVisible(false);

        textFieldVoltage = new JTextField("");
        this.add(textFieldVoltage);
        textFieldVoltage.setBounds(745, 220, 30, 20);
        textFieldVoltage.setVisible(false);
        textFieldVoltage.setName("textFieldVoltage");

        labelVoltage_2 = new JLabel("B");
        this.add(labelVoltage_2);
        labelVoltage_2.setBounds(780, 223, 20, 15);
        labelVoltage_2.setVisible(false);

        // Reason-2:
        labelReason2 = new JLabel("Причини:");
        this.add(labelReason2);
        labelReason2.setBounds(10, 253, 50, 15);
        labelReason2.setVisible(false);

        comboBoxReason2 = new JComboBox<>(StringModels.getShReasons2());
        this.add(comboBoxReason2);
        comboBoxReason2.setBounds(60, 250, 110, 20);
        comboBoxReason2.addActionListener(this::comboBoxReason2ActionPerformed);
        comboBoxReason2.setVisible(false);
        comboBoxReason2.setName("comboBoxReason2");

        comboBoxReason2_additionally_1 = new JComboBox<>();
        this.add(comboBoxReason2_additionally_1);
        comboBoxReason2_additionally_1.setVisible(false);
        comboBoxReason2_additionally_1.addActionListener(this::comboBoxReason2_additionally_1ActionPerformed);
        comboBoxReason2_additionally_1.setName("comboBoxReason2_additionally_1");

        labelReason2_additionally_1 = new JLabel("п.");
        labelReason2_additionally_1.setBounds(610, 253, 10, 15);
        this.add(labelReason2_additionally_1);
        labelReason2_additionally_1.setVisible(false);

        textFieldReason2_additionally_1 = new JTextField();
        textFieldReason2_additionally_1.setBounds(625, 250, 100, 20);
        this.add(textFieldReason2_additionally_1);
        textFieldReason2_additionally_1.setVisible(false);
        textFieldReason2_additionally_1.setName("textFieldReason2_additionally_1");



        this.setVisible(true);

    }

    // Methods:
    // Object:
    private void comboBoxShObjectsActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxShObjects_additionally_1.removeAllItems();
        String[] temp = new String[0];
        String[] tempElement = new String[0];
        textFieldCheckingOnSchedule_1.setText("");
        textFieldCheckingOnSchedule_1.setVisible(false);
        textFieldCheckingOnSchedule_2.setText("");
        textFieldCheckingOnSchedule_2.setVisible(false);
        comboBoxCheckingOnSchedule.setSelectedIndex(0);
        comboBoxCheckingOnSchedule.setVisible(false);
        labelCheckingOnSchedule_2.setVisible(false);
        labelCheckingOnSchedule_1.setVisible(false);
        labelNumberOfWires.setVisible(false);
        labelNameOfWires.setVisible(false);
        textFieldNumberOfWires.setVisible(false);
        textFieldNumberOfWires.setText("");
        textFieldNameOfWires.setVisible(false);
        textFieldNameOfWires.setText("");
        labelCable_1.setVisible(false);
        textFieldCable_1.setVisible(false);
        textFieldCable_1.setText("");
        labelCable_2.setVisible(false);
        textFieldCable_2.setVisible(false);
        textFieldCable_2.setText("");
        labelCable_3.setVisible(false);
        textFieldCable_3.setVisible(false);
        textFieldCable_3.setText("");
        labelCable_4.setVisible(false);
        labelResistance_1.setVisible(false);
        textFieldResistanceDay.setText("");
        textFieldResistanceDay.setVisible(false);
        comboBoxResistanceMonth.setSelectedIndex(0);
        comboBoxResistanceMonth.setVisible(false);
        textFieldResistanceYear.setText("");
        textFieldResistanceYear.setVisible(false);
        labelResistance_2.setVisible(false);
        comboBoxElement.removeAllItems();
        labelElement.setVisible(true);
        comboBoxElement.setVisible(true);
        labelCheckingOnScheduleRK_1.setVisible(false);
        textFieldCheckingOnScheduleRK_1.setText("");
        textFieldCheckingOnScheduleRK_1.setVisible(false);
        comboBoxCheckingOnScheduleRK.setVisible(false);
        textFieldCheckingOnScheduleRK_2.setText("");
        textFieldCheckingOnScheduleRK_2.setVisible(false);
        labelCheckingOnScheduleRK_2.setVisible(false);
        comboBoxElement2.removeAllItems();
        comboBoxElement2.setVisible(false);
        labelReason1.setVisible(true);
        comboBoxReason1.setVisible(true);
        comboBoxReason1.removeAllItems();
        comboBoxReason1.setBounds(60, 190, 300, 20);
        labelReason2.setVisible(true);
        comboBoxReason2.setVisible(true);
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 0: // -
                labelElement.setVisible(false);
                comboBoxElement.setVisible(false);
                labelReason1.setVisible(false);
                comboBoxReason1.setVisible(false);
                labelReason2.setVisible(false);
                comboBoxReason2.setVisible(false);
                return;
            case 1: // Пульти, табло, апарати управління
                temp = StringModels.getShObjects2ForShObjects_1();
                tempElement = StringModels.getShElementsForShObjects_1();

                String[] tempReasons = StringModels.getShReasons1ForShObjects_1();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                break;
            case 2: // Шафи, стативи, коробки, ящики
                temp = StringModels.getShObjects2ForShObjects_2();
                tempElement = StringModels.getShElementsForShObjects_2();
                comboBoxElement2.setVisible(true);
                break;
            case 3: // Щитові електропостач. установки
                temp = StringModels.getShObjects2ForShObjects_3();
                tempElement = StringModels.getShElementsForShObjects_3();
                comboBoxElement2.setVisible(true);
                break;
            case 4: // Акумулятори
                temp = StringModels.getShObjects2ForShObjects_4();
                tempElement = StringModels.getShElementsForShObjects_4();
                tempReasons = StringModels.getShReasons1ForShObjects_4();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                break;
            case 5: // Сигнали
                temp = StringModels.getShObjects2ForShObjects_5();
                tempElement = StringModels.getShElementsForShObjects_5();
                tempReasons = StringModels.getShReasons1ForShObjects_5();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                comboBoxReason1.setBounds(60, 190, 200, 20);
                break;
            case 6: // Приводи, замки
                textFieldCheckingOnSchedule_1.setVisible(true);
                textFieldCheckingOnSchedule_2.setVisible(true);
                comboBoxCheckingOnSchedule.setVisible(true);
                labelCheckingOnSchedule_2.setVisible(true);
                labelCheckingOnSchedule_1.setVisible(true);
                temp = StringModels.getShObjects2ForShObjects_6();
                tempElement = StringModels.getShElementsForShObjects_6();
                tempReasons = StringModels.getShReasons1ForShObjects_6();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                break;
            case 7: // Повітряні лінії
                labelNumberOfWires.setVisible(true);
                labelNameOfWires.setVisible(true);
                textFieldNumberOfWires.setVisible(true);
                textFieldNameOfWires.setVisible(true);
                temp = StringModels.getShObjects2ForShObjects_7();
                tempElement = StringModels.getShElementsForShObjects_7();
                tempReasons = StringModels.getShReasons1ForShObjects_7();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                break;
            case 8: // Кабельні лінії
                labelCable_1.setVisible(true);
                textFieldCable_1.setVisible(true);
                labelCable_2.setVisible(true);
                textFieldCable_2.setVisible(true);
                labelCable_3.setVisible(true);
                textFieldCable_3.setVisible(true);
                labelCable_4.setVisible(true);
                labelResistance_1.setVisible(true);
                textFieldResistanceDay.setVisible(true);
                comboBoxResistanceMonth.setVisible(true);
                textFieldResistanceYear.setVisible(true);
                labelResistance_2.setVisible(true);
                temp = StringModels.getShObjects2ForShObjects_8();
                tempElement = StringModels.getShElementsForShObjects_8();
                tempReasons = StringModels.getShReasons1ForShObjects_8();
                for (String s : tempReasons) {
                    comboBoxReason1.addItem(s);
                }
                break;
            case 9: // Рейкові кола
                tempElement = StringModels.getShElementsForShObjects_9();
                comboBoxElement2.setVisible(true);
                break;
            case 10: // Інші об'єкти
                temp = new String[]{"-", "Інший об'єкт", "При реконструкції пристроїв СЦБ"};
                labelElement.setVisible(false);
                comboBoxElement.setVisible(false);
                labelReason1.setVisible(false);
                comboBoxReason1.setVisible(false);
                break;
        }
        for (String s : temp) {
            comboBoxShObjects_additionally_1.addItem(s);
        }
        for (String sElement : tempElement) {
            comboBoxElement.addItem(sElement);
        }
        comboBoxShObjects_additionally_1ActionPerformed(null);
        comboBoxElement2ActionPerformed(null);
        comboBoxReason1ActionPerformed(null);
    }

    private void comboBoxShObjects_additionally_1ActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxShObjects_additionally_2.removeAllItems();
        comboBoxShObjects_additionally_2.setVisible(false);
        textFieldShObjects2_additionally.setText("");
        textFieldShObjects2_additionally.setVisible(false);
        comboBoxShObjects2_additionally.removeAllItems();
        comboBoxShObjects2_additionally.setVisible(false);
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 1: // Пульти, табло, апарати управління
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 6: // Уніфікований пульт
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 50, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("УП-1");
                        comboBoxShObjects_additionally_2.addItem("УП-2");
                        break;
                    case 9: // Маневрова колонка
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                    case 12: // Стрілочний централізатор
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("уніфікований");
                        comboBoxShObjects_additionally_2.addItem("Біненсона");
                        break;
                }
                break;
            case 2: // Шафи, стативи, коробки, ящики
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 2: // Статив
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                    case 3: // Коробка
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("колійна");
                        comboBoxShObjects_additionally_2.addItem("стрілочна");
                        comboBoxShObjects_additionally_2.addItem("інше");
                        break;
                    case 4: // Інші об'єкти
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 2: // Ввідна панель
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("ПВ-60");
                        comboBoxShObjects_additionally_2.addItem("ПВ1-ЕЦ");
                        comboBoxShObjects_additionally_2.addItem("інша");
                        break;
                    case 4: // Панель релейна
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("ПРББ");
                        comboBoxShObjects_additionally_2.addItem("ПРГ");
                        comboBoxShObjects_additionally_2.addItem("інша");
                        break;
                    case 8: // Панель випрямлячів
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("ПВ-24/220ББ");
                        comboBoxShObjects_additionally_2.addItem("ПВ-24");
                        comboBoxShObjects_additionally_2.addItem("ПДЦ");
                        comboBoxShObjects_additionally_2.addItem("інша");
                        break;
                }
                break;
            case 4: // Акумулятори
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 3: // C-
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                    case 4: // CK-
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                    case 5: // САП-
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                }
                break;
            case 5: // Сигнали
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 1: // Світлофор поїзний
                    case 2: // Маршрутний покажчик
                    case 3: // Покажчик напряму
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("мачтовий");
                        comboBoxShObjects_additionally_2.addItem("карликовий");
                        comboBoxShObjects_additionally_2.addItem("консольний");
                        comboBoxShObjects2_additionally.setBounds(680, 10, 100, 20);
                        comboBoxShObjects2_additionally.setVisible(true);
                        comboBoxShObjects2_additionally.addItem("лінзовий");
                        comboBoxShObjects2_additionally.addItem("прожекторний");
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 1: // Електропривід
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("стрілочний");
                        comboBoxShObjects_additionally_2.addItem("контрольний замок");
                        comboBoxShObjects_additionally_2.addItem("автошлагбауму");
                        break;
                    case 2: // Замок Мелентьєва
                        comboBoxShObjects_additionally_2.setBounds(560, 10, 110, 20);
                        comboBoxShObjects_additionally_2.setVisible(true);
                        comboBoxShObjects_additionally_2.addItem("плюсовий");
                        comboBoxShObjects_additionally_2.addItem("мінусовий");
                        break;
                }
                break;
            case 10: // Інші об'єкти
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 1: // Інший об'єкт
                        textFieldShObjects2_additionally.setBounds(560, 10, 110, 20);
                        textFieldShObjects2_additionally.setVisible(true);
                        break;
                }
                break;
        }
    }

    private void comboBoxShObjects_additionally_2ActionPerformed(java.awt.event.ActionEvent evt) {
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 2: // Шафи, стативи, коробки, ящики
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 3: // Коробка
                        switch (comboBoxShObjects_additionally_2.getSelectedIndex()) {
                            case 2: // Інше
                                textFieldShObjects2_additionally.setBounds(680, 10, 100, 20);
                                textFieldShObjects2_additionally.setText("");
                                textFieldShObjects2_additionally.setVisible(true);
                                break;
                            default:
                                textFieldShObjects2_additionally.setVisible(false);
                                break;
                        }
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 2: // Ввідна панель
                    case 4: // Панель релейна
                        switch (comboBoxShObjects_additionally_2.getSelectedIndex()) {
                            case 2: // Інша
                                textFieldShObjects2_additionally.setBounds(680, 10, 100, 20);
                                textFieldShObjects2_additionally.setText("");
                                textFieldShObjects2_additionally.setVisible(true);
                                break;
                            default:
                                textFieldShObjects2_additionally.setVisible(false);
                                break;
                        }
                        break;
                    case 8: // Панель випрямлячів
                        switch (comboBoxShObjects_additionally_2.getSelectedIndex()) {
                            case 3: // Інша
                                textFieldShObjects2_additionally.setBounds(680, 10, 100, 20);
                                textFieldShObjects2_additionally.setText("");
                                textFieldShObjects2_additionally.setVisible(true);
                                break;
                            default:
                                textFieldShObjects2_additionally.setVisible(false);
                                break;
                        }
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxShObjects_additionally_1.getSelectedIndex()) {
                    case 1: // Електропривід
                        switch (comboBoxShObjects_additionally_2.getSelectedIndex()) {
                            case 0: // Стрілочний
                                comboBoxShObjects2_additionally.setBounds(680, 10, 100, 20);
                                comboBoxShObjects2_additionally.removeAllItems();
                                comboBoxShObjects2_additionally.addItem("СП-3");
                                comboBoxShObjects2_additionally.addItem("СП-6");
                                comboBoxShObjects2_additionally.addItem("СПВ-5");
                                comboBoxShObjects2_additionally.addItem("СПГ-3М");
                                comboBoxShObjects2_additionally.addItem("СПГБ-4М");
                                comboBoxShObjects2_additionally.addItem("СП-ТС");
                                comboBoxShObjects2_additionally.setVisible(true);
                                break;
                            default:
                                comboBoxShObjects2_additionally.removeAllItems();
                                comboBoxShObjects2_additionally.setVisible(false);
                                break;
                        }
                        break;
                }
                break;
        }
        this.updateUI();
    }

    // Element:
    private void comboBoxElementActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxElement_additionally_1.removeAllItems();
        comboBoxElement_additionally_1.setVisible(false);
        comboBoxElement_additionally_2.removeAllItems();
        comboBoxElement_additionally_2.setVisible(false);
        comboBoxElement_additionally_3.removeAllItems();
        comboBoxElement_additionally_3.setVisible(false);
        comboBoxElement_additionally_4.removeAllItems();
        comboBoxElement_additionally_4.setVisible(false);
        textFieldElement_additionally_1.setText("");
        textFieldElement_additionally_1.setVisible(false);
        textFieldElement_additionally_2.setText("");
        textFieldElement_additionally_2.setVisible(false);
        textFieldElement_additionally_3.setText("");
        textFieldElement_additionally_3.setVisible(false);
        textFieldElement_additionally_4.setText("");
        textFieldElement_additionally_4.setVisible(false);
        textFieldElement_additionally_5.setText("");
        textFieldElement_additionally_5.setVisible(false);
        labelElement_additionally_1.setText("");
        labelElement_additionally_1.setVisible(false);
        labelElement_additionally_2.setText("");
        labelElement_additionally_2.setVisible(false);
        labelElement_additionally_3.setText("");
        labelElement_additionally_3.setVisible(false);
        labelElement_additionally_4.setText("");
        labelElement_additionally_4.setVisible(false);
        labelTested_1.setVisible(false);
        textFieldTested_1.setVisible(false);
        textFieldTested_1.setText("");
        labelTested_2.setVisible(false);
        textFieldTestedDay.setVisible(false);
        textFieldTestedDay.setText("");
        comboBoxTestedMonth.setVisible(false);
        comboBoxTestedMonth.setSelectedIndex(0);
        textFieldTestedYear.setVisible(false);
        textFieldTestedYear.setText("");
        labelTested_3.setVisible(false);
        textFieldElementRemote_additionally_1.setText("");
        textFieldElementRemote_additionally_1.setVisible(false);
        labelCheckingOnScheduleRK_1.setVisible(false);
        textFieldCheckingOnScheduleRK_1.setText("");
        textFieldCheckingOnScheduleRK_1.setVisible(false);
        comboBoxCheckingOnScheduleRK.setVisible(false);
        textFieldCheckingOnScheduleRK_2.setText("");
        textFieldCheckingOnScheduleRK_2.setVisible(false);
        labelCheckingOnScheduleRK_2.setVisible(false);
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 1: // Пульти, табло, апарати управління
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Кнопка
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("сигналу");
                        comboBoxElement_additionally_1.addItem("стрілки");
                        comboBoxElement_additionally_1.addItem("інша");
                        comboBoxElement_additionally_1.setVisible(true);
                        textFieldElementRemote_additionally_1.setBounds(380, 70, 100, 20);
                        textFieldElementRemote_additionally_1.setVisible(true);
                        break;
                    case 2: // Комутатор
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("сигналу");
                        comboBoxElement_additionally_1.addItem("стрілки");
                        comboBoxElement_additionally_1.addItem("маршруту");
                        comboBoxElement_additionally_1.setVisible(true);
                        textFieldElementRemote_additionally_1.setBounds(380, 70, 100, 20);
                        textFieldElementRemote_additionally_1.setVisible(true);
                        break;
                    case 4: // З'єднання
                        textFieldElementRemote_additionally_1.setBounds(270, 70, 100, 20);
                        textFieldElementRemote_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 2: // Шафи, стативи, коробки, ящики
                comboBoxElement2.removeAllItems();
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // -
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        break;
                    case 1: // Релейна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 140, 20);
                        String[] temp3 = StringModels.getRelayEquipment();
                        for (String s : temp3) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxElement_additionally_1.setVisible(true);
                        temp3 = StringModels.getRelayEquipmentForElement2();
                        for (String s : temp3) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp3 = StringModels.getReasonForRelayEquipment();
                        for (String s : temp3) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 200, 20);
                        String[] temp = StringModels.getObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp = StringModels.getReasonForObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxReason1.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        temp = StringModels.getObjectsContactlessDevicesForElement2();
                        for (String s : temp) {
                            comboBoxElement2.addItem(s);
                        }
                        break;
                    case 3: // Трансформатори
                        comboBoxElement_additionally_1.setBounds(270, 70, 130, 20);
                        comboBoxElement_additionally_1.addItem("Трансформатор");
                        comboBoxElement_additionally_1.addItem("Трансформатор ТС");
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        String[] temp4 = StringModels.getTransformersForElement2();
                        for (String s : temp4) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp4 = StringModels.getReasonForTransformers();
                        for (String s : temp4) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 4: // Елементи захисту
                        comboBoxElement_additionally_1.setBounds(270, 70, 170, 20);
                        String[] temp1 = StringModels.getSecurityFeatures();
                        for (String aTemp : temp1) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        temp1 = StringModels.getSecurityFeaturesForElement2();
                        for (String s : temp1) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp1 = StringModels.getReasonForSecurityFeatures();
                        for (String s : temp1) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 5: // Інші елементи
                        comboBoxElement_additionally_1.setBounds(270, 70, 140, 20);
                        String[] temp2 = StringModels.getOtherElementsStative();
                        for (String aTemp : temp2) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        temp2 = StringModels.getReasonForOtherElementsStative();
                        for (String aTemp : temp2) {
                            comboBoxReason1.addItem(aTemp);
                        }
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                comboBoxElement2.removeAllItems();
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // -
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        break;
                    case 1: // Релейна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 140, 20);
                        String[] temp3 = StringModels.getRelayEquipment();
                        for (String s : temp3) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxElement_additionally_1.setVisible(true);
                        temp3 = StringModels.getRelayEquipmentForElement2();
                        for (String s : temp3) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp3 = StringModels.getReasonForRelayEquipment();
                        for (String s : temp3) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 200, 20);
                        String[] temp = StringModels.getObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp = StringModels.getReasonForObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxReason1.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        temp = StringModels.getObjectsContactlessDevicesForElement2();
                        for (String s : temp) {
                            comboBoxElement2.addItem(s);
                        }
                        break;
                    case 3: // Трансформатори
                        comboBoxElement_additionally_1.setBounds(270, 70, 130, 20);
                        comboBoxElement_additionally_1.addItem("Трансформатор");
                        comboBoxElement_additionally_1.addItem("Трансформатор ТС");
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        String[] temp4 = StringModels.getTransformersForElement2();
                        for (String s : temp4) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp4 = StringModels.getReasonForTransformers();
                        for (String s : temp4) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 4: // Елементи захисту
                        comboBoxElement_additionally_1.setBounds(270, 70, 170, 20);
                        String[] temp1 = StringModels.getSecurityFeatures();
                        for (String aTemp : temp1) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        temp1 = StringModels.getSecurityFeaturesForElement2();
                        for (String s : temp1) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp1 = StringModels.getReasonForSecurityFeatures();
                        for (String s : temp1) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 5: // Інші елементи
                        comboBoxElement_additionally_1.setBounds(270, 70, 200, 20);
                        String[] temp2 = StringModels.getOtherElementsElectricitySupplyInstallations();
                        for (String aTemp : temp2) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        temp2 = StringModels.getReasonForOtherElementsElectricitySupplyInstallations();
                        for (String aTemp : temp2) {
                            comboBoxReason1.addItem(aTemp);
                        }
                        break;
                }
                break;
            case 5: // Сигнали
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Мачта
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("залізобетонна");
                        comboBoxElement_additionally_1.addItem("металева");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 4: // Світлофорна головка
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("звичайна");
                        comboBoxElement_additionally_1.addItem("світлодіодна");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 7: // Лампочка
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("однониткова");
                        comboBoxElement_additionally_1.addItem("двониткова");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Автоперемикач
                        comboBoxElement_additionally_1.setBounds(270, 70, 130, 20);
                        comboBoxElement_additionally_1.addItem("контрольна лінійка");
                        comboBoxElement_additionally_1.addItem("колодка");
                        comboBoxElement_additionally_1.addItem("контакти");
                        comboBoxElement_additionally_1.addItem("ніж");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 3: // Механічна передача
                        comboBoxElement_additionally_1.setBounds(270, 70, 150, 20);
                        comboBoxElement_additionally_1.addItem("важіль");
                        comboBoxElement_additionally_1.addItem("фрикційне зчеплення");
                        comboBoxElement_additionally_1.addItem("редуктор");
                        comboBoxElement_additionally_1.addItem("шиберна шестерня");
                        comboBoxElement_additionally_1.addItem("головний (несучий) вал");
                        comboBoxElement_additionally_1.addItem("інше");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 6: // Електродвигун
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("МСП-0,1");
                        comboBoxElement_additionally_1.addItem("МСП-0,15");
                        comboBoxElement_additionally_1.addItem("МСП-0,25");
                        comboBoxElement_additionally_1.addItem("МСА-0,3");
                        comboBoxElement_additionally_1.addItem("МСТ-0,3");
                        comboBoxElement_additionally_1.addItem("МСТ-У-0,3");
                        comboBoxElement_additionally_1.addItem("ДП-0,18");
                        comboBoxElement_additionally_1.addItem("ДП-0,25");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 7: // Замок Мелентьєва
                        comboBoxElement_additionally_1.setBounds(270, 70, 110, 20);
                        comboBoxElement_additionally_1.addItem("пружина");
                        comboBoxElement_additionally_1.addItem("цугальта");
                        comboBoxElement_additionally_1.addItem("штифт");
                        comboBoxElement_additionally_1.addItem("Т-подібний болт");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                    case 9: // Інший елемент
                        textFieldElementRemote_additionally_1.setBounds(270, 70, 200, 20);
                        textFieldElementRemote_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 7: // Повітряні лінії
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Провід
                        labelElement_additionally_1.setBounds(270, 73, 100, 15);
                        labelElement_additionally_1.setText("кількість проводів");
                        labelElement_additionally_1.setVisible(true);
                        textFieldElement_additionally_1.setBounds(370, 70, 100, 20);
                        textFieldElement_additionally_1.setVisible(true);
                        return;
                    case 2: // Опора
                        comboBoxElement_additionally_1.setBounds(270, 70, 80, 20);
                        comboBoxElement_additionally_1.addItem("траверса");
                        comboBoxElement_additionally_1.addItem("ізолятор");
                        comboBoxElement_additionally_1.addItem("в'язка");
                        comboBoxElement_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 8: // Кабельні лінії
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Жили
                        labelElement_additionally_1.setBounds(270, 73, 50, 15);
                        labelElement_additionally_1.setText("кількість");
                        labelElement_additionally_1.setVisible(true);
                        textFieldElement_additionally_1.setBounds(320, 70, 100, 20);
                        textFieldElement_additionally_1.setVisible(true);
                        labelElement_additionally_2.setBounds(430, 73, 30, 15);
                        labelElement_additionally_2.setText("назва");
                        labelElement_additionally_2.setVisible(true);
                        textFieldElement_additionally_2.setBounds(465, 70, 100, 20);
                        textFieldElement_additionally_2.setVisible(true);
                        return;
                    case 2: // Муфта
                        comboBoxElement_additionally_1.setBounds(270, 70, 120, 20);
                        comboBoxElement_additionally_1.addItem("-");
                        comboBoxElement_additionally_1.addItem("універсальна");
                        comboBoxElement_additionally_1.addItem("з'єднуюча");
                        comboBoxElement_additionally_1.addItem("розгалужувальна");
                        comboBoxElement_additionally_1.addItem("трійникова");
                        comboBoxElement_additionally_1.setVisible(true);
                        labelCheckingOnScheduleRK_1.setVisible(true);
                        textFieldCheckingOnScheduleRK_1.setVisible(true);
                        comboBoxCheckingOnScheduleRK.setVisible(true);
                        textFieldCheckingOnScheduleRK_2.setVisible(true);
                        labelCheckingOnScheduleRK_2.setVisible(true);
                        break;
                }
                break;
            case 9: // Рейкові кола
                comboBoxElement2.removeAllItems();
                switch (comboBoxElement.getSelectedIndex()) {
                    case 0: // -
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        break;
                    case 1: // Релейна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 140, 20);
                        String[] temp3 = StringModels.getRelayEquipment();
                        for (String s : temp3) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxElement_additionally_1.setVisible(true);
                        temp3 = StringModels.getRelayEquipmentForElement2();
                        for (String s : temp3) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp3 = StringModels.getReasonForRelayEquipment();
                        for (String s : temp3) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        comboBoxElement_additionally_1.setBounds(270, 70, 200, 20);
                        String[] temp = StringModels.getObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxElement_additionally_1.addItem(s);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp = StringModels.getReasonForObjectsContactlessDevices();
                        for (String s : temp) {
                            comboBoxReason1.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        temp = StringModels.getObjectsContactlessDevicesForElement2();
                        for (String s : temp) {
                            comboBoxElement2.addItem(s);
                        }
                        break;
                    case 3: // Трансформатори
                        comboBoxElement_additionally_1.setBounds(270, 70, 130, 20);
                        comboBoxElement_additionally_1.addItem("Трансформатор");
                        comboBoxElement_additionally_1.addItem("Трансформатор ТС");
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        String[] temp4 = StringModels.getTransformersForElement2();
                        for (String s : temp4) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp4 = StringModels.getReasonForTransformers();
                        for (String s : temp4) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 4: // Елементи захисту
                        comboBoxElement_additionally_1.setBounds(270, 70, 170, 20);
                        String[] temp1 = StringModels.getSecurityFeatures();
                        for (String aTemp : temp1) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        labelTested_1.setVisible(true);
                        textFieldTested_1.setVisible(true);
                        labelTested_2.setVisible(true);
                        textFieldTestedDay.setVisible(true);
                        comboBoxTestedMonth.setVisible(true);
                        textFieldTestedYear.setVisible(true);
                        labelTested_3.setVisible(true);
                        temp1 = StringModels.getSecurityFeaturesForElement2();
                        for (String s : temp1) {
                            comboBoxElement2.addItem(s);
                        }
                        comboBoxElement2.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        temp1 = StringModels.getReasonForSecurityFeatures();
                        for (String s : temp1) {
                            comboBoxReason1.addItem(s);
                        }
                        break;
                    case 5: // Рейкові з'єднувачі
                        comboBoxElement_additionally_1.setBounds(270, 70, 100, 20);
                        comboBoxElement_additionally_1.addItem("стиковий");
                        comboBoxElement_additionally_1.addItem("стрілочний");
                        comboBoxElement_additionally_1.addItem("тимчасовий");
                        comboBoxElement_additionally_1.addItem("відсутність");
                        comboBoxElement_additionally_1.setVisible(true);
                        comboBoxReason1.removeAllItems();
                        comboBoxReason1.addItem("-");
                        comboBoxReason1.addItem("Обрив");
                        comboBoxReason1.addItem("Відсутність");
                        comboBoxReason1.addItem("Втрата контакту");
                        comboBoxReason1.addItem("Згорання");
                        comboBoxReason1.addItem("Пробій");
                        comboBoxReason1.addItem("Причина не встановлена");
                        comboBoxReason1.addItem("Інша причина");
                        labelCheckingOnScheduleRK_1.setVisible(true);
                        textFieldCheckingOnScheduleRK_1.setVisible(true);
                        comboBoxCheckingOnScheduleRK.setVisible(true);
                        textFieldCheckingOnScheduleRK_2.setVisible(true);
                        labelCheckingOnScheduleRK_2.setVisible(true);
                        break;
                    case 6: // Інші елементи
                        comboBoxElement_additionally_1.setBounds(270, 70, 170, 20);
                        String[] temp2 = StringModels.getOtherElementsRackAndPinionRange();
                        for (String aTemp : temp2) {
                            comboBoxElement_additionally_1.addItem(aTemp);
                        }
                        comboBoxElement_additionally_1.setVisible(true);
                        comboBoxElement2.setVisible(false);
                        comboBoxReason1.removeAllItems();
                        temp2 = StringModels.getReasonForOtherElementsRackAndPinionRange();
                        for (String aTemp : temp2) {
                            comboBoxReason1.addItem(aTemp);
                        }
                        break;
                }
                break;
        }
        comboBoxElement_additionally_1ActionPerformed(null);
    }

    private void comboBoxElement_additionally_1ActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxElement_additionally_2.removeAllItems();
        comboBoxElement_additionally_2.setVisible(false);
        comboBoxElement_additionally_3.removeAllItems();
        comboBoxElement_additionally_3.setVisible(false);
        comboBoxElement_additionally_4.removeAllItems();
        comboBoxElement_additionally_4.setVisible(false);
        labelElement_additionally_1.setVisible(false);
        labelElement_additionally_2.setVisible(false);
        labelElement_additionally_3.setVisible(false);
        labelElement_additionally_4.setVisible(false);
        textFieldElement_additionally_1.setText("");
        textFieldElement_additionally_1.setVisible(false);
        textFieldElement_additionally_2.setText("");
        textFieldElement_additionally_2.setVisible(false);
        textFieldElement_additionally_3.setText("");
        textFieldElement_additionally_3.setVisible(false);
        textFieldElement_additionally_4.setText("");
        textFieldElement_additionally_4.setVisible(false);
        textFieldElement_additionally_5.setText("");
        textFieldElement_additionally_5.setVisible(false);


        switch (comboBoxShObjects.getSelectedIndex()) {
            case 2: // Шафи, стативи, коробки, яшики
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Реле
                                comboBoxElement_additionally_2.setBounds(420, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("імпульсне");
                                comboBoxElement_additionally_2.addItem("аварійне");
                                comboBoxElement_additionally_2.addItem("трансміттерне");
                                comboBoxElement_additionally_2.addItem("нейтральне");
                                comboBoxElement_additionally_2.addItem("поляризоване");
                                comboBoxElement_additionally_2.addItem("комбіноване");
                                comboBoxElement_additionally_2.addItem("вогневе");
                                comboBoxElement_additionally_2.addItem("герконове");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(530, 70, 100, 20);
                                textFieldElement_additionally_1.setText("");
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(635, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(665, 70, 100, 20);
                                textFieldElement_additionally_2.setText("");
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(10, 103, 70, 15);
                                labelElement_additionally_2.setText("призначення");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(80, 100, 100, 20);
                                textFieldElement_additionally_3.setText("");
                                textFieldElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Блок
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("релейний");
                                comboBoxElement_additionally_2.addItem("інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Дешифратор
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("АБ");
                                comboBoxElement_additionally_2.addItem("АЛСН");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 4: // Трансміттер
                                textFieldElement_additionally_1.setBounds(420, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(525, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(555, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Безконтактне реле
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("напруги РПН");
                                comboBoxElement_additionally_2.addItem("витримки часу");
                                comboBoxElement_additionally_2.addItem("реле ІВБ");
                                comboBoxElement_additionally_2.addItem("інше");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 2: // Безконтактний трансміттер
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("БКПТШ");
                                comboBoxElement_additionally_2.addItem("КПТШ");
                                comboBoxElement_additionally_2.addItem("БКПТ");
                                comboBoxElement_additionally_2.addItem("ТП-24М");
                                comboBoxElement_additionally_2.addItem("МТ-1");
                                comboBoxElement_additionally_2.addItem("МТ-2");
                                comboBoxElement_additionally_2.addItem("БКТ");
                                comboBoxElement_additionally_2.addItem("БКТ-2М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Блок конденсаторний
                                comboBoxElement_additionally_2.setBounds(480, 70, 65, 20);
                                String[] temp = StringModels.getCondensingUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 4:
                                textFieldElement_additionally_1.setBounds(480, 70, 200, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 5: // Конденсатор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(590, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(620, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("ємність");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(175, 103, 100, 15);
                                labelElement_additionally_3.setText("дата встановлення");
                                labelElement_additionally_3.setVisible(true);
                                textFieldElement_additionally_4.setBounds(280, 100, 20, 20);
                                textFieldElement_additionally_4.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(305, 100, 75, 20);
                                temp = StringModels.getMonths();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_5.setBounds(385, 100, 30, 20);
                                textFieldElement_additionally_5.setVisible(true);
                                labelElement_additionally_4.setBounds(420, 103, 25, 15);
                                labelElement_additionally_4.setText("року");
                                labelElement_additionally_4.setVisible(true);
                                break;
                            case 6: // Випрамляч
                                comboBoxElement_additionally_2.setBounds(480, 70, 80, 20);
                                temp = StringModels.getRectifiers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 7: // Випрамляючий елемент
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(615, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 8: // Перетворювач
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getTransformers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 9: // Блок захисний
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getProtectiveUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 10: // Фазуючий пристрій
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ФУ-1");
                                comboBoxElement_additionally_2.addItem("ФУ-2");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 11: // Апаратура
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ДЦ");
                                comboBoxElement_additionally_2.addItem("ДК");
                                comboBoxElement_additionally_2.addItem("АДЦУ");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 12: // Резистор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 13: // Апаратура АЛСН
                                comboBoxElement_additionally_2.setBounds(480, 70, 140, 20);
                                comboBoxElement_additionally_2.addItem("Підсилювач УК25/50М");
                                comboBoxElement_additionally_2.addItem("Фільтр ФЛ/75М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Трансформатор
                                comboBoxElement_additionally_2.setBounds(410, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("Колійний");
                                comboBoxElement_additionally_2.addItem("Релейний");
                                comboBoxElement_additionally_2.addItem("Сигнальний");
                                comboBoxElement_additionally_2.addItem("Силовий");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(620, 73, 20, 15);
                                labelElement_additionally_1.setText("№");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(640, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("випуск");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 30, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(95, 103, 30, 15);
                                labelElement_additionally_3.setText("року");
                                labelElement_additionally_3.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Запобіжник
                                comboBoxElement_additionally_2.setBounds(450, 70, 170, 20);
                                comboBoxElement_additionally_2.addItem("з контролем перегорання");
                                comboBoxElement_additionally_2.addItem("без контролю перегорання");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(15, 103, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(165, 103, 40, 15);
                                labelElement_additionally_2.setText("полюс");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(200, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(310, 103, 160, 15);
                                labelElement_additionally_3.setText("зарезервований лампою ПЖ -");
                                labelElement_additionally_3.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(470, 100, 50, 20);
                                comboBoxElement_additionally_3.addItem("Так");
                                comboBoxElement_additionally_3.addItem("Ні");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Вимикач автоматичний АВМ
                                labelElement_additionally_1.setBounds(445, 73, 10, 15);
                                labelElement_additionally_1.setText("-");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_1.setBounds(450, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 4: // Розрядник
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("РВН-250");
                                comboBoxElement_additionally_2.addItem("РВНШ-250");
                                comboBoxElement_additionally_2.addItem("РВН-0,5");
                                comboBoxElement_additionally_2.addItem("Г3а-0,65/2,5");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 5: // Вирівнювач
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ВК-10");
                                comboBoxElement_additionally_2.addItem("ВК-20");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-110");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-220");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-380");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 6: // Варистор
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("СН1");
                                comboBoxElement_additionally_2.addItem("СН2");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Штепсельна плата
                                labelElement_additionally_1.setBounds(415, 73, 20, 15);
                                labelElement_additionally_1.setText("№");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_1.setBounds(430, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(540, 70, 60, 20);
                                comboBoxElement_additionally_2.addItem("реле");
                                comboBoxElement_additionally_2.addItem("блоку");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_2.setBounds(610, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 4: // Клема
                                comboBoxElement_additionally_2.setBounds(420, 70, 70, 20);
                                comboBoxElement_additionally_2.addItem("нульова");
                                comboBoxElement_additionally_2.addItem("бокова");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 6: // Шина
                                textFieldElement_additionally_1.setBounds(420, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(530, 73, 40, 15);
                                labelElement_additionally_1.setText("полюс");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(570, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Реле
                                comboBoxElement_additionally_2.setBounds(420, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("імпульсне");
                                comboBoxElement_additionally_2.addItem("аварійне");
                                comboBoxElement_additionally_2.addItem("трансміттерне");
                                comboBoxElement_additionally_2.addItem("нейтральне");
                                comboBoxElement_additionally_2.addItem("поляризоване");
                                comboBoxElement_additionally_2.addItem("комбіноване");
                                comboBoxElement_additionally_2.addItem("вогневе");
                                comboBoxElement_additionally_2.addItem("герконове");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(530, 70, 100, 20);
                                textFieldElement_additionally_1.setText("");
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(635, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(665, 70, 100, 20);
                                textFieldElement_additionally_2.setText("");
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(10, 103, 70, 15);
                                labelElement_additionally_2.setText("призначення");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(80, 100, 100, 20);
                                textFieldElement_additionally_3.setText("");
                                textFieldElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Блок
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("релейний");
                                comboBoxElement_additionally_2.addItem("інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Дешифратор
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("АБ");
                                comboBoxElement_additionally_2.addItem("АЛСН");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 4: // Трансміттер
                                textFieldElement_additionally_1.setBounds(420, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(525, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(555, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Безконтактне реле
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("напруги РПН");
                                comboBoxElement_additionally_2.addItem("витримки часу");
                                comboBoxElement_additionally_2.addItem("реле ІВБ");
                                comboBoxElement_additionally_2.addItem("інше");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 2: // Безконтактний трансміттер
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("БКПТШ");
                                comboBoxElement_additionally_2.addItem("КПТШ");
                                comboBoxElement_additionally_2.addItem("БКПТ");
                                comboBoxElement_additionally_2.addItem("ТП-24М");
                                comboBoxElement_additionally_2.addItem("МТ-1");
                                comboBoxElement_additionally_2.addItem("МТ-2");
                                comboBoxElement_additionally_2.addItem("БКТ");
                                comboBoxElement_additionally_2.addItem("БКТ-2М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Блок конденсаторний
                                comboBoxElement_additionally_2.setBounds(480, 70, 65, 20);
                                String[] temp = StringModels.getCondensingUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 4:
                                textFieldElement_additionally_1.setBounds(480, 70, 200, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 5: // Конденсатор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(590, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(620, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("ємність");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(175, 103, 100, 15);
                                labelElement_additionally_3.setText("дата встановлення");
                                labelElement_additionally_3.setVisible(true);
                                textFieldElement_additionally_4.setBounds(280, 100, 20, 20);
                                textFieldElement_additionally_4.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(305, 100, 75, 20);
                                temp = StringModels.getMonths();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_5.setBounds(385, 100, 30, 20);
                                textFieldElement_additionally_5.setVisible(true);
                                labelElement_additionally_4.setBounds(420, 103, 25, 15);
                                labelElement_additionally_4.setText("року");
                                labelElement_additionally_4.setVisible(true);
                                break;
                            case 6: // Випрамляч
                                comboBoxElement_additionally_2.setBounds(480, 70, 80, 20);
                                temp = StringModels.getRectifiers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 7: // Випрамляючий елемент
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(615, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 8: // Перетворювач
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getTransformers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 9: // Блок захисний
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getProtectiveUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 10: // Фазуючий пристрій
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ФУ-1");
                                comboBoxElement_additionally_2.addItem("ФУ-2");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 11: // Апаратура
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ДЦ");
                                comboBoxElement_additionally_2.addItem("ДК");
                                comboBoxElement_additionally_2.addItem("АДЦУ");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 12: // Резистор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 13: // Апаратура АЛСН
                                comboBoxElement_additionally_2.setBounds(480, 70, 140, 20);
                                comboBoxElement_additionally_2.addItem("Підсилювач УК25/50М");
                                comboBoxElement_additionally_2.addItem("Фільтр ФЛ/75М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Трансформатор
                                comboBoxElement_additionally_2.setBounds(410, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("Колійний");
                                comboBoxElement_additionally_2.addItem("Релейний");
                                comboBoxElement_additionally_2.addItem("Сигнальний");
                                comboBoxElement_additionally_2.addItem("Силовий");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(620, 73, 20, 15);
                                labelElement_additionally_1.setText("№");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(640, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("випуск");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 30, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(95, 103, 30, 15);
                                labelElement_additionally_3.setText("року");
                                labelElement_additionally_3.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Запобіжник
                                comboBoxElement_additionally_2.setBounds(450, 70, 170, 20);
                                comboBoxElement_additionally_2.addItem("з контролем перегорання");
                                comboBoxElement_additionally_2.addItem("без контролю перегорання");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(15, 103, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(165, 103, 40, 15);
                                labelElement_additionally_2.setText("полюс");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(200, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(310, 103, 160, 15);
                                labelElement_additionally_3.setText("зарезервований лампою ПЖ -");
                                labelElement_additionally_3.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(470, 100, 50, 20);
                                comboBoxElement_additionally_3.addItem("Так");
                                comboBoxElement_additionally_3.addItem("Ні");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Вимикач автоматичний АВМ
                                labelElement_additionally_1.setBounds(445, 73, 10, 15);
                                labelElement_additionally_1.setText("-");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_1.setBounds(450, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 4: // Розрядник
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("РВН-250");
                                comboBoxElement_additionally_2.addItem("РВНШ-250");
                                comboBoxElement_additionally_2.addItem("РВН-0,5");
                                comboBoxElement_additionally_2.addItem("Г3а-0,65/2,5");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 5: // Вирівнювач
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ВК-10");
                                comboBoxElement_additionally_2.addItem("ВК-20");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-110");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-220");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-380");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 6: // Варистор
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("СН1");
                                comboBoxElement_additionally_2.addItem("СН2");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Кнопка
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 2: // Тумблер-вимикач
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 3: // Пакетний вимикач
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 4: // Контактор
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 100, 15);
                                labelElement_additionally_1.setText("тип КТ-6023");
                                labelElement_additionally_1.setVisible(true);
                                break;
                            case 5: // Автоматичний вимикач
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 100, 15);
                                labelElement_additionally_1.setText("тип АП50-3М");
                                labelElement_additionally_1.setVisible(true);
                                break;
                            case 6: // Магнітний пускач
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 100, 15);
                                labelElement_additionally_1.setText("тип ПА-311Т");
                                labelElement_additionally_1.setVisible(true);
                                break;
                            case 8: // Перетворювач
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 20, 15);
                                labelElement_additionally_1.setText("тип");
                                labelElement_additionally_1.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(565, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("ППВ-1");
                                comboBoxElement_additionally_2.addItem("ППС-1");
                                comboBoxElement_additionally_2.addItem("ППС-1,7");
                                comboBoxElement_additionally_2.addItem("ПП-300М");
                                comboBoxElement_additionally_2.addItem("ПО-550АФ");
                                comboBoxElement_additionally_2.addItem("ПЧ 50/25-300");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 9: // Реле контролю напруги
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 20, 15);
                                labelElement_additionally_1.setText("тип");
                                labelElement_additionally_1.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(565, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("РН-53/400");
                                comboBoxElement_additionally_2.addItem("РНП");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 10: // Автоматичний зарядний пристрій
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 100, 15);
                                labelElement_additionally_1.setText("тип У3А-24-10");
                                labelElement_additionally_1.setVisible(true);
                                break;
                            case 11: // Блок автоматичного регулювання
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 13: // Лічильник числа відключень
                                comboBoxElement_additionally_2.setBounds(480, 70, 50, 20);
                                comboBoxElement_additionally_2.addItem("1С");
                                comboBoxElement_additionally_2.addItem("2С");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 14: // Сигналізатор заземлення
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(540, 73, 50, 15);
                                labelElement_additionally_1.setText("контроль");
                                labelElement_additionally_1.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(600, 70, 40, 20);
                                comboBoxElement_additionally_2.addItem("=");
                                comboBoxElement_additionally_2.addItem("~");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_2.setBounds(650, 70, 50, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 15: // Вимірювальний прилад
                                textFieldElement_additionally_1.setBounds(480, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 16: // Випрамляючий елемент
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("діод");
                                comboBoxElement_additionally_2.addItem("стабілітрон");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 5: // Сигнали
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Мачта
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Залізобетонна
                                comboBoxElement_additionally_2.setBounds(380, 70, 50, 20);
                                comboBoxElement_additionally_2.addItem("8 м.");
                                comboBoxElement_additionally_2.addItem("10 м.");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 7: // Лампочка
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Однониткова
                                comboBoxElement_additionally_2.setBounds(380, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("ЖС12-15");
                                comboBoxElement_additionally_2.addItem("ЖС12-25");
                                comboBoxElement_additionally_2.addItem("ЖС12-35");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 1: // Двониткова
                                comboBoxElement_additionally_2.setBounds(380, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("ЖС12-15+15");
                                comboBoxElement_additionally_2.addItem("ЖС12-25+25");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 6: // Електродвигун
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // МСП-0,1
                            case 2: // МСП-0,25
                                comboBoxElement_additionally_2.setBounds(380, 70, 50, 20);
                                comboBoxElement_additionally_2.addItem("30В");
                                comboBoxElement_additionally_2.addItem("100В");
                                comboBoxElement_additionally_2.addItem("160В");
                                comboBoxElement_additionally_2.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(440, 70, 120, 20);
                                comboBoxElement_additionally_3.addItem("обмотка");
                                comboBoxElement_additionally_3.addItem("щітковий вузол");
                                comboBoxElement_additionally_3.addItem("пониження ізоляції");
                                comboBoxElement_additionally_3.addItem("інший елемент");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                            case 1: // МСП-0,15
                            case 6: // ДП-0,18
                            case 7: // ДП-0,25
                                comboBoxElement_additionally_2.setBounds(380, 70, 50, 20);
                                comboBoxElement_additionally_2.addItem("30В");
                                comboBoxElement_additionally_2.addItem("110В");
                                comboBoxElement_additionally_2.addItem("160В");
                                comboBoxElement_additionally_2.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(440, 70, 120, 20);
                                comboBoxElement_additionally_3.addItem("обмотка");
                                comboBoxElement_additionally_3.addItem("щітковий вузол");
                                comboBoxElement_additionally_3.addItem("пониження ізоляції");
                                comboBoxElement_additionally_3.addItem("інший елемент");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                            case 3: // МСА-0,3
                            case 4: // МСТ-0,3
                            case 5: // МСТ-У-0,3
                                comboBoxElement_additionally_2.setBounds(380, 70, 50, 20);
                                comboBoxElement_additionally_2.addItem("190В");
                                comboBoxElement_additionally_2.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(440, 70, 120, 20);
                                comboBoxElement_additionally_3.addItem("обмотка");
                                comboBoxElement_additionally_3.addItem("щітковий вузол");
                                comboBoxElement_additionally_3.addItem("пониження ізоляції");
                                comboBoxElement_additionally_3.addItem("інший елемент");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                        }
                        break;
                    case 7: // Замок Мелентьєва
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 2: // Штифт
                                comboBoxElement_additionally_2.setBounds(390, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("круглий");
                                comboBoxElement_additionally_2.addItem("квадратний");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 7: // Повітряні лінії
                switch (comboBoxElement.getSelectedIndex()) {
                    case 2: // Опора
                        labelElement_additionally_1.setBounds(355, 73, 50, 15);
                        labelElement_additionally_1.setText("№ опори");
                        labelElement_additionally_1.setVisible(true);
                        textFieldElement_additionally_1.setBounds(405, 70, 50, 20);
                        textFieldElement_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 8: // Кабельні лінії
                switch (comboBoxElement.getSelectedIndex()) {
                    case 2: // Муфта
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1:
                                textFieldElement_additionally_1.setBounds(400, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 9: // Рейкові кола
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Реле
                                comboBoxElement_additionally_2.setBounds(420, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("імпульсне");
                                comboBoxElement_additionally_2.addItem("аварійне");
                                comboBoxElement_additionally_2.addItem("трансміттерне");
                                comboBoxElement_additionally_2.addItem("нейтральне");
                                comboBoxElement_additionally_2.addItem("поляризоване");
                                comboBoxElement_additionally_2.addItem("комбіноване");
                                comboBoxElement_additionally_2.addItem("вогневе");
                                comboBoxElement_additionally_2.addItem("герконове");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(530, 70, 100, 20);
                                textFieldElement_additionally_1.setText("");
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(635, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(665, 70, 100, 20);
                                textFieldElement_additionally_2.setText("");
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(10, 103, 70, 15);
                                labelElement_additionally_2.setText("призначення");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(80, 100, 100, 20);
                                textFieldElement_additionally_3.setText("");
                                textFieldElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Блок
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("релейний");
                                comboBoxElement_additionally_2.addItem("інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Дешифратор
                                comboBoxElement_additionally_2.setBounds(420, 70, 80, 20);
                                comboBoxElement_additionally_2.addItem("АБ");
                                comboBoxElement_additionally_2.addItem("АЛСН");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(615, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(645, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 4: // Трансміттер
                                textFieldElement_additionally_1.setBounds(420, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(525, 73, 30, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(555, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 2: // Безконтактна апаратура
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Безконтактне реле
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("напруги РПН");
                                comboBoxElement_additionally_2.addItem("витримки часу");
                                comboBoxElement_additionally_2.addItem("реле ІВБ");
                                comboBoxElement_additionally_2.addItem("інше");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 2: // Безконтактний трансміттер
                                comboBoxElement_additionally_2.setBounds(480, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("БКПТШ");
                                comboBoxElement_additionally_2.addItem("КПТШ");
                                comboBoxElement_additionally_2.addItem("БКПТ");
                                comboBoxElement_additionally_2.addItem("ТП-24М");
                                comboBoxElement_additionally_2.addItem("МТ-1");
                                comboBoxElement_additionally_2.addItem("МТ-2");
                                comboBoxElement_additionally_2.addItem("БКТ");
                                comboBoxElement_additionally_2.addItem("БКТ-2М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Блок конденсаторний
                                comboBoxElement_additionally_2.setBounds(480, 70, 65, 20);
                                String[] temp = StringModels.getCondensingUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 4:
                                textFieldElement_additionally_1.setBounds(480, 70, 200, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 5: // Конденсатор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(590, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(620, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("ємність");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(175, 103, 100, 15);
                                labelElement_additionally_3.setText("дата встановлення");
                                labelElement_additionally_3.setVisible(true);
                                textFieldElement_additionally_4.setBounds(280, 100, 20, 20);
                                textFieldElement_additionally_4.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(305, 100, 75, 20);
                                temp = StringModels.getMonths();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_5.setBounds(385, 100, 30, 20);
                                textFieldElement_additionally_5.setVisible(true);
                                labelElement_additionally_4.setBounds(420, 103, 25, 15);
                                labelElement_additionally_4.setText("року");
                                labelElement_additionally_4.setVisible(true);
                                break;
                            case 6: // Випрамляч
                                comboBoxElement_additionally_2.setBounds(480, 70, 80, 20);
                                temp = StringModels.getRectifiers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 7: // Випрамляючий елемент
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(615, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 8: // Перетворювач
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getTransformers();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 9: // Блок захисний
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                temp = StringModels.getProtectiveUnits();
                                for (String aTemp : temp) {
                                    comboBoxElement_additionally_2.addItem(aTemp);
                                }
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 10: // Фазуючий пристрій
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ФУ-1");
                                comboBoxElement_additionally_2.addItem("ФУ-2");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 11: // Апаратура
                                comboBoxElement_additionally_2.setBounds(480, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ДЦ");
                                comboBoxElement_additionally_2.addItem("ДК");
                                comboBoxElement_additionally_2.addItem("АДЦУ");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 12: // Резистор
                                textFieldElement_additionally_1.setBounds(480, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(585, 73, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                break;
                            case 13: // Апаратура АЛСН
                                comboBoxElement_additionally_2.setBounds(480, 70, 140, 20);
                                comboBoxElement_additionally_2.addItem("Підсилювач УК25/50М");
                                comboBoxElement_additionally_2.addItem("Фільтр ФЛ/75М");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Трансформатор
                                comboBoxElement_additionally_2.setBounds(410, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("Колійний");
                                comboBoxElement_additionally_2.addItem("Релейний");
                                comboBoxElement_additionally_2.addItem("Сигнальний");
                                comboBoxElement_additionally_2.addItem("Силовий");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(510, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(620, 73, 20, 15);
                                labelElement_additionally_1.setText("№");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(640, 70, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(20, 103, 40, 15);
                                labelElement_additionally_2.setText("випуск");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(60, 100, 30, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(95, 103, 30, 15);
                                labelElement_additionally_3.setText("року");
                                labelElement_additionally_3.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Запобіжник
                                comboBoxElement_additionally_2.setBounds(450, 70, 170, 20);
                                comboBoxElement_additionally_2.addItem("з контролем перегорання");
                                comboBoxElement_additionally_2.addItem("без контролю перегорання");
                                comboBoxElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_1.setBounds(630, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(15, 103, 40, 15);
                                labelElement_additionally_1.setText("номінал");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(60, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                                labelElement_additionally_2.setBounds(165, 103, 40, 15);
                                labelElement_additionally_2.setText("полюс");
                                labelElement_additionally_2.setVisible(true);
                                textFieldElement_additionally_3.setBounds(200, 100, 100, 20);
                                textFieldElement_additionally_3.setVisible(true);
                                labelElement_additionally_3.setBounds(310, 103, 160, 15);
                                labelElement_additionally_3.setText("зарезервований лампою ПЖ -");
                                labelElement_additionally_3.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(470, 100, 50, 20);
                                comboBoxElement_additionally_3.addItem("Так");
                                comboBoxElement_additionally_3.addItem("Ні");
                                comboBoxElement_additionally_3.setVisible(true);
                                break;
                            case 2: // Вимикач автоматичний АВМ
                                labelElement_additionally_1.setBounds(445, 73, 10, 15);
                                labelElement_additionally_1.setText("-");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_1.setBounds(450, 70, 50, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                            case 4: // Розрядник
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("РВН-250");
                                comboBoxElement_additionally_2.addItem("РВНШ-250");
                                comboBoxElement_additionally_2.addItem("РВН-0,5");
                                comboBoxElement_additionally_2.addItem("Г3а-0,65/2,5");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 5: // Вирівнювач
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("ВК-10");
                                comboBoxElement_additionally_2.addItem("ВК-20");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-110");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-220");
                                comboBoxElement_additionally_2.addItem("ВОЦШ-380");
                                comboBoxElement_additionally_2.addItem("Інший");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 6: // Варистор
                                comboBoxElement_additionally_2.setBounds(450, 70, 90, 20);
                                comboBoxElement_additionally_2.addItem("СН1");
                                comboBoxElement_additionally_2.addItem("СН2");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Рейкові з'єднувачі
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 0: // Стиковий
                            case 1: // Стрілочний
                            case 2: // Тимчасовий
                                comboBoxElement_additionally_2.setBounds(380, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("приварний");
                                comboBoxElement_additionally_2.addItem("штепсельний");
                                comboBoxElement_additionally_2.setVisible(true);
                                comboBoxElement_additionally_3.setBounds(490, 70, 100, 20);
                                comboBoxElement_additionally_3.addItem("мідний");
                                comboBoxElement_additionally_3.addItem("сталевий");
                                comboBoxElement_additionally_3.setVisible(true);
                                comboBoxElement_additionally_4.setBounds(600, 70, 100, 20);
                                comboBoxElement_additionally_4.addItem("наконечник");
                                comboBoxElement_additionally_4.addItem("перчатка");
                                comboBoxElement_additionally_4.addItem("штепсель");
                                comboBoxElement_additionally_4.addItem("манжет");
                                comboBoxElement_additionally_4.addItem("трос");
                                comboBoxElement_additionally_4.addItem("кріплення");
                                comboBoxElement_additionally_4.addItem("ізоляція");
                                comboBoxElement_additionally_4.setVisible(true);
                                break;
                        }
                        break;
                    case 6: // Інші елементи
                        labelCheckingOnScheduleRK_1.setVisible(false);
                        textFieldCheckingOnScheduleRK_1.setText("");
                        textFieldCheckingOnScheduleRK_1.setVisible(false);
                        comboBoxCheckingOnScheduleRK.setVisible(false);
                        textFieldCheckingOnScheduleRK_2.setText("");
                        textFieldCheckingOnScheduleRK_2.setVisible(false);
                        labelCheckingOnScheduleRK_2.setVisible(false);
                        textFieldElement_additionally_1.setText("");
                        textFieldElement_additionally_1.setVisible(false);
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Перемичка
                                labelCheckingOnScheduleRK_1.setVisible(true);
                                textFieldCheckingOnScheduleRK_1.setVisible(true);
                                comboBoxCheckingOnScheduleRK.setVisible(true);
                                textFieldCheckingOnScheduleRK_2.setVisible(true);
                                labelCheckingOnScheduleRK_2.setVisible(true);
                                comboBoxElement_additionally_2.setBounds(450, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("дросельна");
                                comboBoxElement_additionally_2.addItem("міждросельна");
                                comboBoxElement_additionally_2.addItem("джемперна");
                                comboBoxElement_additionally_2.addItem("інша");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 3: // Дросель-трансформатор
                                comboBoxElement_additionally_2.setBounds(450, 70, 100, 20);
                                comboBoxElement_additionally_2.addItem("ДТ-0,2-500");
                                comboBoxElement_additionally_2.addItem("ДТ-0,6-500");
                                comboBoxElement_additionally_2.addItem("ДТ-0,2-1000");
                                comboBoxElement_additionally_2.addItem("ДТ-0,6-1000");
                                comboBoxElement_additionally_2.setVisible(true);
                                break;
                            case 4: // Інший елемент
                                textFieldElement_additionally_1.setBounds(450, 70, 200, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
        }

        if (comboBoxElement_additionally_2.isVisible()) {
            comboBoxElement_additionally_2ActionPerformed(null);
        }
    }

    private void comboBoxElement_additionally_2ActionPerformed(java.awt.event.ActionEvent evt) {
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 2: // Шафи, стативи, коробки, ящики
                switch (comboBoxElement.getSelectedIndex()) {
                    case 2: // Безконтактна апаратура
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 1) { // Безконтактне реле
                            comboBoxElement_additionally_3.setVisible(false);
                            comboBoxElement_additionally_3.removeAllItems();
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            labelElement_additionally_1.setVisible(false);
                            textFieldElement_additionally_2.setText("");
                            textFieldElement_additionally_2.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // Витримки часу
                                comboBoxElement_additionally_3.setBounds(590, 70, 60, 20);
                                comboBoxElement_additionally_3.addItem("БСВШ");
                                comboBoxElement_additionally_3.addItem("БВМШ");
                                comboBoxElement_additionally_3.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 3) { // Інше
                                textFieldElement_additionally_1.setBounds(590, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(10, 103, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(40, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 3) { // Блок конденсаторний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 6) { // Випрамляч
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // ВАК
                                textFieldElement_additionally_1.setBounds(570, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(570, 70, 210, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 8) { // Перетворювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 9) { // Блок захисний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 10) { // Фазуючий пристрій
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 2) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 4: // Елементи захисту
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 5) { // Вирівнювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 5) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 5: // Інші елементи
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 4) { // Клема
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 0) { // Нульова
                                textFieldElement_additionally_1.setBounds(500, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 2: // Безконтактна апаратура
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 1) { // Безконтактне реле
                            comboBoxElement_additionally_3.setVisible(false);
                            comboBoxElement_additionally_3.removeAllItems();
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            labelElement_additionally_1.setVisible(false);
                            textFieldElement_additionally_2.setText("");
                            textFieldElement_additionally_2.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // Витримки часу
                                comboBoxElement_additionally_3.setBounds(590, 70, 60, 20);
                                comboBoxElement_additionally_3.addItem("БСВШ");
                                comboBoxElement_additionally_3.addItem("БВМШ");
                                comboBoxElement_additionally_3.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 3) { // Інше
                                textFieldElement_additionally_1.setBounds(590, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(10, 103, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(40, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 3) { // Блок конденсаторний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 6) { // Випрамляч
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // ВАК
                                textFieldElement_additionally_1.setBounds(570, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(570, 70, 210, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 8) { // Перетворювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 9) { // Блок захисний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 10) { // Фазуючий пристрій
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 2) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 4: // Елементи захисту
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 5) { // Вирівнювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 5) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 16: // Вмпрямляючий еелмент
                                switch (comboBoxElement_additionally_2.getSelectedIndex()) {
                                    case 0:
                                        textFieldElement_additionally_1.setBounds(590, 70, 50, 20);
                                        textFieldElement_additionally_1.setVisible(true);
                                        labelElement_additionally_1.setBounds(650, 73, 30, 15);
                                        labelElement_additionally_1.setText("типу");
                                        labelElement_additionally_1.setVisible(true);
                                        textFieldElement_additionally_2.setBounds(680, 70, 50, 20);
                                        textFieldElement_additionally_2.setVisible(true);
                                        break;
                                    case 1:
                                        textFieldElement_additionally_1.setBounds(590, 70, 50, 20);
                                        textFieldElement_additionally_1.setVisible(true);
                                        labelElement_additionally_1.setVisible(false);
                                        textFieldElement_additionally_2.setVisible(false);
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
            case 9: // Рейкові кола
                switch (comboBoxElement.getSelectedIndex()) {
                    case 2: // Безконтактна апаратура
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 1) { // Безконтактне реле
                            comboBoxElement_additionally_3.setVisible(false);
                            comboBoxElement_additionally_3.removeAllItems();
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            labelElement_additionally_1.setVisible(false);
                            textFieldElement_additionally_2.setText("");
                            textFieldElement_additionally_2.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // Витримки часу
                                comboBoxElement_additionally_3.setBounds(590, 70, 60, 20);
                                comboBoxElement_additionally_3.addItem("БСВШ");
                                comboBoxElement_additionally_3.addItem("БВМШ");
                                comboBoxElement_additionally_3.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 3) { // Інше
                                textFieldElement_additionally_1.setBounds(590, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                                labelElement_additionally_1.setBounds(10, 103, 25, 15);
                                labelElement_additionally_1.setText("типу");
                                labelElement_additionally_1.setVisible(true);
                                textFieldElement_additionally_2.setBounds(40, 100, 100, 20);
                                textFieldElement_additionally_2.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 3) { // Блок конденсаторний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 6) { // Випрамляч
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 1) { // ВАК
                                textFieldElement_additionally_1.setBounds(570, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(570, 70, 210, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 8) { // Перетворювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 10) { // Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 9) { // Блок захисний
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 6) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 10) { // Фазуючий пристрій
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 2) { //Інший
                                textFieldElement_additionally_1.setBounds(580, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 4: // Елементи захисту
                        if (comboBoxElement_additionally_1.getSelectedIndex() == 5) { // Вирівнювач
                            textFieldElement_additionally_1.setText("");
                            textFieldElement_additionally_1.setVisible(false);
                            if (comboBoxElement_additionally_2.getSelectedIndex() == 5) { // Інший
                                textFieldElement_additionally_1.setBounds(550, 70, 100, 20);
                                textFieldElement_additionally_1.setVisible(true);
                            }
                        }
                        break;
                    case 6: // Інші елементи
                        comboBoxElement_additionally_3.removeAllItems();
                        comboBoxElement_additionally_3.setVisible(false);
                        comboBoxElement_additionally_4.removeAllItems();
                        comboBoxElement_additionally_4.setVisible(false);
                        labelElement_additionally_1.setVisible(false);
                        textFieldElement_additionally_1.setText("");
                        textFieldElement_additionally_1.setVisible(false);
                        switch (comboBoxElement_additionally_1.getSelectedIndex()) {
                            case 1: // Перемичка
                                switch (comboBoxElement_additionally_2.getSelectedIndex()) {
                                    case 0: // Дросельна
                                        comboBoxElement_additionally_3.setBounds(560, 70, 90, 20);
                                        comboBoxElement_additionally_3.removeAllItems();
                                        comboBoxElement_additionally_3.addItem("довга");
                                        comboBoxElement_additionally_3.addItem("коротка");
                                        comboBoxElement_additionally_3.addItem("обидві");
                                        comboBoxElement_additionally_3.setVisible(true);
                                        break;
                                    case 3: // Інша
                                        textFieldElement_additionally_1.setBounds(560, 70, 100, 20);
                                        textFieldElement_additionally_1.setVisible(true);
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private void comboBoxElement_additionally_3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (comboBoxShObjects.getSelectedIndex() == 6) { // Приводи, замки
            if (comboBoxElement.getSelectedIndex() == 6) { // Електродвигун
                comboBoxElement_additionally_4.removeAllItems();
                comboBoxElement_additionally_4.setVisible(false);
                if (comboBoxElement_additionally_3.getSelectedIndex() == 0) { // Обмотка
                    comboBoxElement_additionally_4.addItem("якоря");
                    comboBoxElement_additionally_4.addItem("ротора");
                    comboBoxElement_additionally_4.addItem("статора");
                    comboBoxElement_additionally_4.addItem("збудження");
                    comboBoxElement_additionally_4.setVisible(true);
                    if (comboBoxElement_additionally_1.getSelectedIndex() <= 8) { // МСП-0,1; МПС-0,15; МСП-0,25; МСА-0,3; МСТ-0,3; МСТ-У-0,3; ДП-0,18; ДП-0,25; МШ-0,26;
                        comboBoxElement_additionally_4.setBounds(570, 70, 90, 20);
                    } else { // СЛ-571К; Інший
                        comboBoxElement_additionally_4.setBounds(510, 70, 90, 20);
                    }
                }
            }
        }
    }

    // Element-2:
    private void comboBoxElement2ActionPerformed(java.awt.event.ActionEvent evt) {
        textFieldElement2_additionally_1.setText("");
        textFieldElement2_additionally_1.setVisible(false);
        textFieldElement2_additionally_2.setText("");
        textFieldElement2_additionally_2.setVisible(false);
        textFieldElement2_additionally_3.setText("");
        textFieldElement2_additionally_3.setVisible(false);
        comboBoxElement2_additionally_1.removeAllItems();
        comboBoxElement2_additionally_1.setVisible(false);
        labelElement2_additionally_1.setVisible(false);
        labelElement2_additionally_2.setVisible(false);
        switch (comboBoxElement.getSelectedIndex()) {
            case 1: // Релейна апаратура
            case 2: // Безконтактна апаратура
            case 3: // Трансформатори
                switch (comboBoxElement2.getSelectedIndex()) {
                    case 1: // Обмотка
                        textFieldElement2_additionally_1.setBounds(170, 160, 100, 20);
                        textFieldElement2_additionally_1.setVisible(true);
                        break;
                    case 3: // Контакти
                        textFieldElement2_additionally_1.setBounds(170, 160, 100, 20);
                        textFieldElement2_additionally_1.setVisible(true);
                        break;
                    case 4: // Передаюча система
                        comboBoxElement2_additionally_1.setBounds(170, 160, 140, 20);
                        comboBoxElement2_additionally_1.addItem("сердечник");
                        comboBoxElement2_additionally_1.addItem("якір");
                        comboBoxElement2_additionally_1.addItem("ярмо");
                        comboBoxElement2_additionally_1.addItem("сектор");
                        comboBoxElement2_additionally_1.addItem("тяга");
                        comboBoxElement2_additionally_1.addItem("вісь");
                        comboBoxElement2_additionally_1.addItem("направляючий гвинт");
                        comboBoxElement2_additionally_1.addItem("інший елемент");
                        comboBoxElement2_additionally_1.setVisible(true);
                        break;
                    case 5: // Випрямляючий елемент
                        comboBoxElement2_additionally_1.setBounds(170, 160, 140, 20);
                        comboBoxElement2_additionally_1.addItem("діод");
                        comboBoxElement2_additionally_1.addItem("транзистор");
                        comboBoxElement2_additionally_1.addItem("стабілітрон");
                        comboBoxElement2_additionally_1.addItem("теристор");
                        comboBoxElement2_additionally_1.addItem("тиратрон");
                        comboBoxElement2_additionally_1.setVisible(true);
                        labelElement2_additionally_1.setBounds(320, 160, 20, 20);
                        labelElement2_additionally_1.setText("тип");
                        labelElement2_additionally_1.setVisible(true);
                        textFieldElement2_additionally_1.setBounds(345, 160, 100, 20);
                        textFieldElement2_additionally_1.setVisible(true);
                        break;
                    case 6: // Конденсатор
                        textFieldElement2_additionally_1.setBounds(170, 160, 100, 20);
                        textFieldElement2_additionally_1.setVisible(true);
                        labelElement2_additionally_1.setBounds(280, 160, 20, 20);
                        labelElement2_additionally_1.setText("тип");
                        labelElement2_additionally_1.setVisible(true);
                        textFieldElement2_additionally_2.setBounds(305, 160, 100, 20);
                        textFieldElement2_additionally_2.setVisible(true);
                        labelElement2_additionally_2.setBounds(415, 160, 40, 20);
                        labelElement2_additionally_2.setText("ємність");
                        labelElement2_additionally_2.setVisible(true);
                        textFieldElement2_additionally_3.setBounds(460, 160, 100, 20);
                        textFieldElement2_additionally_3.setVisible(true);
                        break;
                    case 7: // Резистор
                        textFieldElement2_additionally_1.setBounds(170, 160, 100, 20);
                        textFieldElement2_additionally_1.setVisible(true);
                        labelElement2_additionally_1.setBounds(280, 160, 50, 20);
                        labelElement2_additionally_1.setText("номінал");
                        labelElement2_additionally_1.setVisible(true);
                        textFieldElement2_additionally_2.setBounds(335, 160, 100, 20);
                        textFieldElement2_additionally_2.setVisible(true);
                        break;
                    case 8: // Інший елемент
                        comboBoxElement2_additionally_1.setBounds(170, 160, 140, 20);
                        comboBoxElement2_additionally_1.addItem("термоелемент");
                        comboBoxElement2_additionally_1.addItem("перемикач");
                        comboBoxElement2_additionally_1.addItem("трансформатор");
                        comboBoxElement2_additionally_1.addItem("дросель");
                        comboBoxElement2_additionally_1.addItem("реактор");
                        comboBoxElement2_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 4: // Елементи захисту
                switch (comboBoxElement2.getSelectedIndex()) {
                    case 1: // Плавка вставка
                        comboBoxElement2_additionally_1.setBounds(170, 160, 100, 20);
                        comboBoxElement2_additionally_1.addItem("перегорання");
                        comboBoxElement2_additionally_1.addItem("обрив");
                        comboBoxElement2_additionally_1.setVisible(true);
                        break;
                }
                break;
        }
    }

    // Reason-1:
    private void comboBoxReason1ActionPerformed(java.awt.event.ActionEvent evt) {
        textFieldReason1_additionally_1.setText("");
        textFieldReason1_additionally_1.setVisible(false);
        textFieldReason1_additionally_2.setText("");
        textFieldReason1_additionally_2.setVisible(false);
        textFieldReason1_additionally_3.setText("");
        textFieldReason1_additionally_3.setVisible(false);
        textFieldReason1_additionally_4.setText("");
        textFieldReason1_additionally_4.setVisible(false);
        comboBoxReason1_additionally_1.removeAllItems();
        comboBoxReason1_additionally_1.setVisible(false);
        comboBoxReason1_additionally_2.removeAllItems();
        comboBoxReason1_additionally_2.setVisible(false);
        comboBoxReason1_additionally_3.removeAllItems();
        comboBoxReason1_additionally_3.setVisible(false);
        labelReason1_additionally_1.setVisible(false);
        labelReason1_additionally_2.setVisible(false);
        labelReason1_additionally_3.setVisible(false);
        labelControlKVP_1.setVisible(false);
        labelControlKVP_2.setVisible(false);
        textFieldDayControlKVP.setText("");
        textFieldDayControlKVP.setVisible(false);
        textFieldYearControlKVP.setText("");
        textFieldYearControlKVP.setVisible(false);
        comboBoxMonthControlKVP.setSelectedIndex(0);
        comboBoxMonthControlKVP.setVisible(false);
        labelYearLamp_1.setVisible(false);
        labelYearLamp_2.setVisible(false);
        textFieldYearLamp.setText("");
        textFieldYearLamp.setVisible(false);
        labelVoltage_1.setVisible(false);
        textFieldVoltage.setText("");
        textFieldVoltage.setVisible(false);
        labelVoltage_2.setVisible(false);
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 1: // Пульти, табло, апарати управління
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 1: // Втрата контакту
                        textFieldReason1_additionally_1.setBounds(370, 190, 100, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        comboBoxReason1_additionally_1.setBounds(480, 190, 100, 20);
                        comboBoxReason1_additionally_1.addItem("в роз'ємі");
                        comboBoxReason1_additionally_1.addItem("в гнізді");
                        comboBoxReason1_additionally_1.addItem("на пайці");
                        comboBoxReason1_additionally_1.addItem("в цоколі");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 2: // Втрата контакту
                        textFieldReason1_additionally_1.setBounds(370, 190, 100, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        break;
                    case 3: // Обрив монтажного проводу
                        comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                        comboBoxReason1_additionally_1.addItem("на контакті");
                        comboBoxReason1_additionally_1.addItem("на клемі");
                        comboBoxReason1_additionally_1.addItem("внутрішній");
                        comboBoxReason1_additionally_1.setVisible(true);
                        textFieldReason1_additionally_1.setBounds(475, 190, 100, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        comboBoxReason1_additionally_1ActionPerformed(null);
                        break;
                    case 4: // Закорочування
                        comboBoxReason1_additionally_1.setBounds(370, 190, 130, 20);
                        comboBoxReason1_additionally_1.addItem("контактів");
                        comboBoxReason1_additionally_1.addItem("на корпус");
                        comboBoxReason1_additionally_1.addItem("на інший елемент");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 6: // Механічне пошкодження
                        comboBoxReason1_additionally_1.setBounds(370, 190, 190, 20);
                        comboBoxReason1_additionally_1.addItem("зламалась контактна пружина");
                        comboBoxReason1_additionally_1.addItem("зламалась пружина для фіксації");
                        comboBoxReason1_additionally_1.addItem("зламалась вісь");
                        comboBoxReason1_additionally_1.addItem("руйнування цоколя");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 2: // Шафи, стативи, коробки, ящики
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                    case 2: // Безконтактна апаратура
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 4: // Втрата контакту
                                textFieldReason1_additionally_1.setBounds(370, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Обрив
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("виводу");
                                comboBoxReason1_additionally_1.addItem("внутрішній");
                                comboBoxReason1_additionally_1.addItem("секції");
                                comboBoxReason1_additionally_1.addItem("пластин (відпай)");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 2: // Замикання
                                comboBoxReason1_additionally_1.setBounds(370, 190, 200, 20);
                                comboBoxReason1_additionally_1.addItem("коротке");
                                comboBoxReason1_additionally_1.addItem("міжвиткове");
                                comboBoxReason1_additionally_1.addItem("пластин (неякісна пайка виводів)");
                                comboBoxReason1_additionally_1.addItem("секцій");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("на виводі");
                                comboBoxReason1_additionally_1.addItem("щітка-пластин");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 4: // Заниження ізоляції за рахунок
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("вологи");
                                comboBoxReason1_additionally_1.addItem("вугільного пилу");
                                comboBoxReason1_additionally_1.addItem("старіння");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Невідповідність номіналу струмному навантаженню
                                labelReason1_additionally_1.setBounds(370, 193, 55, 15);
                                labelReason1_additionally_1.setText("I (розрах)");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_1.setBounds(425, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                labelReason1_additionally_2.setBounds(540, 193, 55, 15);
                                labelReason1_additionally_2.setText("І (навант)");
                                labelReason1_additionally_2.setVisible(true);
                                textFieldReason1_additionally_2.setBounds(595, 190, 100, 20);
                                textFieldReason1_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Монтажний провід
                                comboBoxReason1_additionally_1.setBounds(370, 190, 120, 20);
                                comboBoxReason1_additionally_1.addItem("втрата контакту");
                                comboBoxReason1_additionally_1.addItem("обрив");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 140, 20);
                                comboBoxReason1_additionally_1.addItem("в роз'ємі");
                                comboBoxReason1_additionally_1.addItem("в гнізді");
                                comboBoxReason1_additionally_1.addItem("гвинтового кріплення");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                    case 2: // Безконтактна апаратура
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 4: // Втрата контакту
                                textFieldReason1_additionally_1.setBounds(370, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Обрив
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("виводу");
                                comboBoxReason1_additionally_1.addItem("внутрішній");
                                comboBoxReason1_additionally_1.addItem("секції");
                                comboBoxReason1_additionally_1.addItem("пластин (відпай)");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 2: // Замикання
                                comboBoxReason1_additionally_1.setBounds(370, 190, 200, 20);
                                comboBoxReason1_additionally_1.addItem("коротке");
                                comboBoxReason1_additionally_1.addItem("міжвиткове");
                                comboBoxReason1_additionally_1.addItem("пластин (неякісна пайка виводів)");
                                comboBoxReason1_additionally_1.addItem("секцій");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("на виводі");
                                comboBoxReason1_additionally_1.addItem("щітка-пластин");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 4: // Заниження ізоляції за рахунок
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("вологи");
                                comboBoxReason1_additionally_1.addItem("вугільного пилу");
                                comboBoxReason1_additionally_1.addItem("старіння");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Невідповідність номіналу струмному навантаженню
                                labelReason1_additionally_1.setBounds(370, 193, 55, 15);
                                labelReason1_additionally_1.setText("I (розрах)");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_1.setBounds(425, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                labelReason1_additionally_2.setBounds(540, 193, 55, 15);
                                labelReason1_additionally_2.setText("І (навант)");
                                labelReason1_additionally_2.setVisible(true);
                                textFieldReason1_additionally_2.setBounds(595, 190, 100, 20);
                                textFieldReason1_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("в роз'ємі");
                                comboBoxReason1_additionally_1.addItem("в гнізді");
                                comboBoxReason1_additionally_1.addItem("на клемі");
                                comboBoxReason1_additionally_1.addItem("на пайці");
                                comboBoxReason1_additionally_1.addItem("в ніжці");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 2: // Обрив монтажного проводу
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("на контакті");
                                comboBoxReason1_additionally_1.addItem("на клемі");
                                comboBoxReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_1.setBounds(480, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                            case 3: // Плавка вставка
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("перегорання");
                                comboBoxReason1_additionally_1.addItem("обрив");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
            case 4: // Акумулятори
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 1: // Сульфатація
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("недостатній заряд");
                        comboBoxReason1_additionally_1.addItem("к.з. зовнішнього кола");
                        comboBoxReason1_additionally_1.addItem("к.з. пластин між собою");
                        comboBoxReason1_additionally_1.addItem("засмічений електроліт");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 3: // Внутрішнє коротке замикання
                        comboBoxReason1_additionally_1.setBounds(370, 190, 190, 20);
                        comboBoxReason1_additionally_1.addItem("осад на дні");
                        comboBoxReason1_additionally_1.addItem("посипались пластини");
                        comboBoxReason1_additionally_1.addItem("кусочки металу між пластинами");
                        comboBoxReason1_additionally_1.addItem("пошкодження сепаратора");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 4: // Саморозряд
                        comboBoxReason1_additionally_1.setBounds(370, 190, 230, 20);
                        comboBoxReason1_additionally_1.addItem("наявність домішок в електроліті");
                        comboBoxReason1_additionally_1.addItem("зовнішня поверхня залита електролітом");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 6: // Руйнування
                        comboBoxReason1_additionally_1.setBounds(370, 190, 230, 20);
                        comboBoxReason1_additionally_1.addItem("систематичні перезаряди, недозаряди");
                        comboBoxReason1_additionally_1.addItem("тривала експлуатація");
                        comboBoxReason1_additionally_1.addItem("підвищена густина електроліту");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 5: // Сигнали
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 2: // Обрив
                        comboBoxReason1_additionally_1.setBounds(270, 190, 230, 20);
                        comboBoxReason1_additionally_1.addItem("внутрішній");
                        comboBoxReason1_additionally_1.addItem("на клемі");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 5: // Перегорання лампи
                        textFieldReason1_additionally_1.setBounds(265, 190, 100, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        labelReason1_additionally_1.setBounds(370, 193, 60, 15);
                        labelReason1_additionally_1.setText("вогню, U=");
                        labelReason1_additionally_1.setVisible(true);
                        textFieldReason1_additionally_2.setBounds(430, 190, 100, 20);
                        textFieldReason1_additionally_2.setVisible(true);
                        labelReason1_additionally_2.setBounds(535, 193, 70, 15);
                        labelReason1_additionally_2.setText("В., встановл.");
                        labelReason1_additionally_2.setVisible(true);
                        textFieldReason1_additionally_3.setBounds(610, 190, 20, 20);
                        textFieldReason1_additionally_3.setVisible(true);
                        comboBoxReason1_additionally_1.setBounds(635, 190, 75, 20);
                        String[] temp = StringModels.getMonths();
                        for (String s : temp) {
                            comboBoxReason1_additionally_1.addItem(s);
                        }
                        comboBoxReason1_additionally_1.setVisible(true);
                        textFieldReason1_additionally_4.setBounds(715, 190, 30, 20);
                        textFieldReason1_additionally_4.setVisible(true);
                        labelReason1_additionally_3.setBounds(750, 193, 30, 15);
                        labelReason1_additionally_3.setText("року");
                        labelReason1_additionally_3.setVisible(true);
                        comboBoxReason1_additionally_2.setBounds(10, 220, 200, 20);
                        comboBoxReason1_additionally_2.addItem("заводський дефект");
                        comboBoxReason1_additionally_2.addItem("завищена напруга");
                        comboBoxReason1_additionally_2.addItem("завищення терміну служби");
                        comboBoxReason1_additionally_2.setVisible(true);
                        labelControlKVP_1.setVisible(true);
                        labelControlKVP_2.setVisible(true);
                        textFieldDayControlKVP.setVisible(true);
                        textFieldYearControlKVP.setVisible(true);
                        comboBoxMonthControlKVP.setVisible(true);
                        labelYearLamp_1.setVisible(true);
                        labelYearLamp_2.setVisible(true);
                        textFieldYearLamp.setVisible(true);
                        break;
                    case 7: // Рунування фундаменту
                        textFieldReason1_additionally_1.setBounds(265, 190, 300, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        break;
                    case 9: // Інша причина
                        textFieldReason1_additionally_1.setBounds(265, 190, 300, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 2: // Недостатнє врубання ножів
                        comboBoxReason1_additionally_1.setBounds(370, 190, 270, 20);
                        comboBoxReason1_additionally_1.addItem("неправильне регулювання контрольних лінійок");
                        comboBoxReason1_additionally_1.addItem("ослаблення врізної пружини");
                        comboBoxReason1_additionally_1.addItem("нестандартність повзуна");
                        comboBoxReason1_additionally_1.addItem("послаблення болтів кріплення");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 3: // Підгоріли контакти
                        comboBoxReason1_additionally_1.setBounds(370, 190, 180, 20);
                        comboBoxReason1_additionally_1.addItem("контактний тиск вище норми");
                        comboBoxReason1_additionally_1.addItem("несиметричне врубання ножів");
                        comboBoxReason1_additionally_1.addItem("інша причина");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 4: // Механічне пошкодження
                        textFieldReason1_additionally_1.setBounds(370, 190, 300, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        break;
                    case 6: // Обледеніння
                        comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                        comboBoxReason1_additionally_1.addItem("обігрів є");
                        comboBoxReason1_additionally_1.addItem("обігріву нема");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 7: // Заклинювання
                        comboBoxReason1_additionally_1.setBounds(370, 190, 300, 20);
                        comboBoxReason1_additionally_1.addItem("перекіс (неправильне встановлення)");
                        comboBoxReason1_additionally_1.addItem("відсутність змазки");
                        comboBoxReason1_additionally_1.addItem("відсутність проміжку між вістряком і рамною рейкою");
                        comboBoxReason1_additionally_1.addItem("завищена напруга на електродвигуні");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 11: // Електродвигун
                        comboBoxReason1_additionally_1.setBounds(370, 190, 180, 20);
                        comboBoxReason1_additionally_1.addItem("обрив");
                        comboBoxReason1_additionally_1.addItem("замикання");
                        comboBoxReason1_additionally_1.addItem("втрата контакту");
                        comboBoxReason1_additionally_1.addItem("заниження ізоляції за рахунок");
                        comboBoxReason1_additionally_1.addItem("згорання ізоляції");
                        comboBoxReason1_additionally_1.addItem("механічне пошкодження");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 18: // Інше
                        textFieldReason1_additionally_1.setBounds(370, 190, 300, 20);
                        textFieldReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 7: // Повітряні лінії
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 1: // Обрив
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("корозія, старіння");
                        comboBoxReason1_additionally_1.addItem("не закріплений");
                        comboBoxReason1_additionally_1.addItem("дефект матеріалу");
                        comboBoxReason1_additionally_1.addItem("під час виконання робіт");
                        comboBoxReason1_additionally_1.addItem("вітер (зовнішні впливи)");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 2: // Сполучення (к.з.)
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("не відрегульовані");
                        comboBoxReason1_additionally_1.addItem("вітер");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 4: // Кліматичні впливи
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("гроза");
                        comboBoxReason1_additionally_1.addItem("обледеніння");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 8: // Кабельні лінії
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 1: // Обрив
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("внутрішній");
                        comboBoxReason1_additionally_1.addItem("на клемі");
                        comboBoxReason1_additionally_1.addItem("під час виконання робіт");
                        comboBoxReason1_additionally_1.addItem("дефект матеріалу");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                    case 3: // Заниження ізоляції
                        comboBoxReason1_additionally_1.setBounds(370, 190, 150, 20);
                        comboBoxReason1_additionally_1.addItem("старіння");
                        comboBoxReason1_additionally_1.addItem("потрапляння вологи");
                        comboBoxReason1_additionally_1.setVisible(true);
                        break;
                }
                break;
            case 9: // Рейкові кола
                switch (comboBoxElement.getSelectedIndex()) {
                    case 1: // Релейна апаратура
                    case 2: // Безконтактна апаратура
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 4: // Втрата контакту
                                textFieldReason1_additionally_1.setBounds(370, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 3: // Трансформатори
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Обрив
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("виводу");
                                comboBoxReason1_additionally_1.addItem("внутрішній");
                                comboBoxReason1_additionally_1.addItem("секції");
                                comboBoxReason1_additionally_1.addItem("пластин (відпай)");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 2: // Замикання
                                comboBoxReason1_additionally_1.setBounds(370, 190, 200, 20);
                                comboBoxReason1_additionally_1.addItem("коротке");
                                comboBoxReason1_additionally_1.addItem("міжвиткове");
                                comboBoxReason1_additionally_1.addItem("пластин (неякісна пайка виводів)");
                                comboBoxReason1_additionally_1.addItem("секцій");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("на виводі");
                                comboBoxReason1_additionally_1.addItem("щітка-пластин");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 4: // Заниження ізоляції за рахунок
                                comboBoxReason1_additionally_1.setBounds(370, 190, 110, 20);
                                comboBoxReason1_additionally_1.addItem("вологи");
                                comboBoxReason1_additionally_1.addItem("вугільного пилу");
                                comboBoxReason1_additionally_1.addItem("старіння");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 4: // Елементи захисту
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Невідповідність номіналу струмному навантаженню
                                labelReason1_additionally_1.setBounds(370, 193, 55, 15);
                                labelReason1_additionally_1.setText("I (розрах)");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_1.setBounds(425, 190, 100, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                labelReason1_additionally_2.setBounds(540, 193, 55, 15);
                                labelReason1_additionally_2.setText("І (навант)");
                                labelReason1_additionally_2.setVisible(true);
                                textFieldReason1_additionally_2.setBounds(595, 190, 100, 20);
                                textFieldReason1_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                    case 5: // Рейкові з'єднувачі
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Обрив
                            case 2: // Відсутність
                                textFieldReason1_additionally_1.setBounds(370, 190, 50, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                labelReason1_additionally_1.setBounds(430, 193, 50, 20);
                                labelReason1_additionally_1.setText("км.");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_2.setBounds(460, 190, 50, 20);
                                textFieldReason1_additionally_2.setVisible(true);
                                labelReason1_additionally_2.setBounds(520, 193, 50, 20);
                                labelReason1_additionally_2.setText("пк.");
                                labelReason1_additionally_2.setVisible(true);
                                textFieldReason1_additionally_3.setBounds(550, 190, 50, 20);
                                textFieldReason1_additionally_3.setVisible(true);
                                labelReason1_additionally_3.setBounds(610, 193, 50, 20);
                                labelReason1_additionally_3.setText("шт.");
                                labelReason1_additionally_3.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 300, 20);
                                comboBoxReason1_additionally_1.addItem("в місці з'єднання штепселя з рейкою");
                                comboBoxReason1_additionally_1.addItem("погано забитий");
                                comboBoxReason1_additionally_1.addItem("нестандартний");
                                comboBoxReason1_additionally_1.addItem("в обжимі");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                    case 6: // Інші елементи
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Обрив
                            case 2: // Відсутність
                                textFieldReason1_additionally_1.setBounds(370, 190, 50, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                labelReason1_additionally_1.setBounds(430, 193, 50, 20);
                                labelReason1_additionally_1.setText("км.");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_2.setBounds(460, 190, 50, 20);
                                textFieldReason1_additionally_2.setVisible(true);
                                labelReason1_additionally_2.setBounds(520, 193, 50, 20);
                                labelReason1_additionally_2.setText("пк.");
                                labelReason1_additionally_2.setVisible(true);
                                textFieldReason1_additionally_3.setBounds(550, 190, 50, 20);
                                textFieldReason1_additionally_3.setVisible(true);
                                labelReason1_additionally_3.setBounds(610, 193, 50, 20);
                                labelReason1_additionally_3.setText("шт.");
                                labelReason1_additionally_3.setVisible(true);
                                break;
                            case 3: // Втрата контакту
                                comboBoxReason1_additionally_1.setBounds(370, 190, 300, 20);
                                comboBoxReason1_additionally_1.addItem("в місці з'єднання штепселя з рейкою");
                                comboBoxReason1_additionally_1.addItem("погано забитий");
                                comboBoxReason1_additionally_1.addItem("нестандартний");
                                comboBoxReason1_additionally_1.addItem("в обжимі");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                            case 8: // Вихід з ладу обмотки
                                comboBoxReason1_additionally_1.setBounds(370, 190, 100, 20);
                                comboBoxReason1_additionally_1.addItem("сигнальної");
                                comboBoxReason1_additionally_1.addItem("тягової");
                                comboBoxReason1_additionally_1.addItem("обидвох");
                                comboBoxReason1_additionally_1.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private void comboBoxReason1_additionally_1ActionPerformed(java.awt.event.ActionEvent evt) {
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 1: // Пульти, табло, апарати управління
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 3: // Обрив монтажного проводу
                        switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                            case 0: // На контакті
                            case 1: // На клемі
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                            case 2: // Внутрішній
                                textFieldReason1_additionally_1.setVisible(false);
                                break;
                        }
                        break;
                }
                break;
            case 2: // Шафи, стативи, коробки, ящики
                switch (comboBoxElement.getSelectedIndex()) {
                    case 3: // Трансформатори
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 3: // Втрата контакту
                                switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                                    case 0: //На виводі
                                        comboBoxReason1_additionally_2.removeAllItems();
                                        comboBoxReason1_additionally_2.setVisible(false);
                                        break;
                                    case 1: // Щітка-пластин
                                        comboBoxReason1_additionally_2.setBounds(480, 190, 220, 20);
                                        comboBoxReason1_additionally_2.addItem("слабкий тиск");
                                        comboBoxReason1_additionally_2.addItem("зсув щітки відносно нейтралі");
                                        comboBoxReason1_additionally_2.addItem("засмічення вугільним пилом");
                                        comboBoxReason1_additionally_2.addItem("стирання щіток");
                                        comboBoxReason1_additionally_2.addItem("послаблення пружини щіткотримача");
                                        comboBoxReason1_additionally_2.setVisible(true);
                                        break;
                                }
                                break;
                        }
                        break;
                    case 5: // Інші елементи
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 1: // Монтажний провід
                                switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                                    case 0: // Втрата контакту
                                        textFieldReason1_additionally_1.setBounds(500, 190, 100, 20);
                                        textFieldReason1_additionally_1.setVisible(true);
                                        comboBoxReason1_additionally_2.removeAllItems();
                                        comboBoxReason1_additionally_2.setBounds(610, 190, 70, 20);
                                        comboBoxReason1_additionally_2.addItem("на пайці");
                                        comboBoxReason1_additionally_2.addItem("на клемі");
                                        comboBoxReason1_additionally_2.setVisible(true);
                                        break;
                                    case 1: // Обрив
                                        comboBoxReason1_additionally_2.removeAllItems();
                                        comboBoxReason1_additionally_2.setBounds(500, 190, 90, 20);
                                        comboBoxReason1_additionally_2.addItem("на контакті");
                                        comboBoxReason1_additionally_2.addItem("на клемі");
                                        comboBoxReason1_additionally_2.setVisible(true);
                                        textFieldReason1_additionally_1.setBounds(600, 190, 100, 20);
                                        textFieldReason1_additionally_1.setVisible(true);
                                        break;
                                }
                                break;
                            case 3: // Втрата контакту
                                switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                                    case 0: // В роз'ємі
                                        textFieldReason1_additionally_1.setBounds(520, 190, 100, 20);
                                        textFieldReason1_additionally_1.setVisible(true);
                                        break;
                                    case 1: // В гнізді
                                    case 2: // Гвинтового кріплення
                                        textFieldReason1_additionally_1.setVisible(false);
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
            case 3: // Щитові електропостачальні установки
                switch (comboBoxElement.getSelectedIndex()) {
                    case 3: // Трансформатори
                        switch (comboBoxReason1.getSelectedIndex()) {
                            case 3: // Втрата контакту
                                switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                                    case 0: //На виводі
                                        comboBoxReason1_additionally_2.removeAllItems();
                                        comboBoxReason1_additionally_2.setVisible(false);
                                        break;
                                    case 1: // Щітка-пластин
                                        comboBoxReason1_additionally_2.setBounds(480, 190, 220, 20);
                                        comboBoxReason1_additionally_2.addItem("слабкий тиск");
                                        comboBoxReason1_additionally_2.addItem("зсув щітки відносно нейтралі");
                                        comboBoxReason1_additionally_2.addItem("засмічення вугільним пилом");
                                        comboBoxReason1_additionally_2.addItem("стирання щіток");
                                        comboBoxReason1_additionally_2.addItem("послаблення пружини щіткотримача");
                                        comboBoxReason1_additionally_2.setVisible(true);
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
            case 4: // Акумулятори
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 6: // Руйнування
                        switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                            case 1: // Тривала експлуатація
                                labelReason1_additionally_1.setBounds(610, 193, 90, 15);
                                labelReason1_additionally_1.setText("рік встановлення");
                                labelReason1_additionally_1.setVisible(true);
                                textFieldReason1_additionally_1.setBounds(705, 190, 40, 20);
                                textFieldReason1_additionally_1.setVisible(true);
                                break;
                            case 0: // Систематичні перезаряди, недозаряди
                            case 2: // Підвищена густина електроліту
                                labelReason1_additionally_1.setVisible(false);
                                textFieldReason1_additionally_1.setText("");
                                textFieldReason1_additionally_1.setVisible(false);
                                break;
                        }
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 11: // Електродвигун
                        comboBoxReason1_additionally_2.setVisible(false);
                        comboBoxReason1_additionally_2.removeAllItems();
                        comboBoxReason1_additionally_3.setVisible(false);
                        comboBoxReason1_additionally_3.removeAllItems();
                        switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                            case 0: // Обрив
                                comboBoxReason1_additionally_2.removeAllItems();
                                comboBoxReason1_additionally_2.setBounds(560, 190, 120, 20);
                                comboBoxReason1_additionally_2.addItem("виводу");
                                comboBoxReason1_additionally_2.addItem("внутрішній");
                                comboBoxReason1_additionally_2.addItem("секції");
                                comboBoxReason1_additionally_2.addItem("пластин (відпай)");
                                comboBoxReason1_additionally_2.setVisible(true);
                                break;
                            case 1: // Замикання
                                comboBoxReason1_additionally_2.removeAllItems();
                                comboBoxReason1_additionally_2.setBounds(560, 190, 220, 20);
                                comboBoxReason1_additionally_2.addItem("коротке");
                                comboBoxReason1_additionally_2.addItem("міжвиткове");
                                comboBoxReason1_additionally_2.addItem("пластин (неякісна пайка виводів)");
                                comboBoxReason1_additionally_2.addItem("секцій");
                                comboBoxReason1_additionally_2.setVisible(true);
                                break;
                            case 2: // Втрата контакту
                                comboBoxReason1_additionally_2.removeAllItems();
                                comboBoxReason1_additionally_2.setBounds(560, 190, 110, 20);
                                comboBoxReason1_additionally_2.addItem("на виводі");
                                comboBoxReason1_additionally_2.addItem("щітка-пластини");
                                comboBoxReason1_additionally_2.setVisible(true);
                                break;
                            case 3: // Заниження ізоляції за рахунок
                                comboBoxReason1_additionally_2.removeAllItems();
                                comboBoxReason1_additionally_2.setBounds(560, 190, 110, 20);
                                comboBoxReason1_additionally_2.addItem("вологи");
                                comboBoxReason1_additionally_2.addItem("вугільного пилу");
                                comboBoxReason1_additionally_2.addItem("старіння");
                                comboBoxReason1_additionally_2.setVisible(true);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private void comboBoxReason1_additionally_2ActionPerformed(java.awt.event.ActionEvent evt) {
        switch (comboBoxShObjects.getSelectedIndex()) {
            case 5: // Сигнали
                switch (comboBoxReason1_additionally_2.getSelectedIndex()) {
                    case 1: // Завищена напруга
                        labelVoltage_1.setVisible(true);
                        textFieldVoltage.setVisible(true);
                        labelVoltage_2.setVisible(true);
                        break;
                    default:
                        labelVoltage_1.setVisible(false);
                        textFieldVoltage.setVisible(false);
                        labelVoltage_2.setVisible(false);
                        break;
                }
                break;
            case 6: // Приводи, замки
                switch (comboBoxReason1.getSelectedIndex()) {
                    case 11: // Електродвигун
                        switch (comboBoxReason1_additionally_1.getSelectedIndex()) {
                            case 2: // Втрата контакту
                                switch (comboBoxReason1_additionally_2.getSelectedIndex()) {
                                    case 0: // На виводі
                                        comboBoxReason1_additionally_3.setVisible(false);
                                        comboBoxReason1_additionally_3.removeAllItems();
                                        break;
                                    case 1: //Щітка-пластини
                                        comboBoxReason1_additionally_3.setBounds(10, 220, 220, 20);
                                        comboBoxReason1_additionally_3.addItem("слабкий тиск");
                                        comboBoxReason1_additionally_3.addItem("зсув щітки відносно нейтралі");
                                        comboBoxReason1_additionally_3.addItem("засмічення вугільним пилом");
                                        comboBoxReason1_additionally_3.addItem("стирання щіток");
                                        comboBoxReason1_additionally_3.addItem("послаблення пружини щіткотримача");
                                        comboBoxReason1_additionally_3.setVisible(true);
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    // Reason-2:
    private void comboBoxReason2ActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxReason2_additionally_1.setVisible(false);
        comboBoxReason2_additionally_1.removeAllItems();
        labelReason2_additionally_1.setVisible(false);
        textFieldReason2_additionally_1.setText("");
        textFieldReason2_additionally_1.setVisible(false);
        switch (comboBoxReason2.getSelectedIndex()) {
            case 1: // Конструктивні
                comboBoxReason2_additionally_1.setBounds(180, 250, 80, 20);
                comboBoxReason2_additionally_1.addItem("Проектні");
                comboBoxReason2_additionally_1.addItem("Заводські");
                comboBoxReason2_additionally_1.setVisible(true);
                break;
            case 2: // Експлуатаційні
                comboBoxReason2_additionally_1.setBounds(180, 250, 420, 20);
                String[] temp = StringModels.getShReasons2OperationalReasons();
                for (String s : temp) {
                    comboBoxReason2_additionally_1.addItem(s);
                }
                comboBoxReason2_additionally_1.setVisible(true);
                break;
        }
    }

    private void comboBoxReason2_additionally_1ActionPerformed(java.awt.event.ActionEvent evt) {
        labelReason2_additionally_1.setVisible(false);
        textFieldReason2_additionally_1.setVisible(false);
        switch (comboBoxReason2.getSelectedIndex()) {
            case 2: // Експлуатаційні
                switch (comboBoxReason2_additionally_1.getSelectedIndex()) {
                    case 1:
                    case 2:
                    case 3:
                        labelReason2_additionally_1.setVisible(true);
                        textFieldReason2_additionally_1.setVisible(true);
                        break;
                }
                break;
        }
    }

    @Override
    public boolean canContinue() {
        if (comboBoxShObjects.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вибрано категорію об'єкта");
            return false;
        }
        if (comboBoxShObjects.getSelectedIndex() != 9) {
            if (comboBoxShObjects_additionally_1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Не вибрано об'єкт");
                return false;
            }
        }
        if (comboBoxShObjects.getSelectedIndex() != 10) {
            if (comboBoxElement.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Не обрано елемент");
                return false;
            }
        }
        if ((comboBoxShObjects.getSelectedIndex() == 1) || (comboBoxShObjects.getSelectedIndex() == 4) || (comboBoxShObjects.getSelectedIndex() == 5) || (comboBoxShObjects.getSelectedIndex() == 6) || (comboBoxShObjects.getSelectedIndex() == 7) || (comboBoxShObjects.getSelectedIndex() == 8)) {
            if (comboBoxReason1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Не вказано причину");
                return false;
            }
        }
        if (comboBoxReason2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вказано причини");
            return false;
        }
        if ((comboBoxReason2.getSelectedIndex() == 2) && (comboBoxReason2_additionally_1.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null, "Не вказано причини");
            return false;
        }
        ArrayList<JComboBox> comboList = new ArrayList<>();
        comboList.add(comboBoxShObjects_additionally_2);
        comboList.add(comboBoxShObjects2_additionally);
        comboList.add(comboBoxCheckingOnSchedule);
        comboList.add(comboBoxCheckingOnScheduleRK);
        comboList.add(comboBoxResistanceMonth);
        comboList.add(comboBoxElement_additionally_1);
        comboList.add(comboBoxElement_additionally_2);
        comboList.add(comboBoxElement_additionally_3);
        comboList.add(comboBoxElement_additionally_4);
        comboList.add(comboBoxElement2);
        comboList.add(comboBoxElement2_additionally_1);
        comboList.add(comboBoxReason1_additionally_1);
        comboList.add(comboBoxReason1_additionally_2);
        comboList.add(comboBoxReason1_additionally_3);
        comboList.add(comboBoxReason2_additionally_1);
        comboList.add(comboBoxMonthControlKVP);
        for (JComboBox<String> jcs : comboList) {
            if ((jcs.isVisible()) && (jcs.getItemCount() > 0) && (jcs.getSelectedItem().equals("-"))) {
                JOptionPane.showMessageDialog(null, "Не уточнено всі дані випадаючих списків");
                return false;
            }
        }
        ArrayList<JTextField> textFieldList = new ArrayList<>();
        textFieldList.add(textFieldShObjects2_additionally);
        textFieldList.add(textFieldCheckingOnSchedule_1);
        textFieldList.add(textFieldCheckingOnSchedule_2);
        textFieldList.add(textFieldNumberOfWires);
        textFieldList.add(textFieldNameOfWires);
        textFieldList.add(textFieldCable_1);
        textFieldList.add(textFieldCable_2);
        textFieldList.add(textFieldCable_3);
        textFieldList.add(textFieldResistanceDay);
        textFieldList.add(textFieldResistanceYear);
        textFieldList.add(textFieldElement_additionally_1);
        textFieldList.add(textFieldElement_additionally_2);
        textFieldList.add(textFieldElement_additionally_3);
        textFieldList.add(textFieldElement_additionally_4);
        textFieldList.add(textFieldElement_additionally_5);
        textFieldList.add(textFieldTested_1);
        textFieldList.add(textFieldTestedDay);
        textFieldList.add(textFieldTestedYear);
        textFieldList.add(textFieldCheckingOnScheduleRK_1);
        textFieldList.add(textFieldCheckingOnScheduleRK_2);
        textFieldList.add(textFieldElementRemote_additionally_1);
        textFieldList.add(textFieldElement2_additionally_1);
        textFieldList.add(textFieldElement2_additionally_2);
        textFieldList.add(textFieldElement2_additionally_3);
        textFieldList.add(textFieldReason1_additionally_1);
        textFieldList.add(textFieldReason1_additionally_2);
        textFieldList.add(textFieldReason1_additionally_3);
        textFieldList.add(textFieldReason1_additionally_4);
        textFieldList.add(textFieldDayControlKVP);
        textFieldList.add(textFieldYearControlKVP);
        textFieldList.add(textFieldYearLamp);
        textFieldList.add(textFieldVoltage);
        textFieldList.add(textFieldReason2_additionally_1);
        for (JTextField jtf : textFieldList) {
            if ((jtf.isVisible()) && (jtf.getText().trim().equals(""))) {
                JOptionPane.showMessageDialog(null, "Не заповнено всі поля");
                return false;
            }
        }
        if ((comboBoxShObjects.getSelectedIndex() == 2) || (comboBoxShObjects.getSelectedIndex() == 3)) {
            if ((comboBoxElement.getSelectedIndex() != 0) && (comboBoxElement.getSelectedIndex() != 5)) {
                int iDay, iYear;
                try {
                    iDay = Integer.valueOf(textFieldTestedDay.getText());
                    if ((iDay < 1) || (iDay > 31)) {
                        JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                        return false;
                    }
                    iYear = Integer.valueOf(textFieldTestedYear.getText());
                    if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                        JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                        return false;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                    return false;
                }
                String tempMonth;
                if (comboBoxTestedMonth.getSelectedIndex() <= 8) {
                    tempMonth = "0".concat(String.valueOf(comboBoxTestedMonth.getSelectedIndex() + 1));
                } else {
                    tempMonth = String.valueOf(comboBoxTestedMonth.getSelectedIndex() + 1);
                }
                String dateStr = textFieldTestedDay.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldTestedYear.getText()))));
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    sdf.parse(dateStr);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                    return false;
                }
            }
        }
        if (comboBoxShObjects.getSelectedIndex() == 9) {
            if ((comboBoxElement.getSelectedIndex() != 0) && (comboBoxElement.getSelectedIndex() != 5) && (comboBoxElement.getSelectedIndex() != 6)) {
                int iDay, iYear;
                try {
                    iDay = Integer.valueOf(textFieldTestedDay.getText());
                    if ((iDay < 1) || (iDay > 31)) {
                        JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                        return false;
                    }
                    iYear = Integer.valueOf(textFieldTestedYear.getText());
                    if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                        JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                        return false;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                    return false;
                }
                String tempMonth;
                if (comboBoxTestedMonth.getSelectedIndex() <= 8) {
                    tempMonth = "0".concat(String.valueOf(comboBoxTestedMonth.getSelectedIndex() + 1));
                } else {
                    tempMonth = String.valueOf(comboBoxTestedMonth.getSelectedIndex() + 1);
                }
                String dateStr = textFieldTestedDay.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldTestedYear.getText()))));
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    sdf.parse(dateStr);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки елементу");
                    return false;
                }
            }
        }
        if ((comboBoxShObjects.getSelectedIndex() == 5) && (comboBoxReason1.getSelectedIndex() == 5)) { // Сигнали + Лампочка
            int iDay, iYear;
            try {
                iDay = Integer.valueOf(textFieldReason1_additionally_3.getText());
                if ((iDay < 1) || (iDay > 31)) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата встановлення лампи");
                    return false;
                }
                iYear = Integer.valueOf(textFieldReason1_additionally_4.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата встановлення лампи");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата встановлення лампи");
                return false;
            }
            String tempMonth;
            if (comboBoxReason1_additionally_1.getSelectedIndex() <= 8) {
                tempMonth = "0".concat(String.valueOf(comboBoxReason1_additionally_1.getSelectedIndex() + 1));
            } else {
                tempMonth = String.valueOf(comboBoxReason1_additionally_1.getSelectedIndex() + 1);
            }
            String dateStr = textFieldReason1_additionally_3.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldReason1_additionally_4.getText()))));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата встановлення лампи");
                return false;
            }

            try {
                iDay = Integer.valueOf(textFieldDayControlKVP.getText());
                if ((iDay < 1) || (iDay > 31)) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки в КВП");
                    return false;
                }
                iYear = Integer.valueOf(textFieldYearControlKVP.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки в КВП");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки в КВП");
                return false;
            }
            if (comboBoxMonthControlKVP.getSelectedIndex() <= 8) {
                tempMonth = "0".concat(String.valueOf(comboBoxMonthControlKVP.getSelectedIndex() + 1));
            } else {
                tempMonth = String.valueOf(comboBoxMonthControlKVP.getSelectedIndex() + 1);
            }
            dateStr = textFieldDayControlKVP.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldYearControlKVP.getText()))));
            sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки в КВП");
                return false;
            }

            try {
                iYear = Integer.valueOf(textFieldYearLamp.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введено рік випуску лампи");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введено рік випуску лампи");
                return false;
            }
        }
        if (comboBoxShObjects.getSelectedIndex() == 6) { // Приводи, замки
            int iDay, iYear;
            try {
                iDay = Integer.valueOf(textFieldCheckingOnSchedule_1.getText());
                if ((iDay < 1) || (iDay > 31)) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки приводу по графіку");
                    return false;
                }
                iYear = Integer.valueOf(textFieldCheckingOnSchedule_2.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки приводу по графіку");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки приводу по графіку");
                return false;
            }
            String tempMonth;
            if (comboBoxCheckingOnSchedule.getSelectedIndex() <= 8) {
                tempMonth = "0".concat(String.valueOf(comboBoxCheckingOnSchedule.getSelectedIndex() + 1));
            } else {
                tempMonth = String.valueOf(comboBoxCheckingOnSchedule.getSelectedIndex() + 1);
            }
            String dateStr = textFieldCheckingOnSchedule_1.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldCheckingOnSchedule_2.getText()))));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки приводу по графіку");
                return false;
            }
        }
        if (comboBoxShObjects.getSelectedIndex() == 8) { // Кабельні лінії
            int iDay, iYear;
            try {
                iDay = Integer.valueOf(textFieldResistanceDay.getText());
                if ((iDay < 1) || (iDay > 31)) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку (вимір опору ізоляції)");
                    return false;
                }
                iYear = Integer.valueOf(textFieldResistanceYear.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку (вимір опору ізоляції)");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку (вимір опору ізоляції)");
                return false;
            }
            String tempMonth;
            if (comboBoxResistanceMonth.getSelectedIndex() <= 8) {
                tempMonth = "0".concat(String.valueOf(comboBoxResistanceMonth.getSelectedIndex() + 1));
            } else {
                tempMonth = String.valueOf(comboBoxResistanceMonth.getSelectedIndex() + 1);
            }
            String dateStr = textFieldResistanceDay.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldResistanceYear.getText()))));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку (вимір опору ізоляції)");
                return false;
            }
        }
        if (((comboBoxShObjects.getSelectedIndex() == 9) && (comboBoxElement.getSelectedIndex() == 5)) || ((comboBoxShObjects.getSelectedIndex() == 8) && (comboBoxElement.getSelectedIndex() == 2))) { // Рейкові кола + Рейкові з'єднувачі
            int iDay, iYear;
            try {
                iDay = Integer.valueOf(textFieldCheckingOnScheduleRK_1.getText());
                if ((iDay < 1) || (iDay > 31)) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку Техпроцесу");
                    return false;
                }
                iYear = Integer.valueOf(textFieldCheckingOnScheduleRK_2.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку Техпроцесу");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку Техпроцесу");
                return false;
            }
            String tempMonth;
            if (comboBoxCheckingOnScheduleRK.getSelectedIndex() <= 8) {
                tempMonth = "0".concat(String.valueOf(comboBoxCheckingOnScheduleRK.getSelectedIndex() + 1));
            } else {
                tempMonth = String.valueOf(comboBoxCheckingOnScheduleRK.getSelectedIndex() + 1);
            }
            String dateStr = textFieldCheckingOnScheduleRK_1.getText().concat(".".concat(tempMonth.concat(".".concat(textFieldCheckingOnScheduleRK_2.getText()))));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Неправильно введена дата перевірки по графіку Техпроцесу");
                return false;
            }
        }
        // todo RK
        if (comboBoxShObjects.getSelectedIndex() == 8) { // Кабельні лінії
            int iYear;
            try {
                iYear = Integer.valueOf(textFieldCable_2.getText());
                if ((iYear < 1900) || (iYear > DateTime.getYearInt())) {
                    JOptionPane.showMessageDialog(null, "Неправильно введено рік прокладання кабелю");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Неправильно введено рік прокладання кабелю");
                return false;
            }
            try {
                Double.valueOf(textFieldCable_3.getText().replaceAll(",", "."));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Введено нечислове значення для глибини закопки кабелю");
                return false;
            }
        }
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        ArrayList<String> tempArray = new ArrayList<>();
        ArrayList<Component> components = new ArrayList<>();
        tempArray.add("Відповідальна служба - Ш;");
        String temp;

        // Object:
        if (comboBoxShObjects.getSelectedIndex() != 9) {
            temp = ("Об'єкт: ").concat((String) comboBoxShObjects.getSelectedItem()).concat(" - ").concat((String) comboBoxShObjects_additionally_1.getSelectedItem()).concat(" ");
            if (comboBoxShObjects_additionally_2.isVisible()) {components.add(comboBoxShObjects_additionally_2);}
            if (textFieldShObjects2_additionally.isVisible()) {components.add(textFieldShObjects2_additionally);}
            if (comboBoxShObjects2_additionally.isVisible()) {components.add(comboBoxShObjects2_additionally);}
            if (!components.isEmpty()) {
                tempArray.add(temp.concat(SortComponents.sortAndWrite(components)).concat(";"));
            } else {
                tempArray.add(temp.concat(";"));
            }
            components.clear();
            if (labelCheckingOnSchedule_1.isVisible()) {components.add(labelCheckingOnSchedule_1);}
            if (textFieldCheckingOnSchedule_1.isVisible()) {components.add(textFieldCheckingOnSchedule_1);}
            if (comboBoxCheckingOnSchedule.isVisible()) {components.add(comboBoxCheckingOnSchedule);}
            if (textFieldCheckingOnSchedule_2.isVisible()) {components.add(textFieldCheckingOnSchedule_2);}
            if (labelCheckingOnSchedule_2.isVisible()) {components.add(labelCheckingOnSchedule_2);}
            if (!components.isEmpty()) {
                tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
            }
            components.clear();
            if (labelNumberOfWires.isVisible()) {components.add(labelNumberOfWires);}
            if (textFieldNumberOfWires.isVisible()) {components.add(textFieldNumberOfWires);}
            if (labelNameOfWires.isVisible()) {components.add(labelNameOfWires);}
            if (textFieldNameOfWires.isVisible()) {components.add(textFieldNameOfWires);}
            if (labelCable_1.isVisible()) {components.add(labelCable_1);}
            if (textFieldCable_1.isVisible()) {components.add(textFieldCable_1);}
            if (labelCable_2.isVisible()) {components.add(labelCable_2);}
            if (textFieldCable_2.isVisible()) {components.add(textFieldCable_2);}
            if (labelCable_3.isVisible()) {components.add(labelCable_3);}
            if (textFieldCable_3.isVisible()) {components.add(textFieldCable_3);}
            if (labelCable_4.isVisible()) {components.add(labelCable_4);}
            if (labelResistance_1.isVisible()) {components.add(labelResistance_1);}
            if (textFieldResistanceDay.isVisible()) {components.add(textFieldResistanceDay);}
            if (comboBoxResistanceMonth.isVisible()) {components.add(comboBoxResistanceMonth);}
            if (textFieldResistanceYear.isVisible()) {components.add(textFieldResistanceYear);}
            if (labelResistance_2.isVisible()) {components.add(labelResistance_2);}
            if (!components.isEmpty()) {
                tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
            }
            components.clear();
        } else {
            tempArray.add("Об'єкт: Рейкове коло;");
        }

        // Element-1:
        if (comboBoxElement.isVisible()) {
            temp = "Елемент: ".concat((String) comboBoxElement.getSelectedItem()).concat(" ");
            if (comboBoxElement_additionally_1.isVisible()) {
                temp = temp.concat("- ").concat((String) comboBoxElement_additionally_1.getSelectedItem()).concat(" ");
            }
            if (textFieldElement_additionally_1.isVisible()) {components.add(textFieldElement_additionally_1);}
            if (labelElement_additionally_1.isVisible()) {components.add(labelElement_additionally_1);}
            if (comboBoxElement_additionally_2.isVisible()) {components.add(comboBoxElement_additionally_2);}
            if (labelElement_additionally_2.isVisible()) {components.add(labelElement_additionally_2);}
            if (textFieldElement_additionally_2.isVisible()) {components.add(textFieldElement_additionally_2);}
            if (labelElement_additionally_3.isVisible()) {components.add(labelElement_additionally_3);}
            if (textFieldElement_additionally_3.isVisible()) {components.add(textFieldElement_additionally_3);}
            if (comboBoxElement_additionally_3.isVisible()) {components.add(comboBoxElement_additionally_3);}
            if (textFieldElement_additionally_4.isVisible()) {components.add(textFieldElement_additionally_4);}
            if (textFieldElement_additionally_5.isVisible()) {components.add(textFieldElement_additionally_5);}
            if (labelElement_additionally_4.isVisible()) {components.add(labelElement_additionally_4);}
            if (labelTested_1.isVisible()) {components.add(labelTested_1);}
            if (textFieldTested_1.isVisible()) {components.add(textFieldTested_1);}
            if (labelTested_2.isVisible()) {components.add(labelTested_2);}
            if (textFieldTestedDay.isVisible()) {components.add(textFieldTestedDay);}
            if (comboBoxTestedMonth.isVisible()) {components.add(comboBoxTestedMonth);}
            if (textFieldTestedYear.isVisible()) {components.add(textFieldTestedYear);}
            if (labelTested_3.isVisible()) {components.add(labelTested_3);}
            if (textFieldElementRemote_additionally_1.isVisible()) {components.add(textFieldElementRemote_additionally_1);}
            if (comboBoxElement_additionally_4.isVisible()) {components.add(comboBoxElement_additionally_4);}
            if (labelCheckingOnScheduleRK_1.isVisible()) {components.add(labelCheckingOnScheduleRK_1);}
            if (textFieldCheckingOnScheduleRK_1.isVisible()) {components.add(textFieldCheckingOnScheduleRK_1);}
            if (comboBoxCheckingOnScheduleRK.isVisible()) {components.add(comboBoxCheckingOnScheduleRK);}
            if (textFieldCheckingOnScheduleRK_2.isVisible()) {components.add(textFieldCheckingOnScheduleRK_2);}
            if (labelCheckingOnScheduleRK_2.isVisible()) {components.add(labelCheckingOnScheduleRK_2);}
            if (!components.isEmpty()) {
                temp = temp.concat(SortComponents.sortAndWrite(components));
            }
            components.clear();
            tempArray.add(temp.concat(";"));
        }

        // Element-2:
        if (comboBoxElement2.isVisible()) {
            temp = ((String) comboBoxElement2.getSelectedItem());
            if (comboBoxElement2_additionally_1.isVisible()) {
                temp = temp.concat(" - ").concat((String) comboBoxElement2_additionally_1.getSelectedItem());
            }
            if (textFieldElement2_additionally_1.isVisible()) {components.add(textFieldElement2_additionally_1);}
            if (textFieldElement2_additionally_2.isVisible()) {components.add(textFieldElement2_additionally_2);}
            if (textFieldElement2_additionally_3.isVisible()) {components.add(textFieldElement2_additionally_3);}
            if (labelElement2_additionally_1.isVisible()) {components.add(labelElement2_additionally_1);}
            if (labelElement2_additionally_2.isVisible()) {components.add(labelElement2_additionally_2);}
            if (!components.isEmpty()) {
                temp = temp.concat(" ").concat(SortComponents.sortAndWrite(components));
            }
            components.clear();
            tempArray.add(temp.concat(";"));
        }

        // Reason-1:
        if (comboBoxReason1.isVisible()) {
            if (labelReason1.isVisible()) {components.add(labelReason1);}
            if (comboBoxReason1.isVisible()) {components.add(comboBoxReason1);}
            if (textFieldReason1_additionally_1.isVisible()) {components.add(textFieldReason1_additionally_1);}
            if (textFieldReason1_additionally_2.isVisible()) {components.add(textFieldReason1_additionally_2);}
            if (textFieldReason1_additionally_3.isVisible()) {components.add(textFieldReason1_additionally_3);}
            if (textFieldReason1_additionally_4.isVisible()) {components.add(textFieldReason1_additionally_4);}
            if (comboBoxReason1_additionally_1.isVisible()) {components.add(comboBoxReason1_additionally_1);}
            if (comboBoxReason1_additionally_2.isVisible()) {components.add(comboBoxReason1_additionally_2);}
            if (comboBoxReason1_additionally_3.isVisible()) {components.add(comboBoxReason1_additionally_3);}
            if (labelReason1_additionally_1.isVisible()) {components.add(labelReason1_additionally_1);}
            if (labelReason1_additionally_2.isVisible()) {components.add(labelReason1_additionally_2);}
            if (labelReason1_additionally_3.isVisible()) {components.add(labelReason1_additionally_3);}
            if (labelControlKVP_1.isVisible()) {components.add(labelControlKVP_1);}
            if (labelControlKVP_2.isVisible()) {components.add(labelControlKVP_2);}
            if (textFieldDayControlKVP.isVisible()) {components.add(textFieldDayControlKVP);}
            if (textFieldYearControlKVP.isVisible()) {components.add(textFieldYearControlKVP);}
            if (comboBoxMonthControlKVP.isVisible()) {components.add(comboBoxMonthControlKVP);}
            if (labelYearLamp_1.isVisible()) {components.add(labelYearLamp_1);}
            if (labelYearLamp_2.isVisible()) {components.add(labelYearLamp_2);}
            if (textFieldYearLamp.isVisible()) {components.add(textFieldYearLamp);}
            if (labelVoltage_1.isVisible()) {components.add(labelVoltage_1);}
            if (textFieldVoltage.isVisible()) {components.add(textFieldVoltage);}
            if (labelVoltage_2.isVisible()) {components.add(labelVoltage_2);}
            tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
            components.clear();
        }

        // Reason-2:
        if (labelReason2.isVisible()) {components.add(labelReason2);}
        if (comboBoxReason2.isVisible()) {components.add(comboBoxReason2);}
        if (comboBoxReason2_additionally_1.isVisible()) {components.add(comboBoxReason2_additionally_1);}
        if (labelReason2_additionally_1.isVisible()) {components.add(labelReason2_additionally_1);}
        if (textFieldReason2_additionally_1.isVisible()) {components.add(textFieldReason2_additionally_1);}
        tempArray.add(SortComponents.sortAndWrite(components).concat(";"));
        components.clear();

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

        // Object:
        if (comboBoxShObjects.isVisible()) {components.add(comboBoxShObjects);}
        if ((comboBoxShObjects_additionally_1.isVisible()) && (comboBoxShObjects_additionally_1.getItemCount() != 0)) {components.add(comboBoxShObjects_additionally_1);}
        if (comboBoxShObjects_additionally_2.isVisible()) {components.add(comboBoxShObjects_additionally_2);}
        if (textFieldShObjects2_additionally.isVisible()) {components.add(textFieldShObjects2_additionally);}
        if (comboBoxShObjects2_additionally.isVisible()) {components.add(comboBoxShObjects2_additionally);}
        if (textFieldCheckingOnSchedule_1.isVisible()) {components.add(textFieldCheckingOnSchedule_1);}
        if (comboBoxCheckingOnSchedule.isVisible()) {components.add(comboBoxCheckingOnSchedule);}
        if (textFieldCheckingOnSchedule_2.isVisible()) {components.add(textFieldCheckingOnSchedule_2);}
        if (textFieldNumberOfWires.isVisible()) {components.add(textFieldNumberOfWires);}
        if (textFieldNameOfWires.isVisible()) {components.add(textFieldNameOfWires);}
        if (textFieldCable_1.isVisible()) {components.add(textFieldCable_1);}
        if (textFieldCable_2.isVisible()) {components.add(textFieldCable_2);}
        if (textFieldCable_3.isVisible()) {components.add(textFieldCable_3);}
        if (textFieldResistanceDay.isVisible()) {components.add(textFieldResistanceDay);}
        if (comboBoxResistanceMonth.isVisible()) {components.add(comboBoxResistanceMonth);}
        if (textFieldResistanceYear.isVisible()) {components.add(textFieldResistanceYear);}
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
        components.clear();

        // Element:
        if (comboBoxElement.isVisible()) {components.add(comboBoxElement);}
        if (comboBoxElement_additionally_1.isVisible()) {components.add(comboBoxElement_additionally_1);}
        if (textFieldElement_additionally_1.isVisible()) {components.add(textFieldElement_additionally_1);}
        if (comboBoxElement_additionally_2.isVisible()) {components.add(comboBoxElement_additionally_2);}
        if (textFieldElement_additionally_2.isVisible()) {components.add(textFieldElement_additionally_2);}
        if (textFieldElement_additionally_3.isVisible()) {components.add(textFieldElement_additionally_3);}
        if (comboBoxElement_additionally_3.isVisible()) {components.add(comboBoxElement_additionally_3);}
        if (textFieldElement_additionally_4.isVisible()) {components.add(textFieldElement_additionally_4);}
        if (textFieldElement_additionally_5.isVisible()) {components.add(textFieldElement_additionally_5);}
        if (textFieldTested_1.isVisible()) {components.add(textFieldTested_1);}
        if (textFieldTestedDay.isVisible()) {components.add(textFieldTestedDay);}
        if (comboBoxTestedMonth.isVisible()) {components.add(comboBoxTestedMonth);}
        if (textFieldTestedYear.isVisible()) {components.add(textFieldTestedYear);}
        if (textFieldElementRemote_additionally_1.isVisible()) {components.add(textFieldElementRemote_additionally_1);}
        if (comboBoxElement_additionally_4.isVisible()) {components.add(comboBoxElement_additionally_4);}
        if (textFieldCheckingOnScheduleRK_1.isVisible()) {components.add(textFieldCheckingOnScheduleRK_1);}
        if (comboBoxCheckingOnScheduleRK.isVisible()) {components.add(comboBoxCheckingOnScheduleRK);}
        if (textFieldCheckingOnScheduleRK_2.isVisible()) {components.add(textFieldCheckingOnScheduleRK_2);}
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
        components.clear();

        // Element-2:
        if (comboBoxElement2.isVisible()) {components.add(comboBoxElement2);}
        if (textFieldElement2_additionally_1.isVisible()) {components.add(textFieldElement2_additionally_1);}
        if (textFieldElement2_additionally_2.isVisible()) {components.add(textFieldElement2_additionally_2);}
        if (textFieldElement2_additionally_3.isVisible()) {components.add(textFieldElement2_additionally_3);}
        if (comboBoxElement2_additionally_1.isVisible()) {components.add(comboBoxElement2_additionally_1);}
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
        components.clear();

        // Reason-1:
        if ((comboBoxReason1.isVisible()) && (comboBoxReason1.getItemCount() != 0)) {components.add(comboBoxReason1);}
        if (textFieldReason1_additionally_1.isVisible()) {components.add(textFieldReason1_additionally_1);}
        if (textFieldReason1_additionally_2.isVisible()) {components.add(textFieldReason1_additionally_2);}
        if (textFieldReason1_additionally_3.isVisible()) {components.add(textFieldReason1_additionally_3);}
        if (textFieldReason1_additionally_4.isVisible()) {components.add(textFieldReason1_additionally_4);}
        if (comboBoxReason1_additionally_1.isVisible()) {components.add(comboBoxReason1_additionally_1);}
        if (comboBoxReason1_additionally_2.isVisible()) {components.add(comboBoxReason1_additionally_2);}
        if (comboBoxReason1_additionally_3.isVisible()) {components.add(comboBoxReason1_additionally_3);}
        if (textFieldDayControlKVP.isVisible()) {components.add(textFieldDayControlKVP);}
        if (textFieldYearControlKVP.isVisible()) {components.add(textFieldYearControlKVP);}
        if (comboBoxMonthControlKVP.isVisible()) {components.add(comboBoxMonthControlKVP);}
        if (textFieldYearLamp.isVisible()) {components.add(textFieldYearLamp);}
        if (textFieldVoltage.isVisible()) {components.add(textFieldVoltage);}
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
        components.clear();

        // Reason-2:
        if (comboBoxReason2.isVisible()) {components.add(comboBoxReason2);}
        if (comboBoxReason2_additionally_1.isVisible()) {components.add(comboBoxReason2_additionally_1);}
        if (textFieldReason2_additionally_1.isVisible()) {components.add(textFieldReason2_additionally_1);}
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
        components.clear();

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
                case "comboBoxShObjects":
                    comboBoxShObjects.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxShObjects_additionally_1":
                    comboBoxShObjects_additionally_1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxShObjects_additionally_2":
                    comboBoxShObjects_additionally_2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldShObjects2_additionally":
                    textFieldShObjects2_additionally.setText(s[1]);
                    break;
                case "comboBoxShObjects2_additionally":
                    comboBoxShObjects2_additionally.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldCheckingOnSchedule_1":
                    textFieldCheckingOnSchedule_1.setText(s[1]);
                    break;
                case "comboBoxCheckingOnSchedule":
                    comboBoxCheckingOnSchedule.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldCheckingOnSchedule_2":
                    textFieldCheckingOnSchedule_2.setText(s[1]);
                    break;
                case "textFieldNumberOfWires":
                    textFieldNumberOfWires.setText(s[1]);
                    break;
                case "textFieldNameOfWires":
                    textFieldNameOfWires.setText(s[1]);
                    break;
                case "textFieldCable_1":
                    textFieldCable_1.setText(s[1]);
                    break;
                case "textFieldCable_2":
                    textFieldCable_2.setText(s[1]);
                    break;
                case "textFieldCable_3":
                    textFieldCable_3.setText(s[1]);
                    break;
                case "textFieldResistanceDay":
                    textFieldResistanceDay.setText(s[1]);
                    break;
                case "comboBoxResistanceMonth":
                    comboBoxResistanceMonth.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldResistanceYear":
                    textFieldResistanceYear.setText(s[1]);
                    break;
                case "comboBoxElement":
                    comboBoxElement.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxElement_additionally_1":
                    comboBoxElement_additionally_1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldElement_additionally_1":
                    textFieldElement_additionally_1.setText(s[1]);
                    break;
                case "comboBoxElement_additionally_2":
                    comboBoxElement_additionally_2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldElement_additionally_2":
                    textFieldElement_additionally_2.setText(s[1]);
                    break;
                case "textFieldElement_additionally_3":
                    textFieldElement_additionally_3.setText(s[1]);
                    break;
                case "comboBoxElement_additionally_3":
                    comboBoxElement_additionally_3.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldElement_additionally_4":
                    textFieldElement_additionally_4.setText(s[1]);
                    break;
                case "textFieldElement_additionally_5":
                    textFieldElement_additionally_5.setText(s[1]);
                    break;
                case "textFieldTested_1":
                    textFieldTested_1.setText(s[1]);
                    break;
                case "textFieldTestedDay":
                    textFieldTestedDay.setText(s[1]);
                    break;
                case "comboBoxTestedMonth":
                    comboBoxTestedMonth.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldTestedYear":
                    textFieldTestedYear.setText(s[1]);
                    break;
                case "textFieldElementRemote_additionally_1":
                    textFieldElementRemote_additionally_1.setText(s[1]);
                    break;
                case "comboBoxElement_additionally_4":
                    comboBoxElement_additionally_4.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxElement2":
                    comboBoxElement2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldElement2_additionally_1":
                    textFieldElement2_additionally_1.setText(s[1]);
                    break;
                case "textFieldElement2_additionally_2":
                    textFieldElement2_additionally_2.setText(s[1]);
                    break;
                case "textFieldElement2_additionally_3":
                    textFieldElement2_additionally_3.setText(s[1]);
                    break;
                case "comboBoxElement2_additionally_1":
                    comboBoxElement2_additionally_1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxReason1":
                    comboBoxReason1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldReason1_additionally_1":
                    textFieldReason1_additionally_1.setText(s[1]);
                    break;
                case "textFieldReason1_additionally_2":
                    textFieldReason1_additionally_2.setText(s[1]);
                    break;
                case "textFieldReason1_additionally_3":
                    textFieldReason1_additionally_3.setText(s[1]);
                    break;
                case "textFieldReason1_additionally_4":
                    textFieldReason1_additionally_4.setText(s[1]);
                    break;
                case "comboBoxReason1_additionally_1":
                    comboBoxReason1_additionally_1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxReason1_additionally_2":
                    comboBoxReason1_additionally_2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxReason1_additionally_3":
                    comboBoxReason1_additionally_3.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldDayControlKVP":
                    textFieldDayControlKVP.setText(s[1]);
                    break;
                case "textFieldYearControlKVP":
                    textFieldYearControlKVP.setText(s[1]);
                    break;
                case "comboBoxMonthControlKVP":
                    comboBoxMonthControlKVP.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldYearLamp":
                    textFieldYearLamp.setText(s[1]);
                    break;
                case "textFieldVoltage":
                    textFieldVoltage.setText(s[1]);
                    break;
                case "comboBoxReason2":
                    comboBoxReason2.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxReason2_additionally_1":
                    comboBoxReason2_additionally_1.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldReason2_additionally_1":
                    textFieldReason2_additionally_1.setText(s[1]);
                    break;
                case "textFieldCheckingOnScheduleRK_1":
                    textFieldCheckingOnScheduleRK_1.setText(s[1]);
                    break;
                case "comboBoxCheckingOnScheduleRK":
                    comboBoxCheckingOnScheduleRK.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "textFieldCheckingOnScheduleRK_2":
                    textFieldCheckingOnScheduleRK_2.setText(s[1]);
                    break;
            }
        }
    }
}
