package jmockit.loop_call_same_method;

/**
 * Created by Yonggao.Dong on 16/9/14.
 * 目的：为了示例连续 mock 同一方法
 */
public class Sut {

    private final DependencyAbc abc = new DependencyAbc();

    public String doSomething() {
        int n = abc.intReturningMethod();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++) {

            try {
                s.append(abc.stringReturningMethod());
            } catch (SomeCheckedException e) {
                return s + "exception";
            }

        }
        return s.toString();
    }
}
