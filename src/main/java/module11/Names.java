package module11;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names<T> {

    public List<String> getAllNamesWithOddIndex(List<T> names) {
        AtomicInteger i = new AtomicInteger(1);

        return IntStream.range(0, names.size())
                .filter(n -> n % 2 > 0)
                .mapToObj(name -> i.getAndIncrement() + ". " + names.get(name))
                .collect(Collectors.toList());

    }

    public List<String> sortDescNamesInUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

    }


}
