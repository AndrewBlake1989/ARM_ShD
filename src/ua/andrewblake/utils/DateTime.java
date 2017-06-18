package ua.andrewblake.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private static String yearString;
    private static String monthString;
    private static String dayString;
    private static String hourString;
    private static String minuteString;
    private static int yearInt;
    private static int monthInt;
    private static int dayInt;
    private static int hourInt;
    private static int minuteInt;

    private static void calculateCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy E HH:mm:ss");
        String datetime = formatForDateNow.format(date).toString();
        dayString = datetime.substring(0, 2);
        monthString = datetime.substring(3, 5);
        yearString = datetime.substring(6, 10);
        hourString = datetime.substring(14, 16);
        minuteString = datetime.substring(17, 19);
        dayInt = Integer.parseInt(dayString);
        monthInt = Integer.parseInt(monthString);
        yearInt = Integer.parseInt(yearString);
        hourInt = Integer.parseInt(hourString);
        minuteInt = Integer.parseInt(minuteString);
    }

    public static String getYearString() {
        calculateCurrentDateTime();
        return yearString;
    }

    public static String getMonthString() {
        calculateCurrentDateTime();
        return monthString;
    }

    public static String getDayString() {
        calculateCurrentDateTime();
        return dayString;
    }

    public static String getHourString() {
        calculateCurrentDateTime();
        return hourString;
    }

    public static String getMinuteString() {
        calculateCurrentDateTime();
        return minuteString;
    }

    public static int getYearInt() {
        calculateCurrentDateTime();
        return yearInt;
    }

    public static int getMonthInt() {
        calculateCurrentDateTime();
        return monthInt;
    }

    public static int getDayInt() {
        calculateCurrentDateTime();
        return dayInt;
    }

    public static int getHourInt() {
        calculateCurrentDateTime();
        return hourInt;
    }

    public static int getMinuteInt() {
        calculateCurrentDateTime();
        return minuteInt;
    }

    public static boolean isYearIntercalary() {
        calculateCurrentDateTime();
        if ((yearInt % 4 == 0) && (yearInt % 400 == 0)) return true;
        if ((yearInt % 4 == 0) && (yearInt % 100 == 0)) return false;
        if ((yearInt % 4 == 0) && (yearInt % 100 != 0)) return true;
        return false;
    }

    public static boolean isYearIntercalary(int yearInt) {
        if ((yearInt % 4 == 0) && (yearInt % 400 == 0)) return true;
        if ((yearInt % 4 == 0) && (yearInt % 100 == 0)) return false;
        if ((yearInt % 4 == 0) && (yearInt % 100 != 0)) return true;
        return false;
    }
}
