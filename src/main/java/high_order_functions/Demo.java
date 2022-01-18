package high_order_functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsNotZeroCheck =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: second argument is zero");
                        return 0f;
                    }
                    return func.apply(x, y);
                };


        BiFunction<Float, Float, Float> safeDivide = secondArgIsNotZeroCheck.apply(divide);

        System.out.println(safeDivide.apply(10f, 5f));
    }
}
