public class Philosopher implements Runnable {

    public Philosopher( Table table ) {
        this.table = table;
        this.rThink = new RandomValues(100, 200, RandomValues.getUniformDistribution());
        this.rEat = new RandomValues(500, 2000, RandomValues.getUniformDistribution());
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                long timeThinking = rThink.getLong();
                System.out.format("Philosopher %s is thinking for %d ms\n", thread.getName(), timeThinking);
                Thread.sleep(timeThinking);
                int s = table.takeASeat();
                long timeEating = rEat.getLong();
                System.out.format("Philosopher %s is eating for %d ms\n", thread.getName(), timeEating);
                Thread.sleep(timeEating);
                table.leaveSeat(s);
            }
            catch (InterruptedException e) {
                return;
            }
        }
    }

    public Thread getThread() {
        return thread;
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            return;
        }
    }

    private final Thread thread;
    private final RandomValues rThink;
    private final RandomValues rEat;
    private final Table table;
}
