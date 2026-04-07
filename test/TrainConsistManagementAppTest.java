import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchBogie(bogieIds, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.searchBogie(bogieIds, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistManagementApp.searchBogie(bogieIds, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(TrainConsistManagementApp.searchBogie(bogieIds, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchBogie(bogieIds, "BG101"));
    }
}
