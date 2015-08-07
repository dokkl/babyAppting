package com.hoon.appting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by hoon on 2015-05-26.
 */
public class CommonUtil {
    public static int getAge(String birthDay)  {
        if (birthDay == null) {
            return Integer.valueOf(0);
        }
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = transFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return getAgeFromBirthday(date);
    }

    //*Java 생일로 나이 구하기
    public static int getAgeFromBirthday(Date birthday) {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();

        birth.setTime(birthday);
        today.setTime(new Date());

        int factor = 0;
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            factor = -1;
        }
        return today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
    }
}
