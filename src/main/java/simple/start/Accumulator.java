package simple.start;

/**
 * Created by Yonggao.Dong on 15/9/7.
 * 目标：
 * 1，包，类，方法命名
 * 2. 理解测试是一个实例化过程，挑选实例要考虑：等价，边界，边界外
 * 3. 了解期望的异常可以通过 @Test(expected) 表达，不应该通过 catch捕获，
 * 4. 理解UT只需要关注方法内的逻辑；分治的思想。
 *
 */
public class Accumulator {

    public int accumulate(int input) throws NumberOutOfBoundException {
        if (input > 1000 || input < 0)
            throw new NumberOutOfBoundException("输入参数的范围必须在[0,1000]范围之内");
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
        }
        return sum;
    }


    public String accumulate(String input) throws NumberOutOfBoundException {
        final Integer value = Integer.valueOf(input);

        final int accumulate = accumulate(value);

        return  String.valueOf(accumulate);
    }

}