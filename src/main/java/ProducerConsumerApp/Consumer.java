package ProducerConsumerApp;
//A consumer that processes messages from a MessageQueue and tracks statistics.
public class Consumer implements Runnable {
    private final MessageQueue queue;
    private final Statistics statistics;

    public Consumer(MessageQueue queue, Statistics statistics) {
        this.queue = queue;
        this.statistics = statistics;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = queue.consume();
                System.out.println("Consumed: " + message);
                statistics.incrementSuccessCount();
                Thread.sleep(100); // Simulate time to process a message
            }
        } catch (InterruptedException e) {
            statistics.incrementErrorCount();
            Thread.currentThread().interrupt();
        }
    }
}
