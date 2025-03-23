/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.queue;


public class QueueImpl {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.displayQueue();
        System.out.println();
        System.out.println(queue.dequeue());
        queue.displayQueue();
    }
}
