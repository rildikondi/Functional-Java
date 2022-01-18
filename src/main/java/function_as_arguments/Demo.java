package function_as_arguments;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo {

    private static class Math {

        public static Integer add(Integer x, Integer y) {
            return x + y;
        }

        public static Integer subtract(Integer x, Integer y) {
            return x - y;
        }

        public static Integer combine2and3(BiFunction<Integer, Integer, Integer> combineFunction) {
            return combineFunction.apply(2, 3);
        }

    }

    public static void main(String[] args) {
        System.out.println(Math.combine2and3(Math::add));
        System.out.println(Math.combine2and3(Math::subtract));
        System.out.println(Math.combine2and3((x, y) -> 2 * x + 2 * y));
    }

}


