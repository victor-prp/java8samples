package functional.p1.defenitions.i4.lambda;

import functional.p1.defenitions.i1.basic.BasicFunction;
import functional.p1.defenitions.i3.higherorder.HigherOrderFunction;

/**
 * @author victorp
 */
public class LambdaUsage {

    public static void main(String... args) {

        BasicFunction basicFun = ()-> System.out.println("lambda works");

        HigherOrderFunction higherOrderFun = (fun)-> {
            fun.doSomething();
            fun.doSomething();
        };
        higherOrderFun.doWithSomething(basicFun);
    }

}
