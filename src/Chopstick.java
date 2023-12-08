import java.util.concurrent.Semaphore;

public class Chopstick {

    public Chopstick ( ) {
    }

    public void take ( ) throws InterruptedException {
        try {
            stick.acquire();
        } catch (InterruptedException e) {
            throw e;
        }
    }

    public void release ( ) {
        stick.release();
    }

    private Semaphore stick = new Semaphore(1);
}
