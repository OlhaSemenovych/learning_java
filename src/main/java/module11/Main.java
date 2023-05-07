package module11;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack[0]", "Harry[1]", "John[2]",
                "Bill[3]", "Dave[4]", "Alex[5]", "Sam[6]", "Nemo[7]");
        Names<String> namesClass = new Names<>();

        log.info("----- List of names with odd index -----");
        System.out.println(namesClass.getAllNamesWithOddIndex(names));

        log.info("----- List of sorted names in Upper Case sorted Z-A -----");
        System.out.println(namesClass.sortDescNamesInUpperCase(names));


        log.info("----- List of numbers sort by ASC -----");
        List<String> numbers = Arrays.asList("1, 2, 0", "7, 6", "4, 5");
        System.out.println(Numbers.sortNumbersAsc(numbers).collect(Collectors.joining(", ")));


        log.info("----- Linear Congruential Generator -----");
        LCGenerator lcg = new LCGenerator(25214903917L, 11, 2 ^ 48, 99L);

        Stream<Long> longStream = Stream.iterate(99L, (seed) -> lcg.random(seed).nextRandom());

        List<Long> collect = longStream.limit(5)
                .collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("----- Merge two streams -----");
        Stream<String> first = Stream.of("Lorem", "Ipsum", "Dolor", "Ipsum", "Amet");
        Stream<String> second = Stream.of("1", "2", "3");

        System.out.println(MergeStreams.zip(first, second)
                .collect(Collectors.joining(", ")));
    }

}
