package ProducerConsumerApp;

public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(10);
        Statistics statistics = new Statistics();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue, statistics);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            Thread.sleep(5000); // Allow consumer to finish processing remaining messages
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Total messages processed successfully: " + statistics.getSuccessCount());
        System.out.println("Total errors encountered: " + statistics.getErrorCount());
    }
}
