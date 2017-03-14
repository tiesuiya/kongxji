package org.kongxji.framework.security;

/**
 * 令牌管理
 * @author lh
 * @since 1.0.0
 */
public interface TokenManager {

    String createToken(String username);

    boolean checkToken(String token);
}
