public class Table {

    public Table ( int size ) {
        assert(size > 1);
        this.size = size;
        this.queue = new WaitingQueue();
        seats = new Seat[size];
        chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            seats[i] = new Seat();
            chopsticks[i] = new Chopstick();
        }
    }

    private synchronized int findAndOccupyEmptySeat( ) {
        for (int i = 0; i < size; i++) {
            if (!seats[i].isOccupied()) {
                seats[i].occupy();
                return i;
            }
        }
        return -1;
    }

    public int takeASeat () throws InterruptedException {
        int seat = findAndOccupyEmptySeat();
        while (seat == -1) {
            queue.enqueue();
            seat = findAndOccupyEmptySeat();
        }
        chopsticks[seat].take();
        Thread.sleep(100); // to make deadlock more likely
        chopsticks[(seat + 1) % size].take();
        return seat;
    }

    public void leaveSeat ( int s ) throws InterruptedException {
        assert(seats[s].isOccupied());
        chopsticks[s].release();
        Thread.sleep(100); // to make deadlock more likely
        chopsticks[(s + 1) % size].release();
        seats[s].release();
        queue.dequeue();
    }

    private final int size;
    private final WaitingQueue queue;
    private final Seat[] seats;
    private final Chopstick[] chopsticks;
}
