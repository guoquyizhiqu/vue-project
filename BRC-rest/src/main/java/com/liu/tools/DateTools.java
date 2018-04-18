package com.liu.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liu on 2018/4/18.
 */
public class DateTools {
    public String getDateStr(String dateStr) throws ParseException{
        DateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(dateFormat.parse(dateStr));
        return "";
    }

}
