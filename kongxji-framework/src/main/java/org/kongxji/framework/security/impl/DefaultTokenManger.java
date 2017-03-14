package org.kongxji.framework.security.impl;

import org.kongxji.framework.security.TokenManager;
import org.kongxji.framework.util.CodecUtil;
import org.kongxji.framework.util.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认秘钥管理
 *
 * @author lh
 * @since 1.0.0
 */
public class DefaultTokenManger implements TokenManager {
    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, username);
        return token;
    }

    public boolean checkToken(String token) {
        return StringUtil.isNotEmpty(token) && tokenMap.containsKey(token);
    }
}
