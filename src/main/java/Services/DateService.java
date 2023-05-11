package Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateService {
    final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
    public static String ToString(LocalDate date){
        return dtf.format(date);
    }

    public static boolean validateDate(String dateStr){
        try {
            dtf.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
