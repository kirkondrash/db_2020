package date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {


    public static Date convert(LocalDate date) {
        return Date.from(date.atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    public static LocalDateTime convert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

        // 1981/02/30&18:20
    public static int daysBetween(String firstDate, String lastDate) {
        //JSR 310
        LocalDate parsedFirstDate = LocalDateTime.parse(firstDate, DateTimeFormatter.ofPattern("yyyy/MM/dd&HH:mm")).toLocalDate();
        LocalDate parsedLastDate = LocalDateTime.parse(lastDate, DateTimeFormatter.ofPattern("yyyy/MM/dd&HH:mm")).toLocalDate();
        // the answer depends whether we include the exact dates of period beginning and ending
        return (int) ChronoUnit.DAYS.between(parsedFirstDate,parsedLastDate);
    }



    public static void main(String[] args) {

        System.out.println(daysBetween("1981/03/20&18:20", "1981/03/30&18:20"));
        System.out.println(convert(new Date()));
        System.out.println(convert(LocalDate.now().minusDays(42)));
    }
}
