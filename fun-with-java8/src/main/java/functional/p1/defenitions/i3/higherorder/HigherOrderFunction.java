package functional.p1.defenitions.i3.higherorder;

import functional.p1.defenitions.i1.basic.BasicFunction;

/**
 * @author victorp
 */
@FunctionalInterface
public interface HigherOrderFunction {
    void doWithSomething(BasicFunction basicFunction);
}
