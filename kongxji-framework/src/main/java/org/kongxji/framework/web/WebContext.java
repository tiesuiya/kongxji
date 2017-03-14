package org.kongxji.framework.web;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 容器上下文
 * @author lh
 * @since 1.0.0
 */
public class WebContext {
    private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();

    /**
     * 初始化当前request
     */
    static void init(HttpServletRequest request, HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    /**
     * 销毁当前request
     */
    static void destroy() {
        requestHolder.remove();
        responseHolder.remove();
    }

    /**
     * 得到容器当前request
     */
    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    /**
     * 得到容器当前response
     */
    public static HttpServletResponse getResponse() {
        return responseHolder.get();
    }
}
