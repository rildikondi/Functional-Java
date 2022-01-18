package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        String[] stringArray = {"hello", "functional", "programming", "is", "cool", "!", "or"};

        List<String> listOfString = new ArrayList<>(Arrays.asList(stringArray));

        Map<Integer, List<String>> wordLengthsMap = listOfString
                .stream()
                .collect(Collectors.groupingBy(
                        (word) -> word.length()
                ));
        System.out.println(wordLengthsMap);

        Map<Boolean, List<String>> wordLengthsMap2 = listOfString
                .stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 5
                ));
        System.out.println(wordLengthsMap2);
    }
}
