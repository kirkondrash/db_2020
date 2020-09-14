package java_8_examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YestMain {

    public static void main(String[] args) {
        String fileName = "data/yest.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            Map<String, Long> wordFreq = stream
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(String.format("Total word count: %d", wordFreq.values().stream().mapToLong(Long::longValue).sum()));
            System.out.println(String.format("Most frequent word: %s counts", wordFreq.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(Map.entry("no words in the text!",0l)).toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
