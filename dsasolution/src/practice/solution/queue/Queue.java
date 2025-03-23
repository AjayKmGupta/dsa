/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.queue;

class Queue {
    private Object[] data;
    private int index;
    private int capacity;

    public Queue() {
        this.capacity = 10;
        this.data = new Object[this.capacity];
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.data = new Object[this.capacity];
    }

    private boolean isFull() {
        return this.index == this.capacity - 1;
    }

    private boolean isEmpty() {
        return this.index == 0;
    }

    public void enqueue(Object obj) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }
        this.data[this.index] = obj;
        ++this.index;
    }

    public void displayQueue() {
        int i = 0;
        while (i < this.index) {
            System.out.print(String.valueOf(this.data[i]) + " ");
            ++i;
        }
    }

    public Object dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Object obj = this.data[0];
        int i = 0;
        while (i < this.index - 1) {
            this.data[i] = this.data[i + 1];
            ++i;
        }
        --this.index;
        return obj;
    }
}
