package java_8_examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Friday13Service {
    public static void printMap(int startYear, int endYear) {
        Map<Integer, Long> friday12Freq = IntStream
                .range(startYear, endYear).boxed()
                .flatMap(Friday13Service::getMonthsOfYear)
                .filter(month -> month.atDay(13).getDayOfWeek().equals(DayOfWeek.FRIDAY))
                .collect(Collectors.groupingBy(YearMonth::getYear, Collectors.counting()));

        System.out.println(String.format("Years with 13Fridays: %s", friday12Freq.size()));
        friday12Freq.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        printMap(2001, 2011);
    }

    public static Stream<YearMonth> getMonthsOfYear(int year){
        return IntStream
                .range(1, 12).mapToObj(month -> YearMonth.of(year, month));
    }
}
