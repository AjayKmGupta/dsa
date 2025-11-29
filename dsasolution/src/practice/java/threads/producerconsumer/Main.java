package practice.java.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> shared = new LinkedList<>();
        int maxSize = 5;

        Runnable producer = (() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (shared) {
                    while (shared.size() == maxSize) {
                        try {
                            System.out.println("Buffer is full, hence waiting");
                            shared.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    shared.add(i);
                    System.out.println("Produced: " + i);
                    shared.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Runnable consumer = (() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (shared) {
                    while (shared.isEmpty()) {
                        System.out.println("Waiting for the message to be produced, as buffer empty");
                        try {
                            shared.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Integer val = shared.remove();
                    System.out.println("Consumed: " + val);
                    shared.notifyAll();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}