package org.ridam.filters.my_filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class ResponseHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Adding requestId to the response header");

        chain.doFilter(request,response);

        String requestId= UUID.randomUUID().toString();
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        httpServletResponse.setHeader("request_id",requestId);


    }
}
