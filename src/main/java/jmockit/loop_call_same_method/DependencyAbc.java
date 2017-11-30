package jmockit.loop_call_same_method;

/**
 * Created by Yonggao.Dong on 16/9/14.
 */
public class DependencyAbc {
    public int intReturningMethod() {
        return 0;
    }

    public String stringReturningMethod() throws SomeCheckedException {
        return null;
    }
}
