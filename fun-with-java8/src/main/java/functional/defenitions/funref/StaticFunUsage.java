package functional.defenitions.funref;

import functional.defenitions.basic.BasicFunction;
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
