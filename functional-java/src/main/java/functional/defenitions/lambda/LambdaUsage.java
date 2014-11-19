package functional.defenitions.lambda;

import functional.defenitions.basic.BasicFunction;
import functional.defenitions.higherorder.HigherOrderFunction;

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
