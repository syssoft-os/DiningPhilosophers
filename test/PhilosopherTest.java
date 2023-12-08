import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhilosopherTest {

    @Test
    void liveAndLetDie() {
        Table t = new Table(2);
        Philosopher p = new Philosopher(t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.getThread().interrupt();
        p.join();
    }
}