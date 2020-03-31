package optional;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Calculator {
    public Optional<Double> add(double one, double two) {
//        ThreadLocalRandom.current().nextInt(10, 20);
        Random random = new Random();
        return random.nextInt(11) % 2 == 0 ? Optional.ofNullable(null) : Optional.of(one + two);
    }
}
