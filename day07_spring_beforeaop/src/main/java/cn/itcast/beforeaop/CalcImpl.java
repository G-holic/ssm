package cn.itcast.beforeaop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {
    @Override
    public int add(int a, int b) {
//        System.out.println("==>Calc中的add方法（），参数:" + a + "," + b);

//        MyLogging.beforeMethod("add",new Object[]{a,b});
        int result = a + b;
        System.out.println("add正在计算中。。。。");
//        MyLogging.afterMethod("add",result);

//        System.out.println("==>Calc中的add方法（），结果:" + result);

        return result;
    }

    @Override
    public int sub(int a, int b) {
//        System.out.println("==>Calc中的sub方法（），参数:" + a + "," + b);


        int result = a - b;

//        System.out.println("==>Calc中的sub方法（），结果:" + result);

        return result;
    }

    @Override
    public int mul(int a, int b) {

        int result = a * b;


        return result;
    }

    @Override
    public int div(int a, int b) {

        int result = a / b;
        System.out.println("add正在计算中。。。。");

        return result;
    }
}
