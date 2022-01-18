package closure;

import return_functions.NoArgsFunction;

public class Demo {

    public static void main(String[] args) {

        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> {
            String name = "Ben";
            return () -> "Hello, " + name;
        };

        NoArgsFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
