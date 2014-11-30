package functional.lessmystery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;


/**
 * @author: Victor
 */
public class Java8Mystery {
    public static Map<String,Integer> itDoesSomething(List<String> elements ){
       Map<String,Integer> results = new HashMap<>();
       elements.stream()
               .collect(groupingBy(identity()))
               .forEach((e, elementsInGroup) ->
                       results.put(e, elementsInGroup.size()));
        return results;
    }


    public static void main(String... args) {
        System.out.println(itDoesSomething(Arrays.asList("java", "devoxx", "java one", "java")));
    }
}
