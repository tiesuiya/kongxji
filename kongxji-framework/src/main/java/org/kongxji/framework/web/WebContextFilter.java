package org.kongxji.framework.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 容器上下文过滤器
 *
 * @author lh
 * @since 1.0.0
 */
@WebFilter(filterName = "webContextFilter", urlPatterns = "/*")
public class WebContextFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return;
        }

        WebContext.init(request, response);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            WebContext.destroy();
        }
    }

    public void destroy() {

    }
}
