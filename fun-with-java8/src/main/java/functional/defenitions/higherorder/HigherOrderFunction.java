package functional.defenitions.higherorder;

import functional.defenitions.basic.BasicFunction;

/**
 * @author victorp
 */
@FunctionalInterface
public interface HigherOrderFunction {
    void doWithSomething(BasicFunction basicFunction);
}
