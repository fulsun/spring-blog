package pers.fulsun.blog.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);


    /**
     * LocalDate 转字符串
     *
     * @param localDate
     * @return
     */
    public static String ldToStr(LocalDate localDate) {
        return DATE_FORMATTER.format(localDate);
    }

    /**
     * LocalDate 转字符串
     *
     * @param localDate
     * @param formatter
     * @return
     */
    public static String ldToStr(LocalDate localDate, DateTimeFormatter formatter) {
        return formatter.format(localDate);
    }

    /**
     * 填充日期，如果小于 0，填充 0
     *
     * @param value
     * @return
     */
    public static String fillTime(int value) {
        return value < 10 ? "0" + value : value + "";
    }

    /**
     * LocalDateTime 转字符串
     *
     * @param localDateTime
     * @return
     */
    public static String ldtToStr(LocalDateTime localDateTime) {
        return DATETIME_FORMATTER.format(localDateTime);
    }

}

