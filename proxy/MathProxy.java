package proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Double, Double> absDouble = Math::abs;
    public static Function<Float, Float> absFloat = Math::abs;
    public static Function<Long, Long> absLong = Math::abs;

    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;
    public static BiFunction<Float, Float, Float> maxFloat = Math::max;
    public static BiFunction<Long, Long, Long> maxLong = Math::max;

    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static BiFunction<Double, Double, Double> minDouble = Math::min;
    public static BiFunction<Float, Float, Float> minFloat = Math::min;
    public static BiFunction<Long, Long, Long> minLong = Math::min;

    public static BiFunction<Integer, Integer, Integer> randomInt = (a, b) -> (int) (Math.random() * (b - a) + a);
    public static BiFunction<Double, Double, Double> randomDouble = (a, b) -> Math.random() * (b - a) + a;
    public static BiFunction<Float, Float, Float> randomFloat = (a, b) -> (float) (Math.random() * (b - a) + a);
    public static BiFunction<Long, Long, Long> randomLong = (a, b) -> (long) (Math.random() * (b - a)) + a;

    public static Function<Double, Double> ceilDouble = Math::ceil;
    public static Function<Float, Float> ceilFloat = a -> (float) Math.ceil(a);

    public static Function<Double, Double> floorDouble = Math::floor;
//    public static Function<Double, Double> roundDouble = () Math::round;
//
//    public static Supplier<Double>
}
