package com.bvgol.examples.myAnnotation.aspect;

import com.bvgol.examples.myAnnotation.ann.ApiOperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspect {
    /**
     * 此处的切点是注解的方式(注解类路径)，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.diku.provider.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.bvgol.examples.myAnnotation.ann.ApiOperateLog)")
    public void execute() {
    }

    /**
     * 后置返回通知
     * 处理完请求，返回内容
     */
    @AfterReturning(returning = "result", value = "execute()")
    public void afterReturning(JoinPoint point, Object result) throws Throwable {
        Object[] args = point.getArgs();        //得到注解对象
        ApiOperateLog annotation = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(ApiOperateLog.class);
        String name = annotation.logName();
        String type = annotation.logType();
        String logModule = annotation.logModule();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(new Date());        //获取方法返回值
        log.info(" @AfterReturning:{}", result);
        saveLog(name, type, logModule, args, createTime);
    }

    private void saveLog(String name, String type, String logModule, Object[] args, String createTime) {
        //保存相关日志操作,调用kafka(其他消息中间件),通知Es保存相关日志记录
        log.info("{}->类型:{}->模块:{}->参数:{}->创建时间:{}", name, type, logModule, Arrays.toString(args), createTime);
    }

    /**
     * 前置通知
     */
    @Before("execute()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        log.info("测试@Before.....");
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("execute()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("测试@AfterThrowing.....");
    }

    /**
     * 后置通知
     */
    @After("execute()")
    public void after(JoinPoint joinPoint) {
        log.info("测试@After.....");
    }

    /**
     * 环绕通知
     */
    @Around("execute()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        log.info("进入环绕通知");
        long start = System.currentTimeMillis();
        Object proceed = point.proceed(point.getArgs());
        log.info("环绕通知.....统计方法执行的时间为：{}ms", String.valueOf(System.currentTimeMillis() - start));
        log.info("退出环绕通知");
        return proceed;
    }
}
