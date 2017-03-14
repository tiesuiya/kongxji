package org.kongxji.framework.util;

import java.io.File;
import java.io.IOException;

/**
 * 文件帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public class FileUtil {
    /**
     * 检查文件路径，没有则生成
     *
     * @param path 路径
     */
    public static void createFilePath(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
