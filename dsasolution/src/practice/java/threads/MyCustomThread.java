package practice.java.threads;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyCustomThread implements Runnable {

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10)
                .peek(i -> {
                    try {
                        Thread.sleep(1000);   // 1 second delay
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(i -> System.out.println("Executing in my custom thread " + i));
    }
}
