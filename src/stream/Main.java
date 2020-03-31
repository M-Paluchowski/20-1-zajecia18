package stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> streamFromOf = Stream.of(1, 2, 3, 4, 5);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> streamFromCollection = integers.stream();

//        Stream.empty();

        Stream<Integer> concat = Stream.concat(streamFromOf, streamFromCollection);

        System.out.println("----------------------------------------");
        List<Integer> integersTwo = List.of(1, 2, 3, 4, 5, 6);

        integersTwo.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
        System.out.println("----------------------------------------");

        List<String> strings = List.of("abc", "bca", "yaw");
        strings.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("a");
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        System.out.println("----------------------------------------");
        List<Integer> integers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integers1.stream()
                .limit(5)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }
}
