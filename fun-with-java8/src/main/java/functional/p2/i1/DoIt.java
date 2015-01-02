package functional.p2.i1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author: victorp
 */
public class DoIt {


    private static void doIt2(List<String> words) {
        words.stream().
                map(str -> str.split("")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::print);
    }

    private static void doIt1(List<String> words) {
        StringBuilder  strBuilder = new StringBuilder();
        Set<Character> chartsSet = new HashSet<>();
        for (String word: words){
            for (char singleChar : word.toCharArray())  {
                if (!chartsSet.contains(singleChar)){
                    strBuilder.append(singleChar);
                    chartsSet.add(singleChar);
                }
            }
        }
        System.out.print(strBuilder.toString());
    }


}