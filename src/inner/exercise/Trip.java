package inner.exercise;

import java.util.Comparator;

public class Trip {

    private String name;
    private String destination;
    private double price;

    public Trip(String name, String destination, double price) {
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    class NameComparator implements Comparator<Trip> {

        @Override
        public int compare(Trip tripOne, Trip tripTwo) {
            return tripOne.name.compareTo(tripTwo.name);
        }
    }

    static class PriceComparator implements Comparator<Trip> {

        @Override
        public int compare(Trip tripOne, Trip tripTwo) {

            return Double.compare(tripOne.getPrice(), tripTwo.getPrice());
        }
    }
}
