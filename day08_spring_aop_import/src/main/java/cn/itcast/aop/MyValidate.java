package cn.itcast.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component  //将当前类标识为一个组件
@Aspect     //将当前类标识为【切面类】【非核心业务提取类】
@Order(value = 1)  // 定义切面优先级(- - 数值越小，优先级越高【一般建议使用正整数】)
public class MyValidate {

    /**
     * 添加数据验证功能
     */
    @Before(value = "cn.itcast.aop.MyLogging.myPointCut()")

    public void methodBefore(JoinPoint joinPoint){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【前置通知】~~~~=====>数据验证切面~~~~~");

    }
}
