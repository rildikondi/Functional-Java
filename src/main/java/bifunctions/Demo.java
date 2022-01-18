package bifunctions;

import java.util.function.BiFunction;

public class Demo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(32, 32));

        TriFunction<Integer, Integer, Integer, Integer> sub = (x, y, z) -> x - y - z;
        System.out.println(sub.apply(10, 5, 3));
    }
}
