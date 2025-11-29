package practice.java.threads.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class UsingInBuiltBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(100);

        Thread producer = new Thread(() ->  {
            for (int i = 0; i < 1000; i++) {
                try {
                    buffer.put(i);
                    Thread.sleep((int) ( 1000 * Math.random()));
                    System.out.println("Produced " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }, "Producer");

        Thread consumer = new Thread(() ->  {
            for (int i = 0; i < 1000; i++) {
                try {
                    Integer value = buffer.take();
                    Thread.sleep((int) ( 2000 * Math.random()));
                    System.out.println("Consumed " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();

    }

}
