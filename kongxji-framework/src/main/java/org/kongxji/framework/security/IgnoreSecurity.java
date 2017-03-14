package org.kongxji.framework.security;

import java.lang.annotation.*;

/**
 * 忽略安全验证
 *
 * @author lh
 * @since 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
