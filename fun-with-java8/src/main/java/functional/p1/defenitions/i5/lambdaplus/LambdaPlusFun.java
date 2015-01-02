package functional.p1.defenitions.i5.lambdaplus;

import java.util.function.BiFunction;

/**
 * @author victorp
 */
public class LambdaPlusFun {

    static public int sum(int r, int l) {return r + l;}
    static public int multiply(int r, int l){return r * l;}

    static public int calculate(int r, int l, BiFunction<Integer,Integer,Integer> fun){
       return fun.apply(r,l);
    }

    public static void main(String... args) {
        calculate(5,2, LambdaPlusFun::sum);
        calculate(5,2, LambdaPlusFun::multiply);

        calculate(5,2, (r,l)-> r-l);
    }
}
