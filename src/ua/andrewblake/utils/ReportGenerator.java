package ua.andrewblake.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import ua.andrewblake.enums.Department;
import ua.andrewblake.exceptions.FailedToCreateReportException;
import ua.andrewblake.exceptions.FailureLoadDataFromDatabaseException;
import ua.andrewblake.save.Stat;
import ua.andrewblake.tablemodels.TableModel4_1;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;

import static ua.andrewblake.enums.Department.Sh;
import static ua.andrewblake.enums.Department.D;
import static ua.andrewblake.enums.Department.P;
import static ua.andrewblake.enums.Department.E;
import static ua.andrewblake.enums.Department.Other;

public class ReportGenerator {

    private static Blob[] thisYearBlobs;
    private static Blob[] previousYearBlobs;
    private static Stat[] thisYearStats;
    private static Stat[] previousYearStats;
    private static String directory;
    private static String currentYear;
    private static BigDecimal[][] equipmentTechnicalPoints;
    private static BigDecimal[][] equipmentTechnicalPointsPreviousYear;
    private static int[][] thisYearTable1;
    private static int[][] previousYearTable1;
    private static int[][][] table2;
    private static int[][] table3_1;
    private static int[][] table3_2;
    private static int[][] table3_3;
    private static int[][] table3_4;
    private static int[][] table3_6;
    private static int[][] table3_7;
    private static int[][] table3_8;
    private static int[][] table3_9;
    private static int[][] table3_9a;
    private static int[][] table3_10;
    private static int[][] table3_11;
    private static int[][] table3_12;
    private static String nameOfPeriod;

    public static boolean createReport(File directoryToSave, String periodOfTime, String previousYearPeriodOfTime, String year, String period) throws FailureLoadDataFromDatabaseException, FailedToCreateReportException {
        directory = directoryToSave.toString();
        currentYear = year;
        nameOfPeriod = period;
        takeRecords(periodOfTime, previousYearPeriodOfTime);
        makeStats();
        getEquipmentTechnicalPoints();
        resetTables();

        if (!writeTable1()) {return false;}
        if (!writeTable2()) {return false;}
        if (!writeTable3_1()) {return false;}
        if (!writeTable3_2()) {return false;}
        if (!writeTable3_3()) {return false;}
        if (!writeTable3_4()) {return false;}
        if (!writeTable3_6()) {return false;}
        if (!writeTable3_7()) {return false;}
        if (!writeTable3_8()) {return false;}
        if (!writeTable3_9()) {return false;}
        if (!writeTable3_9a()) {return false;}
        if (!writeTable3_10()) {return false;}
        if (!writeTable3_11()) {return false;}
        if (!writeTable3_12()) {return false;}


        return true;
    }

    private static void takeRecords(String periodOfTime, String previousYearPeriodOfTime) throws FailureLoadDataFromDatabaseException {
        try {
            String[] temp = new String[0];
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            statement.executeQuery("LOCK TABLE records READ;");

            // thisYearBlobs
            ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM records".concat(periodOfTime).concat(" AND deleted = 0;"));
            while (res.next()) {
                thisYearBlobs = new Blob[res.getInt(1)];
                temp = new String[res.getInt(1)];
            }
            res = statement.executeQuery("SELECT date, number_of_record, file_record FROM records".concat(periodOfTime).concat(" AND deleted = 0;"));
            int i = 0;
            while (res.next()) {
                temp[i] = res.getString(1).concat("-").concat(res.getString(2));
                thisYearBlobs[i] = res.getBlob(3);
                i++;
            }
            ArrayList<Blob> blobsArrayList = new ArrayList<>();
            ArrayList<String> dateWithNumberList = new ArrayList<>();
            for (int j = 0; j < temp.length; j++) {
                f1:
                for (int i1 = 0; i1 < dateWithNumberList.size(); i1++) {
                    if (temp[j].equals(dateWithNumberList.get(i1))) {
                        blobsArrayList.remove(i1);
                        dateWithNumberList.remove(i1);
                        break f1;
                    }
                }
                blobsArrayList.add(thisYearBlobs[j]);
                dateWithNumberList.add(temp[j]);
            }
            thisYearBlobs = new Blob[blobsArrayList.size()];
            for (int j = 0; j < blobsArrayList.size(); j++) {
                thisYearBlobs[j] = blobsArrayList.get(j);
            }

            // previousYearBlobs
            res = statement.executeQuery("SELECT COUNT(*) FROM records".concat(previousYearPeriodOfTime).concat(" AND deleted = 0;"));
            while (res.next()) {
                previousYearBlobs = new Blob[res.getInt(1)];
                temp = new String[res.getInt(1)];
            }
            res = statement.executeQuery("SELECT date, number_of_record, file_record FROM records".concat(previousYearPeriodOfTime).concat(" AND deleted = 0;"));
            i = 0;
            while (res.next()) {
                temp[i] = res.getString(1).concat("-").concat(res.getString(2));
                previousYearBlobs[i] = res.getBlob(3);
                i++;
            }
            blobsArrayList = new ArrayList<>();
            dateWithNumberList = new ArrayList<>();
            for (int j = 0; j < temp.length; j++) {
                f1:
                for (int i1 = 0; i1 < dateWithNumberList.size(); i1++) {
                    if (temp[j].equals(dateWithNumberList.get(i1))) {
                        blobsArrayList.remove(i1);
                        dateWithNumberList.remove(i1);
                        break f1;
                    }
                }
                blobsArrayList.add(previousYearBlobs[j]);
                dateWithNumberList.add(temp[j]);
            }
            previousYearBlobs = new Blob[blobsArrayList.size()];
            for (int j = 0; j < blobsArrayList.size(); j++) {
                previousYearBlobs[j] = blobsArrayList.get(j);
            }

            statement.executeQuery("UNLOCK TABLES;");
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(1);
        }
    }

