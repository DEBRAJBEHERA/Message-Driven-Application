package ProducerConsumerApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    @Test
    public void testIncrementSuccessCount() {
        Statistics statistics = new Statistics();
        statistics.incrementSuccessCount();
        assertEquals(1, statistics.getSuccessCount());
    }

    @Test
    public void testIncrementErrorCount() {
        Statistics statistics = new Statistics();
        statistics.incrementErrorCount();
        assertEquals(1, statistics.getErrorCount());
    }
}
