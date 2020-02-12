package com.zhoudy.springboot.usermanage.annotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Configuration
@Slf4j
public class ExecuteTimeAspect {

    @Pointcut("@annotation(com.zhoudy.springboot.usermanage.annotation.ExecuteTime)")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("@Before通知执行");
        //获取目标方法参数信息
        Object[] args = joinPoint.getArgs();
        //aop代理对象
        Object aThis = joinPoint.getThis();
        log.info(aThis.toString());
        //被代理对象
        Object target = joinPoint.getTarget();
        log.info(target.toString());
        //获取连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
        log.info(signature.toLongString());
        log.info(signature.toShortString());
        log.info(signature.toString());
        //获取方法名
        log.info(signature.getName());
        //获取声明类型名
        log.info(signature.getDeclaringTypeName());
        //获取声明类型  方法所在类的class对象
        log.info(signature.getDeclaringType().toString());
        //和getDeclaringTypeName()一样
        log.info(signature.getDeclaringType().getName());
        //连接点类型
        String kind = joinPoint.getKind();
        log.info(kind);
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        log.info(sourceLocation.toString());
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        log.info(staticPart.toLongString());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info(request.getRequestURL().toString());
        log.info(request.getRemoteAddr());
        log.info(request.getMethod());
        log.info("before通知执行结束");
    }


    /**
     * 后置返回
     *      如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     *      如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     *            参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){
        log.info("第一个后置返回通知的返回值："+result);
    }

    @AfterReturning(value = "pointCut()",returning = "result",argNames = "result")
    public void doAfterReturningAdvice2(String result){
        log.info("第二个后置返回通知的返回值："+result);
    }


    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     *            对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception){
        log.info(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            log.info("发生了空指针异常!!!!!");
        }
    }

    @After(value = "pointCut()")
    public void doAfterAdvice(JoinPoint joinPoint){
        log.info("后置通知执行了!");
    }
    

    @Around(value = "pointCut()")
    public void doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        long startTime=System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate=new Date(startTime);
        log.info("开始执行:"+sdf.format(startDate));;
        try {
            Object proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime= System.currentTimeMillis();
        Date endDate=new Date(startTime);
        log.info("结束时间:"+sdf.format(endDate)+",用时"+(endTime-startTime)/1000+"秒");;
    }
}
