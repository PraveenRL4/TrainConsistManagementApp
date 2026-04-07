import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesLoop(bogies, 60);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getType());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesStream(bogies, 60);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getType());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 65)
        );
        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterBogiesLoop(bogies, 60);
        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterBogiesStream(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 50 + (i % 30)));
        }
        long loopTime = TrainConsistManagementApp.measureLoopTime(bogies, 60);
        long streamTime = TrainConsistManagementApp.measureStreamTime(bogies, 60);
        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 50 + (i % 30)));
        }
        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterBogiesLoop(bogies, 60);
        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterBogiesStream(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size());
    }
}
