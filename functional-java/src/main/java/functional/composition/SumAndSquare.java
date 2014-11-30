package functional.composition;

import functional.Util;
import functional.defenitions.basic.BasicFunction;
import functional.defenitions.higherorder.HigherOrderFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author victorp
 */
public class SumAndSquare {
    static final BiFunction<Integer,Integer,Integer> sum = (x,y)->x+y;
    static final Function<Integer,Integer> square = (x)->x*x;

    public static void main(String... args) {
        //Normal 'sum' fun
        Util.println("2 + 3 = %s", sum.apply(2, 3));

        //Composition 'square(sum(x,y))'
        BiFunction<Integer,Integer,Integer> composed = sum.andThen(square);
        Util.println("square(2 + 3) = %s",composed.apply(2, 3));
    }


}
