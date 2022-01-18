package partial_application;

import bifunctions.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> add =
                (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                (x) -> (y, z) -> add.apply(x, y, z);


        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        System.out.println(add5.apply(6, 7));


        BiFunction<Integer, Integer, Function<Integer, Integer>> addPartialV2 =
                (x, y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Integer> add6and7 = addPartialV2.apply(6, 7);

        System.out.println(add6and7.apply(5));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartialV3 =
                (x) -> (y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Function<Integer, Integer>> add5V3 = addPartialV3.apply(5);
        Function<Integer, Integer> add5and6 = add5V3.apply(6);

        System.out.println(add5and6.apply(7));


    }
}
