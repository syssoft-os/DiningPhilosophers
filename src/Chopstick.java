import java.util.concurrent.Semaphore;

public class Chopstick {

    public Chopstick ( ) {
    }

    public void take ( ) throws InterruptedException {
        stick.acquire();
    }

    public void release ( ) {
        stick.release();
    }

    private final Semaphore stick = new Semaphore(1);
}
