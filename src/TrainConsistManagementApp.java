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

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        String getType() {
            return type;
        }

        String getCargo() {
            return cargo;
        }
    }

    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
    }

    public static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
    }

    public static boolean checkSafetyCompliance(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream().allMatch(b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true;
        });
    }

    public static void main(String[] args) {
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g.getType() + " -> " + g.getCargo());
        }

        boolean safe = checkSafetyCompliance(goodsBogies);
        System.out.println("\nSafety Compliance Status: " + safe);
        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println("\nUC12 safety validation completed ...");
    }
}
