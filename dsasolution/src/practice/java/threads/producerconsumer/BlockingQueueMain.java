package practice.java.threads.producerconsumer;

public class BlockingQueueMain {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(100);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                blockingQueue.push(String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Produced: " + i);
            }
        }, "producer");

        Thread cosnumer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String value = blockingQueue.pop();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Consumed: " + value);
            }
        }, "consumer");

        producer.start();
        cosnumer.start();
    }

}
