import java.util.concurrent.Semaphore;

public class WaitingQueue {

    public WaitingQueue ( ) {
    }

    public void enqueue ( ) throws InterruptedException {
        try {
            q.acquire();
        } catch (InterruptedException e) {
            throw e;
        }
    }

    public void dequeue ( ) {
        q.release();
    }

    private Semaphore q = new Semaphore(0);
}
