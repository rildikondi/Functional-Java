package return_functions;

import java.util.function.Function;

public class Demo {

    public static class Math {

        public static Integer timesTwo(Integer x) {
            return x * 2;
        }

        public static Integer timesThree(Integer x) {
            return x * 3;
        }

        public static Integer timesFour(Integer x) {
            return x * 4;
        }

        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }


    public static void main(String[] args) {

        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> () -> "Hello Functional";

        NoArgsFunction<String> greeter = createGreeter.apply();

        System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = Math.createMultiplier(2);
        Function<Integer, Integer> timesThree = Math.createMultiplier(3);
        Function<Integer, Integer> timesFour = Math.createMultiplier(4);

        System.out.println(timesTwo.apply(6));
        System.out.println(timesThree.apply(6));
        System.out.println(timesFour.apply(6));
    }
}
