package ProducerConsumerApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConsumerTest {

    @Test
    public void testConsumer() throws Exception {
        MessageQueue queue = new MessageQueue(10);
        Statistics statistics = new Statistics();
        Consumer consumer = new Consumer(queue, statistics);
        Thread consumerThread = new Thread(consumer);

        for (int i = 0; i < 100; i++) {
            queue.produce("Message " + i);
        }

        consumerThread.start();
        Thread.sleep(2000);

        assertEquals(100, statistics.getSuccessCount());
    }

    @Test
    public void testConsumerInterruption() throws Exception {
        MessageQueue queue = new MessageQueue(10);
        Statistics statistics = new Statistics();
        Consumer consumer = new Consumer(queue, statistics);
        Thread consumerThread = new Thread(consumer);

        consumerThread.start();
        consumerThread.interrupt();
        consumerThread.join();

        assertEquals(1, statistics.getErrorCount());
    }
}

