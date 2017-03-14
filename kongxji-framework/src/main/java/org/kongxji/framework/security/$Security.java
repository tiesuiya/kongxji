package org.kongxji.framework.security;

import org.kongxji.framework.security.impl.DefaultTokenManger;
import org.kongxji.framework.web.WebContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 安全验证切面，验证token
 *
 * @author lh
 * @since 1.0.0
 */
@Configuration
@Aspect
class $Security {
    private static final Logger logger = LoggerFactory.getLogger($Security.class);

    // TODO init
    private TokenManager tokenManager = new DefaultTokenManger();
    private String tokenName = "X-Token";

    /**
     * 定义拦截规则：拦截所定义包下面的所有类中，有@RequestMapping注解的方法。
     */
//    @Pointcut("execution(* com.ekfans.*.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        // 如果目标方法忽略了安全检查，直接执行
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }

        // 检查当前请求request的header中token
        String token = WebContext.getRequest().getHeader(tokenName);
        // FIXME 目前这种方式不能满足需求
        if (!tokenManager.checkToken(token)) {
            String msg = String.format("token [%s] is invalid", token);
            throw new TokenException(msg);
        }

        return pjp.proceed();
    }
}