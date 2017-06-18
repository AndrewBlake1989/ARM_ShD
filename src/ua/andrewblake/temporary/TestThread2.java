package ua.andrewblake.temporary;

/**
 * Created by AndrewBlake on 30.05.2017.
 */
public class TestThread2 extends Thread {

    public TestThread2() {
        super();
    }

    public void run() {
        System.out.println("x-1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("y-2");
    }
}
