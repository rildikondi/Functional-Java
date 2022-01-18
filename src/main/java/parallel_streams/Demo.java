package parallel_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {


        String[] stringArray = {"hello", "functional", "programming", "is", "cool", "!", "or"};

        List<String> listOfString = new ArrayList<>(Arrays.asList(stringArray));

        List<String> processedWords = listOfString
                .parallelStream()
                .map((word) -> {
                    System.out.println("Uppercasing word: " + word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                            System.out.println("Adding exclamation point to word: " + word);
                            return word + "!";
                        }
                )
                .collect(Collectors.toList());

        System.out.println(processedWords);
    }
}
