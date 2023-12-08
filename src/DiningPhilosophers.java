public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 3) {
            System.out.println("Usage: java DiningPhilosophers <nPhilosophers> <nSeats> <nSeconds>");
            return;
        }
        int nPhilosophers = Integer.parseInt(args[0]);
        int nSeats = Integer.parseInt(args[1]);
        int nSeconds = Integer.parseInt(args[2]);
        System.out.format("Dining philosophers problem with %d philosophers and %d seats\n", nPhilosophers, nSeats);
        System.out.format("Simulation will run for %d seconds\n", nSeconds);

        Table table = new Table(nSeats);
        Philosopher[] philosophers = new Philosopher[nPhilosophers];
        for (int i = 0; i < nPhilosophers; i++) {
            philosophers[i] = new Philosopher(table);
        }

        long startTime = System.currentTimeMillis();
        long loopTime = System.currentTimeMillis();
        int minimalNumberOfMeals_lastRound = Integer.MAX_VALUE;
        while (loopTime - startTime < (long) nSeconds * 1000) {
            Thread.sleep(1000);
            loopTime = System.currentTimeMillis();
            int minimalNumberOfMeals = Integer.MAX_VALUE;
            int maximalNumberOfMeals = Integer.MIN_VALUE;
            for (Philosopher p : philosophers) {
                if (p.getNumberOfMeals() < minimalNumberOfMeals) {
                    minimalNumberOfMeals = p.getNumberOfMeals();
                }
                if (p.getNumberOfMeals() > maximalNumberOfMeals) {
                    maximalNumberOfMeals = p.getNumberOfMeals();
                }
            }
            System.out.format("%10.2f: Between %d and %d meals eaten so far.",
                    (loopTime - startTime) / 1000.0, minimalNumberOfMeals, maximalNumberOfMeals);
            if (minimalNumberOfMeals != minimalNumberOfMeals_lastRound) {
                minimalNumberOfMeals_lastRound = minimalNumberOfMeals;
                System.out.println();
            } else {
                System.out.println(" All dead?");
            }
        }

        System.out.println("Time to stop the simulation");
        for ( Philosopher p : philosophers ) {
            p.getThread().interrupt();
            p.join();
        }
    }
}