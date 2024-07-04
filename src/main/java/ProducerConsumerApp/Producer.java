package ProducerConsumerApp;
//A producer that generates messages and adds them to a MessageQueue.
public class Producer implements Runnable {
    private final MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                String message = "Message " + i;
                queue.produce(message);
                System.out.println("Produced: " + message);
                Thread.sleep(50); //time taken to produce message
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
