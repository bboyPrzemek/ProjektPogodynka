package sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixToTimeConverter {

    public static String convert(long unixTime) {


        long unixSeconds = 1503954000;
        // convert seconds to milliseconds
        Date date = new java.util.Date(unixTime * 1000L);
        // the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
// give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+1"));
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);

        return formattedDate.toString();
    }

}