    private static void makeStats() throws FailedToCreateReportException {
        thisYearStats = new Stat[thisYearBlobs.length];
        previousYearStats = new Stat[previousYearBlobs.length];
        for (int i = 0; i < thisYearStats.length; i++) {
            Blob record = thisYearBlobs[i];
            try {
                InputStream x = record.getBinaryStream();
                int size = x.available();
                byte b[] = new byte[size];
                x.read(b);
                try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                    targetFile.write(b);
                }
            } catch (SQLException e) {
                throw new FailedToCreateReportException();
            } catch (FileNotFoundException e) {
                throw new FailedToCreateReportException();
            } catch (IOException e) {
                throw new FailedToCreateReportException();
            }
            thisYearStats[i] = SerializeToBlob.deserialize();
        }
        for (int i = 0; i < previousYearStats.length; i++) {
            Blob record = previousYearBlobs[i];
            try {
                InputStream x = record.getBinaryStream();
                int size = x.available();
                byte b[] = new byte[size];
                x.read(b);
                try (OutputStream targetFile = new FileOutputStream("src/ua/andrewblake/save/SaveStatToBlob.svf")) {
                    targetFile.write(b);
                }
            } catch (SQLException e) {
                throw new FailedToCreateReportException();
            } catch (FileNotFoundException e) {
                throw new FailedToCreateReportException();
            } catch (IOException e) {
                throw new FailedToCreateReportException();
            }
            previousYearStats[i] = SerializeToBlob.deserialize();
        }
    }

    private static void getEquipmentTechnicalPoints() throws FailureLoadDataFromDatabaseException {
        try {
            Connection connection = ConnectionToMySQL.getConnectionToMySQL();
            Statement statement = connection.createStatement();
            equipmentTechnicalPoints = new BigDecimal[13][9];
            equipmentTechnicalPointsPreviousYear = new BigDecimal[13][9];
            statement.executeQuery("LOCK TABLE equipment_technical_points READ;");
            for (int i = 1; i <= 12; i++) {
                if (i == 7) {
                    continue;
                }
                ResultSet res = statement.executeQuery("SELECT * FROM equipment_technical_points WHERE year = ".concat(currentYear).concat(" AND shch = ").concat(String.valueOf(i)).concat(";"));
                while (res.next()) {
                    equipmentTechnicalPoints[i][1] = new BigDecimal(res.getDouble(4)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][2] = new BigDecimal(res.getDouble(5)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][3] = new BigDecimal(res.getDouble(6)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][4] = new BigDecimal(res.getDouble(7)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][5] = new BigDecimal(res.getDouble(8)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][6] = new BigDecimal(res.getDouble(9)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][7] = new BigDecimal(res.getDouble(10)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPoints[i][8] = new BigDecimal(res.getDouble(11)).setScale(2, RoundingMode.HALF_UP);
                }
            }
            for (int i = 1; i <= 12; i++) {
                if (i == 7) {
                    continue;
                }
                ResultSet res = statement.executeQuery("SELECT * FROM equipment_technical_points WHERE year = ".concat(String.valueOf(Integer.valueOf(currentYear) - 1)).concat(" AND shch = ").concat(String.valueOf(i)).concat(";"));
                while (res.next()) {
                    equipmentTechnicalPointsPreviousYear[i][1] = new BigDecimal(res.getDouble(4)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][2] = new BigDecimal(res.getDouble(5)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][3] = new BigDecimal(res.getDouble(6)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][4] = new BigDecimal(res.getDouble(7)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][5] = new BigDecimal(res.getDouble(8)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][6] = new BigDecimal(res.getDouble(9)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][7] = new BigDecimal(res.getDouble(10)).setScale(2, RoundingMode.HALF_UP);
                    equipmentTechnicalPointsPreviousYear[i][8] = new BigDecimal(res.getDouble(11)).setScale(2, RoundingMode.HALF_UP);
                }
            }
            statement.executeQuery("UNLOCK TABLES;");
        } catch (SQLException e) {
            throw new FailureLoadDataFromDatabaseException(2);
        }
    }

    private static void resetTables() {
        thisYearTable1 = new int[44][13];
        fillTablesZeroValues(thisYearTable1);
        previousYearTable1 = new int[44][13];
        fillTablesZeroValues(previousYearTable1);
        table3_1 = new int[20][12];
        fillTablesZeroValues(table3_1);
        table3_2 = new int[7][6];
        fillTablesZeroValues(table3_2);
        table3_3 = new int[15][14];
        fillTablesZeroValues(table3_3);
        table3_4 = new int[30][10];
        fillTablesZeroValues(table3_4);
        table3_6 = new int[16][9];
        fillTablesZeroValues(table3_6);
        table3_7 = new int[14][8];
        fillTablesZeroValues(table3_7);
        table3_8 = new int[12][8];
        fillTablesZeroValues(table3_8);
        table3_9 = new int[22][13];
        fillTablesZeroValues(table3_9);
        table3_9a = new int[23][10];
        fillTablesZeroValues(table3_9a);
        table3_10 = new int[29][11];
        fillTablesZeroValues(table3_10);
        table3_11 = new int[18][4];
        fillTablesZeroValues(table3_11);
        table3_12 = new int[15][6];
        fillTablesZeroValues(table3_12);
        table2 = new int[10][45][14];
        fillTablesZeroValues(table2);


    }

    private static void fillTablesZeroValues(int[][][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                for (int k = 0; k < table[i][j].length; k++) {
                    table[i][j][k] = 0;
                }
            }
        }
    }

    private static void fillTablesZeroValues(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 0;
            }
        }
    }

    private static void calculateStatisticTable1ThisYear() {
        for (Stat stat : thisYearStats) {
            thisYearTable1[0][stat.dist]++; // Всього відмов
            Department department = Sh;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    switch (s[1]) {
                        case "1": // Відмови по службі Ш
                            department = Sh;
                            thisYearTable1[1][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBoxShObjects")) && (s1[1].equals("9"))) { // в т.ч. Рейкові кола
                                    thisYearTable1[2][stat.dist]++;
                                }
                            }
                            break;
                        case "2": // Відмови по службі П
                            department = P;
                            thisYearTable1[3][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBoxObject")) && (s1[1].equals("1"))) { // Рейкове коло
                                    thisYearTable1[4][stat.dist]++;
                                }
                                if ((s1[0].equals("comboBoxObject")) && (s1[1].equals("2"))) { // Стрілки
                                    thisYearTable1[5][stat.dist]++;
                                }
                            }
                            break;
                        case "3": // Відмови по службі Д
                            department = D;
                            thisYearTable1[6][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBox1")) && (s1[1].equals("0"))) { // Неправильне користування
                                    thisYearTable1[7][stat.dist]++;
                                }
                                if ((s1[0].equals("comboBox1")) && (s1[1].equals("1"))) { // Поріз стрілки
                                    thisYearTable1[8][stat.dist]++;
                                }
                            }
                            break;
                        case "4": // Відмови по службі Е
                            department = E;
                            thisYearTable1[9][stat.dist]++;
                            if (stat.paramsPanelObjectsAndReasons[0][0].equals("0")) { // Відсутність електроенергії
                                thisYearTable1[10][stat.dist]++;
                            } else { // Відхилення від номінальної напруги
                                thisYearTable1[11][stat.dist]++;
                            }
                            break;
                        case "5":
                            department = Other;
                            thisYearTable1[12][stat.dist]++;
                    }
                    break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[0])) { // Перекриття сигналів
                thisYearTable1[13][stat.dist]++;
                switch (department) {
                    case Sh:
                        thisYearTable1[14][stat.dist]++;
                        if (stat.paramsPanelIntroductionError2[8].equals("0")) {
                            thisYearTable1[15][stat.dist]++;
                        } else {
                            thisYearTable1[16][stat.dist]++;
                        }
                        break;
                    case P:
                        thisYearTable1[17][stat.dist]++;
                        break;
                    case D:
                        thisYearTable1[18][stat.dist]++;
                        break;
                    case E:
                        thisYearTable1[19][stat.dist]++;
                        break;
                    case Other:
                        thisYearTable1[20][stat.dist]++;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[1])) { // + Кожен поїзд
                int count = stat.tableModel2_1.getRowCount() - 1;
                thisYearTable1[21][stat.dist] += count;
                switch (department) {
                    case Sh:
                        thisYearTable1[22][stat.dist] += count;
                        break;
                    case P:
                        thisYearTable1[23][stat.dist] += count;
                        break;
                    case D:
                        thisYearTable1[24][stat.dist] += count;
                        break;
                    case E:
                        thisYearTable1[25][stat.dist] += count;
                        break;
                    case Other:
                        thisYearTable1[26][stat.dist] += count;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[2])) { // Закриття основних засобів
                thisYearTable1[27][stat.dist]++;
                switch (department) {
                    case Sh:
                        thisYearTable1[28][stat.dist]++;
                        break;
                    case P:
                        thisYearTable1[29][stat.dist]++;
                        break;
                    case D:
                        thisYearTable1[30][stat.dist]++;
                        break;
                    case E:
                        thisYearTable1[31][stat.dist]++;
                        break;
                    case Other:
                        thisYearTable1[32][stat.dist]++;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[3])) { // Відмови із затримками поїздів
                thisYearTable1[33][stat.dist]++;
                TableModel4_1 tableModel4_1 = stat.tableModel4_1;
                for (int i = 0; i < tableModel4_1.getRowCount() - 1; i++) {
                    if ((tableModel4_1.getValueAt(i, 1).equals("   Пасажирський")) || (tableModel4_1.getValueAt(i, 1).equals("   Приміський"))) {
                        thisYearTable1[34][stat.dist]++;
                        String latency = (String) tableModel4_1.getValueAt(i, 2);
                        thisYearTable1[36][stat.dist] += (Integer.valueOf(latency.substring(0, latency.length() - 3)) * 60 + Integer.valueOf(latency.substring(latency.length() - 2, latency.length())));
                    }
                    if (tableModel4_1.getValueAt(i, 1).equals("   Вантажний")) {
                        thisYearTable1[35][stat.dist]++;
                        String latency = (String) tableModel4_1.getValueAt(i, 2);
                        thisYearTable1[37][stat.dist] += (Integer.valueOf(latency.substring(0, latency.length() - 3)) * 60 + Integer.valueOf(latency.substring(latency.length() - 2, latency.length())));
                    }
                }
            }
            for (String s : stat.simpleRecord) {
                if (s.length() < 25) {
                    continue;
                }
                if (s.substring(0, 23).equals("Тривалість пошкодження:")) {
                    String temp  = s.substring(24, s.length() - 1);
                    int hour = Integer.valueOf(temp.substring(0, temp.length() - 3));
                    int minute = Integer.valueOf(temp.substring(temp.length() - 2, temp.length()));
                    thisYearTable1[42][stat.dist] += hour * 60 + minute;
                    if (department == Sh) {
                        thisYearTable1[43][stat.dist] += hour * 60 + minute;
                    }
                    break;
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (i == 7) {
                continue;
            }
            double d = 0;
            for (int j = 1; j <= 8; j++) {
                d += equipmentTechnicalPoints[i][j].doubleValue();
            }
            thisYearTable1[39][i] = (int) (d * 100);
        }
    }

    private static void calculateStatisticTable1PreviousYear() {
        for (Stat stat : previousYearStats) {
            previousYearTable1[0][stat.dist]++; // Всього відмов
            Department department = Sh;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    switch (s[1]) {
                        case "1": // Відмови по службі Ш
                            department = Sh;
                            previousYearTable1[1][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBoxShObjects")) && (s1[1].equals("9"))) { // в т.ч. Рейкові кола
                                    previousYearTable1[2][stat.dist]++;
                                }
                            }
                            break;
                        case "2": // Відмови по службі П
                            department = P;
                            previousYearTable1[3][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBoxObject")) && (s1[1].equals("1"))) { // Рейкове коло
                                    previousYearTable1[4][stat.dist]++;
                                }
                                if ((s1[0].equals("comboBoxObject")) && (s1[1].equals("2"))) { // Стрілки
                                    previousYearTable1[5][stat.dist]++;
                                }
                            }
                            break;
                        case "3": // Відмови по службі Д
                            department = D;
                            previousYearTable1[6][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if ((s1[0].equals("comboBox1")) && (s1[1].equals("1"))) { // Неправильне користування
                                    previousYearTable1[7][stat.dist]++;
                                }
                                if ((s1[0].equals("comboBox1")) && (s1[1].equals("2"))) { // Поріз стрілки
                                    previousYearTable1[8][stat.dist]++;
                                }
                            }
                            break;
                        case "4": // Відмови по службі Е
                            department = E;
                            previousYearTable1[9][stat.dist]++;
                            if (stat.paramsPanelObjectsAndReasons[0][0].equals("0")) { // Відсутність електроенергії
                                previousYearTable1[10][stat.dist]++;
                            } else { // Відхилення від номінальної напруги
                                previousYearTable1[11][stat.dist]++;
                            }
                            break;
                        case "5":
                            department = Other;
                            previousYearTable1[12][stat.dist]++;
                    }
                    break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[0])) { // Перекриття сигналів
                previousYearTable1[13][stat.dist]++;
                switch (department) {
                    case Sh:
                        previousYearTable1[14][stat.dist]++;
                        if (stat.paramsPanelIntroductionError2[8].equals("0")) {
                            previousYearTable1[15][stat.dist]++;
                        } else {
                            previousYearTable1[16][stat.dist]++;
                        }
                        break;
                    case P:
                        previousYearTable1[17][stat.dist]++;
                        break;
                    case D:
                        previousYearTable1[18][stat.dist]++;
                        break;
                    case E:
                        previousYearTable1[19][stat.dist]++;
                        break;
                    case Other:
                        previousYearTable1[20][stat.dist]++;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[1])) { // + Кожен поїзд
                int count = stat.tableModel2_1.getRowCount() - 1;
                previousYearTable1[21][stat.dist] += count;
                switch (department) {
                    case Sh:
                        previousYearTable1[22][stat.dist] += count;
                        break;
                    case P:
                        previousYearTable1[23][stat.dist] += count;
                        break;
                    case D:
                        previousYearTable1[24][stat.dist] += count;
                        break;
                    case E:
                        previousYearTable1[25][stat.dist] += count;
                        break;
                    case Other:
                        previousYearTable1[26][stat.dist] += count;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[2])) { // Закриття основних засобів
                previousYearTable1[27][stat.dist]++;
                switch (department) {
                    case Sh:
                        previousYearTable1[28][stat.dist]++;
                        break;
                    case P:
                        previousYearTable1[29][stat.dist]++;
                        break;
                    case D:
                        previousYearTable1[30][stat.dist]++;
                        break;
                    case E:
                        previousYearTable1[31][stat.dist]++;
                        break;
                    case Other:
                        previousYearTable1[32][stat.dist]++;
                        break;
                }
            }
            if (Boolean.valueOf(stat.paramsPanelIntroductionError2[3])) { // Відмови із затримками поїздів
                thisYearTable1[33][stat.dist]++;
                TableModel4_1 tableModel4_1 = stat.tableModel4_1;
                for (int i = 0; i < tableModel4_1.getRowCount() - 1; i++) {
                    if ((tableModel4_1.getValueAt(i, 1).equals("   Пасажирський")) || (tableModel4_1.getValueAt(i, 1).equals("   Приміський"))) {
                        thisYearTable1[34][stat.dist]++;
                        String latency = (String) tableModel4_1.getValueAt(i, 2);
                        thisYearTable1[36][stat.dist] += (Integer.valueOf(latency.substring(0, latency.length() - 3)) * 60 + Integer.valueOf(latency.substring(latency.length() - 2, latency.length())));
                    }
                    if (tableModel4_1.getValueAt(i, 1).equals("   Вантажний")) {
                        thisYearTable1[35][stat.dist]++;
                        String latency = (String) tableModel4_1.getValueAt(i, 2);
                        thisYearTable1[37][stat.dist] += (Integer.valueOf(latency.substring(0, latency.length() - 3)) * 60 + Integer.valueOf(latency.substring(latency.length() - 2, latency.length())));
                    }
                }
            }
            for (String s : stat.simpleRecord) {
                if (s.length() < 25) {
                    continue;
                }
                if (s.substring(0, 23).equals("Тривалість пошкодження:")) {
                    String temp  = s.substring(24, s.length() - 1);
                    int hour = Integer.valueOf(temp.substring(0, temp.length() - 3));
                    int minute = Integer.valueOf(temp.substring(temp.length() - 2, temp.length()));
                    previousYearTable1[42][stat.dist] += hour * 60 + minute;
                    if (department == Sh) {
                        previousYearTable1[43][stat.dist] += hour * 60 + minute;
                    }
                    break;
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (i == 7) {
                continue;
            }
            double d = 0;
            for (int j = 1; j <= 8; j++) {
                d += equipmentTechnicalPointsPreviousYear[i][j].doubleValue();
            }
            previousYearTable1[39][i] = (int) (d * 100);
        }
    }

    private static void calculateStatisticTable2() {
        for (Stat stat : thisYearStats) {
            int numberOfTable = 0;
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            for (String[] s : stat.paramsPanelTypeOfDeviceOnPanelIntroductionError) {
                if (s[0].equals("comboBoxTypeOfDevice")) {
                    numberOfTable = Integer.valueOf(s[1]);
                    numberOfTable = (numberOfTable == 8) || (numberOfTable == 9) ? 7 : numberOfTable;
                    numberOfTable = numberOfTable == 10 ? 8 : numberOfTable;
                    break;
                }
            }
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    table2[numberOfTable][28][stat.dist]++; // Всього відмов за службою Ш
                    switch (s[1]) {
                        case "1": // Пульти, табло, апарати управління
                            table2[numberOfTable][2][stat.dist]++;
                            break;
                        case "2": // Релейні шафи, стативи
                            table2[numberOfTable][3][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxElement")) {
                                    switch (s1[1]) {
                                        case "1": // Релейна апаратура
                                            table2[numberOfTable][4][stat.dist]++;
                                            break;
                                        case "2": // Безконтактна апаратура
                                            table2[numberOfTable][5][stat.dist]++;
                                            break;
                                        case "3": // Трансформатори
                                            table2[numberOfTable][6][stat.dist]++;
                                            break;
                                        case "4": // Елементи захисту
                                            table2[numberOfTable][7][stat.dist]++;
                                            break;
                                        case "5": // Інші елементи
                                            table2[numberOfTable][8][stat.dist]++;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "3": // Щитові електропостачальні установки
                            table2[numberOfTable][9][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxElement")) {
                                    switch (s1[1]) {
                                        case "1": // Релейна апаратура
                                            table2[numberOfTable][10][stat.dist]++;
                                            break;
                                        case "2": // Безконтактна апаратура
                                            table2[numberOfTable][11][stat.dist]++;
                                            break;
                                        case "3": // Трансформатори
                                            table2[numberOfTable][12][stat.dist]++;
                                            break;
                                        case "4": // Елементи захисту
                                            table2[numberOfTable][13][stat.dist]++;
                                            break;
                                        case "5": // Інші елементи
                                            table2[numberOfTable][14][stat.dist]++;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "4": // Акумулятори
                            table2[numberOfTable][15][stat.dist]++;
                            break;
                        case "5": // Сигнали
                            table2[numberOfTable][16][stat.dist]++;
                            break;
                        case "6": // Приводи, замки
                            table2[numberOfTable][17][stat.dist]++;
                            break;
                        case "7": // Повітряні лінії
                            table2[numberOfTable][18][stat.dist]++;
                            break;
                        case "8": // Кабельні лінії
                            table2[numberOfTable][19][stat.dist]++;
                            break;
                        case "9": // Рейкові кола
                            table2[numberOfTable][20][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxElement")) {
                                    switch (s1[1]) {
                                        case "1": // Релейна апаратура
                                            table2[numberOfTable][21][stat.dist]++;
                                            break;
                                        case "2": // Безконтактна апаратура
                                            table2[numberOfTable][22][stat.dist]++;
                                            break;
                                        case "3": // Трансформатори
                                            table2[numberOfTable][23][stat.dist]++;
                                            break;
                                        case "4": // Елементи захисту
                                            table2[numberOfTable][24][stat.dist]++;
                                            break;
                                        case "5": // Рейкові з'єднувачі
                                            table2[numberOfTable][25][stat.dist]++;
                                            break;
                                        case "6": // Інші елементи
                                            table2[numberOfTable][26][stat.dist]++;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "10": // Інші об'єкти
                            table2[numberOfTable][27][stat.dist]++;
                            break;
                    }
                    break;
                }
            }
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxReason2")) {
                    switch (s[1]) {
                        case "1": // Конструктивні
                            table2[numberOfTable][30][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason2_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0": // Проектні
                                            table2[numberOfTable][31][stat.dist]++;
                                            break;
                                        case "1": // Заводські
                                            table2[numberOfTable][32][stat.dist]++;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "2":
                            table2[numberOfTable][33][stat.dist]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason2_additionally_1")) {
                                    switch (s1[1]) {
                                        case "1": // Порушення терміну виконання робіт (ЦШ-0060)
                                            table2[numberOfTable][34][stat.dist]++;
                                            break;
                                        case "2": // Порушення технології виконання робіт (ЦШ-0060)
                                            table2[numberOfTable][35][stat.dist]++;
                                            break;
                                        case "3": // Порушення правил безпеки руху (ЦШ-0018)
                                            table2[numberOfTable][36][stat.dist]++;
                                            break;
                                        case "4": // Помилка під час виконання робіт, що не викликала порушень Безпеки Руху
                                            table2[numberOfTable][37][stat.dist]++;
                                            break;
                                        case "5": // Неякісна перевірка і ремонт в КВП, майстернях
                                            table2[numberOfTable][38][stat.dist]++;
                                            break;
                                        case "6": // Старіння зношеність
                                            table2[numberOfTable][39][stat.dist]++;
                                            break;
                                        case "7": // Гроза, стихія
                                            table2[numberOfTable][40][stat.dist]++;
                                            break;
                                        case "8": // Причина не встановлена
                                            table2[numberOfTable][41][stat.dist]++;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                }
            }
            for (String s : stat.simpleRecord) {
                if (s.length() < 25) {
                    continue;
                }
                if (s.substring(0, 23).equals("Тривалість пошкодження:")) {
                    String temp  = s.substring(24, s.length() - 1);
                    int hour = Integer.valueOf(temp.substring(0, temp.length() - 3));
                    int minute = Integer.valueOf(temp.substring(temp.length() - 2, temp.length()));
                    table2[numberOfTable][44][stat.dist] += hour * 60 + minute;
                    break;
                }
            }
        }
        for (int table = 1; table <= 8; table++) {
            for (int row = 2; row <= 44; row++) {
                for (int column = 1; column <= 12; column++) {
                    table2[9][row][column] += table2[table][row][column];
                }
            }
        }
        for (int table = 1; table <= 9; table++) {
            for (int row = 2; row <= 44; row++) {
                for (int column = 1; column <= 12; column++) {
                    table2[table][row][13] += table2[table][row][column];
                }
            }
        }
    }

    private static void calculateStatisticTable3_1() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("1")) {
                        int row = 0;
                        int column = 0;
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                row = Integer.valueOf(s1[1]) + 2;
                                for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                    if (s2[0].equals("comboBoxElement")) {
                                        column = s2[1].equals("1") ? 1 : Integer.valueOf(s2[1]) - 1;
                                        table3_1[row][column]++;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        calculateTotal(table3_1, 3, 19, 1, 11);
    }

    private static void calculateStatisticTable3_2() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("2")) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                switch (s1[1]) {
                                    case "1":
                                        row = 3;
                                        break;
                                    case "2":
                                        row = 4;
                                        break;
                                    case "4":
                                        row = 5;
                                        break;
                                }
                                break;
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) {
                                if (s1[1].equals("5")) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_1")) {
                                            switch (s2[1]) {
                                                case "1":
                                                    column = 1;
                                                    break;
                                                case "2":
                                                    column = 2;
                                                    break;
                                                case "3":
                                                    column = 3;
                                                    break;
                                                default:
                                                    column = 4;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }

                    }
                    break;
                }
            }
            table3_2[row][column]++;
        }
        table3_2[3][5] = table3_2[3][1] + table3_2[3][2] + table3_2[3][3] + table3_2[3][4];
        table3_2[4][5] = table3_2[4][1] + table3_2[4][2] + table3_2[4][3] + table3_2[4][4];
        table3_2[5][5] = table3_2[5][1] + table3_2[5][2] + table3_2[5][3] + table3_2[5][4];
        table3_2[6][1] = table3_2[3][1] + table3_2[4][1] + table3_2[5][1];
        table3_2[6][2] = table3_2[3][2] + table3_2[4][2] + table3_2[5][2];
        table3_2[6][3] = table3_2[3][3] + table3_2[4][3] + table3_2[5][3];
        table3_2[6][4] = table3_2[3][4] + table3_2[4][4] + table3_2[5][4];
        table3_2[6][5] = table3_2[3][5] + table3_2[4][5] + table3_2[5][5];
    }

    private static void calculateStatisticTable3_3() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("3")) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                switch (s1[1]) {
                                    case "1":
                                        row = 12;
                                        break;
                                    case "2":
                                        row = 3;
                                        break;
                                    case "3":
                                        row = 7;
                                        break;
                                    case "4":
                                        row = 5;
                                        break;
                                    case "5":
                                        row = 6;
                                        break;
                                    case "6":
                                        row = 8;
                                        break;
                                    case "7":
                                        row = 10;
                                        break;
                                    case "8":
                                        row = 4;
                                        break;
                                    case "9":
                                        row = 11;
                                        break;
                                    case "10":
                                        row = 9;
                                        break;
                                    case "11":
                                        row = 13;
                                        break;
                                }
                                break;
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) {
                                if (s1[1].equals("2")) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_1")) {
                                            if (s2[1].equals("14")) {
                                                column = 1;
                                            }
                                            break;
                                        }
                                    }
                                }
                                if (s1[1].equals("5")) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_1")) {
                                            switch (s2[1]) {
                                                case "11":
                                                    column = 2;
                                                    break;
                                                case "1":
                                                case "3":
                                                    column = 3;
                                                    break;
                                                case "7":
                                                    column = 4;
                                                    break;
                                                case "17":
                                                    column = 5;
                                                    break;
                                                case "4":
                                                    column = 6;
                                                    break;
                                                case "16":
                                                    column = 7;
                                                    break;
                                                case "15":
                                                    column = 8;
                                                    break;
                                                case "14":
                                                    column = 9;
                                                    break;
                                                case "9":
                                                    column = 10;
                                                    break;
                                                case "10":
                                                    column = 11;
                                                    break;
                                                case "13":
                                                    column = 12;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            table3_3[row][column]++;
        }
        calculateTotal(table3_3, 3, 14, 1, 13);
    }

    private static void calculateStatisticTable3_4() {
        boolean thunderstorm = false;
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if ((s[1].equals("2")) || (s[1].equals("3")) || (s[1].equals("9"))) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement2")) {
                                column = Integer.valueOf(s1[1]) > 1 ? Integer.valueOf(s1[1]) - 1 : Integer.valueOf(s1[1]);
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxReason1")) {
                                thunderstorm = s1[1].equals("6");
                                break;
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) {
                                switch (s1[1]) {
                                    case "1":  // Релейна апаратура
                                        for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                            if (s2[0].equals("comboBoxElement_additionally_1")) {
                                                switch (s2[1]) {
                                                    case "1": // Реле
                                                        table3_4[4][column]++;
                                                        if (thunderstorm) {table3_4[4][8]++;}
                                                        for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                            if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                                table3_4[Integer.valueOf(s3[1]) + 5][column]++;
                                                                if (thunderstorm) {table3_4[Integer.valueOf(s3[1]) + 5][8]++;}
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case "2": // Блок
                                                        table3_4[13][column]++;
                                                        if (thunderstorm) {table3_4[13][8]++;}
                                                        break;
                                                    case "3": // Дешифратор
                                                        for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                            if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                                if (s3[1].equals("0")) { // Дешифратор АБ
                                                                    table3_4[14][column]++;
                                                                    if (thunderstorm) {table3_4[14][8]++;}
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case "4": // Трансміттер
                                                        table3_4[15][column]++;
                                                        if (thunderstorm) {table3_4[15][8]++;}
                                                        break;
                                                    case "5": // Сигнальний механізм
                                                        table3_4[16][column]++;
                                                        if (thunderstorm) {table3_4[16][8]++;}
                                                        break;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    case "2": // Безконтактна апаратура
                                        for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                            if (s2[0].equals("comboBoxElement_additionally_1")) {
                                                switch (s2[1]) {
                                                    case "1": // Безконтактне реле
                                                        table3_4[18][column]++;
                                                        if (thunderstorm) {table3_4[18][8]++;}
                                                        break;
                                                    case "2": // Трансміттери
                                                        table3_4[19][column]++;
                                                        if (thunderstorm) {table3_4[19][8]++;}
                                                        break;
                                                    case "3": // Конденсаторні блоки
                                                        table3_4[20][column]++;
                                                        if (thunderstorm) {table3_4[20][8]++;}
                                                        break;
                                                    case "6": // Випрямлячі
                                                        table3_4[21][column]++;
                                                        if (thunderstorm) {table3_4[21][8]++;}
                                                        break;
                                                    case "8": // Перетворювачі
                                                        table3_4[22][column]++;
                                                        if (thunderstorm) {table3_4[22][8]++;}
                                                        break;
                                                    case "9": // Захисні блоки
                                                        table3_4[23][column]++;
                                                        if (thunderstorm) {table3_4[23][8]++;}
                                                        break;
                                                    case "10": // Фазуючі пристрої
                                                        table3_4[24][column]++;
                                                        if (thunderstorm) {table3_4[24][8]++;}
                                                        break;
                                                    case "11": // Апаратура ДЦ, ДК, АДЦУ
                                                        table3_4[25][column]++;
                                                        if (thunderstorm) {table3_4[25][8]++;}
                                                        break;
                                                    case "12": // Резистори
                                                        table3_4[26][column]++;
                                                        if (thunderstorm) {table3_4[26][8]++;}
                                                        break;
                                                    case "13": // Апаратура АЛСН
                                                        table3_4[27][column]++;
                                                        if (thunderstorm) {table3_4[27][8]++;}
                                                        break;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    case "3":
                                        table3_4[28][column]++;
                                        if (thunderstorm) {table3_4[28][8]++;}
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        calculateTotal(table3_4, 4, 29, 1, 9);
    }

    private static void calculateStatisticTable3_6() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) { // Об'єкт
                    if ((s[1].equals("2")) || (s[1].equals("3")) || (s[1].equals("9"))) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) { // Елемент
                                if (s1[1].equals("4")) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_1")) {
                                            switch (s2[1]) {
                                                case "1": // Запобіжник
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            column = s3[1].equals("0") ? 1 : 2;
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "2": // АВМ
                                                    column = 4;
                                                    break;
                                                case "4": // Розрядник
                                                    column = 3;
                                                    break;
                                                case "5": // Вирівнювач
                                                    column = 5;
                                                    break;
                                                case "6": // Варистор
                                                    column = 7;
                                                    break;
                                                case "7": // Заземлення
                                                    column = 6;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxReason1")) {
                                            switch (s2[1]) {
                                                case "1": // Невідповідність номіналу
                                                    row = 4;
                                                    break;
                                                case "2": // Коротке замикання
                                                    row = 5;
                                                    break;
                                                case "4": // Неякісна пайка
                                                    row = 10;
                                                    break;
                                                case "5": // Старіння і окислення
                                                    row = 9;
                                                    break;
                                                case "6": // Неправильне регулювання сигнальної пружини
                                                    row = 7;
                                                    break;
                                                case "7": // Дефект матеріалу
                                                    row = 8;
                                                    break;
                                                case "8": // Втрата контакту
                                                    row = 6;
                                                    break;
                                                case "9": // Гроза
                                                    row = 11;
                                                    break;
                                                case "10": // Тяговий струм
                                                    row = 12;
                                                    break;
                                                case "11": // Механічне пошкодження
                                                    row = 13;
                                                    break;
                                                case "12": // Причина не встановлена
                                                    row = 14;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            table3_6[row][column]++;
        }
        calculateTotal(table3_6, 4, 15, 1, 8);
    }

    private static void calculateStatisticTable3_7() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("4")) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                column = Integer.valueOf(s1[1]);
                                break;
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxReason1")) {
                                row = Integer.valueOf(s1[1]) + 3;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            table3_7[row][column]++;
        }
        calculateTotal(table3_7, 4, 13, 1, 7);
    }

    private static void calculateStatisticTable3_8() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("5")) {
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                if ((s1[1].equals("1")) || (s1[1].equals("2")) || (s1[1].equals("3"))) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxShObjects_additionally_2")) {
                                            column = Integer.valueOf(s2[1]) + 1;
                                            break;
                                        }
                                    }
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxShObjects2_additionally")) {
                                            column += (Integer.valueOf(s2[1]) * 3);
                                            System.out.println(column);
                                            break;
                                        }
                                    }
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxReason1")) {
                                            switch (s2[1]) {
                                                case "5": // Перегорання ламп
                                                    table3_8[4][column]++;
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxReason1_additionally_2")) {
                                                            table3_8[5 + Integer.valueOf(s3[1])][column]++;
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "1": // Втрата контакту в лампотримачі
                                                    table3_8[8][column]++;
                                                    break;
                                                case "6": // Падіння світлофора - корозія
                                                    table3_8[9][column]++;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        calculateTotal(table3_8, 4, 10, 1, 7);
    }

    private static void calculateStatisticTable3_9() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("6")) { // Приводи, замки
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                switch (s1[1]) {
                                    case "1": // Електропривід
                                        for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                            if (s2[0].equals("comboBoxShObjects_additionally_2")) {
                                                switch (s2[1]) {
                                                    case "0": // Стрілочний
                                                        for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                            if (s3[0].equals("comboBoxShObjects2_additionally")) {
                                                                switch (s3[1]) {
                                                                    case "0": // СП-3
                                                                        column = 1;
                                                                        break;
                                                                    case "1": // СП-6
                                                                        column = 2;
                                                                        break;
                                                                    case "2": // СПВ-5
                                                                        column = 3;
                                                                        break;
                                                                    case "3": // СПГ-3М
                                                                        column = 4;
                                                                        break;
                                                                    case "4": // СПГБ-4М
                                                                        column = 5;
                                                                        break;
                                                                    case "5": // СП-ТС
                                                                        column = 6;
                                                                        break;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case "1": // Контрольний замок
                                                        column = 7;
                                                        break;
                                                    case "2": // Автошлагбауму
                                                        column = 8;
                                                        break;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    case "2": // Замок Мелентьєва
                                        column = 9;
                                        break;
                                    case "3": // Приводозамикач
                                        column = 10;
                                        break;
                                    case "4": // Інший
                                        column = 11;
                                        break;
                                }
                                break;
                            }
                        }
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) {
                                switch (s1[1]) {
                                    case "1": // Автоперемикач
                                        table3_9[3][column]++;
                                        for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                            if (s2[0].equals("comboBoxReason1")) {
                                                switch (s2[1]) {
                                                    case "2": // Недостатнє врубування ножів
                                                        table3_9[4][column]++;
                                                        break;
                                                    case "4": // Механічне пошкодження
                                                        table3_9[5][column]++;
                                                        break;
                                                    case "5": // Забруднення контактів
                                                        table3_9[7][column]++;
                                                        break;
                                                    case "6": // Обледеніння
                                                        table3_9[8][column]++;
                                                        break;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    case "2": // Заклинювання шибера
                                        table3_9[9][column]++;
                                        break;
                                    case "3": // Несправність механічної передачі
                                        table3_9[10][column]++;
                                        break;
                                    case "4": // Блок-контакти
                                        table3_9[11][column]++;
                                        break;
                                    case "5": // Монтаж
                                        table3_9[12][column]++;
                                        break;
                                    case "6": // Несправність електродвигуна
                                        table3_9[13][column]++;
                                        break;
                                    case "7": // Замок Мелентьєва
                                        table3_9[14][column]++;
                                        for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                            if (s2[0].equals("comboBoxElement_additionally_1")) {
                                                switch (s2[1]) {
                                                    case "0": // Пружина
                                                        table3_9[15][column]++;
                                                        break;
                                                    case "1": // Цугальта
                                                        table3_9[16][column]++;
                                                        break;
                                                    case "2": // Штифт
                                                        table3_9[17][column]++;
                                                        break;
                                                    case "3": // Т-подібний болт
                                                        table3_9[18][column]++;
                                                        break;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    case "8": // Курбельна заслінка
                                        table3_9[19][column]++;
                                        break;
                                    case "9": // Інший елемент
                                        table3_9[20][column]++;
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        for (int column = 1; column <= 11; column++) {
            table3_9[21][column] += table3_9[3][column];
            for (int row = 9; row <= 14; row++) {
                table3_9[21][column] += table3_9[row][column];
            }
            table3_9[21][column] += table3_9[19][column];
            table3_9[21][column] += table3_9[20][column];
        }
        for (int row = 3; row <= 21; row++) {
            for (int column = 1; column <= 11; column++) {
                table3_9[row][12] += table3_9[row][column];
            }
        }
    }

    private static void calculateStatisticTable3_9a() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("6")) { // Приводи, замки
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxElement")) {
                                if (s1[1].equals("6")) {
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_1")) {
                                            switch (s2[1]) {
                                                case "0": // МСП-0,1
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            switch (s3[1]) {
                                                                case "0": // 30
                                                                    row = 4;
                                                                    break;
                                                                case "1": // 100
                                                                    row = 5;
                                                                    break;
                                                                case "2": // 160
                                                                    row = 6;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "1": // МСП-0,15
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            switch (s3[1]) {
                                                                case "0": // 30
                                                                    row = 7;
                                                                    break;
                                                                case "1": // 110
                                                                    row = 8;
                                                                    break;
                                                                case "2": // 160
                                                                    row = 9;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "2": // МСП-0,25
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            switch (s3[1]) {
                                                                case "0": // 30
                                                                    row = 10;
                                                                    break;
                                                                case "1": // 100
                                                                    row = 11;
                                                                    break;
                                                                case "2": // 160
                                                                    row = 12;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "3": // МСА-0,3
                                                    row = 13;
                                                    break;
                                                case "4": // МСТ-0,3
                                                    row = 14;
                                                    break;
                                                case "5": // МСТ-У-0,3
                                                    row = 15;
                                                    break;
                                                case "6": // ДП-0,18
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            switch (s3[1]) {
                                                                case "0": // 30
                                                                    row = 16;
                                                                    break;
                                                                case "1": // 110
                                                                    row = 17;
                                                                    break;
                                                                case "2": // 160
                                                                    row = 18;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "7": // ДП-0,25
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                            switch (s3[1]) {
                                                                case "0": // 30
                                                                    row = 19;
                                                                    break;
                                                                case "1": // 110
                                                                    row = 20;
                                                                    break;
                                                                case "2": // 160
                                                                    row = 21;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                        if (s2[0].equals("comboBoxElement_additionally_3")) {
                                            switch (s2[1]) {
                                                case "0": // Обрив, замикання обмоток
                                                    for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s3[0].equals("comboBoxElement_additionally_4")) {
                                                            switch (s3[1]) {
                                                                case "0": // Якоря
                                                                    column = 2;
                                                                    break;
                                                                case "1": // Ротора
                                                                    column = 3;
                                                                    break;
                                                                case "2": // Статора
                                                                    column = 4;
                                                                    break;
                                                                case "3": // Збудження
                                                                    column = 5;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "1": // Щітковий вузол
                                                    column = 6;
                                                    break;
                                                case "2": // Пониження ізоляції
                                                    column = 7;
                                                    break;
                                                case "3": // Інший елемент
                                                    column = 8;
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            table3_9a[row][column]++;
        }
        calculateTotal(table3_9a, 4, 22, 1, 9);
    }

    private static void calculateStatisticTable3_10() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            boolean station = stat.paramsPanelIntroductionError[11][1].equals("1");
            switch (stat.paramsPanelIntroductionError[13][1]) {
                case "1": // Sh
                    for (String[] s : stat.paramsPanelObjectsAndReasons) {
                        if (s[0].equals("comboBoxShObjects")) {
                            if (s[1].equals("9")) { // Рейкові кола
                                for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                    if (s1[0].equals("comboBoxElement")) {
                                        switch (s1[1]) {
                                            case "5": // Рейкові з'єднувачі
                                                for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                    if (s2[0].equals("comboBoxReason1")) {
                                                        switch (s2[1]) {
                                                            case "1": // Обрив
                                                                table3_10[4][station ? 1 : 2]++;
                                                                table3_10[4][3]++;
                                                                break;
                                                            case "2": // Відсутність
                                                                table3_10[6][station ? 1 : 2]++;
                                                                table3_10[6][3]++;
                                                                break;
                                                            case "6": // Причина не встановлена
                                                                table3_10[26][station ? 1 : 2]++;
                                                                table3_10[26][3]++;
                                                                break;
                                                            case "7": // Інша прчина
                                                                table3_10[27][station ? 1 : 2]++;
                                                                table3_10[27][3]++;
                                                                break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            case "6": // Інші елементи
                                                for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                    if (s2[0].equals("comboBoxElement_additionally_1")) {
                                                        switch (s2[1]) {
                                                            case "1": // Перемичка
                                                                table3_10[7][station ? 1 : 2]++;
                                                                table3_10[7][3]++;
                                                                for (String[] s3 : stat.paramsPanelObjectsAndReasons) {
                                                                    if (s3[0].equals("comboBoxElement_additionally_2")) {
                                                                        switch (s3[1]) {
                                                                            case "0": // Дросельна
                                                                                table3_10[8][station ? 1 : 2]++;
                                                                                table3_10[8][3]++;
                                                                                break;
                                                                            case "1": // Міждросельна
                                                                                table3_10[9][station ? 1 : 2]++;
                                                                                table3_10[9][3]++;
                                                                                break;
                                                                            case "2": // Джемперна
                                                                                table3_10[10][station ? 1 : 2]++;
                                                                                table3_10[10][3]++;
                                                                                break;
                                                                            case "3": // Інша
                                                                                table3_10[11][station ? 1 : 2]++;
                                                                                table3_10[11][3]++;
                                                                                break;
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case "3": // Дросель-трансформатор
                                                                table3_10[25][station ? 1 : 2]++;
                                                                table3_10[25][3]++;
                                                                break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                    if (s2[0].equals("comboBoxReason1")) {
                                                        switch (s2[1]) {
                                                            case "9": // Причина не з'ясована
                                                                table3_10[26][station ? 1 : 2]++;
                                                                table3_10[26][3]++;
                                                                break;
                                                            case "10": // Інша причина
                                                                table3_10[27][station ? 1 : 2]++;
                                                                table3_10[27][3]++;
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                case "2": // P
                    for (String[] s : stat.paramsPanelObjectsAndReasons) {
                        if (s[0].equals("comboBoxObject")) {
                            switch (s[1]) {
                                case "1":  // Рейкове коло
                                    for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                        if (s1[0].equals("comboBoxElement")) {
                                            switch (s1[1]) {
                                                case "0": // Рейковий з'єднувач
                                                    table3_10[4][station ? 4 : 5]++;
                                                    table3_10[4][6]++;
                                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s2[0].equals("comboBoxReason")) {
                                                            switch (s2[1]) {
                                                                case "1": // Відсутність
                                                                    table3_10[6][station ? 4 : 5]++;
                                                                    table3_10[6][6]++;
                                                                    break;
                                                                case "3": // Обрив під час колійних робіт
                                                                    table3_10[5][station ? 4 : 5]++;
                                                                    table3_10[5][6]++;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "1": // Ізостик
                                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s2[0].equals("comboBoxReason")) {
                                                            switch (s2[1]) {
                                                                case "0": // Порушення ізоляції
                                                                    table3_10[13][station ? 4 : 5]++;
                                                                    table3_10[13][6]++;
                                                                    table3_10[14][station ? 4 : 5]++;
                                                                    table3_10[14][6]++;
                                                                    break;
                                                                case "1": // Несправний клеєболтовий ізостик
                                                                    table3_10[18][station ? 4 : 5]++;
                                                                    table3_10[18][6]++;
                                                                    break;
                                                                case "2": // Несправний надміцний ізостик
                                                                    table3_10[19][station ? 4 : 5]++;
                                                                    table3_10[19][6]++;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "2": // Пониження ізоляції баласту
                                                    table3_10[20][station ? 4 : 5]++;
                                                    table3_10[20][6]++;
                                                    break;
                                                case "3": // Перемичка
                                                    table3_10[7][station ? 4 : 5]++;
                                                    table3_10[7][6]++;
                                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s2[0].equals("comboBoxElement_additionally1")) {
                                                            switch (s2[1]) {
                                                                case "0": // Дросельна
                                                                    table3_10[8][station ? 4 : 5]++;
                                                                    table3_10[8][6]++;
                                                                    break;
                                                                case "1": // Міждросельна
                                                                    table3_10[9][station ? 4 : 5]++;
                                                                    table3_10[9][6]++;
                                                                    break;
                                                                case "2": // Джемперна
                                                                    table3_10[10][station ? 4 : 5]++;
                                                                    table3_10[10][6]++;
                                                                    break;
                                                                case "3": // Інші
                                                                    table3_10[11][station ? 4 : 5]++;
                                                                    table3_10[11][6]++;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s2[0].equals("comboBoxReason")) {
                                                            if (s2[1].equals("1")) { // Під час колійних робіт
                                                                table3_10[12][station ? 4 : 5]++;
                                                                table3_10[12][6]++;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "4": // Інші причини
                                                    for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                        if (s2[0].equals("comboBoxReason")) {
                                                            switch (s2[1]) {
                                                                case "0": // Закорочування рейкового кола під час робіт
                                                                    table3_10[21][station ? 4 : 5]++;
                                                                    table3_10[21][6]++;
                                                                    table3_10[22][station ? 4 : 5]++;
                                                                    table3_10[22][6]++;
                                                                    break;
                                                                case "1": // Закорочування рейкового кола стороннім предметом
                                                                    table3_10[21][station ? 4 : 5]++;
                                                                    table3_10[21][6]++;
                                                                    table3_10[23][station ? 4 : 5]++;
                                                                    table3_10[23][6]++;
                                                                    break;
                                                                case "2": // Зламалась (тріснула) рейка
                                                                    table3_10[24][station ? 4 : 5]++;
                                                                    table3_10[24][6]++;
                                                                    break;
                                                                case "3": // Інша причина
                                                                    table3_10[27][station ? 4 : 5]++;
                                                                    table3_10[27][6]++;
                                                                    break;
                                                                case "4": // Нез'ясована причина
                                                                    table3_10[26][station ? 4 : 5]++;
                                                                    table3_10[26][6]++;
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                case "2": // Стрілка
                                    for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                        if (s1[0].equals("comboBoxReason")) {
                                            if (s1[1].equals("0")) { // Пробита ізоляція
                                                for (String[] s2 : stat.paramsPanelObjectsAndReasons) {
                                                    if (s2[0].equals("comboBoxElement")) {
                                                        switch (s2[1]) {
                                                            case "1": // Сережка
                                                                table3_10[13][station ? 4 : 5]++;
                                                                table3_10[13][6]++;
                                                                table3_10[17][station ? 4 : 5]++;
                                                                table3_10[17][6]++;
                                                                break;
                                                            case "2": // Стягуюча полоса
                                                                table3_10[13][station ? 4 : 5]++;
                                                                table3_10[13][6]++;
                                                                table3_10[16][station ? 4 : 5]++;
                                                                table3_10[16][6]++;
                                                                break;
                                                            case "5": // Стрілочна гарнітура
                                                                table3_10[13][station ? 4 : 5]++;
                                                                table3_10[13][6]++;
                                                                table3_10[15][station ? 4 : 5]++;
                                                                table3_10[15][6]++;
                                                                break;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                            }
                            break;
                        }
                    }
                    break;
                case "5": // Other
                    if (stat.paramsPanelObjectsAndReasons[0][1].equals("2")) {
                        table3_10[27][station ? 7 : 8]++;
                        table3_10[27][9]++;
                    }
                    break;
            }
        }
        for (int row = 4; row <= 27; row++) {
            table3_10[row][10] = table3_10[row][3] + table3_10[row][6] + table3_10[row][9];
        }
        for (int column = 1; column <= 10; column++) {
            for (int row = 4; row <= 27; row++) {
                table3_10[28][column] += table3_10[row][column];
            }
        }
    }

    private static void calculateStatisticTable3_11() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("7")) { // Повітряні лінії
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                column = Integer.valueOf(s1[1]);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxReason1")) {
                    switch (s[1]) {
                        case "1": // Обрив
                            table3_11[4][column]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason1_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0":
                                            row = 5;
                                            break;
                                        case "1":
                                            row = 6;
                                            break;
                                        case "2":
                                            row = 7;
                                            break;
                                        case "3":
                                            row = 8;
                                            break;
                                        case "4":
                                            row = 9;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "2": // Сполучення (к.з.)
                            table3_11[10][column]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason1_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0":
                                            row = 11;
                                            break;
                                        case "1":
                                            row = 12;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "3": // Накид
                            row = 13;
                            break;
                        case "4": // Кліматичні впливи
                            table3_11[14][column]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason1_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0":
                                            row = 15;
                                            break;
                                        case "1":
                                            row = 16;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                }
            }
            table3_11[row][column]++;
        }
        calculateTotal(table3_11, 4, 17, 1, 3);
    }

    private static void calculateStatisticTable3_12() {
        for (Stat stat : thisYearStats) {
            Department department = Other;
            for (String[] s : stat.paramsPanelIntroductionError) {
                if (s[0].equals("comboBoxDepartment")) { // Служба
                    if (s[1].equals("1")) {
                        department = Sh;
                    }
                    break;
                }
            }
            if (department != Sh) {
                continue;
            }
            int row = 0;
            int column = 0;
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxShObjects")) {
                    if (s[1].equals("8")) { // Кабельні лінії
                        for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                            if (s1[0].equals("comboBoxShObjects_additionally_1")) {
                                column = Integer.valueOf(s1[1]);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            for (String[] s : stat.paramsPanelObjectsAndReasons) {
                if (s[0].equals("comboBoxReason1")) {
                    switch (s[1]) {
                        case "1": // Обрив
                            table3_12[4][column]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason1_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0": // Внутрішній
                                            row = 5;
                                            break;
                                        case "1": // На клемі
                                            row = 6;
                                            break;
                                        case "2": // Під час виконання робіт
                                            row = 7;
                                            break;
                                        case "3": // Дефект матеріалу
                                            row = 8;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "2": // Зовнішні впливи - тяговий і блукаючий струм
                            row = 9;
                            break;
                        case "3": // Заниження ізоляції
                            table3_12[10][column]++;
                            for (String[] s1 : stat.paramsPanelObjectsAndReasons) {
                                if (s1[0].equals("comboBoxReason1_additionally_1")) {
                                    switch (s1[1]) {
                                        case "0": // Старіння потрапляння вологи
                                            row = 11;
                                            break;
                                        case "1": // На клемі
                                            row = 12;
                                            break;
                                    }
                                    break;
                                }
                            }
                            break;
                        case "4": // Сполучення (к.з.)
                            row = 13;
                            break;
                    }
                    break;
                }
            }
            table3_12[row][column]++;
        }
        for (int row = 4; row <= 13; row++) {
            for (int column = 1; column <= 4; column++) {
                table3_12[row][5] += table3_12[row][column];
            }
        }
        for (int column = 1; column <= 5; column++) {
            table3_12[14][column] = table3_12[4][column] + table3_12[9][column] + table3_12[10][column] + table3_12[13][column];
        }
    }

    private static void calculateTotal(int[][] table, int beginRow, int totalRow, int beginColumn, int totalColumn) {
        for (int row = beginRow; row < totalRow; row++) {
            for (int column = beginColumn; column < totalColumn; column++) {
                table[row][totalColumn] += table[row][column];
            }
        }
        for (int column = beginColumn; column <= totalColumn; column++) {
            for (int row = beginRow; row < totalRow; row++) {
                table[totalRow][column] += table[row][column];
            }
        }
    }

    private static boolean copyPreparedTables(String tableName) {
        String sourceFileName = "src/ua/andrewblake/prepared/".concat(tableName).concat(".xls");
        String productFileName = directory.concat("/").concat(tableName).concat(".xls");
        try (InputStream inFile = new FileInputStream(sourceFileName); OutputStream outFile = new FileOutputStream(productFileName)) {
            byte[] buff = new byte[64 * 1024];
            int count;
            while ((count  = inFile.read(buff)) != -1) {
                outFile.write(buff, 0, count);
            }
            outFile.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable1() {
        calculateStatisticTable1ThisYear();
        calculateStatisticTable1PreviousYear();
        if (!copyPreparedTables("Table_1")) {
            return false;
        }
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_1.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);
        cell.setCellValue(nameOfPeriod);
        for (int i = 0; i <= 43; i++) {
            for (int j = 1; j <= 13; j++) {
                if (j == 7) {
                    continue;
                }
                row = sheet.getRow(i + 2);
                int column = 0;
                switch (j) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        column = j * 2;
                        break;
                    case 5:
                    case 6:
                        column = j * 2 + 1;
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        column = j * 2 - 1;
                        break;
                }
                cell = row.getCell(column);
                if (j != 13) {
                    cell.setCellValue(thisYearTable1[i][j] == 0 ? "-" : String.valueOf(thisYearTable1[i][j]));
                } else {
                    int sum = 0;
                    for (int k = 1; k <= 12; k++) {
                        sum += thisYearTable1[i][k];
                        cell.setCellValue(sum == 0 ? "-" : String.valueOf(sum));
                    }
                }
                cell = row.getCell(column + 1);
                if (j != 13) {
                    cell.setCellValue(previousYearTable1[i][j] == 0 ? "-" : String.valueOf(previousYearTable1[i][j]));
                } else {
                    int sum = 0;
                    for (int k = 1; k <= 12; k++) {
                        sum += previousYearTable1[i][k];
                        cell.setCellValue(sum == 0 ? "-" : String.valueOf(sum));
                    }
                }
            }
        }
        for (int j = 1; j <= 13; j++) {
            if (j == 7) {
                continue;
            }
            int column = 0;
            switch (j) {
                case 1:
                case 2:
                case 3:
                case 4:
                    column = j * 2;
                    break;
                case 5:
                case 6:
                    column = j * 2 + 1;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    column = j * 2 - 1;
                    break;
            }
            // this year
            sheet.getRow(1).getCell(column).setCellValue(currentYear);
            cell = sheet.getRow(38).getCell(column);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(39).getCell(column);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(44).getCell(column);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(45).getCell(column);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            if (!sheet.getRow(41).getCell(column).getStringCellValue().equals("-")) {
                cell = sheet.getRow(42).getCell(column);
                cell.setCellValue(sheet.getRow(2).getCell(column).getStringCellValue().equals("-") ? "0.00" : String.valueOf(new BigDecimal(100 * Double.valueOf(sheet.getRow(2).getCell(column).getStringCellValue()) / Integer.valueOf(sheet.getRow(41).getCell(column).getStringCellValue())).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                cell = sheet.getRow(43).getCell(column);
                cell.setCellValue(sheet.getRow(3).getCell(column).getStringCellValue().equals("-") ? "0.00" : String.valueOf(new BigDecimal(100 * Double.valueOf(sheet.getRow(3).getCell(column).getStringCellValue()) / Integer.valueOf(sheet.getRow(41).getCell(column).getStringCellValue())).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                cell = sheet.getRow(41).getCell(column);
//                cell.setCellValue(new BigDecimal(Double.valueOf((cell.getStringCellValue())) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue());
                cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(new BigDecimal(Double.valueOf((cell.getStringCellValue())) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            } else {
                sheet.getRow(41).getCell(column).setCellValue("-");
                sheet.getRow(42).getCell(column).setCellValue("-");
                sheet.getRow(43).getCell(column).setCellValue("-");
            }
            // previous year
            sheet.getRow(1).getCell(column + 1).setCellValue(Integer.valueOf(currentYear) - 1);
            cell = sheet.getRow(38).getCell(column + 1);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(39).getCell(column + 1);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(44).getCell(column + 1);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            cell = sheet.getRow(45).getCell(column + 1);
            cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(Integer.valueOf(cell.getStringCellValue()) / 60).concat(":").concat(Integer.valueOf(cell.getStringCellValue()) % 60 < 10 ? "0".concat(String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)) : String.valueOf(Integer.valueOf(cell.getStringCellValue()) % 60)));
            if (!sheet.getRow(41).getCell(column + 1).getStringCellValue().equals("-")) {
                cell = sheet.getRow(42).getCell(column + 1);
                cell.setCellValue(sheet.getRow(2).getCell(column + 1).getStringCellValue().equals("-") ? "0.00" : String.valueOf(new BigDecimal(100 * Double.valueOf(sheet.getRow(2).getCell(column + 1).getStringCellValue()) / Integer.valueOf(sheet.getRow(41).getCell(column + 1).getStringCellValue())).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                cell = sheet.getRow(43).getCell(column + 1);
                cell.setCellValue(sheet.getRow(3).getCell(column + 1).getStringCellValue().equals("-") ? "0.00" : String.valueOf(new BigDecimal(100 * Double.valueOf(sheet.getRow(3).getCell(column + 1).getStringCellValue()) / Integer.valueOf(sheet.getRow(41).getCell(column + 1).getStringCellValue())).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                cell = sheet.getRow(41).getCell(column + 1);
                cell.setCellValue(cell.getStringCellValue().equals("-") ? "-" : String.valueOf(new BigDecimal(Double.valueOf((cell.getStringCellValue())) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            } else {
                sheet.getRow(41).getCell(column + 1).setCellValue("-");
                sheet.getRow(42).getCell(column + 1).setCellValue("-");
                sheet.getRow(43).getCell(column + 1).setCellValue("-");
            }
        }


        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_1.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable2() {
        calculateStatisticTable2();
        int column = 0;
        Workbook workbook = null;
        for (int t = 1; t <= 9; t++) {
            if (!copyPreparedTables("Table_2.".concat(String.valueOf(t)))) {
                return false;
            }


            try {
                workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_2.").concat(String.valueOf(t)).concat(".xls")));
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
                return false;
            }
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(1);
            cell.setCellValue(nameOfPeriod);
            for (int i = 2; i <= 44; i++) {
                if (i == 29) {
                    continue;
                }
                for (int j = 1; j <= 13; j++) {
                    if (j == 7) {
                        continue;
                    }
                    column = j < 7 ? j + 1 : j;
                    cell = sheet.getRow(i).getCell(column);
                    cell.setCellValue(table2[t][i][j] == 0 ? "-" : String.valueOf(table2[t][i][j]));
                    if (i == 42) {
                        ;
                        if (t < 9) {
                            if (j < 13) {
                                sheet.getRow(42).getCell(column).setCellValue(equipmentTechnicalPoints[j][t].equals(0) ? "-" : String.valueOf(equipmentTechnicalPoints[j][t]));
                            } else {
                                double d = 0;
                                for (int k = 1; k <= 12; k++) {
                                    if (k == 7) {
                                        continue;
                                    }
                                    d += equipmentTechnicalPoints[k][t].doubleValue();
                                }
                                sheet.getRow(42).getCell(column).setCellValue(new BigDecimal(d).setScale(2, RoundingMode.HALF_UP).toString());
                            }
                        } else {
                            if (j < 13) {
                                double d = 0;
                                for (int k = 1; k <= 8; k++) {
                                    d += equipmentTechnicalPoints[j][k].doubleValue();
                                }
                                sheet.getRow(42).getCell(column).setCellValue(new BigDecimal(d).setScale(2, RoundingMode.HALF_UP).toString());
                            } else {
                                double d = 0;
                                for (int k = 1; k <= 12; k++) {
                                    if (k == 7) {
                                        continue;
                                    }
                                    d += Double.valueOf(sheet.getRow(42).getCell(k < 7 ? k + 1 : k).getStringCellValue());
                                }
                                sheet.getRow(42).getCell(column).setCellValue(new BigDecimal(d).setScale(2, RoundingMode.HALF_UP).toString());
                            }
                        }
                    }
                    if (i == 43) {
                        sheet.getRow(43).getCell(column).setCellValue(table2[t][28][j] == 0 || table2[t][42][j] == 0 ? "-" : new BigDecimal(table2[t][28][j] / Double.valueOf(sheet.getRow(42).getCell(column).getStringCellValue())).setScale(2, RoundingMode.HALF_UP).toString());
                    }
                    if (i == 44) {
                        sheet.getRow(44).getCell(column).setCellValue(table2[t][28][j] == 0 || table2[t][44][j] == 0 ? "-" : String.valueOf((table2[t][44][j] / table2[t][28][j]) / 60).concat(":").concat(String.valueOf((table2[t][44][j] / table2[t][28][j]) % 60)));
                        if (!sheet.getRow(44).getCell(column).getStringCellValue().equals("-")) {
                            String s = sheet.getRow(44).getCell(column).getStringCellValue();
                            char c = s.charAt(s.length() - 3);
                            if (!":".equals(String.valueOf(c))) {
                                sheet.getRow(44).getCell(column).setCellValue(sheet.getRow(44).getCell(column).getStringCellValue().concat("0"));
                            }
                        }
                    }
                }
            }

            try {
                FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_2.").concat(String.valueOf(t)).concat(".xls"));
                workbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
                return false;
            }

        }
        return true;
    }

    private static boolean writeTable3_1() {
        calculateStatisticTable3_1();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.1")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.1.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 3; row <= 19; row++) {
            for (int column = 1; column <= 11; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_1[row][column] == 0 ? "-" : String.valueOf(table3_1[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.1.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_2() {
        calculateStatisticTable3_2();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.2")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.2.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 3; row <= 6; row++) {
            for (int column = 1; column <= 5; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_2[row][column] == 0 ? "-" : String.valueOf(table3_2[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.2.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_3() {
        calculateStatisticTable3_3();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.3")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.3.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 3; row <= 14; row++) {
            for (int column = 1; column <= 13; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_3[row][column] == 0 ? "-" : String.valueOf(table3_3[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.3.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_4() {
        calculateStatisticTable3_4();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.4")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.4.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 29; row++) {
            if (row == 17) {
                continue;
            }
            for (int column = 1; column <= 9; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_4[row][column] == 0 ? "-" : String.valueOf(table3_4[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.4.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_6() {
        calculateStatisticTable3_6();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.6")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.6.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 15; row++) {
            for (int column = 1; column <= 8; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_6[row][column] == 0 ? "-" : String.valueOf(table3_6[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.6.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_7() {
        calculateStatisticTable3_7();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.7")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.7.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 13; row++) {
            for (int column = 1; column <= 7; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_7[row][column] == 0 ? "-" : String.valueOf(table3_7[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.7.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_8() {
        calculateStatisticTable3_8();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.8")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.8.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 10; row++) {
            for (int column = 1; column <= 7; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_8[row][column] == 0 ? "-" : String.valueOf(table3_8[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.8.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_9() {
        calculateStatisticTable3_9();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.9")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.9.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 3; row <= 21; row++) {
            for (int column = 1; column <= 12; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_9[row][column] == 0 ? "-" : String.valueOf(table3_9[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.9.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_9a() {
        calculateStatisticTable3_9a();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.9a")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.9a.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 22; row++) {
            for (int column = 2; column <= 9; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_9a[row][column] == 0 ? "-" : String.valueOf(table3_9a[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.9a.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_10() {
        calculateStatisticTable3_10();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.10")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.10.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 28; row++) {
            for (int column = 1; column <= 10; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_10[row][column] == 0 ? "-" : String.valueOf(table3_10[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.10.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_11() {
        calculateStatisticTable3_11();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.11")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.11.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 17; row++) {
            for (int column = 1; column <= 3; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_11[row][column] == 0 ? "-" : String.valueOf(table3_11[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.11.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    private static boolean writeTable3_12() {
        calculateStatisticTable3_12();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.12")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.12.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 14; row++) {
            for (int column = 1; column <= 5; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_12[row][column] == 0 ? "-" : String.valueOf(table3_12[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.12.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }

    /*private static int[][] calculateStatistic(String tableName) {

    }

    private static boolean simpleWrite(String tableName, int fromRow, int toRow, int fromColumn, int toColumn) {

        calculateStatisticTable3_4();
        Workbook workbook = null;
        if (!copyPreparedTables("Table_3.6")) {
            return false;
        }
        try {
            workbook = new HSSFWorkbook(new FileInputStream(directory.concat("/").concat("Table_3.6.xls")));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int row = 4; row <= 14; row++) {
            for (int column = 1; column <= 8; column++) {
                sheet.getRow(row).getCell(column).setCellValue(table3_6[row][column] == 0 ? "-" : String.valueOf(table3_6[row][column]));
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.concat("/").concat("Table_3.6.xls"));
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Помилка при спробі запису звітності. Доступ до файлу звітності може бути заблокований іншою програмою");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Збій зв'язку з файловою системою");
            return false;
        }
        return true;
    }*/


}
