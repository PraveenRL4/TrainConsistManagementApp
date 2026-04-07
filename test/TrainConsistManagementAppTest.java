import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {
    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );
        int total = TrainConsistManagementApp.countTotalSeats(bogies);
        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );
        int total = TrainConsistManagementApp.countTotalSeats(bogies);
        assertEquals(128, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );
        int total = TrainConsistManagementApp.countTotalSeats(bogies);
        assertEquals(24, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        int total = TrainConsistManagementApp.countTotalSeats(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        TrainConsistManagementApp.Bogie b = new TrainConsistManagementApp.Bogie("Sleeper", 72);
        assertEquals(72, b.getCapacity());
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );
        int total = TrainConsistManagementApp.countTotalSeats(bogies);
        assertEquals(152, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        List<TrainConsistManagementApp.Bogie> originalCopy = new ArrayList<>(bogies);
        TrainConsistManagementApp.countTotalSeats(bogies);

        assertEquals(originalCopy.size(), bogies.size());
        assertEquals(originalCopy.get(0).getName(), bogies.get(0).getName());
    }
}
