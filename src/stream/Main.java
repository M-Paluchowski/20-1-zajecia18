package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.println(number));
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
        System.out.println(strings);

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

        System.out.println("----------------------------------------");
        List<Integer> integers2 = List.of(1, 2, 3, 4, 5);
        integers2.stream()
                .map(new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer integer) {
                        return integer * 2;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
        System.out.println(integers2);
        System.out.println("----------------------------------------");
        Set<String> names = Set.of("Ania", "Marcin", "Jarek");
        names.stream()
                .map(new Function<String, Human>() {
                    @Override
                    public Human apply(String name) {
                        return new Human(name);
                    }
                })
                .forEach(new Consumer<Human>() {
                    @Override
                    public void accept(Human human) {
                        System.out.println(human);
                    }
                });

        System.out.println("----------------------------------------");
        Set<String> names2 = Set.of("Ania", "Marcin", "Jarek");
        List<Human> collect = names2.stream()
                .map(new Function<String, Human>() {
                    @Override
                    public Human apply(String name) {
                        return new Human(name);
                    }
                })
                .collect(Collectors.toList());
//        Collectors.toSet()
        System.out.println(collect);

        System.out.println("----------------------------------------");
        Set<String> names3 = Set.of("Ania", "Marcin", "Jarek", "Iza");
        boolean exists = names3.stream()
                .anyMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("a");
                    }
                });
        System.out.println(exists);

        boolean exists2 = names3.stream()
                .anyMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("z");
                    }
                });
        System.out.println(exists2);

        System.out.println("----------------------------------------");
        Set<String> names4 = Set.of("Ania", "Iza");
        boolean exists3 = names4.stream()
                .allMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("a");
                    }
                });

        System.out.println(exists3);

        boolean exists4 = names4.stream()
                .allMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith("I");
                    }
                });
        System.out.println(exists4);

        System.out.println("----------------------------------------");
        Set<String> names5 = Set.of("Ania", "Iza");
        boolean z = names5.stream()
                .noneMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("z");
                    }
                });
        System.out.println(z);

        System.out.println("----------------------------------------");
        Set<String> names6 = Set.of("Ania", "Iza");
        long count = names6.stream()
                .count();
        System.out.println(count);

        System.out.println("----------------------------------------");
        Set<String> names7 = Set.of("Ania", "Iza");

        Predicate<String> predicate = name -> name.startsWith("Z");

        Predicate<String> predicate2 = new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.startsWith("Z");
            }
        };

        Optional<String> optional1 = names7.stream()
                .filter(predicate)
                .findAny();
        System.out.println(optional1.isEmpty());

        System.out.println("----------------------------------------");
        Set<String> names8 = Set.of("Ania", "Iza", "Zuza");
        Optional<String> optional2 = names8.stream()
                .filter(name -> {
                    String letter = "Z";
                    return name.startsWith(letter);
                })
                .findFirst();
        System.out.println(optional2.isEmpty());
        System.out.println(optional2.isPresent());

        System.out.println("----------------------------------------");
        List<String> names9 = List.of("Ania", "Iza", "Zuza");
        names9.stream()
                .skip(2)
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        System.out.println("----------------------------------------");
        List<String> names10 = List.of("Zuza", "Iza", "Ania");
        List<String> collect1 = names10.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("----------------------------------------");
        List<String> names11 = List.of("Zuza", "Iza", "Ania");
        List<Human> collect2 = names11.stream()
                .map(name -> new Human(name))
                .sorted((humanOne, humanTwo) -> humanOne.getName().compareTo(humanTwo.getName()))
                .collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("----------------------------------------");
        OptionalDouble average = IntStream.of(1, 2, 3, 4, 5, 6)
//                .min()
//                .max()
                .average();
        System.out.println(average.getAsDouble());

        System.out.println("----------------------------------------");
        List<Human> humans = List.of(new Human("Ania", List.of("Wrocław", "Kraków")), new Human("Iza", List.of("Warszawa")));
        humans.stream()
//                .map(new Function<Human, List<String>>() {
//                    @Override
//                    public List<String> apply(Human human) {
//                        return human.getAddresses();
//                    }
//                })
//                .forEach(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> strings) {
//                        System.out.println(strings);
//                    }
//                });
                .flatMap(new Function<Human, Stream<String>>() {
                    @Override
                    public Stream<String> apply(Human human) {
                        return human.getAddresses().stream();
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        System.out.println("----------------------------------------");
        List<Integer> integers3 = List.of(1, 2, 3, 4, 5, 6, 7, 9, 10);
        Integer reduce = integers3.stream()
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                });
        System.out.println(reduce);

        System.out.println("----------------------------------------");
        List<String> a = List.of("a", "b", "c", "d");
        String reduce1 = a.stream()
                .reduce("", new BinaryOperator<String>() {
                    @Override
                    public String apply(String s, String s2) {
                        return s + s2;
                    }
                });
        System.out.println(reduce1);

        System.out.println("----------------------------------------");
        List<String> names12 = List.of("Zuza", "Iza", "Ania");
        List<Human> collect3 = names12.stream()
                .map(Human::new)
                .sorted((humanOne, humanTwo) -> humanOne.getName().compareTo(humanTwo.getName()))
                .collect(Collectors.toList());
        System.out.println(collect2);


    }

    static class Human {
        private String name;
        private String surname;
        private List<String> addresses;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, List<String> addresses) {
            this.name = name;
            this.addresses = addresses;
        }

        public String getName() {
            return name;
        }

        public List<String> getAddresses() {
            return addresses;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
}
