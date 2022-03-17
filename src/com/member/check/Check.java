package com.member.check;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean isPhone(String Phone_number) {
        String regex = "^((13[0-9])|(14(0|[5-7]|9))|(15([0-3]|[5-9]))|(16(2|[5-7]))|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(Phone_number);
        return m.matches();
    }
}
