package functional.lessmystery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Victor
 */
public class Mystery {
    public static HashMap<String,Integer> itDoesSomething(List<String> elements ){
        HashMap<String,Integer> results = new HashMap<>();
        for (String element: elements){
            Integer count = results.get(element);
            if (count != null){
                results.put(element,count+1);
            } else {
                results.put(element,1);
            }
        }
        return results;
    }


    public static void main(String... args) {
         System.out.println(itDoesSomething(Arrays.asList("java", "devoxx", "java one", "java")));
    }
}
