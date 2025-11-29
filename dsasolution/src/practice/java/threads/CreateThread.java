package practice.java.threads;

public class CreateThread {

    public static void main(String[] args) {

        CustomThread customThread = new CustomThread();
        customThread.start();

        MyCustomThread myCustomThread = new MyCustomThread();
        Thread t1 = new Thread(myCustomThread);
        t1.start();

        for(int i = 0; i < 10; i++) {
            System.out.println("Executing main thread " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
