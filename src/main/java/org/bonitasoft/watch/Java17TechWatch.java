package org.bonitasoft.watch;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.util.Locale;

public class Java17TechWatch {

    public static void main(String[] args) {
        NumberFormat fmtShort = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.SHORT);
        System.out.println(fmtShort.format(1000));
        System.out.println(fmtShort.format(1000000));
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.LONG);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(1000000));

        DayOfWeek dayOfTheWeek = DayOfWeek.MONDAY;
        String messageOfTheDay = switch (dayOfTheWeek) {
            case MONDAY -> {
                System.out.println(dayOfTheWeek);
                yield "Two days till Wednesday!";
            }
            case TUESDAY -> {
                System.out.println(dayOfTheWeek);
                yield "One day till Wednesday!";
            }
            case WEDNESDAY -> "It is Wednesday my dudes!";
            default -> "";
        };
        System.out.println(messageOfTheDay);

    }

    public String howFarFromWednesdayAreWe(DayOfWeek dayOfTheWeek) {
        return switch (dayOfTheWeek) {
            case MONDAY -> "Two days till Wednesday!";
            case TUESDAY -> "One day till Wednesday!";
            case WEDNESDAY -> "It is Wednesday my dudes!";
            default -> "";
        };
    }

    private String textBlock() {
        String detailsJsonTextBlock = """
       {
           "name": "John",
           "lastName": "Doe",
           "experience": "3 years",
           "description": "This is description"
       }
                             """;
        return """
            This is a text block
            It can contain multiple lines
            """;
    }

}