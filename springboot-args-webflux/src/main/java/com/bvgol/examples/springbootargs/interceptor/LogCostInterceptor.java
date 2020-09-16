package com.bvgol.examples.springbootargs.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LogCostInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        Object attribute = httpServletRequest.getSession().getAttribute("");
        //登录拦截
        if (attribute == null) {

            httpServletResponse.reset();
            //设置编码格式
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");

            PrintWriter pw = httpServletResponse.getWriter();
//            pw.write(JsonUtil.objToJson(ServerResponse.createByErrorCodeAndMessage(ResponseCode.NEED_LOGIN.getCode(), "拦截器拦截，请登录")));
            JSONObject json = new JSONObject();
            json.put("code", 10000007L);
            json.put("msg", "拦截器拦截，请登录");
            json.put("success", false);
            pw.write(json.toJSONString());
            System.out.println(json.toJSONString());
            pw.flush();
            pw.close();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}