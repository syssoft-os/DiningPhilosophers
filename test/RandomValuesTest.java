import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomValuesTest {

    @Test
    void testUniformDistribution() {
        RandomValues randomValues = new RandomValues(0, 1, RandomValues.getUniformDistribution());
        final int N = 10000;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            double v = randomValues.getDouble();
            sum += v;
            assertTrue(v >= 0 && v <= 1);
        }
        sum /= N;
        assertTrue(sum >= 0.4 && sum <= 0.6);
    }

    @Test
    void testNormalDistribution() {
        RandomValues randomValues = new RandomValues(0, 1, RandomValues.getNormalDistribution(0.5, 0.1));
        final int N = 10000;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            double v = randomValues.getDouble();
            sum += v;
            assertTrue(v >= 0 && v <= 1);
        }
        sum /= N;
        assertTrue(sum >= 0.4 && sum <= 0.6);
    }
}