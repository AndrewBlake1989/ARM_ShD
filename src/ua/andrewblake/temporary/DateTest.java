package ua.andrewblake.temporary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by AndrewBlake on 24.04.2017.
 */
public class DateTest {

    public static void main(String[] args) {
//        Date date;
//        Date date2;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//        String str = "11.04.2017 10:07";
//        String str2 = "24.04.2017 17:18";
//
//        try {
//            date = sdf.parse(str);
//            date2 = sdf.parse(str2);
//            long t = date2.getTime() - date.getTime();
//            System.out.println(date.toString());
//            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy E HH:mm:ss");
//            String datetime = formatForDateNow.format(date).toString();
//            long minutes = TimeUnit.MILLISECONDS.toMinutes(t);
//            System.out.println(datetime);
//            System.out.println(minutes);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        Date date;
        Date date2;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String str = "1.4.2017 1:7";
        String str2 = "44.04.2017 17:18";
        try {
            date = sdf.parse(str);
            date2 = sdf.parse(str2);
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy E HH:mm:ss");
            System.out.println(formatForDateNow.format(date).toString());
            System.out.println(formatForDateNow.format(date2).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }








        String s = "22";
        int i = Integer.valueOf(s);




    }

}
