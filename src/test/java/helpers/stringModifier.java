package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class stringModifier {   //Класс помощник с методами для строк

    public static String getUniqueString(String str) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); //создаем уникальное название тикета с использованием даты/времени
    }
}