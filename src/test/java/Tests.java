import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    void singleAssertion() {
        System.out.println("This test method should be run");
        assertEquals(2, 1 + 1);
    }
}
