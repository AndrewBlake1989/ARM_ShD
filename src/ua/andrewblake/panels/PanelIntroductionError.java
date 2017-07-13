package ua.andrewblake.panels;

import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.DateTime;
import ua.andrewblake.utils.StringModels;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PanelIntroductionError extends JPanel implements GetData {

    private JLabel labelErrorNumber1;
    private JLabel labelErrorNumber2;
    private JSeparator separator1;
    private JLabel labelDateTime;
    private JLabel labelDateTameBeginning;
    private JComboBox<String> comboBoxBeginningYear;
    private JComboBox<String> comboBoxBeginningMonth;
    private JComboBox<String> comboBoxBeginningDay;
    private JComboBox<String> comboBoxBeginningHour;
    private JLabel labelTimeBeginningSeparator;
    private JComboBox<String> comboBoxBeginningMinute;
    private JLabel labelDateTimeElimination;
    private JComboBox<String> comboBoxEliminationYear;
    private JComboBox<String> comboBoxEliminationMonth;
    private JComboBox<String> comboBoxEliminationDay;
    private JComboBox<String> comboBoxEliminationHour;
    private JLabel labelTimeEliminationSeparator;
    private JComboBox<String> comboBoxEliminationMinute;
    private JSeparator separator2;
    private JLabel labelDist;
    private JComboBox<String> comboBoxDist;
    private JSeparator separator3;
    private JLabel labelPlaceOfOccurrence;
    private JComboBox<String> comboBoxStationOrPeregon;
    private JComboBox<String> comboBoxStationOrPeregonName;
    private JPanel panelTypeOfDevice;
    private JSeparator separator4;
    private JLabel labelDepartment;
    private JComboBox<String> comboBoxDepartment;
    private JPanel panelObjectsAndReasons;
    private JSeparator separator5;
    private JButton buttonBack;
    private JButton buttonNext;

    // Constructor:
    public PanelIntroductionError() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelErrorNumber1 = new JLabel("№ несправності в поточному місяці: ");
        this.add(labelErrorNumber1);
        labelErrorNumber1.setBounds(10, 20, 185, 15);

        labelErrorNumber2 = new JLabel("---");
        this.add(labelErrorNumber2);
        labelErrorNumber2.setBounds(100, 40, 20, 15);

        separator1 = new JSeparator(1);
        this.add(separator1);
        separator1.setBounds(200, 0, 5, 70);

        labelDateTime = new JLabel("Дата і час:");
        this.add(labelDateTime);
        labelDateTime.setBounds(210, 30, 55, 15);

        labelDateTameBeginning = new JLabel("Появи");
        this.add(labelDateTameBeginning);
        labelDateTameBeginning.setBounds(280, 15, 35, 15);

        labelDateTimeElimination = new JLabel("Усунення");
        this.add(labelDateTimeElimination);
        labelDateTimeElimination.setBounds(280, 45, 50, 15);

        comboBoxBeginningYear = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxBeginningYear);
        comboBoxBeginningYear.setBounds(340, 10, 50, 20);

        comboBoxBeginningMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxBeginningMonth);
        comboBoxBeginningMonth.setBounds(400, 10, 80, 20);
        comboBoxBeginningMonth.addActionListener(this::comboBoxBeginningMonthActionPerformed);

        comboBoxBeginningDay = new JComboBox<>(StringModels.getDays_31());
        this.add(comboBoxBeginningDay);
        comboBoxBeginningDay.setBounds(490, 10, 40, 20);

        comboBoxBeginningHour = new JComboBox<>(StringModels.getHours());
        this.add(comboBoxBeginningHour);
        comboBoxBeginningHour.setBounds(560, 10, 40, 20);

        labelTimeBeginningSeparator = new JLabel(":");
        this.add(labelTimeBeginningSeparator);
        labelTimeBeginningSeparator.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTimeBeginningSeparator.setBounds(605, 10, 5, 20);

        comboBoxBeginningMinute = new JComboBox<>(StringModels.getMinutes());
        this.add(comboBoxBeginningMinute);
        comboBoxBeginningMinute.setBounds(615, 10, 40, 20);

        comboBoxEliminationYear = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxEliminationYear);
        comboBoxEliminationYear.setBounds(340, 40, 50, 20);

        comboBoxEliminationMonth = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxEliminationMonth);
        comboBoxEliminationMonth.setBounds(400, 40, 80, 20);
        comboBoxEliminationMonth.addActionListener(this::comboBoxEliminationMonthActionPerformed);

        comboBoxEliminationDay = new JComboBox<>(StringModels.getDays_31());
        this.add(comboBoxEliminationDay);
        comboBoxEliminationDay.setBounds(490, 40, 40, 20);

        comboBoxEliminationHour = new JComboBox<>(StringModels.getHours());
        this.add(comboBoxEliminationHour);
        comboBoxEliminationHour.setBounds(560, 40, 40, 20);

        labelTimeEliminationSeparator = new JLabel(":");
        this.add(labelTimeEliminationSeparator);
        labelTimeEliminationSeparator.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTimeEliminationSeparator.setBounds(605, 40, 5, 20);

        comboBoxEliminationMinute = new JComboBox<>(StringModels.getMinutes());
        this.add(comboBoxEliminationMinute);
        comboBoxEliminationMinute.setBounds(615, 40, 40, 20);

        separator2 = new JSeparator(1);
        this.add(separator2);
        separator2.setBounds(670, 0, 5, 70);

        labelDist = new JLabel("Дистанція:");
        this.add(labelDist);
        labelDist.setBounds(705, 10, 55, 15);

        comboBoxDist = new JComboBox<>(StringModels.getShch());
        this.add(comboBoxDist);
        comboBoxDist.setBounds(690, 30, 90, 20);
        comboBoxDist.addActionListener(this::comboBoxDistActionPerformed);

        separator3 = new JSeparator(0);
        this.add(separator3);
        separator3.setBounds(0, 70, 800, 5);

        labelPlaceOfOccurrence = new JLabel("Місце виникнення:");
        this.add(labelPlaceOfOccurrence);
        labelPlaceOfOccurrence.setBounds(10, 83, 95, 15);

        comboBoxStationOrPeregon = new JComboBox<>(StringModels.getStationOrPeregon());
        this.add(comboBoxStationOrPeregon);
        comboBoxStationOrPeregon.setBounds(110, 80, 65, 20);

        comboBoxStationOrPeregonName = new JComboBox<>();
        this.add(comboBoxStationOrPeregonName);
        comboBoxStationOrPeregonName.setBounds(180, 80, 600, 20);
        comboBoxStationOrPeregon.addActionListener(this::comboBoxStationOrPeregonActionPerformed);

        panelTypeOfDevice = new PanelTypeOfDeviceOnPanelIntroductionError();
        this.add(panelTypeOfDevice);
        panelTypeOfDevice.setBounds(0, 110, 800, 70);

        separator4 = new JSeparator(0);
        this.add(separator4);
        separator4.setBounds(0, 180, 800, 5);

        labelDepartment = new JLabel("Служба:");
        this.add(labelDepartment);
        labelDepartment.setBounds(10, 193, 50, 15);

        comboBoxDepartment = new JComboBox<>(StringModels.getDepartments());
        this.add(comboBoxDepartment);
        comboBoxDepartment.setBounds(60, 190, 50, 20);
        comboBoxDepartment.addActionListener(this::comboBoxDepartmentActionPerformed);

        separator5 = new JSeparator(0);
        this.add(separator5);
        separator5.setBounds(0, 490, 800, 5);

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

        whatShCh();

        this.setVisible(false);
        GlobalSettings.setPanelIntroductionError(this);

    }

    // Methods:
    void fillCurrentDateTime() {
        comboBoxBeginningYear.setSelectedIndex(DateTime.getYearInt() - 2010);
        comboBoxBeginningMonth.setSelectedIndex(DateTime.getMonthInt() - 1);
        fillComboBoxBeginningDay ();
        comboBoxBeginningDay.setSelectedIndex(DateTime.getDayInt() - 1);
        comboBoxBeginningHour.setSelectedIndex(DateTime.getHourInt());
        comboBoxBeginningMinute.setSelectedIndex(DateTime.getMinuteInt());
        comboBoxEliminationYear.setSelectedIndex(DateTime.getYearInt() - 2010);
        comboBoxEliminationMonth.setSelectedIndex(DateTime.getMonthInt() - 1);
        fillComboBoxEliminationDay ();
        comboBoxEliminationDay.setSelectedIndex(DateTime.getDayInt() - 1);
        comboBoxEliminationHour.setSelectedIndex(DateTime.getHourInt());
        comboBoxEliminationMinute.setSelectedIndex(DateTime.getMinuteInt());
    }

    private void fillComboBoxBeginningDay () {
        int daysInMonth;
        int selectedMonth = comboBoxBeginningMonth.getSelectedIndex() + 1;
        comboBoxBeginningDay.removeAllItems();
        if ((selectedMonth == 1) || (selectedMonth == 3) || (selectedMonth == 5) || (selectedMonth == 7) || (selectedMonth == 8) || (selectedMonth == 10) || (selectedMonth == 12)) {
            daysInMonth = 31;
        } else  if ((selectedMonth == 4) || (selectedMonth == 6) || (selectedMonth == 9) || (selectedMonth == 11)) {
            daysInMonth = 30;
        } else {
            if (DateTime.isYearIntercalary()) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        }
        for (int i = 0; i < daysInMonth; i++) {
            comboBoxBeginningDay.addItem(StringModels.getDays_31()[i]);
        }
        comboBoxBeginningDay.setSelectedIndex(0);
    }

    private void fillComboBoxEliminationDay () {
        int daysInMonth;
        int selectedMonth = comboBoxEliminationMonth.getSelectedIndex() + 1;
        comboBoxEliminationDay.removeAllItems();
        if ((selectedMonth == 1) || (selectedMonth == 3) || (selectedMonth == 5) || (selectedMonth == 7) || (selectedMonth == 8) || (selectedMonth == 10) || (selectedMonth == 12)) {
            daysInMonth = 31;
        } else  if ((selectedMonth == 4) || (selectedMonth == 6) || (selectedMonth == 9) || (selectedMonth == 11)) {
            daysInMonth = 30;
        } else {
            if (DateTime.isYearIntercalary()) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        }
        for (int i = 0; i < daysInMonth; i++) {
            comboBoxEliminationDay.addItem(StringModels.getDays_31()[i]);
        }
        comboBoxEliminationDay.setSelectedIndex(0);
    }

    private void comboBoxBeginningMonthActionPerformed(java.awt.event.ActionEvent evt) {
        fillComboBoxBeginningDay();
    }

    private void comboBoxEliminationMonthActionPerformed(java.awt.event.ActionEvent evt) {
        fillComboBoxEliminationDay();
    }

    private void comboBoxDistActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxStationOrPeregonActionPerformed(null);
    }

    private void comboBoxStationOrPeregonActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxStationOrPeregonName.removeAllItems();
        if ((comboBoxDist.getSelectedIndex() == 0) || (comboBoxStationOrPeregon.getSelectedIndex() == 0)) { return; }
        if (comboBoxStationOrPeregon.getSelectedIndex() == 1) {
            switch (comboBoxDist.getSelectedIndex()) {
                case 1:
                    for (int i = 0; i < StringModels.getShch1Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch1Stations()[i]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < StringModels.getShch2Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch2Stations()[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < StringModels.getShch3Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch3Stations()[i]);
                    }
                    break;
                case 4:
                    for (int i = 0; i < StringModels.getShch4Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch4Stations()[i]);
                    }
                    break;
                case 5:
                    for (int i = 0; i < StringModels.getShch5Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch5Stations()[i]);
                    }
                    break;
                case 6:
                    for (int i = 0; i < StringModels.getShch6Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch6Stations()[i]);
                    }
                    break;
                case 7:
                    for (int i = 0; i < StringModels.getShch8Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch8Stations()[i]);
                    }
                    break;
                case 8:
                    for (int i = 0; i < StringModels.getShch9Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch9Stations()[i]);
                    }
                    break;
                case 9:
                    for (int i = 0; i < StringModels.getShch10Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch10Stations()[i]);
                    }
                    break;
                case 10:
                    for (int i = 0; i < StringModels.getShch11Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch11Stations()[i]);
                    }
                    break;
                case 11:
                    for (int i = 0; i < StringModels.getShch12Stations().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch12Stations()[i]);
                    }
                    break;
            }
        } else {
            switch (comboBoxDist.getSelectedIndex()) {
                case 1:
                    for (int i = 0; i < StringModels.getShch1Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch1Peregons()[i]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < StringModels.getShch2Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch2Peregons()[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < StringModels.getShch3Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch3Peregons()[i]);
                    }
                    break;
                case 4:
                    for (int i = 0; i < StringModels.getShch4Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch4Peregons()[i]);
                    }
                    break;
                case 5:
                    for (int i = 0; i < StringModels.getShch5Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch5Peregons()[i]);
                    }
                    break;
                case 6:
                    for (int i = 0; i < StringModels.getShch6Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch6Peregons()[i]);
                    }
                    break;
                case 7:
                    for (int i = 0; i < StringModels.getShch8Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch8Peregons()[i]);
                    }
                    break;
                case 8:
                    for (int i = 0; i < StringModels.getShch9Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch9Peregons()[i]);
                    }
                    break;
                case 9:
                    for (int i = 0; i < StringModels.getShch10Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch10Peregons()[i]);
                    }
                    break;
                case 10:
                    for (int i = 0; i < StringModels.getShch11Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch11Peregons()[i]);
                    }
                    break;
                case 11:
                    for (int i = 0; i < StringModels.getShch12Peregons().length; i++) {
                        comboBoxStationOrPeregonName.addItem(StringModels.getShch12Peregons()[i]);
                    }
                    break;
            }
        }
    }

    private void comboBoxDepartmentActionPerformed(java.awt.event.ActionEvent evt) {
        if (panelObjectsAndReasons != null) {
            panelObjectsAndReasons.setBounds(0, 210, 0, 0);
        }
        switch (comboBoxDepartment.getSelectedIndex()) {
            case 0: // -
                return;
            case 1: // Sh
                panelObjectsAndReasons = new PanelObjectsAndReasonsByDepartmentSh();
                break;
            case 2: // P
                panelObjectsAndReasons = new PanelObjectsAndReasonsByDepartmentP();
                break;
            case 3: // D
                panelObjectsAndReasons = new PanelObjectsAndReasonsByDepartmentD();
                break;
            case 4: // E
                panelObjectsAndReasons = new PanelObjectsAndReasonsByDepartmentE();
                break;
            case 5: // Other
                panelObjectsAndReasons = new PanelObjectsAndReasonsByDepartmentOther();
                break;

        }
        panelObjectsAndReasons.setBounds(0, 210, 800, 280);
        this.add(panelObjectsAndReasons);
        panelObjectsAndReasons.setVisible(true);
        this.updateUI();
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {

        if (!canContinue()) {
            return;
        }

        this.setVisible(false);
        GlobalSettings.getPanelIntroductionError2().setVisible(true);

    }

    void reset() {
        labelErrorNumber2.setText("---");
        fillCurrentDateTime();
        comboBoxDist.setSelectedIndex(0);
        comboBoxStationOrPeregon.setSelectedIndex(0);
        ((PanelTypeOfDeviceOnPanelIntroductionError) panelTypeOfDevice).reset();
        comboBoxDepartment.setSelectedIndex(0);
        comboBoxBeginningYear.setEnabled(true);
        comboBoxBeginningMonth.setEnabled(true);
        comboBoxBeginningDay.setEnabled(true);
        comboBoxStationOrPeregonName.setEnabled(true);
        comboBoxStationOrPeregon.setEnabled(true);
        comboBoxDist.setEnabled(true);
        whatShCh();
    }

    private void whatShCh() {
        if ((GlobalSettings.getUserPosition() > 3) && (GlobalSettings.getUserPosition() < 16)) {
            comboBoxDist.setSelectedIndex(GlobalSettings.getUserPosition() - 3);
            comboBoxDist.setEnabled(false);
        }
    }

    @Override
    public boolean canContinue() {
        if (comboBoxDist.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ви не обрали дистанцію сигналізації та зв'язку");
            return false;
        }
        String tempMonth;
        if (comboBoxBeginningMonth.getSelectedIndex() <= 8) {
            tempMonth = "0".concat(String.valueOf(comboBoxBeginningMonth.getSelectedIndex() + 1));
        } else {
            tempMonth = String.valueOf(comboBoxBeginningMonth.getSelectedIndex() + 1);
        }
        String dateStrBeginning = comboBoxBeginningDay.getItemAt(comboBoxBeginningDay.getSelectedIndex()).concat(".".concat(tempMonth.concat(".".concat(comboBoxBeginningYear.getItemAt(comboBoxBeginningYear.getSelectedIndex()).concat(" ").concat(comboBoxBeginningHour.getItemAt(comboBoxBeginningHour.getSelectedIndex()).concat(":".concat(comboBoxBeginningMinute.getItemAt(comboBoxBeginningMinute.getSelectedIndex()))))))));
        String dateStrElimination = comboBoxEliminationDay.getItemAt(comboBoxEliminationDay.getSelectedIndex()).concat(".".concat(tempMonth.concat(".".concat(comboBoxEliminationYear.getItemAt(comboBoxEliminationYear.getSelectedIndex()).concat(" ").concat(comboBoxEliminationHour.getItemAt(comboBoxEliminationHour.getSelectedIndex()).concat(":".concat(comboBoxEliminationMinute.getItemAt(comboBoxEliminationMinute.getSelectedIndex()))))))));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            Date beginning = sdf.parse(dateStrBeginning);
            Date elimination = sdf.parse(dateStrElimination);
            long t = elimination.getTime() - beginning.getTime();

            if (t < 0) {
                JOptionPane.showMessageDialog(null, "Дата усунення несправності передує даті її появи");
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        if (comboBoxStationOrPeregon.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вказано місце появи несправності");
            return false;
        }
        GetData gdPanel = (GetData) panelTypeOfDevice;
        if (!gdPanel.canContinue()) {
            return false;
        }
        if (comboBoxDepartment.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Не вибрано відповідальну службу");
            return false;
        }
        gdPanel = (GetData) panelObjectsAndReasons;
        return gdPanel.canContinue();
    }

    @Override
    public String[] getSimple(String[] simple) {
        simple = new String[6];
        if ((GlobalSettings.getCurrentStat() == null) || (GlobalSettings.getCurrentStat().numberOfRecord == 0)) {
            simple[0] = "Несправність не зареєстрована.";
        } else {
            simple[0] = "№ несправності: ".concat(String.valueOf(GlobalSettings.getCurrentStat().numberOfRecord));
        }
        simple[1] = "Дистанція сигналізації та зв'язку: ".concat((String) comboBoxDist.getSelectedItem()).concat(";");
        simple[2] = "Місце виникнення: ".concat((String) comboBoxStationOrPeregon.getSelectedItem()).concat(" ").concat((String) comboBoxStationOrPeregonName.getSelectedItem()).concat(";");
        simple[3] = "Дата і час появи: ".concat((String) comboBoxBeginningDay.getSelectedItem()).concat(".").concat((String) comboBoxBeginningMonth.getSelectedItem()).concat(".").concat((String) comboBoxBeginningYear.getSelectedItem()).concat(" ").concat((String) comboBoxBeginningHour.getSelectedItem()).concat(":").concat((String) comboBoxBeginningMinute.getSelectedItem()).concat(";");
        simple[4] = "Дата і час усунення: ".concat((String) comboBoxEliminationDay.getSelectedItem()).concat(".").concat((String) comboBoxEliminationMonth.getSelectedItem()).concat(".").concat((String) comboBoxEliminationYear.getSelectedItem()).concat(" ").concat((String) comboBoxEliminationHour.getSelectedItem()).concat(":").concat((String) comboBoxEliminationMinute.getSelectedItem()).concat(";");
        String tempMonth;
        if (comboBoxBeginningMonth.getSelectedIndex() <= 8) {
            tempMonth = "0".concat(String.valueOf(comboBoxBeginningMonth.getSelectedIndex() + 1));
        } else {
            tempMonth = String.valueOf(comboBoxBeginningMonth.getSelectedIndex() + 1);
        }
        String dateStrBeginning = comboBoxBeginningDay.getItemAt(comboBoxBeginningDay.getSelectedIndex()).concat(".".concat(tempMonth.concat(".".concat(comboBoxBeginningYear.getItemAt(comboBoxBeginningYear.getSelectedIndex()).concat(" ").concat(comboBoxBeginningHour.getItemAt(comboBoxBeginningHour.getSelectedIndex()).concat(":".concat(comboBoxBeginningMinute.getItemAt(comboBoxBeginningMinute.getSelectedIndex()))))))));
        String dateStrElimination = comboBoxEliminationDay.getItemAt(comboBoxEliminationDay.getSelectedIndex()).concat(".".concat(tempMonth.concat(".".concat(comboBoxEliminationYear.getItemAt(comboBoxEliminationYear.getSelectedIndex()).concat(" ").concat(comboBoxEliminationHour.getItemAt(comboBoxEliminationHour.getSelectedIndex()).concat(":".concat(comboBoxEliminationMinute.getItemAt(comboBoxEliminationMinute.getSelectedIndex()))))))));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            Date beginning = sdf.parse(dateStrBeginning);
            Date elimination = sdf.parse(dateStrElimination);
            long t = elimination.getTime() - beginning.getTime();
            int allMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(t);
            int hours = allMinutes / 60;
            int minutes = allMinutes % 60;
            simple[5] = "Тривалість пошкодження: ".concat(String.valueOf(hours)).concat(":").concat((String.valueOf(minutes)).length()==1?"0".concat((String.valueOf(minutes))):(String.valueOf(minutes))).concat(";");
        } catch (ParseException e) {
            // NOP
        }
        GetData gd = (GetData) panelTypeOfDevice;
        simple = gd.getSimple(simple);
        gd = (GetData) panelObjectsAndReasons;
        simple = gd.getSimple(simple);

        return simple;
    }

    @Override
    public Stat getParams(Stat stat) {
        if (stat == null) {
            stat = new Stat();
        }
        String[][] params = new String[14][2];
        params[0][0] = "comboBoxBeginningYear";
        params[0][1] = String.valueOf(comboBoxBeginningYear.getSelectedIndex());
        params[1][0] = "comboBoxBeginningMonth";
        params[1][1] = String.valueOf(comboBoxBeginningMonth.getSelectedIndex());
        params[2][0] = "comboBoxBeginningDay";
        params[2][1] = String.valueOf(comboBoxBeginningDay.getSelectedIndex());
        params[3][0] = "comboBoxBeginningHour";
        params[3][1] = String.valueOf(comboBoxBeginningHour.getSelectedIndex());
        params[4][0] = "comboBoxBeginningMinute";
        params[4][1] = String.valueOf(comboBoxBeginningMinute.getSelectedIndex());
        params[5][0] = "comboBoxEliminationYear";
        params[5][1] = String.valueOf(comboBoxEliminationYear.getSelectedIndex());
        params[6][0] = "comboBoxEliminationMonth";
        params[6][1] = String.valueOf(comboBoxEliminationMonth.getSelectedIndex());
        params[7][0] = "comboBoxEliminationDay";
        params[7][1] = String.valueOf(comboBoxEliminationDay.getSelectedIndex());
        params[8][0] = "comboBoxEliminationHour";
        params[8][1] = String.valueOf(comboBoxEliminationHour.getSelectedIndex());
        params[9][0] = "comboBoxEliminationMinute";
        params[9][1] = String.valueOf(comboBoxEliminationMinute.getSelectedIndex());
        params[10][0] = "comboBoxDist";
        params[10][1] = String.valueOf(comboBoxDist.getSelectedIndex());
        params[11][0] = "comboBoxStationOrPeregon";
        params[11][1] = String.valueOf(comboBoxStationOrPeregon.getSelectedIndex());
        params[12][0] = "comboBoxStationOrPeregonName2";
        params[12][1] = (String) comboBoxStationOrPeregonName.getSelectedItem();
        params[13][0] = "comboBoxDepartment";
        params[13][1] = String.valueOf(comboBoxDepartment.getSelectedIndex());
        stat.paramsPanelIntroductionError = params;
        stat = ((GetData) panelTypeOfDevice).getParams(stat);
        stat = ((GetData) panelObjectsAndReasons).getParams(stat);
        stat.dist = (comboBoxDist.getSelectedIndex() <= 6) ? comboBoxDist.getSelectedIndex() : (comboBoxDist.getSelectedIndex() + 1);
        stat.year = Integer.valueOf((String) comboBoxBeginningYear.getSelectedItem());
        stat.month = ((byte) (comboBoxBeginningMonth.getSelectedIndex() + 1));
        stat.day = Byte.valueOf((String) comboBoxBeginningDay.getSelectedItem());
        if (panelObjectsAndReasons instanceof PanelObjectsAndReasonsByDepartmentSh) {
            stat.department = 1;
        }
        if (panelObjectsAndReasons instanceof PanelObjectsAndReasonsByDepartmentP) {
            stat.department = 2;
        }
        if (panelObjectsAndReasons instanceof PanelObjectsAndReasonsByDepartmentD) {
            stat.department = 3;
        }
        if (panelObjectsAndReasons instanceof PanelObjectsAndReasonsByDepartmentE) {
            stat.department = 4;
        }
        if (panelObjectsAndReasons instanceof PanelObjectsAndReasonsByDepartmentOther) {
            stat.department = 5;
        }
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        comboBoxBeginningYear.setEnabled(false);
        comboBoxBeginningMonth.setEnabled(false);
        comboBoxBeginningDay.setEnabled(false);
        String[][] params = stat.paramsPanelIntroductionError;
        for (String[] s : params) {
            switch (s[0]) {
                case "comboBoxBeginningYear":
                    comboBoxBeginningYear.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxBeginningMonth":
                    comboBoxBeginningMonth.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxBeginningDay":
                    comboBoxBeginningDay.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxBeginningHour":
                    comboBoxBeginningHour.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxBeginningMinute":
                    comboBoxBeginningMinute.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxEliminationYear":
                    comboBoxEliminationYear.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxEliminationMonth":
                    comboBoxEliminationMonth.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxEliminationDay":
                    comboBoxEliminationDay.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxEliminationHour":
                    comboBoxEliminationHour.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxEliminationMinute":
                    comboBoxEliminationMinute.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxDist":
                    comboBoxDist.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxStationOrPeregon":
                    comboBoxStationOrPeregon.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxStationOrPeregonName":
                    comboBoxStationOrPeregonName.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
                case "comboBoxStationOrPeregonName2":
                    comboBoxStationOrPeregonName.removeAllItems();
                    comboBoxStationOrPeregonName.addItem(s[1]);
                    comboBoxStationOrPeregonName.setEnabled(false);
                    comboBoxStationOrPeregon.setEnabled(false);
                    comboBoxDist.setEnabled(false);
                    break;
                case "comboBoxDepartment":
                    comboBoxDepartment.setSelectedIndex(Integer.valueOf(s[1]));
                    break;
            }
        }
        labelErrorNumber2.setText(String.valueOf(stat.numberOfRecord));
        ((GetData) panelTypeOfDevice).fillParams(stat);
        ((GetData) panelObjectsAndReasons).fillParams(stat);
        GlobalSettings.getPanelIntroductionError2().fillParams(stat);
        GlobalSettings.getPanelIntroductionError3().fillParams(stat);
    }

}
