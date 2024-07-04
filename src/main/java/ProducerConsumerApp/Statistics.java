package ProducerConsumerApp;
//Tracks the number of successfully processed messages and the number of errors encountered.
public class Statistics {
    private int successCount = 0;
    private int errorCount = 0;

    public synchronized void incrementSuccessCount() {
        successCount++;
    }

    public synchronized void incrementErrorCount() {
        errorCount++;
    }

    public synchronized int getSuccessCount() {
        return successCount;
    }

    public synchronized int getErrorCount() {
        return errorCount;
    }
}
