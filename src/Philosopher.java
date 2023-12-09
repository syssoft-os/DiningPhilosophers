public class Philosopher implements Runnable {

    public Philosopher( Table table, boolean beSilent ) {
        this.table = table;
        this.beSilent = beSilent;
        this.rThink = new RandomValues(20, 100, RandomValues.getUniformDistribution());
        this.rEat = new RandomValues(10, 30, RandomValues.getNormalDistribution(0.5,0.1 ));
        thread = new Thread(this);
        thread.start();
    }

    public Philosopher( Table table ) {
        this(table, true);
    }
    @Override
    public void run() {
        while (true) {
            try {
                long timeThinking = rThink.getLong();
                if (!beSilent)
                    System.out.format("Philosopher %s is thinking for %d ms\n", getName(), timeThinking);
                Thread.sleep(timeThinking);
                int s = table.takeASeat();
                long timeEating = rEat.getLong();
                nMeals++;
                if (!beSilent)
                    System.out.format("Philosopher %s is eating for %d ms\n", getName(), timeEating);
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

    public int getNumberOfMeals () {
        return nMeals;
    }

    public String getName () {
        return thread.getName();
    }

    private final Thread thread;
    private final RandomValues rThink;
    private final RandomValues rEat;
    private final Table table;
    private int nMeals = 0;
    private final boolean beSilent;
}
