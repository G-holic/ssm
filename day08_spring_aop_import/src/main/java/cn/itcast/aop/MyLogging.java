package cn.itcast.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component      //将当前类标识为一个组件
@Aspect         //将当前类标识为【切面类】【非核心业务提取类】
@Order(value = 2) // 定义切面优先级(- - 数值越小，优先级越高【一般建议使用正整数】)

public class MyLogging {
    // 重用切入点表达式
    // 提取可重用的切入点表达式
    @Pointcut("execution(* cn.itcast.aop.CalcImpl.*(..))")
    public void myPointCut(){

    }

    /**
     * 前置通知
     */
//    @Before(value = "execution(public int cn.itcast.aop.CalcImpl.add(int, int))")
//    @Before(value = "execution(* cn.itcast.aop.CalcImpl.*(..))")
//    @Before(value = "myPointCut()")
    public  void beforeMethod(JoinPoint joinPoint){
        // 获取方法名称
        String name = joinPoint.getSignature().getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();

        System.out.println("【前置通知】==>Calc中"+name+"方法（），参数:" + Arrays.toString(args));
    }

    /**
     * 后置通知
     */
//    @After(value = "execution(* cn.itcast.aop.CalcImpl.*(..)))")
//    @After(value = "myPointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

//        System.out.println("==>Calc中"+methodName+"方法（），结果:" + result);
        System.out.println("【后置通知】==>Calc中"+name+"方法之后执行!"+ Arrays.toString(args));
    }

    /**
     * 返回通知
     */
//    @AfterReturning(value = "myPointCut()",returning = "result")
    public void afterReturnning(JoinPoint joinPoint,Object result){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【返回通知】==>Calc中"+methodName+"方法（），返回结果执行！结果：" + result);
    }

    /**
     * 异常通知
     */
//    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【异常通知】==>Calc中"+methodName+"方法（），出现异常时执行！异常：" + e);
    }

    @Around(value = "myPointCut()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){

        // 获取方法名称
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        // 定义返回值
        Object result = null;
        try {
            // 前置通知
            System.out.println("【前置通知】==>Calc中"+methodName+"方法（），参数:" + Arrays.toString(args));
            // 触发目标对象的目标方法【加减乘除方法】
            result = proceedingJoinPoint.proceed();
            // 返回通知【有异常不执行】
            System.out.println("【返回通知】==>Calc中"+methodName+"方法（），返回结果执行！结果：" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
            System.out.println("【异常通知】==>Calc中"+methodName+"方法（），出现异常时执行！异常：" + throwable);
        }finally {
            // 后置通知【有异常执行】
            System.out.println("【后置通知】==>Calc中"+methodName+"方法之后执行!"+ Arrays.toString(args));
        }
        return result;
    }

}
