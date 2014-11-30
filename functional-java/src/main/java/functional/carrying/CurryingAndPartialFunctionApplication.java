package functional.carrying;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static java.lang.System.*;

/**
 * @author victorp
 */
public class CurryingAndPartialFunctionApplication {


    public static void main(String[] args)
    {
        IntBinaryOperator simpleAdd = (a, b) -> a + b;
        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;

        // Demonstrating simple add:
        out.println(simpleAdd.applyAsInt(4, 5));

        // Demonstrating curried add:
        out.println(curriedAdd.apply(4).applyAsInt(5));

        // Curried version lets you perform partial application:
        IntUnaryOperator adder5 = curriedAdd.apply(5);
        out.println(adder5.applyAsInt(4));
        out.println(adder5.applyAsInt(6));
    }
}
