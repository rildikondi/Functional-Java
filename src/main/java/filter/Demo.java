package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = listOfIntegers
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evens);


        String[] stringArray = {"hello", "functional", "programming", "is", "cool", "!"};

        List<String> listOfString = new ArrayList<>(Arrays.asList(stringArray));

        Predicate<String> isLongerThan5 = (str) -> str.length() > 5;


        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {

            return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan6 = createLengthTest.apply(6);


        List<String> longWords = listOfString
                .stream()
                .filter(isLongerThan5)
                .filter(isLongerThan6)
                .collect(Collectors.toList());

        System.out.println(longWords);
    }
}
