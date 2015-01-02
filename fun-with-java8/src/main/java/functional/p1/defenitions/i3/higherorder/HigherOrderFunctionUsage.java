package functional.p1.defenitions.i3.higherorder;

import functional.p1.defenitions.i1.basic.BasicFunction;
import functional.p1.defenitions.i2.funref.StaticFunction;

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
