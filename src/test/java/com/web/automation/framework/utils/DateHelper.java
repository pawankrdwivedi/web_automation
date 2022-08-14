package com.web.automation.framework.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class DateHelper
{

    public String getDateFromCurrentDate(String plusOrMinus,int daysFromCurrentDate)
    {
        DateTime dt2=null;
        DateTime dt= new DateTime();
        switch(plusOrMinus.toLowerCase().trim())
        {
            case "plus":
                dt2=dt.plusDays(daysFromCurrentDate);
                break;
            case "minus":
                dt2=dt.minusDays(daysFromCurrentDate);
                break;
        }
        DateTimeFormatter dtFormat=DateTimeFormat.forPattern("dd/MM/yyyy 00:00");
        return dt2.toString(dtFormat);
    }

    public String getUniqueString()
    {
        DateTime dt= new DateTime();
        DateTimeFormatter dtFormat=DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        return (dt.toString(dtFormat)).replaceAll("/", "_").replaceAll(":", "_");
    }
}
