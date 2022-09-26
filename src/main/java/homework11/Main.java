package homework11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] names = {"John", "Bill", "David", "Kate", "Lisa", "Zara"};

        // Get array elements with odd index
        IntStream.range(0, names.length)
                .filter(i -> i % 2 == 1)
                .forEach(i -> System.out.println(i + ". " + names[i]));

        System.out.println("---------------------");

        // Get strings in upper case and sort in descending order
        Arrays.stream(names)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("---------------------");

        // Sort strings of integers
        List<String> stringArr = Arrays.asList("1, 2, 0", "4, 5");

        String res = stringArr.stream()
                .map(s -> s.replaceAll("[^-0-9]+", " ").trim().split(" "))
                .flatMap(Stream::of)
                .map(Integer::parseInt)
                .sorted()
                .map(s -> Integer.toString(s))
                .collect(Collectors.joining(", "));
        System.out.println(res);

        System.out.println("---------------------");

        // Infinite stream of random numbers
        long seed = new Random().nextLong(1000)+25;
        long a = 25_214_903_917L;
        int c = 11;
        long m = (long)Math.pow(2, 48);

        Stream.iterate(new long[]{seed}, n -> new long[]{(a*n[0] + c)%m})
                .limit(20)
                .map(n -> n[0])
                .forEach(System.out::println);

        System.out.println("---------------------");

        // Mix elements of two streams

        Stream<String> first = Stream.of("1", "2", "3", "4", "5");
        Stream<String> second = Stream.of("Mathew", "Kate", "John");

        zip(first, second).forEach(System.out::println);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        Iterator<T> iterator = second.iterator();

        return first.filter(x -> iterator.hasNext())
                .flatMap((x -> Stream.of(x, iterator.next())));

    }
}
