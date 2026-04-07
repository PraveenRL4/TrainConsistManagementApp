public class TrainConsistManagementApp {

    public static boolean searchBogie(String[] bogieIds, String searchId) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC20 - Exception Handling During Search");

        String[] bogieIds = {}; // empty train scenario
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            if (found) {
                System.out.println("Bogie " + searchId + " found in train consist.");
            } else {
                System.out.println("Bogie " + searchId + " not found in train consist.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed ...");
    }
}
