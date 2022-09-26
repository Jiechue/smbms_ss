package com.smbms.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        try {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date =  date = df.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
