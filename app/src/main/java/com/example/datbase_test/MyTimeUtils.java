package com.example.datbase_test;

import java.util.Calendar;
import java.util.TimeZone;

public class MyTimeUtils {
    public static String getYearMonthDayHourMinuteSecond(long timeMillis) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
        calendar.setTimeInMillis(timeMillis);
        int year=calendar.get(Calendar.YEAR);

        int month=calendar.get(Calendar.MONTH) + 1;
        String mToMonth=null;
        if (String.valueOf(month).length()==1) {
            mToMonth="0"+month;
        } else {
            mToMonth=String.valueOf(month);
        }

        int day=calendar.get(Calendar.DAY_OF_MONTH);
        String dToDay=null;
        if (String.valueOf(day).length()==1) {
            dToDay="0"+day;
        } else {
            dToDay=String.valueOf(day);
        }

        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        String hToHour=null;
        if (String.valueOf(hour).length()==1) {
            hToHour="0"+hour;
        } else {
            hToHour=String.valueOf(hour);
        }

        int minute=calendar.get(Calendar.MINUTE);
        String mToMinute=null;
        if (String.valueOf(minute).length()==1) {
            mToMinute="0"+minute;
        } else {
            mToMinute=String.valueOf(minute);
        }

        int second=calendar.get(Calendar.SECOND);
        String sToSecond=null;
        if (String.valueOf(second).length()==1) {
            sToSecond="0"+second;
        } else {
            sToSecond=String.valueOf(second);
        }
        return  year+ "-" +mToMonth+ "-" +dToDay+ " "+hToHour+ ":" +mToMinute+ ":" +sToSecond;
    }

}
