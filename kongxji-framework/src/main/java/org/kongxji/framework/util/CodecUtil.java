package org.kongxji.framework.util;

import java.util.UUID;

/**
 * 编码与解码工具类
 * @author lh
 * @since 1.0.0
 */
public class CodecUtil {

    /**
     * 创建32位随机编码
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
