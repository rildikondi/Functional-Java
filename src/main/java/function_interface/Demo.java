package function_interface;

import java.util.function.Function;

public class Demo {

    protected static class Math {

        public static Integer triple(Integer x) {
            return x * 3;
        }

    }

    public static void main(String[] args) {

        Function<Integer, Integer> myTriple = Math::triple;
        System.out.println(myTriple.apply(5));

        Function<Integer, Integer> lambdaf = (x) -> x < 0 ? -x : x;

        lambdaf.apply(5);

    }
}
