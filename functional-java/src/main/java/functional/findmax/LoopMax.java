package functional.findmax;


import functional.Util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;


/**
 * @author victorp
 */
public class LoopMax {

    static public Function<Collection<Integer>,Integer> max = numbers ->{
        int result = Integer.MIN_VALUE;
        for (Integer number:numbers){
            if (number > result){
                result = number;
            }
        }
        return result;
    };

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(2,66,4,5,99,0,-22);
        Util.println("max is: %s",max.apply(numbers));
    }

}
