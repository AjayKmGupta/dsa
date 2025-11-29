package practice.java.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    Queue<String> queue = new LinkedList<>();
    int queueLength;
    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    public BlockingQueue(int queueLength) {

        this.queueLength = queueLength;
    }


    public void push(String value) {

        lock.lock();
        try {
            while (queue.size() == queueLength) {
                full.await();
            }
            queue.add(value);
            empty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public String pop() {
        lock.lock();
        String value = null;
        try {
            while (queue.isEmpty()) {
                empty.await();
            }
            value = queue.remove();
            full.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return value;
    }

}
