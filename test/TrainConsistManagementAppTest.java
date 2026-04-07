import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilterBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }
}