package com.cefalo.mentor.etl;

import org.apache.http.client.utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
    public static final String ARC_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";

    public static void main(String[] args) {
        String dateString = "2020-04-02";
        String[] formats = {"yyyy-MM-dd hh:mm:ss Z", "yyyy-MM-dd"};
        Date date = DateUtils.parseDate(dateString, formats);

        DateFormat df = new SimpleDateFormat(ARC_DATE_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String convertedDate = df.format(date);
        System.out.println(convertedDate);
    }
}
