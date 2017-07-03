package ua.andrewblake.panels;

import ua.andrewblake.exceptions.AccessingFileException;
import ua.andrewblake.exceptions.CommunicateFileSystemException;
import ua.andrewblake.exceptions.FailedToCreateReportException;
import ua.andrewblake.exceptions.FailureLoadDataFromDatabaseException;
import ua.andrewblake.settings.GlobalSettings;
import ua.andrewblake.utils.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PanelReportGenerating extends JPanel {

    private JLabel labelHeader;
    private JLabel labelChoosePeriod;
    private JComboBox<String> comboBoxChoosePeriod;
    private JLabel labelYearFrom;
    private JComboBox<String> comboBoxYearFrom;
    private JLabel labelQuarterOrMonthFrom;
    private JComboBox<String> comboBoxQuarterOrMonthFrom;
    private JLabel labelDayOrDecadeFrom;
    private JComboBox<String> comboBoxDayOrDecadeFrom;
    private JLabel labelHyphen;
    private JLabel labelYearTo;
    private JComboBox<String> comboBoxYearTo;
    private JLabel labelMonthTo;
    private JComboBox<String> comboBoxMonthTo;
    private JLabel labelDayTo;
    private JComboBox<String> comboBoxDayTo;
    private JLabel labelImage;
    private JButton buttonBack;
    private JButton buttonCreateReport;
    private JFileChooser fileChooser;

    public PanelReportGenerating() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelHeader = new JLabel("Формування звіту:");
        this.add(labelHeader);
        labelHeader.setBounds(350, 10, 100, 15);

        labelChoosePeriod = new JLabel("Створити звіт за");
        this.add(labelChoosePeriod);
        labelChoosePeriod.setBounds(10, 33, 85, 15);

        comboBoxChoosePeriod = new JComboBox<>(new String[]{"Рік", "Квартал", "Місяць", "Декаду", "День", "Період"});
        this.add(comboBoxChoosePeriod);
        comboBoxChoosePeriod.setBounds(100, 30, 70, 20);
        comboBoxChoosePeriod.addActionListener(this::comboBoxChoosePeriodActionPerformed);

        labelYearFrom = new JLabel("Рік:");
        this.add(labelYearFrom);
        labelYearFrom.setBounds(10, 63, 20, 15);

        comboBoxYearFrom = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxYearFrom);
        comboBoxYearFrom.setBounds(30, 60, 50, 20);

        labelQuarterOrMonthFrom = new JLabel();
        this.add(labelQuarterOrMonthFrom);
        labelQuarterOrMonthFrom.setBounds(90, 63, 50, 15);
        labelQuarterOrMonthFrom.setVisible(false);

        comboBoxQuarterOrMonthFrom = new JComboBox<>();
        this.add(comboBoxQuarterOrMonthFrom);
        comboBoxQuarterOrMonthFrom.setBounds(140, 60, 80, 20);
        comboBoxQuarterOrMonthFrom.setVisible(false);
        comboBoxQuarterOrMonthFrom.addActionListener(this::comboBoxQuarterOrMonthFromActionPerformed);

        labelDayOrDecadeFrom = new JLabel();
        this.add(labelDayOrDecadeFrom);
        labelDayOrDecadeFrom.setBounds(230, 63, 50, 15);
        labelDayOrDecadeFrom.setVisible(false);

        comboBoxDayOrDecadeFrom = new JComboBox<>();
        this.add(comboBoxDayOrDecadeFrom);
        comboBoxDayOrDecadeFrom.setBounds(280, 60, 40, 20);
        comboBoxDayOrDecadeFrom.setVisible(false);

        labelHyphen = new JLabel("----");
        this.add(labelHyphen);
        labelHyphen.setBounds(330, 63, 20, 15);
        labelHyphen.setVisible(false);

        labelYearTo = new JLabel("Рік:");
        this.add(labelYearTo);
        labelYearTo.setBounds(360, 63, 20, 15);
        labelYearTo.setVisible(false);

        comboBoxYearTo = new JComboBox<>(StringModels.getYears());
        this.add(comboBoxYearTo);
        comboBoxYearTo.setBounds(380, 60, 50, 20);
        comboBoxYearTo.setVisible(false);

        labelMonthTo = new JLabel("Місяць:");
        this.add(labelMonthTo);
        labelMonthTo.setBounds(440, 63, 40, 15);
        labelMonthTo.setVisible(false);

        comboBoxMonthTo = new JComboBox<>(StringModels.getMonths());
        this.add(comboBoxMonthTo);
        comboBoxMonthTo.setBounds(480, 60, 80, 20);
        comboBoxMonthTo.setVisible(false);
        comboBoxMonthTo.addActionListener(this::comboBoxMonthToActionPerformed);

        labelDayTo = new JLabel("День:");
        this.add(labelDayTo);
        labelDayTo.setBounds(570, 63, 30, 15);
        labelDayTo.setVisible(false);

        comboBoxDayTo = new JComboBox<>(StringModels.getDays_31());
        this.add(comboBoxDayTo);
        comboBoxDayTo.setBounds(605, 60, 40, 20);
        comboBoxDayTo.setVisible(false);

        labelImage = new JLabel(new ImageIcon("src/ua/andrewblake/resources/Report.jpg"));
        this.add(labelImage);
        labelImage.setBounds(60, 90, 670, 430);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 120, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        buttonCreateReport = new JButton("Створити");
        this.add(buttonCreateReport);
        buttonCreateReport.setBounds(660, 530, 120, 30);
        buttonCreateReport.setIcon(new ImageIcon("src/ua/andrewblake/resources/Edit.png"));
        buttonCreateReport.addActionListener(this::buttonCreateReportActionPerformed);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilterForSaveReportFileChooser());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        this.updateUI();
        this.setVisible(false);

        GlobalSettings.setPanelReportGenerating(this);

    }

    void reset() {
        comboBoxChoosePeriod.setSelectedIndex(0);
        comboBoxChoosePeriodActionPerformed(null);
        comboBoxYearFrom.setSelectedIndex(DateTime.getYearInt() - 2010);
    }

    private void comboBoxChoosePeriodActionPerformed(java.awt.event.ActionEvent evt) {
        labelQuarterOrMonthFrom.setVisible(false);
        comboBoxQuarterOrMonthFrom.setVisible(false);
        labelDayOrDecadeFrom.setVisible(false);
        comboBoxDayOrDecadeFrom.setVisible(false);
        labelHyphen.setVisible(false);
        labelYearTo.setVisible(false);
        comboBoxYearTo.setVisible(false);
        labelMonthTo.setVisible(false);
        comboBoxMonthTo.setVisible(false);
        labelDayTo.setVisible(false);
        comboBoxDayTo.setVisible(false);
        switch (comboBoxChoosePeriod.getSelectedIndex()) {
            case 1: // Декада
                labelQuarterOrMonthFrom.setVisible(true);
                labelQuarterOrMonthFrom.setText("Квартал:");
                comboBoxQuarterOrMonthFrom.removeAllItems();
                comboBoxQuarterOrMonthFrom.addItem("1");
                comboBoxQuarterOrMonthFrom.addItem("2");
                comboBoxQuarterOrMonthFrom.addItem("3");
                comboBoxQuarterOrMonthFrom.addItem("4");
                comboBoxQuarterOrMonthFrom.setVisible(true);
                break;
            case 2: // Місяць
                labelQuarterOrMonthFrom.setText("Місяць:");
                labelQuarterOrMonthFrom.setVisible(true);
                comboBoxQuarterOrMonthFrom.removeAllItems();
                for (String s : StringModels.getMonths()) {
                    comboBoxQuarterOrMonthFrom.addItem(s);
                }
                comboBoxQuarterOrMonthFrom.setSelectedIndex(DateTime.getMonthInt() - 1);
                comboBoxQuarterOrMonthFrom.setVisible(true);
                break;
            case 3: // Декада
                labelQuarterOrMonthFrom.setVisible(true);
                labelQuarterOrMonthFrom.setText("Місяць:");
                comboBoxQuarterOrMonthFrom.setVisible(true);
                comboBoxQuarterOrMonthFrom.removeAllItems();
                for (String s : StringModels.getMonths()) {
                    comboBoxQuarterOrMonthFrom.addItem(s);
                }
                comboBoxQuarterOrMonthFrom.setSelectedIndex(DateTime.getMonthInt() - 1);
                labelDayOrDecadeFrom.setText("Декада:");
                labelDayOrDecadeFrom.setVisible(true);
                comboBoxDayOrDecadeFrom.removeAllItems();
                comboBoxDayOrDecadeFrom.addItem("1");
                comboBoxDayOrDecadeFrom.addItem("2");
                comboBoxDayOrDecadeFrom.addItem("3");
                comboBoxDayOrDecadeFrom.setVisible(true);
                break;
            case 4: // День
                labelQuarterOrMonthFrom.setVisible(true);
                labelQuarterOrMonthFrom.setText("Місяць:");
                comboBoxQuarterOrMonthFrom.setVisible(true);
                comboBoxQuarterOrMonthFrom.removeAllItems();
                for (String s : StringModels.getMonths()) {
                    comboBoxQuarterOrMonthFrom.addItem(s);
                }
                comboBoxQuarterOrMonthFrom.setSelectedIndex(DateTime.getMonthInt() - 1);
                labelDayOrDecadeFrom.setText("День:");
                labelDayOrDecadeFrom.setVisible(true);
                comboBoxDayOrDecadeFrom.setVisible(true);
                break;
            case 5: // Період
                labelQuarterOrMonthFrom.setVisible(true);
                labelQuarterOrMonthFrom.setText("Місяць:");
                comboBoxQuarterOrMonthFrom.setVisible(true);
                comboBoxQuarterOrMonthFrom.removeAllItems();
                for (String s : StringModels.getMonths()) {
                    comboBoxQuarterOrMonthFrom.addItem(s);
                }
                comboBoxQuarterOrMonthFrom.setSelectedIndex(DateTime.getMonthInt() - 1);
                labelDayOrDecadeFrom.setText("День:");
                labelDayOrDecadeFrom.setVisible(true);
                comboBoxDayOrDecadeFrom.setVisible(true);
                labelHyphen.setVisible(true);
                labelYearTo.setVisible(true);
                comboBoxYearTo.setVisible(true);
                labelMonthTo.setVisible(true);
                comboBoxMonthTo.setVisible(true);
                labelDayTo.setVisible(true);
                comboBoxDayTo.setVisible(true);
                break;
        }
    }

    private void comboBoxQuarterOrMonthFromActionPerformed(java.awt.event.ActionEvent evt) {
        if ((comboBoxChoosePeriod.getSelectedIndex() == 4) || (comboBoxChoosePeriod.getSelectedIndex() == 5)) {
            int daysInMonth;
            int selectedMonth = comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1;
            comboBoxDayOrDecadeFrom.removeAllItems();
            if ((selectedMonth == 1) || (selectedMonth == 3) || (selectedMonth == 5) || (selectedMonth == 7) || (selectedMonth == 8) || (selectedMonth == 10) || (selectedMonth == 12)) {
                daysInMonth = 31;
            } else  if ((selectedMonth == 4) || (selectedMonth == 6) || (selectedMonth == 9) || (selectedMonth == 11)) {
                daysInMonth = 30;
            } else {
                if (DateTime.isYearIntercalary(comboBoxYearFrom.getSelectedIndex() + 2010)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
            }
            for (int i = 0; i < daysInMonth; i++) {
                comboBoxDayOrDecadeFrom.addItem(StringModels.getDays_31()[i]);
            }
        }
    }

    private void comboBoxMonthToActionPerformed(java.awt.event.ActionEvent evt) {
        int daysInMonth;
        int selectedMonth = comboBoxMonthTo.getSelectedIndex() + 1;
        comboBoxDayTo.removeAllItems();
        if ((selectedMonth == 1) || (selectedMonth == 3) || (selectedMonth == 5) || (selectedMonth == 7) || (selectedMonth == 8) || (selectedMonth == 10) || (selectedMonth == 12)) {
            daysInMonth = 31;
        } else  if ((selectedMonth == 4) || (selectedMonth == 6) || (selectedMonth == 9) || (selectedMonth == 11)) {
            daysInMonth = 30;
        } else {
            if (DateTime.isYearIntercalary(comboBoxYearTo.getSelectedIndex() + 2010)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        }
        for (int i = 0; i < daysInMonth; i++) {
            comboBoxDayTo.addItem(StringModels.getDays_31()[i]);
        }
        if (comboBoxChoosePeriod.getSelectedIndex() == 4) {
            comboBoxDayTo.setSelectedIndex(DateTime.getDayInt() - 1);
        }
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelMain().setVisible(true);
    }

    private void buttonCreateReportActionPerformed(java.awt.event.ActionEvent evt) {

        int result = fileChooser.showOpenDialog(this);
        File file;
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            buttonCreateReport.setVisible(false);
        } else {
            return;
        }

        String periodOfTime;
        String previousYearPeriodOfTime;
        String yearFrom = "";
        String monthFrom = "";
        String dayFrom = "";
        String yearTo = "";
        String monthTo = "";
        String dayTo = "";
        int daysInMonth;
        int selectedMonth = comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1;
        comboBoxDayOrDecadeFrom.removeAllItems();
        if ((selectedMonth == 1) || (selectedMonth == 3) || (selectedMonth == 5) || (selectedMonth == 7) || (selectedMonth == 8) || (selectedMonth == 10) || (selectedMonth == 12)) {
            daysInMonth = 31;
        } else  if ((selectedMonth == 4) || (selectedMonth == 6) || (selectedMonth == 9) || (selectedMonth == 11)) {
            daysInMonth = 30;
        } else {
            if (DateTime.isYearIntercalary(comboBoxYearFrom.getSelectedIndex() + 2010)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        }

        switch (comboBoxChoosePeriod.getSelectedIndex()) {
            case 0: // Рік
                yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                monthFrom = "01";
                monthTo = "12";
                dayFrom = "01";
                dayTo = "31";
                break;
            case 1: // Квартал
                switch (comboBoxQuarterOrMonthFrom.getSelectedIndex()) {
                    case 0: // 1
                        yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                        monthFrom = "01";
                        monthTo = "03";
                        dayFrom = "01";
                        dayTo = "31";
                        break;
                    case 1: // 2
                        yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                        monthFrom = "04";
                        monthTo = "06";
                        dayFrom = "01";
                        dayTo = "30";
                        break;
                    case 2: // 3
                        yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                        monthFrom = "07";
                        monthTo = "00";
                        dayFrom = "01";
                        dayTo = "30";
                        break;
                    case 3: // 4
                        yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                        monthFrom = "10";
                        monthTo = "12";
                        dayFrom = "01";
                        dayTo = "31";
                        break;
                }
                break;
            case 2: // Місяць
                yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                monthFrom = monthTo = String.valueOf(comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1);
                dayFrom = "01";
                dayTo = String.valueOf(daysInMonth);
                break;
            case 3: // Декада
                yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                monthFrom = monthTo = String.valueOf(comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1);
                if (comboBoxDayOrDecadeFrom.getSelectedIndex() == 0) {
                    dayFrom = "01";
                } else if (comboBoxDayOrDecadeFrom.getSelectedIndex() == 1) {
                    dayFrom = "11";
                } else {
                    dayFrom = "21";
                }
                if (comboBoxDayOrDecadeFrom.getSelectedIndex() == 0) {
                    dayTo = "10";
                } else if (comboBoxDayOrDecadeFrom.getSelectedIndex() == 1) {
                    dayTo = "20";
                } else {
                    dayTo = String.valueOf(daysInMonth);
                }
                break;
            case 4: // День
                yearFrom = yearTo = (String) comboBoxYearFrom.getSelectedItem();
                monthFrom = monthTo = String.valueOf(comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1);
                dayFrom = dayTo = (String) comboBoxDayOrDecadeFrom.getSelectedItem();
                break;
            case 5: // Період
                yearFrom = (String) comboBoxYearFrom.getSelectedItem();
                monthFrom = String.valueOf(comboBoxQuarterOrMonthFrom.getSelectedIndex() + 1);
                dayFrom = (String) comboBoxDayOrDecadeFrom.getSelectedItem();
                yearTo = (String) comboBoxYearTo.getSelectedItem();
                monthTo = String.valueOf(comboBoxMonthTo.getSelectedIndex() + 1);
                dayTo = (String) comboBoxDayTo.getSelectedItem();
                break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" WHERE date >= '");
        stringBuilder.append(yearFrom);
        stringBuilder.append("-");
        stringBuilder.append(monthFrom);
        stringBuilder.append("-");
        stringBuilder.append(dayFrom);
        stringBuilder.append("' AND date <= '");
        stringBuilder.append(yearTo);
        stringBuilder.append("-");
        stringBuilder.append(monthTo);
        stringBuilder.append("-");
        stringBuilder.append(dayTo);
        stringBuilder.append("'");
        periodOfTime = stringBuilder.toString();

        stringBuilder = new StringBuilder();
        stringBuilder.append(" WHERE date >= '");
        stringBuilder.append(Integer.valueOf(yearFrom) - 1);
        stringBuilder.append("-");
        stringBuilder.append(monthFrom);
        stringBuilder.append("-");
        stringBuilder.append(dayFrom);
        stringBuilder.append("' AND date <= '");
        stringBuilder.append(Integer.valueOf(yearTo) - 1);
        stringBuilder.append("-");
        stringBuilder.append(monthTo);
        stringBuilder.append("-");
        stringBuilder.append(dayTo);
        stringBuilder.append("'");
        previousYearPeriodOfTime = stringBuilder.toString();
        String nameOfPeriod =  JOptionPane.showInputDialog(null, "Введіть назву періоду звітності для відображення в звітних таблицях.");

        try {
            ReportGenerator.createReport(file, periodOfTime, previousYearPeriodOfTime, (String) comboBoxYearFrom.getSelectedItem(), nameOfPeriod);
            JOptionPane.showMessageDialog(null, "Звіт успішно створений");
        } catch (FailureLoadDataFromDatabaseException e) {
            switch (e.getType()) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Не вдалося створити звіт. Збій завантаження записів несправностей з Бази Даних.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Не вдалося створити звіт. Збій завантаження балів технічного оснащення з Бази Даних.");
                    break;
            }
        } catch (AccessingFileException e) {
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою. Файл - \"".concat(e.getFileName()).concat("\"."));
        } catch (CommunicateFileSystemException e) {
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
        } catch (FailedToCreateReportException e) {
            JOptionPane.showMessageDialog(null, "Не вдалося створити звіт.");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Збій внутрішньої логіки обчислення програми.");
        }

        buttonCreateReport.setVisible(true);
    }

}
