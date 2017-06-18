package ua.andrewblake.temporary;

/**
 * Created by AndrewBlake on 30.05.2017.
 */
public class TestThread implements Runnable {

    Thread thread;

    public TestThread() {
        thread = new Thread(this, "abc");
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("ok-1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok-2");
    }
}
