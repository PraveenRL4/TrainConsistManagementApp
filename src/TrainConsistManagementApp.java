import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        String getType() {
            return type;
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
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getType));
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

    public static List<Bogie> filterBogiesLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterBogiesStream(List<Bogie> bogies, int threshold) {
        return bogies.stream().filter(b -> b.getCapacity() > threshold).collect(Collectors.toList());
    }

    public static long measureLoopTime(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterBogiesLoop(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureStreamTime(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterBogiesStream(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 30)));
        }

        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");

        long loopTime = measureLoopTime(bogies, 60);
        long streamTime = measureStreamTime(bogies, 60);

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        System.out.println("\nUC13 performance benchmarking completed ...");
    }
}
