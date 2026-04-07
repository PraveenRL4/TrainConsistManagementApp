import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistManagementApp.binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearch(bogieIds, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        assertFalse(TrainConsistManagementApp.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(TrainConsistManagementApp.binarySearch(bogieIds, "BG205"));
    }
}
