import java.util.function.Supplier;

public class RandomValues {

    public RandomValues ( double min_value, double max_value, Supplier<Double> distributionFunction ) {
        this.min_value = min_value;
        this.max_value = max_value;
        this.distributionFunction = distributionFunction;
    }

    public double get() {
        double v = distributionFunction.get();
        if (v < 0 || v > 1) {
            System.err.println("Distribution function must return a value between 0 and 1");
            System.exit(-1);
        }
        return min_value + Math.random() * (max_value - min_value);
    }

    public static Supplier<Double> getUniformDistribution() {
        return () -> Math.random();
    }

    private double min_value;
    private double max_value;
    private Supplier<Double> distributionFunction;
}
