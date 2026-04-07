import java.util.Arrays;

public class TrainConsistManagementApp {

    public static boolean binarySearch(String[] bogieIds, String key) {
        Arrays.sort(bogieIds); // ensure sorted before searching
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC19 - Binary Search for Bogie ID");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String key = "BG309";

        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " not found using Binary Search.");
        }

        System.out.println("\nUC19 search completed ...");
    }
}
