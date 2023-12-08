public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        int nPhilosophers = Integer.parseInt(args[0]);
        int nSeats = Integer.parseInt(args[1]);
        System.out.format("Dining philosophers problem with %d philosophers and %d seats\n", nPhilosophers, nSeats);

        Table table = new Table(nSeats);
        Philosopher[] philosophers = new Philosopher[nPhilosophers];
        for (int i = 0; i < nPhilosophers; i++) {
            philosophers[i] = new Philosopher(table);
        }
        Thread.sleep(5000);
        System.out.println("Time to stop the simulation");
        for ( Philosopher p : philosophers ) {
            p.getThread().interrupt();
            p.join();
        }
    }
}