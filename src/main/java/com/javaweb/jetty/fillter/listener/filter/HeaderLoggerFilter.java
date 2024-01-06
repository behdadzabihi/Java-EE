package com.javaweb.jetty.fillter.listener.filter;

import com.nikamooz.javaweb.session5.utility.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "HeaderLoggerFilter", urlPatterns = "/*")
public class HeaderLoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Utils.logHeaders(request);
        filterChain.doFilter(request, servletResponse);
    }
}
