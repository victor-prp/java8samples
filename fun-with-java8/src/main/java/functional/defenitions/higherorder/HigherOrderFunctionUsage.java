package functional.defenitions.higherorder;

import functional.defenitions.basic.BasicFunction;
import functional.defenitions.funref.StaticFunction;

/**
 * @author victorp
 */
public class HigherOrderFunctionUsage {

    public static void doItTwice(BasicFunction fun){
        fun.doSomething();
        fun.doSomething();
    }

    public static void main(String... args) {
        BasicFunction basicFun = StaticFunction::pureFun;
        HigherOrderFunction higherOrderFun = HigherOrderFunctionUsage::doItTwice;

        higherOrderFun.doWithSomething(basicFun);
    }

}
