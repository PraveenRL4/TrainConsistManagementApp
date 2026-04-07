import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        TrainConsistManagementApp.sortBogieNames(bogieNames);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, bogieNames);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        TrainConsistManagementApp.sortBogieNames(bogieNames);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, bogieNames);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        TrainConsistManagementApp.sortBogieNames(bogieNames);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, bogieNames);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        TrainConsistManagementApp.sortBogieNames(bogieNames);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, bogieNames);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};
        TrainConsistManagementApp.sortBogieNames(bogieNames);
        assertArrayEquals(new String[]{"Sleeper"}, bogieNames);
    }
}
