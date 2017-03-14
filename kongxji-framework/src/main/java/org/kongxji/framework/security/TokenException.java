package org.kongxji.framework.security;

/**
 * 令牌异常
 * @author lh
 * @since 1.0.0
 */
public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
}
