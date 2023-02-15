package cn.itcast.beforeaop;

import java.util.Arrays;

public class MyLogging {

    /**
     * 方法之前
     */
    public static void beforeMethod(String methodName,Object[] args){
        System.out.println("==>Calc中"+methodName+"方法（），参数:" + Arrays.toString(args));
    }

    /**
     * 方法之后
     */
    public static void afterMethod(String methodName,Object result){
        System.out.println("==>Calc中"+methodName+"方法（），结果:" + result);
    }
}
