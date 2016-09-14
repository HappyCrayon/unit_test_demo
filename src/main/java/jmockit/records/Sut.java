package jmockit.records;

/**
 * Created by Yonggao.Dong on 16/9/14.
 */
public class Sut {

    private final DependencyAbc abc = new DependencyAbc();

    public String doSomething() {
        int n = abc.intReturningMethod();
        String s = "";

        for (int i = 0; i < n; i++) {

            try {
                s += abc.stringReturningMethod();
            } catch (SomeCheckedException e) {
                return s + "exception";
            }

        }
        return s;
    }
}
