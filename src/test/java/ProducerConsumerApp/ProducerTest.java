package ProducerConsumerApp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProducerTest {

    @Test
    public void testProducer() throws InterruptedException {
        MessageQueue queue = new MessageQueue(10);
        Producer producer = new Producer(queue);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        producerThread.join();

        for (int i = 0; i < 100; i++) {
            assertEquals("Message " + i, queue.consume());
        }
    }
}
