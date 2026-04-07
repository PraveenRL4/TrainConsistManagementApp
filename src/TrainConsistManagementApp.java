import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        String getName() {
            return name;
        }

        int getCapacity() {
            return capacity;
        }
    }

    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
    }

    public static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }

        int totalSeats = countTotalSeats(bogies);
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("\nUC10 aggregation completed ...");
    }
}
