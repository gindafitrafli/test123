package com.project.clientfacing.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Log4j2
public class Filter extends GenericFilterBean {

    //currently this class is made only for debugging purpose(to verify the postman request and docker compose network configuration)
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
