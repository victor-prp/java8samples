package functional.p1.defenitions.i2.funref;

import functional.p1.defenitions.i1.basic.BasicFunction;
/**
 * @author victorp
 */
public class StaticFunUsage {


    public static void main(String... args){
        //function reference
        BasicFunction basicFun = StaticFunction::pureFun;
        basicFun.doSomething();
    }
}
