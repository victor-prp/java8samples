package functional.p1.defenitions.i1.basic;

/**
 * @author victorp
 */
public class BasicFunctionUsage {

    public static void main(String... args){
        BasicFunction fun = new BasicFunction() {
            @Override
            public void doSomething() {
                System.out.println("do it");
            }
        };
        fun.doSomething();
    }
}
