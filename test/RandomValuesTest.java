import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomValuesTest {

    @Test
    void get() {
        RandomValues randomValues = new RandomValues(0, 1, RandomValues.getUniformDistribution());
        final int N = 10000;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            double v = randomValues.get();
            sum += v;
            assertTrue(v >= 0 && v <= 1);
        }
        sum /= N;
        assertTrue(sum >= 0.4 && sum <= 0.6);
    }
}