package org.ridam.filters.my_filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.UUID;

@Component
@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long startTime=System.currentTimeMillis();
        System.out.println("request has been received for logging filter (leevel1)");

        chain.doFilter(request,response);

        long duration=System.currentTimeMillis()-startTime;

        System.out.println("Total time required: "+ duration);

    }
}
