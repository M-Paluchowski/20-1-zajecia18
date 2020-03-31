package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Integer> empty = Optional.empty();
        Optional<Integer> optionalInteger = Optional.of(123);
//        Optional<Integer> a = Optional.of(null);

        Optional<Integer> optionalOfNullableInteger = Optional.ofNullable(123);
//        Optional<Integer> a = Optional.ofNullable(null);

        System.out.println(empty.isPresent());
        System.out.println(optionalInteger.isPresent());

        Integer get = optionalInteger.get();
        System.out.println(get);

//        empty.get();

        System.out.println("------------------------------------------");
        Integer emptyOrElse = empty.orElse(666);
        Integer existsOrElse = optionalInteger.orElse(666);

        System.out.println(emptyOrElse);
        System.out.println(existsOrElse);
        System.out.println("------------------------------------------");

        Calculator calculator = new Calculator();
        Optional<Double> add = calculator.add(0.1, 0.2);
        Double aDouble = add.orElse(0.0);
        System.out.println(aDouble.toString());
    }
}
