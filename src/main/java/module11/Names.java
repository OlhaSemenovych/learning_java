package module11;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {

    public static void getAllNamesWithOddIndex(List<String> names) {
        AtomicInteger i = new AtomicInteger(1);

        IntStream.range(0, names.size())
                .filter(n -> n % 2 > 0)
                .mapToObj(name -> i.getAndIncrement() + ". " + names.get(name))
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    public static void sortDescNamesInUpperCase(List<String> names) {
        names.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .peek(System.out::println)
                .collect(Collectors.toList());

    }


}
