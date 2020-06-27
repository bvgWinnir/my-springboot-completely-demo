package com.bvgol.examples.commonExecption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guochen
 * @Title: Application
 * @Package
 * @Description:
 * @date 2020/6/2720:52
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * @ControllerAdvice 就是 @Controller 的增强版。
     * @ControllerAdvice 主要用来处理全局数据，一般搭配 @ExceptionHandler、@ModelAttribute、@InitBinder 使用
     *
     *CustomExceptionHandler 类上面添加了 @ControllerAdvice 注解。当系统启动时，该类就会被扫描到 Spring 容器中。
     * uploadException 方法上面添加了 @ExceptionHandler 注解，
     *  其中定义的 MaxUploadSizeExceededException.class 表明该方法用来处理 MaxUploadSizeExceededException 类型的异常。
     *  如果想让该方法处理所有类型的异常，只需要将 MaxUploadSizeExceededException 改成 Exception 即可。
     * 异常处理方法的参数可以有异常实例、HttpServletResponse 以及 HttpServletRequest、Model 等。
     *  异常处理方法的返回值可以是一段 JSON、一个 ModelAndView、一个逻辑视图名等。
     *
     * */
}
