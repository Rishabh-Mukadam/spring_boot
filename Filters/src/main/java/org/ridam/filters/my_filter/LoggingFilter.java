package org.ridam.filters.my_filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request has been received");
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;

        String request_id= UUID.randomUUID().toString();
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        chain.doFilter(request,response);
        httpServletResponse.setHeader("request_id",request_id);

    }
}
