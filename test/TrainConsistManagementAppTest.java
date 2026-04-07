import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24),
                new TrainConsistManagementApp.Bogie("Sleeper", 70),
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(3, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2, grouped.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1, grouped.size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(grouped.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        List<TrainConsistManagementApp.Bogie> originalCopy = new ArrayList<>(bogies);
        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(originalCopy.size(), bogies.size());
        assertEquals(originalCopy.get(0).getName(), bogies.get(0).getName());
    }
}
