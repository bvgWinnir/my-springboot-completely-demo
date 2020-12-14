//package com.bvgol.examples.myAnnotation;
//
//import lombok.extern.log4j.Log4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.ValidationException;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
//
// * Facade的切面处理类，统一统计进行参数校验及异常捕获
//
// * @author Hollis
//
// */
//
//@Aspect
//
//@Component
//@Log4j
//public class FacadeAspect {
//
//
//    @Autowired
//
//    HttpServletRequest request;
//
//    @Around("@annotation(com.hollis.annotation.Facade)")
//
//    public Object facade(ProceedingJoinPoint pjp) throws Exception {
//
//        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
//
//        Object[] args = pjp.getArgs();
//
//        Class returnType = ((MethodSignature)pjp.getSignature()).getMethod().getReturnType();
//
//        //循环遍历所有参数，进行参数校验
//
//        for (Object parameter : args) {
//
//            try {
//
//                BeanValidator.validateObject(parameter);
//
//            } catch (ValidationException e) {
//
//                return getFailedResponse(returnType, e);
//
//            }
//
//        }
//
//        try {
//
//            // 目标方法执行
//
//            Object response = pjp.proceed();
//
//            return response;
//
//        } catch (Throwable throwable) {
//
//            return getFailedResponse(returnType, throwable);
//
//        }
//
//    }
//
//    /**
//
//     * 定义并返回一个通用的失败响应
//
//     */
//
//    private Object getFailedResponse(Class returnType, Throwable throwable)
//
//        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//
//        //如果返回值的类型为BaseResponse 的子类，则创建一个通用的失败响应
//
//        if (returnType.getDeclaredConstructor().newInstance() instanceof BaseResponse) {
//
//            BaseResponse response = (BaseResponse)returnType.getDeclaredConstructor().newInstance();
//
//            response.setSuccess(false);
//
//            response.setResponseMessage(throwable.toString());
//
//            response.setResponseCode(GlobalConstant.BIZ_ERROR);
//
//            return response;
//
//        }
//
//
////        log.error(
////
////            "failed to getFailedResponse , returnType (" + returnType + ") is not instanceof BaseResponse");
//
//        return null;
//
//    }
//
//}
