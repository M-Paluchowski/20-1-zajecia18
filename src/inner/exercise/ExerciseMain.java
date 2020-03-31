package inner.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExerciseMain {
    public static void main(String[] args) {
        List<Trip> trips = new ArrayList<>(Arrays.asList(new Trip("Super wycieczka", "Węgry", 100.0),
                new Trip("Ale super wycieczka", "Anglia", 200.0),
                new Trip("Zarąbista wycieczka", "Polska", 1.0)));

        trips.sort(new Comparator<Trip>() {
            @Override
            public int compare(Trip tripOne, Trip tripTwo) {
                return tripOne.getDestination().compareTo(tripTwo.getDestination());
            }
        });
        System.out.println(trips);

        trips.sort(new Trip("a", "a", 0.0). new NameComparator());
        System.out.println(trips);

        trips.sort(new Trip.PriceComparator());
        System.out.println(trips);
    }
}
