package junit.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yonggao.Dong on 15/9/7.
 *
 */
public class Accumulator {

    private List a = new ArrayList();

    public int accumulate(int input) throws NumberOutOfBoundException{
        if(input>10000 || input<0)
            throw new NumberOutOfBoundException("输入参数的范围必须在[0,1000]范围之内");
        int sum=0;
        for(int i=1;i<=input;i++){
            sum+=i;
        }
        return sum;
    }

    public void  doSome(){

        a.add("11");
    }

}