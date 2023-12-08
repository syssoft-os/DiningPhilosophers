import java.util.concurrent.Semaphore;

public class WaitingQueue {

    public WaitingQueue ( ) {
    }

    public void enqueue ( ) throws InterruptedException {
        try {
            System.out.format("Philosopher %s is waiting for a free seat\n", Thread.currentThread().getName());
            q.acquire();
            System.out.format("Philosopher %s has left the queue\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw e;
        }
    }

    public void dequeue ( ) {
        q.release();
    }

    private Semaphore q = new Semaphore(0);
}
