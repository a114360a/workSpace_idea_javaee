package com.aji.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

/**
 * @author aji
 * @create 2021-06-24 9:19
 */
public class DateTest {
    @Test
    public void Test1(){
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(date1.getTime());
        System.out.println(System.currentTimeMillis());
        Date date2 = new Date(date1.getTime());
        System.out.println("1624497867286");
        System.out.println(date2.toString());
        System.out.println("--------------------------------");
        SimpleDateFormat sim1 = new SimpleDateFormat();
        System.out.println(sim1.format(date1));
        SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sim2.format(date1));
        try {
            Date date3 = sim2.parse("2021-06-24 09:28:29");
            System.out.println(date3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------");
        Calendar calendar = Calendar.getInstance();
        Date date4 = calendar.getTime();
        System.out.println(date4);
        date4 = new Date(432432532L);
        calendar.setTime(date4);
        calendar.set(Calendar.DAY_OF_MONTH,8);
        System.out.println(calendar.getTime());
        calendar.set(Calendar.HOUR,2);
        System.out.println(calendar.getTime());
        calendar.set(Calendar.MONDAY,-2);
        System.out.println(calendar.getTime());

    }
    @Test
    public void Test2(){
        LocalDateTime ld = LocalDateTime.now();
        System.out.println(ld);
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime ld2 = LocalDateTime.now(clock);
        System.out.println(ld2);
        Instant instant = Instant.now();

        System.out.println(instant.toEpochMilli());
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dt);
        DateTimeFormatter dt1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(dt1);
        DateTimeFormatter da2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        System.out.println(dt.format(ld));
        System.out.println(dt.parse("2021-06-24 10:10:15"));
    }
}
