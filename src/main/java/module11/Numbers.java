package module11;

import java.util.*;
import java.util.stream.Stream;

public class Numbers {


    public static Stream<String> sortNumbersAsc(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt((value) -> {
                    String[] split = value.split(", ");
                    return Arrays.asList(split)
                            .stream()
                            .mapToInt(Integer::parseInt);
                })
                .sorted()
                .mapToObj(String::valueOf);
    }

}
