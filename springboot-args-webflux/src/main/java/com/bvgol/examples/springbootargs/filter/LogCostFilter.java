package com.bvgol.examples.springbootargs.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogCostFilter extends OncePerRequestFilter {




    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Execute cost=" + (System.currentTimeMillis() - start));
//        httpServletResponse.reset();
        //设置编码格式
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setDateHeader("code", 10000007L);
//        httpServletResponse.sendError(1,"xxxxxxxxxxx");
        PrintWriter pw = httpServletResponse.getWriter();
        httpServletResponse.reset();
        pw.write("拦截器拦截，请登录");

        pw.flush();
        pw.close();

    }

    @Override
    public void destroy() {

    }
}