import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie b = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie b = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie b = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie b1 = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");
        TrainConsistManagementApp.GoodsBogie b2 = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");
        assertEquals("Petroleum", b1.getCargo());
        assertNull(b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistManagementApp.GoodsBogie b = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }
}
