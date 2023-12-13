# The Dining Philosopher Problem

A Java implementation to the classical synchronization problem.
Different solutions to avoid any deadlocks are implemented. These
implementations are tagged with the prefix `v<i>`, where `<i>` is
the sequence of solutions to be discussed in a lecture.

The solutions are:

- v1: Naive solution with no deadlock avoidance at all. The two chopsticks are taken immediately. one after the other, so depending on the situation, it may take some time for the first deadlock.
- v2: There is a delay of 100ms between the two chopsticks. This solution provoces a deadlock, so normally, you won't have to wait very long for the deadlock. This version will serve as a base for any problem solution.
- v3: Taking the left AND the right chopstick in an atomic operation.
- v4: Breaking the symmetry by taking the chopsticks in a different order.
- v5: Limiting the number of philosophers that can eat to n-1 if n is the size of the table.

The main thread will ask all philosophers every second for the number of meals they had in the past, assuming that an increase in the minimum number of meals is an indicator for a living system.
After a specified number of seconds, the main thread will try to interrupt all philosopher threads and will then wait for their termination.
