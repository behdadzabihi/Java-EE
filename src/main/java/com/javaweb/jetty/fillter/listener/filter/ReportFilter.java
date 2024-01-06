package com.javaweb.jetty.fillter.listener.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ReportFilter", urlPatterns = "/*")
public class ReportFilter implements Filter {
    ServletContext servletContext;

    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Integer counter = (Integer) servletContext.getAttribute(req.getRequestURI().toString());
        if(counter==null){
            counter=1;
        }else{
            counter++;
        }

//        if(){
//            HttpServletResponse resp = (HttpServletResponse) response;
//            resp.getWriter().print("Access Denied.");
//        }else {
            servletContext.setAttribute(req.getRequestURI().toString(), counter);
            chain.doFilter(request, response);
//        }
    }

    public void destroy() {

    }
}
