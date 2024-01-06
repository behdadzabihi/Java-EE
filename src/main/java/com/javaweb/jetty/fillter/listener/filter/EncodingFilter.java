package com.javaweb.jetty.fillter.listener.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        String value = filterConfig.getInitParameter("encoding");
        if(value!=null&&value.isEmpty()){
            encoding=value;
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request, servletResponse);
    }

    public void destroy() {

    }
}
